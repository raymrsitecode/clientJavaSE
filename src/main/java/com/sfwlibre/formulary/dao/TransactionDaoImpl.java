/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sfwlibre.formulary.dao;

import com.sfwlibre.formulary.configuration.ConnectionMysql;
import com.sfwlibre.formulary.domain.PaymentDomain;
import com.sfwlibre.formulary.domain.TransactionDomain;
import com.sfwlibre.formulary.dto.PaymentDTO;
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
    public int insertTransactionPaymentCash(TransactionDomain transaction) {
        Connection con = getConnectionDB();
         String SQL_Query = "INSERT INTO sgcpagos.sgc_t002_transactions ( description , amount , type_payment , date_amount_register , date_register , user_id , card_id  ) VALUES (   ?  , ?  , ?  , ?  , ?  , ?  , ?   )";
            int last_inserted_id = 0;   
        try {
                PreparedStatement preparedStmt = con.prepareStatement(SQL_Query,Statement.RETURN_GENERATED_KEYS);
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
                ResultSet rs = preparedStmt.getGeneratedKeys();
                if(rs.next())
                {
                     last_inserted_id = rs.getInt(1);
                }
                con.close();
        } catch (SQLException ex) {
            Logger.getLogger(UserDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
          
        }
        return last_inserted_id;
    }

    @Override
    public int insertTransactionMsi(TransactionDomain transaction) {
         Connection con = getConnectionDB();
         String SQL_Query = "INSERT INTO sgcpagos.sgc_t002_transactions ( description , amount , type_payment , date_amount_register , date_register , user_id , card_id, msi_id  ) VALUES (   ?  , ?  , ?  , ?  , ?  , ?  , ?, ?  )";
         int last_inserted_id = 0;  
        try {
                PreparedStatement preparedStmt = con.prepareStatement(SQL_Query,Statement.RETURN_GENERATED_KEYS);
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
                preparedStmt.executeUpdate();
                ResultSet rs = preparedStmt.getGeneratedKeys();
                if(rs.next())
                {
                     last_inserted_id = rs.getInt(1);
                }
                con.close();
        } catch (SQLException ex) {
            Logger.getLogger(UserDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
          
        }
        return last_inserted_id;
    }

    @Override
    public List<TransactionDTO> getListTransaction() {
        //create funtionality here
       Connection con = getConnectionDB();
        
        try{
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT t.transaction_id, CONCAT(u.name, u.last_name) name,t.description concepto, t.amount,c.description notarjeta, m.description plazo,t.type_payment tipopago FROM sgcpagos.sgc_t002_transactions t JOIN sgc_t001_users u ON t.user_id = u.user_id  JOIN sgc_t003_card c ON t.card_id = c.card_id JOIN sgc_t005_msi m ON t.msi_id = m.msi_id UNION SELECT t.transaction_id, CONCAT(u.name, u.last_name) name,t.description, t.amount,c.description, '' ,t.type_payment FROM sgcpagos.sgc_t002_transactions t  JOIN sgc_t001_users u ON t.user_id = u.user_id  JOIN sgc_t003_card c ON t.card_id = c.card_id  where t.type_payment <> 'MSI'");
            List<TransactionDTO> listTransaction = new ArrayList<>();
            while(rs.next()){
                TransactionDTO transaction = new TransactionDTO();
                        transaction.setId(rs.getInt("transaction_id"));
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

    @Override
    public void inserTransactionPayment(PaymentDomain payment) {
        Connection con = getConnectionDB();
         String SQL_Query = "INSERT INTO  sgcpagos.sgc_t007_breakdown (  amount , isPayed , date_register , date_payout ,  sgc_t002_transactions_transaction_id ) VALUES (  ? , ? , ? , ? , ? )";
         
        try {
                PreparedStatement preparedStmt = con.prepareStatement(SQL_Query);
                java.util.Date date=new java.util.Date();
                java.sql.Date sqlDate=new java.sql.Date(date.getTime());
                java.sql.Timestamp sqlTime=new java.sql.Timestamp(date.getTime());
                
                preparedStmt.setDouble(1, payment.getAmount());
                preparedStmt.setBoolean(2, false);
                preparedStmt.setTimestamp(3, sqlTime);
                preparedStmt.setTimestamp(4, sqlTime);
                preparedStmt.setInt(5, payment.getTransactionId());
   
                preparedStmt.executeUpdate();
              
                con.close();
        } catch (SQLException ex) {
            Logger.getLogger(UserDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
          
        }
    }

    @Override
    public List<PaymentDTO> getListTransactionPayment(int transactionId) {
        Connection con = getConnectionDB();
        
        try{
            PreparedStatement prep = con.prepareStatement( "SELECT breakdown_id,amount, isPayed,date_register,date_payout from sgcpagos.sgc_t007_breakdown b where sgc_t002_transactions_transaction_id = ?");
                              prep.setInt(1, transactionId);
                    ResultSet rs = prep.executeQuery();
                    
            List<PaymentDTO> listPayment = new ArrayList<>();
            while(rs.next()){
                PaymentDTO payment = new PaymentDTO();
                           payment.setId(rs.getInt("breakdown_id"));
                           payment.setAmount(rs.getDouble("amount"));
                           payment.setIsPayed(rs.getBoolean("isPayed"));
                           payment.setDatePayout(rs.getTimestamp("date_payout"));
                           payment.setDateRegister(rs.getTimestamp("date_register"));
                           listPayment.add(payment);
            }            
            con.close();
            return listPayment;
        }catch(SQLException e){
            return null;
        }
    }

    @Override
    public void updateTransactionPaymentToPayed(PaymentDomain payment) {
        Connection con = getConnectionDB();
         String SQL_Query = "UPDATE sgc_t007_breakdown SET isPayed = ?, date_payout = ? WHERE breakdown_id = ?;";
         
        try {
                PreparedStatement preparedStmt = con.prepareStatement(SQL_Query);
                java.util.Date date=new java.util.Date();
                java.sql.Date sqlDate=new java.sql.Date(date.getTime());
                java.sql.Timestamp sqlTime=new java.sql.Timestamp(date.getTime());
                
                preparedStmt.setBoolean(1, true);
                preparedStmt.setTimestamp(2, sqlTime);
                preparedStmt.setInt( 3, payment.getBreakDownId() );
                
   
                preparedStmt.executeUpdate();
              
                con.close();
        } catch (SQLException ex) {
            Logger.getLogger(UserDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
          
        }
    }
    
    


    
    
    
}
