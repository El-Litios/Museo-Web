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
public class SeguroDevoluciones2 extends Devoluciones{
    private int cod_seguro;
    private String desc_seguro;
    private Date fec_seguro;
    private int monto_seguro;

    public SeguroDevoluciones2() {
    }

    public SeguroDevoluciones2(Date fec_seguro, int monto_seguro, Date fec_devo, String docs_devo, Date fec_prestamo) {
        super(fec_devo, docs_devo, fec_prestamo);
        this.fec_seguro = fec_seguro;
        this.monto_seguro = monto_seguro;
    }

    public SeguroDevoluciones2(Date fec_devo, String docs_devo, Date fec_prestamo) {
        super(fec_devo, docs_devo, fec_prestamo);
    }

    public SeguroDevoluciones2(Date fec_seguro, Date fec_devo) {
        super(fec_devo);
        this.fec_seguro = fec_seguro;
    }

  
   

  
    

    public int getCod_seguro() {
        return cod_seguro;
    }

    public void setCod_seguro(int cod_seguro) {
        this.cod_seguro = cod_seguro;
    }

    public String getDesc_seguro() {
        return desc_seguro;
    }

    public void setDesc_seguro(String desc_seguro) {
        this.desc_seguro = desc_seguro;
    }

    public Date getFec_seguro() {
        return fec_seguro;
    }

    public void setFec_seguro(Date fec_seguro) {
        this.fec_seguro = fec_seguro;
    }

    public int getMonto_seguro() {
        return monto_seguro;
    }

    public void setMonto_seguro(int monto_seguro) {
        this.monto_seguro = monto_seguro;
    }
    
    
}
