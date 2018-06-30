package com.lea.dal.domain.entities;
// Generated 28.06.2018. 08:51:52 by Hibernate Tools 4.3.1

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * BasicDetails generated by hbm2java
 */
@Entity
@Table(name = "BasicDetails",
         schema = "dbo",
         catalog = "VirgoHospitals"
)
public class BasicDetails extends EntityBase implements java.io.Serializable {

    private int idbasicDetails;
    private City city;
    private String firstName;
    private String middleName;
    private String lastName;
    private String fullStreet;
    private String pincode;
    private String telephone;
    private String mobilePhone;
    private String email;

    public BasicDetails() {
    }

    public BasicDetails(int idbasicDetails, City city, String firstName, String lastName, String fullStreet, String pincode) {
        this.idbasicDetails = idbasicDetails;
        this.city = city;
        this.firstName = firstName;
        this.lastName = lastName;
        this.fullStreet = fullStreet;
        this.pincode = pincode;
    }

    public BasicDetails(int idbasicDetails, City city, String firstName, String middleName, String lastName, String fullStreet, String pincode, String telephone, String mobilePhone, String email) {
        this.idbasicDetails = idbasicDetails;
        this.city = city;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.fullStreet = fullStreet;
        this.pincode = pincode;
        this.telephone = telephone;
        this.mobilePhone = mobilePhone;
        this.email = email;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "IDBasicDetails", unique = true, nullable = false)
    public int getIdbasicDetails() {
        return this.idbasicDetails;
    }

    public void setIdbasicDetails(int idbasicDetails) {
        this.idbasicDetails = idbasicDetails;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CityID", nullable = false)
    public City getCity() {
        return this.city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    @Column(name = "FirstName", nullable = false)
    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Column(name = "MiddleName")
    public String getMiddleName() {
        return this.middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    @Column(name = "LastName", nullable = false)
    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Column(name = "FullStreet", nullable = false)
    public String getFullStreet() {
        return this.fullStreet;
    }

    public void setFullStreet(String fullStreet) {
        this.fullStreet = fullStreet;
    }

    @Column(name = "PINcode", nullable = false)
    public String getPincode() {
        return this.pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    @Column(name = "Telephone")
    public String getTelephone() {
        return this.telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    @Column(name = "MobilePhone")
    public String getMobilePhone() {
        return this.mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    @Column(name = "Email")
    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
