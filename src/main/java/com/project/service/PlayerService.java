
package com.project.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.project.model.Player;
import com.project.dao.PlayerRepository;
import com.project.dto.PlayerDTO;
import org.springframework.beans.factory.annotation.Autowired;

@Service
@Transactional
public class PlayerService {
    @Autowired
    private PlayerRepository playerRepository;
    

    @Autowired
    private UserServiceImpl userServiceImpl;
    
    public List<Player> findAll() {
        List<Player> players = new ArrayList<>();
        for (Player player : playerRepository.findAll()) {
            players.add(player);
        }
        return players;
    }
    public Player findPlayer(int id) {
        return playerRepository.findOne(id);
    }

    public void save(Player player) {
        playerRepository.save(player);
    }

    public void delete(int id) {
        playerRepository.delete(id);
    }

   
}
