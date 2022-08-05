/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.sfwlibre.formulary.service;

import com.sfwlibre.formulary.dto.TransactionDTO;

/**
 *
 * @author raymrsitecode
 */
public interface TransactionService {
    
     public void insertTransactionPaymentCash(TransactionDTO transaction);
     public void insertTransactionMsi(TransactionDTO transaction);
}
