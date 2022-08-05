/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sfwlibre.formulary.dao;

import com.sfwlibre.formulary.configuration.ConnectionMysql;
import com.sfwlibre.formulary.dto.UserDTO;
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
public class UserDaoImpl extends ConnectionMysql implements UserDao{

    @Override
    public UserDTO getUser(UserDTO usuario) {
        
               Connection con = getConnectionDB();
                    try {
                       Statement stmt = con.createStatement();
                       ResultSet rs=stmt.executeQuery("SELECT * FROM sgcpagos.sgc_t001_users where user = '"+usuario.getUser()+"' and access_token = '"+usuario.getPassword()+"'");  

                                UserDTO user = new UserDTO();
                               while(rs.next()){
                                        user.setId( rs.getInt("user_id"));
                                        user.setUser(rs.getString("user"));
                                        user.setName(rs.getString("name"));
                                        user.setLastName(rs.getString("last_name"));
                                        
                                     }    

                                   con.close();
                                   return user;
                    } catch (SQLException ex) {
                        Logger.getLogger(UserDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
                    }
            return null;
    }

    @Override
    public List<UserDTO> getListUsers() {
        Connection con = getConnectionDB();
        
        try{
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM sgcpagos.sgc_t001_users");
            List<UserDTO> listUsers = new ArrayList<>();
            while(rs.next()){
                UserDTO user = new UserDTO();
                        user.setId( rs.getInt("user_id"));
                        user.setUser(rs.getString("user"));
                        user.setName(rs.getString("name"));
                        user.setLastName(rs.getString("last_name"));
                        listUsers.add(user);
            }            
            con.close();
            return listUsers;
        }catch(SQLException e){
            return null;
        }
    }

    @Override
    public UserDTO createUser(UserDTO user) {
         Connection con = getConnectionDB();
         String sql = " insert into sgc_t001_users (name, last_name, date_register, date_down, user, access_token) values (?, ?, ?, ?, ?, ? )";
               PreparedStatement preparedStmt;
        try {
            
                preparedStmt = con.prepareStatement(sql);
                java.util.Date date=new java.util.Date();
                java.sql.Date sqlDate=new java.sql.Date(date.getTime());
                java.sql.Timestamp sqlTime=new java.sql.Timestamp(date.getTime());
                preparedStmt.setString (1, user.getName());
                preparedStmt.setString (2, user.getLastName());
                preparedStmt.setDate(3, sqlDate );
                preparedStmt.setDate(4, sqlDate);
                preparedStmt.setString(5, user.getUser());
                preparedStmt.setString(6, user.getPassword());
                preparedStmt.execute();
                

                con.close();
                return user;
        } catch (SQLException ex) {
            Logger.getLogger(UserDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public int getUser(String name) {
        Connection con = getConnectionDB();
        int user_id = 0;
                    try {
                       Statement stmt = con.createStatement();
                       ResultSet rs=stmt.executeQuery("SELECT user_id FROM sgcpagos.sgc_t001_users where concat(name, ' ', last_name) = '"+name+"'");  

                                
                               while(rs.next()){
                                        user_id = rs.getInt("user_id");
                                     }    
                                   con.close();
                                   return user_id;
                    } catch (SQLException ex) {
                        Logger.getLogger(UserDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
                    }
            return user_id;
    }
    
    
        
}
