/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.sfwlibre.formulary.service;

import com.sfwlibre.formulary.dto.CatalogDTO;
import java.util.List;

/**
 *
 * @author raymrsitecode
 */
public interface CatalogService {
     public List<CatalogDTO> listCatalog();
     
     public List<CatalogDTO> listCatalogUsers(int userId);
     
     public List<CatalogDTO> listCatalogCards();
     
      public int getCardsByDescription(String description);
}
