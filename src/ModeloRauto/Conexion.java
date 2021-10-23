package ModeloRauto;

import java.sql.*;
import javax.swing.JOptionPane;

public class Conexion {


public  Connection conectar;

    String bd = "rautos";
    String url = "jdbc:mysql://localhost/" + bd;
    String user = "root";
    String pass = "";

    public java.sql.Connection Conectarbd() {
   
    
        try {
              Class.forName("com.mysql.jdbc.Driver");
             conectar =(Connection) DriverManager.getConnection(url,user,pass); 
             System.out.println("Se conecto");
            
        } catch (ClassNotFoundException |SQLException ex) {
            System.out.println(" no se conecto");  
      
    }        return conectar;


}
 public void Desconectarbd(){
     
     
     try {
         conectar.close();
         System.out.println("Se desconecto");
     } catch (SQLException ex) {
         System.out.println("no se pudo cerrar conexion");
     }
     
    

}}

