/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lea.bll.viewmodels;

/**
 *
 * @author Lea
 */
public class LifestyleDetailsVM {
    private int idlifestyleDetails;
     private Boolean vegetarian;
     private Integer cigaretsPerDay;
     private Integer coffeeTeaPerDay;
     private Integer alcoholicDrinksPerDay;
     private String stimulantsUsed;
     private Boolean homeCookedFood;

    public LifestyleDetailsVM() {
    }

    public LifestyleDetailsVM(int idlifestyleDetails, Boolean vegetarian, Integer cigaretsPerDay, Integer coffeeTeaPerDay, Integer alcoholicDrinksPerDay, String stimulantsUsed, Boolean homeCookedFood) {
        this.idlifestyleDetails = idlifestyleDetails;
        this.vegetarian = vegetarian;
        this.cigaretsPerDay = cigaretsPerDay;
        this.coffeeTeaPerDay = coffeeTeaPerDay;
        this.alcoholicDrinksPerDay = alcoholicDrinksPerDay;
        this.stimulantsUsed = stimulantsUsed;
        this.homeCookedFood = homeCookedFood;
    }

    public int getIdlifestyleDetails() {
        return idlifestyleDetails;
    }

    public void setIdlifestyleDetails(int idlifestyleDetails) {
        this.idlifestyleDetails = idlifestyleDetails;
    }

    public Boolean getVegetarian() {
        return vegetarian;
    }

    public void setVegetarian(Boolean vegetarian) {
        this.vegetarian = vegetarian;
    }

    public Integer getCigaretsPerDay() {
        return cigaretsPerDay;
    }

    public void setCigaretsPerDay(Integer cigaretsPerDay) {
        this.cigaretsPerDay = cigaretsPerDay;
    }

    public Integer getCoffeeTeaPerDay() {
        return coffeeTeaPerDay;
    }

    public void setCoffeeTeaPerDay(Integer coffeeTeaPerDay) {
        this.coffeeTeaPerDay = coffeeTeaPerDay;
    }

    public Integer getAlcoholicDrinksPerDay() {
        return alcoholicDrinksPerDay;
    }

    public void setAlcoholicDrinksPerDay(Integer alcoholicDrinksPerDay) {
        this.alcoholicDrinksPerDay = alcoholicDrinksPerDay;
    }

    public String getStimulantsUsed() {
        return stimulantsUsed;
    }

    public void setStimulantsUsed(String stimulantsUsed) {
        this.stimulantsUsed = stimulantsUsed;
    }

    public Boolean getHomeCookedFood() {
        return homeCookedFood;
    }

    public void setHomeCookedFood(Boolean homeCookedFood) {
        this.homeCookedFood = homeCookedFood;
    }
     
     
    
}
