/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lea.gui.tables;

import com.lea.bll.datamanagers.DoctorManager;
import com.lea.bll.viewmodels.DoctorVM;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Lea
 */
public class DoctorTableModel extends AbstractTableModel {

    private final DoctorManager doctorManager;
    private final List<DoctorVM> doctors;
    
    public DoctorTableModel() {
        doctorManager = new DoctorManager();
        doctors = doctorManager.getAll();
    }
    
    @Override
    public int getRowCount() {
        return doctors.size();
    }

    @Override
    public int getColumnCount() {
        return DoctorVM.class.getDeclaredFields().length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0://id
                return doctors.get(rowIndex).getId();
            case 1://basic Details
                return doctors.get(rowIndex).getBasicDetails().getFirstName() + doctors.get(rowIndex).getBasicDetails().getLastName();
            case 2://title
                return doctors.get(rowIndex).getDoctorDetails().getTitle();
            case 3://profession
                return doctors.get(rowIndex).getDoctorDetails().getProfession();
            case 4://active
                return doctors.get(rowIndex).getDoctorDetails().isActive();
        }
        return null;
    }
    
    
    

//    @Override
//    public Class<?> getColumnClass(int columnIndex) {
//        return getValueAt(0, columnIndex).getClass();
//    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
       return false;
    }
    
}
