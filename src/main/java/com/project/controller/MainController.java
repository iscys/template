package com.project.controller;

import com.project.common.fileupload.FtpUpload;
import com.project.common.model.FileModel;
import com.project.model.UserModel;
import com.project.service.MainService;
import com.project.utils.CommonUtils;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.support.DefaultMultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import java.io.InputStream;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

@Controller
@RequestMapping("/main")
public class MainController {

    @Autowired
    MainService mainService;
    @Autowired
    private CommonUtils commonUtils;


    @RequestMapping(value={"test","iscys"},params = {"one"})
    @ResponseBody
    public String test(){
        return commonUtils.getName();
    }

   @RequestMapping("index")
    public ModelAndView index(HttpServletRequest req)throws Exception{
        System.out.println(mainService);
       ModelAndView mv =new ModelAndView();
       mainService.updateData();
       mv.setViewName("upload");
       return mv;
   }

    @RequestMapping("upload")
    public void upload(MultipartFile file, HttpServletRequest req)throws Exception{
        /**
        DefaultMultipartHttpServletRequest request=(DefaultMultipartHttpServletRequest)req;
        Iterator<String> fileNames = request.getFileNames();
        MultiValueMap<String, MultipartFile> multiFileMap = request.getMultiFileMap();
        MultipartFile file1 = multiFileMap.getFirst("file");
        InputStream fileStream = file.getInputStream();
        String filename = file.getOriginalFilename();
        String suff =filename.substring(filename.lastIndexOf(".")+1);
        FileModel fileModel = FtpUpload.getInstance().uploadFile(fileStream, suff, null);
        System.out.println(fileModel);


        //--------传统fileupload 文件上传-----------//

        DiskFileItemFactory fileItemFactory=new DiskFileItemFactory();
        ServletFileUpload fileUpload =new ServletFileUpload(fileItemFactory);
        List<FileItem> fileItems = fileUpload.parseRequest(req);
        FileItem fileItem = fileItems.get(0);
        String fieldName = fileItem.getFieldName();
        System.out.println(fieldName);
        long size = fileItem.getSize();
         **/
    }

    public static void main(String[] args) throws Exception {


        String s =new String("hello");
        updateStr(s);
        System.out.println(s);
    }

    private static void updateStr(String s) {
            s="world";
    }

}
