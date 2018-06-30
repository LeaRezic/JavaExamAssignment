/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lea.bll.datamanagers;

import com.lea.dal.domain.repositories.Repository;
import com.lea.dal.infrastructure.RepositoryFactory;

/**
 *
 * @author Lea
 */
public abstract class DataManager {
    final Repository repository;

    public DataManager() {
        this.repository = RepositoryFactory.GetDefaultInstace();
        //this.repository = new DatabaseRepository();
    }
}
