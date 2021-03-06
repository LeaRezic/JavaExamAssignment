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
        EntityBase entity = () -> 0;
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
    public List<Patient> getAllPatientsByDoctor(int id) {
        List<Patient> patients = new ArrayList<>();
        getAllPatients().forEach(p -> p.getAppointments()
                .forEach(a -> {
                    if (a.getDoctor().getIddoctor() == id) {
                        patients.add(p);
                    }
                }));
        return patients;
    }

    @Override
    public Boolean insertOrUpdatePatient(Patient p) {
        insertOrUpdateEntity(p.getBasicDetailsByBasicDetailsId());
        insertOrUpdateEntity(p.getBasicDetailsByNextOfKinId());
        insertOrUpdateEntity(p.getComplaintDetails());
        insertOrUpdateEntity(p.getLifestyleDetails());
        insertOrUpdateEntity(p.getMedicalDetails());
        insertOrUpdateEntity(p.getPersonalDetails());
        insertOrUpdateEntity(p);
        return true;
    }

    @Override
    public Boolean insertOrUpdateDoctor(Doctor d) {
        insertOrUpdateEntity(d.getBasicDetails());
        insertOrUpdateEntity(d);
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

    private void insertOrUpdateEntity(EntityBase entity) {
        if (entity.fetchEntityId() == 0) {
            insertEntity(entity);
        } else {
            updateEntity(entity);
        }
    }

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
    public List<City> getAllCities() {
        return (List<City>) getAllEntitiesOfType(City.class.getSimpleName());
    }

    @Override
    public List<Country> getAllCountries() {
        return (List<Country>) getAllEntitiesOfType(Country.class.getSimpleName());
    }

    @Override
    public City getCityById(int id) {
        return (City) getEntityByIdOfType(City.class.getSimpleName(), id);
    }

    @Override
    public BloodType getBloodTypeById(int id) {
        return (BloodType) getEntityByIdOfType(BloodType.class.getSimpleName(), id);
    }

    @Override
    public MaritalStatus getMaritalStatusById(int id) {
        return (MaritalStatus) getEntityByIdOfType(MaritalStatus.class.getSimpleName(), id);
    }

    @Override
    public DoctorSpecialization getDoctorSpecializationById(int id) {
        return (DoctorSpecialization) getEntityByIdOfType(DoctorSpecialization.class.getSimpleName(), id);
    }

    @Override
    public Boolean insertEmergencyRegistration(EmergencyRegistration er) {
        insertOrUpdateEntity(er);
        return true;
    }

    @Override
    public void deleteEmergencyRegistration(EmergencyRegistration er) {
        deleteEntity(er);
    }

    private void deleteEntity(EntityBase entity) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.delete(entity);
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
    public HospitalService getHospitalServiceById(int id) {
        return (HospitalService) getEntityByIdOfType(HospitalService.class.getSimpleName(), id);
    }

    @Override
    public Appointment getAppointmentById(int id) {
        return (Appointment) getEntityByIdOfType(Appointment.class.getSimpleName(), id);
    }

}
