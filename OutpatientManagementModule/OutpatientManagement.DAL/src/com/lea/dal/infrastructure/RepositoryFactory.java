/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lea.dal.infrastructure;

import com.lea.dal.domain.repositories.Repository;
import com.lea.dal.hibernate.DatabaseRepository;

/**
 *
 * @author Lea
 */
public final class RepositoryFactory {

    private RepositoryFactory() {
    }
    
    public static Repository GetDefaultInstace() {
        return new DatabaseRepository();
    }
    
    
    
}
