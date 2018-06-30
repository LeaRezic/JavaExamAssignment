/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lea.dal.hibernate;

import com.lea.dal.domain.entities.Doctor;
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

    @Override
    public List<Doctor> getAllDoctors() {
        List<Doctor> entityList = new ArrayList<>();

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            String currentQuery = "FROM " + "Doctor";
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
    
}
