package com.project.controller;

import com.project.model.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;
import com.project.service.TaskService;
import java.util.Date;

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
    
    @GetMapping("/save-task")
    public String saveTask(@RequestParam String name, @RequestParam String desc) {
        Task task = new Task(name, desc, new Date(), false);
        taskService.save(task);
        return "Task saved!";
    }

}
