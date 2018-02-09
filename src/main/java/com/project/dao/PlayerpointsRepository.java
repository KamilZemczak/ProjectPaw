
package com.project.dao;

import com.project.model.Playerpoints;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerpointsRepository extends JpaRepository<Playerpoints, Integer> {

    public Playerpoints findByRoundnr(Integer roundnr);
    public Playerpoints  findByPlayer_id(Integer player_id);    
      public Playerpoints findByRoundnrAndPlayer_Id(Integer roundnr, Integer player_id);

}

