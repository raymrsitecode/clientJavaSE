/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sfwlibre.formulary.service;

import com.sfwlibre.formulary.dto.UserDTO;
import java.util.List;

/**
 *
 * @author Raymundo
 */
public interface UsuarioService {
    
       UserDTO createUser(UserDTO user);
       
       public int getUser(String name);

       List<UserDTO> listUser();

       UserDTO isAuthenticatedUser(UserDTO user);
       
}
