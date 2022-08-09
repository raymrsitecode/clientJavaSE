/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sfwlibre.formulary.dao;

import com.sfwlibre.formulary.dto.CommentDTO;
import java.util.List;

/**
 *
 * @author raymrsitecode
 */
public interface ComentaryDao {
    
    public void createComentary(String comentary, int transaction_id);
    
    public List<CommentDTO> getListComments(int transactionId);
}
