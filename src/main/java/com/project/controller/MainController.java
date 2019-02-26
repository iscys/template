package com.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/main")
public class MainController {


   @RequestMapping("index")
    public void vi(){
       System.out.println(1/0);
   }
}
