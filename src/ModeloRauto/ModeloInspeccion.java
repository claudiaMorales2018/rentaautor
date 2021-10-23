
package ModeloRauto;

import java.util.Date;


public class ModeloInspeccion {
    
  
Integer EmpresaID ;
Integer InspeccionID;
Integer PedidoID;
Integer PedidoLinea;
Integer EmpleadoID;
Date    Inspeccionfecha;
String  InspeccionTipo;
String  InspeccionEstado;
String  InspeccionResultado;
String  InspeccionObservaciones;

String I01_luzdelanteraAlta;
String I02_luzdelanteraBaja;
String I03_lucesemergencia;
String I04_neblinas;
String I05_direcciondelantera;
String I06_direccionposteriores;
String I07_parabrisasdelantera;
String I08_parabrisasposteriores;
String I09_ventanas;
String I10_espejoslaterales;
String I11_tapatanque;
String I12_alarmaretroceso;
String I13_estadotablero;
String I14_frenomano;
String I15_serviciofreno;
String I16_cinturonseguridadchofer;
String I17_cinturonpasajeros;
String I18_ordenlimpieza;
String I19_bocinas;
String I20_asientos;
String I21_llantasdelanteraderecha;
String I22_llantasdelanteraizquierda;
String I23_llantaposteriorderecha;
String I24_llantaposteriorizquierda;
String I25_llantasderepuesto;
String I26_conosseguridad;
String I27_extintor;
String I28_tricket;
String I29_rallondelantero;
String I30_rallontrasero;
String I31_rallonlateralderecho;
String I32_rallonlateralizquierdo;
String I33_tarjetapropiedad;
String I34_tanquelleno;
String I35_llaves;

    public ModeloInspeccion() {
    }

    public ModeloInspeccion(int EmpresaID, int InspeccionID, int PedidoID, int PedidoLinea, int EmpleadoID, Date Inspeccionfecha, String InspeccionTipo, String InspeccionObservaciones, String InspeccionEstado, String InspeccionResultado, String I01_luzdelanteraAlta, String I02_luzdelanteraBaja, String I03_lucesemergencia, String I04_neblinas, String I05_direcciondelantera, String I06_direccionposteriores, String I07_parabrisasdelantera, String I08_parabrisasposteriores, String I09_ventanas, String I10_espejoslaterales, String I11_tapatanque, String I12_alarmaretroceso, String I13_estadotablero, String I14_frenomano, String I15_serviciofreno, String I16_cinturonseguridadchofer, String I17_cinturonpasajeros, String I18_ordenlimpieza, String I19_bocinas, String I20_asientos, String I21_llantasdelanteraderecha, String I22_llantasdelanteraizquierda, String I23_llantaposteriorderecha, String I24_llantaposteriorizquierda, String I25_llantasderepuesto, String I26_conosseguridad, String I27_extintor, String I28_tricket, String I29_rallondelantero, String I30_rallontrasero, String I31_rallonlateralderecho, String I32_rallonlateralizquierdo, String I33_tarjetapropiedad, String I34_tanquelleno, String I35_llaves) {
        this.EmpresaID = EmpresaID;
        this.InspeccionID = InspeccionID;
        this.PedidoID = PedidoID;
        this.PedidoLinea = PedidoLinea;
        this.EmpleadoID = EmpleadoID;
        this.Inspeccionfecha = Inspeccionfecha;
        this.InspeccionTipo = InspeccionTipo;
        this.InspeccionObservaciones = InspeccionObservaciones;
        this.InspeccionEstado = InspeccionEstado;
        this.InspeccionResultado = InspeccionResultado;
        this.I01_luzdelanteraAlta = I01_luzdelanteraAlta;
        this.I02_luzdelanteraBaja = I02_luzdelanteraBaja;
        this.I03_lucesemergencia = I03_lucesemergencia;
        this.I04_neblinas = I04_neblinas;
        this.I05_direcciondelantera = I05_direcciondelantera;
        this.I06_direccionposteriores = I06_direccionposteriores;
        this.I07_parabrisasdelantera = I07_parabrisasdelantera;
        this.I08_parabrisasposteriores = I08_parabrisasposteriores;
        this.I09_ventanas = I09_ventanas;
        this.I10_espejoslaterales = I10_espejoslaterales;
        this.I11_tapatanque = I11_tapatanque;
        this.I12_alarmaretroceso = I12_alarmaretroceso;
        this.I13_estadotablero = I13_estadotablero;
        this.I14_frenomano = I14_frenomano;
        this.I15_serviciofreno = I15_serviciofreno;
        this.I16_cinturonseguridadchofer = I16_cinturonseguridadchofer;
        this.I17_cinturonpasajeros = I17_cinturonpasajeros;
        this.I18_ordenlimpieza = I18_ordenlimpieza;
        this.I19_bocinas = I19_bocinas;
        this.I20_asientos = I20_asientos;
        this.I21_llantasdelanteraderecha = I21_llantasdelanteraderecha;
        this.I22_llantasdelanteraizquierda = I22_llantasdelanteraizquierda;
        this.I23_llantaposteriorderecha = I23_llantaposteriorderecha;
        this.I24_llantaposteriorizquierda = I24_llantaposteriorizquierda;
        this.I25_llantasderepuesto = I25_llantasderepuesto;
        this.I26_conosseguridad = I26_conosseguridad;
        this.I27_extintor = I27_extintor;
        this.I28_tricket = I28_tricket;
        this.I29_rallondelantero = I29_rallondelantero;
        this.I30_rallontrasero = I30_rallontrasero;
        this.I31_rallonlateralderecho = I31_rallonlateralderecho;
        this.I32_rallonlateralizquierdo = I32_rallonlateralizquierdo;
        this.I33_tarjetapropiedad = I33_tarjetapropiedad;
        this.I34_tanquelleno = I34_tanquelleno;
        this.I35_llaves = I35_llaves;
    }

    
     public ModeloInspeccion(int EmpresaID, int PedidoID, int PedidoLinea, int EmpleadoID, Date Inspeccionfecha, String InspeccionTipo, String InspeccionObservaciones, String InspeccionEstado, String InspeccionResultado, String I01_luzdelanteraAlta, String I02_luzdelanteraBaja, String I03_lucesemergencia, String I04_neblinas, String I05_direcciondelantera, String I06_direccionposteriores, String I07_parabrisasdelantera, String I08_parabrisasposteriores, String I09_ventanas, String I10_espejoslaterales, String I11_tapatanque, String I12_alarmaretroceso, String I13_estadotablero, String I14_frenomano, String I15_serviciofreno, String I16_cinturonseguridadchofer, String I17_cinturonpasajeros, String I18_ordenlimpieza, String I19_bocinas, String I20_asientos, String I21_llantasdelanteraderecha, String I22_llantasdelanteraizquierda, String I23_llantaposteriorderecha, String I24_llantaposteriorizquierda, String I25_llantasderepuesto, String I26_conosseguridad, String I27_extintor, String I28_tricket, String I29_rallondelantero, String I30_rallontrasero, String I31_rallonlateralderecho, String I32_rallonlateralizquierdo, String I33_tarjetapropiedad, String I34_tanquelleno, String I35_llaves) {
        this.EmpresaID = EmpresaID;
        this.PedidoID = PedidoID;
        this.PedidoLinea = PedidoLinea;
        this.EmpleadoID = EmpleadoID;
        this.Inspeccionfecha = Inspeccionfecha;
        this.InspeccionTipo = InspeccionTipo;
        this.InspeccionObservaciones = InspeccionObservaciones;
        this.InspeccionEstado = InspeccionEstado;
        this.InspeccionResultado = InspeccionResultado;
        this.I01_luzdelanteraAlta = I01_luzdelanteraAlta;
        this.I02_luzdelanteraBaja = I02_luzdelanteraBaja;
        this.I03_lucesemergencia = I03_lucesemergencia;
        this.I04_neblinas = I04_neblinas;
        this.I05_direcciondelantera = I05_direcciondelantera;
        this.I06_direccionposteriores = I06_direccionposteriores;
        this.I07_parabrisasdelantera = I07_parabrisasdelantera;
        this.I08_parabrisasposteriores = I08_parabrisasposteriores;
        this.I09_ventanas = I09_ventanas;
        this.I10_espejoslaterales = I10_espejoslaterales;
        this.I11_tapatanque = I11_tapatanque;
        this.I12_alarmaretroceso = I12_alarmaretroceso;
        this.I13_estadotablero = I13_estadotablero;
        this.I14_frenomano = I14_frenomano;
        this.I15_serviciofreno = I15_serviciofreno;
        this.I16_cinturonseguridadchofer = I16_cinturonseguridadchofer;
        this.I17_cinturonpasajeros = I17_cinturonpasajeros;
        this.I18_ordenlimpieza = I18_ordenlimpieza;
        this.I19_bocinas = I19_bocinas;
        this.I20_asientos = I20_asientos;
        this.I21_llantasdelanteraderecha = I21_llantasdelanteraderecha;
        this.I22_llantasdelanteraizquierda = I22_llantasdelanteraizquierda;
        this.I23_llantaposteriorderecha = I23_llantaposteriorderecha;
        this.I24_llantaposteriorizquierda = I24_llantaposteriorizquierda;
        this.I25_llantasderepuesto = I25_llantasderepuesto;
        this.I26_conosseguridad = I26_conosseguridad;
        this.I27_extintor = I27_extintor;
        this.I28_tricket = I28_tricket;
        this.I29_rallondelantero = I29_rallondelantero;
        this.I30_rallontrasero = I30_rallontrasero;
        this.I31_rallonlateralderecho = I31_rallonlateralderecho;
        this.I32_rallonlateralizquierdo = I32_rallonlateralizquierdo;
        this.I33_tarjetapropiedad = I33_tarjetapropiedad;
        this.I34_tanquelleno = I34_tanquelleno;
        this.I35_llaves = I35_llaves;
    }
    
    
    public int getEmpresaID() {
        return EmpresaID;
    }

    public void setEmpresaID(int EmpresaID) {
        this.EmpresaID = EmpresaID;
    }

    public int getInspeccionID() {
        return InspeccionID;
    }

    public void setInspeccionID(int InspeccionID) {
        this.InspeccionID = InspeccionID;
    }

    public int getPedidoID() {
        return PedidoID;
    }

    public void setPedidoID(int PedidoID) {
        this.PedidoID = PedidoID;
    }

    public int getPedidoLinea() {
        return PedidoLinea;
    }

    public void setPedidoLinea(int PedidoLinea) {
        this.PedidoLinea = PedidoLinea;
    }

    public int getEmpleadoID() {
        return EmpleadoID;
    }

    public void setEmpleadoid(int EmpleadoID) {
        this.EmpleadoID = EmpleadoID;
    }

    public Date getInspeccionfecha() {
        return Inspeccionfecha;
    }

    public void setInspeccionfecha(Date Inspeccionfecha) {
        this.Inspeccionfecha = Inspeccionfecha;
    }

    public String getInspeccionTipo() {
        return InspeccionTipo;
    }

    public void setInspeccionTipo(String InspeccionTipo) {
        this.InspeccionTipo = InspeccionTipo;
    }

    public String getInspeccionObservaciones() {
        return InspeccionObservaciones;
    }

    public void setInspeccionObservaciones(String InspeccionObservaciones) {
        this.InspeccionObservaciones = InspeccionObservaciones;
    }

    public String getInspeccionEstado() {
        return InspeccionEstado;
    }

    public void setInspeccionEstado(String InspeccionEstado) {
        this.InspeccionEstado = InspeccionEstado;
    }

    public String getInspeccionResultado() {
        return InspeccionResultado;
    }

    public void setInspeccionResultado(String InspeccionResultado) {
        this.InspeccionResultado = InspeccionResultado;
    }

    public String getI01_luzdelanteraAlta() {
        return I01_luzdelanteraAlta;
    }

    public void setI01_luzdelanteraAlta(String I01_luzdelanteraAlta) {
        this.I01_luzdelanteraAlta = I01_luzdelanteraAlta;
    }

    public String getI02_luzdelanteraBaja() {
        return I02_luzdelanteraBaja;
    }

    public void setI02_luzdelanteraBaja(String I02_luzdelanteraBaja) {
        this.I02_luzdelanteraBaja = I02_luzdelanteraBaja;
    }

    public String getI03_lucesemergencia() {
        return I03_lucesemergencia;
    }

    public void setI03_lucesemergencia(String I03_lucesemergencia) {
        this.I03_lucesemergencia = I03_lucesemergencia;
    }

    public String getI04_neblinas() {
        return I04_neblinas;
    }

    public void setI04_neblinas(String I04_neblinas) {
        this.I04_neblinas = I04_neblinas;
    }

    public String getI05_direcciondelantera() {
        return I05_direcciondelantera;
    }

    public void setI05_direcciondelantera(String I05_direcciondelantera) {
        this.I05_direcciondelantera = I05_direcciondelantera;
    }

    public String getI06_direccionposteriores() {
        return I06_direccionposteriores;
    }

    public void setI06_direccionposteriores(String I06_direccionposteriores) {
        this.I06_direccionposteriores = I06_direccionposteriores;
    }

    
    public String getI07_parabrisasdelantera() {
        return I07_parabrisasdelantera;
    }

    public void setI07_parabrisasdelantera(String I07_parabrisasdelantera) {
        this.I07_parabrisasdelantera = I07_parabrisasdelantera;
    }

    public String getI08_parabrisasposteriores() {
        return I08_parabrisasposteriores;
    }

    public void setI08_parabrisasposteriores(String I08_parabrisasposteriores) {
        this.I08_parabrisasposteriores = I08_parabrisasposteriores;
    }

    public String getI09_ventanas() {
        return I09_ventanas;
    }

    public void setI09_ventanas(String I09_ventanas) {
        this.I09_ventanas = I09_ventanas;
    }

    public String getI10_espejoslaterales() {
        return I10_espejoslaterales;
    }

    public void setI10_espejoslaterales(String I10_espejoslaterales) {
        this.I10_espejoslaterales = I10_espejoslaterales;
    }

    public String getI11_tapatanque() {
        return I11_tapatanque;
    }

    public void setI11_tapatanque(String I11_tapatanque) {
        this.I11_tapatanque = I11_tapatanque;
    }

    public String getI12_alarmaretroceso() {
        return I12_alarmaretroceso;
    }

    public void setI12_alarmaretroceso(String I12_alarmaretroceso) {
        this.I12_alarmaretroceso = I12_alarmaretroceso;
    }

    public String getI13_estadotablero() {
        return I13_estadotablero;
    }

    public void setI13_estadotablero(String I13_estadotablero) {
        this.I13_estadotablero = I13_estadotablero;
    }

    public String getI14_frenomano() {
        return I14_frenomano;
    }

    public void setI14_frenomano(String I14_frenomano) {
        this.I14_frenomano = I14_frenomano;
    }

    public String getI15_serviciofreno() {
        return I15_serviciofreno;
    }

    public void setI15_serviciofreno(String I15_serviciofreno) {
        this.I15_serviciofreno = I15_serviciofreno;
    }

    public String getI16_cinturonseguridadchofer() {
        return I16_cinturonseguridadchofer;
    }

    public void setI16_cinturonseguridadchofer(String I16_cinturonseguridadchofer) {
        this.I16_cinturonseguridadchofer = I16_cinturonseguridadchofer;
    }

    public String getI17_cinturonpasajeros() {
        return I17_cinturonpasajeros;
    }

    public void setI17_cinturonpasajeros(String I17_cinturonpasajeros) {
        this.I17_cinturonpasajeros = I17_cinturonpasajeros;
    }

    public String getI18_ordenlimpieza() {
        return I18_ordenlimpieza;
    }

    public void setI18_ordenlimpieza(String I18_ordenlimpieza) {
        this.I18_ordenlimpieza = I18_ordenlimpieza;
    }

    public String getI19_bocinas() {
        return I19_bocinas;
    }

    public void setI19_bocinas(String I19_bocinas) {
        this.I19_bocinas = I19_bocinas;
    }

    public String getI20_asientos() {
        return I20_asientos;
    }

    public void setI20_asientos(String I20_asientos) {
        this.I20_asientos = I20_asientos;
    }

    public String getI21_llantasdelanteraderecha() {
        return I21_llantasdelanteraderecha;
    }

    public void setI21_llantasdelanteraderecha(String I21_llantasdelanteraderecha) {
        this.I21_llantasdelanteraderecha = I21_llantasdelanteraderecha;
    }

    public String getI22_llantasdelanteraizquierda() {
        return I22_llantasdelanteraizquierda;
    }

    public void setI22_llantasdelanteraizquierda(String I22_llantasdelanteraizquierda) {
        this.I22_llantasdelanteraizquierda = I22_llantasdelanteraizquierda;
    }

    public String getI23_llantaposteriorderecha() {
        return I23_llantaposteriorderecha;
    }

    public void setI23_llantaposteriorderecha(String I23_llantaposteriorderecha) {
        this.I23_llantaposteriorderecha = I23_llantaposteriorderecha;
    }

    public String getI24_llantaposteriorizquierda() {
        return I24_llantaposteriorizquierda;
    }

    public void setI24_llantaposteriorizquierda(String I24_llantaposteriorizquierda) {
        this.I24_llantaposteriorizquierda = I24_llantaposteriorizquierda;
    }

    public String getI25_llantasderepuesto() {
        return I25_llantasderepuesto;
    }

    public void setI25_llantasderepuesto(String I25_llantasderepuesto) {
        this.I25_llantasderepuesto = I25_llantasderepuesto;
    }

    public String getI26_conosseguridad() {
        return I26_conosseguridad;
    }

    public void setI26_conosseguridad(String I26_conosseguridad) {
        this.I26_conosseguridad = I26_conosseguridad;
    }

    public String getI27_extintor() {
        return I27_extintor;
    }

    public void setI27_extintor(String I27_extintor) {
        this.I27_extintor = I27_extintor;
    }

    public String getI28_tricket() {
        return I28_tricket;
    }

    public void setI28_tricket(String I28_tricket) {
        this.I28_tricket = I28_tricket;
    }

    public String getI29_rallondelantero() {
        return I29_rallondelantero;
    }

    public void setI29_rallondelantero(String I29_rallondelantero) {
        this.I29_rallondelantero = I29_rallondelantero;
    }

    public String getI30_rallontrasero() {
        return I30_rallontrasero;
    }

    public void setI30_rallontrasero(String I30_rallontrasero) {
        this.I30_rallontrasero = I30_rallontrasero;
    }

    public String getI31_rallonlateralderecho() {
        return I31_rallonlateralderecho;
    }

    public void setI31_rallonlateralderecho(String I31_rallonlateralderecho) {
        this.I31_rallonlateralderecho = I31_rallonlateralderecho;
    }

    public String getI32_rallonlateralizquierdo() {
        return I32_rallonlateralizquierdo;
    }

    public void setI32_rallonlateralizquierdo(String I32_rallonlateralizquierdo) {
        this.I32_rallonlateralizquierdo = I32_rallonlateralizquierdo;
    }

    public String getI33_tarjetapropiedad() {
        return I33_tarjetapropiedad;
    }

    public void setI33_tarjetapropiedad(String I33_tarjetapropiedad) {
        this.I33_tarjetapropiedad = I33_tarjetapropiedad;
    }

    public String getI34_tanquelleno() {
        return I34_tanquelleno;
    }

    public void setI34_tanquelleno(String I34_tanquelleno) {
        this.I34_tanquelleno = I34_tanquelleno;
    }

    public String getI35_llaves() {
        return I35_llaves;
    }

    public void setI35_llaves(String I35_llaves) {
        this.I35_llaves = I35_llaves;
    }
    
}
