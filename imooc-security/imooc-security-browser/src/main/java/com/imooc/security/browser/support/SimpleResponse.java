package com.imooc.security.browser.support;

/**
 * Created by LvCongLiang on 2018/10/28.
 */
public class SimpleResponse {
    public SimpleResponse(Object content) {
        this.content = content;
    }

    private Object content;

    public Object getContent() {
        return content;
    }

    public void setContent(Object content) {
        this.content = content;
    }
}
