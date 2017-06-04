package com.project.controller;

import com.project.model.Game;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import com.project.service.GameService;
import javax.servlet.http.HttpServletRequest;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

    @Autowired
    private GameService gameService;

    @GetMapping("/home")
    public String home(HttpServletRequest request) {
        request.setAttribute("mode", "MODE_HOME");
        return "index";
    }

    @GetMapping("/all-games")
    public String allGames(HttpServletRequest request) {
        request.setAttribute("games", gameService.findAll());
        request.setAttribute("mode", "MODE_GAMES");
        return "index";
    }
    
    //TODO: nie wiadomo czy to dobrze
    @GetMapping("/bet-games")
    public String betGames(HttpServletRequest request) {
        request.setAttribute("games", gameService.findAll());
        request.setAttribute("mode", "MODE_BETS");
        return "index";
    }

    @GetMapping("/new-game")
    public String newGame(HttpServletRequest request) {
        request.setAttribute("mode", "MODE_NEW");
        return "index";
    }

    @PostMapping("/save-game")
    public String saveGame(@ModelAttribute Game game, BindingResult bindingResult, HttpServletRequest request) {
        gameService.save(game);
        request.setAttribute("games", gameService.findAll());
        request.setAttribute("mode", "MODE_GAMES");
        return "index";
    }

    @GetMapping("/update-game")
    public String updateGame(@RequestParam int id, HttpServletRequest request) {
        request.setAttribute("game", gameService.findGame(id));
        request.setAttribute("mode", "MODE_UPDATE");
        return "index";
    }

    @GetMapping("/delete-game")
    public String deleteGames(@RequestParam int id, HttpServletRequest request) {
        gameService.delete(id);
        request.setAttribute("games", gameService.findAll());
        request.setAttribute("mode", "MODE_GAMES");
        return "index";
    }

}
