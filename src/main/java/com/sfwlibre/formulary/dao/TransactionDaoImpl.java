/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sfwlibre.formulary.dao;

import com.sfwlibre.formulary.configuration.ConnectionMysql;
import com.sfwlibre.formulary.dto.TransactionDTO;

/**
 *
 * @author raymrsitecode
 */
public class TransactionDaoImpl extends ConnectionMysql implements TransactionDao {

    @Override
    public void insertTransaction(TransactionDTO transaction) {
//          String SQL_Query = "INSERT INTO sgcpagos.sgc_t002_transactions ( description , amount , type_payment , date_amount_register , date_register , user_id , card_id , sgc_t005_msi_msi_id ) VALUES (   ?  , ?  , ?  , ?  , ?  , ?  , ?  , ?  )";
//          Connection con = getConnectionDB();
//         String sql = "insert into sgc_t001_users (name, last_name, date_register, date_down, user, access_token) values (?, ?, ?, ?, ?, ? )";
//               PreparedStatement preparedStmt;
//        try {
//            
//                preparedStmt = con.prepareStatement(sql);
//                java.util.Date date=new java.util.Date();
//                java.sql.Date sqlDate=new java.sql.Date(date.getTime());
//                java.sql.Timestamp sqlTime=new java.sql.Timestamp(date.getTime());
//                preparedStmt.setString (1, user.getName());
//                preparedStmt.setString (2, user.getLastName());
//                preparedStmt.setDate(3, sqlDate );
//                preparedStmt.setDate(4, sqlDate);
//                preparedStmt.setString(5, user.getUser());
//                preparedStmt.setString(6, user.getPassword());
//                preparedStmt.execute();
//                
//
//                con.close();
//                return user;
//        } catch (SQLException ex) {
//            Logger.getLogger(UserDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
//            return null;
//        }
    }
    
}
