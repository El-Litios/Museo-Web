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
public class Especialidades {
    private int cod_especialidades;
    private String nom_especilidades;

    public Especialidades() {
    }

    public Especialidades(int cod_especialidades, String nom_especilidades) {
        this.cod_especialidades = cod_especialidades;
        this.nom_especilidades = nom_especilidades;
    }

    public Especialidades(String nom_especilidades) {
        this.nom_especilidades = nom_especilidades;
    }

    public int getCod_especialidades() {
        return cod_especialidades;
    }

    public void setCod_especialidades(int cod_especialidades) {
        this.cod_especialidades = cod_especialidades;
    }

    public String getNom_especilidades() {
        return nom_especilidades;
    }

    public void setNom_especilidades(String nom_especilidades) {
        this.nom_especilidades = nom_especilidades;
    }
    
    
}
