/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sfwlibre.formulary.dto;

import java.sql.Date;

/**
 *
 * @author raymrsitecode
 */
public class TransactionDTO {
    
    private int id;
    private String description;
    private double amount;
    private int type_amount;
    private Date date_amount_register;
    private Date date_register;
    private int user_id;
    private int card_id;
    private int msi_id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public int getType_amount() {
        return type_amount;
    }

    public void setType_amount(int type_amount) {
        this.type_amount = type_amount;
    }

    public Date getDate_amount_register() {
        return date_amount_register;
    }

    public void setDate_amount_register(Date date_amount_register) {
        this.date_amount_register = date_amount_register;
    }

    public Date getDate_register() {
        return date_register;
    }

    public void setDate_register(Date date_register) {
        this.date_register = date_register;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getCard_id() {
        return card_id;
    }

    public void setCard_id(int card_id) {
        this.card_id = card_id;
    }

    public int getMsi_id() {
        return msi_id;
    }

    public void setMsi_id(int msi_id) {
        this.msi_id = msi_id;
    }

    @Override
    public String toString() {
        return "TransactionDTO{" + "id=" + id + ", description=" + description + ", amount=" + amount + ", type_amount=" + type_amount + ", date_amount_register=" + date_amount_register + ", date_register=" + date_register + ", user_id=" + user_id + ", card_id=" + card_id + ", msi_id=" + msi_id + '}';
    }
    
    
}
