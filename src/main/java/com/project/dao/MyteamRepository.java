
package com.project.dao;

import com.project.model.Myteam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MyteamRepository extends JpaRepository<Myteam, Integer> {
    
}

