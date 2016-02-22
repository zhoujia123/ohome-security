package cn.com.countrygarden.ohome.security.interceptors;

import cn.com.countrygarden.ohome.security.util.ParamsResolve;
import com.jfinal.aop.Interceptor;
import com.jfinal.aop.Invocation;
import com.jfinal.kit.HandlerKit;

import java.util.Map;

/**
 * 是否包含公共参数
 * Created by zhoujia05 on 2016/2/22.
 */
public class CommonParamsInterceptor implements Interceptor {

    @Override
    public void intercept(Invocation inv) {
        Map<String, String[]> paraMap = inv.getController().getParaMap();
        //如果不包含则返回错误
        if(!ParamsResolve.mapIsContainCommonParams(ParamsResolve.convertMaps(paraMap))){
            System.out.println("不包含公共参数");
            inv.getController().renderError(404);
//            JsonKit.toJson();
        }
        inv.invoke();
    }
}
