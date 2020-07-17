/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODELO;

/**
 *
 * @author Mark-
 */
public class Museos extends PaisMuseo{
    private int cod_museo;
    private String nom_museo;
    private String dir_museo;
    private String contac_museo;

    public Museos() {
    }

    public Museos(int cod_museo, String nom_museo, String dir_museo, String contac_museo, String nom_pais) {
        super(nom_pais);
        this.cod_museo = cod_museo;
        this.nom_museo = nom_museo;
        this.dir_museo = dir_museo;
        this.contac_museo = contac_museo;
    }

    public Museos(String nom_museo) {
        this.nom_museo = nom_museo;
    }

    public Museos(int cod_museo, String nom_museo) {
        this.cod_museo = cod_museo;
        this.nom_museo = nom_museo;
    }
    
    

    public int getCod_museo() {
        return cod_museo;
    }

    public void setCod_museo(int cod_museo) {
        this.cod_museo = cod_museo;
    }

    public String getNom_museo() {
        return nom_museo;
    }

    public void setNom_museo(String nom_museo) {
        this.nom_museo = nom_museo;
    }

    public String getDir_museo() {
        return dir_museo;
    }

    public void setDir_museo(String dir_museo) {
        this.dir_museo = dir_museo;
    }

    public String getContac_museo() {
        return contac_museo;
    }

    public void setContac_museo(String contac_museo) {
        this.contac_museo = contac_museo;
    }
    
    
}
