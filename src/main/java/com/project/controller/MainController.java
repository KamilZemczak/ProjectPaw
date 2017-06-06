package com.project.controller;

import com.project.model.Game;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import com.project.service.GameService;
import com.project.service.MessageService;
import com.project.service.TypeService;
import javax.servlet.http.HttpServletRequest;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

    @Autowired
    private GameService gameService;

    @Autowired
    private MessageService messageService;

    @Autowired
    private TypeService typeService;

    @GetMapping("/")
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

    @GetMapping("/your-games")
    public String yourGames(HttpServletRequest request) {
        request.setAttribute("games", typeService.getUserGames());
        request.setAttribute("mode", "MODE_BETS");
        return "index";
    }

    @GetMapping("/bet-games")
    public String betGames(HttpServletRequest request) {
        request.setAttribute("games", gameService.fillTypeToGame(gameService.findAll()));        
        request.setAttribute("mode", "MODE_BETSS");
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
        request.setAttribute("message", "treść wiadomości"); //TODO
        messageService.addSuccessMessage("Zaktualizowano pozycje!");
        return "index";
    }

    @GetMapping("/delete-game")
    public String deleteGames(@RequestParam int id, HttpServletRequest request) {
        gameService.delete(id);
        request.setAttribute("games", gameService.findAll());
        request.setAttribute("mode", "MODE_GAMES");
        return "index";
    }

    @GetMapping("/contact")
    public String contact(HttpServletRequest request) {
        request.setAttribute("mode", "MODE_CONTACT");
        return "index";
    }
}
