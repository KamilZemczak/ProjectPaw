package com.project.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity(name = "type")
public class Type implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idType;
    private int scoreHomep;
    private int scoreAwayp;
    @ManyToMany(mappedBy = "types")
    private List<User> users;

    public Type() {

    }

    public Type(int scoreHomeTeamp, int scoreAwayTeamp) {
        this.scoreHomep = scoreHomeTeamp;
        this.scoreAwayp = scoreAwayTeamp;
    }

    public int getIdType() {
        return idType;
    }

    public void setIdType(int idType) {
        this.idType = idType;
    }

    public int getScoreHomep() {
        return scoreHomep;
    }

    public void setScoreHomep(int scoreHomeTeamp) {
        this.scoreHomep = scoreHomeTeamp;
    }

    public int getScoreAwayTeamp() {
        return scoreAwayp;
    }

    public void setScoreAwayTeamp(int scoreAwayTeamp) {
        this.scoreAwayp = scoreAwayTeamp;
    }

    @Override
    public String toString() {
        return "Type{" + "idType=" + idType + ", scoreHomep=" + scoreHomep + ", scoreAwayTeamp=" + scoreAwayp + '}';
    }

    /*@Override
    public String toString() {
    return "Type{" + "scoreHomeTeamp=" + scoreHomeTeamp + ", scoreAwayTeamp=" + scoreAwayTeamp + '}';
    }*/

 /*
    List Bet
    user_id  = lista_z_zakladami [id.task]
    
    @OneToMany(mappedBy="user")
    @OrderBy("bet_id")
    private Set<Bet> bets = new HashSet();*/
}
