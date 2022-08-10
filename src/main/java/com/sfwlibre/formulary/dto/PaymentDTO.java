/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sfwlibre.formulary.dto;

import java.util.Date;

/**
 *
 * @author raymrsitecode
 */
public class PaymentDTO {
    
    private int id;
    private double amount;
    private Date dateRegister;
    private Date datePayout;
    private boolean isPayed;
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isIsPayed() {
        return isPayed;
    }

    public void setIsPayed(boolean isPayed) {
        this.isPayed = isPayed;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Date getDateRegister() {
        return dateRegister;
    }

    public void setDateRegister(Date dateRegister) {
        this.dateRegister = dateRegister;
    }

    public Date getDatePayout() {
        return datePayout;
    }

    public void setDatePayout(Date datePayout) {
        this.datePayout = datePayout;
    }

    @Override
    public String toString() {
        return "PaymentDTO{" + "id=" + id + ", amount=" + amount + ", dateRegister=" + dateRegister + ", datePayout=" + datePayout + ", isPayed=" + isPayed + '}';
    }
   
}
