
package ControladorRauto;

import ModeloRauto.MetodosUsuario;
import ModeloRauto.ModeloInspeccion;
import ModeloRauto.ModeloSistema;
import ModeloRauto.ModeloUsuario;
import VistaRauto.InicioSistema;
import VistaRauto.Inspeccion;
import VistaRauto.VistaLogin;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class ControladorLogin  implements ActionListener, MouseListener{
    //Se declaran los controladores
    ControladorInspeccion CIN = new ControladorInspeccion();
    
    // Se declaran las Vistas del Sistema
    VistaRauto.VistaLogin VistaL = new VistaRauto.VistaLogin ();
    VistaRauto.InicioSistema VistaInicio = new VistaRauto.InicioSistema();
    VistaRauto.Inspeccion VistaInspeccion = new VistaRauto.Inspeccion();
    
    
    //Se declaran los modelos del Sistema
    MetodosUsuario modelo_login = new  MetodosUsuario();
    ModeloSistema modelo_sistema = new ModeloSistema();
    ModeloInspeccion modelo_inspeccion = new ModeloInspeccion();

    //Se declaran variables Globales
    int inspeccion_seleccionada;
    Date FechaInspeccion3 = null;
    
    
    // Controlador Principal = ControladorLogin
    // Controlador Login = capturar vista Login
    public ControladorLogin(VistaRauto.VistaLogin VistaL, ModeloUsuario modeloL){
        this.VistaL = VistaL;
        VistaL.btn_enter.addActionListener(this);
        VistaL.btn_salir.addActionListener(this);
      }
    
    // Controlador Login = capturar vista Inicio Sistema
    public ControladorLogin (VistaRauto.InicioSistema VistaInicio, ModeloSistema modelo_sistema ) {
        this.VistaInicio=VistaInicio;
        this.modelo_sistema=modelo_sistema;
        VistaInicio.btnInspeccion.addActionListener(this);      
    }
    
    // Controlador Login = capturar vista Inspeccion
    public ControladorLogin (VistaRauto.Inspeccion VistaInspeccion, ModeloInspeccion modelo_inspeccion ) {
        this.VistaInspeccion=VistaInspeccion;
        this.modelo_inspeccion=modelo_inspeccion;
        VistaInspeccion.btnCrearInspeccion.addActionListener(this);
        VistaInspeccion.btnMostrarInspeccion.addActionListener(this);
        VistaInspeccion.btnEliminarInspeccion.addActionListener(this);
        VistaInspeccion.btnmodificarInspeccion.addActionListener(this);
        inspeccion_limpiarventana();
        inspeccion_refrescartabla();
    }
    
   
    public static Date ParseFecha(String FechaString3)
    {
         SimpleDateFormat formato3 = new SimpleDateFormat("yyyy-M-d");
         Date FechaInspeccion3 = null;
         try {
            FechaInspeccion3 = formato3.parse(FechaString3);
         } 
         catch (ParseException ex) 
         {
             System.out.println(ex);
         }
         return FechaInspeccion3;
     
        } 
    
    //Inicia Metodos / Funciones de las diferentes Vistas / Botones
    //Menu del Sistema
      public void sistema_obtenerfechaactual() { 
        //Instanciamos el objeto Calendar
        //en fecha obtenemos la fecha  
        
        Calendar fecha = new GregorianCalendar();
//        Calendar fecha = Calendar.getInstance();
                                                    
        int anio = fecha.get(Calendar.YEAR);
        int mes = fecha.get(Calendar.MONTH)+1;
        int dia = fecha.get(Calendar.DAY_OF_MONTH);


        String mes_letras;
        String MES[] = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};
        mes_letras = MES[mes-1];
        String FechaDia = Integer.toString(dia) + " de " + mes_letras + " del " + Integer.toString(anio);
        VistaInicio.txtFechaI.setText(FechaDia);
    }
   
   // CRUD - Inspeccion
    public void inspeccion_refrescartabla() { 
    
    //Actualiza información en la tabla  incrustada de la ventana
    DefaultTableModel modeloT = new DefaultTableModel();
    VistaInspeccion.tablaRecepcion.setModel(modeloT);
    
    Date FechaInspeccion; 
    String FechaString;
    SimpleDateFormat formato = new SimpleDateFormat("d/M/yyyy");
        
    //Define las columnas de la tabla
    modeloT.addColumn("Empresa");
    modeloT.addColumn("Numero");
    modeloT.addColumn("Pedido");
    modeloT.addColumn("NoLinea");
    modeloT.addColumn("Empleado");
    modeloT.addColumn("Fecha");
    modeloT.addColumn("Tipo");
    modeloT.addColumn("Estado");
    modeloT.addColumn("Resultado");
       
    //Llena vector o filas de la tabla 
     Object [] columna = new Object [9];
       int    numRegistros  = CIN.LeerListaInspeccion().size();
            for (int i = 0; i < numRegistros; i++) {
                columna[0] = CIN.LeerListaInspeccion().get(i).getEmpresaID();
                columna[1] = CIN.LeerListaInspeccion().get(i).getInspeccionID();
                columna[2] = CIN.LeerListaInspeccion().get(i).getPedidoID();
                columna[3] = CIN.LeerListaInspeccion().get(i).getPedidoLinea();
                columna[4] = CIN.LeerListaInspeccion().get(i).getEmpleadoID();
                FechaInspeccion = CIN.LeerListaInspeccion().get(i).getInspeccionfecha();
                FechaString = formato.format(FechaInspeccion);
   //                columna[5] = CIN.LeerListaInspeccion().get(i).getInspeccionfecha();
                columna[5] = FechaString;
                columna[6] = CIN.LeerListaInspeccion().get(i).getInspeccionTipo();
                columna[7] = CIN.LeerListaInspeccion().get(i).getInspeccionEstado();
                columna[8] = CIN.LeerListaInspeccion().get(i).getInspeccionResultado();
                modeloT.addRow(columna);
            }
    }
      
      public void inspeccion_limpiarventana(){
       //Limpia contenidos previos
       this.VistaInspeccion.txtEmpresa.setText("");
       this.VistaInspeccion.txtNumero.setText("");
       this.VistaInspeccion.txtInspeccion.setText("");
       this.VistaInspeccion.txtEmpleado.setText("");
       this.VistaInspeccion.txtPedido.setText("");
       this.VistaInspeccion.txtFecha.setText("");
       this.VistaInspeccion.checkentrega.setSelected(false);
       this.VistaInspeccion.checkrecepcion.setSelected(false);
       
       this.VistaInspeccion.Insp_1.setText("");
       this.VistaInspeccion.Insp_2.setText("");
       this.VistaInspeccion.Insp_3.setText("");
       this.VistaInspeccion.Insp_4.setText("");
       this.VistaInspeccion.Insp_5.setText("");
       this.VistaInspeccion.Insp_6.setText("");
       this.VistaInspeccion.Insp_7.setText("");
       this.VistaInspeccion.Insp_8.setText("");
       this.VistaInspeccion.Insp_9.setText("");
       this.VistaInspeccion.Insp_10.setText("");
       
       this.VistaInspeccion.Insp_11.setText("");
       this.VistaInspeccion.Insp_12.setText("");
       this.VistaInspeccion.Insp_13.setText("");
       this.VistaInspeccion.Insp_14.setText("");
       this.VistaInspeccion.Insp_15.setText("");
       this.VistaInspeccion.Insp_16.setText("");
       this.VistaInspeccion.Insp_17.setText("");
       this.VistaInspeccion.Insp_18.setText("");
       this.VistaInspeccion.Insp_19.setText("");
       this.VistaInspeccion.Insp_20.setText("");
       
       this.VistaInspeccion.Insp_21.setText("");
       this.VistaInspeccion.Insp_22.setText("");
       this.VistaInspeccion.Insp_23.setText("");
       this.VistaInspeccion.Insp_24.setText("");
       this.VistaInspeccion.Insp_25.setText("");
       this.VistaInspeccion.Insp_26.setText("");
       this.VistaInspeccion.Insp_27.setText("");
       this.VistaInspeccion.Insp_28.setText("");
       this.VistaInspeccion.Insp_29.setText("");
       this.VistaInspeccion.Insp_30.setText("");
       
       this.VistaInspeccion.Insp_31.setText("");
       this.VistaInspeccion.Insp_32.setText("");
       this.VistaInspeccion.Insp_33.setText("");
       this.VistaInspeccion.Insp_34.setText("");
       this.VistaInspeccion.Insp_35.setText("");
       
       //Asigna fondo blanco a campos de inspección
        this.VistaInspeccion.Insp_1.setBackground(Color.WHITE);
        this.VistaInspeccion.Insp_2.setBackground(Color.WHITE);
        this.VistaInspeccion.Insp_3.setBackground(Color.WHITE);
        this.VistaInspeccion.Insp_4.setBackground(Color.WHITE);
        this.VistaInspeccion.Insp_5.setBackground(Color.WHITE);
        this.VistaInspeccion.Insp_6.setBackground(Color.WHITE);
        this.VistaInspeccion.Insp_7.setBackground(Color.WHITE);
        this.VistaInspeccion.Insp_8.setBackground(Color.WHITE);
        this.VistaInspeccion.Insp_9.setBackground(Color.WHITE);
        this.VistaInspeccion.Insp_10.setBackground(Color.WHITE);

        this.VistaInspeccion.Insp_11.setBackground(Color.WHITE);
        this.VistaInspeccion.Insp_12.setBackground(Color.WHITE);
        this.VistaInspeccion.Insp_13.setBackground(Color.WHITE);
        this.VistaInspeccion.Insp_14.setBackground(Color.WHITE);
        this.VistaInspeccion.Insp_15.setBackground(Color.WHITE);
        this.VistaInspeccion.Insp_16.setBackground(Color.WHITE);
        this.VistaInspeccion.Insp_17.setBackground(Color.WHITE);
        this.VistaInspeccion.Insp_18.setBackground(Color.WHITE);
        this.VistaInspeccion.Insp_19.setBackground(Color.WHITE);
        this.VistaInspeccion.Insp_20.setBackground(Color.WHITE);

        this.VistaInspeccion.Insp_21.setBackground(Color.WHITE);
        this.VistaInspeccion.Insp_22.setBackground(Color.WHITE);
        this.VistaInspeccion.Insp_23.setBackground(Color.WHITE);
        this.VistaInspeccion.Insp_24.setBackground(Color.WHITE);
        this.VistaInspeccion.Insp_25.setBackground(Color.WHITE);
        this.VistaInspeccion.Insp_26.setBackground(Color.WHITE);
        this.VistaInspeccion.Insp_27.setBackground(Color.WHITE);
        this.VistaInspeccion.Insp_28.setBackground(Color.WHITE);
        this.VistaInspeccion.Insp_29.setBackground(Color.WHITE);
        this.VistaInspeccion.Insp_30.setBackground(Color.WHITE);

        this.VistaInspeccion.Insp_31.setBackground(Color.WHITE);
        this.VistaInspeccion.Insp_32.setBackground(Color.WHITE);
        this.VistaInspeccion.Insp_33.setBackground(Color.WHITE);
        this.VistaInspeccion.Insp_34.setBackground(Color.WHITE);
        this.VistaInspeccion.Insp_35.setBackground(Color.WHITE);
       
  } 
  
   public void inspeccion_alterarBackground(){
      // Cambiar el color del backgroud segun el valor de la base de datos (B - M - N)
      
        if ("B".equals(VistaInspeccion.Insp_1.getText())) VistaInspeccion.Insp_1.setBackground(Color.GREEN);
        if ("M".equals(VistaInspeccion.Insp_1.getText())) VistaInspeccion.Insp_1.setBackground(Color.RED);
        if ("N".equals(VistaInspeccion.Insp_1.getText())) VistaInspeccion.Insp_1.setBackground(Color.GRAY);

        if ("B".equals(VistaInspeccion.Insp_2.getText())) VistaInspeccion.Insp_2.setBackground(Color.GREEN);
        if ("M".equals(VistaInspeccion.Insp_2.getText())) VistaInspeccion.Insp_2.setBackground(Color.RED);
        if ("N".equals(VistaInspeccion.Insp_2.getText())) VistaInspeccion.Insp_2.setBackground(Color.GRAY);

        if ("B".equals(VistaInspeccion.Insp_3.getText())) VistaInspeccion.Insp_3.setBackground(Color.GREEN);
        if ("M".equals(VistaInspeccion.Insp_3.getText())) VistaInspeccion.Insp_3.setBackground(Color.RED);
        if ("N".equals(VistaInspeccion.Insp_3.getText())) VistaInspeccion.Insp_3.setBackground(Color.GRAY);

        if ("B".equals(VistaInspeccion.Insp_4.getText())) VistaInspeccion.Insp_4.setBackground(Color.GREEN);
        if ("M".equals(VistaInspeccion.Insp_4.getText())) VistaInspeccion.Insp_4.setBackground(Color.RED);
        if ("N".equals(VistaInspeccion.Insp_4.getText())) VistaInspeccion.Insp_4.setBackground(Color.GRAY);

        if ("B".equals(VistaInspeccion.Insp_5.getText())) VistaInspeccion.Insp_5.setBackground(Color.GREEN);
        if ("M".equals(VistaInspeccion.Insp_5.getText())) VistaInspeccion.Insp_5.setBackground(Color.RED);
        if ("N".equals(VistaInspeccion.Insp_5.getText())) VistaInspeccion.Insp_5.setBackground(Color.GRAY);

        if ("B".equals(VistaInspeccion.Insp_6.getText())) VistaInspeccion.Insp_6.setBackground(Color.GREEN);
        if ("M".equals(VistaInspeccion.Insp_6.getText())) VistaInspeccion.Insp_6.setBackground(Color.RED);
        if ("N".equals(VistaInspeccion.Insp_6.getText())) VistaInspeccion.Insp_6.setBackground(Color.GRAY);

        if ("B".equals(VistaInspeccion.Insp_7.getText())) VistaInspeccion.Insp_7.setBackground(Color.GREEN);
        if ("M".equals(VistaInspeccion.Insp_7.getText())) VistaInspeccion.Insp_7.setBackground(Color.RED);
        if ("N".equals(VistaInspeccion.Insp_7.getText())) VistaInspeccion.Insp_7.setBackground(Color.GRAY);

        if ("B".equals(VistaInspeccion.Insp_8.getText())) VistaInspeccion.Insp_8.setBackground(Color.GREEN);
        if ("M".equals(VistaInspeccion.Insp_8.getText())) VistaInspeccion.Insp_8.setBackground(Color.RED);
        if ("N".equals(VistaInspeccion.Insp_8.getText())) VistaInspeccion.Insp_8.setBackground(Color.GRAY);

        if ("B".equals(VistaInspeccion.Insp_9.getText())) VistaInspeccion.Insp_9.setBackground(Color.GREEN);
        if ("M".equals(VistaInspeccion.Insp_9.getText())) VistaInspeccion.Insp_9.setBackground(Color.RED);
        if ("N".equals(VistaInspeccion.Insp_9.getText())) VistaInspeccion.Insp_9.setBackground(Color.GRAY);

        if ("B".equals(VistaInspeccion.Insp_10.getText())) VistaInspeccion.Insp_10.setBackground(Color.GREEN);
        if ("M".equals(VistaInspeccion.Insp_10.getText())) VistaInspeccion.Insp_10.setBackground(Color.RED);
        if ("N".equals(VistaInspeccion.Insp_10.getText())) VistaInspeccion.Insp_10.setBackground(Color.GRAY);

        if ("B".equals(VistaInspeccion.Insp_11.getText())) VistaInspeccion.Insp_11.setBackground(Color.GREEN);
        if ("M".equals(VistaInspeccion.Insp_11.getText())) VistaInspeccion.Insp_11.setBackground(Color.RED);
        if ("N".equals(VistaInspeccion.Insp_11.getText())) VistaInspeccion.Insp_11.setBackground(Color.GRAY);

        if ("B".equals(VistaInspeccion.Insp_12.getText())) VistaInspeccion.Insp_12.setBackground(Color.GREEN);
        if ("M".equals(VistaInspeccion.Insp_12.getText())) VistaInspeccion.Insp_12.setBackground(Color.RED);
        if ("N".equals(VistaInspeccion.Insp_12.getText())) VistaInspeccion.Insp_12.setBackground(Color.GRAY);

        if ("B".equals(VistaInspeccion.Insp_13.getText())) VistaInspeccion.Insp_13.setBackground(Color.GREEN);
        if ("M".equals(VistaInspeccion.Insp_13.getText())) VistaInspeccion.Insp_13.setBackground(Color.RED);
        if ("N".equals(VistaInspeccion.Insp_13.getText())) VistaInspeccion.Insp_13.setBackground(Color.GRAY);

        if ("B".equals(VistaInspeccion.Insp_14.getText())) VistaInspeccion.Insp_14.setBackground(Color.GREEN);
        if ("M".equals(VistaInspeccion.Insp_14.getText())) VistaInspeccion.Insp_14.setBackground(Color.RED);
        if ("N".equals(VistaInspeccion.Insp_14.getText())) VistaInspeccion.Insp_14.setBackground(Color.GRAY);

        if ("B".equals(VistaInspeccion.Insp_15.getText())) VistaInspeccion.Insp_15.setBackground(Color.GREEN);
        if ("M".equals(VistaInspeccion.Insp_15.getText())) VistaInspeccion.Insp_15.setBackground(Color.RED);
        if ("N".equals(VistaInspeccion.Insp_15.getText())) VistaInspeccion.Insp_15.setBackground(Color.GRAY);

        if ("B".equals(VistaInspeccion.Insp_16.getText())) VistaInspeccion.Insp_16.setBackground(Color.GREEN);
        if ("M".equals(VistaInspeccion.Insp_16.getText())) VistaInspeccion.Insp_16.setBackground(Color.RED);
        if ("N".equals(VistaInspeccion.Insp_16.getText())) VistaInspeccion.Insp_16.setBackground(Color.GRAY);

        if ("B".equals(VistaInspeccion.Insp_17.getText())) VistaInspeccion.Insp_17.setBackground(Color.GREEN);
        if ("M".equals(VistaInspeccion.Insp_17.getText())) VistaInspeccion.Insp_17.setBackground(Color.RED);
        if ("N".equals(VistaInspeccion.Insp_17.getText())) VistaInspeccion.Insp_17.setBackground(Color.GRAY);

        if ("B".equals(VistaInspeccion.Insp_18.getText())) VistaInspeccion.Insp_18.setBackground(Color.GREEN);
        if ("M".equals(VistaInspeccion.Insp_18.getText())) VistaInspeccion.Insp_18.setBackground(Color.RED);
        if ("N".equals(VistaInspeccion.Insp_18.getText())) VistaInspeccion.Insp_18.setBackground(Color.GRAY);

        if ("B".equals(VistaInspeccion.Insp_19.getText())) VistaInspeccion.Insp_19.setBackground(Color.GREEN);
        if ("M".equals(VistaInspeccion.Insp_19.getText())) VistaInspeccion.Insp_19.setBackground(Color.RED);
        if ("N".equals(VistaInspeccion.Insp_19.getText())) VistaInspeccion.Insp_19.setBackground(Color.GRAY);

        if ("B".equals(VistaInspeccion.Insp_20.getText())) VistaInspeccion.Insp_20.setBackground(Color.GREEN);
        if ("M".equals(VistaInspeccion.Insp_20.getText())) VistaInspeccion.Insp_20.setBackground(Color.RED);
        if ("N".equals(VistaInspeccion.Insp_20.getText())) VistaInspeccion.Insp_20.setBackground(Color.GRAY);

        if ("B".equals(VistaInspeccion.Insp_21.getText())) VistaInspeccion.Insp_21.setBackground(Color.GREEN);
        if ("M".equals(VistaInspeccion.Insp_21.getText())) VistaInspeccion.Insp_21.setBackground(Color.RED);
        if ("N".equals(VistaInspeccion.Insp_21.getText())) VistaInspeccion.Insp_21.setBackground(Color.GRAY);

        if ("B".equals(VistaInspeccion.Insp_22.getText())) VistaInspeccion.Insp_22.setBackground(Color.GREEN);
        if ("M".equals(VistaInspeccion.Insp_22.getText())) VistaInspeccion.Insp_22.setBackground(Color.RED);
        if ("N".equals(VistaInspeccion.Insp_22.getText())) VistaInspeccion.Insp_22.setBackground(Color.GRAY);

        if ("B".equals(VistaInspeccion.Insp_23.getText())) VistaInspeccion.Insp_23.setBackground(Color.GREEN);
        if ("M".equals(VistaInspeccion.Insp_23.getText())) VistaInspeccion.Insp_23.setBackground(Color.RED);
        if ("N".equals(VistaInspeccion.Insp_23.getText())) VistaInspeccion.Insp_23.setBackground(Color.GRAY);

        if ("B".equals(VistaInspeccion.Insp_24.getText())) VistaInspeccion.Insp_24.setBackground(Color.GREEN);
        if ("M".equals(VistaInspeccion.Insp_24.getText())) VistaInspeccion.Insp_24.setBackground(Color.RED);
        if ("N".equals(VistaInspeccion.Insp_24.getText())) VistaInspeccion.Insp_24.setBackground(Color.GRAY);

        if ("B".equals(VistaInspeccion.Insp_25.getText())) VistaInspeccion.Insp_25.setBackground(Color.GREEN);
        if ("M".equals(VistaInspeccion.Insp_25.getText())) VistaInspeccion.Insp_25.setBackground(Color.RED);
        if ("N".equals(VistaInspeccion.Insp_25.getText())) VistaInspeccion.Insp_25.setBackground(Color.GRAY);

        if ("B".equals(VistaInspeccion.Insp_26.getText())) VistaInspeccion.Insp_26.setBackground(Color.GREEN);
        if ("M".equals(VistaInspeccion.Insp_26.getText())) VistaInspeccion.Insp_26.setBackground(Color.RED);
        if ("N".equals(VistaInspeccion.Insp_26.getText())) VistaInspeccion.Insp_26.setBackground(Color.GRAY);

        if ("B".equals(VistaInspeccion.Insp_27.getText())) VistaInspeccion.Insp_27.setBackground(Color.GREEN);
        if ("M".equals(VistaInspeccion.Insp_27.getText())) VistaInspeccion.Insp_27.setBackground(Color.RED);
        if ("N".equals(VistaInspeccion.Insp_27.getText())) VistaInspeccion.Insp_27.setBackground(Color.GRAY);

        if ("B".equals(VistaInspeccion.Insp_28.getText())) VistaInspeccion.Insp_28.setBackground(Color.GREEN);
        if ("M".equals(VistaInspeccion.Insp_28.getText())) VistaInspeccion.Insp_28.setBackground(Color.RED);
        if ("N".equals(VistaInspeccion.Insp_28.getText())) VistaInspeccion.Insp_28.setBackground(Color.GRAY);

        if ("B".equals(VistaInspeccion.Insp_29.getText())) VistaInspeccion.Insp_29.setBackground(Color.GREEN);
        if ("M".equals(VistaInspeccion.Insp_29.getText())) VistaInspeccion.Insp_29.setBackground(Color.RED);
        if ("N".equals(VistaInspeccion.Insp_29.getText())) VistaInspeccion.Insp_29.setBackground(Color.GRAY);

        if ("B".equals(VistaInspeccion.Insp_30.getText())) VistaInspeccion.Insp_30.setBackground(Color.GREEN);
        if ("M".equals(VistaInspeccion.Insp_30.getText())) VistaInspeccion.Insp_30.setBackground(Color.RED);
        if ("N".equals(VistaInspeccion.Insp_30.getText())) VistaInspeccion.Insp_30.setBackground(Color.GRAY);

        if ("B".equals(VistaInspeccion.Insp_31.getText())) VistaInspeccion.Insp_31.setBackground(Color.GREEN);
        if ("M".equals(VistaInspeccion.Insp_31.getText())) VistaInspeccion.Insp_31.setBackground(Color.RED);
        if ("N".equals(VistaInspeccion.Insp_31.getText())) VistaInspeccion.Insp_31.setBackground(Color.GRAY);

        if ("B".equals(VistaInspeccion.Insp_32.getText())) VistaInspeccion.Insp_32.setBackground(Color.GREEN);
        if ("M".equals(VistaInspeccion.Insp_32.getText())) VistaInspeccion.Insp_32.setBackground(Color.RED);
        if ("N".equals(VistaInspeccion.Insp_32.getText())) VistaInspeccion.Insp_32.setBackground(Color.GRAY);

        if ("B".equals(VistaInspeccion.Insp_33.getText())) VistaInspeccion.Insp_33.setBackground(Color.GREEN);
        if ("M".equals(VistaInspeccion.Insp_33.getText())) VistaInspeccion.Insp_33.setBackground(Color.RED);
        if ("N".equals(VistaInspeccion.Insp_33.getText())) VistaInspeccion.Insp_33.setBackground(Color.GRAY);

        if ("B".equals(VistaInspeccion.Insp_34.getText())) VistaInspeccion.Insp_34.setBackground(Color.GREEN);
        if ("M".equals(VistaInspeccion.Insp_34.getText())) VistaInspeccion.Insp_34.setBackground(Color.RED);
        if ("N".equals(VistaInspeccion.Insp_34.getText())) VistaInspeccion.Insp_34.setBackground(Color.GRAY);

        if ("B".equals(VistaInspeccion.Insp_35.getText())) VistaInspeccion.Insp_35.setBackground(Color.GREEN);
        if ("M".equals(VistaInspeccion.Insp_35.getText())) VistaInspeccion.Insp_35.setBackground(Color.RED);
        if ("N".equals(VistaInspeccion.Insp_35.getText())) VistaInspeccion.Insp_35.setBackground(Color.GRAY);
 } 
      
      public void inspeccion_mostrarelemento() { 
           //Muestra informacion detallada de la inspeccion seleccionada del Grid
           //Obtiene el ID de la inspección
           int fila = VistaInspeccion.tablaRecepcion.getSelectedRow();
           inspeccion_seleccionada = Integer.parseInt(VistaInspeccion.tablaRecepcion.getValueAt(fila, 1).toString());
           
           // Ejecuta sentencia SQL
            modelo_inspeccion = CIN.MostrarInspeccion(inspeccion_seleccionada);
            
            //Obtiene los valores del resultado del Select
            VistaInspeccion.txtEmpresa.setText("" + modelo_inspeccion.getEmpresaID());
            VistaInspeccion.txtNumero.setText("" + modelo_inspeccion.getPedidoLinea());
            VistaInspeccion.txtInspeccion.setText("" + inspeccion_seleccionada);
            VistaInspeccion.txtEmpleado.setText("" + modelo_inspeccion.getEmpleadoID());
            VistaInspeccion.txtPedido.setText("" + modelo_inspeccion.getPedidoID());
            //Cambia formato a la fecha
            Date FechaInspeccion2; 
            String FechaString2;
            SimpleDateFormat formato2 = new SimpleDateFormat("dd/MM/yyyy");
            FechaInspeccion2 = modelo_inspeccion.getInspeccionfecha();
            FechaString2 = formato2.format(FechaInspeccion2);
            VistaInspeccion.txtFecha.setText("" + FechaString2);
//              VistaInspeccion.txtFecha.setText("" + modelo_inspeccion.getInspeccionfecha());
            
            //Identifica que mostrar acorde Tipo Inspeccion - Estado - Resultado
            String TipoInspeccion = "";
            String VEstado = "";
            String VResultado = "";
            
            //Asigna valores a variables
            TipoInspeccion = modelo_inspeccion.getInspeccionTipo();
            VEstado = modelo_inspeccion.getInspeccionEstado();
            VResultado = modelo_inspeccion.getInspeccionResultado();
             
            //Compara resultados obtenidos - Tipo Inspección
            if ("E".equals(TipoInspeccion)) VistaInspeccion.checkentrega.setSelected(true);
            if ("R".equals(TipoInspeccion)) VistaInspeccion.checkrecepcion.setSelected(true);
            
            //Compara resultados obtenidos - VEstado
            if ("NI".equals(VEstado)) VistaInspeccion.comboInspEstado.setSelectedItem("NI-No Iniciada");
            if ("PA".equals(VEstado)) VistaInspeccion.comboInspEstado.setSelectedItem("PA-Parcial");
            if ("CO".equals(VEstado)) VistaInspeccion.comboInspEstado.setSelectedItem("CO-Completa");
            
             //Compara resultados obtenidos - VResultado
            if ("C".equals(VResultado)) VistaInspeccion.comboInspResultado.setSelectedItem("C-Confirmada");
            if ("N".equals(VResultado)) VistaInspeccion.comboInspResultado.setSelectedItem("N-No Confirmada");
          
                
            //Muestra el detalle de la inspeccion            
            VistaInspeccion.Insp_1.setText(modelo_inspeccion.getI01_luzdelanteraAlta());
            VistaInspeccion.Insp_2.setText(modelo_inspeccion.getI02_luzdelanteraBaja());
            VistaInspeccion.Insp_3.setText(modelo_inspeccion.getI03_lucesemergencia());
            VistaInspeccion.Insp_4.setText(modelo_inspeccion.getI04_neblinas()); 
            VistaInspeccion.Insp_5.setText(modelo_inspeccion.getI05_direcciondelantera()); 
            
            VistaInspeccion.Insp_6.setText(modelo_inspeccion.getI06_direccionposteriores()); 
            VistaInspeccion.Insp_7.setText(modelo_inspeccion.getI07_parabrisasdelantera()); 
            VistaInspeccion.Insp_8.setText(modelo_inspeccion.getI08_parabrisasposteriores());
            VistaInspeccion.Insp_9.setText(modelo_inspeccion.getI09_ventanas()); 
            VistaInspeccion.Insp_10.setText(modelo_inspeccion.getI10_espejoslaterales());
            
            VistaInspeccion.Insp_11.setText(modelo_inspeccion.getI11_tapatanque());
            VistaInspeccion.Insp_12.setText(modelo_inspeccion.getI12_alarmaretroceso());
            VistaInspeccion.Insp_13.setText(modelo_inspeccion.getI13_estadotablero()); 
            VistaInspeccion.Insp_14.setText(modelo_inspeccion.getI14_frenomano()); 
            VistaInspeccion.Insp_15.setText(modelo_inspeccion.getI15_serviciofreno());
            VistaInspeccion.Insp_16.setText(modelo_inspeccion.getI16_cinturonseguridadchofer());
            VistaInspeccion.Insp_17.setText(modelo_inspeccion.getI17_cinturonpasajeros()); 
            VistaInspeccion.Insp_18.setText(modelo_inspeccion.getI18_ordenlimpieza());
            VistaInspeccion.Insp_19.setText(modelo_inspeccion.getI19_bocinas());
            VistaInspeccion.Insp_20.setText(modelo_inspeccion.getI20_asientos());
            
            VistaInspeccion.Insp_21.setText(modelo_inspeccion.getI21_llantasdelanteraderecha());
            VistaInspeccion.Insp_22.setText(modelo_inspeccion.getI22_llantasdelanteraizquierda());
            VistaInspeccion.Insp_23.setText(modelo_inspeccion.getI23_llantaposteriorderecha());
            VistaInspeccion.Insp_24.setText(modelo_inspeccion.getI24_llantaposteriorizquierda()); 
            VistaInspeccion.Insp_25.setText(modelo_inspeccion.getI25_llantasderepuesto()); 
            VistaInspeccion.Insp_26.setText(modelo_inspeccion.getI26_conosseguridad()); 
            VistaInspeccion.Insp_27.setText(modelo_inspeccion.getI27_extintor()); 
            VistaInspeccion.Insp_28.setText(modelo_inspeccion.getI28_tricket()); 
            VistaInspeccion.Insp_29.setText(modelo_inspeccion.getI29_rallondelantero());
            VistaInspeccion.Insp_30.setText(modelo_inspeccion.getI30_rallontrasero()); 
            
            VistaInspeccion.Insp_31.setText(modelo_inspeccion.getI31_rallonlateralderecho()); 
            VistaInspeccion.Insp_32.setText(modelo_inspeccion.getI32_rallonlateralizquierdo());
            VistaInspeccion.Insp_33.setText(modelo_inspeccion.getI33_tarjetapropiedad()); 
            VistaInspeccion.Insp_34.setText(modelo_inspeccion.getI34_tanquelleno()); 
            VistaInspeccion.Insp_35.setText(modelo_inspeccion.getI35_llaves()); 
            
            //Evalua si cambia formato acorde al valor identificado
            inspeccion_alterarBackground();
      }
    
    
  
      
      
    
    
    
    
    
    
    //Capturar eventos de las diferentes Vistas
    @Override
    public void actionPerformed(ActionEvent e) {

       Object evt = e.getSource();
       
       //Eventos VistaLogin
       //===========================================================================================================================================
        if (evt.equals(VistaL.btn_enter)) {
            char p []= VistaL.txt_pass.getPassword();
            String pass=new String(p);
            
            if (VistaL.txt_user.getText().isEmpty()|| pass.isEmpty()) {
                
                JOptionPane.showMessageDialog(null,"Debe digitar un Usuario y una Contraseña","Error en la Operacion",JOptionPane.ERROR_MESSAGE);
                       
            } else{
                String user=VistaL.txt_user.getText();
            ArrayList<ModeloUsuario>list;
            list = modelo_login.login(user, pass);
            
                if (list.size()>0) {
                    
                    JOptionPane.showMessageDialog(null,"Bienvenido a CheckList Auto");
                    VistaL.dispose();
                    ModeloSistema MMenu = new ModeloSistema();
                    ControladorLogin CSistema = new ControladorLogin(VistaInicio,MMenu);
                    VistaInicio.setVisible(true);
                    sistema_obtenerfechaactual();
   
                }else{
                    JOptionPane.showMessageDialog(null,"Acceso denegado", "Error",JOptionPane.ERROR_MESSAGE);
                }
            }
        } else if (evt.equals(VistaL.btn_salir)) {
            
            int confirmar = JOptionPane.showConfirmDialog(null, "Esta seguro que quiere salir de la aplicacion");
            
            if (confirmar ==JOptionPane.YES_OPTION) {
                System.exit(0);
                
            }else if (evt.equals(VistaL.checkviewpass)) {
                if (VistaL.checkviewpass.isSelected()) {
                    VistaL.txt_pass.setEchoChar((char)0 );
                }else  {
                VistaL.txt_pass.setEchoChar('*');
                
                } 
            }
        } //VistaLogin: botón Salir
      //Termina Captura de Eventos Vista Login     
     
      //Eventos Sistema (Menu)
      //===========================================================================================================================================
      if (evt.equals(VistaInicio.btnInspeccion)) {
           
          VistaInicio.dispose();
          ModeloInspeccion MInsp = new ModeloInspeccion();
          ControladorLogin CInspeccion = new ControladorLogin(VistaInspeccion,MInsp);
          VistaInspeccion.setVisible(true);
      } 
      //Termina Captura de Eventos Vista Inicio
    
      //Eventos Inspeccion
      //===========================================================================================================================================
      //Mostrar Registros - Inspeccion
      if (evt.equals(VistaInspeccion.btnMostrarInspeccion)) {
          inspeccion_limpiarventana();
          inspeccion_mostrarelemento();
      } 
      
       //Suprimir Inspeccion
      if (evt.equals(VistaInspeccion.btnEliminarInspeccion)) {
         
          //Toma inspeccion seleccionada previamente con el boton mostrar
          int x = JOptionPane.showConfirmDialog(this.VistaInspeccion, "Esta seguro de suprimir inspeccion");
          if (x == 0 && inspeccion_seleccionada > 0) {
                if (CIN.eliminarInspeccion(inspeccion_seleccionada)) {
                    JOptionPane.showMessageDialog(this.VistaInspeccion, "Se Elimino inspeccion");
                } else {
                    JOptionPane.showMessageDialog(this.VistaInspeccion, "No se Elimino inspeccion");
                }
            }
          inspeccion_limpiarventana();
          inspeccion_refrescartabla();

        }
          
      //Actualizar inspeccion mostrada
     if (evt.equals(VistaInspeccion.btnmodificarInspeccion)) {


         modelo_inspeccion.setEmpresaID(Integer.parseInt(VistaInspeccion.txtEmpresa.getText().toString()));
         modelo_inspeccion.setPedidoID(Integer.parseInt(VistaInspeccion.txtPedido.getText().toString()));  
         modelo_inspeccion.setPedidoLinea(Integer.parseInt(VistaInspeccion.txtNumero.getText().toString()));  
         modelo_inspeccion.setEmpleadoid(Integer.parseInt(VistaInspeccion.txtEmpleado.getText().toString()));
         
         Date FechaModificada;
         String FechaVInspeccion;
         FechaVInspeccion = VistaInspeccion.txtFecha.getText();
         
         
         FechaModificada = ParseFecha(FechaVInspeccion);
         modelo_inspeccion.setInspeccionfecha(FechaModificada);
         
         //Identifica que mostrar acorde Tipo Inspeccion - Estado - Resultado
         String VTipoInspeccion = "";
         String VEstado = "";
         String VResultado = "";
            
         //Recupera información Estado - Resultado - Tipo
         if (VistaInspeccion.checkentrega.isSelected()) VTipoInspeccion = "E";
         if (VistaInspeccion.checkrecepcion.isSelected()) VTipoInspeccion = "R";
         if (VistaInspeccion.comboInspEstado.getSelectedItem() == "NI-No Iniciada") VEstado = "NI";
         if (VistaInspeccion.comboInspEstado.getSelectedItem() == "PA-Parcial") VEstado = "PA";
         if (VistaInspeccion.comboInspEstado.getSelectedItem() == "CO-Completa") VEstado = "CO";
         if (VistaInspeccion.comboInspResultado.getSelectedItem() == "C-Confirmada") VResultado = "C";
         if (VistaInspeccion.comboInspResultado.getSelectedItem() == "N-No Confirmada") VResultado = "N";
         
         modelo_inspeccion.setInspeccionEstado(VEstado);
         modelo_inspeccion.setInspeccionResultado(VResultado);
         modelo_inspeccion.setInspeccionTipo(VTipoInspeccion);
         
        //Recupera información detalle

            modelo_inspeccion.setI01_luzdelanteraAlta(VistaInspeccion.Insp_1.getText());
            modelo_inspeccion.setI02_luzdelanteraBaja(VistaInspeccion.Insp_2.getText());
            modelo_inspeccion.setI03_lucesemergencia(VistaInspeccion.Insp_3.getText());
            modelo_inspeccion.setI04_neblinas(VistaInspeccion.Insp_4.getText());
            modelo_inspeccion.setI05_direcciondelantera(VistaInspeccion.Insp_5.getText());
            modelo_inspeccion.setI06_direccionposteriores(VistaInspeccion.Insp_6.getText());
            modelo_inspeccion.setI07_parabrisasdelantera(VistaInspeccion.Insp_7.getText());
            modelo_inspeccion.setI08_parabrisasposteriores(VistaInspeccion.Insp_8.getText());
            modelo_inspeccion.setI09_ventanas(VistaInspeccion.Insp_9.getText());
            modelo_inspeccion.setI10_espejoslaterales(VistaInspeccion.Insp_10.getText());
            modelo_inspeccion.setI11_tapatanque(VistaInspeccion.Insp_11.getText());
            modelo_inspeccion.setI12_alarmaretroceso(VistaInspeccion.Insp_12.getText());
            modelo_inspeccion.setI13_estadotablero(VistaInspeccion.Insp_13.getText());
            modelo_inspeccion.setI14_frenomano(VistaInspeccion.Insp_14.getText());
            modelo_inspeccion.setI15_serviciofreno(VistaInspeccion.Insp_15.getText());
            modelo_inspeccion.setI16_cinturonseguridadchofer(VistaInspeccion.Insp_16.getText());
            modelo_inspeccion.setI17_cinturonpasajeros(VistaInspeccion.Insp_17.getText());
            modelo_inspeccion.setI18_ordenlimpieza(VistaInspeccion.Insp_18.getText());
            modelo_inspeccion.setI19_bocinas(VistaInspeccion.Insp_19.getText());
            modelo_inspeccion.setI20_asientos(VistaInspeccion.Insp_20.getText());
            modelo_inspeccion.setI21_llantasdelanteraderecha(VistaInspeccion.Insp_21.getText());
            modelo_inspeccion.setI22_llantasdelanteraizquierda(VistaInspeccion.Insp_22.getText());
            modelo_inspeccion.setI23_llantaposteriorderecha(VistaInspeccion.Insp_23.getText());
            modelo_inspeccion.setI24_llantaposteriorizquierda(VistaInspeccion.Insp_24.getText());
            modelo_inspeccion.setI25_llantasderepuesto(VistaInspeccion.Insp_25.getText());
            modelo_inspeccion.setI26_conosseguridad(VistaInspeccion.Insp_26.getText());
            modelo_inspeccion.setI27_extintor(VistaInspeccion.Insp_27.getText());
            modelo_inspeccion.setI28_tricket(VistaInspeccion.Insp_28.getText());
            modelo_inspeccion.setI29_rallondelantero(VistaInspeccion.Insp_29.getText());
            modelo_inspeccion.setI30_rallontrasero(VistaInspeccion.Insp_30.getText());
            modelo_inspeccion.setI31_rallonlateralderecho(VistaInspeccion.Insp_31.getText());
            modelo_inspeccion.setI32_rallonlateralizquierdo(VistaInspeccion.Insp_32.getText());
            modelo_inspeccion.setI33_tarjetapropiedad(VistaInspeccion.Insp_33.getText());
            modelo_inspeccion.setI34_tanquelleno(VistaInspeccion.Insp_34.getText());
            modelo_inspeccion.setI35_llaves(VistaInspeccion.Insp_35.getText());

         
         if (!CIN.ActualizarInspeccion(modelo_inspeccion,inspeccion_seleccionada)) {
            JOptionPane.showMessageDialog(this.VistaInspeccion, "No se actualizo registro");
            CIN.ActualizarInspeccion(modelo_inspeccion,inspeccion_seleccionada);
        }
                
         inspeccion_limpiarventana();
         inspeccion_refrescartabla();
        
    }    
          
      //Actualizar inspeccion mostrada
     if (evt.equals(VistaInspeccion.btnCrearInspeccion)) {


         modelo_inspeccion.setInspeccionID(Integer.parseInt(VistaInspeccion.txtInspeccion.getText().toString()));
         modelo_inspeccion.setEmpresaID(Integer.parseInt(VistaInspeccion.txtEmpresa.getText().toString()));
         modelo_inspeccion.setPedidoID(Integer.parseInt(VistaInspeccion.txtPedido.getText().toString()));  
         modelo_inspeccion.setPedidoLinea(Integer.parseInt(VistaInspeccion.txtNumero.getText().toString()));  
         modelo_inspeccion.setEmpleadoid(Integer.parseInt(VistaInspeccion.txtEmpleado.getText().toString()));
         
//       Date FechaModificada;
//       String FechaVInspeccion;
//       FechaVInspeccion = VistaInspeccion.txtFecha.getText();
//       FechaModificada = ParseFecha(FechaVInspeccion);
//       modelo_inspeccion.setInspeccionfecha(FechaModificada);
//       System.out.println(FechaVInspeccion);
//       System.out.println(FechaModificada);
         
         
//         Calendar fecha = new GregorianCalendar();
//         int anio = fecha.get(Calendar.YEAR);
//         int mes = fecha.get(Calendar.MONTH)+1;
//         int dia = fecha.get(Calendar.DAY_OF_MONTH);
//         Date FechaDia2 = new Date();
         
//         String FechaDia = Integer.toString(dia) + "/" + Integer.toString(mes) + Integer.toString(anio);
//         VistaInspeccion.txtFecha.setText(FechaDia);
//         modelo_inspeccion.setInspeccionfecha(FechaDia2);
         
         //Identifica que mostrar acorde Tipo Inspeccion - Estado - Resultado
         String VTipoInspeccion = "";
         String VEstado = "";
         String VResultado = "";
            
         //Recupera información Estado - Resultado - Tipo
         if (VistaInspeccion.checkentrega.isSelected()) VTipoInspeccion = "E";
         if (VistaInspeccion.checkrecepcion.isSelected()) VTipoInspeccion = "R";
         if (VistaInspeccion.comboInspEstado.getSelectedItem() == "NI-No Iniciada") VEstado = "NI";
         if (VistaInspeccion.comboInspEstado.getSelectedItem() == "PA-Parcial") VEstado = "PA";
         if (VistaInspeccion.comboInspEstado.getSelectedItem() == "CO-Completa") VEstado = "CO";
         if (VistaInspeccion.comboInspResultado.getSelectedItem() == "C-Confirmada") VResultado = "C";
         if (VistaInspeccion.comboInspResultado.getSelectedItem() == "N-No Confirmada") VResultado = "N";
         
         modelo_inspeccion.setInspeccionEstado(VEstado);
         modelo_inspeccion.setInspeccionResultado(VResultado);
         modelo_inspeccion.setInspeccionTipo(VTipoInspeccion);
         
        //Recupera información detalle

            modelo_inspeccion.setI01_luzdelanteraAlta(VistaInspeccion.Insp_1.getText());
            modelo_inspeccion.setI02_luzdelanteraBaja(VistaInspeccion.Insp_2.getText());
            modelo_inspeccion.setI03_lucesemergencia(VistaInspeccion.Insp_3.getText());
            modelo_inspeccion.setI04_neblinas(VistaInspeccion.Insp_4.getText());
            modelo_inspeccion.setI05_direcciondelantera(VistaInspeccion.Insp_5.getText());
            modelo_inspeccion.setI06_direccionposteriores(VistaInspeccion.Insp_6.getText());
            modelo_inspeccion.setI07_parabrisasdelantera(VistaInspeccion.Insp_7.getText());
            modelo_inspeccion.setI08_parabrisasposteriores(VistaInspeccion.Insp_8.getText());
            modelo_inspeccion.setI09_ventanas(VistaInspeccion.Insp_9.getText());
            modelo_inspeccion.setI10_espejoslaterales(VistaInspeccion.Insp_10.getText());
            modelo_inspeccion.setI11_tapatanque(VistaInspeccion.Insp_11.getText());
            modelo_inspeccion.setI12_alarmaretroceso(VistaInspeccion.Insp_12.getText());
            modelo_inspeccion.setI13_estadotablero(VistaInspeccion.Insp_13.getText());
            modelo_inspeccion.setI14_frenomano(VistaInspeccion.Insp_14.getText());
            modelo_inspeccion.setI15_serviciofreno(VistaInspeccion.Insp_15.getText());
            modelo_inspeccion.setI16_cinturonseguridadchofer(VistaInspeccion.Insp_16.getText());
            modelo_inspeccion.setI17_cinturonpasajeros(VistaInspeccion.Insp_17.getText());
            modelo_inspeccion.setI18_ordenlimpieza(VistaInspeccion.Insp_18.getText());
            modelo_inspeccion.setI19_bocinas(VistaInspeccion.Insp_19.getText());
            modelo_inspeccion.setI20_asientos(VistaInspeccion.Insp_20.getText());
            modelo_inspeccion.setI21_llantasdelanteraderecha(VistaInspeccion.Insp_21.getText());
            modelo_inspeccion.setI22_llantasdelanteraizquierda(VistaInspeccion.Insp_22.getText());
            modelo_inspeccion.setI23_llantaposteriorderecha(VistaInspeccion.Insp_23.getText());
            modelo_inspeccion.setI24_llantaposteriorizquierda(VistaInspeccion.Insp_24.getText());
            modelo_inspeccion.setI25_llantasderepuesto(VistaInspeccion.Insp_25.getText());
            modelo_inspeccion.setI26_conosseguridad(VistaInspeccion.Insp_26.getText());
            modelo_inspeccion.setI27_extintor(VistaInspeccion.Insp_27.getText());
            modelo_inspeccion.setI28_tricket(VistaInspeccion.Insp_28.getText());
            modelo_inspeccion.setI29_rallondelantero(VistaInspeccion.Insp_29.getText());
            modelo_inspeccion.setI30_rallontrasero(VistaInspeccion.Insp_30.getText());
            modelo_inspeccion.setI31_rallonlateralderecho(VistaInspeccion.Insp_31.getText());
            modelo_inspeccion.setI32_rallonlateralizquierdo(VistaInspeccion.Insp_32.getText());
            modelo_inspeccion.setI33_tarjetapropiedad(VistaInspeccion.Insp_33.getText());
            modelo_inspeccion.setI34_tanquelleno(VistaInspeccion.Insp_34.getText());
            modelo_inspeccion.setI35_llaves(VistaInspeccion.Insp_35.getText());

         
         if (!CIN.crearInspeccion(modelo_inspeccion)) {
            JOptionPane.showMessageDialog(this.VistaInspeccion, "No se ingreso registro");
            CIN.crearInspeccion(modelo_inspeccion);
        }
                
         inspeccion_limpiarventana();
         inspeccion_refrescartabla();
        
    }     
      //Termina Captura de Eventos Vista Inspeccion
      
    
      
      
      
        
    } //VistaLogin: botón Ingresar

    
    
            
    
    @Override
    public void mouseClicked(MouseEvent e) {
      
    }

    @Override
    public void mousePressed(MouseEvent e) {
      
    }

    @Override
    public void mouseReleased(MouseEvent e) {
       
    }

    @Override
    public void mouseEntered(MouseEvent e) {
         
    }

    @Override
    public void mouseExited(MouseEvent e) {
     
    }
}
