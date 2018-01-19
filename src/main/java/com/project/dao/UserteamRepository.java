
package com.project.dao;

import com.project.model.Userteam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserteamRepository extends JpaRepository<Userteam, Integer> {
    
}

