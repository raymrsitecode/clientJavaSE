/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sfwlibre.formulary.dao;

import com.sfwlibre.formulary.configuration.ConnectionMysql;
import com.sfwlibre.formulary.domain.TransactionDomain;
import com.sfwlibre.formulary.dto.TransactionDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author raymrsitecode
 */
public class TransactionDaoImpl extends ConnectionMysql implements TransactionDao {

    @Override
    public void insertTransactionPaymentCash(TransactionDomain transaction) {
        Connection con = getConnectionDB();
         String SQL_Query = "INSERT INTO sgcpagos.sgc_t002_transactions ( description , amount , type_payment , date_amount_register , date_register , user_id , card_id  ) VALUES (   ?  , ?  , ?  , ?  , ?  , ?  , ?   )";
               
        try {
                PreparedStatement preparedStmt = con.prepareStatement(SQL_Query);
                java.util.Date date=new java.util.Date();
                java.sql.Date sqlDate=new java.sql.Date(date.getTime());
                java.sql.Timestamp sqlTime  =new java.sql.Timestamp(date.getTime());
                
                preparedStmt.setString (1, transaction.getDescription());
                preparedStmt.setDouble(2, transaction.getAmount() );
                preparedStmt.setString(3, "PAYMENT_CASH");
                preparedStmt.setDate(4, sqlDate);
                preparedStmt.setDate(5, sqlDate);
                preparedStmt.setInt(6, transaction.getUser_id() );
                preparedStmt.setInt(7, transaction.getCard_id() );

                preparedStmt.execute();
                con.close();
        } catch (SQLException ex) {
            Logger.getLogger(UserDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
          
        }
    }

    @Override
    public void insertTransactionMsi(TransactionDomain transaction) {
        Connection con = getConnectionDB();
         String SQL_Query = "INSERT INTO sgcpagos.sgc_t002_transactions ( description , amount , type_payment , date_amount_register , date_register , user_id , card_id, sgc_t005_msi_msi_id  ) VALUES (   ?  , ?  , ?  , ?  , ?  , ?  , ?, ?  )";
               
        try {
                PreparedStatement preparedStmt = con.prepareStatement(SQL_Query);
                java.util.Date date=new java.util.Date();
                java.sql.Date sqlDate=new java.sql.Date(date.getTime());
                java.sql.Timestamp sqlTime=new java.sql.Timestamp(date.getTime());
                
                preparedStmt.setString (1, transaction.getDescription());
                preparedStmt.setDouble(2, transaction.getAmount() );
                preparedStmt.setString(3, "MSI");
                preparedStmt.setDate(4, sqlDate);
                preparedStmt.setDate(5, sqlDate);
                preparedStmt.setInt(6, transaction.getUser_id() );
                preparedStmt.setInt(7, transaction.getCard_id() );
                preparedStmt.setInt(8, transaction.getMsi_id() );
                preparedStmt.execute();
                con.close();
        } catch (SQLException ex) {
            Logger.getLogger(UserDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
          
        }
    }

    @Override
    public List<TransactionDTO> getListTransaction() {
        //create funtionality here
       Connection con = getConnectionDB();
        
        try{
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT CONCAT(u.name, u.last_name) name,t.description concepto, t.amount,c.description notarjeta, m.description plazo,t.type_payment tipopago FROM sgcpagos.sgc_t002_transactions t JOIN sgc_t001_users u ON t.user_id = u.user_id  JOIN sgc_t003_card c ON t.card_id = c.card_id JOIN sgc_t005_msi m ON t.sgc_t005_msi_msi_id = m.msi_id UNION SELECT CONCAT(u.name, u.last_name) name,t.description, t.amount,c.description, '' ,t.type_payment FROM sgcpagos.sgc_t002_transactions t  JOIN sgc_t001_users u ON t.user_id = u.user_id  JOIN sgc_t003_card c ON t.card_id = c.card_id  where t.type_payment <> 'MSI'");
            List<TransactionDTO> listTransaction = new ArrayList<>();
            while(rs.next()){
                TransactionDTO transaction = new TransactionDTO();
                        transaction.setCard(rs.getString("notarjeta"));
                        transaction.setDescription(rs.getString("concepto"));
                        transaction.setMsi(rs.getString("plazo"));
                        transaction.setUser(rs.getString("name"));
                        transaction.setType_amount( rs.getString("tipopago"));
                        transaction.setAmount(rs.getDouble("amount"));
                        listTransaction.add(transaction);
            }            
            con.close();
            return listTransaction;
        }catch(SQLException e){
            return null;
        }
    }


    
    
    
}
