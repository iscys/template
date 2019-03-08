package com.project.controller;

import com.project.common.fileupload.FtpUpload;
import com.project.config.SessionAttribute;
import com.project.model.UserModel;
import org.apache.commons.io.FileUtils;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;
import org.springframework.stereotype.Controller;
import org.springframework.util.AlternativeJdkIdGenerator;
import org.springframework.util.IdGenerator;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.UUID;

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
    public void addSession( @RequestHeader("Accept") String head, @CookieValue("NAME") String NAME, @ModelAttribute UserModel userModel, HttpServletRequest req)throws Exception{
      req.getSession().setAttribute("user",userModel);
    }


    public static void main(String[] args) throws Exception {
        FileInputStream inputStream =new FileInputStream("C:/Users/cys/Desktop/www.jpg");
        FtpUpload.getInstance().uploadFile(inputStream,"jpg",null);

    }
}
