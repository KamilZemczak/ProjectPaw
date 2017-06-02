package com.project.controller;

import com.project.model.Bet;
import com.project.service.BetService;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BetController {

    @Autowired
    private BetService betService;

    @GetMapping("/home2")
    public String home(HttpServletRequest request) {
        request.setAttribute("mode", "MODE_HOMEB");
        return "adminpanel";
    }

    @GetMapping("/all-bets")
    public String allBets(HttpServletRequest request) {
        request.setAttribute("bets", betService.findAll());
        request.setAttribute("mode", "MODE_BETS");
        return "adminpanel";
    }

    @GetMapping("/new-bet")
    public String newBet(HttpServletRequest request) {
        request.setAttribute("mode", "MODE_NEWB");
        return "adminpanel";
    }

    @PostMapping("/save-bet")
    public String saveBet(@ModelAttribute Bet bet, BindingResult bindingResult, HttpServletRequest request) {
        //task.setDateCreated(new Date());
        betService.save(bet);
        request.setAttribute("bets", betService.findAll());
        request.setAttribute("mode", "MODE_BETS");
        return "adminpanel";
    }

    @GetMapping("/update-bet")
    public String updateBet(@RequestParam int id_bet, HttpServletRequest request) {
        request.setAttribute("bet", betService.findBet(id_bet));
        request.setAttribute("mode", "MODE_UPDATEB");
        return "adminpanel";
    }

    @GetMapping("/delete-bet")
    public String deleteBets(@RequestParam int id_bet, HttpServletRequest request) {
        betService.delete(id_bet);
        request.setAttribute("bets", betService.findAll());
        request.setAttribute("mode", "MODE_BETS");
        return "adminpanel";
    }

}
