/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lea.bll.datamanagers;

import com.lea.bll.viewmodels.LifestyleDetailsVM;
import com.lea.dal.domain.entities.LifestyleDetails;

/**
 *
 * @author Lea
 */
public class LifestyleDetailsManager extends DataManager {
    
    public LifestyleDetailsVM createNew() {
        LifestyleDetailsVM viewModel = new LifestyleDetailsVM();
        viewModel.setIdlifestyleDetails(0);
        return viewModel;
    }
    
    public LifestyleDetailsVM convertFromEntityToViewModel(LifestyleDetails entity) {
        LifestyleDetailsVM viewModel = createNew();
        viewModel.setIdlifestyleDetails(entity.getIdlifestyleDetails());
        viewModel.setAlcoholicDrinksPerDay(entity.getAlcoholicDrinksPerDay());
        viewModel.setCigaretsPerDay(entity.getCigaretsPerDay());
        viewModel.setCoffeeTeaPerDay(entity.getCigaretsPerDay());
        viewModel.setHomeCookedFood(entity.getHomeCookedFood());
        viewModel.setStimulantsUsed(entity.getStimulantsUsed());
        viewModel.setVegetarian(entity.getVegetarian());
        return viewModel;
    }
    
    public LifestyleDetails convertFromViewModelToEntity(LifestyleDetailsVM viewModel) {
        LifestyleDetails entity = new LifestyleDetails();
        entity.setIdlifestyleDetails(0);
        entity.setAlcoholicDrinksPerDay(viewModel.getAlcoholicDrinksPerDay());
        entity.setCigaretsPerDay(viewModel.getCigaretsPerDay());
        entity.setCoffeeTeaPerDay(viewModel.getCoffeeTeaPerDay());
        entity.setHomeCookedFood(viewModel.getHomeCookedFood());
        entity.setStimulantsUsed(viewModel.getStimulantsUsed());
        entity.setVegetarian(viewModel.getVegetarian());
        return entity;
    }
    
}
