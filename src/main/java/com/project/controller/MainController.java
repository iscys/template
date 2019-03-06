package com.project.controller;

import com.project.config.SessionAttribute;
import com.project.model.UserModel;
import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileOutputStream;

@Controller
@RequestMapping("/main")
public class MainController {


   @RequestMapping("index")
    public ModelAndView index(String name, @SessionAttribute("user")UserModel userModel, HttpServletRequest req)throws Exception{
       ModelAndView mv =new ModelAndView();
       System.out.println("11111111111111");
       mv.setViewName("me");
       return mv;
   }

    @RequestMapping("addSession")
    public void addSession(UserModel userModel, HttpServletRequest req)throws Exception{
      req.getSession().setAttribute("user",userModel);
    }
}
