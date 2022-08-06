/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sfwlibre.formulary.dao;

import com.sfwlibre.formulary.dto.TransactionDTO;
import java.util.List;

/**
 *
 * @author raymrsitecode
 */
interface TransactionDao {
    
    public void insertTransactionPaymentCash(TransactionDTO transaction);
    public void insertTransactionMsi(TransactionDTO transaction);
    
    public List<TransactionDTO> getListTransaction();
}
