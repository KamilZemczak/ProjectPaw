package com.project.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "bet")
public class Bet implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id_bet;
    private int id_round;
    private int scoreHomeTeamP;
    private int scoreAwayTeamP;
    private int scoreHomeTeamA;
    private int scoreAwayTeamA;
    private String homeTeam;
    private String awayTeam;
    private String matchDate;

    public Bet() {
    }

    public Bet(int id_bet, int id_round, int scoreHomeTeamP, int scoreAwayTeamP, int scoreHomeTeamA, int scoreAwayTeamA, String homeTeam, String awayTeam, String matchDate) {
        super();
        this.id_round = id_round;
        this.scoreHomeTeamP = scoreHomeTeamP;
        this.scoreAwayTeamP = scoreAwayTeamP;
        this.scoreHomeTeamA = scoreHomeTeamA;
        this.scoreAwayTeamA = scoreAwayTeamA;
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.matchDate = matchDate;
    }

    public int getId_bet() {
        return id_bet;
    }

    public void setId_bet(int id_bet) {
        this.id_bet = id_bet;
    }

    public int getId_round() {
        return id_round;
    }

    public void setId_round(int id_round) {
        this.id_round = id_round;
    }

    public int getScoreHomeTeamP() {
        return scoreHomeTeamP;
    }

    public void setScoreHomeTeamP(int scoreHomeTeamP) {
        this.scoreHomeTeamP = scoreHomeTeamP;
    }

    public int getScoreAwayTeamP() {
        return scoreAwayTeamP;
    }

    public void setScoreAwayTeamP(int scoreAwayTeamP) {
        this.scoreAwayTeamP = scoreAwayTeamP;
    }

    public int getScoreHomeTeamA() {
        return scoreHomeTeamA;
    }

    public void setScoreHomeTeamA(int scoreHomeTeamA) {
        this.scoreHomeTeamA = scoreHomeTeamA;
    }

    public int getScoreAwayTeamA() {
        return scoreAwayTeamA;
    }

    public void setScoreAwayTeamA(int scoreAwayTeamA) {
        this.scoreAwayTeamA = scoreAwayTeamA;
    }

    public String getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam(String homeTeam) {
        this.homeTeam = homeTeam;
    }

    public String getAwayTeam() {
        return awayTeam;
    }

    public void setAwayTeam(String awayTeam) {
        this.awayTeam = awayTeam;
    }

    public String getMatchDate() {
        return matchDate;
    }

    public void setMatchDate(String matchDate) {
        this.matchDate = matchDate;
    }

    @Override
    public String toString() {
        return "Bet{" + "id_bet=" + id_bet + ", id_round=" + id_round + ", scoreHomeTeamP=" + scoreHomeTeamP + ", scoreAwayTeamP=" + scoreAwayTeamP + ", scoreHomeTeamA=" 
                + scoreHomeTeamA + ", scoreAwayTeamA=" + scoreAwayTeamA + ", homeTeam=" + homeTeam + ", awayTeam=" + awayTeam + ", matchDate=" + matchDate + '}';
    }
}
