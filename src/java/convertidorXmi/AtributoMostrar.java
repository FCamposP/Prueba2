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
public class AtributoMostrar {
    private String tipoDato;
    private String nombreVariable;   
    private boolean lista;

    public boolean isLista() {
        return lista;
    }

    public void setLista(boolean lista) {
        this.lista = lista;
    }
    
    

    public AtributoMostrar(String tipoDato, String nombreVariable, boolean islista) {
        this.tipoDato = tipoDato;
        this.nombreVariable = nombreVariable;
        this.lista=islista;
    }

    public AtributoMostrar(String tipoDato, String nombreVariable) {
        this.tipoDato = tipoDato;
        this.nombreVariable = nombreVariable;
    }

    
    public String getTipoDato() {
        return tipoDato;
    }

    public void setTipoDato(String tipoDato) {
        this.tipoDato = tipoDato;
    }

    public String getNombreVariable() {
        return nombreVariable;
    }

    public void setNombreVariable(String nombreVariable) {
        this.nombreVariable = nombreVariable;
    }
    
    
}
