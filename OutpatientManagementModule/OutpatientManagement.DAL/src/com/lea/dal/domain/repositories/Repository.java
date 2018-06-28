/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lea.dal.domain.repositories;

import com.lea.dal.domain.entities.Doctor;
import java.util.List;

/**
 *
 * @author Lea
 */
public interface Repository {
    public List<Doctor> getAllDoctors();
}
