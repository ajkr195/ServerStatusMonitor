package com.servermonitor.tool.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MyWebController {

	@GetMapping(value="/")
    public String homepage(){
        return "index";
    }
}