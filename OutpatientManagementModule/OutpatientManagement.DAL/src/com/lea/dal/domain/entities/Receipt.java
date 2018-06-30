package com.lea.dal.domain.entities;
// Generated 28.06.2018. 08:51:52 by Hibernate Tools 4.3.1


import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Receipt generated by hbm2java
 */
@Entity
@Table(name="Receipt"
    ,schema="dbo"
    ,catalog="VirgoHospitals"
)
public class Receipt  implements java.io.Serializable {


     private int idreceipt;
     private Appointment appointment;
     private Date issueDate;
     private Boolean creditCard;
     private BigDecimal totalPrice;

    public Receipt() {
    }

	
    public Receipt(int idreceipt, Appointment appointment, Date issueDate, BigDecimal totalPrice) {
        this.idreceipt = idreceipt;
        this.appointment = appointment;
        this.issueDate = issueDate;
        this.totalPrice = totalPrice;
    }
    public Receipt(int idreceipt, Appointment appointment, Date issueDate, Boolean creditCard, BigDecimal totalPrice) {
       this.idreceipt = idreceipt;
       this.appointment = appointment;
       this.issueDate = issueDate;
       this.creditCard = creditCard;
       this.totalPrice = totalPrice;
    }
   
     @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="IDReceipt", unique=true, nullable=false)
    public int getIdreceipt() {
        return this.idreceipt;
    }
    
    public void setIdreceipt(int idreceipt) {
        this.idreceipt = idreceipt;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="AppointmentID", nullable=false)
    public Appointment getAppointment() {
        return this.appointment;
    }
    
    public void setAppointment(Appointment appointment) {
        this.appointment = appointment;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="IssueDate", nullable=false, length=23)
    public Date getIssueDate() {
        return this.issueDate;
    }
    
    public void setIssueDate(Date issueDate) {
        this.issueDate = issueDate;
    }

    
    @Column(name="CreditCard")
    public Boolean getCreditCard() {
        return this.creditCard;
    }
    
    public void setCreditCard(Boolean creditCard) {
        this.creditCard = creditCard;
    }

    
    @Column(name="TotalPrice", nullable=false, scale=4)
    public BigDecimal getTotalPrice() {
        return this.totalPrice;
    }
    
    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }




}


