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
public class DoctorDetailsVM extends ViewModel {

    private String title;
    private int professionId;
    private boolean active;

    public DoctorDetailsVM() {
        super(0);
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

}
