package MODELO;

public class TipoEvento2 extends Galerias{
    private int cod_tev;
    private String nom_tev;

    public TipoEvento2() {
    }

    public TipoEvento2(String nom_tev, String nom_gal) {
        super(nom_gal);
        this.nom_tev = nom_tev;
    }

    public TipoEvento2(String nom_tev) {
        this.nom_tev = nom_tev;
    }

    
    
    public int getCod_tev() {
        return cod_tev;
    }

    public void setCod_tev(int cod_tev) {
        this.cod_tev = cod_tev;
    }

    public String getNom_tev() {
        return nom_tev;
    }

    public void setNom_tev(String nom_tev) {
        this.nom_tev = nom_tev;
    }
    
    
}
