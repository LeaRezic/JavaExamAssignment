/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lea.gui.forms;

import com.lea.dal.hibernate.HibernateUtil;
import com.lea.gui.cards.AppointmentCard;
import com.lea.gui.cards.DoctorCard;
import com.lea.gui.cards.RegistrationCard;
import com.lea.gui.cards.StatisticsCard;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author Lea
 */
public class OutpatientManagementGuiApp extends JFrame {

    private JPanel contentPane;
    // side panel container and buttons
    private JPanel sideMenuPanel;
    private JButton patientButton;
    private JButton doctorButton;
    private JButton appointmentButton;
    private JButton statisticsButton;
    // other properties -  center content and footer label
    private JPanel mainContent;
    private JLabel footerLabel;
    // card za doktore
    private DoctorCard cardDoctor;
    private RegistrationCard cardRegistration;
    private StatisticsCard cardStatistics;
    private AppointmentCard cardAppointment;
    // images
    private static final String[] IMAGES = {"resources/first-aid.png", "resources/patient_gray.png", "resources/patient_green.png",
        "resources/doctor_gray.png", "resources/doctor_green.png", "resources/appointment_gray.png",
        "resources/appointment_green.png", "resources/report_gray.png", "resources/report_green.png"};
    private static final List<ImageIcon> IMAGE_ICONS = new ArrayList<>();

    public OutpatientManagementGuiApp() {
        super("Outpatient Management");
        loadImages();
        configureFrame();
        initComponents();
        drawFrame();
    }

    private void loadImages() {
        for (String image : IMAGES) {
            IMAGE_ICONS.add(new ImageIcon(getClass().getClassLoader().getResource(image)));
        }
    }

    private void configureFrame() {
        this.setSize(900, 500);
        this.setResizable(false);
        this.setIconImage(IMAGE_ICONS.get(0).getImage());
        this.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent e) {
                e.getWindow().dispose();
                System.out.println("Closing the Session Factory (if used)! :)");
                HibernateUtil.shutdown();
            }
        });
    }

    private void initComponents() {
        // content pane and menu bar
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(20, 20, 5, 20));
        // side navigation
        loadWestMenu();
        // main content
        mainContent = new JPanel();
        mainContent.setLayout(new CardLayout());
        // footer label
        loadFooterLabel();
        // za doctor card
        loadCards();
    }

    private void drawFrame() {
        // setting the layout and content pane
        BorderLayout layout = new BorderLayout();
        contentPane.setLayout(layout);
        this.setContentPane(contentPane);
        // adding content to the contentPane
        contentPane.add(footerLabel, BorderLayout.SOUTH);
        contentPane.add(sideMenuPanel, BorderLayout.WEST);
        contentPane.add(mainContent, BorderLayout.CENTER);

    }

    private void loadWestMenu() {
        // side navigation menu
        sideMenuPanel = new JPanel();
        sideMenuPanel.setBorder(new EmptyBorder(0, 0, 0, 20));
        sideMenuPanel.setLayout(new GridLayout(4, 1, 0, 0));
        // gumbeki za side menu
        
        patientButton = new JButton();
        configButton(patientButton, 1, "Manage patient records", "patients");
        
        doctorButton = new JButton();
        configButton(doctorButton, 3, "Manage doctors", "doctors");
        
        appointmentButton = new JButton();
        configButton(appointmentButton, 5, "Manage appointments", "appointments");
        
        statisticsButton = new JButton();
        configButton(statisticsButton, 7, "View reports", "statistics");
        
        sideMenuPanel.add(patientButton);
        sideMenuPanel.add(doctorButton);
        sideMenuPanel.add(appointmentButton);
        sideMenuPanel.add(statisticsButton);
    }

    private void configButton(JButton btn, int imageIndex, String toolTipText, String cardAction) {
        btn.setPreferredSize(new Dimension(70, 50));
        btn.setIcon(IMAGE_ICONS.get(imageIndex));
        btn.setRolloverIcon(IMAGE_ICONS.get(++imageIndex));
        btn.setBorder(null);
        btn.setFocusPainted(false);
        btn.setContentAreaFilled(false);
        btn.setToolTipText(toolTipText);
        btn.addActionListener((ActionEvent e) -> {
            CardLayout cl = (CardLayout)(mainContent.getLayout());
            cl.show(mainContent, cardAction);
        });
    }

    private void loadFooterLabel() {
        footerLabel = new JLabel(" © VIRGO HOSPITALS - Outpatient Management");
        footerLabel.setBorder(new EmptyBorder(10, 0, 0, 0));
        footerLabel.setForeground(new Color(53, 112, 11));
    }

    private void loadCards() {
        cardRegistration = new RegistrationCard();
        mainContent.add(cardRegistration, "patients");
        cardDoctor = new DoctorCard();
        mainContent.add(cardDoctor, "doctors");
        cardAppointment = new AppointmentCard();
        mainContent.add(cardAppointment, "appointments");
        cardStatistics = new StatisticsCard();
        mainContent.add(cardStatistics, "statistics");
    }

}
