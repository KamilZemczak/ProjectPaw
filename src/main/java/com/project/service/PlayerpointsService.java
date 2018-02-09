
package com.project.service;
import com.project.model.Playerpoints;

public interface PlayerpointsService {
    Playerpoints findByRoundnr (Integer roundnr);
    Playerpoints  findByPlayer_id(Integer player_id); 
    Playerpoints findByRoundnrAndPlayer_Id(Integer roundnr, Integer player_id);
}
