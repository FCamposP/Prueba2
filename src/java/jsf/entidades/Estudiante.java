/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jsf.entidades;

/**
 *
 * @author fabry
 */
public class Estudiante {
    
    private Long idEstudiante;
    private String Nombre;

    public Estudiante(Long idEstudiante, String Nombre) {
        this.idEstudiante = idEstudiante;
        this.Nombre = Nombre;
    }

    public Long getIdEstudiante() {
        return idEstudiante;
    }

    public void setIdEstudiante(Long idEstudiante) {
        this.idEstudiante = idEstudiante;
    }


    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }
    
    
    
}
