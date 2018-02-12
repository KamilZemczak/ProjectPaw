
package com.project.model;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity; 
import javax.persistence.GeneratedValue; 
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

@Entity(name="userteam")
public class Userteam implements Serializable {
    @Id
    private Integer id;
    @Column
     private String player1;
    @Column
     private String player2;
    @Column
     private String player3;
    @Column
     private String player4;
    @Column
     private String player5;
    @Column
     private String player6;
    @Column
     private String player7;
    @Column
     private String player8;
    @Column
     private String player9;
    @Column
     private String player10;
    @Column
     private String player11;
    @Column
     private String player12;
    @Column
     private String player13;
    @Column
     private String player14;
    @Column
     private String player15;
     @Column
     private Integer tcounter;
      @Column
     private Integer transfers;
    @OneToOne 
    private User user;
    
   
    
   
    
    public Userteam() {
    }

    public Userteam(Integer id, String player1, String player2, String player3, String player4, String player5, String player6, String player7, String player8, String player9, String player10, String player11, String player12, String player13, String player14, String player15, Integer tcounter, Integer transfers) {
       super();
        this.id = id;
        this.player1 = player1;
        this.player2 = player2;
        this.player3 = player3;
        this.player4 = player4;
        this.player5 = player5;
        this.player6 = player6;
        this.player7 = player7;
        this.player8 = player8;
        this.player9 = player9;
        this.player10 = player10;
        this.player11 = player11;
        this.player12 = player12;
        this.player13 = player13;
        this.player14 = player14;
        this.player15 = player15;
        this.tcounter = tcounter;
        this.transfers=transfers;
    
    }
    
   

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPlayer1() {
        return player1;
    }

    public void setPlayer1(String player1) {
        this.player1 = player1;
    }

    public String getPlayer2() {
        return player2;
    }

    public void setPlayer2(String player2) {
        this.player2 = player2;
    }

    public String getPlayer3() {
        return player3;
    }

    public void setPlayer3(String player3) {
        this.player3 = player3;
    }

    public String getPlayer4() {
        return player4;
    }

    public void setPlayer4(String player4) {
        this.player4 = player4;
    }

    public String getPlayer5() {
        return player5;
    }

    public void setPlayer5(String player5) {
        this.player5 = player5;
    }

    public String getPlayer6() {
        return player6;
    }

    public void setPlayer6(String player6) {
        this.player6 = player6;
    }

    public String getPlayer7() {
        return player7;
    }

    public void setPlayer7(String player7) {
        this.player7 = player7;
    }

    public String getPlayer8() {
        return player8;
    }

    public void setPlayer8(String player8) {
        this.player8 = player8;
    }

    public String getPlayer9() {
        return player9;
    }

    public void setPlayer9(String player9) {
        this.player9 = player9;
    }

    public String getPlayer10() {
        return player10;
    }

    public void setPlayer10(String player10) {
        this.player10 = player10;
    }

    public String getPlayer11() {
        return player11;
    }

    public void setPlayer11(String player11) {
        this.player11 = player11;
    }

    public String getPlayer12() {
        return player12;
    }

    public void setPlayer12(String player12) {
        this.player12 = player12;
    }

    public String getPlayer13() {
        return player13;
    }

    public void setPlayer13(String player13) {
        this.player13 = player13;
    }

    public String getPlayer14() {
        return player14;
    }

    public void setPlayer14(String player14) {
        this.player14 = player14;
    }

    public String getPlayer15() {
        return player15;
    }

    public void setPlayer15(String player15) {
        this.player15 = player15;
    }

    public Integer getTcounter() {
        return tcounter;
    }

    public void setTcounter(Integer tcounter) {
        this.tcounter = tcounter;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getTransfers() {
        return transfers;
    }

    public void setTransfers(Integer transfers) {
        this.transfers = transfers;
    }

 

 
  
    

    
}
