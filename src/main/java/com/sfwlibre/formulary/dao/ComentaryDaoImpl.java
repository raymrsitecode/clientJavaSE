/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sfwlibre.formulary.dao;

import com.sfwlibre.formulary.configuration.ConnectionMysql;
import com.sfwlibre.formulary.dto.CommentDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author raymrsitecode
 */
public class ComentaryDaoImpl extends ConnectionMysql implements ComentaryDao {

    
    @Override
    public void createComentary(String comentary, int transaction_id) {
       Connection con = getConnectionDB();
         String SQL_Query = "INSERT INTO  sgcpagos.sgc_t006_comment ( description , sgc_t002_transactions_transaction_id , date_register ) VALUES ( ? , ?  , ? );";
         
            try {
                    PreparedStatement preparedStmt = con.prepareStatement(SQL_Query);
                    java.util.Date date=new java.util.Date();
                    java.sql.Date sqlDate=new java.sql.Date(date.getTime());
                    java.sql.Timestamp sqlTime  =new java.sql.Timestamp(date.getTime());

                    preparedStmt.setString (1, comentary);
                    preparedStmt.setInt(2, transaction_id );
                    preparedStmt.setDate(3, sqlDate);
                    preparedStmt.execute();
                   
                    con.close();
            } catch (SQLException ex) {
                Logger.getLogger(UserDaoImpl.class.getName()).log(Level.SEVERE, null, ex);

            }
    }

    @Override
    public List<CommentDTO> getListComments(int transactionId) {
       Connection con = getConnectionDB();
        
        try{
            PreparedStatement prep = con.prepareStatement( "SELECT * FROM sgcpagos.sgc_t006_comment where sgc_t002_transactions_transaction_id = ?");
                              prep.setInt(1, transactionId);
            ResultSet rs = prep.executeQuery();
            List<CommentDTO> listComments = new ArrayList<>();
            while(rs.next()){
                CommentDTO comment = new CommentDTO();
                        comment.setId( rs.getInt("comment_id"));
                        comment.setDescription(rs.getString("description"));
                        comment.setDate_register(rs.getDate("date_register"));
                        listComments.add(comment);
            }            
            con.close();
            return listComments;
        }catch(SQLException e){
            return null;
        }
    }
    
}
