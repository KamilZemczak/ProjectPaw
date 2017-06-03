package com.project.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.project.model.Game;
import com.project.dao.GameRepository;

@Service
@Transactional
public class GameService {

    private final GameRepository gameRepository;

    public GameService(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    public List<Game> findAll() {
        List<Game> games = new ArrayList<>();
        for (Game game : gameRepository.findAll()) {
            games.add(game);
        }
        return games;
    }
    
    public Game findGame(int gameId) {
        return gameRepository.findOne(gameId);
    }
    
    public void save(Game game) {
        gameRepository.save(game);
    }
    
    public void delete(int gameId) {
        gameRepository.delete(gameId);
    }
}
