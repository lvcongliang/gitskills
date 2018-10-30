package com.imooc.dto;

/**
 * Created by Administrator on 2018/10/28.
 */
public class FileInfo {
    public FileInfo(String path) {
        this.path = path;
    }

    private String path;

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
