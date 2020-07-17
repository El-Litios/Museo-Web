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
public class Visitante extends Usuarios2{
    private int cod_visita;
    private String nom_visita;
    private String nom_encargado;
    private String curso_visita;
    private int cant_visita;

    public Visitante() {
    }

    public Visitante(int cod_visita, String nom_visita, String nom_encargado, String curso_visita, int cant_visita) {
        this.cod_visita = cod_visita;
        this.nom_visita = nom_visita;
        this.nom_encargado = nom_encargado;
        this.curso_visita = curso_visita;
        this.cant_visita = cant_visita;
    }

    public Visitante(String nom_visita, String nom_encargado, int cant_visita) {
        this.nom_visita = nom_visita;
        this.nom_encargado = nom_encargado;
        this.cant_visita = cant_visita;
    }

    public Visitante(String nombre) {
        super(nombre);
    }

    public Visitante(int cod_visita, String nom_visita) {
        this.cod_visita = cod_visita;
        this.nom_visita = nom_visita;
    }

    
    
    public int getCod_visita() {
        return cod_visita;
    }

    public void setCod_visita(int cod_visita) {
        this.cod_visita = cod_visita;
    }

    public String getNom_visita() {
        return nom_visita;
    }

    public void setNom_visita(String nom_visita) {
        this.nom_visita = nom_visita;
    }

    public String getNom_encargado() {
        return nom_encargado;
    }

    public void setNom_encargado(String nom_encargado) {
        this.nom_encargado = nom_encargado;
    }

    public String getCurso_visita() {
        return curso_visita;
    }

    public void setCurso_visita(String curso_visita) {
        this.curso_visita = curso_visita;
    }

    public int getCant_visita() {
        return cant_visita;
    }

    public void setCant_visita(int cant_visita) {
        this.cant_visita = cant_visita;
    }
    
    
}
