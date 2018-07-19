/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lea.gui.cards;

import com.lea.bll.datamanagers.DdlDataManager;
import com.lea.bll.datamanagers.EmergencyRegistrationManager;
import com.lea.bll.datamanagers.PatientManager;
import com.lea.gui.forms.EmergencyRegistrationForm;
import com.lea.gui.forms.FullRegistrationForm;
import com.lea.utilities.OptionKeyValue;
import java.text.ParseException;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

/**
 *
 * @author Lea
 */
public class RegistrationCard extends javax.swing.JPanel {

    /**
     * Creates new form RegistrationCard
     */
    private static final EmergencyRegistrationManager EMERGENCY_MANAGER = new EmergencyRegistrationManager();
    private static final PatientManager DATA_MANAGER = new PatientManager();
    private static final DdlDataManager DDL_MANAGER = new DdlDataManager();

    public RegistrationCard() {
        initComponents();
        loadDoctors();
        loadPatients();
        loadEmergencyRegistrations();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        btnAddEmergencyRegistration = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        btnAddFullRegistration = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        cbUnfinishedRegistrations = new javax.swing.JComboBox();
        btnFinishFullRegistration = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        cbDoctors = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        patientsList = new javax.swing.JList();
        btnViewRegistration = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        btnEditPatient = new javax.swing.JButton();

        setBorder(new javax.swing.border.LineBorder(new java.awt.Color(60, 61, 61), 1, true));
        setPreferredSize(new java.awt.Dimension(730, 400));

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(53, 112, 11));
        jLabel1.setText("PATIENTS");

        btnAddEmergencyRegistration.setText("Emergency Registration");
        btnAddEmergencyRegistration.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddEmergencyRegistrationActionPerformed(evt);
            }
        });

        jLabel2.setText("Start new:");

        btnAddFullRegistration.setText("Full Registration");
        btnAddFullRegistration.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddFullRegistrationActionPerformed(evt);
            }
        });

        jLabel3.setText("Choose an existing emergency registration");

        cbUnfinishedRegistrations.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnFinishFullRegistration.setText("Finish Registration");
        btnFinishFullRegistration.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFinishFullRegistrationActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(53, 112, 11));
        jLabel4.setText("Existing patient records");

        jLabel5.setText("Filter by doctor");

        cbDoctors.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbDoctors.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbDoctorsActionPerformed(evt);
            }
        });

        patientsList.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(patientsList);

        btnViewRegistration.setText("View");
        btnViewRegistration.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewRegistrationActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(53, 112, 11));
        jLabel6.setText("Create patient records");

        btnEditPatient.setText("Edit");
        btnEditPatient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditPatientActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(btnFinishFullRegistration)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel2)
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(btnAddFullRegistration, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnAddEmergencyRegistration)))
                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cbUnfinishedRegistrations, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel6)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 72, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel4)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel5)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(cbDoctors, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnEditPatient)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnViewRegistration))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(69, 69, 69))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbDoctors, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnViewRegistration)
                            .addComponent(btnEditPatient)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnAddEmergencyRegistration)
                            .addComponent(jLabel2))
                        .addGap(12, 12, 12)
                        .addComponent(btnAddFullRegistration)
                        .addGap(41, 41, 41)
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(cbUnfinishedRegistrations, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnFinishFullRegistration)))
                .addGap(0, 32, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddFullRegistrationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddFullRegistrationActionPerformed
        FullRegistrationForm form = new FullRegistrationForm(DATA_MANAGER.createNew(), true);
        form.setLocationRelativeTo(null);
        form.setVisible(true);
        form.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent e) {
                if (form.isSuccessful()) {
                    JOptionPane.showMessageDialog(null, "Added a new registration");
                }
                e.getWindow().dispose();
            }
        });
    }//GEN-LAST:event_btnAddFullRegistrationActionPerformed

    private void btnFinishFullRegistrationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFinishFullRegistrationActionPerformed
        try {
            int index = ((OptionKeyValue) cbUnfinishedRegistrations.getSelectedItem()).getKey();
            if (index == -1) {
                return;
            }
            FullRegistrationForm form = new FullRegistrationForm(DATA_MANAGER.getFromEmergencyRegistration(index), true);
            form.setLocationRelativeTo(null);
            form.setVisible(true);
            form.addWindowListener(new java.awt.event.WindowAdapter() {
                @Override
                public void windowClosing(java.awt.event.WindowEvent e) {
                    if (form.isSuccessful()) {
                        JOptionPane.showMessageDialog(null, "Finished the registration");
                        loadEmergencyRegistrations();
                        loadPatients();
                    }
                    e.getWindow().dispose();
                }
            });
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnFinishFullRegistrationActionPerformed

    private void cbDoctorsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbDoctorsActionPerformed
        resetPatientsList();
    }//GEN-LAST:event_cbDoctorsActionPerformed

    private void btnViewRegistrationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewRegistrationActionPerformed
        try {
            int index = ((OptionKeyValue) patientsList.getSelectedValue()).getKey();
            FullRegistrationForm form = new FullRegistrationForm(DATA_MANAGER.getById(index), false);
            form.setLocationRelativeTo(null);
            form.setVisible(true);
            form.addWindowListener(new java.awt.event.WindowAdapter() {
                @Override
                public void windowClosing(java.awt.event.WindowEvent e) {
                    if (form.isSuccessful()) {
                        JOptionPane.showMessageDialog(null, "Added a new registration");
                    }
                    e.getWindow().dispose();
                }
            });
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "error", JOptionPane.ERROR);
        }
    }//GEN-LAST:event_btnViewRegistrationActionPerformed

    private void btnAddEmergencyRegistrationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddEmergencyRegistrationActionPerformed
        EmergencyRegistrationForm form = new EmergencyRegistrationForm(EMERGENCY_MANAGER.createNew(), true);
        form.setLocationRelativeTo(null);
        form.setVisible(true);
        form.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent e) {
                if (form.isSuccessful()) {
                    JOptionPane.showMessageDialog(null, "Added emergency registration!");
                    loadEmergencyRegistrations();
                }
                e.getWindow().dispose();
            }
        });
    }//GEN-LAST:event_btnAddEmergencyRegistrationActionPerformed

    private void btnEditPatientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditPatientActionPerformed
        try {
            int index = ((OptionKeyValue) patientsList.getSelectedValue()).getKey();
            if (index == -1) {
                return;
            }
            FullRegistrationForm form = new FullRegistrationForm(DATA_MANAGER.getById(index), true);
            form.setLocationRelativeTo(null);
            form.setVisible(true);
            form.addWindowListener(new java.awt.event.WindowAdapter() {
                @Override
                public void windowClosing(java.awt.event.WindowEvent e) {
                    if (form.isSuccessful()) {
                        JOptionPane.showMessageDialog(null, "Updated the registration");
                        loadPatients();
                    }
                    e.getWindow().dispose();
                }
            });
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnEditPatientActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddEmergencyRegistration;
    private javax.swing.JButton btnAddFullRegistration;
    private javax.swing.JButton btnEditPatient;
    private javax.swing.JButton btnFinishFullRegistration;
    private javax.swing.JButton btnViewRegistration;
    private javax.swing.JComboBox cbDoctors;
    private javax.swing.JComboBox cbUnfinishedRegistrations;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList patientsList;
    // End of variables declaration//GEN-END:variables

    private DefaultComboBoxModel<OptionKeyValue> cbDoctorsModel;
    private DefaultComboBoxModel<OptionKeyValue> cbEmRegistrationsModel;
    private DefaultListModel<OptionKeyValue> listPatientsModel;

    private void loadDoctors() {
        cbDoctorsModel = new DefaultComboBoxModel<>();
        cbDoctorsModel.addElement(new OptionKeyValue(-1, "  - - - show all - - -"));
        DDL_MANAGER.getAllDoctors()
                .forEach((option) -> {
                    cbDoctorsModel.addElement(option);
                });
        cbDoctors.setModel(cbDoctorsModel);
    }

    private void loadPatients() {
        try {
            listPatientsModel = new DefaultListModel<>();
            DATA_MANAGER.getAll()
                    .forEach(d -> listPatientsModel.addElement(new OptionKeyValue(d.getId(), d.toString())));
            patientsList.setModel(listPatientsModel);
            if (!listPatientsModel.isEmpty()) {
                patientsList.setSelectedIndex(0);
            }
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(null, "An error occured while fetching data", "error", JOptionPane.ERROR);
        }
    }

    private void resetPatientsList() {
        try {
            int idDoctor = ((OptionKeyValue) cbDoctors.getSelectedItem()).getKey();
            if (idDoctor == -1) {
                loadPatients();
                return;
            }
            listPatientsModel = new DefaultListModel<>();
            DATA_MANAGER.getAllByDoctor(idDoctor)
                    .stream()
                    .forEach(d -> listPatientsModel.addElement(new OptionKeyValue(d.getId(), d.toString())));
            patientsList.setModel(listPatientsModel);
            if (!listPatientsModel.isEmpty()) {
                patientsList.setSelectedIndex(0);
            }
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(null, "An error occured while fetching data", "error", JOptionPane.ERROR);
        }
    }

    private void loadEmergencyRegistrations() {
        cbEmRegistrationsModel = new DefaultComboBoxModel<>();
        cbEmRegistrationsModel.addElement(new OptionKeyValue(-1, "  - - - choose - - -"));
        EMERGENCY_MANAGER.getAll()
                .stream()
                .forEach((option) -> {
                    cbEmRegistrationsModel.addElement(new OptionKeyValue(option.getId(), option.toString()));
                });
        cbUnfinishedRegistrations.setModel(cbEmRegistrationsModel);
    }

}
