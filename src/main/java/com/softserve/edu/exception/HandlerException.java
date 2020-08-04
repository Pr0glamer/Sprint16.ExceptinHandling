package com.softserve.edu.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import java.util.NoSuchElementException;

@ControllerAdvice
public class HandlerException {
    @ExceptionHandler(ResourceNotFoundException.class)
    public ModelAndView handleMyCustomException(ResourceNotFoundException exception) {
        ModelAndView model = new ModelAndView("error/error_page");
        model.addObject("info", exception.getMessage());
        model.setStatus(HttpStatus.BAD_REQUEST);
        return model;
    }

    @ExceptionHandler(NoSuchElementException.class)
    public ModelAndView handleNoSuchElementException(NoSuchElementException ex) {
        ModelAndView model = new ModelAndView("error/error_page_404");
        model.addObject("info", "No such page");
        model.addObject("status", "404");
        return model;

    }

    @ExceptionHandler({Exception.class, InternalServerException.class})
    public ModelAndView handleAllException(Exception ex) {
        ModelAndView model = new ModelAndView("error/error_page_500");
        model.addObject("info", "Internal server error");
        model.addObject("status", "505");
        return model;
    }

}
