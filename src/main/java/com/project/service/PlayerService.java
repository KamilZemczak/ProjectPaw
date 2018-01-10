
package com.project.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.project.model.Clubs;
import com.project.dao.ClubsRepository;
import com.project.dao.TypeRepository;
import com.project.dto.ClubsDTO;
import com.project.model.Type;
import com.project.model.User;
import org.springframework.beans.factory.annotation.Autowired;

@Service
@Transactional
public class ClubsService {
    @Autowired
    private ClubsRepository clubsRepository;
    
    @Autowired
    private TypeRepository typeRepository;

    @Autowired
    private UserServiceImpl userServiceImpl;
    
    public List<Clubs> findAll() {
        List<Clubs> club = new ArrayList<>();
        for (Clubs clubs : clubsRepository.findAll()) {
            club.add(clubs);
        }
        return club;
    }
    public Clubs findClubs(int id) {
        return clubsRepository.findOne(id);
    }

    public void save(Clubs clubs) {
        clubsRepository.save(clubs);
    }

    public void delete(int id) {
        clubsRepository.delete(id);
    }

   
}
