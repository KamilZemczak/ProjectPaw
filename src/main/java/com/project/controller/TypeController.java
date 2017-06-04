package com.project.controller;

import com.project.model.Type;
import com.project.service.TypeService;
import com.project.service.UserServiceImpl;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TypeController {

    @Autowired
    private TypeService typeService;

    @Autowired
    private UserServiceImpl userServiceImpl;

    @GetMapping("/bet-bet")
    public String updateType(@RequestParam int gameId, HttpServletRequest request) {
        request.setAttribute("game", typeService.findType(gameId));
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

    @GetMapping("/save-bet")
    public String saveType(@RequestParam("userId") Integer userId, int bookId, HttpServletRequest request) {
        userServiceImpl.getUsername(userId);
        request.setAttribute("masterId", userId);
        typeService.betGameToUser(bookId, userId);
        return "index";
    }
}
