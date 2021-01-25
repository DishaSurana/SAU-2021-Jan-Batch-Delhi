package com.springmvc.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

@ControllerAdvice
public class divideByZeroControllerAdvice extends Exception {

    public divideByZeroControllerAdvice()
    {
        super("Division by zero");
    }

    @RequestMapping(produces= MediaType.APPLICATION_JSON_VALUE)
    @ExceptionHandler(value = divideByZeroControllerAdvice.class)
    public @ResponseBody
    HashMap<String, Object> handleError(HttpServletRequest req, Exception exception) {
        HashMap<String,Object> zeroError =new HashMap<>();
        HashMap<String,String> errorObj=new HashMap<>();
        errorObj.put("Operation","/");
        errorObj.put("Message","Divide By Zero Error");
        errorObj.put("Advice", "Do not enter '0' for number2");
        zeroError.put("zeroError", errorObj);
        return zeroError;
    }
}
