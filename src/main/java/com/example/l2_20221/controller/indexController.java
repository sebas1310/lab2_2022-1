package com.example.l2_20221.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class indexController {
    @GetMapping(value = "/indexDevelop")
    public String index(){
        return "index";
    }
}
