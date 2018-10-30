package com.imooc.execption;

/**
 * Created by Administrator on 2018/10/26.
 */
public class UserNotExistsException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public UserNotExistsException(String id) {
        super("user doesn't exist");
        this.id=id;
    }

    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
