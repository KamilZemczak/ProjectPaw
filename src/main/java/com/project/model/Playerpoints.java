
package com.project.model;
import java.io.Serializable;
import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity; 
import javax.persistence.GeneratedValue; 
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="playerpoints")
public class Playerpoints implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column
     private Integer round_nr;
    @Column
     private Integer player_ide;
    @Column
     private Integer round_points;
    @Column
     private Integer summary_points;
    @Column
     private String p;

    public Playerpoints() {
    }
    
    public Playerpoints(Integer id, Integer round_nr, Integer player_ide, Integer round_points, Integer summary_points, String p ) {
        super();
        this.id = id;
        this.round_nr = round_nr;
        this.player_ide = player_ide;
        this.round_points = round_points;
        this.summary_points = summary_points;
        this.p = p;
    }

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
