
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

@Entity(name="myteam")
public class Myteam implements Serializable {
    
    @Id
    //  @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column
     private String mplayer1;
    @Column
     private String mplayer2;
    @Column
     private String mplayer3;
    @Column
     private String mplayer4;
    @Column
     private String mplayer5;
    @Column
     private String mplayer6;
    @Column
     private String mplayer7;
    @Column
     private String mplayer8;
    @Column
     private String mplayer9;
    @Column
     private String mplayer10;
    @Column
     private String mplayer11;
    
     @Column
     private String formation;
    
   
    
    
    public Myteam() {
    }

    public Myteam(Integer id, String mplayer1, String mplayer2, String mplayer3, String mplayer4, String mplayer5, String mplayer6, String mplayer7, String mplayer8, String mplayer9, String mplayer10, String mplayer11, String formation) {
       super();
        this.id = id;
        this.mplayer1 = mplayer1;
        this.mplayer2 = mplayer2;
        this.mplayer3 = mplayer3;
        this.mplayer4 = mplayer4;
        this.mplayer5 = mplayer5;
        this.mplayer6 = mplayer6;
        this.mplayer7 = mplayer7;
        this.mplayer8 = mplayer8;
        this.mplayer9 = mplayer9;
        this.mplayer10 = mplayer10;
        this.mplayer11 = mplayer11;
    
        this.formation = formation;
    
    }
    
   

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMplayer1() {
        return mplayer1;
    }

    public void setMplayer1(String mplayer1) {
        this.mplayer1 = mplayer1;
    }

    public String getMplayer2() {
        return mplayer2;
    }

    public void setMplayer2(String mplayer2) {
        this.mplayer2 = mplayer2;
    }

    public String getMplayer3() {
        return mplayer3;
    }

    public void setMplayer3(String mplayer3) {
        this.mplayer3 = mplayer3;
    }

    public String getMplayer4() {
        return mplayer4;
    }

    public void setMplayer4(String mplayer4) {
        this.mplayer4 = mplayer4;
    }

    public String getMplayer5() {
        return mplayer5;
    }

    public void setMplayer5(String mplayer5) {
        this.mplayer5 = mplayer5;
    }

    public String getMplayer6() {
        return mplayer6;
    }

    public void setMplayer6(String mplayer6) {
        this.mplayer6 = mplayer6;
    }

    public String getMplayer7() {
        return mplayer7;
    }

    public void setMplayer7(String mplayer7) {
        this.mplayer7 = mplayer7;
    }

    public String getMplayer8() {
        return mplayer8;
    }

    public void setMplayer8(String mplayer8) {
        this.mplayer8 = mplayer8;
    }

    public String getMplayer9() {
        return mplayer9;
    }

    public void setMplayer9(String mplayer9) {
        this.mplayer9 = mplayer9;
    }

    public String getMplayer10() {
        return mplayer10;
    }

    public void setMplayer10(String mplayer10) {
        this.mplayer10 = mplayer10;
    }

    public String getMplayer11() {
        return mplayer11;
    }

    public void setMplayer11(String mplayer11) {
        this.mplayer11 = mplayer11;
    }



    public String getFormation() {
        return formation;
    }

    public void setFormation(String formation) {
        this.formation = formation;
    }




   
    
  
    

    
}
