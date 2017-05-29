package com.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import com.project.service.TaskService;
import javax.servlet.http.HttpServletRequest;


@Controller
public class MainController {
    
    @Autowired
    private TaskService taskService;
    
    @GetMapping("/")
    public String home(HttpServletRequest request) {
        request.setAttribute("tasks", taskService.findAll());
        return "index";
    }
}
