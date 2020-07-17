/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODELO;

import java.sql.Date;

/**
 *
 * @author Mark-
 */
public class EspecialidadUsuario3 extends Eventos2{
    private int cod_eu;

    public EspecialidadUsuario3() {
    }

    public EspecialidadUsuario3(String nom_ev, String nom_visita, String nom_encargado, int cant_visita) {
        super(nom_ev, nom_visita, nom_encargado, cant_visita);
    }

    public EspecialidadUsuario3(String nom_ev, Date fec_ini, String nombre) {
        super(nom_ev, fec_ini, nombre);
    }

    public int getCod_eu() {
        return cod_eu;
    }

    public void setCod_eu(int cod_eu) {
        this.cod_eu = cod_eu;
    }
    
}
