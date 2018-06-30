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
public class MedicalDetailsVM extends ViewModel {
    private int idmedicalDetails;
     private String surgeriesHistory;
     private String allergiesCondition;
     private String diabeticCondition;
     private String hypertensiveCondition;
     private String cardiacCondition;
     private String respiratoryCondition;
     private String digestiveCondition;
     private String muscularCondition;
     private String neurologicalCondition;

    public MedicalDetailsVM() {
    }

    public MedicalDetailsVM(int idmedicalDetails, String surgeriesHistory, String allergiesCondition, String diabeticCondition, String hypertensiveCondition, String cardiacCondition, String respiratoryCondition, String digestiveCondition, String muscularCondition, String neurologicalCondition) {
        this.idmedicalDetails = idmedicalDetails;
        this.surgeriesHistory = surgeriesHistory;
        this.allergiesCondition = allergiesCondition;
        this.diabeticCondition = diabeticCondition;
        this.hypertensiveCondition = hypertensiveCondition;
        this.cardiacCondition = cardiacCondition;
        this.respiratoryCondition = respiratoryCondition;
        this.digestiveCondition = digestiveCondition;
        this.muscularCondition = muscularCondition;
        this.neurologicalCondition = neurologicalCondition;
    }

    public int getIdmedicalDetails() {
        return idmedicalDetails;
    }

    public void setIdmedicalDetails(int idmedicalDetails) {
        this.idmedicalDetails = idmedicalDetails;
    }

    public String getSurgeriesHistory() {
        return surgeriesHistory;
    }

    public void setSurgeriesHistory(String surgeriesHistory) {
        this.surgeriesHistory = surgeriesHistory;
    }

    public String getAllergiesCondition() {
        return allergiesCondition;
    }

    public void setAllergiesCondition(String allergiesCondition) {
        this.allergiesCondition = allergiesCondition;
    }

    public String getDiabeticCondition() {
        return diabeticCondition;
    }

    public void setDiabeticCondition(String diabeticCondition) {
        this.diabeticCondition = diabeticCondition;
    }

    public String getHypertensiveCondition() {
        return hypertensiveCondition;
    }

    public void setHypertensiveCondition(String hypertensiveCondition) {
        this.hypertensiveCondition = hypertensiveCondition;
    }

    public String getCardiacCondition() {
        return cardiacCondition;
    }

    public void setCardiacCondition(String cardiacCondition) {
        this.cardiacCondition = cardiacCondition;
    }

    public String getRespiratoryCondition() {
        return respiratoryCondition;
    }

    public void setRespiratoryCondition(String respiratoryCondition) {
        this.respiratoryCondition = respiratoryCondition;
    }

    public String getDigestiveCondition() {
        return digestiveCondition;
    }

    public void setDigestiveCondition(String digestiveCondition) {
        this.digestiveCondition = digestiveCondition;
    }

    public String getMuscularCondition() {
        return muscularCondition;
    }

    public void setMuscularCondition(String muscularCondition) {
        this.muscularCondition = muscularCondition;
    }

    public String getNeurologicalCondition() {
        return neurologicalCondition;
    }

    public void setNeurologicalCondition(String neurologicalCondition) {
        this.neurologicalCondition = neurologicalCondition;
    }
     
     
}
