/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sfwlibre.formulary.service;

import com.sfwlibre.formulary.dao.UserDaoImpl;
import com.sfwlibre.formulary.dto.UserDTO;
import java.util.List;

/**
 *
 * @author Raymundo
 */

public class UsuarioServiceImpl implements UsuarioService{
    
            private UserDaoImpl userDao = new UserDaoImpl();
    
            @Override
            public UserDTO createUser(UserDTO user){
                       return userDao.createUser(user);
            }

            @Override
            public List<UserDTO> listUser(){
                     return userDao.getListUsers();
            }
            
            
            @Override
            public UserDTO isAuthenticatedUser(UserDTO user){  
                     return userDao.getUser(user);
            }
            
}
