package com.project.service;

import com.project.dao.BetRepository;
import com.project.model.Bet;
import java.util.ArrayList;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class BetService {

    private final BetRepository betRepository;

    public BetService(BetRepository betRepository) {
        this.betRepository = betRepository;
    }

    public List<Bet> findAll() {
        List<Bet> bets = new ArrayList<>();
        for (Bet bet : betRepository.findAll()) {
            bets.add(bet);
        }
        return bets;
    }
    
    public Bet findBet(int id_bet) {
        return betRepository.findOne(id_bet);
    }
    
    public void save(Bet bet) {
        betRepository.save(bet);
    }
    
    public void delete(int id_bet) {
        betRepository.delete(id_bet);
    }
}
