
package com.project.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;



import org.springframework.beans.factory.annotation.Autowired;
import com.project.dao.MyteamRepository;
import com.project.model.Myteam;

@Service
@Transactional
public class MyteamService {
    
    @Autowired
    private MyteamRepository myteamRepository;
    
   
    @Autowired
    private UserServiceImpl userServiceImpl;
    
    public List<Myteam> findAll() {
        List<Myteam> myteams = new ArrayList<>();
        for (Myteam myteam : myteamRepository.findAll()) {
            myteams.add(myteam);
        }
        return myteams;
    }
    public Myteam findMyteam(int id) {
        return myteamRepository.findOne(id);
    }

    public void save(Myteam myteam) {
        myteamRepository.save(myteam);
    }

    public void delete(int id) {
        myteamRepository.delete(id);
    }

   
}
