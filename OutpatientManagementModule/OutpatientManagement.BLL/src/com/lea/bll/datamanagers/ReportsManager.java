/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lea.bll.datamanagers;

import com.lea.dal.domain.entities.Appointment;
import com.lea.dal.domain.entities.Doctor;
import com.lea.dal.domain.entities.HospitalService;
import com.lea.dal.domain.entities.Patient;
import com.lea.utilities.DateConverter;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Lea
 */
public class ReportsManager extends DataManager {

    private static final String LINE_SPLIT = "\n--------------------------------------------\n";

    public String getEntityNumbersReport() {
        StringBuilder sb = new StringBuilder();
        sb.append("Total number of doctors: " + repository.getAllDoctors().size() + "\n");
        sb.append("Of which actively employed: " + repository.getAllDoctors()
                .stream()
                .filter(d -> d.isActive())
                .count());
        sb.append(LINE_SPLIT);
        int totalRegistrations = repository.getAllPatients().size()
                + repository.getAllEmeregencyRegistrations().size();
        sb.append("Total number of patients: " + totalRegistrations + "\n");
        sb.append("Of which fully registered: " + repository.getAllPatients().size());
        sb.append(LINE_SPLIT);
        sb.append("Total number of appointemnts: " + repository.getAllAppointments().size() + "\n");
        return sb.toString();
    }

    public String getApppointmentsPerDoctorReport() {
        StringBuilder sb = new StringBuilder();
        sb.append("Total number of appointments per doctor");
        sb.append(LINE_SPLIT);
        List<Doctor> doctors = repository.getAllDoctors();
        for (int i = 0; i < doctors.size(); i++) {
            Doctor doctor = doctors.get(i);
            sb.append(doctor.toString());
            sb.append(": ");
            List<Appointment> appointments = new ArrayList<>();
            repository.getAllAppointments()
                    .forEach(a -> {
                        if (a.getDoctor().getIddoctor() == doctor.getIddoctor()) {
                            appointments.add(a);
                        }
                    });
            sb.append(appointments.size() + "\n");
        }
        return sb.toString();
    }

    public String getServicesSumPerPatient() {
        StringBuilder sb = new StringBuilder();
        sb.append("Total price sum of hospital services per patient");
        sb.append(LINE_SPLIT);
        List<Patient> patients = repository.getAllPatients();
        for (int i = 0; i < patients.size(); i++) {
            Patient patient = patients.get(i);
            sb.append(patient.toString() + ": ");
            List<HospitalService> allServices = new ArrayList();
            patient.getAppointments().forEach(a -> getHospitalServices(allServices, a));
            sb.append(getTotalPrice(allServices) + "\n");
        }
        return sb.toString();
    }

    private void getHospitalServices(List<HospitalService> services, Appointment a) {
        a.getAppointmentServices().forEach(x -> services.add(x.getHospitalService()));
    }

    private BigDecimal getTotalPrice(List<HospitalService> services) {
        BigDecimal result = new BigDecimal(0);
        for (HospitalService service : services) {
            result = result.add(service.getBasicPrice().setScale(2, RoundingMode.CEILING));
        }
        return result;
    }

}
