package com.project.common.fileupload;

public class FileUtils {

    /**
     * 得到文件后缀类型
     * @param originalFilename
     * @return
     */
    public static String getSuffixType(String originalFilename){

        return originalFilename.substring(originalFilename.lastIndexOf(".")+1);
    }

}
