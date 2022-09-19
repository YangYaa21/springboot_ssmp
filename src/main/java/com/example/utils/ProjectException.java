package com.example.utils;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ProjectException {

    @ExceptionHandler
    Result doException(Exception ex){
        ex.printStackTrace();
        return new  Result("服务器异常，请稍后再试！");
    }
}
