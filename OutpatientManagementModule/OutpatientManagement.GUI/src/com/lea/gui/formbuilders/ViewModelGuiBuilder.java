/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lea.gui.formbuilders;

import com.lea.bll.viewmodels.ViewModel;
import com.lea.gui.formgroups.FormGroup;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.List;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 *
 * @author Lea
 */
public abstract class ViewModelGuiBuilder {

    public String title;
    public List<FormGroup> formGroups;
    public JPanel panel;
    public int width;
    public int height;

    public ViewModelGuiBuilder(String title, int width, int height) {
        this.title = title;
        panel = new JPanel();
        this.width = width;
        this.height = height;
        formGroups = new ArrayList<>();
    }

    public abstract void setFormGroups();

    private void drawPanel() {
        panel.setBorder(BorderFactory.createTitledBorder(title));
        panel.setPreferredSize(new Dimension(width, height));
        GridBagLayout layout = new GridBagLayout();
        panel.setLayout(layout);
        panel.setOpaque(true);
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weighty = .5;
        c.insets = new Insets(5, 20, 5, 20);
        c.gridx = 0;
        c.gridy = 0;
        for (FormGroup formGroup : formGroups) {
//            formGroup.getLabel().setPreferredSize(new Dimension(60, 30));
//            formGroup.getLabel().setAlignmentY(SwingConstants.RIGHT);
            c.weightx = 0;
            panel.add(formGroup.getLabel(), c);
            c.gridx++;
            c.weightx = 1;
            panel.add(formGroup.getComponent(), c);
            c.gridy++;
            c.gridx = 0;
        }
    }

    public JPanel getPanel() {
        setFormGroups();
        drawPanel();
        return panel;
    }

    public abstract void setModel(ViewModel viewModel);

    public abstract ViewModel getModel();

    public Boolean isValid() {
        for (FormGroup formGroup : formGroups) {
            if (!formGroup.isValid()) {
                return false;
            }
        }
        return true;
    }

    public String getErrorMessage() {
        String message = "";
        for (FormGroup formGroup : formGroups) {
            if (!formGroup.isValid()) {
                message += formGroup.getErrorMessage() + "\n";
            }
        }
        return message;
    }

}
