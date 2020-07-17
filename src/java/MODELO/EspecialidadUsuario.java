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
public class EspecialidadUsuario extends Especilidades2{
    private int cod_eu;

    public EspecialidadUsuario() {
    }

    public EspecialidadUsuario(int cod_eu) {
        this.cod_eu = cod_eu;
    }

    public EspecialidadUsuario(int cod_eu, String nom_especilidades, String usu_nom, String nombre, String em) {
        super(nom_especilidades, usu_nom, nombre, em);
        this.cod_eu = cod_eu;
    }

    public EspecialidadUsuario(int cod_eu, String nombre) {
        super(nombre);
        this.cod_eu = cod_eu;
    }

    public EspecialidadUsuario(String usu_nom, String nombre, String em) {
        super(usu_nom, nombre, em);
    }

    public EspecialidadUsuario(int cod_eu, String usu_nom, String nombre, String em) {
        super(usu_nom, nombre, em);
        this.cod_eu = cod_eu;
    }

    public EspecialidadUsuario(int cod_eu, String nombre, String em) {
        super(nombre, em);
        this.cod_eu = cod_eu;
    }
    
    

    public int getCod_eu() {
        return cod_eu;
    }

    public void setCod_eu(int cod_eu) {
        this.cod_eu = cod_eu;
    }
    
    
}
