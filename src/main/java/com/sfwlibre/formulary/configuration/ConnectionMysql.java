/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sfwlibre.formulary.configuration;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Raymundo
 */
public class ConnectionMysql {   

private static Properties getConnectionData() {
        Properties props = new Properties();
        String fileName = "src/main/resources/db.properties";
        try (FileInputStream in = new FileInputStream(fileName)) {
            props.load(in);
        } catch (IOException ex) {
            Logger lgr = Logger.getLogger(ConnectionMysql.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }
        return props;
    }

public Connection getConnectionDB(){
    Properties props = getConnectionData();
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
