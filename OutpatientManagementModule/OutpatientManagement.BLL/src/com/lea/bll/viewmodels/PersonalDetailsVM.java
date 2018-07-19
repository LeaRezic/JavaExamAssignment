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
public class PersonalDetailsVM extends ViewModel {

    public enum Sex {
        F, M
    }

    private int bloodTypeId;
    private int maritalStatusId;
    private Sex sex;
    private Date dateOfBirth;
    private String occupation;
    private Double height;
    private Double weight;

    public PersonalDetailsVM(int id) {
        super(id);
    }

    public int getBloodTypeId() {
        return this.bloodTypeId;
    }

    public void setBloodTypeId(int bloodTypeId) {
        this.bloodTypeId = bloodTypeId;
    }

    public int getMaritalStatusId() {
        return this.maritalStatusId;
    }

    public void setMaritalStatusId(int maritalStatusId) {
        this.maritalStatusId = maritalStatusId;
    }

    public Sex getSex() {
        return this.sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public Date getDateOfBirth() {
        return this.dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getOccupation() {
        return this.occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public Double getHeight() {
        return this.height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public Double getWeight() {
        return this.weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

}
