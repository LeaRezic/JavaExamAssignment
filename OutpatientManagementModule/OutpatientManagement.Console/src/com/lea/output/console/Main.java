/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lea.output.console;

import com.lea.bll.datamanagers.BasicDetailsManager;
import com.lea.bll.datamanagers.DoctorManager;
import com.lea.bll.viewmodels.BasicDetailsVM;
import com.lea.bll.viewmodels.DoctorVM;
import com.lea.dal.hibernate.HibernateUtil;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Lea
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        DoctorManager doctorManager = new DoctorManager();
        List<DoctorVM> doctors = new ArrayList<DoctorVM>();
        doctors = doctorManager.getAll();
        for (DoctorVM doctor : doctors) {
            System.out.println(doctor.toString());
        }
        
        DoctorVM secondDoctor = doctorManager.getById(2);
        System.out.println(secondDoctor.toString());
        
//        BasicDetailsVM someonesDetails = new BasicDetailsManager().getById(10);
//        System.out.println(someonesDetails.toString());
        
        HibernateUtil.shutdown();
        
    }
    
}
