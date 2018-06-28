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
public class ContactInformationVM {
    public ContactInformationVM(int idcontactInformation, String telephone, String mobilePhone, String email) {
        this.idcontactInformation = idcontactInformation;
        this.telephone = telephone;
        this.mobilePhone = mobilePhone;
        this.email = email;
    }
    
    private int idcontactInformation;
     private String telephone;
     private String mobilePhone;
     private String email;

    public ContactInformationVM() {
    }

    public int getIdcontactInformation() {
        return idcontactInformation;
    }

    public void setIdcontactInformation(int idcontactInformation) {
        this.idcontactInformation = idcontactInformation;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
