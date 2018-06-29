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
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Lea
 */
public class FormGroupsTest extends JFrame {

    private List<FormGroup> formGroups;
    private JPanel contentPane;
    private JButton btnAdd;

    public FormGroupsTest() {
        super("Testiranje - form groups");
        contentPane = new JPanel();
        btnAdd = new JButton();
        formGroups = new ArrayList<>();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        initComponents();
        drawForm();
    }

    public static void main(String[] args) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                FormGroupsTest form = new FormGroupsTest();
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

    }

    private void drawForm() {

        contentPane.setPreferredSize(new Dimension(400, 200));
        GridBagLayout layout = new GridBagLayout();
        contentPane.setLayout(layout);
        contentPane.setOpaque(true);
        setContentPane(contentPane);

        GridBagConstraints c = new GridBagConstraints();
        c.weightx = .8;
        c.weighty = .5;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(5, 20, 5, 20);
        c.gridx = 0;
        c.gridy = 0;

        for (FormGroup formGroup : formGroups) {
            contentPane.add(formGroup.getLabel(), c);
            c.gridx++;
            contentPane.add(formGroup.getComponent(), c);
            c.gridy++;
            c.gridx = 0;
        }
        c.gridx = 1;
        this.getContentPane().add(btnAdd, c);

        pack();

    }

    private void saveCity(String string) {
        JOptionPane.showMessageDialog(this, "Spremljen grad " + string);
    }

}
