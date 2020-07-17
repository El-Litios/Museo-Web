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
public class Devoluciones extends Prestamos{
    private int cod_devo;
    private Date fec_devo;
    private String docs_devo;
    private String comen_devo;

    public Devoluciones() {
    }

    public Devoluciones(Date fec_devo, String docs_devo, Date fec_prestamo) {
        super(fec_prestamo);
        this.fec_devo = fec_devo;
        this.docs_devo = docs_devo;
    }

    public Devoluciones(int cod_devo, Date fec_devo) {
        this.cod_devo = cod_devo;
        this.fec_devo = fec_devo;
    }

    public Devoluciones(int cod_devo, Date fec_devo, String docs_devo, String comen_devo) {
        this.cod_devo = cod_devo;
        this.fec_devo = fec_devo;
        this.docs_devo = docs_devo;
        this.comen_devo = comen_devo;
    }

    public Devoluciones(Date fec_devo) {
        this.fec_devo = fec_devo;
    }

   

    
    
    public Devoluciones(int cod_devo, Date fec_devo, String docs_devo, String comen_devo, Date fec_prestamo) {
        super(fec_prestamo);
        this.cod_devo = cod_devo;
        this.fec_devo = fec_devo;
        this.docs_devo = docs_devo;
        this.comen_devo = comen_devo;
    }

   

    
    public int getCod_devo() {
        return cod_devo;
    }

    public void setCod_devo(int cod_devo) {
        this.cod_devo = cod_devo;
    }

    public Date getFec_devo() {
        return fec_devo;
    }

    public void setFec_devo(Date fec_devo) {
        this.fec_devo = fec_devo;
    }

    public String getDocs_devo() {
        return docs_devo;
    }

    public void setDocs_devo(String docs_devo) {
        this.docs_devo = docs_devo;
    }

    public String getComen_devo() {
        return comen_devo;
    }

    public void setComen_devo(String comen_devo) {
        this.comen_devo = comen_devo;
    }
    
    
}
