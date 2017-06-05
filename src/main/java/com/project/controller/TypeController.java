package com.project.controller;

import com.project.model.Type;
import com.project.service.GameService;
import com.project.service.TypeService;
import com.project.service.UserServiceImpl;
import java.security.Principal;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TypeController {

    @Autowired
    private TypeService typeService;

    @Autowired
    private GameService gameService;

    @Autowired
    private UserServiceImpl userServiceImpl;

    @GetMapping("/bet-bet")
    public String updateType(@RequestParam int id, HttpServletRequest request) {
        request.setAttribute("game", gameService.findGame(id));
        request.setAttribute("mode", "MODE_BET");
        return "index";
    }

    @PostMapping("/save-bet")
    public String saveType(@ModelAttribute Type type, @RequestParam("game_id") Integer id, HttpServletRequest request) {
    type.setGame(gameService.findGame(id));
    type.setUser(userServiceImpl.getUserId());
    typeService.save(type);
    request.setAttribute("bet", "MODE_BETS");
    return "index";
    }
    
    /*  @PostMapping("/save-bet")
    public String saveGame(@ModelAttribute Type type, BindingResult bindingResult, HttpServletRequest request) {
    typeService.save(type);
    request.setAttribute("bets", typeService.findAll());
    request.setAttribute("mode", "MODE_BETS");
    return "index";
    }*/

    /*    @GetMapping("/bet-touser")
    public String rentToUser(@RequestParam("id") Integer id, @RequestParam("userId") Integer userId) {
    try {
    typeService.typeGameToUser(type, id, userId);
    } catch (Exception e) {
    //messageService.addErrorMessage("Błąd. Skontaktuj się ze swoim deweloperem.");
    e.printStackTrace();
    }
    //messageService.addSuccessMessage("Książka została wypożyczona!");
    return "index";
    }*/
 /*
    @GetMapping("/save-bet")
    public String saveType(@RequestParam("userId") Integer userId, int bookId, HttpServletRequest request) {
    userServiceImpl.getUsername(userId);
    request.setAttribute("masterId", userId);
    typeService.betGameToUser(bookId, userId);
    return "index";
    }*/
}
