/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.sfwlibre.formulary.service;

import com.sfwlibre.formulary.domain.PaymentDomain;
import com.sfwlibre.formulary.domain.TransactionDomain;
import com.sfwlibre.formulary.dto.PaymentDTO;
import com.sfwlibre.formulary.dto.TransactionDTO;
import java.util.List;

/**
 *
 * @author raymrsitecode
 */
public interface TransactionService {
    
     public int insertTransactionPaymentCash(TransactionDomain transaction);
     public int insertTransactionMsi(TransactionDomain transaction);
     public List<TransactionDTO> getListTransaction();
     public void inserTransactionPayment(PaymentDomain payment);
     public List<PaymentDTO> getListTransactionPayment(int transactionId);
}
