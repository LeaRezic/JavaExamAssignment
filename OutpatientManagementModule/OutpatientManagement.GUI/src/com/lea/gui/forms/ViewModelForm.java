/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lea.gui.forms;

import com.lea.bll.viewmodels.ViewModel;
import com.lea.gui.panelbuilders.PanelBuilderType;
import com.lea.gui.panelbuilders.ViewModelPanelBuilder;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author Lea
 */
public abstract class ViewModelForm extends JFrame {

    private JPanel contentPane;
    private JButton btnSave;
    public ViewModel viewModel;
    public List<ViewModelPanelBuilder> panelBuilders;
    public boolean actionSuccessfullyPerformed;

    public ViewModelForm(String title, ViewModel viewModel, boolean editable) {
        super(title);
        this.viewModel = viewModel;
        initComponents(editable);
        drawForm(editable);
    }

    private void initComponents(boolean editable) {
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        panelBuilders = new ArrayList<>();
        contentPane = new JPanel();
        btnSave = new JButton();
        fillPanelBuilderList();
        // event na gumbeku
        if (editable) {
            btnSave.addActionListener((ActionEvent e) -> {
                String errorMessage = "";
                for (int i = 0; i < panelBuilders.size(); i++) {
                    if (!panelBuilders.get(i).isValid()) {
                        errorMessage += panelBuilders.get(i).getErrorMessage();
                    }
                }
                if (errorMessage.equals("")) {
                    try {
                        updateViewModel();
                        saveChanges();
                        actionSuccessfullyPerformed = true;
                        exit();
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        JOptionPane.showMessageDialog(null, "An error occured while saving data\n" + ex.getMessage());
                    }
                } else {
                    JOptionPane.showMessageDialog(null, errorMessage);
                }
            });
        } else {
            btnSave.addActionListener((ActionEvent e) -> {
                exit();
            });
        }
        btnSave.setText(editable ? "Save" : "Close");
    }

    public abstract void fillPanelBuilderList();

    public abstract void updateViewModel();

    public abstract void saveChanges();

    public void exit() {
        this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
    }

    public boolean isSuccessful() {
        return actionSuccessfullyPerformed;
    }

    private void drawForm(boolean editable) {
        // content pane
        contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
        for (int i = 0; i < panelBuilders.size(); i++) {
            JPanel pnl = new JPanel();
            pnl.setBorder(new EmptyBorder(5, 5, 5, 5));
            pnl.add(panelBuilders.get(i).getPanel(editable));
            contentPane.add(pnl);
        }
        // za button
        JPanel buttonPlaceHolder = new JPanel();
        buttonPlaceHolder.setBorder(new EmptyBorder(0, 300, 50, 0));
        buttonPlaceHolder.add(btnSave);
        contentPane.add(buttonPlaceHolder);
        // postavlja content pane, odredi visinu...
        JScrollPane outerScrollPane = new JScrollPane(contentPane);
        setContentPane(outerScrollPane);
        int height = 0; //* 48;
        for (int i = 0; i < panelBuilders.size(); i++) {
            height += panelBuilders.get(i).getNumberOfFormGroups();
        }
        height *= 45;
        outerScrollPane.setPreferredSize(new Dimension(500, height));
        outerScrollPane.getVerticalScrollBar().setUnitIncrement(20);
        this.setResizable(false);
        pack();
    }

    public ViewModel getModelFromPanel(PanelBuilderType type) {
        return panelBuilders.stream()
                .filter(p -> p.getType() == type)
                .findFirst()
                .get()
                .getModel();
    }

    public abstract ViewModelFormType getFormType();

}
