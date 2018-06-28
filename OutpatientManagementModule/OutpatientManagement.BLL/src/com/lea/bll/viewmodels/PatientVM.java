/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lea.bll.viewmodels;

import java.util.Date;

/**
 *
 * @author Lea
 */
public class PatientVM {
    private int idpatient;
     private BasicDetailsVM basicDetailsByNextOfKinId;
     private BasicDetailsVM basicDetailsByBasicDetailsId;
     private ComplaintDetailsVM complaintDetails;
     private LifestyleDetailsVM lifestyleDetails;
     private MedicalDetailsVM medicalDetails;
     private PersonalDetailsVM personalDetails;
     private String opid;
     private Date fullRegistrationDate;
     private String nextOfKinRelationship;

    public PatientVM() {
    }

    public PatientVM(int idpatient, BasicDetailsVM basicDetailsByNextOfKinId, BasicDetailsVM basicDetailsByBasicDetailsId, ComplaintDetailsVM complaintDetails, LifestyleDetailsVM lifestyleDetails, MedicalDetailsVM medicalDetails, PersonalDetailsVM personalDetails, String opid, Date fullRegistrationDate, String nextOfKinRelationship) {
        this.idpatient = idpatient;
        this.basicDetailsByNextOfKinId = basicDetailsByNextOfKinId;
        this.basicDetailsByBasicDetailsId = basicDetailsByBasicDetailsId;
        this.complaintDetails = complaintDetails;
        this.lifestyleDetails = lifestyleDetails;
        this.medicalDetails = medicalDetails;
        this.personalDetails = personalDetails;
        this.opid = opid;
        this.fullRegistrationDate = fullRegistrationDate;
        this.nextOfKinRelationship = nextOfKinRelationship;
    }

    public int getIdpatient() {
        return idpatient;
    }

    public void setIdpatient(int idpatient) {
        this.idpatient = idpatient;
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

    public String getOpid() {
        return opid;
    }

    public void setOpid(String opid) {
        this.opid = opid;
    }

    public Date getFullRegistrationDate() {
        return fullRegistrationDate;
    }

    public void setFullRegistrationDate(Date fullRegistrationDate) {
        this.fullRegistrationDate = fullRegistrationDate;
    }

    public String getNextOfKinRelationship() {
        return nextOfKinRelationship;
    }

    public void setNextOfKinRelationship(String nextOfKinRelationship) {
        this.nextOfKinRelationship = nextOfKinRelationship;
    }
     
     
}
