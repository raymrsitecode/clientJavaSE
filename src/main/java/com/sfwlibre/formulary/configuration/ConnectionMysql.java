/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sfwlibre.formulary.configuration;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Raymundo
 */
public class ConnectionMysql {
    
public static void main(String args[]){  

       Properties props = getConnectionData();
          try{  
               Class.forName("com.mysql.cj.jdbc.Driver");  
               Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/srg_certification",props.getProperty("db.user"),"");  
               Statement stmt=con.createStatement();  
               ResultSet rs=stmt.executeQuery("SELECT * FROM srg_certification.srg_t001_certification;");  
               while(rs.next())  
                              System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));  
                              con.close();  
              }catch(Exception e){ 
                                   System.out.println(e);
                         }  
}  

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

}
