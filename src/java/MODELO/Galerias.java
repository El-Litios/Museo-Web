package MODELO;

public class Galerias extends Ubicaciones{
    private int cod_gal;
    private String nom_gal;

    public Galerias() {
    }

    public Galerias(int cod_gal, String nom_gal) {
        this.cod_gal = cod_gal;
        this.nom_gal = nom_gal;
    }

    public Galerias(String nom_gal) {
        this.nom_gal = nom_gal;
    }

    
    
    public Galerias(int cod_gal, String nom_gal, String nom_ubi) {
        super(nom_ubi);
        this.cod_gal = cod_gal;
        this.nom_gal = nom_gal;
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
