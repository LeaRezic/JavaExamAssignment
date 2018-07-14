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
public class LifestyleDetailsVM extends ViewModel {
     private Boolean vegetarian;
     private Integer cigaretsPerDay;
     private Integer coffeeTeaPerDay;
     private Integer alcoholicDrinksPerDay;
     private String stimulantsUsed;
     private Boolean homeCookedFood;

    public LifestyleDetailsVM(int id) {
        super(id);
    }

    public LifestyleDetailsVM(int idlifestyleDetails, Boolean vegetarian, Integer cigaretsPerDay, Integer coffeeTeaPerDay, Integer alcoholicDrinksPerDay, String stimulantsUsed, Boolean homeCookedFood) {
        super(idlifestyleDetails);
        this.vegetarian = vegetarian;
        this.cigaretsPerDay = cigaretsPerDay;
        this.coffeeTeaPerDay = coffeeTeaPerDay;
        this.alcoholicDrinksPerDay = alcoholicDrinksPerDay;
        this.stimulantsUsed = stimulantsUsed;
        this.homeCookedFood = homeCookedFood;
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
