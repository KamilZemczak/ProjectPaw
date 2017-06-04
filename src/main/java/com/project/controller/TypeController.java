package com.project.controller;

import com.project.dao.GameRepository;
import com.project.model.Game;
import com.project.model.Type;
import com.project.service.GameService;
import com.project.service.TypeService;
import com.project.service.UserService;
import com.project.service.UserServiceImpl;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
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
    
    @Autowired
    private GameService gameService;
    
    @Autowired
    private UserServiceImpl userServiceImpl;

    @GetMapping("/bet-bet")
    public String updateType(@RequestParam int id, HttpServletRequest request) {
        request.setAttribute("game", typeService.findType(id));
        request.setAttribute("mode", "MODE_BET");
        return "index";
    }

    @PostMapping("/save-bet")
    public String saveType(@ModelAttribute Type type, @RequestParam Integer id, @RequestParam Integer userId, HttpServletRequest request) {
        
        typeService.save(type);
        
        request.setAttribute("game", typeService.findType(id));
        request.setAttribute("userId", userServiceImpl.getUsername(userId));
        typeService.typeGameToUser(id, userId);
        //request.setAttribute("types", typeService.findAll());
        request.setAttribute("bet", "MODE_BETS");
        return "index";
    }
    
    /* @PostMapping("/save-game")
    public String saveGame(@ModelAttribute Game game, BindingResult bindingResult, HttpServletRequest request) {
    gameService.save(game);
    request.setAttribute("games", gameService.findAll());
    request.setAttribute("mode", "MODE_GAMES");
    return "index";
    }
    
    */

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
