/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package convertidorXmi;

import java.util.ArrayList;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 *
 * @author fabry
 */
public class LectorXmiHandler  extends DefaultHandler{

    private ArrayList<Clase> listaClases= new ArrayList();
    private Clase nuevaClase;
    private Atributo nuevoAtributo;    
    


    public ArrayList<Clase> getListaClases() {
        return listaClases;
    }

    public void setListaClases(ArrayList<Clase> listaClases) {
        this.listaClases = listaClases;
    }

    public Clase getNuevaClase() {
        return nuevaClase;
    }

    public void setNuevaClase(Clase nuevaClase) {
        this.nuevaClase = nuevaClase;
    }
    
    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
      
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
   
        switch(qName){
            case "uml:Model":
                SetearDatosFaltantes();
                break;
        }
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
     
        switch(qName){//switch para etiquetass
            case "packagedElement": 
                switch(attributes.getValue("xmi:type")){//switch para tipos de packageElemment, clases o asociaciones
                    case "uml:Class": //1  Clases
                        nuevaClase= new Clase();
                        listaClases.add(nuevaClase);
                         nuevaClase.setNombre(attributes.getValue("name"));
                         nuevaClase.setId(attributes.getValue("xmi:id"));
//                         nuevaInfoClase= new InfoClase();
//                         nuevaInfoClase.setIdClase(nuevaClase.getId());
//                         nuevaInfoClase.setNombreClase(nuevaClase.getNombre());
                        break;
                    case "uml:AssociationClass":
                        nuevaClase= new Clase();
                        listaClases.add(nuevaClase);
                         nuevaClase.setNombre(attributes.getValue("name"));
                         nuevaClase.setId(attributes.getValue("xmi:id"));
                        break;

                }//fin switch para tipo de packageElement
                
                break; //fin packagedElement
            case "ownedAttribute":
                nuevoAtributo= new Atributo();
                nuevaClase.adicionarAtributo(nuevoAtributo);
                nuevoAtributo.setNombre(attributes.getValue("name"));
                nuevoAtributo.setId(attributes.getValue("xmi:id"));
                nuevoAtributo.setAgregation(attributes.getValue("aggregation"));
                if(nuevoAtributo.getAgregation()!=null){
                    nuevoAtributo.setIsLista(true);
                }
                //setear isLista, aggregation define si es una lista?
                switch(attributes.getValue("visibility")){
                    case "public":
                        nuevoAtributo.setVisibilidad(Enums.Visibilidad.publico);
                        break;
                    case "private":
                        nuevoAtributo.setVisibilidad(Enums.Visibilidad.privado);
                        break;
                    case "protected":
                        nuevoAtributo.setVisibilidad(Enums.Visibilidad.protegido);
                        break;
                }
                
                String idTipoPropiedadClase=attributes.getValue("type");
                if(idTipoPropiedadClase!=null){//Si el tipo de dato del Atributo es alguna clase
                    nuevoAtributo.setNombreTipoPropiedad(ObtenerNombreClase(idTipoPropiedadClase));
                    nuevoAtributo.setIdClaseTipoAtributo(idTipoPropiedadClase);
                    nuevoAtributo.setPrimitiva(false);
                }
                break;
            case "type":
                nuevoAtributo.setNombreTipoPropiedad(ObtenerTipoDatoPrimitivo(attributes.getValue("href")));
                break;
            case "generalization":
                nuevaClase.setHija(true);
                String idPadre=attributes.getValue("general");
                nuevaClase.setNombrePadre(ObtenerNombreClase(idPadre));
               nuevaClase.setIdPadre(idPadre);
                break;
                //para multiplicidad de atributo
            case "lowerValue":
                nuevoAtributo.setMultiplicidadMinima(Enums.Multiplicidad.cero);
                break;
            case "upperValue":
                nuevoAtributo.setMultiplicidadMaxima(Enums.Multiplicidad.muchos);
                nuevoAtributo.setIsLista(true);
                break;
                
        }
    }
    
    
    private String ObtenerNombreClase(String id){
        
        String nombreClase=null;
        if(listaClases.size()>0){
            for(Clase c: listaClases){
                if(c.getId().equals(id)){
                    nombreClase=c.getNombre();
                }
            }
        }
        
        return nombreClase;
    }
    

    
    
    private String ObtenerTipoDatoPrimitivo(String href){
        
        String tipoDato="";
        tipoDato= href.substring(href.indexOf('#')+1);
        
        return tipoDato;
    }
    
    
    private void SetearDatosFaltantes(){
        //se guardan los datos faltantes cuando las clases necesitadas aun no estaban creadas
        for(Clase clase: listaClases){ 
            
            //formatear el nombre de Clase
            clase.setNombre(Formato.nombreClase(clase.getNombre()));
            //para una clase herencia, cuando no se guardó al padre
            if(clase.isHija()==true && clase.getNombrePadre()==null){
                clase.setNombrePadre(ObtenerNombreClase(clase.getIdPadre()));
            }
            for(Atributo atributo: clase.getAtributos()){
                
                //formatear ell nombre de atributo
                atributo.setNombre(Formato.variable(atributo.getNombre()));
                
                //para una propiedad de tipo de dato de una clase
                if(atributo.getNombreTipoPropiedad()==null){
                    String nombreClase=ObtenerNombreClase(atributo.getIdClaseTipoAtributo());
                    atributo.setNombreTipoPropiedad(nombreClase);
                }
            }
        }
        
    }
    
}


//revisar null: nombre de clases para propiedades, para herencia

//papra clase asociacion revisar su estructura