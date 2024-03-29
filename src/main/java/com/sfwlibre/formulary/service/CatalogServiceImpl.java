/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sfwlibre.formulary.service;

import com.sfwlibre.formulary.dao.CatalogDaoImpl;
import com.sfwlibre.formulary.dto.CatalogDTO;
import java.util.List;

/**
 *
 * @author raymrsitecode
 */
public class CatalogServiceImpl implements CatalogService{

    private CatalogDaoImpl catalogDao = new CatalogDaoImpl();
    
    @Override
    public List<CatalogDTO> listCatalog() {
        return catalogDao.listCatalog();
    }

    @Override
    public List<CatalogDTO> listCatalogUsers(int userId) {
       return  catalogDao.listCatalogUsers(userId);
    }

    @Override
    public List<CatalogDTO> listCatalogCards() {
        return catalogDao.listCatalogCards();
    }

    @Override
    public int getCardsByDescription(String description) {
       return catalogDao.getCardsByDescription(description);
    }

    @Override
    public int getMsiByDescription(String description) {
        return catalogDao.getMsiByDescription(description);
    }

    @Override
    public List<CatalogDTO> listCatalogCards(String typeCard) {
        return catalogDao.listCatalogCards(typeCard);
    }
    
}
