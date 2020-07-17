package MODELO;

import java.sql.Date;

public class ObraDeArte extends Autores2{
    private int cod_obra;
    private String tit_obra;
    private Date fcrea_obra;
    private Date fing_obra;

    public ObraDeArte() {
    }

    public ObraDeArte(String tit_obra) {
        this.tit_obra = tit_obra;
    }

    public ObraDeArte(int cod_obra, String tit_obra) {
        this.cod_obra = cod_obra;
        this.tit_obra = tit_obra;
    }

    public ObraDeArte(String tit_obra, Date fcrea_obra, Date fing_obra, String nom_autor, String nom_tipoO) {
        super(nom_autor, nom_tipoO);
        this.tit_obra = tit_obra;
        this.fcrea_obra = fcrea_obra;
        this.fing_obra = fing_obra;
    }

    public ObraDeArte(String tit_obra, Date fcrea_obra, Date fing_obra) {
        this.tit_obra = tit_obra;
        this.fcrea_obra = fcrea_obra;
        this.fing_obra = fing_obra;
    }

    
    
    public ObraDeArte(int cod_obra, String tit_obra, Date fcrea_obra, Date fing_obra, String nom_autor, String nom_tipoO) {
        super(nom_autor, nom_tipoO);
        this.cod_obra = cod_obra;
        this.tit_obra = tit_obra;
        this.fcrea_obra = fcrea_obra;
        this.fing_obra = fing_obra;
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
