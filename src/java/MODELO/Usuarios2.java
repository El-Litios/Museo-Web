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
public class Usuarios2 {
    private int usu_cod;
    private String usu_nom;
    private String usu_pass;
    private String nombre;
    private String em;

    public Usuarios2() {
    }

    public Usuarios2(String nombre) {
        this.nombre = nombre;
    }

    public Usuarios2(int usu_cod, String nombre) {
        this.usu_cod = usu_cod;
        this.nombre = nombre;
    }

    public int getUsu_cod() {
        return usu_cod;
    }

    public void setUsu_cod(int usu_cod) {
        this.usu_cod = usu_cod;
    }

    public String getUsu_nom() {
        return usu_nom;
    }

    public void setUsu_nom(String usu_nom) {
        this.usu_nom = usu_nom;
    }

    public String getUsu_pass() {
        return usu_pass;
    }

    public void setUsu_pass(String usu_pass) {
        this.usu_pass = usu_pass;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEm() {
        return em;
    }

    public void setEm(String em) {
        this.em = em;
    }
    
    
}
