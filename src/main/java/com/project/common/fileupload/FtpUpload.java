package com.project.common.fileupload;


import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;
import org.springframework.util.Assert;

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
            this.username = username;
            this.password = password;
            this.host = ip;
            this.port = Integer.valueOf(port);
            this.url = url;

        } catch (Exception e) {
            e.getMessage();
        }

    }

    /**
     * @param inputStream 文件流
     * @param suffixType  后缀类型
     * @param customPath  自定义的路径，要上传的路径可以为空
     * @return
     * @throws Exception
     */
    public boolean uploadFile(InputStream inputStream, String suffixType, String customPath) {
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
            ftp.setControlEncoding("UTF-8");
            is_ok = ftp.storeFile("12398.jpg", inputStream);
            if(!is_ok){System.out.println("上传失败");}
            ftp.logout();

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
        return is_ok;

    }
}
