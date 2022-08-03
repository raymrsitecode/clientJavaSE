package com.sfwlibre.formulary.dto;

/**
 *
 * @author Raymundo
 */
public class UserDTO {
   
             private int id;
             private String user;
             private String password;
             private String token_security;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getToken_security() {
        return token_security;
    }

    public void setToken_security(String token_security) {
        this.token_security = token_security;
    }

     @Override
    public String toString() {
      return user + " " + password + " " + token_security;
   }
}
