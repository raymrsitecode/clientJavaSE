/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sfwlibre.formulary.service;

import com.sfwlibre.formulary.dao.TransactionDaoImpl;
import com.sfwlibre.formulary.dto.TransactionDTO;

/**
 *
 * @author raymrsitecode
 */
public class TransactionServiceImpl implements TransactionService{

    private TransactionDaoImpl transactionDao = new TransactionDaoImpl();
    
    @Override
    public void insertTransactionPaymentCash(TransactionDTO transaction) {
           transactionDao.insertTransactionPaymentCash(transaction);
    }

    @Override
    public void insertTransactionMsi(TransactionDTO transaction) {
          transactionDao.insertTransactionMsi(transaction);
    }
    
}
