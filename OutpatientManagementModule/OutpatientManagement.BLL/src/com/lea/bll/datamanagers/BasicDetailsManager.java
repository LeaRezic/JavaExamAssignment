/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lea.bll.datamanagers;

import com.lea.bll.viewmodels.BasicDetailsVM;
import com.lea.bll.viewmodels.CityVM;
import com.lea.dal.domain.entities.BasicDetails;
import com.lea.dal.domain.entities.City;

/**
 *
 * @author Lea
 */
public class BasicDetailsManager extends DataManager {

//    public BasicDetailsVM getById(int id) {
//        return convertFromEntityToViewModel(repository.getBasicDetailsById(id));
//    }

    private BasicDetailsVM convertFromEntityToViewModel(BasicDetails entity) {
        BasicDetailsVM viewModel = new BasicDetailsVM();
        viewModel.setIdbasicDetails(entity.getIdbasicDetails());
        viewModel.setFirstName(entity.getFirstName());
        viewModel.setMiddleName(entity.getMiddleName());
        viewModel.setLastName(entity.getLastName());
        
        City city = entity.getCity();
        CityVM thisCity = new CityVM();
        thisCity.setName(city.getName());
        viewModel.setCityVM(thisCity);
        
        return viewModel;
    }

}
