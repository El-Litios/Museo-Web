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
public class DetallePrestamo extends ObraDeArte2{
    private int cod_detallep;
    private String obser_detallep;

    public DetallePrestamo() {
    }

    public DetallePrestamo(int cod_detallep, String obser_detallep, String tit_obra, Date fec_prestamo) {
        super(tit_obra, fec_prestamo);
        this.cod_detallep = cod_detallep;
        this.obser_detallep = obser_detallep;
    }

    public DetallePrestamo(int cod_detallep, String obser_detallep, String tit_obra) {
        super(tit_obra);
        this.cod_detallep = cod_detallep;
        this.obser_detallep = obser_detallep;
    }

    
    
    public int getCod_detallep() {
        return cod_detallep;
    }

    public void setCod_detallep(int cod_detallep) {
        this.cod_detallep = cod_detallep;
    }

    public String getObser_detallep() {
        return obser_detallep;
    }

    public void setObser_detallep(String obser_detallep) {
        this.obser_detallep = obser_detallep;
    }
    
    
}
