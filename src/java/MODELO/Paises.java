/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package MODELO;

public class Paises {
    private int cod_pais;
    private String nom_pais;

    public Paises() {
    }

    public Paises(String nom_pais) {
        this.nom_pais = nom_pais;
    }

    
    
    public Paises(int cod_pais, String nom_pais) {
        this.cod_pais = cod_pais;
        this.nom_pais = nom_pais;
    }

    public int getCod_pais() {
        return cod_pais;
    }

    public void setCod_pais(int cod_pais) {
        this.cod_pais = cod_pais;
    }

    public String getNom_pais() {
        return nom_pais;
    }

    public void setNom_pais(String nom_pais) {
        this.nom_pais = nom_pais;
    }
    
    
}
