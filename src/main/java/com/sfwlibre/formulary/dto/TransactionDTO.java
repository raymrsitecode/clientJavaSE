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
    
    /***
     * atributo en el que viaja el id de la transaccion registrada
     * 
     */
    private int id;
    /***
     * atributo en el que viaja el concepto o descripcion de la transaccion.
     * 
     */
    private String description;
    /***
     * atributo en el que viaja el monto de la transaccion registrada
     * 
     */
    private double amount;
    /***
     * atributo en el que viaja el tipo de transaccion si es msi o onlyoneexbition de la transaccion registrada
     * 
     */
    private String type_amount;
    /***
     * atributo en el que viaja el fecha  de la transaccion registrada
     * 
     */
    private Date date_amount_register;/***
     * atributo en el que viaja la fecha registro de la transaccion registrada
     * 
     */
    
    private Date date_register;
    /***
     * atributo en el que viaja el id del usuario que adeuda la transaccion registrada
     * 
     */
    private String user;
    /***
     * atributo en el que viaja el id de la tarjeta que se utilizo en la transaccion registrada
     * 
     */
    private String card;
    /***
     * atributo en el que viaja el id de los meses a pagar de la transaccion registrada
     * 
     */
    private String msi;

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

    public String getType_amount() {
        return type_amount;
    }

    public void setType_amount(String type_amount) {
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

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getCard() {
        return card;
    }

    public void setCard(String card) {
        this.card = card;
    }

    public String getMsi() {
        return msi;
    }

    public void setMsi(String msi) {
        this.msi = msi;
    }

    @Override
    public String toString() {
        return "TransactionDTO{" + "id=" + id + ", description=" + description + ", amount=" + amount + ", type_amount=" + type_amount + ", date_amount_register=" + date_amount_register + ", date_register=" + date_register + ", user=" + user + ", card=" + card + ", msi=" + msi + '}';
    }
    
    
}
