
package com.project.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.project.model.Playerpoints;
import com.project.dao.PlayerpointsRepository;
import com.project.dao.TypeRepository;
import com.project.dto.PlayerpointsDTO;
import com.project.model.Type;
import com.project.model.User;
import org.springframework.beans.factory.annotation.Autowired;

@Service
@Transactional
public class PlayerpointsService {
    
    @Autowired
    private PlayerpointsRepository playerpointsRepository;
    
    @Autowired
    private TypeRepository typeRepository;

    @Autowired
    private UserServiceImpl userServiceImpl;
    
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

   public void oblicz(int round_points){
        int a = 0,b = 0,c = 0,d=0;
       
       round_points= a+b+c+d;
       
   }
}
