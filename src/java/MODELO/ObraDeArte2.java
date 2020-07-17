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
public class ObraDeArte2 extends Prestamos{
    private int cod_obra;
    private String tit_obra;
    private Date fcrea_obra;
    private Date fing_obra;

    public ObraDeArte2() {
    }

    public ObraDeArte2(String tit_obra, Date fec_prestamo) {
        super(fec_prestamo);
        this.tit_obra = tit_obra;
    }

    public ObraDeArte2(String tit_obra) {
        this.tit_obra = tit_obra;
    }

    
    
    public int getCod_obra() {
        return cod_obra;
    }

    public void setCod_obra(int cod_obra) {
        this.cod_obra = cod_obra;
    }

    public String getTit_obra() {
        return tit_obra;
    }

    public void setTit_obra(String tit_obra) {
        this.tit_obra = tit_obra;
    }

    public Date getFcrea_obra() {
        return fcrea_obra;
    }

    public void setFcrea_obra(Date fcrea_obra) {
        this.fcrea_obra = fcrea_obra;
    }

    public Date getFing_obra() {
        return fing_obra;
    }

    public void setFing_obra(Date fing_obra) {
        this.fing_obra = fing_obra;
    }
    
    
}
