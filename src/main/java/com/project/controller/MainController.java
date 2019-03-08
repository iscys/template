package com.project.controller;

import com.project.common.fileupload.FtpUpload;
import com.project.common.model.FileModel;
import com.project.model.UserModel;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.InputStream;

@Controller
@RequestMapping("/main")
public class MainController {


   @RequestMapping("index")
    public ModelAndView index(HttpServletRequest req)throws Exception{
       ModelAndView mv =new ModelAndView();
       mv.setViewName("upload");
       return mv;
   }

    @RequestMapping("upload")
    public void upload(MultipartFile file, HttpServletRequest req)throws Exception{
        InputStream fileStream = file.getInputStream();
        String filename = file.getOriginalFilename();
        String suff =filename.substring(filename.lastIndexOf(".")+1);
        FileModel fileModel = FtpUpload.getInstance().uploadFile(fileStream, suff, null);
        System.out.println(fileModel);

    }


    public static void main(String[] args) throws Exception {
       // FileInputStream inputStream =new FileInputStream("/Users/iscys/Desktop/12.jpg");
       // FtpUpload.getInstance().uploadFile(inputStream,"jpg",null);
        FTPClient ftp =new FTPClient();
        ftp.connect("47.95.245.138",21);
        ftp.login("107417","107417");
        int reply = ftp.getReplyCode();
        if (!FTPReply.isPositiveCompletion(reply)) {
            System.err.println("FTP服务器拒绝连接 ");
            ftp.disconnect();
        }
        System.out.println(ftp.printWorkingDirectory());
        FtpUpload.changeWorkingDir(ftp,"is/io/op/");
        System.out.println(ftp.printWorkingDirectory());
    }
}
