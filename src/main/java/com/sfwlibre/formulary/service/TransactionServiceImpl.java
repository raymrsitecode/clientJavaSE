/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sfwlibre.formulary.service;

import com.sfwlibre.formulary.dao.TransactionDaoImpl;
import com.sfwlibre.formulary.domain.TransactionDomain;
import com.sfwlibre.formulary.dto.TransactionDTO;
import java.util.List;

/**
 *
 * @author raymrsitecode
 */
public class TransactionServiceImpl implements TransactionService{

    private TransactionDaoImpl transactionDao = new TransactionDaoImpl();
    
    @Override
    public void insertTransactionPaymentCash(TransactionDomain transaction) {
           transactionDao.insertTransactionPaymentCash(transaction);
    }

    @Override
    public void insertTransactionMsi(TransactionDomain transaction) {
          transactionDao.insertTransactionMsi(transaction);
    }

    @Override
    public List<TransactionDTO> getListTransaction() {
         return transactionDao.getListTransaction();
    }
    
}
