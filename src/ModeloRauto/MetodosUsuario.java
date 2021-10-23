
package ModeloRauto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;


public class MetodosUsuario {
    
    
    
    
 Conexion conexion;  

    public MetodosUsuario() {
        conexion = new Conexion();
    }

public ArrayList<ModeloUsuario>login(String Usuario_Login, String Usuario_PWG) {

    
    Connection conectar=null;
    PreparedStatement ps;
    ResultSet rs;
    ModeloUsuario usuario;
    ArrayList list= new ArrayList();
    
    try {
        conectar=conexion.Conectarbd();
        
        if (conectar!=null) {
            String sql="SELECT Usuario_Login,Usuario_PWG From  usuario WHERE Usuario_Login=? And  Usuario_PWG=?";
            
            ps=conectar.prepareStatement(sql);
            ps.setString(1, Usuario_Login);
            ps.setString(2,Usuario_PWG);
            
            rs=ps.executeQuery();
            while(rs.next()){
                
                usuario = new ModeloUsuario();
                usuario.setUsuario_Login(rs.getString("Usuario_Login"));
                usuario.setUsuario_PWG(rs.getString("Usuario_PWG"));
                list.add(usuario);
            
            } 
        }
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null,"Error" +e,"Error",JOptionPane.ERROR_MESSAGE);
    }
    finally{
     
        try { 
            conectar.close();
        
    } catch (Exception e) {
    }
    
}
return list;
}
    
}
