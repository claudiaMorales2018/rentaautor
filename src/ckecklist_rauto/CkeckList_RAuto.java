/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ckecklist_rauto;

import ControladorRauto.ControladorLogin;
import ModeloRauto.Conexion;
import ModeloRauto.ModeloUsuario;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import VistaRauto.VistaLogin;
import com.jtattoo.plaf.bernstein.BernsteinLookAndFeel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author USUARIO
 */
public class CkeckList_RAuto {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException, ClassNotFoundException, UnsupportedLookAndFeelException {
      
        UIManager.setLookAndFeel(new BernsteinLookAndFeel() );
        
        VistaLogin v = new VistaLogin();
        
        ModeloUsuario m = new ModeloUsuario();
        ControladorLogin c = new ControladorLogin(v,m);
        
          v.setVisible(true);
  
        
    }
    
}
