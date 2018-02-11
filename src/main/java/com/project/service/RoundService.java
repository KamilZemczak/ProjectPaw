
package com.project.service;

import com.project.dao.RoundRepository;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.project.model.Round;
import com.project.dao.TypeRepository;
import org.springframework.beans.factory.annotation.Autowired;


@Service
@Transactional
public class RoundService {
    @Autowired
    private RoundRepository clubsRepository;
    
    @Autowired
    private TypeRepository typeRepository;

    @Autowired
    private UserServiceImpl userServiceImpl;
    
    public List<Round> findAll() {
        List<Round> club = new ArrayList<>();
        for (Round clubs : clubsRepository.findAll()) {
            club.add(clubs);
        }
        return club;
    }
    public Round findRound(int id) {
        return clubsRepository.findOne(id);
    }

    public void save(Round clubs) {
        clubsRepository.save(clubs);
    }

    public void delete(int id) {
        clubsRepository.delete(id);
    }

   
}
