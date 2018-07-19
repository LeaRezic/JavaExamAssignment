/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lea.gui.panelbuilders;

import com.lea.bll.viewmodels.LifestyleDetailsVM;
import com.lea.bll.viewmodels.ViewModel;
import com.lea.gui.formgroups.BooleanFormGroup;
import com.lea.gui.formgroups.FormGroup;
import com.lea.gui.formgroups.NumberFormGroup;
import com.lea.gui.formgroups.TextFormGroup;

/**
 *
 * @author Lea
 */
public class LifestyleDetailsPanelBuilder extends ViewModelPanelBuilder {

    private LifestyleDetailsVM viewModel;
    private FormGroup vegetarian;
    private FormGroup cigarettes;
    private FormGroup coffeeTea;
    private FormGroup alcoholicDrinks;
    private FormGroup stimulants;
    private FormGroup homeCookedFood;

    public LifestyleDetailsPanelBuilder(ViewModel viewModel) {
        super("Lifestyle", 400, 240);
        this.viewModel = (LifestyleDetailsVM) viewModel;
    }

    @Override
    public void setFormGroups() {

        vegetarian = new BooleanFormGroup("Vegetarian");
        formGroups.add(vegetarian);

        cigarettes = new NumberFormGroup("Cigarettes per day", 500);
        formGroups.add(cigarettes);

        coffeeTea = new NumberFormGroup("Cups of coffee/tea per day", 50);
        formGroups.add(coffeeTea);

        alcoholicDrinks = new NumberFormGroup("Alcoholic drinks per day", 50);
        formGroups.add(alcoholicDrinks);

        stimulants = new TextFormGroup("Stimulants used");
        formGroups.add(stimulants);

        homeCookedFood = new BooleanFormGroup("Predominantly home food");
        formGroups.add(homeCookedFood);

        if (viewModel.getId() != 0) {
            displayViewModel();
        }

    }

    @Override
    public void setModel(ViewModel viewModel) {
        this.viewModel = (LifestyleDetailsVM) viewModel;
    }

    @Override
    public ViewModel getModel() {
        viewModel.setAlcoholicDrinksPerDay((int) alcoholicDrinks.getValue());
        viewModel.setCigaretsPerDay((int) cigarettes.getValue());
        viewModel.setCoffeeTeaPerDay((int) coffeeTea.getValue());
        viewModel.setHomeCookedFood((boolean) homeCookedFood.getValue());
        viewModel.setStimulantsUsed((String) stimulants.getValue());
        viewModel.setVegetarian((boolean) vegetarian.getValue());
        return viewModel;
    }

    private void displayViewModel() {
        vegetarian.setValue(viewModel.getVegetarian());
        cigarettes.setValue(viewModel.getCigaretsPerDay());
        coffeeTea.setValue(viewModel.getCoffeeTeaPerDay());
        alcoholicDrinks.setValue(viewModel.getAlcoholicDrinksPerDay());
        stimulants.setValue(viewModel.getStimulantsUsed());
        homeCookedFood.setValue(viewModel.getHomeCookedFood());
    }

    @Override
    public PanelBuilderType getType() {
        return PanelBuilderType.LIFESTYLEDETAILS;
    }

}
