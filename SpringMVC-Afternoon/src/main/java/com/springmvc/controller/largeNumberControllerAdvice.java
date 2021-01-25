package com.springmvc.controller;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;


@ControllerAdvice
public class largeNumberControllerAdvice extends Exception{

    public largeNumberControllerAdvice(){
        super("Large Number Error: number > 1000");
    }

    @ExceptionHandler(value = largeNumberControllerAdvice.class)
    public ModelAndView handleLargeNumberError() {

        ModelAndView mv = new ModelAndView();
        mv.addObject("exception", "Large Number Error: number > 1000");
        mv.setViewName("largeNumberError");
        return mv;
    }

}

