/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.sfwlibre.formulary.dao;

import com.sfwlibre.formulary.dto.UserDTO;
import java.util.List;

/**
 *
 * @author raymrsitecode
 */
public interface UserDao {
    
    public UserDTO getUser(UserDTO user);
    
    public int getUser(String name);
    
    public List<UserDTO> getListUsers();
    
    public UserDTO createUser(UserDTO user);
    
        
}
