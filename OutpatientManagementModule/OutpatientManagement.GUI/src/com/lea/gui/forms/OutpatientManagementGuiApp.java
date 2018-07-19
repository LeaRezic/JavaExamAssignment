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
    private DoctorCard doctorsCard;
    private RegistrationCard registrationsCard;
    private StatisticsCard statisticsCard;
    private AppointmentCard appointmentsCard;
    // images

    private enum AppIcon {
        LOGO("resources/first-aid.png"),
        PATIENT_GRAY("resources/patient_gray.png"),
        PATIENT_GREEN("resources/patient_green.png"),
        DOCTOR_GRAY("resources/doctor_gray.png"),
        DOCTOR_GREEN("resources/doctor_green.png"),
        APPOINTMENT_GRAY("resources/appointment_gray.png"),
        APPOINTMENT_GREEN("resources/appointment_green.png"),
        STATISTICS_GRAY("resources/report_gray.png"),
        STATISTICS_GREEN("resources/report_green.png");

        private final String resourcePath;

        private AppIcon(String resourcePath) {
            this.resourcePath = resourcePath;
        }

        public ImageIcon getImageIcon() {
            return new ImageIcon(getClass().getClassLoader().getResource(this.resourcePath));
        }
    }

    public OutpatientManagementGuiApp() {
        super("Outpatient Management");
        configureFrame();
        initComponents();
        drawFrame();
    }

    private void configureFrame() {
        this.setSize(900, 500);
        this.setResizable(false);
        this.setIconImage(AppIcon.LOGO.getImageIcon().getImage());
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
        // content pane
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(20, 20, 5, 20));
        // side navigation
        loadWestMenu();
        // main content
        mainContent = new JPanel();
        mainContent.setLayout(new CardLayout());
        // footer label
        loadFooterLabel();
        // za card-ove
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
        configButton(patientButton, AppIcon.PATIENT_GRAY, AppIcon.PATIENT_GREEN, "Manage patient records", PATIENTS_CARD);
        doctorButton = new JButton();
        configButton(doctorButton, AppIcon.DOCTOR_GRAY, AppIcon.DOCTOR_GREEN, "Manage doctors", DOCTORS_CARD);
        appointmentButton = new JButton();
        configButton(appointmentButton, AppIcon.APPOINTMENT_GRAY, AppIcon.APPOINTMENT_GREEN, "Manage appointments", APPOINTMENTS_CARD);
        statisticsButton = new JButton();
        configButton(statisticsButton, AppIcon.STATISTICS_GRAY, AppIcon.STATISTICS_GREEN, "View reports", STATISTICS_CARD);
        // ubacivanje u panel
        sideMenuPanel.add(patientButton);
        sideMenuPanel.add(doctorButton);
        sideMenuPanel.add(appointmentButton);
        sideMenuPanel.add(statisticsButton);
    }

    private void configButton(JButton btn, AppIcon iconNormal, AppIcon iconHover, String toolTipText, String cardAction) {
        btn.setPreferredSize(new Dimension(70, 50));
        btn.setIcon(iconNormal.getImageIcon());
        btn.setRolloverIcon(iconHover.getImageIcon());
        btn.setBorder(null);
        btn.setFocusPainted(false);
        btn.setContentAreaFilled(false);
        btn.setToolTipText(toolTipText);
        btn.addActionListener((ActionEvent e) -> {
            CardLayout cl = (CardLayout) (mainContent.getLayout());
            cl.show(mainContent, cardAction);
        });
    }

    private void loadFooterLabel() {
        footerLabel = new JLabel(FOOTER_TEXT);
        footerLabel.setBorder(new EmptyBorder(10, 0, 0, 0));
        footerLabel.setForeground(CUSTOM_GREEN);
    }

    private void loadCards() {
        registrationsCard = new RegistrationCard();
        mainContent.add(registrationsCard, PATIENTS_CARD);
        doctorsCard = new DoctorCard();
        mainContent.add(doctorsCard, DOCTORS_CARD);
        appointmentsCard = new AppointmentCard();
        mainContent.add(appointmentsCard, APPOINTMENTS_CARD);
        statisticsCard = new StatisticsCard();
        mainContent.add(statisticsCard, STATISTICS_CARD);
    }

    // konstante
    private static final String STATISTICS_CARD = "statistics";
    private static final String APPOINTMENTS_CARD = "appointments";
    private static final String DOCTORS_CARD = "doctors";
    private static final String PATIENTS_CARD = "patients";
    private static final String FOOTER_TEXT = " © VIRGO HOSPITALS - Outpatient Management";
    private static final Color CUSTOM_GREEN = new Color(53, 112, 11);

}
