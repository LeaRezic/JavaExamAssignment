/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lea.dal.hibernate;

import com.lea.dal.domain.entities.*;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.SessionFactory;

/**
 * Hibernate Utility class with a convenient method to get Session Factory
 * object.
 *
 * @author Lea
 */
public class HibernateUtil {

    private static final SessionFactory sessionFactory;

    static {
        try {
            // Create the SessionFactory from standard (hibernate.cfg.xml) 
            // config file.
            sessionFactory = new AnnotationConfiguration()
                    .configure()
                    .addAnnotatedClass(Country.class)
                    .addAnnotatedClass(City.class)
                    .addAnnotatedClass(Address.class)
                    .addAnnotatedClass(HospitalServiceCategory.class)
                    .addAnnotatedClass(HospitalService.class)
                    .addAnnotatedClass(ContactInformation.class)
                    .addAnnotatedClass(LifestyleDetails.class)
                    .addAnnotatedClass(MedicalDetails.class)
                    .addAnnotatedClass(BasicDetails.class)
                    .addAnnotatedClass(PersonalDetails.class)
                    .addAnnotatedClass(ComplaintDetails.class)
                    .addAnnotatedClass(Doctor.class)
                    .addAnnotatedClass(Patient.class)
                    .addAnnotatedClass(Appointment.class)
                    .addAnnotatedClass(AppointmentService.class)
                    .addAnnotatedClass(EmergencyRegistration.class)
                    .addAnnotatedClass(Receipt.class)
                    .buildSessionFactory();
        } catch (Throwable ex) {
            // Log the exception. 
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

//    public static void shutdown() {
//        getSessionFactory().close();
//    }
}
