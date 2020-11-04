package com.jsf.jpa.crud;
 
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
 
@Entity
@Table(name="doctor")
public class DoctorEntityManager {
 
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id; 
    private String name;
 
    public DoctorEntityManager() { }
 
    public int getId() {
        return id;
    }
 
    public void setId(int id) {
        this.id = id;
    }
 
    public String getName() {
        return name;
    }
 
    public void setName(String name) {
        this.name = name;
    }
}