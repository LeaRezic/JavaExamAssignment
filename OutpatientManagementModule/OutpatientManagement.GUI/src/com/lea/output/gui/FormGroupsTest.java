/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lea.output.gui;

import com.lea.gui.formgroups.FormGroup;
import com.lea.gui.formgroups.NumberFormGroup;
import com.lea.gui.formgroups.OptionFormGroup;
import com.lea.gui.formgroups.TextFormGroup;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Lea
 */
public class FormGroupsTest extends JFrame {

    private List<FormGroup> formGroups;

    public FormGroupsTest() {
        formGroups = new ArrayList<>();
        initForm();
        initComponents();
    }

    public static void main(String[] args) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                FormGroupsTest form = new FormGroupsTest();
                form.setLocationRelativeTo(null);
                form.setVisible(true);
            }
        });

    }

    private void initComponents() {
        // TEST
        FormGroup cityName = new TextFormGroup("City");
        formGroups.add(cityName);
        FormGroup stateName = new TextFormGroup("State");
        formGroups.add(stateName);
        FormGroup countryName = new TextFormGroup("Country");
        formGroups.add(countryName);
        FormGroup streetNumber = new NumberFormGroup("Street Number", 10);
        formGroups.add(streetNumber);
        List<String> someCountries = new ArrayList<>();
        someCountries.add("Prva Država");
        someCountries.add("Druga Država");
        someCountries.add("Treća Država");
        FormGroup drzavaDdl = new OptionFormGroup("Choose a country", someCountries);
        formGroups.add(drzavaDdl);

        for (FormGroup formGroup : formGroups) {
            this.getContentPane().add(formGroup.getLabel());
            this.getContentPane().add(formGroup.getComponent());
        }

//        this.getContentPane().add(cityName.getLabel());
//        this.getContentPane().add(cityName.getComponent());
        JButton btnAdd = new JButton();
        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String message = "";
                for (FormGroup formGroup : formGroups) {
                    if (!formGroup.isValid()) {
                        message += formGroup.getErrorMessage() + "\n";
                    }
                }
                if (message.compareTo("") == 0) {
                    saveCity((String) cityName.getValue());
                } else {
                    JOptionPane.showMessageDialog(null, message, "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        btnAdd.setText("Save");
        this.getContentPane().add(btnAdd);
    }

    private void initForm() {
        this.setTitle("Add city - TEST");
        this.setLayout(new GridLayout(0, 2));
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setBounds(50, 50, 300, 150);
    }

    private void saveCity(String string) {
        JOptionPane.showMessageDialog(this, "Spremljen grad " + string);
    }

}
