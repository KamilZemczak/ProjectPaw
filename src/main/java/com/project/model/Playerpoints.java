
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
     private String p;
    
    @ManyToOne
    private Player player;
    
    
    
    
    public Playerpoints() {
    }
    
    public Playerpoints(Integer id, Integer roundnr, Integer roundpoints, Integer summarypoints, String p ) {
        super();
        this.id = id;
        this.roundnr = roundnr;
        this.roundpoints = roundpoints;
        this.summarypoints = summarypoints;
        this.p = p;
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

    public String getP() {
        return p;
    }

    public void setP(String p) {
        this.p = p;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

   
    
    
    
}
