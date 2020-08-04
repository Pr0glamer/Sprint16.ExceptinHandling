package com.softserve.edu.controller;


import com.softserve.edu.entity.Marathon;
import com.softserve.edu.exception.MarathonNotFoundException;
import com.softserve.edu.exception.StudentNotFoundException;
import com.softserve.edu.service.MarathonService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.NoSuchElementException;

@Controller
@RequestMapping({"/", "/marathons"})
public class MarathonController {
    private MarathonService marathonService;

    public MarathonController(MarathonService marathonService) {
        this.marathonService = marathonService;
    }

    @ExceptionHandler(NoSuchElementException.class)
    public ModelAndView handleNoSuchElementException(NoSuchElementException ex) {
        ModelAndView model = new ModelAndView("error/error_page_404");
        model.addObject("info", ex.getMessage());
        model.setStatus(HttpStatus.NOT_FOUND);
        return model;
    }

    @GetMapping
    public String getAllMarathons(Model model) {
        model.addAttribute("marathons", marathonService.findAll());
        return "marathones";
    }

    @GetMapping("/add")
    public String gotoMarathon(Model model) {
        throw new NoSuchElementException("No mapping for /marathons/add");
    }

    @GetMapping("/edit/{id}")
    public String updateMarathon(@PathVariable long id, Model model) {
        try {
            Marathon marathon = marathonService.findById(Long.valueOf(id).intValue());
            model.addAttribute("marathon", marathon);
            return "marathon";
        } catch (Exception ex) {
            throw new MarathonNotFoundException("Marathon with id = " + id + " not found");
        }
    }
}
