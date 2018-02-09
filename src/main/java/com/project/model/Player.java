
package com.project.model;
import java.io.Serializable;
import java.sql.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity; 
import javax.persistence.GeneratedValue; 
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity(name="player")
public class Player implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column
    private String firstname;
    @Column
     private String lastname;
    @Column
     private Date date_birth;
    @Column
     private String position;
    @Column
     private String club;
    @Column
     private Integer price;

    @OneToMany (mappedBy="player")
    private List<Playerpoints> playerpoint;
    
   
    
  
    
 
    
    
    public Player() {
    }

    public Player(Integer id, String firstname, String lastname, Date date_birth, String position, Integer price) {
         super();
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.date_birth = date_birth;
        this.position = position;
        this.club = club;
        this.price = price;
    }
    
   

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Date getDate_birth() {
        return date_birth;
    }

    public void setDate_birth(Date date_birth) {
        this.date_birth = date_birth;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getClub() {
        return club;
    }

    public void setClub(String club) {
        this.club = club;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public List<Playerpoints> getPlayerpoint() {
        return playerpoint;
    }

    public void setPlayerpoint(List<Playerpoints> playerpoint) {
        this.playerpoint = playerpoint;
    }

   

    
}
