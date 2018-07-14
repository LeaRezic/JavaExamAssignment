/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lea.gui.forms;

import com.lea.bll.datamanagers.DoctorManager;
import com.lea.bll.viewmodels.BasicDetailsVM;
import com.lea.bll.viewmodels.DoctorDetailsVM;
import com.lea.bll.viewmodels.DoctorVM;
import com.lea.gui.panelbuilders.BasicDetailsPanelBuilder;
import com.lea.gui.panelbuilders.DoctorDetailsPanelBuilder;
import com.lea.gui.panelbuilders.ViewModelPanelBuilder;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author Lea
 */
public class DoctorForm extends JFrame {

    private JPanel contentPane;
    private JButton btnAdd;
    private ViewModelPanelBuilder basicDetailsPanelBuilder;
    private ViewModelPanelBuilder doctorPanelBuilder;

    public boolean actionSuccessfullyPerformed;

//    public DoctorForm() {
//        super("Testiranje - DOCTOR INSERT ");
//        initComponents();
//        drawForm();
//    }
    public DoctorForm(DoctorVM doctor) {
        super("Testiranje - DOCTOR INSERT ");
        actionSuccessfullyPerformed = false;
        initComponents(doctor);
        drawForm();
    }

    private void initComponents(DoctorVM doctor) {
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        contentPane = new JPanel();
        btnAdd = new JButton();
        doctorPanelBuilder = new DoctorDetailsPanelBuilder(doctor.getDoctorDetails());
        //doctorPanelBuilder.setModel(doctor.getDoctorDetails());
        basicDetailsPanelBuilder = new BasicDetailsPanelBuilder(doctor.getBasicDetails());
        //basicDetailsPanelBuilder.setModel(doctor.getBasicDetails());

        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String errorMessage = "";

                if (!basicDetailsPanelBuilder.isValid()) {
                    errorMessage += "Error in Basic details";
                    errorMessage += "\n" + basicDetailsPanelBuilder.getErrorMessage();
                    JOptionPane.showMessageDialog(null, errorMessage.equals("") ? "OK" : errorMessage);
                } else {
                    doctor.setBasicDetails((BasicDetailsVM) basicDetailsPanelBuilder.getModel());
                    doctor.setDoctorDetails((DoctorDetailsVM) doctorPanelBuilder.getModel());
                    new DoctorManager().saveChanges((doctor));
                    actionSuccessfullyPerformed = true;
                    exit();
                }
                //JOptionPane.showMessageDialog(null, errorMessage.equals("") ? "OK" : errorMessage);

            }
        });
        btnAdd.setText("Save");
    }

    public void exit() {
        this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
    }

    public boolean isSuccessful() {
        return actionSuccessfullyPerformed;
    }

    private void drawForm() {

        FlowLayout layout = new FlowLayout();

        contentPane.setLayout(layout);

        contentPane.add(basicDetailsPanelBuilder.getPanel());
        contentPane.add(doctorPanelBuilder.getPanel());

        JPanel buttonPlaceHolder = new JPanel();
        buttonPlaceHolder.setBorder(new EmptyBorder(0, 300, 0, 0));
        buttonPlaceHolder.add(btnAdd);
        contentPane.add(buttonPlaceHolder);
        setContentPane(contentPane);
        int height = (basicDetailsPanelBuilder.getNumberOfFormGroups() + doctorPanelBuilder.getNumberOfFormGroups()) * 48;
        contentPane.setPreferredSize(new Dimension(450, height));
        this.setResizable(false);
        pack();

    }

}
