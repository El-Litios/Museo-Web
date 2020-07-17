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
public class EstadoRestauracion extends EspecialidadUsuario2{
    private int cod_estado;
    private String nom_estado;

    public EstadoRestauracion() {
    }

    public EstadoRestauracion(String nom_estado, int cod_eu, String tit_obra, Date fcrea_obra, Date fing_obra) {
        super(cod_eu, tit_obra, fcrea_obra, fing_obra);
        this.nom_estado = nom_estado;
    }

    public EstadoRestauracion(String nom_estado, String tit_obra, Date fcrea_obra, Date fing_obra) {
        super(tit_obra, fcrea_obra, fing_obra);
        this.nom_estado = nom_estado;
    }

    public EstadoRestauracion(String tit_obra, Date fcrea_obra, Date fing_obra) {
        super(tit_obra, fcrea_obra, fing_obra);
    }


    public EstadoRestauracion(int cod_estado, String nom_estado) {
        this.cod_estado = cod_estado;
        this.nom_estado = nom_estado;
    }

    public int getCod_estado() {
        return cod_estado;
    }

    public void setCod_estado(int cod_estado) {
        this.cod_estado = cod_estado;
    }

    public String getNom_estado() {
        return nom_estado;
    }

    public void setNom_estado(String nom_estado) {
        this.nom_estado = nom_estado;
    }
    
    
}
