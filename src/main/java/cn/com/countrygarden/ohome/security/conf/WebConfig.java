package cn.com.countrygarden.ohome.security.conf;

import cn.com.countrygarden.ohome.security.controller.DispatchController;
import cn.com.countrygarden.ohome.security.controller.IndexController;
import cn.com.countrygarden.ohome.security.handlers.CommonParamsHandler;
import com.jfinal.config.*;
import com.jfinal.core.JFinal;

/**
 * Created by xiaobai on 16/2/21.
 */
public class WebConfig extends JFinalConfig {

    @Override
    public void configConstant(Constants me) {
        me.setDevMode(true);
    }

    @Override
    public void configRoute(Routes me) {

        me.add("/", IndexController.class,"/index");
        me.add("/dispatch", DispatchController.class);
    }

    @Override
    public void configPlugin(Plugins me) {

    }

    @Override
    public void configInterceptor(Interceptors me) {

    }

    @Override
    public void configHandler(Handlers me) {
        me.add(new CommonParamsHandler());
    }

    public static void main(String[] args) {
//        JFinal.start("web", 8088, "/", 5);
    }
}
