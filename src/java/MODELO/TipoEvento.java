package MODELO;
public class TipoEvento {
    private int cod_tev;
    private String nom_tev;

    public TipoEvento() {
    }

    public TipoEvento(int cod_tev, String nom_tev) {
        this.cod_tev = cod_tev;
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
