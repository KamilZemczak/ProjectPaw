
package com.project.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import com.project.model.Playerpoints;
import com.project.dao.PlayerpointsRepository;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class PlayerpointsServiceImpl {
    
    @Autowired
    private PlayerpointsRepository playerpointsRepository;
    
    
    public List<Playerpoints> findAll() {
        List<Playerpoints> playerpoint = new ArrayList<>();
        for (Playerpoints playerpoints : playerpointsRepository.findAll()) {
            playerpoint.add(playerpoints);
        }
        return playerpoint;
    }
    public Playerpoints findPlayerpoints(int id) {
        return playerpointsRepository.findOne(id);
    }

    public void save(Playerpoints Playerpoints) {
        playerpointsRepository.save(Playerpoints);
    }

    public void delete(int id) {
        playerpointsRepository.delete(id);
    }

    public Playerpoints findByRoundnr (Integer roundnr) {
        Playerpoints playerpoints = playerpointsRepository.findByRoundnr (roundnr);
        return playerpoints;
    }
 public Playerpoints findByPlayer_id (Integer player_id) {
        Playerpoints playerpoints = playerpointsRepository.findByPlayer_id(player_id); 
        return playerpoints;
    }
    
 
 public Playerpoints findByPlayer_id (Integer roundnr, Integer player_id) {
        Playerpoints playerpoints = playerpointsRepository.findByRoundnrAndPlayer_Id(roundnr, player_id);
    
        return playerpoints;
    } 
 
    
}
