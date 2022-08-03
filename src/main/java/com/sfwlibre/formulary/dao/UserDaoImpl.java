/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sfwlibre.formulary.dao;

import com.sfwlibre.formulary.configuration.ConnectionMysql;
import com.sfwlibre.formulary.dto.UserDTO;
import java.sql.Connection;
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
    
    
        
}
