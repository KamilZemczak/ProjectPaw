
package com.project.model;
import java.io.Serializable;
import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity; 
import javax.persistence.GeneratedValue; 
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity(name="playerpoints")
public class Playerpoints implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column
     private Integer roundnr;
    @Column
     private Integer roundpoints;
    @Column
     private Integer summarypoints;
    @Column
     private Integer assists;
     @Column
    private boolean redcards;
      @Column
    private boolean yellowcards;
       @Column
     private Integer goals;
    
    @ManyToOne
    private Player player;
    
   
    
    public Playerpoints() {
    }
    
 public Playerpoints(Integer id, Integer roundnr, Integer roundpoints, Integer summarypoints, Integer assists, boolean redcards, boolean yellowcards, Integer goals ) {
        super();
        this.id = id;
        this.roundnr = roundnr;
        this.roundpoints = roundpoints;
        this.summarypoints = summarypoints;
        this.assists = assists;
        this.redcards=redcards;
        this.yellowcards=yellowcards;
        this.goals=goals;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRoundnr() {
        return roundnr;
    }

    public void setRoundnr(Integer roundnr) {
        this.roundnr = roundnr;
    }


    public Integer getRoundpoints() {
        return roundpoints;
    }

    public void setRoundpoints(Integer roundpoints) {
        this.roundpoints = roundpoints;
    }

    public Integer getSummarypoints() {
        return summarypoints;
    }

    public void setSummarypoints(Integer summarypoints) {
        this.summarypoints = summarypoints;
    }

    public Integer getAssists() {
        return assists;
    }

    public void setAssists(Integer assists) {
        this.assists = assists;
    }

    public boolean isRedcards() {
        return redcards;
    }

    public void setRedcards(boolean redcards) {
        this.redcards = redcards;
    }

    public boolean isYellowcards() {
        return yellowcards;
    }

    public void setYellowcards(boolean yellowcards) {
        this.yellowcards = yellowcards;
    }

    public Integer getGoals() {
        return goals;
    }

    public void setGoals(Integer goals) {
        this.goals = goals;
    }

 

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

   
    
    
    
}
