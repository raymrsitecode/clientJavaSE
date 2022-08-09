/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sfwlibre.formulary.service;

import com.sfwlibre.formulary.dao.ComentaryDaoImpl;
import com.sfwlibre.formulary.dto.CommentDTO;
import java.util.List;

/**
 *
 * @author raymrsitecode
 */
public class ComentaryServiceImpl implements ComentaryService {

    private ComentaryDaoImpl comentaryDao = new ComentaryDaoImpl();
    
    @Override
    public void createComentary(String comentary, int transaction_id) {
       comentaryDao.createComentary(comentary, transaction_id);
    }

    @Override
    public List<CommentDTO> getListComments(int transactionId) {
       return comentaryDao.getListComments(transactionId);
    }
    
}
