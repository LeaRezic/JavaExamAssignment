/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lea.bll.viewmodels;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Lea
 */
public class DoctorDetailsVM extends ViewModel {

    private String title;
    private String profession;
    private boolean active;
    
    private List<String> allSpecializations;

    public DoctorDetailsVM() {
        allSpecializations = new ArrayList<>();
    }

    public DoctorDetailsVM(String title, String profession, boolean active) {
        this.title = title;
        this.profession = profession;
        this.active = active;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
    
    public List<String> getAllSpecializations() {
        return allSpecializations;
    }

    public void setAllSpecializations(List<String> allSpecializations) {
        this.allSpecializations = allSpecializations;
    }

}
