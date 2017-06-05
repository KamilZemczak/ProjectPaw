package com.project.dao;

import com.project.model.Type;
import com.project.model.User;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeRepository extends JpaRepository<Type, Integer> {

    @Query("SELECT t from type t where t.user = :user")
    List<Type> findUserGames(@Param("user") User one);

}
