/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lea.bll.datamanagers;

import com.lea.dal.domain.entities.Appointment;
import com.lea.dal.domain.entities.HospitalService;
import com.lea.utilities.DateConverter;
import com.lea.utilities.OptionKeyValue;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Lea
 */
public class ReceiptManager extends DataManager {

    private static final String LINE_SPLIT = "\n------------------------------------------------\n";

    public String getReceiptOutput(List<OptionKeyValue> services, int idConsultation) {
        List<HospitalService> allServices = new ArrayList<>();
        allServices.add(repository.getHospitalServiceById(idConsultation));
        for (OptionKeyValue service : services) {
            allServices.add(repository.getHospitalServiceById(service.getKey()));
        }
        return getOutput(allServices);
    }

    public String getReceiptOutputFromAppointment(int idAppointment) {
        Appointment appointment = repository.getAppointmentById(idAppointment);
        List<HospitalService> allServices = new ArrayList();
        appointment.getAppointmentServices().forEach(a -> allServices.add(a.getHospitalService()));
        return getOutput(allServices);
    }

    private String getOutput(List<HospitalService> services) {
        StringBuilder output = new StringBuilder();
        output.append("Receipt summary" + LINE_SPLIT);
        output.append("Issue date: " + DateConverter.getStringFromDate(new Date()) + LINE_SPLIT);
        BigDecimal totalPrice = new BigDecimal(0);
        for (HospitalService service : services) {
            output.append(service.getName() + " " + service.getBasicPrice().setScale(2, RoundingMode.CEILING).toString() + "\n");
            totalPrice = totalPrice.add(service.getBasicPrice());
        }
        output.append("\n" + LINE_SPLIT);
        output.append("TOTAL PRICE: " + totalPrice.setScale(2, RoundingMode.CEILING).toString());
        return output.toString();
    }

}
