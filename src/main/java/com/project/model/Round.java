
package com.project.model;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity; 
import javax.persistence.Id;

@Entity(name="round")
public class Round implements Serializable {
   @Id
   private Integer id;
   
    @Column
     private Integer number;

    public Round() {
    }
    
    public Round (Integer id,Integer number) {
        super();
        this.id=id;
        this.number = number;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    
    
}
