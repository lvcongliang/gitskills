package com.imooc.web.aspect;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2018/10/26.
 */
@Aspect
@Component
public class TimeAspect {

//    @Before(value="",argNames = "")
//    public void test(){
//
//    }
    @Around("execution(* com.imooc.web.controller.UserController.*(..))")
    public Object handleControllerMethod(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Object[] args=proceedingJoinPoint.getArgs();
        for(Object obj: args){
            System.out.println("arg is "+obj);
        }
        System.out.println("proceedingJoinPoint = [" + proceedingJoinPoint + "]");
        Object obj=proceedingJoinPoint.proceed();
        System.out.println("proceedingJoinPoint obj= [" + obj + "]");
        return obj;
    }
}
