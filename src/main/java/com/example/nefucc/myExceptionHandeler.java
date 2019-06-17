package com.example.nefucc;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class myExceptionHandeler {
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Object exceptionhandler(){
        return "您访问的页面正忙，请稍后再来访问";
    }
}
