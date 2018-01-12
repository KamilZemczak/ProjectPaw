
package com.project.dto;

import java.sql.Date;

public class PlayerpointsDTO {
    private Integer id;
     private Integer round_nr;
     private Integer player_ide;
     private Integer round_points;
     private Integer summary_points;
    private String p;

 
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRound_nr() {
        return round_nr;
    }

    public void setRound_nr(Integer round_nr) {
        this.round_nr = round_nr;
    }

    public Integer getPlayer_ide() {
        return player_ide;
    }

    public void setPlayer_ide(Integer player_ide) {
        this.player_ide = player_ide;
    }

    public Integer getRound_points() {
        return round_points;
    }

    public void setRound_points(Integer round_points) {
        this.round_points = round_points;
    }

    public Integer getSummary_points() {
        return summary_points;
    }

    public void setSummary_points(Integer summary_points) {
        this.summary_points = summary_points;
    }

    public String getP() {
        return p;
    }

    public void setP(String p) {
        this.p = p;
    }

   
    
    
    
}
