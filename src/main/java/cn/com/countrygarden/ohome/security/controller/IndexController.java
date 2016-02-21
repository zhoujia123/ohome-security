package cn.com.countrygarden.ohome.security.controller;

import com.jfinal.core.Controller;

/**
 * Created by xiaobai on 16/2/21.
 */
public class IndexController extends Controller {

    public void index(){
        renderText("hello");
    }

}
