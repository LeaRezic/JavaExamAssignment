/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lea.gui.forms;

import DataFields.OptionsDataField;
import DataFields.TextDataField;
import com.lea.bll.viewmodels.DoctorVM;
import com.lea.gui.formfields.FormField;
import com.lea.gui.formfields.TextFormField;
import com.lea.gui.parser.GuiDataParser;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.swing.JFrame;

/**
 *
 * @author Lea
 */
public class DoctorForm extends JFrame {

    private static GuiDataParser dataParser;
    private static List<FormField> formFields;
    private static FormField firstNameField;
    private static FormField middleNameField;
    private static FormField lastNameField;
    private static FormField titleField;
    private static FormField isActiveField;

    public DoctorForm() {
        dataParser = new GuiDataParser();
        initFormFields(null);
    }

    public DoctorForm(DoctorVM doctor) {
        //initFormFields();
    }

    public static void main(String[] args) {

    }

    private static void initFormFields(Optional<DoctorVM> doctor) {
        formFields = new ArrayList<FormField>();
        firstNameField = (TextFormField) dataParser.getFormField(new TextDataField("First Name: ", null));
        lastNameField = (TextFormField) dataParser.getFormField(new TextDataField("Middle Name: ", null));
    }

}
