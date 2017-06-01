package com.project.dao;

import com.project.model.Bet;
import javax.transaction.Transactional;
import org.springframework.data.repository.CrudRepository;

@Transactional
public abstract interface BetRepository extends CrudRepository<Bet, Long> {
        
}
