/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sfwlibre.formulary.dao;

/**
 *
 * @author raymrsitecode
 */
public class TransactionDaoImpl implements TransactionDao {

    @Override
    public void insertTransaction() {
          String SQL_Query = "INSERT INTO sgcpagos.sgc_t002_transactions ( description , amount , type_payment , date_amount_register , date_register , user_id , card_id , sgc_t005_msi_msi_id ) VALUES (   ?  , ?  , ?  , ?  , ?  , ?  , ?  , ?  )";
    }
    
}
