package com.project.dao;

import com.project.model.Type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeRepository extends JpaRepository<Type, Integer> {

    /* @Query("from Type t where t.user = :user")
    List<Type> findUserGames(@Param("user") User one);*/

}
