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
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
        LOGO, PATIENT_GRAY, PATIENT_GREEN, DOCTOR_GREEN, DOCTOR_GRAY,
        APPOINTMENT_GREEN, APPOINTMENT_GRAY, STATISTICS_GREEN, STATISTICS_GRAY
    }

    private final Map<Integer, String> imagesMap = new HashMap<>();
    private static final List<ImageIcon> IMAGE_ICONS = new ArrayList<>();

    public OutpatientManagementGuiApp() {
        super("Outpatient Management");
        loadImages();
        configureFrame();
        initComponents();
        drawFrame();
    }

    private void loadImages() {
        
        imagesMap.put(AppIcon.LOGO.ordinal(), "resources/first-aid.png");
        imagesMap.put(AppIcon.PATIENT_GREEN.ordinal(), "resources/patient_green.png");
        imagesMap.put(AppIcon.PATIENT_GRAY.ordinal(), "resources/patient_gray.png");
        imagesMap.put(AppIcon.STATISTICS_GRAY.ordinal(), "resources/report_gray.png");
        imagesMap.put(AppIcon.STATISTICS_GREEN.ordinal(), "resources/report_green.png");
        imagesMap.put(AppIcon.DOCTOR_GRAY.ordinal(), "resources/doctor_gray.png");
        imagesMap.put(AppIcon.DOCTOR_GREEN.ordinal(), "resources/doctor_green.png");
        imagesMap.put(AppIcon.APPOINTMENT_GRAY.ordinal(), "resources/appointment_gray.png");
        imagesMap.put(AppIcon.APPOINTMENT_GREEN.ordinal(), "resources/appointment_green.png");

        imagesMap.entrySet().forEach((entry) -> {
            int keyIndex = entry.getKey();
            String value = entry.getValue();
            IMAGE_ICONS.add(keyIndex, new ImageIcon(getClass().getClassLoader().getResource(value)));
        });
    }

    private void configureFrame() {
        this.setSize(900, 500);
        this.setResizable(false);
        this.setIconImage((getAppIcon(AppIcon.LOGO)).getImage());
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
        configButton(patientButton, AppIcon.PATIENT_GRAY, AppIcon.PATIENT_GREEN, "Manage patient records", PATIENTS_CARD);

        doctorButton = new JButton();
        configButton(doctorButton, AppIcon.DOCTOR_GRAY, AppIcon.DOCTOR_GREEN, "Manage doctors", DOCTORS_CARD);

        appointmentButton = new JButton();
        configButton(appointmentButton, AppIcon.APPOINTMENT_GRAY, AppIcon.APPOINTMENT_GREEN, "Manage appointments", APPOINTMENTS_CARD);

        statisticsButton = new JButton();
        configButton(statisticsButton, AppIcon.STATISTICS_GRAY, AppIcon.STATISTICS_GREEN, "View reports", STATISTICS_CARD);

        sideMenuPanel.add(patientButton);
        sideMenuPanel.add(doctorButton);
        sideMenuPanel.add(appointmentButton);
        sideMenuPanel.add(statisticsButton);
    }
    
    private void configButton(JButton btn, AppIcon iconNormal, AppIcon iconHover, String toolTipText, String cardAction) {
        btn.setPreferredSize(new Dimension(70, 50));
        btn.setIcon(getAppIcon(iconNormal));
        btn.setRolloverIcon(getAppIcon(iconHover));
        btn.setBorder(null);
        btn.setFocusPainted(false);
        btn.setContentAreaFilled(false);
        btn.setToolTipText(toolTipText);
        btn.addActionListener((ActionEvent e) -> {
            CardLayout cl = (CardLayout) (mainContent.getLayout());
            cl.show(mainContent, cardAction);
        });
    }
    
    private ImageIcon getAppIcon(AppIcon icon) {
        return IMAGE_ICONS.get(icon.ordinal());
    }

    private void loadFooterLabel() {
        footerLabel = new JLabel(" © VIRGO HOSPITALS - Outpatient Management");
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
    
    
    private static final String STATISTICS_CARD = "statistics";
    private static final String APPOINTMENTS_CARD = "appointments";
    private static final String DOCTORS_CARD = "doctors";
    private static final String PATIENTS_CARD = "patients";
    private static final Color CUSTOM_GREEN = new Color(53, 112, 11);

}
