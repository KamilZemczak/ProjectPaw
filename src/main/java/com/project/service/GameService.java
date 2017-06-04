package com.project.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.project.model.Game;
import com.project.dao.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;

@Service
@Transactional
public class GameService {

    @Autowired
    private GameRepository gameRepository;

    /*public GameService(GameRepository gameRepository) {
    this.gameRepository = gameRepository;
    }*/
    
    public List<Game> findAll() {
        List<Game> games = new ArrayList<>();
        for (Game game : gameRepository.findAll()) {
            games.add(game);
        }
        return games;
    }
    
    public Game findGame(int id) {
        return gameRepository.findOne(id);
    }
    
    /**
     * Zapisuje parametry gry do bazy danych
     * 
     * @param game dane pobrane od użytkownika
     */
    public void save(Game game) {
        gameRepository.save(game);
    }
    
    /**
     * Usuwa grę z bazy danych
     * 
     * @param id identyfikator usuwanej gry
     */
    public void delete(int id) {
        gameRepository.delete(id);
    }
}
