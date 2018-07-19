/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lea.output.console;

import com.lea.bll.datamanagers.DoctorManager;
import com.lea.bll.datamanagers.PatientManager;
import com.lea.bll.viewmodels.DoctorVM;
import com.lea.bll.viewmodels.PatientVM;
import com.lea.dal.hibernate.HibernateUtil;
import java.text.ParseException;

/**
 *
 * @author Lea
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        HibernateUtil.getSessionFactory();
        printGap(50);

        System.out.println("LISTNG ALL DOCTORS");
        for (DoctorVM doctor : new DoctorManager().getAll()) {
            System.out.println(doctor.toString());
        }

        printGap(1);

        System.out.println("LISTNG ALL PATIENTS");
        try {
            for (PatientVM patient : new PatientManager().getAll()) {
                System.out.println(patient.toString());
            }
        } catch (ParseException ex) {
            System.out.println("An error occured while parsing data.");
        }
        
        HibernateUtil.shutdown();
    }

    public static void printGap(int n) {
        for (int i = 0; i < n; i++) {
            System.out.println("\n");
        }
    }

}
