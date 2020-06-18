package com.sjiag.Control;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {

    @RequestMapping("/login.html")
    public String login(){
            return "login";
    }
    @RequestMapping("/")
    public String login1(){
            return "login";
    }
    @RequestMapping("/index1.html")
    public String index2(){
            return "index1";
    }
    @RequestMapping("/regist.html")
    public String regist(){
        return "regist";
    }
    @RequestMapping("/index.html")
    public String index(){
        return "index";
    }
    @RequestMapping("/index1")
    public String index1(){
        return "index1";
    }
    @RequestMapping("tea/totap")
    public String Person(){
        return "page/tap";
    }
}
