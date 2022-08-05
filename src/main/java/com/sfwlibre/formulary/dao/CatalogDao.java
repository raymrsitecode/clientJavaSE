/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.sfwlibre.formulary.dao;

import com.sfwlibre.formulary.dto.CatalogDTO;
import java.util.List;

/**
 *
 * @author raymrsitecode
 */
public interface CatalogDao {
    
    public List<CatalogDTO> listCatalog();
    
    public List<CatalogDTO> listCatalogUsers(int user_id);
    
    
    public List<CatalogDTO> listCatalogCards();
    
    public int getCardsByDescription(String description);
    
    public int getMsiByDescription(String description);
    
        
}
