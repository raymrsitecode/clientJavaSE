/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sfwlibre.formulary.dao;

import com.sfwlibre.formulary.configuration.ConnectionMysql;
import com.sfwlibre.formulary.dto.TransactionDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author raymrsitecode
 */
public class TransactionDaoImpl extends ConnectionMysql implements TransactionDao {

    @Override
    public void insertTransactionPaymentCash(TransactionDTO transaction) {
        Connection con = getConnectionDB();
         String SQL_Query = "INSERT INTO sgcpagos.sgc_t002_transactions ( description , amount , type_payment , date_amount_register , date_register , user_id , card_id  ) VALUES (   ?  , ?  , ?  , ?  , ?  , ?  , ?   )";
               
        try {
                PreparedStatement preparedStmt = con.prepareStatement(SQL_Query);
                java.util.Date date=new java.util.Date();
                java.sql.Date sqlDate=new java.sql.Date(date.getTime());
                java.sql.Timestamp sqlTime=new java.sql.Timestamp(date.getTime());
                
                preparedStmt.setString (1, transaction.getDescription());
                preparedStmt.setDouble(2, transaction.getAmount() );
                preparedStmt.setString(3, "PAYMENT_CASH");
                preparedStmt.setDate(4, sqlDate);
                preparedStmt.setDate(5, sqlDate);
                preparedStmt.setInt(6, Integer.valueOf(transaction.getUser_id()) );
                preparedStmt.setInt(7, Integer.valueOf(transaction.getCard_id()) );

                preparedStmt.execute();
                con.close();
        } catch (SQLException ex) {
            Logger.getLogger(UserDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
          
        }
    }

    @Override
    public void insertTransactionMsi(TransactionDTO transaction) {
        Connection con = getConnectionDB();
         String SQL_Query = "INSERT INTO sgcpagos.sgc_t002_transactions ( description , amount , type_payment , date_amount_register , date_register , user_id , card_id, sgc_t005_msi_msi_id  ) VALUES (   ?  , ?  , ?  , ?  , ?  , ?  , ?, ?  )";
               
        try {
                PreparedStatement preparedStmt = con.prepareStatement(SQL_Query);
                java.util.Date date=new java.util.Date();
                java.sql.Date sqlDate=new java.sql.Date(date.getTime());
                java.sql.Timestamp sqlTime=new java.sql.Timestamp(date.getTime());
                
                preparedStmt.setString (1, transaction.getDescription());
                preparedStmt.setDouble(2, transaction.getAmount() );
                preparedStmt.setString(3, "PAYMENT_CASH");
                preparedStmt.setDate(4, sqlDate);
                preparedStmt.setDate(5, sqlDate);
                preparedStmt.setInt(6, Integer.valueOf(transaction.getUser_id()) );
                preparedStmt.setInt(7, Integer.valueOf(transaction.getCard_id()) );
                preparedStmt.setInt(8, Integer.valueOf(transaction.getMsi_id()) );
                preparedStmt.execute();
                con.close();
        } catch (SQLException ex) {
            Logger.getLogger(UserDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
          
        }
    }

    @Override
    public List<TransactionDTO> getListTransaction() {
        //create funtionality here
       return null;
    }


    
    
    
}
