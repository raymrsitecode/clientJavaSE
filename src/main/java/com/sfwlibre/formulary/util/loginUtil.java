/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sfwlibre.formulary.util;

import com.sfwlibre.formulary.configuration.ContextConfiguration;
import com.sfwlibre.formulary.dto.UsuarioDTO;

/**
 *
 * @author Raymundo
 */
public class loginUtil extends ContextConfiguration{


   public  boolean processDataUser(UsuarioDTO user){
       UsuarioDTO usuarioDTO = getA().createUser( user );
       return usuarioDTO.isAutorizado();
}
   
   
    
}
