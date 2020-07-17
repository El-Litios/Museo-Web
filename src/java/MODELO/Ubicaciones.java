package MODELO;
public class Ubicaciones {
    private int cod_ubi;
    private String nom_ubi;

    public Ubicaciones() {
    }

    public Ubicaciones(int cod_ubi, String nom_ubi) {
        this.cod_ubi = cod_ubi;
        this.nom_ubi = nom_ubi;
    }

    public Ubicaciones(String nom_ubi) {
        this.nom_ubi = nom_ubi;
    }
    
    

    public int getCod_ubi() {
        return cod_ubi;
    }

    public void setCod_ubi(int cod_ubi) {
        this.cod_ubi = cod_ubi;
    }

    public String getNom_ubi() {
        return nom_ubi;
    }

    public void setNom_ubi(String nom_ubi) {
        this.nom_ubi = nom_ubi;
    }
    
    
}
