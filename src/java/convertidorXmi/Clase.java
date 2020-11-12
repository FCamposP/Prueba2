/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package convertidorXmi;

import java.util.ArrayList;


/**
 *
 * @author fabry
 */
public class Clase {

    private String nombre;
    private ArrayList<Atributo> atributos;
    private boolean padre;
    private boolean hija;
    private String nombrePadre;
    private String idPadre;
    private String id;
    private Enums.Visibilidad  visibilidad;
    private boolean abstracta;
    private boolean primitivo;
    
    public String getIdPadre() {
        return idPadre;
    }

    public void setIdPadre(String idPadre) {
        this.idPadre = idPadre;
    }

    public Enums.Visibilidad getVisibilidad() {
        return visibilidad;
    }

    public void setVisibilidad(Enums.Visibilidad visibilidad) {
        this.visibilidad = visibilidad;
    }
 
    public boolean isAbstracta() {
        return abstracta;
    }

    public void setAbstracta(boolean abstracta) {
        this.abstracta = abstracta;
    }

    public boolean isPrimitivo() {
        return primitivo;
    }

    public void setPrimitivo(boolean primitivo) {
        this.primitivo = primitivo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Clase() {
        this.nombre = "";
        this.atributos = new ArrayList<Atributo>();
        this.padre = false;
        this.hija = false;
        this.nombrePadre = "";
    }

    public Clase(String nombre, boolean padre, boolean hija, String nombrePadre) {
        this.nombre = nombre;
        this.atributos = new ArrayList<Atributo>();
        this.padre = padre;
        this.hija = hija;
        this.nombrePadre = nombrePadre;
    }

    @Override
    public String toString() {
        return "\nClase{" + "nombre=" + nombre + ", atributos=" + atributos + ", padre=" + padre + ", hija=" + hija + ", nombrePadre=" + nombrePadre + ", id=" + id + '}';
    }

    public void adicionarAtributo(Atributo a) {
        atributos.add(a);
    } 

    public ArrayList<Atributo> getAtributos() {
        return atributos;
    }

    public void setAtributos(ArrayList<Atributo> atributos) {
        this.atributos = atributos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isHija() {
        return hija;
    }

    public void setHija(boolean hija) {
        this.hija = hija;
    }

    public String getNombrePadre() {
        return nombrePadre;
    }

    public void setNombrePadre(String nombrePadre) {
        this.nombrePadre = nombrePadre;
    }

    public boolean isPadre() {
        return padre;
    }

    public void setPadre(boolean padre) {
        this.padre = padre;
    }
}
