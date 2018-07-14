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

// abstraktni roditelj od bilo kojeg data managera, ako se promijeni repo,
// onda se samo ovdje ažurira o čemu je riječ
public abstract class DataManager {
    final Repository repository;

    // dohvaća default instance od repo factory-ja
    public DataManager() {
        this.repository = RepositoryFactory.GetDefaultInstace();
    }
    
    // inače, svaki data manager ima createNew, getById, insertOrUpdate
    // i privatne za konvertirat iz domenskog u viewModel i nazad
    // možda bi se to moglo s nekim đenericima?
}
