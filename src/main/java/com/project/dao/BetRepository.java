package com.project.dao;

import com.project.model.Bet;
import org.springframework.data.repository.CrudRepository;

public interface BetRepository extends CrudRepository<Bet, Integer> {
    
}

