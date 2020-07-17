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
public class SeguroPrestamo {
    private int cod_seguro;
    private String desc_seguro;
    private Date fec_seguro;
    private int monto_seguro;

    public SeguroPrestamo(int cod_seguro, Date fec_seguro) {
        this.cod_seguro = cod_seguro;
        this.fec_seguro = fec_seguro;
    }

    public SeguroPrestamo(int cod_seguro, String desc_seguro) {
        this.cod_seguro = cod_seguro;
        this.desc_seguro = desc_seguro;
    }

    
    
    public SeguroPrestamo(int cod_seguro, String desc_seguro, Date fec_seguro, int monto_seguro) {
        this.cod_seguro = cod_seguro;
        this.desc_seguro = desc_seguro;
        this.fec_seguro = fec_seguro;
        this.monto_seguro = monto_seguro;
    }

    public SeguroPrestamo(Date fec_seguro) {
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
