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
public class Eventos2 extends Visitante{
    private int cod_ev;
    private String nom_ev;
    private Date fec_ini;
    private Date fec_fin;

    public Eventos2() {
    }

    public Eventos2(String nom_ev, String nom_visita, String nom_encargado, int cant_visita) {
        super(nom_visita, nom_encargado, cant_visita);
        this.nom_ev = nom_ev;
    }

    public Eventos2(String nom_ev, Date fec_ini) {
        this.nom_ev = nom_ev;
        this.fec_ini = fec_ini;
    }

    public Eventos2(String nom_ev, Date fec_ini, String nombre) {
        super(nombre);
        this.nom_ev = nom_ev;
        this.fec_ini = fec_ini;
    }

    public int getCod_ev() {
        return cod_ev;
    }

    public void setCod_ev(int cod_ev) {
        this.cod_ev = cod_ev;
    }

    public String getNom_ev() {
        return nom_ev;
    }

    public void setNom_ev(String nom_ev) {
        this.nom_ev = nom_ev;
    }

    public Date getFec_ini() {
        return fec_ini;
    }

    public void setFec_ini(Date fec_ini) {
        this.fec_ini = fec_ini;
    }

    public Date getFec_fin() {
        return fec_fin;
    }

    public void setFec_fin(Date fec_fin) {
        this.fec_fin = fec_fin;
    }
    
    
}
