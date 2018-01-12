
package com.project.dao;

import com.project.model.Playerpoints;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerpointsRepository extends JpaRepository<Playerpoints, Integer> {
    
}

