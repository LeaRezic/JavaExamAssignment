package com.lea.dal.domain.entities;
// Generated 28.06.2018. 08:51:52 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * LifestyleDetails generated by hbm2java
 */
@Entity
@Table(name="LifestyleDetails"
    ,schema="dbo"
    ,catalog="VirgoHospitals"
)
public class LifestyleDetails  implements java.io.Serializable {


     private int idlifestyleDetails;
     private Boolean vegetarian;
     private Integer cigaretsPerDay;
     private Integer coffeeTeaPerDay;
     private Integer alcoholicDrinksPerDay;
     private String stimulantsUsed;
     private Boolean homeCookedFood;
     private Set<Patient> patients = new HashSet<Patient>(0);

    public LifestyleDetails() {
    }

	
    public LifestyleDetails(int idlifestyleDetails) {
        this.idlifestyleDetails = idlifestyleDetails;
    }
    public LifestyleDetails(int idlifestyleDetails, Boolean vegetarian, Integer cigaretsPerDay, Integer coffeeTeaPerDay, Integer alcoholicDrinksPerDay, String stimulantsUsed, Boolean homeCookedFood, Set<Patient> patients) {
       this.idlifestyleDetails = idlifestyleDetails;
       this.vegetarian = vegetarian;
       this.cigaretsPerDay = cigaretsPerDay;
       this.coffeeTeaPerDay = coffeeTeaPerDay;
       this.alcoholicDrinksPerDay = alcoholicDrinksPerDay;
       this.stimulantsUsed = stimulantsUsed;
       this.homeCookedFood = homeCookedFood;
       this.patients = patients;
    }
   
     @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="IDLifestyleDetails", unique=true, nullable=false)
    public int getIdlifestyleDetails() {
        return this.idlifestyleDetails;
    }
    
    public void setIdlifestyleDetails(int idlifestyleDetails) {
        this.idlifestyleDetails = idlifestyleDetails;
    }

    
    @Column(name="Vegetarian")
    public Boolean getVegetarian() {
        return this.vegetarian;
    }
    
    public void setVegetarian(Boolean vegetarian) {
        this.vegetarian = vegetarian;
    }

    
    @Column(name="CigaretsPerDay")
    public Integer getCigaretsPerDay() {
        return this.cigaretsPerDay;
    }
    
    public void setCigaretsPerDay(Integer cigaretsPerDay) {
        this.cigaretsPerDay = cigaretsPerDay;
    }

    
    @Column(name="CoffeeTeaPerDay")
    public Integer getCoffeeTeaPerDay() {
        return this.coffeeTeaPerDay;
    }
    
    public void setCoffeeTeaPerDay(Integer coffeeTeaPerDay) {
        this.coffeeTeaPerDay = coffeeTeaPerDay;
    }

    
    @Column(name="AlcoholicDrinksPerDay")
    public Integer getAlcoholicDrinksPerDay() {
        return this.alcoholicDrinksPerDay;
    }
    
    public void setAlcoholicDrinksPerDay(Integer alcoholicDrinksPerDay) {
        this.alcoholicDrinksPerDay = alcoholicDrinksPerDay;
    }

    
    @Column(name="StimulantsUsed")
    public String getStimulantsUsed() {
        return this.stimulantsUsed;
    }
    
    public void setStimulantsUsed(String stimulantsUsed) {
        this.stimulantsUsed = stimulantsUsed;
    }

    
    @Column(name="HomeCookedFood")
    public Boolean getHomeCookedFood() {
        return this.homeCookedFood;
    }
    
    public void setHomeCookedFood(Boolean homeCookedFood) {
        this.homeCookedFood = homeCookedFood;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="lifestyleDetails")
    public Set<Patient> getPatients() {
        return this.patients;
    }
    
    public void setPatients(Set<Patient> patients) {
        this.patients = patients;
    }




}


