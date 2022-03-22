/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sfwlibre.formulary.service;

import com.sfwlibre.formulary.dto.UsuarioDTO;
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
            public UsuarioDTO createUser(UsuarioDTO user){

                  if(user.getNombre().equalsIgnoreCase("raymrsite") && user.getPassword().equalsIgnoreCase("12345")){
                     user.setAutorizado(true);
                     
                    return user;
                     }
                return user;
            }

            @Override
            public List<UsuarioDTO> listUser(){
                     return new ArrayList<>();
            }
}
