package com.project.dto;

public class GameDTO {

    private Integer id;
    private Integer round;
    private Integer scoreHomea;
    private Integer scoreAwaya;
    private String homeTeam;
    private String awayTeam;
    private String dateGame;
    private boolean finished;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRound() {
        return round;
    }

    public void setRound(Integer round) {
        this.round = round;
    }

    public Integer getScoreHomea() {
        return scoreHomea;
    }

    public void setScoreHomea(Integer scoreHomea) {
        this.scoreHomea = scoreHomea;
    }

    public Integer getScoreAwaya() {
        return scoreAwaya;
    }

    public void setScoreAwaya(Integer scoreAwaya) {
        this.scoreAwaya = scoreAwaya;
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

    public String getDateGame() {
        return dateGame;
    }

    public void setDateGame(String dateGame) {
        this.dateGame = dateGame;
    }

    public boolean isFinished() {
        return finished;
    }

    public void setFinished(boolean finished) {
        this.finished = finished;
    }
}
