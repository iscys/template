package com.project.common.fileupload;


import com.project.common.model.FileModel;
import com.project.common.tool.IdGenerator;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;
import org.springframework.util.Assert;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Ftp 文件上传
 */
public class FtpUpload {
    private Properties config;
    private String username;
    private String password;
    private String host;
    private Integer port;
    private String url;
    private String basePath;

    /**
     * 单例模式模式
     */
    public static FtpUpload getInstance() {

        return Instance.getInstance();
    }

    private static class Instance {
        private static FtpUpload ftp = new FtpUpload();

        public static FtpUpload getInstance() {
            return ftp;
        }

    }

    public FtpUpload() {
        try {
            ClassLoader loader = FtpUpload.class.getClassLoader();
            InputStream ftpConfig = loader.getResourceAsStream("ftp.properties");
            if (config == null) {
                config = new Properties();
                config.load(ftpConfig);
            }
            String username = config.getProperty("ftp.user");
            Assert.notNull(username, "ftp登陆账号不能为空");
            String password = config.getProperty("ftp.password");
            Assert.notNull(password, "ftp登陆密码不能为空");
            String ip = config.getProperty("ftp.ip");
            Assert.notNull(ip, "ftp连接ip不能为空");
            String port = config.getProperty("ftp.port");
            Assert.notNull(port, "ftp登连接端口不能为空");
            String url = config.getProperty("ftp.url");
            Assert.notNull(url, "url 不能为空");
            String basePath = config.getProperty("ftp.basePath");
            Assert.notNull(basePath, "basePath 不能为空");
            this.username = username;
            this.password = password;
            this.host = ip;
            this.port = Integer.valueOf(port);
            this.url = url;
            this.basePath=basePath;

        } catch (Exception e) {
            e.getMessage();
        }

    }

    /**
     * @param inputStream 文件流
     * @param suffixType  后缀类型
     * @param customPath  自定义的路径，要上传的路径可以为空,上传默认路径
     * @return
     * @throws Exception
     */
    public FileModel uploadFile(InputStream inputStream, String suffixType, String customPath) {
        FileModel fileModel =new FileModel();
        FTPClient ftp = null;
        boolean is_ok = false;
        try {
            Assert.notNull(suffixType, "文件类型不能为空");
            ftp = new FTPClient();
            ftp.connect(host, port);
            ftp.login(username, password);
            ftp.setFileType(2);

            int reply = ftp.getReplyCode();
            if (!FTPReply.isPositiveCompletion(reply)) {
                System.err.println("FTP服务器拒绝连接 ");
                ftp.disconnect();
            }
            Long ids = IdGenerator.getKey();
            String fileName =ids+"."+suffixType;
            ftp.setControlEncoding("UTF-8");
            //切换目录，没有则创建目录
            if(StringUtils.isNoneBlank(customPath)){
                changeWorkingDir(ftp, customPath);
            }
            is_ok = ftp.storeFile(fileName, inputStream);
            if(!is_ok){System.out.println("上传失败");}
            ftp.logout();
            String filePath= ftp.printWorkingDirectory();
            filePath =filePath.replaceFirst(this.basePath,"")+"/";

            String fileUrl =this.url+filePath+fileName;
            fileModel.setFileName(fileName);
            fileModel.setSuffixType(suffixType);
            fileModel.setFilePath(ftp.printWorkingDirectory());//直接工作目录
            fileModel.setUrl(fileUrl);
        } catch (Exception e) {
            e.getMessage();
        } finally {
            try {
                if (inputStream != null) {
                    inputStream.close();
                }
                if(ftp.isConnected()){
                    ftp.disconnect();
                }

            } catch (IOException e) {
                e.getMessage();
            }
        }
        return fileModel;

    }

    /**
     * 改变并创建目录
     * @param ftp
     * @param customPath
     * @return
     */
    public static boolean changeWorkingDir(FTPClient ftp, String customPath) {
        boolean is_ok=false;
           try{
               boolean hasDirectory = ftp.changeWorkingDirectory(customPath);
               if(!hasDirectory){
                   String[] strArray = customPath.split("/");
                    if(strArray!=null &&strArray.length>0) {
                        for (String path : strArray) {
                            if(StringUtils.isNoneBlank(path)&&!ftp.changeWorkingDirectory(path)){
                                    ftp.makeDirectory(path);
                                is_ok= ftp.changeWorkingDirectory(path);
                            }
                        }
                    }
               }
               return is_ok;
           }catch (Exception e){
               e.getMessage();
           }
        return is_ok;
    }
}
