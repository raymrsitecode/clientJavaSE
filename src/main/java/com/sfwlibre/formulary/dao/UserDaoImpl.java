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
                       ResultSet rs=stmt.executeQuery("SELECT * FROM t_usuarios where user = '"+usuario.getUser()+"' and password = '"+usuario.getPassword()+"'");  

                                UserDTO user = new UserDTO();
                               while(rs.next()){
                                        user.setId( rs.getInt("id"));
                                        user.setUser(rs.getString("user"));
                                        user.setPassword(rs.getString("password"));
                                        user.setToken_security(rs.getString("token_security"));
                                     }    

                                   con.close();
                                   return user;
                    } catch (SQLException ex) {
                        Logger.getLogger(UserDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
                    }
            return null;
            }
    
    
        
}
