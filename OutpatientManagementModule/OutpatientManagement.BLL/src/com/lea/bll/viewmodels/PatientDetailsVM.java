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
public class PatientDetailsVM extends ViewModel {

    private String opid;
    private Date fullRegistrationDate;
    private String nextOfKinRelationship;

    public PatientDetailsVM() {
        super(0);
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
