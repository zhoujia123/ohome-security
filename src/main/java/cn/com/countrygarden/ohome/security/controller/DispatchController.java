package cn.com.countrygarden.ohome.security.controller;

import com.jfinal.core.Controller;

/**
 * 接口入口分发
 * Created by xiaobai on 16/2/21.
 */
public class DispatchController extends Controller{

    /**
     * 分发
     */
    public void index(){
        renderText("dispatch");
    }
}
