package com.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import com.project.service.TaskService;


@Controller
public class MainController {
    
    @Autowired
    private TaskService taskService;
    
    //dlarafala
    
    @GetMapping("/")
    public String home() {
        return "index";
    }
}
