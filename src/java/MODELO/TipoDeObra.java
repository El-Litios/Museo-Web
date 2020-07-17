
package MODELO;
public class TipoDeObra {
    private int cod_tipoO;
    private String nom_tipoO;

    public TipoDeObra() {
    }

    public TipoDeObra(int cod_tipoO, String nom_tipoO) {
        this.cod_tipoO = cod_tipoO;
        this.nom_tipoO = nom_tipoO;
    }

    public TipoDeObra(String nom_tipoO) {
        this.nom_tipoO = nom_tipoO;
    }

    
    
    public int getCod_tipoO() {
        return cod_tipoO;
    }

    public void setCod_tipoO(int cod_tipoO) {
        this.cod_tipoO = cod_tipoO;
    }

    public String getNom_tipoO() {
        return nom_tipoO;
    }

    public void setNom_tipoO(String nom_tipoO) {
        this.nom_tipoO = nom_tipoO;
    }
    
    
    
}
