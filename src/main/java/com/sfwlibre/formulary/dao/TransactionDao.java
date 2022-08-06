/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sfwlibre.formulary.dao;

import com.sfwlibre.formulary.domain.TransactionDomain;
import com.sfwlibre.formulary.dto.TransactionDTO;
import java.util.List;

/**
 *
 * @author raymrsitecode
 */
interface TransactionDao {
    
    public void insertTransactionPaymentCash(TransactionDomain transaction);
    public void insertTransactionMsi(TransactionDomain transaction);
    
    public List<TransactionDTO> getListTransaction();
}
