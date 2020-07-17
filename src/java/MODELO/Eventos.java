package MODELO;

import java.sql.Date;

public class Eventos extends TipoEvento2 {
    private int cod_ev;
    private String nom_ev;
    private Date fec_ini;
    private Date fec_fin;

    public Eventos() {
    }

    public Eventos(int cod_ev, String nom_ev, Date fec_ini, Date fec_fin, String nom_tev, String nom_gal) {
        super(nom_tev, nom_gal);
        this.cod_ev = cod_ev;
        this.nom_ev = nom_ev;
        this.fec_ini = fec_ini;
        this.fec_fin = fec_fin;
    }

    public Eventos(int cod_ev, String nom_ev, Date fec_ini, Date fec_fin, String nom_tev) {
        super(nom_tev);
        this.cod_ev = cod_ev;
        this.nom_ev = nom_ev;
        this.fec_ini = fec_ini;
        this.fec_fin = fec_fin;
    }

    public Eventos(int cod_ev, String nom_ev) {
        this.cod_ev = cod_ev;
        this.nom_ev = nom_ev;
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
