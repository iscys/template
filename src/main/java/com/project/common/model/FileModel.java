package com.project.common.model;

public class FileModel {

    private String filePath;//文件在服务器的路径
    private String fileName;//文件名
    private String url;//上传服务器返回后，http 访问路径
    private String suffixType; //文件后缀类型
    private int size;//文件大小

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getSuffixType() {
        return suffixType;
    }

    public void setSuffixType(String suffixType) {
        this.suffixType = suffixType;
    }

}
