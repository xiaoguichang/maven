package com.xiaogch.maven.springmvc.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Administrator on 2017/6/27 0027.
 */
@Controller
@RequestMapping("/home")
public class HomeController {

    @RequestMapping(value = "index.do", method = RequestMethod.POST)
    public String index() {
        return "home/index";
    }

}
