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
    private int professionId;
    private boolean active;
    
//    private List<String> allSpecializations;

    public DoctorDetailsVM() {
        super(0);
//        allSpecializations = new ArrayList<>();
    }

    public DoctorDetailsVM(String title, int professionId, boolean active) {
        super(0);
        this.title = title;
        this.professionId = professionId;
        this.active = active;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getProfession() {
        return professionId;
    }

    public void setProfession(int profession) {
        this.professionId = profession;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
    
//    public List<String> getAllSpecializations() {
//        return allSpecializations;
//    }
//
//    public void setAllSpecializations(List<String> allSpecializations) {
//        this.allSpecializations = allSpecializations;
//    }

}
