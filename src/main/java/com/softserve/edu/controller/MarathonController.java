package com.softserve.edu.controller;


import com.softserve.edu.entity.Marathon;
import com.softserve.edu.exception.MarathonNotFoundException;
import com.softserve.edu.exception.StudentNotFoundException;
import com.softserve.edu.service.MarathonService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.el.MethodNotFoundException;

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
        throw new MethodNotFoundException("No mapping for /marathons/add");//model.getAttribute("id").toString()
    }

    @GetMapping("/edit/{id}")
    public String updateMarathon(@PathVariable long id, Model model) {
        try {
            Marathon marathon = marathonService.findById(new Long(id).intValue());
            model.addAttribute("marathon", marathon);
            return "update-marathon";
        } catch (Exception ex) {
            throw new MarathonNotFoundException("MarathonNotFoundException: "+id);
        }

    }
}
