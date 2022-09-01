/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sfwlibre.formulary.service;

import com.sfwlibre.formulary.dao.TransactionDaoImpl;
import com.sfwlibre.formulary.domain.PaymentDomain;
import com.sfwlibre.formulary.domain.TransactionDomain;
import com.sfwlibre.formulary.dto.PaymentDTO;
import com.sfwlibre.formulary.dto.TransactionDTO;
import java.util.List;

/**
 *
 * @author raymrsitecode
 */
public class TransactionServiceImpl implements TransactionService{

    private final TransactionDaoImpl transactionDao = new TransactionDaoImpl();
    
    @Override
    public int insertTransactionPaymentCash(TransactionDomain transaction) {
           return transactionDao.insertTransactionPaymentCash(transaction);
    }

    @Override
    public int insertTransactionMsi(TransactionDomain transaction) {
          return transactionDao.insertTransactionMsi(transaction);
    }

    @Override
    public List<TransactionDTO> getListTransaction() {
         return transactionDao.getListTransaction();
    }

    @Override
    public void inserTransactionPayment(PaymentDomain payment) {
        transactionDao.inserTransactionPayment(payment);
    }

    @Override
    public List<PaymentDTO> getListTransactionPayment(int transactionId) {
        return transactionDao.getListTransactionPayment(transactionId);
    }

    @Override
    public void updateTransactionPaymentToPayed(PaymentDomain payment) {
        transactionDao.updateTransactionPaymentToPayed(payment);
    }
    
}
