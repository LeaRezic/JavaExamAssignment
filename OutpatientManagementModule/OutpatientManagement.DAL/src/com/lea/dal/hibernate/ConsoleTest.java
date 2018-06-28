/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lea.dal.hibernate;

import com.lea.dal.domain.entities.Doctor;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Lea
 */
public class ConsoleTest {
    public static void main(String[] args) {
        List<Doctor> doctors = new ArrayList<Doctor>();
        DatabaseRepository repo = new DatabaseRepository();
        doctors = repo.getAllDoctors();
        doctors.forEach(d->System.out.println(d.getBasicDetails().getFirstName() + " " + d.getBasicDetails().getLastName()));
        
        
    }
    
    
}
