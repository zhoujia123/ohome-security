package cn.com.countrygarden.ohome.security.handlers;

import cn.com.countrygarden.ohome.security.util.ParamsResolve;
import com.jfinal.aop.Interceptor;
import com.jfinal.aop.Invocation;
import com.jfinal.handler.Handler;
import com.jfinal.kit.HandlerKit;
import com.jfinal.kit.JsonKit;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * 是否包含公共参数
 * Created by xiaobai on 16/2/21.
 */
public class CommonParamsHandler extends Handler {

    private final String url = "/dispatch";

    @Override
    public void handle(String target, HttpServletRequest request, HttpServletResponse response, boolean[] isHandled) {
        Map<String, String[]> parameterMap = request.getParameterMap();
        //如果不包含则返回错误
        if(url.equals(target) && !ParamsResolve.mapIsContainCommonParams(parameterMap)){
            System.out.println("target:" + target);
            HandlerKit.renderError404(request,response,isHandled);
//            JsonKit.toJson();
        }
        next.handle(target, request, response, isHandled);
    }
}
