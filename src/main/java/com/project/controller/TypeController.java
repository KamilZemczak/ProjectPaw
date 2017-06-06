package com.project.controller;

import com.project.dao.TypeRepository;
import com.project.model.Game;
import com.project.model.Type;
import com.project.model.User;
import com.project.service.GameService;
import com.project.service.TypeService;
import com.project.service.UserServiceImpl;
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
    private TypeRepository typeRepository;

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
        Game game = gameService.findGame(id);
        User user = userServiceImpl.getUserId();
        if (typeRepository.findOneByUserAndGame(user, game) != null || game.getFinished()) {
            return "index";
        }
        type.setGame(gameService.findGame(id));
        type.setUser(userServiceImpl.getUserId());
        typeService.save(type);
        request.setAttribute("bet", "MODE_BETS");
        return "index";
    }

    @GetMapping("/all-types")
    public String allGames(HttpServletRequest request) {
        request.setAttribute("types", typeService.findAll());
        request.setAttribute("mode", "MODE_TYPES");
        return "index";
    }
}
