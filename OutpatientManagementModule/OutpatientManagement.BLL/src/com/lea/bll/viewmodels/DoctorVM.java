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

    private BasicDetailsVM basicDetails;
    private DoctorDetailsVM doctorDetails;

    //private List<String> allSpecializations;
    public DoctorVM(int iddoctor) {
        super(iddoctor);
        this.basicDetails = new BasicDetailsVM(0);
        this.doctorDetails = new DoctorDetailsVM();
        //allSpecializations = new ArrayList<>();
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

    @Override
    public String toString() {
        return doctorDetails.getTitle() + " " + basicDetails.getLastName();
    }

}
