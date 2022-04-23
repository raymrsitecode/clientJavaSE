/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sfwlibre.formulary.service;

import com.sfwlibre.formulary.dto.UserDTO;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author Raymundo
 */
@Service
public class UsuarioServiceImpl implements UsuarioService{
    
          
 
            @Override
            public UserDTO createUser(UserDTO user){
                       return new UserDTO();     
            }

            @Override
            public List<UserDTO> listUser(){
                     return new ArrayList<>();
            }
            
            @Override
            public Boolean isAuthenticatedUser(UserDTO user){
                     if(user.getNombre().equalsIgnoreCase("raymrsite") && user.getPassword().equalsIgnoreCase("12345")){
                        user.setAutorizado(true);
                     
                    return user.isAutorizado();
                     }
                return false;
            }
            
}
