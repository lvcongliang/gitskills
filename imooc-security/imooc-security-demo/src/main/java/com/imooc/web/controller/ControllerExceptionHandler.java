package com.imooc.web.controller;

import com.imooc.execption.UserNotExistsException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2018/10/26.
 */
@ControllerAdvice
public class ControllerExceptionHandler {


    @ExceptionHandler(UserNotExistsException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Map<String,Object> handleUserNotExistException(UserNotExistsException ex){
        Map<String,Object> map=new HashMap<>();
        map.put("id",ex.getId());
        map.put("message",ex.getMessage());
        return map;
    }


}
