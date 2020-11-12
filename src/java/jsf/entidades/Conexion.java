/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jsf.entidades;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author fabry
 */
public class Conexion {
    
     public Connection conexion;
 public Statement sentencia;
 public ResultSet resultado;
 private final String Driver="com.mysql.jdbc.Driver";
 private final String url="jdbc:mysql//localhost:3306/";
 private final String userbd="root";
 private final String passw="";
 
 public void ConectarBasedeDatos(String bd) throws SQLException{
 try {
 final String Controlador = "com.mysql.jdbc.Driver";
 Class.forName( Controlador );
 final String url_bd = "jdbc:mysql://localhost:3306/";
 final String url_bd2 = "jdbc:mysql://localhost:3306/"+bd;
 if(bd.equals("")){
 conexion = DriverManager.getConnection(url_bd,userbd,passw);
 }else{
 conexion = DriverManager.getConnection(url_bd2,userbd,passw);
 }
 sentencia = (Statement) conexion.createStatement();
 } catch (ClassNotFoundException | SQLException ex) {
 JOptionPane.showMessageDialog(null,ex.getMessage(), "Excepcion", JOptionPane.ERROR_MESSAGE);
 }
 }
 
 
  public void DesconectarBasedeDatos() {
 try {
 if (conexion != null ) {

 conexion.close();
 }
 }
 catch (SQLException ex) {
 JOptionPane.showMessageDialog(null,ex.getMessage(), "Excepcion", JOptionPane.ERROR_MESSAGE);
 System.exit(1);
 }
 }
 public Connection getConnection(){
 return conexion;
 }

 
 public void CrearBd(String based){
     
     try{
         ConectarBasedeDatos(based);
         //this.sentencia.execute();
     }catch(Exception e){
         
     }
     
 }
}
