package com.project.service;

import com.project.dao.GameRepository;
import com.project.dao.TypeRepository;
import com.project.dao.UserRepository;
import com.project.model.Game;
import com.project.model.Type;
import com.project.model.User;

import java.util.ArrayList;
import java.util.Date;
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

    private final TypeRepository typeRepository;
  
    public TypeService(TypeRepository typeRepository) {
        this.typeRepository = typeRepository;
    }

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
    
    public void betGameToUser(Integer gameId, Integer userId) {
        User user = userRepository.findOne(userId);
        Game game = gameRepository.findOne(gameId);
        Type type = new Type();
        type.setGame(game);
        type.setUser(user);
        //rent.setRentDate(new Date());
        if (user == null || game == null) {
            throw new NullPointerException("!!!");
        }
        typeRepository.save(type);
    }

}
