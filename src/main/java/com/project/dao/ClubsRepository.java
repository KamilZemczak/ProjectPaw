
package com.project.dao;

import com.project.model.Clubs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClubsRepository extends JpaRepository<Clubs, Integer> {
    
}

