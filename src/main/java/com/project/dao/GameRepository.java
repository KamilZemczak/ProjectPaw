package com.project.dao;

import org.springframework.data.repository.CrudRepository;
import com.project.model.Game;

public interface GameRepository extends CrudRepository<Game, Integer> {
    
}
