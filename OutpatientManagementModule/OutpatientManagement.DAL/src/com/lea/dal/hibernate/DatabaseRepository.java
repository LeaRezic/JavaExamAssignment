/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lea.dal.hibernate;

import com.lea.dal.domain.entities.*;
import com.lea.dal.domain.repositories.Repository;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Lea
 */
public class DatabaseRepository implements Repository {

    private List<?> getAllEntitiesOfType(String className) {
        List<?> entityList = new ArrayList<>();
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            String currentQuery = "FROM " + className;
            entityList = session.createQuery(currentQuery).list();
            tx.commit();
        } catch (HibernateException ex) {
            if (tx != null) {
                tx.rollback();
            }
            ex.printStackTrace();
        } finally {
            session.close();
        }
        return entityList;
    }

    private EntityBase getEntityByIdOfType(String className, int id) {
        EntityBase entity = new EntityBase();
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            String currentQuery = "FROM " + className + " WHERE id = " + id;
            entity = (EntityBase) session.createQuery(currentQuery).list().iterator().next();
            tx.commit();
        } catch (HibernateException ex) {
            if (tx != null) {
                tx.rollback();
            }
            ex.printStackTrace();
        } finally {
            session.close();
        }
        return entity;
    }

    @Override
    public Doctor getDoctorById(int id) {
        return (Doctor) getEntityByIdOfType(Doctor.class.getSimpleName(), id);
    }
    
    @Override
    public List<Doctor> getAllDoctors() {
        return (ArrayList<Doctor>) getAllEntitiesOfType(Doctor.class.getSimpleName());
    }

    @Override
    public Patient getPatientById(int id) {
        return (Patient) getEntityByIdOfType(Patient.class.getSimpleName(), id);
    }

    @Override
    public List<Patient> getAllPatients() {
        return (ArrayList<Patient>) getAllEntitiesOfType(Patient.class.getSimpleName());
    }

    @Override
    public Boolean insertOrUpdatePatient(Patient p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    

    @Override
    public Boolean insertOrUpdateDoctor(Doctor d) {
        
        if (d.getIddoctor() == 0) {
            int basicDetailsId = insertEntity(d.getBasicDetails());
            d.setBasicDetails((BasicDetails) getEntityByIdOfType(BasicDetails.class.getSimpleName(),basicDetailsId));
            insertEntity(d);
        }
        return true;
        
    }

    @Override
    public List<MaritalStatus> getAllMaritalStatuses() {
        return (ArrayList<MaritalStatus>) getAllEntitiesOfType(MaritalStatus.class.getSimpleName());
    }

    @Override
    public List<DoctorSpecialization> getAllDoctorSpecializations() {
        return (ArrayList<DoctorSpecialization>) getAllEntitiesOfType(DoctorSpecialization.class.getSimpleName());
    }

    @Override
    public List<BloodType> getAllBloodTypes() {
        return (ArrayList<BloodType>) getAllEntitiesOfType(BloodType.class.getSimpleName());
    }

    @Override
    public List<Appointment> getAllAppointments() {
        return (ArrayList<Appointment>) getAllEntitiesOfType(Appointment.class.getSimpleName());
    }

    @Override
    public Boolean insertOrUpdateAppointment() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public EmergencyRegistration getEmergencyRegistrationById(int id) {
        return (EmergencyRegistration) getEntityByIdOfType(EmergencyRegistration.class.getSimpleName(), id);
    }

    @Override
    public List<EmergencyRegistration> getAllEmeregencyRegistrations() {
        return (ArrayList<EmergencyRegistration>) getAllEntitiesOfType(EmergencyRegistration.class.getSimpleName());
    }

    @Override
    public List<HospitalService> getAllHospitalServices() {
        return (List<HospitalService>) getAllEntitiesOfType(HospitalService.class.getSimpleName());
    }

//    private int insertEntity(EntityBase entity) {
//        int newId = -1;
//        Session session = HibernateUtil.getSessionFactory().openSession();
//        Transaction tx = null;
//        try {
//            tx = session.beginTransaction();
//            newId = (int) session.save(entity);
//            tx.commit();
//        } catch (HibernateException ex) {
//            if (tx != null) {
//                tx.rollback();
//            }
//            ex.printStackTrace();
//        } finally {
//            session.close();
//        }
//        return newId;
//    }
    
    private int insertEntity(EntityBase entity) {
        int newId = -1;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            newId = (int) session.save(entity);
            tx.commit();
        } catch (HibernateException ex) {
            if (tx != null) {
                tx.rollback();
            }
            ex.printStackTrace();
        } finally {
            session.close();
        }
        return newId;
    }
    
    private void updateEntity(EntityBase entity) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.update(entity);
            tx.commit();
        } catch (HibernateException ex) {
            if (tx != null) {
                tx.rollback();
            }
            ex.printStackTrace();
        } finally {
            session.close();
        }
    }

    @Override
    public void insertOrUpdateComplaintDetails(ComplaintDetails cd) {

        if (cd.getIdcomplaintDetails() == 0) {
            insertEntity(cd);
        } else {
            updateEntity(cd);
        }
        
    }

    @Override
    public List<City> getAllCities() {
        return (List<City>) getAllEntitiesOfType(City.class.getSimpleName());
    }

    @Override
    public List<Country> getAllCountries() {
        return (List<Country>) getAllEntitiesOfType(Country.class.getSimpleName());
    }

}
