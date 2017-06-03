package com.project.controller;

import com.project.model.Type;
import com.project.service.TypeService;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TypeController {
    
    @Autowired
    private TypeService typeService;

    @GetMapping("/bet-bet")
    public String updateType(@RequestParam int id, HttpServletRequest request) {
        request.setAttribute("game", typeService.findType(id));
        request.setAttribute("mode", "MODE_BET");
        return "index";
    }

    @PostMapping("/save-bet")
    public String saveType(@ModelAttribute Type type, BindingResult bindingResult, HttpServletRequest request) {
        typeService.save(type);
        request.setAttribute("games", typeService.findAll());
        request.setAttribute("mode", "MODE_BETS");
        return "index";
    }

}
