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
public class CommentDTO {
    
    private int id;
    private String description;
    private Date date_register;

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

    public Date getDate_register() {
        return date_register;
    }

    public void setDate_register(Date date_register) {
        this.date_register = date_register;
    }

    @Override
    public String toString() {
        return "CommentDTO{" + "id=" + id + ", description=" + description + ", date_register=" + date_register + '}';
    }
    
    
    
}
