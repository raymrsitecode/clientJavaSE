/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sfwlibre.formulary.configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author Raymundo
 */
public class ConnectionMysql {   



public Connection getConnectionDB(){
   
          try{  
               Class.forName("com.mysql.cj.jdbc.Driver");  
               Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sgcpagos","root","");  
                 return con;
              }catch(Exception e){ 
                       JOptionPane.showMessageDialog(null, "No se pudo conectar a la bbdd"+ e);
                                   return null;
             }  
}

}
