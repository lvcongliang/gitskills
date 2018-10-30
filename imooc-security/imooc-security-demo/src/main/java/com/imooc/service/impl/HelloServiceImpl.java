package com.imooc.service.impl;

import com.imooc.service.HelloService;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2018/10/26.
 */
@Service
public class HelloServiceImpl implements HelloService{
    @Override
    public String greeting(String name) {
        System.out.println("greeting [" + name + "]");
        return "hello "+name;
    }
}
