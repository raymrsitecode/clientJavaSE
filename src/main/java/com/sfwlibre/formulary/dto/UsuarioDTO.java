package com.sfwlibre.formulary.dto;

import java.util.List;

/**
 *
 * @author Raymundo
 */
public class UsuarioDTO {
   
    private String nombre;
    private String password;
    private boolean autorizado;
    private List<UsuarioDTO> listUser;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isAutorizado() {
        return autorizado;
    }

    public void setAutorizado(boolean autorizado) {
        this.autorizado = autorizado;
    }

    public List<UsuarioDTO> getListUser() {
        return listUser;
    }

    public void setListUser(List<UsuarioDTO> listUser) {
        this.listUser = listUser;
    }
    
    public void addOneUser(UsuarioDTO oneItem) {
        listUser.add(oneItem);
    }

    @Override
    public String toString() {
      return nombre + " " + password + " " + autorizado;
   }
}
