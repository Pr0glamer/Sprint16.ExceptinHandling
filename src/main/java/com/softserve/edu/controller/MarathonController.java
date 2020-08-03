package com.softserve.edu.controller;


import com.softserve.edu.exception.ResourceNotFoundException;
import com.softserve.edu.service.MarathonService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/marathons")
public class MarathonController {
    private MarathonService marathonService;

    public MarathonController(MarathonService marathonService) {
        this.marathonService = marathonService;
    }

//    @ExceptionHandler(MyCustomException.class)
//    public ModelAndView handleMyCustomException(MyCustomException exception){
//        ModelAndView model = new ModelAndView("error_page");
//        model.addObject("info", exception.getMessage());
//        model.setStatus(HttpStatus.BAD_REQUEST);
//        return model;
//    }

    @GetMapping
    public String getAllMarathons(Model model) {
        model.addAttribute("marathons", marathonService.findAll());
        return "marathones";
    }

    @GetMapping("/add")
    String gotoMarathon(Model model) {
        throw new ResourceNotFoundException("Hello from exception");
    }

    //TODO implement other needed methods
}
