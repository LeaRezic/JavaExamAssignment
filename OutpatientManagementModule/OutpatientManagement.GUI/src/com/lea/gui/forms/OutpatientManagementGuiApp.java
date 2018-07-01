/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lea.gui.forms;

import com.lea.dal.hibernate.HibernateUtil;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author Lea
 */
public class OutpatientManagementGuiApp extends JFrame {

    private JPanel contentPane;
    private JMenuBar menuBar;
    // patient menu
    private JMenu menuPatient;
    private JMenuItem miNewEmergencyRegistration;
    private JMenuItem miNewFullRegistration;
    private JMenuItem miFinishExistringRegistration;
    // doctor menu
    private JMenu menuDoctor;
    private JMenuItem miViewAllDoctors;
    private JMenuItem miAddDoctor;
    // appointemnts menu
    private JMenu menuAppointment;
    private JMenuItem miViewAllAppointments;
    private JMenuItem miAddAppointment;
    private JMenuItem miIssueReceipt;
    // statistics menu
    private JMenu menuStatistic;
    private JMenuItem miDailyStatistics;
    private JMenuItem miWeeklyStatistics;
    private JMenuItem miMonthlyStatistics;
    // side panel container and buttons
    private JPanel sideMenuPanel;
    private JButton patientButton;
    private JButton doctorButton;
    private JButton appointmentButton;
    private JButton statisticsButton;
    // other properties -  center content and footer label
    private JPanel mainContent;
    private JLabel footerLabel;
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
        this.setSize(1200, 800);
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
        contentPane.setBorder(new EmptyBorder(20,0,0,5));
        menuBar = new JMenuBar();
        // loading menus (init and add menu items)
        loadPatientsMenu();
        loadDoctorsMenu();
        loadAppointmentsMenu();
        loadStatisticsMenu();
        // side navigation
        loadWestMenu();
        // main content
        mainContent = new JPanel();
        mainContent.setBorder(BorderFactory.createMatteBorder(0, 2, 0, 0, new Color(61,61,61)));
        // footer label
        loadFooterLabel();

    }

    private void drawFrame() {
        // adding menus
        menuBar.add(menuPatient);
        menuBar.add(menuDoctor);
        menuBar.add(menuAppointment);
        menuBar.add(menuStatistic);
        // setting the layout and content pane
        BorderLayout layout = new BorderLayout();
        contentPane.setLayout(layout);
        this.setContentPane(contentPane);
        // adding content to the contentPane
        this.setJMenuBar(menuBar);
        contentPane.add(footerLabel, BorderLayout.SOUTH);
        contentPane.add(sideMenuPanel, BorderLayout.WEST);
        contentPane.add(mainContent, BorderLayout.CENTER);

    }

    private void loadPatientsMenu() {
        // init
        menuPatient = new JMenu("Patients");
        miNewEmergencyRegistration = new JMenuItem("Emergency registration");
        miNewFullRegistration = new JMenuItem("Full registration");
        miFinishExistringRegistration = new JMenuItem("Finish existing registration");
        // add
        menuPatient.add(miNewEmergencyRegistration);
        menuPatient.add(miNewFullRegistration);
        menuPatient.add(miFinishExistringRegistration);
    }

    private void loadDoctorsMenu() {
        // init
        menuDoctor = new JMenu("Doctors");
        miViewAllDoctors = new JMenuItem("View All");
        miAddDoctor = new JMenuItem("Add new");
        // add
        menuDoctor.add(miViewAllDoctors);
        menuDoctor.add(miAddDoctor);

    }

    private void loadAppointmentsMenu() {
        // init
        menuAppointment = new JMenu("Appointments");
        miViewAllAppointments = new JMenuItem("View all");
        miAddAppointment = new JMenuItem("Schedule new");
        miIssueReceipt = new JMenuItem("Issue receipt");
        // add
        menuAppointment.add(miViewAllAppointments);
        menuAppointment.add(miAddAppointment);
        menuAppointment.add(miIssueReceipt);
    }

    private void loadStatisticsMenu() {
        // init
        menuStatistic = new JMenu("Statistics");
        miDailyStatistics = new JMenuItem("Daily report");
        miWeeklyStatistics = new JMenuItem("Weekly report");
        miMonthlyStatistics = new JMenuItem("Monthly report");
        // add
        menuStatistic.add(miDailyStatistics);
        menuStatistic.add(miWeeklyStatistics);
        menuStatistic.add(miMonthlyStatistics);

    }

    private void loadWestMenu() {
        // side navigation menu
        sideMenuPanel = new JPanel();
        sideMenuPanel.setBorder(new EmptyBorder(80, 10, 10, 10));
        sideMenuPanel.setLayout(new GridLayout(6, 1, 0, 40));
        // gumbeki za side menu
        patientButton = new JButton();
        configButton(patientButton, 1, "Manage patient records");
        doctorButton = new JButton();
        configButton(doctorButton, 3, "Manage doctors");
        appointmentButton = new JButton();
        configButton(appointmentButton, 5, "Manage appointments");
        statisticsButton = new JButton();
        configButton(statisticsButton, 7, "View reports");
        sideMenuPanel.add(patientButton);
        sideMenuPanel.add(doctorButton);
        sideMenuPanel.add(appointmentButton);
        sideMenuPanel.add(statisticsButton);
    }

    private void configButton(JButton btn, int imageIndex, String toolTipText) {
        btn.setPreferredSize(new Dimension(70, 50));
        btn.setIcon(IMAGE_ICONS.get(imageIndex));
        btn.setRolloverIcon(IMAGE_ICONS.get(++imageIndex));
        btn.setBorder(null);
        btn.setFocusPainted(false);
        btn.setContentAreaFilled(false);
        btn.setToolTipText(toolTipText);
    }

    private void loadFooterLabel() {
        footerLabel = new JLabel(" © VIRGO HOSPITALS - Outpatient Management");
        footerLabel.setBorder(new EmptyBorder(15, 5, 5, 5));
        footerLabel.setForeground(new Color(53, 112, 11));
    }

}
