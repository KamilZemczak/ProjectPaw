package com.project.dao;

import com.project.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserkRepository extends JpaRepository<User, Integer> {
   
}
