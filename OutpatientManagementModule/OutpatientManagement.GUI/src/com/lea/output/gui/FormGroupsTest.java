/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lea.output.gui;

import com.lea.bll.datamanagers.ComplaintDetailsManager;
import com.lea.bll.viewmodels.ComplaintDetailsVM;
import com.lea.dal.hibernate.HibernateUtil;
import com.lea.gui.formbuilders.BasicDetailsGuiBuilder;
import com.lea.gui.formbuilders.ComplaintDetailsGuiBuilder;
import com.lea.gui.formbuilders.ViewModelGuiBuilder;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Lea
 */
public class FormGroupsTest extends JFrame {

    private JPanel contentPane;
    private JButton btnAdd;
//    private ViewModelGuiBuilder panelPatient;
//    private ViewModelGuiBuilder panelNextOfKin;
    private ViewModelGuiBuilder panelComplaintDetails;
    private ComplaintDetailsManager dataManager;

    public FormGroupsTest() {
        super("Testiranje - form groups");
        //setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent e) {
//                System.out.println("Uncomment following to open another window!");
//                //MainPage m = new MainPage();
//                //m.setVisible(true);
                e.getWindow().dispose();
                System.out.println("Closing the Session Factory! :D");
                HibernateUtil.shutdown();
            }
        });
        setLocationRelativeTo(null);
        initComponents();
        drawForm();

    }

    public static void main(String[] args) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new FormGroupsTest().setVisible(true);
                
            }
        });
    }

    private void initComponents() {

        contentPane = new JPanel();
        btnAdd = new JButton();
//        panelPatient = new BasicDetailsGuiBuilder("Patient");
//        panelNextOfKin = new BasicDetailsGuiBuilder("Next of kin");
        panelComplaintDetails = new ComplaintDetailsGuiBuilder();
        dataManager = new ComplaintDetailsManager();

        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String errorMessage = "";

                if (!panelComplaintDetails.isValid()) {
                    errorMessage += "Error in Complaint details";
                    errorMessage += "\n" + panelComplaintDetails.getErrorMessage();
                } else {
                    panelComplaintDetails.setModel(dataManager.createNew());
                    dataManager.saveChanges((ComplaintDetailsVM) panelComplaintDetails.getModel());
                }
                JOptionPane.showMessageDialog(null, errorMessage == "" ? "OK" : errorMessage);
            }
        });
        btnAdd.setText("Save");

//                if (!panelPatient.isValid()) {
//                    errorMessage += "Error in patient details";
//                    errorMessage += "\n" + panelPatient.getErrorMessage();
//                }
//                if (!panelNextOfKin.isValid()) {
//                    errorMessage += "\nError in next of kin details";
//                    errorMessage += "\n" + panelNextOfKin.getErrorMessage();
//                }
    }

    private void drawForm() {

        GridLayout layout = new GridLayout(0, 1);
        contentPane.setLayout(layout);
//        contentPane.add(panelPatient.getPanel());
//        contentPane.add(panelNextOfKin.getPanel());
        contentPane.add(panelComplaintDetails.getPanel());
        contentPane.add(btnAdd);
        setContentPane(contentPane);

        pack();

    }

}
