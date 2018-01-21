
package com.project.service;

import com.project.dao.UserkRepository;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.project.model.User;
import org.springframework.beans.factory.annotation.Autowired;


@Service
@Transactional
public class UserkService {
    @Autowired
    private UserkRepository userkRepository;
    

    @Autowired
    private UserServiceImpl userServiceImpl;
    
    public List<User> findAll() {
        List<User> userks = new ArrayList<>();
        for (User user : userkRepository.findAll()) {
            userks.add(user);
        }
        return userks;
    }
    public User findUser(int id) {
        return userkRepository.findOne(id);
    }

    public void save(User user) {
        userkRepository.save(user);
    }

    public void delete(int id) {
        userkRepository.delete(id);
    }

   
}
