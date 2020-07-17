
package MODELO;
public class Nacionalidades extends Paises{
    private int cod_nac;
    private String nom_nac;

    public Nacionalidades() {
    }

    public Nacionalidades(int cod_nac, String nom_nac) {
        this.cod_nac = cod_nac;
        this.nom_nac = nom_nac;
    }

    public Nacionalidades(int cod_nac, String nom_nac, int cod_pais, String nom_pais) {
        super(cod_pais, nom_pais);
        this.cod_nac = cod_nac;
        this.nom_nac = nom_nac;
    }

    public Nacionalidades(int cod_nac, String nom_nac, String nom_pais) {
        super(nom_pais);
        this.cod_nac = cod_nac;
        this.nom_nac = nom_nac;
    }

    public Nacionalidades(String nom_nac, String nom_pais) {
        super(nom_pais);
        this.nom_nac = nom_nac;
    }

   

   

    public int getCod_nac() {
        return cod_nac;
    }

    public void setCod_nac(int cod_nac) {
        this.cod_nac = cod_nac;
    }

    public String getNom_nac() {
        return nom_nac;
    }

    public void setNom_nac(String nom_nac) {
        this.nom_nac = nom_nac;
    }
    
    
    
}
