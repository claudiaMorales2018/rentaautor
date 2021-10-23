
package ControladorRauto;

import ModeloRauto.Conexion;
import ModeloRauto.ModeloInspeccion;
import VistaRauto.Inspeccion;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;


public class ControladorInspeccion {
    
  Conexion c;

    public ControladorInspeccion() {
        c = new Conexion();
    }    
    
    public static Inspeccion Vinspeccion = new Inspeccion(); 
    
    public boolean crearInspeccion(ModeloInspeccion B) {

//      String sql = "INSERT INTO inspeccion (Empresa_Id,Inspeccion_Id,Pedido_Id,Pedido_Linea,Empleado_Id,Inspeccion_Fecha,Inspeccion_Tipo,Inspeccion_Estado,Inspeccion_Resultado)VALUES(?,?,?,?,?,?,?,?) ";
//      String sql = "INSERT INTO inspeccion (Empresa_Id,Inspeccion_Id,Pedido_Id,Pedido_Linea,Empleado_Id,Inspeccion_Tipo,Inspeccion_Estado,Inspeccion_Resultado)VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) ";
      String sql = "INSERT INTO inspeccion (Empresa_Id,Inspeccion_Id,Pedido_Id,Pedido_Linea,Empleado_Id,Inspeccion_Tipo,Inspeccion_Estado,Inspeccion_Resultado,Inspeccion_01_Luz_Delantera_Alta,Inspeccion_02_Luz_Delantera_Baja,Inspeccion_03_Luces_Emergencia,Inspeccion_04_Neblinera,Inspeccion_05_Direccional_Delantera,Inspeccion_06_Direccion_Posteriores,Inspeccion_07_Parabrisas_Delantera,Inspeccion_08_Parabrisas_Posteriores,Inspeccion_09_Ventanas,Inspeccion_10_Espejos_Laterales,Inspeccion_11_Tapa_Tanque,Inspeccion_12_Alarme_Retroceso,Inspeccion_13_Estado_Tablero,Inspeccion_14_Freno_Mano,Inspeccion_15_Freno_Servicios,Inspeccion_16_Cinturon_Seguridad_Chofer,Inspeccion_17_Cinturon_Pasajeros,Inspeccion_18_Orden_Limpieza,Inspeccion_19_Bocinas,Inspeccion_20_Asientos,Inspeccion_21_Llantas_Delantera_Derecha,Inspeccion_22_Llanta_Delantera_Izquierda,Inspeccion_23_Llanta_Posterior_Derecha,Inspeccion_24_Llanta_Posterior_Izquierda,Inspeccion_25_Llanta_Repuesto,Inspeccion_26_Conos_Seguridad,Inspeccion_27_Extintor,Inspeccion_28_Tricket,Inspeccion_29_Rallon_Delantero,Inspeccion_30_Rallon_Trasero,Inspeccion_31_Rallon_Lateral_Derecho,Inspeccion_32_Rallon_Lateral_Izquierdo,Inspeccion_33_Tarjeta_Propiedad,Inspeccion_34_Tanque_Lleno,Inspeccion_35_Llaves) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) ";
      try {
            PreparedStatement ps =c.Conectarbd().prepareStatement(sql);
            System.out.println(ps);
            ps.setInt(1, B.getEmpresaID());
            ps.setInt(2, B.getInspeccionID());
            ps.setInt(3, B.getPedidoID());
            ps.setInt(4, B.getPedidoLinea());
            ps.setInt(5, B.getEmpleadoID());
//            ps.setDate(6, (Date) B.getInspeccionfecha());
            ps.setString(6, B.getInspeccionTipo());
            ps.setString(7, B.getInspeccionEstado());
            ps.setString(8, B.getInspeccionResultado());
           
            ps.setString(9, B.getI01_luzdelanteraAlta());
            ps.setString(10, B.getI02_luzdelanteraBaja());
            ps.setString(11, B.getI03_lucesemergencia());
            ps.setString(12, B.getI04_neblinas());
            ps.setString(13, B.getI05_direcciondelantera());
            ps.setString(14, B.getI06_direccionposteriores());
            ps.setString(15, B.getI07_parabrisasdelantera());
            ps.setString(16, B.getI08_parabrisasposteriores());
            ps.setString(17, B.getI09_ventanas());
            ps.setString(18, B.getI10_espejoslaterales());
            ps.setString(19, B.getI11_tapatanque());
            ps.setString(20, B.getI12_alarmaretroceso());
            ps.setString(21, B.getI13_estadotablero());
            ps.setString(22, B.getI14_frenomano());
            ps.setString(23, B.getI15_serviciofreno());
            ps.setString(24, B.getI16_cinturonseguridadchofer());
            ps.setString(25, B.getI17_cinturonpasajeros());
            ps.setString(26, B.getI18_ordenlimpieza());
            ps.setString(27, B.getI19_bocinas());
            ps.setString(28, B.getI20_asientos());
            ps.setString(29, B.getI21_llantasdelanteraderecha());
            ps.setString(30, B.getI22_llantasdelanteraizquierda());
            ps.setString(31, B.getI23_llantaposteriorderecha());
            ps.setString(32, B.getI24_llantaposteriorizquierda());
            ps.setString(33, B.getI25_llantasderepuesto());
            ps.setString(34, B.getI26_conosseguridad());
            ps.setString(35, B.getI27_extintor());
            ps.setString(36, B.getI28_tricket());
            ps.setString(37, B.getI29_rallondelantero());
            ps.setString(38, B.getI30_rallontrasero());
            ps.setString(39, B.getI31_rallonlateralderecho());
            ps.setString(40, B.getI32_rallonlateralizquierdo());
            ps.setString(41, B.getI33_tarjetapropiedad());
            ps.setString(42, B.getI34_tanquelleno());
            ps.setString(43, B.getI35_llaves());
            
            System.out.println(ps);
            ps.execute();
            ps.close();
            ps = null;
            c.Desconectarbd();
            return true;

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"No se insertó registro","Error Base Datos",JOptionPane.ERROR_MESSAGE);
            //System.out.println("No se Inserto inspección cabecera");
            return false;

        }   
    }   
 //Array Inspeccion del sistema 
 public  ArrayList<ModeloInspeccion> LeerListaInspeccion() {
      //  ArrayList<modelo crudInspeccion> modelo = new ArrayList<crudInspeccion>();
      ArrayList LeerListaInspeccion = new ArrayList();
      ModeloInspeccion Minspeccion;
        try {

            String sql = "SELECT Empresa_Id,Inspeccion_Id,Pedido_Id,Pedido_Linea,Empleado_Id,Inspeccion_Fecha,Inspeccion_Tipo,Inspeccion_Estado,Inspeccion_Resultado  FROM inspeccion";

            PreparedStatement ps = c.Conectarbd().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ModeloInspeccion B = new ModeloInspeccion();
                B.setEmpresaID(rs.getInt(1));
                B.setInspeccionID(rs.getInt(2));
                B.setPedidoID(rs.getInt(3));
                B.setPedidoLinea(rs.getInt(4));
                B.setEmpleadoid(rs.getInt(5));
                B.setInspeccionfecha(rs.getDate(6));
                B.setInspeccionTipo(rs.getString(7));
                B.setInspeccionEstado(rs.getString(8));
                B.setInspeccionResultado(rs.getString(9));
             LeerListaInspeccion.add(B);
            }
            ps.close();
            ps = null;
            c.Desconectarbd();

        } catch (SQLException ex) {
            System.out.println("Fallo la Inspeccion");
        }
        return LeerListaInspeccion;
        
    }
 
 
  //Actualizar Inspeccion del sistema 
  public boolean ActualizarInspeccion(ModeloInspeccion B1,int id ){
 
  
// String sql = "UPDATE inspeccion SET Empresa_Id=?,Pedido_Id=?,Pedido_Linea=?,Empleado_Id=?,Inspeccion_Fecha=?,Inspeccion_Tipo=?,Inspeccion_Estado=?,Inspeccion_Resultado=?  WHERE Inspeccion_Id=? ";
// String sql = "UPDATE inspeccion SET Empresa_Id=?,Pedido_Id=?,Pedido_Linea=?,Empleado_Id=?,Inspeccion_Tipo=?,Inspeccion_Estado=?,Inspeccion_Resultado=?  WHERE Inspeccion_Id=? ";
        String sql = "UPDATE inspeccion SET Empresa_Id=?,Pedido_Id=?,Pedido_Linea=?,Empleado_Id=?,Inspeccion_Tipo=?,Inspeccion_Estado=?,Inspeccion_Resultado=?,Inspeccion_01_Luz_Delantera_Alta=?,Inspeccion_02_Luz_Delantera_Baja=?,Inspeccion_03_Luces_Emergencia=?,Inspeccion_04_Neblinera=?,Inspeccion_05_Direccional_Delantera=?,Inspeccion_06_Direccion_Posteriores=?,Inspeccion_07_Parabrisas_Delantera=?,Inspeccion_08_Parabrisas_Posteriores=?,Inspeccion_09_Ventanas=?,Inspeccion_10_Espejos_Laterales=?,Inspeccion_11_Tapa_Tanque=?,Inspeccion_12_Alarme_Retroceso=?,Inspeccion_13_Estado_Tablero=?,Inspeccion_14_Freno_Mano=?,Inspeccion_15_Freno_Servicios=?,Inspeccion_16_Cinturon_Seguridad_Chofer=?,Inspeccion_17_Cinturon_Pasajeros=?,Inspeccion_18_Orden_Limpieza=?,Inspeccion_19_Bocinas=?,Inspeccion_20_Asientos=?,Inspeccion_21_Llantas_Delantera_Derecha=?,Inspeccion_22_Llanta_Delantera_Izquierda=?,Inspeccion_23_Llanta_Posterior_Derecha=?,Inspeccion_24_Llanta_Posterior_Izquierda=?,Inspeccion_25_Llanta_Repuesto=?,Inspeccion_26_Conos_Seguridad=?,Inspeccion_27_Extintor=?,Inspeccion_28_Tricket=?,Inspeccion_29_Rallon_Delantero=?,Inspeccion_30_Rallon_Trasero=?,Inspeccion_31_Rallon_Lateral_Derecho=?,Inspeccion_32_Rallon_Lateral_Izquierdo=?,Inspeccion_33_Tarjeta_Propiedad=?,Inspeccion_34_Tanque_Lleno=?,Inspeccion_35_Llaves=?  WHERE Inspeccion_Id=? ";
   
        try {
            PreparedStatement ps = c.Conectarbd().prepareStatement(sql);
          
            ps.setInt(1, B1.getEmpresaID());
            ps.setInt(2, B1.getPedidoID());
            ps.setInt(3, B1.getPedidoLinea());
            ps.setInt(4, B1.getEmpleadoID());
//            ps.setDate(5, (Date) B1.getInspeccionfecha());
            ps.setString(5, B1.getInspeccionTipo());
            ps.setString(6, B1.getInspeccionEstado());
            ps.setString(7, B1.getInspeccionResultado());
            
            ps.setString(8, B1.getI01_luzdelanteraAlta());
            ps.setString(9, B1.getI02_luzdelanteraBaja());
            ps.setString(10, B1.getI03_lucesemergencia());
            ps.setString(11, B1.getI04_neblinas());
            ps.setString(12, B1.getI05_direcciondelantera());
            ps.setString(13, B1.getI06_direccionposteriores());
            ps.setString(14, B1.getI07_parabrisasdelantera());
            ps.setString(15, B1.getI08_parabrisasposteriores());
            ps.setString(16, B1.getI09_ventanas());
            ps.setString(17, B1.getI10_espejoslaterales());
            ps.setString(18, B1.getI11_tapatanque());
            ps.setString(19, B1.getI12_alarmaretroceso());
            ps.setString(20, B1.getI13_estadotablero());
            ps.setString(21, B1.getI14_frenomano());
            ps.setString(22, B1.getI15_serviciofreno());
            ps.setString(23, B1.getI16_cinturonseguridadchofer());
            ps.setString(24, B1.getI17_cinturonpasajeros());
            ps.setString(25, B1.getI18_ordenlimpieza());
            ps.setString(26, B1.getI19_bocinas());
            ps.setString(27, B1.getI20_asientos());
            ps.setString(28, B1.getI21_llantasdelanteraderecha());
            ps.setString(29, B1.getI22_llantasdelanteraizquierda());
            ps.setString(30, B1.getI23_llantaposteriorderecha());
            ps.setString(31, B1.getI24_llantaposteriorizquierda());
            ps.setString(32, B1.getI25_llantasderepuesto());
            ps.setString(33, B1.getI26_conosseguridad());
            ps.setString(34, B1.getI27_extintor());
            ps.setString(35, B1.getI28_tricket());
            ps.setString(36, B1.getI29_rallondelantero());
            ps.setString(37, B1.getI30_rallontrasero());
            ps.setString(38, B1.getI31_rallonlateralderecho());
            ps.setString(39, B1.getI32_rallonlateralizquierdo());
            ps.setString(40, B1.getI33_tarjetapropiedad());
            ps.setString(41, B1.getI34_tanquelleno());
            ps.setString(42, B1.getI35_llaves());
            ps.setInt(43, id);
//            System.out.println(sql);
//            System.out.println(ps);
            ps.execute();
            ps.close();
            ps = null;
            c.Desconectarbd();
             return true;
         } catch (SQLException ex) {
            System.out.println("Fallo el update Inspeccion");
        }
       return false;
  } 
  
 //Mostrar Inspeccion del Sistema - Evento Mouse
 public ModeloInspeccion MostrarInspeccion(int id) {
       ModeloInspeccion B= new ModeloInspeccion();
        try {

           
            String sql = "SELECT * FROM inspeccion  WHERE Inspeccion_Id=?";
            PreparedStatement ps = c.Conectarbd().prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                B.setEmpresaID(rs.getInt("Empresa_Id"));
                B.setPedidoID(rs.getInt("Pedido_Id"));
                B.setPedidoLinea(rs.getInt("Pedido_Linea"));
                B.setEmpleadoid(rs.getInt("Empleado_Id"));
                B.setInspeccionfecha(rs.getDate("Inspeccion_Fecha"));
                B.setInspeccionTipo(rs.getString("Inspeccion_Tipo"));
                B.setInspeccionEstado(rs.getString("Inspeccion_Estado"));
                B.setInspeccionResultado(rs.getString("Inspeccion_Resultado"));
                
                B.setInspeccionObservaciones(rs.getString("Inspeccion_Observacion"));
                B.setI01_luzdelanteraAlta(rs.getString("Inspeccion_01_Luz_Delantera_Alta"));
                B.setI02_luzdelanteraBaja(rs.getString("Inspeccion_02_Luz_Delantera_Baja"));
                B.setI03_lucesemergencia(rs.getString("Inspeccion_03_Luces_Emergencia"));
                B.setI04_neblinas(rs.getString("Inspeccion_04_Neblinera"));
                B.setI05_direcciondelantera(rs.getString("Inspeccion_05_Direccional_Delantera"));
                B.setI06_direccionposteriores(rs.getString("Inspeccion_06_Direccion_Posteriores"));
                B.setI07_parabrisasdelantera(rs.getString("Inspeccion_07_Parabrisas_Delantera"));
                B.setI08_parabrisasposteriores(rs.getString("Inspeccion_08_Parabrisas_Posteriores"));
                B.setI09_ventanas(rs.getString("Inspeccion_09_Ventanas"));
                B.setI10_espejoslaterales(rs.getString("Inspeccion_10_Espejos_Laterales")); 
                B.setI11_tapatanque(rs.getString("Inspeccion_11_Tapa_Tanque"));
                B.setI12_alarmaretroceso(rs.getString("Inspeccion_12_Alarme_Retroceso"));
                B.setI13_estadotablero(rs.getString("Inspeccion_13_Estado_Tablero"));
                B.setI14_frenomano(rs.getString("Inspeccion_14_Freno_Mano"));
                B.setI15_serviciofreno(rs.getString("Inspeccion_15_Freno_Servicios"));
                B.setI16_cinturonseguridadchofer(rs.getString("Inspeccion_16_Cinturon_Seguridad_Chofer"));
                B.setI17_cinturonpasajeros(rs.getString("Inspeccion_17_Cinturon_Pasajeros"));
                B.setI18_ordenlimpieza(rs.getString("Inspeccion_18_Orden_Limpieza"));
                B.setI19_bocinas(rs.getString("Inspeccion_19_Bocinas"));
                B.setI20_asientos(rs.getString("Inspeccion_20_Asientos"));
                B.setI21_llantasdelanteraderecha(rs.getString("Inspeccion_21_Llantas_Delantera_Derecha"));
                B.setI22_llantasdelanteraizquierda(rs.getString("Inspeccion_22_Llanta_Delantera_Izquierda"));
                B.setI23_llantaposteriorderecha(rs.getString("Inspeccion_23_Llanta_Posterior_Derecha"));
                B.setI24_llantaposteriorizquierda(rs.getString("Inspeccion_24_Llanta_Posterior_Izquierda"));
                B.setI25_llantasderepuesto(rs.getString("Inspeccion_25_Llanta_Repuesto"));
                B.setI26_conosseguridad(rs.getString("Inspeccion_26_Conos_Seguridad"));
                B.setI27_extintor(rs.getString("Inspeccion_27_Extintor"));
                B.setI28_tricket(rs.getString("Inspeccion_28_Tricket"));
                B.setI29_rallondelantero(rs.getString("Inspeccion_29_Rallon_Delantero"));
                B.setI30_rallontrasero(rs.getString("Inspeccion_30_Rallon_Trasero"));
                B.setI31_rallonlateralderecho(rs.getString("Inspeccion_31_Rallon_Lateral_Derecho"));
                B.setI32_rallonlateralizquierdo(rs.getString("Inspeccion_32_Rallon_Lateral_Izquierdo"));
                B.setI33_tarjetapropiedad(rs.getString("Inspeccion_33_Tarjeta_Propiedad"));
                B.setI34_tanquelleno(rs.getString("Inspeccion_34_Tanque_Lleno"));
                B.setI35_llaves(rs.getString("Inspeccion_35_Llaves"));
            }
            ps.close();
            ps = null;
            c.Desconectarbd();

        } catch (SQLException ex) {
            System.out.println("Fallo la lectura Inspeccion");
        }
        return B;
    }
  
 
  //Suprimir Usuario del Sistema  
   public  boolean eliminarInspeccion (int id){
    
        try {
            String sql="DELETE FROM inspeccion WHERE Inspeccion_Id=? ";
            PreparedStatement ps=c.Conectarbd().prepareStatement(sql);
            ps.setInt(1, id);                   
            ps.execute();
            ps.close();
            ps=null;
            c.Desconectarbd();
            return true;
        } catch (SQLException ex) {
          return false;
        }
    }
      
}
