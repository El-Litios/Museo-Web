
package MODELO;

import java.sql.Date;

public class Autores extends Nacionalidades{
    private int cod_autor;
    private String nom_autor;
    private String pseu_autor;
    private String fec_naci;
    private String fec_def;

    public Autores() {
    }

    public Autores(int cod_autor, String nom_autor, String pseu_autor, String nom_nac, String nom_pais) {
        super(nom_nac, nom_pais);
        this.cod_autor = cod_autor;
        this.nom_autor = nom_autor;
        this.pseu_autor = pseu_autor;
    }

    public Autores(String nom_autor) {
        this.nom_autor = nom_autor;
    }

    public Autores(int cod_autor, String nom_autor, String pseu_autor, String fec_naci, String fec_def, String nom_nac, String nom_pais) {
        super(nom_nac, nom_pais);
        this.cod_autor = cod_autor;
        this.nom_autor = nom_autor;
        this.pseu_autor = pseu_autor;
        this.fec_naci = fec_naci;
        this.fec_def = fec_def;
    }

    public Autores(int cod_autor, String nom_autor) {
        this.cod_autor = cod_autor;
        this.nom_autor = nom_autor;
    }
    
    
    
    public int getCod_autor() {
        return cod_autor;
    }

    public void setCod_autor(int cod_autor) {
        this.cod_autor = cod_autor;
    }

    public String getNom_autor() {
        return nom_autor;
    }

    public void setNom_autor(String nom_autor) {
        this.nom_autor = nom_autor;
    }

    public String getPseu_autor() {
        return pseu_autor;
    }

    public void setPseu_autor(String pseu_autor) {
        this.pseu_autor = pseu_autor;
    }

    public String getFec_naci() {
        return fec_naci;
    }

    public void setFec_naci(String fec_naci) {
        this.fec_naci = fec_naci;
    }

    public String getFec_def() {
        return fec_def;
    }

    public void setFec_def(String fec_def) {
        this.fec_def = fec_def;
    }

 
    
    
}
