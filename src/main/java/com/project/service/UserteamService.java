
package com.project.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;



import org.springframework.beans.factory.annotation.Autowired;
import com.project.dao.UserteamRepository;
import com.project.model.Userteam;

@Service
@Transactional
public class UserteamService {
    
    @Autowired
    private UserteamRepository userteamRepository;
    
   
    @Autowired
    private UserServiceImpl userServiceImpl;
    
    public List<Userteam> findAll() {
        List<Userteam> userteams = new ArrayList<>();
        for (Userteam userteam : userteamRepository.findAll()) {
            userteams.add(userteam);
        }
        return userteams;
    }
    public Userteam findUserteam(int id) {
        return userteamRepository.findOne(id);
    }

    public void save(Userteam userteam) {
        userteamRepository.save(userteam);
    }

    public void delete(int id) {
        userteamRepository.delete(id);
    }

   
}
