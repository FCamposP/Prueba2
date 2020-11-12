/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package convertidorXmi;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.SAXException;

/**
 *
 * @author fabry
 */
public class Convertidor {

    public void ConvertidorXmi() throws ParserConfigurationException, SAXException, IOException {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        SAXParser saxParser = saxParserFactory.newSAXParser();
        File file = new File("C:/Users/fabry/modelio/workspace/Prueba1/XMI/prueba1.xmi");
        LectorXmiHandler handler = new LectorXmiHandler();
        saxParser.parse(file, handler);
        CrearArchivos(handler.getListaClases());
    }

    public Convertidor() {
    }

    public static void CrearArchivos(ArrayList<Clase> listaClases) {
        FileWriter fichero = null;
        PrintWriter pw = null;
        try {
            for (Clase clase : listaClases) {
                String nombreFile = "";
                nombreFile = "C:/Users/fabry/modelio/workspace/Prueba1/XMI/fc1";
                File directorio = new File(nombreFile);
        if (!directorio.exists()) {
            if (directorio.mkdirs()) {
                System.out.println("Directorio creado");
            } else {
                System.out.println("Error al crear directorio");
            }
        }

                nombreFile += "/"+clase.getNombre() + ".java";
                fichero = new FileWriter(nombreFile);
                pw = new PrintWriter(fichero);

                //   for (Clase clas:listaClases)
                String codigo = GeneradorJava.GenerarCodigoJava(clase);
                pw.println(codigo);
                fichero.close();
            }
            //crear clase main
            String nombreFile = "";
                nombreFile = "C:/Users/fabry/modelio/workspace/Prueba1/XMI/fc1";
            nombreFile += "/Main.java";
            fichero = new FileWriter(nombreFile);
            pw = new PrintWriter(fichero);
            pw.println(GeneradorJava.GenerarClaseMain());
            fichero.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                // Nuevamente aprovechamos el finally para 
                // asegurarnos que se cierra el fichero.
                if (null != fichero) {
                    fichero.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

}


//falta visibilidad de clases y propiedades