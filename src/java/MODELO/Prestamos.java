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
public class Prestamos extends EstadoPrestamo{
    private int cod_prestamo;
    private Date fec_prestamo;
    private String comen_prestamo;
    private int codto_asociado;

    public Prestamos() {
    }

    public Prestamos(Date fec_prestamo, String nom_estado, String nom_museo) {
        super(nom_estado, nom_museo);
        this.fec_prestamo = fec_prestamo;
    }

 

    public Prestamos(Date fec_prestamo, int codto_asociado, String nom_estado, String nom_museo) {
        super(nom_estado, nom_museo);
        this.fec_prestamo = fec_prestamo;
        this.codto_asociado = codto_asociado;
    }

    public Prestamos(Date fec_prestamo, String comen_prestamo) {
        this.fec_prestamo = fec_prestamo;
        this.comen_prestamo = comen_prestamo;
    }

    
    
    public Prestamos(int cod_prestamo, Date fec_prestamo, String comen_prestamo, int codto_asociado, String nom_estado, String nom_museo) {
        super(nom_estado, nom_museo);
        this.cod_prestamo = cod_prestamo;
        this.fec_prestamo = fec_prestamo;
        this.comen_prestamo = comen_prestamo;
        this.codto_asociado = codto_asociado;
    }

    public Prestamos(Date fec_prestamo) {
        this.fec_prestamo = fec_prestamo;
    }

    public Prestamos(int cod_prestamo, Date fec_prestamo) {
        this.cod_prestamo = cod_prestamo;
        this.fec_prestamo = fec_prestamo;
    }

    
    
    public int getCod_prestamo() {
        return cod_prestamo;
    }

    public void setCod_prestamo(int cod_prestamo) {
        this.cod_prestamo = cod_prestamo;
    }

    public Date getFec_prestamo() {
        return fec_prestamo;
    }

    public void setFec_prestamo(Date fec_prestamo) {
        this.fec_prestamo = fec_prestamo;
    }

    public String getComen_prestamo() {
        return comen_prestamo;
    }

    public void setComen_prestamo(String comen_prestamo) {
        this.comen_prestamo = comen_prestamo;
    }

    public int getCodto_asociado() {
        return codto_asociado;
    }

    public void setCodto_asociado(int codto_asociado) {
        this.codto_asociado = codto_asociado;
    }
    
    
}
