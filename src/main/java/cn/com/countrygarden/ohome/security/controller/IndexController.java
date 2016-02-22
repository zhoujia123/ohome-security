package cn.com.countrygarden.ohome.security.controller;

import com.jfinal.core.ActionKey;
import com.jfinal.core.Controller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by xiaobai on 16/2/21.
 */
public class IndexController extends Controller {

    private final static Logger log = LoggerFactory.getLogger(IndexController.class);

    public void index(){
        String para = getPara(0);
        String para1 = getPara(1);
        System.out.println(para+";"+para1);
        log.info(para+";"+para1);
        renderText("hello");
    }

    public void say(){
        renderText("say");
    }

}
