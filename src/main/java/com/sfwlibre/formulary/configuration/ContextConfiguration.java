/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sfwlibre.formulary.configuration;

import com.sfwlibre.formulary.service.UsuarioService;
import com.sfwlibre.formulary.service.UsuarioServiceImpl;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 *
 * @author Raymundo
 */
public class ContextConfiguration {

    public UsuarioService a;

    public ContextConfiguration() {

          AnnotationConfigApplicationContext factoria = new AnnotationConfigApplicationContext();
          factoria.register(SpringConfigurador.class);
          factoria.refresh();
           this.a = factoria.getBean(UsuarioServiceImpl.class); 
    }

    public UsuarioService getA() {
        return a;
    }

}
