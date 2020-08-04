package com.softserve.edu.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@ControllerAdvice
public class HandlerException {
    @ExceptionHandler(StudentNotFoundException.class)
    public ModelAndView handleStudentNotFoundException(StudentNotFoundException exception){
        ModelAndView model = new ModelAndView("error/error_page_404");
        model.addObject("info", exception.getMessage());
        model.setStatus(HttpStatus.NOT_FOUND);
        return model;
    }

    @ExceptionHandler(MarathonNotFoundException.class)
    public ModelAndView handleMarathonNotFoundException(MarathonNotFoundException exception){
        ModelAndView model = new ModelAndView("error/error_page_404");
        model.addObject("info", exception.getMessage());
        model.setStatus(HttpStatus.NOT_FOUND);
        return model;
    }

    @ExceptionHandler(InternalServerException.class)
    public ModelAndView handleInternalServerException(InternalServerException exception){
        ModelAndView model = new ModelAndView("error/error_page_500");
        model.addObject("info", exception.getMessage());
        model.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
        return model;
    }

    @ExceptionHandler(Exception.class)
    public ModelAndView handleAllException(Exception ex) {
        ModelAndView model = new ModelAndView("error/error_page");
        model.addObject("info", ex.getMessage());
        model.addObject("status", "I'm a teapot");
        model.setStatus(HttpStatus.I_AM_A_TEAPOT);
        return model;
    }
}
