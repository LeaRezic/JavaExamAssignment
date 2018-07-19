/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lea.bll.viewmodels;

import com.lea.utilities.DateConverter;
import java.util.Date;

/**
 *
 * @author Lea
 */
public class EmergencyRegistrationVM extends ViewModel {

    public enum Sex {
        F, M
    }

    private Date registryDate;
    private Sex patientSex;
    private String briefComplaint;
    private String patientFirstName;
    private String patientMiddleName;
    private String patientLastName;
    private String relativeFirstName;
    private String relativeMiddleName;
    private String relativeLastName;
    private String relationshipOfRelative;
    private String patientContact;
    private String relativeContact;

    public EmergencyRegistrationVM(int id) {
        super(id);
    }

    public Date getRegistryDate() {
        return registryDate;
    }

    public void setRegistryDate(Date registryDate) {
        this.registryDate = registryDate;
    }

    public Sex getPatientSex() {
        return patientSex;
    }

    public void setPatientSex(Sex patientSex) {
        this.patientSex = patientSex;
    }

    public String getBriefComplaint() {
        return briefComplaint;
    }

    public void setBriefComplaint(String briefComplaint) {
        this.briefComplaint = briefComplaint;
    }

    public String getPatientFirstName() {
        return patientFirstName;
    }

    public void setPatientFirstName(String patientFirstName) {
        this.patientFirstName = patientFirstName;
    }

    public String getPatientMiddleName() {
        return patientMiddleName;
    }

    public void setPatientMiddleName(String patientMiddleName) {
        this.patientMiddleName = patientMiddleName;
    }

    public String getPatientLastName() {
        return patientLastName;
    }

    public void setPatientLastName(String patientLastName) {
        this.patientLastName = patientLastName;
    }

    public String getRelativeFirstName() {
        return relativeFirstName;
    }

    public void setRelativeFirstName(String relativeFirstName) {
        this.relativeFirstName = relativeFirstName;
    }

    public String getRelativeMiddleName() {
        return relativeMiddleName;
    }

    public void setRelativeMiddleName(String relativeMiddleName) {
        this.relativeMiddleName = relativeMiddleName;
    }

    public String getRelativeLastName() {
        return relativeLastName;
    }

    public void setRelativeLastName(String relativeLastName) {
        this.relativeLastName = relativeLastName;
    }

    public String getRelationshipOfRelative() {
        return relationshipOfRelative;
    }

    public void setRelationshipOfRelative(String relationshipOfRelative) {
        this.relationshipOfRelative = relationshipOfRelative;
    }

    public String getPatientContact() {
        return patientContact;
    }

    public void setPatientContact(String patientContact) {
        this.patientContact = patientContact;
    }

    public String getRelativeContact() {
        return relativeContact;
    }

    public void setRelativeContact(String relativeContact) {
        this.relativeContact = relativeContact;
    }

    @Override
    public String toString() {
        return DateConverter.getStringFromDate(registryDate) + ", " + getPatientFirstName() + " " + getPatientLastName();
    }

}
