/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lea.gui.forms;

import DataFields.TextDataField;
import DataLists.AddressData;
import com.lea.gui.formfields.FormField;
import javax.swing.JComponent;
import javax.swing.JFrame;
import com.lea.gui.parser.GuiDataParser;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Lea
 */
public class AddressForm extends JFrame {

    public static AddressData data;
    public static GuiDataParser parser = new GuiDataParser();

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {

                //FormField fullAddress = parser(data.getFullStreet());
                AddressForm form = new AddressForm();
                data = new AddressData();
                form.setTitle("TEST - ADDRESS");
                form.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                form.setLocationRelativeTo(null);
                form.setBounds(0, 0, 300, 300);
                GridLayout testLayout = new GridLayout(0, 2);
                form.setLayout(testLayout);

                FormField fullAddressField = parser.getFormField(data.getFullStreet());
                form.getContentPane().add(fullAddressField.getLabel());
                form.getContentPane().add(fullAddressField.getComponent());

                FormField pinCodeField = parser.getFormField(data.getPinCode());
                form.getContentPane().add(pinCodeField.getLabel());
                form.getContentPane().add(pinCodeField.getComponent());

                FormField cityField = parser.getFormField(data.getCityName());
                form.getContentPane().add(cityField.getLabel());
                form.getContentPane().add(cityField.getComponent());

                JButton btnSubmit = new JButton();
                form.getContentPane().add(btnSubmit);

                btnSubmit.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                        String message;
                        
                        ((TextDataField) data.getFullStreet()).setInputValue(((JTextField) fullAddressField.getComponent()).getText());
                        if (((TextDataField) data.getFullStreet()).isValid()) {
                            message = "Sve OKEJ!";
                        } else {
                            message = ((TextDataField) data.getFullStreet()).getErrorMessage();
                        }

                        JOptionPane.showMessageDialog(null, message);

                        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                    }

                });

                btnSubmit.setText("Add");

                form.setVisible(true);
            }
        });
    }

}
