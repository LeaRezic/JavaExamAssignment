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
public class DoctorVM extends ViewModel {
    
//    public enum DoctorSpecialization {
//        GENERAL_PHYSICIAN, ANESTESIOLOGIST, DERMATOLOGIST
//    }
    
    private int iddoctor;
     private BasicDetailsVM basicDetails;
     private DoctorDetailsVM doctorDetails;
     
     private List<String> allSpecializations;

    public DoctorVM() {
        allSpecializations = new ArrayList<>();
    }

    public DoctorVM(int iddoctor, BasicDetailsVM basicDetails, DoctorDetailsVM doctorDetails) {
        this.iddoctor = iddoctor;
        this.basicDetails = basicDetails;
        this.doctorDetails = doctorDetails;
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

    public DoctorDetailsVM getDoctorDetails() {
        return doctorDetails;
    }

    public void setDoctorDetails(DoctorDetailsVM doctorDetails) {
        this.doctorDetails = doctorDetails;
    }
    
    public List<String> getAllSpecializations() {
        return allSpecializations;
    }

    public void setAllSpecializations(List<String> allSpecializations) {
        this.allSpecializations = allSpecializations;
    }

    @Override
    public String toString() {
        return doctorDetails.getTitle() + " " + basicDetails.getLastName() + " (" + doctorDetails.getProfession() + ")";
    }
    
    
    
    
     
     
}
