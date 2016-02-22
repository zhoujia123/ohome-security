package cn.com.countrygarden.ohome.security.interceptors;

import com.jfinal.aop.Interceptor;
import com.jfinal.aop.Invocation;
import com.jfinal.core.Const;
import com.jfinal.kit.Prop;
import com.jfinal.kit.PropKit;

/**
 * timestamp时间戳是否超过系统间隔(默认10分钟)
 * Created by zhoujia05 on 2016/2/22.
 */
public class InvalidTimestampInterceptor implements Interceptor{

    //时间间隔
    private final Long interval;

    public InvalidTimestampInterceptor() {
        Prop prop = PropKit.use("application.properties", Const.DEFAULT_ENCODING);
        this.interval = prop.getLong("interval", 10L) * 60 * 1000L;
    }

    @Override
    public void intercept(Invocation inv) {
        Long timestamp = inv.getController().getParaToLong("timestamp");
        //超过时间间隔
        if(System.currentTimeMillis() - timestamp > this.interval){
            inv.getController().renderError(404);
        }
        inv.invoke();
    }
}
