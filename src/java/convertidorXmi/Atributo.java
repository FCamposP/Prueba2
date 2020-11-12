/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package convertidorXmi;

/**
 *
 * @author fabry
 */
public class Atributo {
    
    private String id;
    private String nombre;
    private String variable;
    private String nombreTipoPropiedad;
    private String idClaseTipoAtributo;
    private Enums.Visibilidad visibilidad;
    private Enums.Multiplicidad multiplicidadMinima;
    private Enums.Multiplicidad multiplicidadMaxima;
    private String agregation;
    private boolean isLista=false;
    private boolean primitiva=true;

    public boolean isPrimitiva() {
        return primitiva;
    }

    public void setPrimitiva(boolean primitiva) {
        this.primitiva = primitiva;
    }
    
    

    public Enums.Multiplicidad getMultiplicidadMinima() {
        return multiplicidadMinima;
    }

    public void setMultiplicidadMinima(Enums.Multiplicidad multiplicidadMinima) {
        this.multiplicidadMinima = multiplicidadMinima;
    }

    public Enums.Multiplicidad getMultiplicidadMaxima() {
        return multiplicidadMaxima;
    }

    public void setMultiplicidadMaxima(Enums.Multiplicidad multiplicidadMaxima) {
        this.multiplicidadMaxima = multiplicidadMaxima;
    }

    
    
    
    public String getIdClaseTipoAtributo() {
        return idClaseTipoAtributo;
    }

    public void setIdClaseTipoAtributo(String idClaseTipoAtributo) {
        this.idClaseTipoAtributo = idClaseTipoAtributo;
    }

    
    
    
    @Override
    public String toString() {
        return "\nAtributo{" + "id=" + id + ", nombre=" + nombre + ", nombreTipoPropiedad=" + nombreTipoPropiedad + ", visibilidad=" + visibilidad + ", multiplicidadMinima=" + multiplicidadMinima + ", multiplicidadMaxima=" + multiplicidadMaxima + ", agregation=" + agregation + ", isLista=" + isLista + '}';
    }

    
    
    public String getNombreTipoPropiedad() {
        return nombreTipoPropiedad;
    }

    public void setNombreTipoPropiedad(String nombreTipoPropiedad) {
        this.nombreTipoPropiedad = nombreTipoPropiedad;
    }

    public boolean isIsLista() {
        return isLista;
    }

    public void setIsLista(boolean isLista) {
        this.isLista = isLista;
    }
    
    
    public String getAgregation() {
        return agregation;
    }

    public void setAgregation(String agregation) {
        this.agregation = agregation;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    
    
    public Enums.Visibilidad getVisibilidad() {
        return visibilidad;
    }

    public void setVisibilidad(Enums.Visibilidad visibilidad) {
        this.visibilidad = visibilidad;
    }


    public Atributo() {
        this.nombre = "";
        this.variable = "";

    }

    public Atributo(String nombre, String variable) {
        this.nombre = nombre;
        this.variable = variable;

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getVariable() {
        return variable;
    }

    public void setVariable(String variable) {
        this.variable = variable;
    }

}
