/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jsf.Controllers;

import convertidorXmi.LectorXmiHandler;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import jsf.dao.EstudianteDaoImp;
import jsf.entidades.Conexion;
import jsf.entidades.Estudiante;
import convertidorXmi.Convertidor;
import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.resource.UMLResource;
import org.xml.sax.SAXException;

/**
 *
 * @author fabry
 */
@Named(value = "estudianteMB")
@Dependent
public class EstudianteManagedBean {

    private String texto1;
    private String texto2;

    public EstudianteManagedBean() {
    }

    public String getTexto1() {
        return texto1;
    }

    public void setTexto1(String texto1) {
        this.texto1 = texto1;
    }

    public String getTexto2() {
        return texto2;
    }

    public void setTexto2(String texto2) {
        this.texto2 = texto2;
    }

    public String redireccionar() {

        return "result";

    }
//    private URI typesUri = null;

    public void mostrar() throws ParserConfigurationException, IOException, SAXException {

        Convertidor converter= new Convertidor();
        converter.ConvertidorXmi();
//        Model m = getModel("C:/ExtendedPO2.uml");
//        System.out.println(m.getName());
    }

//    public Model getModel(String pathToModel) {
//
//        typesUri = URI.createFileURI(pathToModel);
//        ResourceSet set = new ResourceSetImpl();
//
//        set.getPackageRegistry().put(UMLPackage.eNS_URI, UMLPackage.eINSTANCE);
//        set.getResourceFactoryRegistry().getExtensionToFactoryMap().put(UMLResource.FILE_EXTENSION, UMLResource.Factory.INSTANCE);
//        set.createResource(typesUri);
//        Resource r = set.getResource(typesUri, true);
//
//        Model m = (Model) EcoreUtil.getObjectByType(r.getContents(), UMLPackage.Literals.MODEL);
//
//        return m;
//    }
    
    
    
    
    public void guardar() {
        try {
         Estudiante est1 = new Estudiante(1L, "Fabricio Campos");
            Conexion con = new Conexion();
            con.ConectarBasedeDatos("jsf");

            EstudianteDaoImp estImp = new EstudianteDaoImp(con.conexion);
            estImp.insertar(est1);
        } catch (Exception ex) {

        }

    }
}
