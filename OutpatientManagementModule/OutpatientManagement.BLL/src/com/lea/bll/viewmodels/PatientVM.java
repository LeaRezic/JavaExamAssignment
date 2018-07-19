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
public class PatientVM extends ViewModel {

    private PatientDetailsVM patientDetails;
    private BasicDetailsVM basicDetailsByNextOfKinId;
    private BasicDetailsVM basicDetailsByBasicDetailsId;
    private ComplaintDetailsVM complaintDetails;
    private LifestyleDetailsVM lifestyleDetails;
    private MedicalDetailsVM medicalDetails;
    private PersonalDetailsVM personalDetails;

    public PatientVM(int id) {
        super(id);
    }

    public PatientDetailsVM getPatientDetails() {
        return patientDetails;
    }

    public void setPatientDetails(PatientDetailsVM patientDetails) {
        this.patientDetails = patientDetails;
    }

    public BasicDetailsVM getBasicDetailsByNextOfKinId() {
        return basicDetailsByNextOfKinId;
    }

    public void setBasicDetailsByNextOfKinId(BasicDetailsVM basicDetailsByNextOfKinId) {
        this.basicDetailsByNextOfKinId = basicDetailsByNextOfKinId;
    }

    public BasicDetailsVM getBasicDetailsByBasicDetailsId() {
        return basicDetailsByBasicDetailsId;
    }

    public void setBasicDetailsByBasicDetailsId(BasicDetailsVM basicDetailsByBasicDetailsId) {
        this.basicDetailsByBasicDetailsId = basicDetailsByBasicDetailsId;
    }

    public ComplaintDetailsVM getComplaintDetails() {
        return complaintDetails;
    }

    public void setComplaintDetails(ComplaintDetailsVM complaintDetails) {
        this.complaintDetails = complaintDetails;
    }

    public LifestyleDetailsVM getLifestyleDetails() {
        return lifestyleDetails;
    }

    public void setLifestyleDetails(LifestyleDetailsVM lifestyleDetails) {
        this.lifestyleDetails = lifestyleDetails;
    }

    public MedicalDetailsVM getMedicalDetails() {
        return medicalDetails;
    }

    public void setMedicalDetails(MedicalDetailsVM medicalDetails) {
        this.medicalDetails = medicalDetails;
    }

    public PersonalDetailsVM getPersonalDetails() {
        return personalDetails;
    }

    public void setPersonalDetails(PersonalDetailsVM personalDetails) {
        this.personalDetails = personalDetails;
    }

    @Override
    public String toString() {
        return basicDetailsByBasicDetailsId.getFirstName() + " " + basicDetailsByBasicDetailsId.getLastName();
    }

}
