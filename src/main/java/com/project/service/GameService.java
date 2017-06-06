package com.project.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.project.model.Game;
import com.project.dao.GameRepository;
import com.project.dao.TypeRepository;
import com.project.dao.UserRepository;
import com.project.dto.GameDTO;
import com.project.model.Type;
import com.project.model.User;
import org.springframework.beans.factory.annotation.Autowired;

@Service
@Transactional
public class GameService {

    @Autowired
    private GameRepository gameRepository;
    
    @Autowired
    private TypeRepository typeRepository;

    @Autowired
    private UserServiceImpl userServiceImpl;

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

    public void save(Game game) {
        gameRepository.save(game);
    }

    public void delete(int id) {
        gameRepository.delete(id);
    }

    public List<GameDTO> fillTypeToGame(List<Game> games) {
        ArrayList<GameDTO> gameDTOArrayList = new ArrayList<GameDTO>();
        for (Game game : games) {

            User one = userServiceImpl.getUserId();
            Type type = typeRepository.findOneByUserAndGame(one, game);

            GameDTO gameDTO = new GameDTO();
            gameDTO.setId(game.getId());
            gameDTO.setRound(game.getRound());
            gameDTO.setScoreHomea(game.getScoreHomea());
            gameDTO.setScoreAwaya(game.getScoreAwaya());
            gameDTO.setHomeTeam(game.getHomeTeam());
            gameDTO.setAwayTeam(game.getAwayTeam());
            gameDTO.setDateGame(game.getDateGame());
            gameDTO.setFinished(game.getFinished());
            if (type != null) {
                gameDTO.setScoreHomep(type.getScoreHomep());
                gameDTO.setScoreAwayp(type.getScoreAwayp());
            }
            gameDTOArrayList.add(gameDTO);
        }
        return gameDTOArrayList;
    }
}
