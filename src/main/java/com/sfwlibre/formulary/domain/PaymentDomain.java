/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sfwlibre.formulary.domain;

import java.util.Date;

/**
 * INSERT INTO  sgcpagos.sgc_t007_breakdown (  amount , isPayed , date_register , date_payout ,  sgc_t002_transactions_transaction_id ) VALUES (  ? , ? , ? , ? , ? );
 * @author raymrsitecode
 */
public class PaymentDomain {
    
    private double amount;
    private boolean isPayed;
    private Date dateRegister;
    private Date datePayout;
    private int transactionId;

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public boolean isIsPayed() {
        return isPayed;
    }

    public void setIsPayed(boolean isPayed) {
        this.isPayed = isPayed;
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

    public int getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }

    @Override
    public String toString() {
        return "PaymentDomain{" + "amount=" + amount + ", isPayed=" + isPayed + ", dateRegister=" + dateRegister + ", datePayout=" + datePayout + ", transactionId=" + transactionId + '}';
    }
    
    
}
