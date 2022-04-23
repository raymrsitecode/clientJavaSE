/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sfwlibre.formulary.util;

import com.sfwlibre.formulary.configuration.ContextConfiguration;
import com.sfwlibre.formulary.dto.UserDTO;

/**
 *
 * @author Raymundo
 */
public class loginUtil extends ContextConfiguration{


   public  boolean processDataUser(UserDTO user){
       UserDTO usuarioDTO = getA().createUser( user );
       return usuarioDTO.isAutorizado();
  }


   public void createUser( UserDTO user){
}
   
   
    
}
