/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jsf.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;
import jsf.entidades.Estudiante;
import jsf.interfaces.DaoEstudiante;

/**
 *
 * @author fabry
 */
public class EstudianteDaoImp implements DaoEstudiante{

    private Connection conn;
    final String Insert= "Insert into estudiante (id,nombre) values (?,?)";

    public EstudianteDaoImp(Connection conn) {
        this.conn = conn;
    }
    
    @Override
    public void insertar(Estudiante a) {
        
        PreparedStatement stat= null;
        try{
            stat= conn.prepareStatement(Insert);
            stat.setLong(1,a.getIdEstudiante());
            stat.setString(2, a.getNombre());
            
        }catch(Exception e){
            
        }
         }

    @Override
    public void modificar(Estudiante a) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eliminar(Estudiante a) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Estudiante> obtenerRegistros() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Estudiante obtener(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
