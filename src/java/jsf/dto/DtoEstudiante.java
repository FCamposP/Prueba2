/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jsf.dto;

import java.util.logging.Logger;

/**
 *
 * @author fabry
 */
public class DtoEstudiante {

    public DtoEstudiante(String Nombre) {
        this.Nombre = Nombre;
    }


    
        private String Nombre;

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }
}
