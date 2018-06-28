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
public class BasicDetailsVM {
    private int idperson;
     private AddressVM address;
     private ContactInformationVM contactInformation;
     private String firstName;
     private String middleName;
     private String lastName;
     private Boolean sex;
     private Date dateOfBirth;

    public BasicDetailsVM() {
    }

    public BasicDetailsVM(int idperson, AddressVM address, ContactInformationVM contactInformation, String firstName, String middleName, String lastName, Boolean sex, Date dateOfBirth) {
        this.idperson = idperson;
        this.address = address;
        this.contactInformation = contactInformation;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.sex = sex;
        this.dateOfBirth = dateOfBirth;
    }

    public int getIdperson() {
        return idperson;
    }

    public void setIdperson(int idperson) {
        this.idperson = idperson;
    }

    public AddressVM getAddress() {
        return address;
    }

    public void setAddress(AddressVM address) {
        this.address = address;
    }

    public ContactInformationVM getContactInformation() {
        return contactInformation;
    }

    public void setContactInformation(ContactInformationVM contactInformation) {
        this.contactInformation = contactInformation;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Boolean getSex() {
        return sex;
    }

    public void setSex(Boolean sex) {
        this.sex = sex;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
     
     
     
}
