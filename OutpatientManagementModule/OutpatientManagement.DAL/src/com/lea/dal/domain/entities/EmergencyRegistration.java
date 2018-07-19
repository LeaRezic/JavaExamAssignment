package com.lea.dal.domain.entities;
// Generated 28.06.2018. 08:51:52 by Hibernate Tools 4.3.1

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * EmergencyRegistration generated by hbm2java
 */
@Entity
@Table(name = "EmergencyRegistration",
         schema = "dbo",
         catalog = "VirgoHospitals"
)
public class EmergencyRegistration implements EntityBase, java.io.Serializable {

    private int idemergencyRegistration;
    private Date registryDate;
    private boolean patientSex;
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

    public EmergencyRegistration() {
    }

    public EmergencyRegistration(int idemergencyRegistration, Date registryDate, boolean patientSex, String briefComplaint, String patientFirstName, String patientMiddleName, String patientLastName, String relativeFirstName, String relativeMiddleName, String relativeLastName, String relationshipOfRelative, String patientContact, String relativeContact) {
        this.idemergencyRegistration = idemergencyRegistration;
        this.registryDate = registryDate;
        this.patientSex = patientSex;
        this.briefComplaint = briefComplaint;
        this.patientFirstName = patientFirstName;
        this.patientMiddleName = patientMiddleName;
        this.patientLastName = patientLastName;
        this.relativeFirstName = relativeFirstName;
        this.relativeMiddleName = relativeMiddleName;
        this.relativeLastName = relativeLastName;
        this.relationshipOfRelative = relationshipOfRelative;
        this.patientContact = patientContact;
        this.relativeContact = relativeContact;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "IDEmergencyRegistration", unique = true, nullable = false)
    public int getIdemergencyRegistration() {
        return this.idemergencyRegistration;
    }

    public void setIdemergencyRegistration(int idemergencyRegistration) {
        this.idemergencyRegistration = idemergencyRegistration;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "RegistryDate", nullable = false, length = 10)
    public Date getRegistryDate() {
        return this.registryDate;
    }

    public void setRegistryDate(Date registryDate) {
        this.registryDate = registryDate;
    }

    @Column(name = "PatientSex", nullable = false)
    public boolean isPatientSex() {
        return this.patientSex;
    }

    public void setPatientSex(boolean patientSex) {
        this.patientSex = patientSex;
    }

    @Column(name = "BriefComplaint", nullable = false)
    public String getBriefComplaint() {
        return this.briefComplaint;
    }

    public void setBriefComplaint(String briefComplaint) {
        this.briefComplaint = briefComplaint;
    }

    @Column(name = "PatientFirstName", nullable = false)
    public String getPatientFirstName() {
        return this.patientFirstName;
    }

    public void setPatientFirstName(String patientFirstName) {
        this.patientFirstName = patientFirstName;
    }

    @Column(name = "PatientMiddleName", nullable = false)
    public String getPatientMiddleName() {
        return this.patientMiddleName;
    }

    public void setPatientMiddleName(String patientMiddleName) {
        this.patientMiddleName = patientMiddleName;
    }

    @Column(name = "PatientLastName", nullable = false)
    public String getPatientLastName() {
        return this.patientLastName;
    }

    public void setPatientLastName(String patientLastName) {
        this.patientLastName = patientLastName;
    }

    @Column(name = "RelativeFirstName", nullable = false)
    public String getRelativeFirstName() {
        return this.relativeFirstName;
    }

    public void setRelativeFirstName(String relativeFirstName) {
        this.relativeFirstName = relativeFirstName;
    }

    @Column(name = "RelativeMiddleName", nullable = false)
    public String getRelativeMiddleName() {
        return this.relativeMiddleName;
    }

    public void setRelativeMiddleName(String relativeMiddleName) {
        this.relativeMiddleName = relativeMiddleName;
    }

    @Column(name = "RelativeLastName", nullable = false)
    public String getRelativeLastName() {
        return this.relativeLastName;
    }

    public void setRelativeLastName(String relativeLastName) {
        this.relativeLastName = relativeLastName;
    }

    @Column(name = "RelationshipOfRelative", nullable = false)
    public String getRelationshipOfRelative() {
        return this.relationshipOfRelative;
    }

    public void setRelationshipOfRelative(String relationshipOfRelative) {
        this.relationshipOfRelative = relationshipOfRelative;
    }

    @Column(name = "PatientContact", nullable = false)
    public String getPatientContact() {
        return this.patientContact;
    }

    public void setPatientContact(String patientContact) {
        this.patientContact = patientContact;
    }

    @Column(name = "RelativeContact", nullable = false)
    public String getRelativeContact() {
        return this.relativeContact;
    }

    public void setRelativeContact(String relativeContact) {
        this.relativeContact = relativeContact;
    }

    @Override
    public int fetchEntityId() {
        return idemergencyRegistration;
    }

}
