/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lea.bll.viewmodels;

import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author Lea
 */
public class ReceiptVM extends ViewModel {
     private AppointmentVM appointment;
     private Date issueDate;
     private Boolean creditCard;
     private BigDecimal totalPrice;

    public ReceiptVM(int idReceipt) {
        super(idReceipt);
    }

    public ReceiptVM(int idreceipt, AppointmentVM appointment, Date issueDate, Boolean creditCard, BigDecimal totalPrice) {
        super(idreceipt);
        this.appointment = appointment;
        this.issueDate = issueDate;
        this.creditCard = creditCard;
        this.totalPrice = totalPrice;
    }

    public AppointmentVM getAppointment() {
        return appointment;
    }

    public void setAppointment(AppointmentVM appointment) {
        this.appointment = appointment;
    }

    public Date getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(Date issueDate) {
        this.issueDate = issueDate;
    }

    public Boolean getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(Boolean creditCard) {
        this.creditCard = creditCard;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }
     
     
}
