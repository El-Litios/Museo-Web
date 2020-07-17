package MODELO;

import java.sql.Date;

public class Galerias2 extends ObraDeArte {
    private int cod_gal;
    private String nom_gal;

    public Galerias2() {
    }

    public Galerias2(String nom_gal, String tit_obra) {
        super(tit_obra);
        this.nom_gal = nom_gal;
    }

    public Galerias2(String tit_obra, Date fcrea_obra, Date fing_obra, String nom_autor, String nom_tipoO) {
        super(tit_obra, fcrea_obra, fing_obra, nom_autor, nom_tipoO);
    }

    
    
    public int getCod_gal() {
        return cod_gal;
    }

    public void setCod_gal(int cod_gal) {
        this.cod_gal = cod_gal;
    }

    public String getNom_gal() {
        return nom_gal;
    }

    public void setNom_gal(String nom_gal) {
        this.nom_gal = nom_gal;
    }
    
    
}
