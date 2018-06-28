/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lea.output.console;

import com.lea.bll.datamanagers.DoctorManager;
import com.lea.bll.viewmodels.DoctorVM;
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
        
        List<DoctorVM> doctors = new ArrayList<DoctorVM>();
        doctors = new DoctorManager().getAllDoctors();
        for (DoctorVM doctor : doctors) {
            System.out.println(doctor.toString());
        }
        
        
    }
    
}
