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
public class DoctorVM extends ViewModel {
    
    public enum DoctorSpecialization {
        GENERAL_PHYSICIAN, ANESTESIOLOGIST, DERMATOLOGIST
    }
    
    private int iddoctor;
     private BasicDetailsVM basicDetails;
     private String title;
     private boolean active;

    public DoctorVM() {
    }

    public DoctorVM(int iddoctor, BasicDetailsVM basicDetails, String title, boolean active) {
        this.iddoctor = iddoctor;
        this.basicDetails = basicDetails;
        this.title = title;
        this.active = active;
    }

    public int getIddoctor() {
        return iddoctor;
    }

    public void setIddoctor(int iddoctor) {
        this.iddoctor = iddoctor;
    }

    public BasicDetailsVM getBasicDetails() {
        return basicDetails;
    }

    public void setBasicDetails(BasicDetailsVM basicDetails) {
        this.basicDetails = basicDetails;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return title + " " + basicDetails.getFirstName() + " " + basicDetails.getLastName();
    }
    
    
    
     
     
}
