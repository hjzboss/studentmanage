package com.hjznb.student.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String first(){
        return "redirect:/dist/index.html";
    }
}
