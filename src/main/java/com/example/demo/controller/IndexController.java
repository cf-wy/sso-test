package com.example.demo.controller;

import net.unicon.cas.client.configuration.EnableCasClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@EnableCasClient
public class IndexController {

    @GetMapping({"/index","/"})
    public String index(){
        return "index";
    }

    @GetMapping("/s/hello")
    @ResponseBody
    public String  hello(){
        return "hello";
    }
}
