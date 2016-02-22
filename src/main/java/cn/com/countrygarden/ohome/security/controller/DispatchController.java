package cn.com.countrygarden.ohome.security.controller;

import cn.com.countrygarden.ohome.security.interceptors.CommonParamsInterceptor;
import cn.com.countrygarden.ohome.security.interceptors.InvalidTimestampInterceptor;
import com.jfinal.aop.Before;
import com.jfinal.core.Controller;

/**
 * 接口入口分发
 * Created by xiaobai on 16/2/21.
 */
public class DispatchController extends Controller{

    /**
     * 分发
     */
    @Before({CommonParamsInterceptor.class, InvalidTimestampInterceptor.class})
    public void index(){
        renderText("dispatch");
    }
}
