package com.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.project.service.TaskService;

@RestController
public class SampleRestController {

    @Autowired
    private TaskService taskService;

    @GetMapping("/hello")
    public String hello() {
        return "Udalo sie";
    }
    
    @GetMapping("/all-tasks")
    public String allTasks() {
        return taskService.findAll().toString();
        
    }

}
