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
public class Especilidades2 extends Usuarios{
    private int cod_especialidades;
    private String nom_especilidades;

    public Especilidades2() {
    }

    public Especilidades2(String nombre) {
        super(nombre);
    }

    public Especilidades2(String usu_nom, String nombre, String em) {
        super(usu_nom, nombre, em);
    }

    

    public Especilidades2(String nom_especilidades, String usu_nom, String nombre, String em) {
        super(usu_nom, nombre, em);
        this.nom_especilidades = nom_especilidades;
    }

    public Especilidades2(String nombre, String em) {
        super(nombre, em);
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
