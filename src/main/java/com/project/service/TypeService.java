package com.project.service;

import com.project.dao.GameRepository;
import com.project.dao.TypeRepository;
import com.project.dao.UserRepository;
import com.project.dto.GameDTO;
import com.project.model.Game;
import com.project.model.Type;
import com.project.model.User;

import java.util.ArrayList;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class TypeService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private GameRepository gameRepository;

    @Autowired
    private TypeRepository typeRepository;
    
    @Autowired
    private UserServiceImpl userServiceImpl;
    
    @Autowired
    private GameService gameService;
    
    /* public TypeService(TypeRepository typeRepository) {
    this.typeRepository = typeRepository;
    }
     */
    public List<Type> findAll() {
        List<Type> types = new ArrayList<>();
        for (Type type : typeRepository.findAll()) {
            types.add(type);
        }
        return types;
    }

    public Type findType(int id) {
        return typeRepository.findOne(id);
    }

    public void save(Type type) {
        typeRepository.save(type);
    }

    public void typeGameToUser(Integer gameId, Integer userId) {
        User user = userServiceImpl.getUsername(userId);
        Game game = gameService.findGame(gameId);
        Type type = new Type();
        type.setGame(game);
        type.setUser(user);
        if (user == null || game == null) {
            throw new NullPointerException("Coś poszło nie tak.");
        }
        typeRepository.save(type);
    }

    public ArrayList<GameDTO> getUserGames() {
        User one = userServiceImpl.getUserId();
        List<Type> typeGames = typeRepository.findUserGames(one);
        ArrayList<GameDTO> gameDTOArrayList = new ArrayList<GameDTO>();
        for (Type type : typeGames) {
            Game typeGame = type.getGame();
            GameDTO gameDTO = new GameDTO();
            gameDTO.setId(typeGame.getId());
            gameDTO.setRound(typeGame.getRound());
            gameDTO.setScoreHomea(typeGame.getScoreHomea());
            gameDTO.setScoreAwaya(typeGame.getScoreAwaya());
            gameDTO.setHomeTeam(typeGame.getHomeTeam());
            gameDTO.setAwayTeam(typeGame.getAwayTeam());
            gameDTO.setDateGame(typeGame.getDateGame());
            gameDTO.setFinished(typeGame.getFinished());
            gameDTOArrayList.add(gameDTO);
        }
        return gameDTOArrayList;
    }
}
