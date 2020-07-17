/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODELO;

import java.sql.Date;

/**
 *
 * @author Mark-
 */
public class DevolucionSeguros extends SeguroDevoluciones2{
    private int cod_devoseg;

    public DevolucionSeguros() {
    }

    public DevolucionSeguros(int cod_devoseg, Date fec_seguro, int monto_seguro, Date fec_devo, String docs_devo, Date fec_prestamo) {
        super(fec_seguro, monto_seguro, fec_devo, docs_devo, fec_prestamo);
        this.cod_devoseg = cod_devoseg;
    }

    public DevolucionSeguros(int cod_devoseg, Date fec_devo, String docs_devo, Date fec_prestamo) {
        super(fec_devo, docs_devo, fec_prestamo);
        this.cod_devoseg = cod_devoseg;
    }

   

    
    public DevolucionSeguros(int cod_devoseg, Date fec_seguro, Date fec_devo) {
        super(fec_seguro, fec_devo);
        this.cod_devoseg = cod_devoseg;
    }

    public int getCod_devoseg() {
        return cod_devoseg;
    }

    public void setCod_devoseg(int cod_devoseg) {
        this.cod_devoseg = cod_devoseg;
    }
    
    
}
