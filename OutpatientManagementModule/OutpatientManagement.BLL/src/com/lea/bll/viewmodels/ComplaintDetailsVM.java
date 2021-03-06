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
public class ComplaintDetailsVM extends ViewModel {
     private String complaint;
     private String treatmentHistory;
     private String treatedAtHospital;

    public ComplaintDetailsVM(int id) {
        super(id);
    }

    public ComplaintDetailsVM(int idcomplaintDetails, String complaint, String treatmentHistory, String treatedAtHospital) {
        super(idcomplaintDetails);
        this.complaint = complaint;
        this.treatmentHistory = treatmentHistory;
        this.treatedAtHospital = treatedAtHospital;
    }

    public String getComplaint() {
        return complaint;
    }

    public void setComplaint(String complaint) {
        this.complaint = complaint;
    }

    public String getTreatmentHistory() {
        return treatmentHistory;
    }

    public void setTreatmentHistory(String treatmentHistory) {
        this.treatmentHistory = treatmentHistory;
    }

    public String getTreatedAtHospital() {
        return treatedAtHospital;
    }

    public void setTreatedAtHospital(String treatedAtHospital) {
        this.treatedAtHospital = treatedAtHospital;
    }
     
    
}
