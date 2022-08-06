/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sfwlibre.formulary.dao;

import com.sfwlibre.formulary.configuration.ConnectionMysql;
import com.sfwlibre.formulary.dto.CatalogDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author raymrsitecode
 */
public class CatalogDaoImpl extends ConnectionMysql implements CatalogDao {

    @Override
    public List<CatalogDTO> listCatalog() {
        Connection con = getConnectionDB();
        
        try{
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM sgcpagos.sgc_t005_msi");
            List<CatalogDTO> listCatalog = new ArrayList<>();
            while(rs.next()){
                CatalogDTO catalog = new CatalogDTO();
                        catalog.setId( rs.getInt("msi_id"));
                        catalog.setDescription(rs.getString("description"));
                        listCatalog.add(catalog);
            }            
            con.close();
            return listCatalog;
        }catch(SQLException e){
            return null;
        }
    }

    @Override
    public List<CatalogDTO> listCatalogUsers(int user_id) {
        
        Connection con = getConnectionDB();
        System.err.println("user_id"+user_id);
        try{
            PreparedStatement prep = con.prepareStatement( "SELECT * FROM sgcpagos.sgc_t001_users where user_id <> ?");
                              prep.setInt(1, user_id);
            ResultSet rs = prep.executeQuery();
            List<CatalogDTO> listCatalog = new ArrayList<>();
            while(rs.next()){
                CatalogDTO catalog = new CatalogDTO();
                        catalog.setId( rs.getInt("user_id"));
                        catalog.setDescription(rs.getString("name") +" "+ rs.getString("last_name") );
                        listCatalog.add(catalog);
            }            
            con.close();
            return listCatalog;
        }catch(SQLException e){
            return null;
        }
        
    }

    @Override
    public List<CatalogDTO> listCatalogCards() {
        Connection con = getConnectionDB();
        
        try{
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM sgcpagos.sgc_t003_card");
            List<CatalogDTO> listCatalog = new ArrayList<>();
            while(rs.next()){
                CatalogDTO catalog = new CatalogDTO();
                        catalog.setId( rs.getInt("card_id"));
                        catalog.setDescription(rs.getString("description"));
                        listCatalog.add(catalog);
            }            
            con.close();
            return listCatalog;
        }catch(SQLException e){
            return null;
        }
    }

    @Override
    public int getCardsByDescription(String description) {
       Connection con = getConnectionDB();
         int card_id = 0;
        try{
            PreparedStatement prep = con.prepareStatement( "SELECT * FROM sgcpagos.sgc_t003_card where description = ?");
                              prep.setString(1, description);
            ResultSet rs = prep.executeQuery();
            while(rs.next()){
                        card_id = rs.getInt("card_id");                        
            }            
            con.close();
            return card_id;
        }catch(SQLException e){
            
        }
        return card_id;
    }

    @Override
    public int getMsiByDescription(String description) {
       Connection con = getConnectionDB();
         int msi_id = 0;
        try{
            PreparedStatement prep = con.prepareStatement( "SELECT * FROM sgcpagos.sgc_t005_msi where description = ?");
                              prep.setString(1, description);
            ResultSet rs = prep.executeQuery();
            while(rs.next()){
                        msi_id = rs.getInt("msi_id");                        
            }            
            con.close();
            return msi_id;
        }catch(SQLException e){
            
        }
        return msi_id;
    }
    
}
