package com.yzy.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ClassName HelloController
 * @Description TODO
 * @Author yzy 729141789@qq.com
 * @Date 2022-03-28 15:34
 * @Version
 **/
@Controller
public class HelloController {

    //“/”-->/WEB-INF/templates/index.html

    @RequestMapping(value = "/")
    public String index() {
        //返回视图名称
        return "index";
    }

    @RequestMapping("/target")
    public String toTarget() {
        return "target";
    }
}
