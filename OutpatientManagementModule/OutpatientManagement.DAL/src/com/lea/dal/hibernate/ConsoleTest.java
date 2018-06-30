/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lea.dal.hibernate;

import com.lea.dal.domain.entities.Doctor;
import com.lea.dal.domain.entities.EntityBase;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Lea
 */
public class ConsoleTest {

    public static void main(String[] args) {

        try {

            List<Doctor> doctors = new ArrayList<Doctor>();
            DatabaseRepository repo = new DatabaseRepository();
            doctors = repo.getAllDoctors();
            doctors.forEach(d -> System.out.println(d.getBasicDetails().getFirstName() + " " + d.getBasicDetails().getLastName()));

            Doctor testDoctor = new Doctor();
            System.out.println(testDoctor.getClass().getSimpleName());

            testDoctor = repo.getDoctorById(3);
            System.out.println(testDoctor.getTitle());

            repo.getAllPatients().forEach(p -> System.out.println(p.getBasicDetailsByBasicDetailsId().getFirstName() + " " + p.getBasicDetailsByBasicDetailsId().getLastName()));

        } catch (Exception ex) {
            System.out.println("Some damn error occured.");
        } finally {
            HibernateUtil.shutdown();
        }

    }

}
