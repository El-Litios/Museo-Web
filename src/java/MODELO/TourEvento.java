/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODELO;

import java.sql.Date;
import java.sql.Time;

/**
 *
 * @author Mark-
 */
public class TourEvento extends EspecialidadUsuario3{
    private int cod_tour;
    private Date fecha_tour;
    private Time hora_tour;
    private String insumos_tour;


    public TourEvento() {
    }

    public TourEvento(int cod_tour, Date fecha_tour, Time hora_tour, String insumos_tour, String nom_ev, String nom_visita, String nom_encargado, int cant_visita) {
        super(nom_ev, nom_visita, nom_encargado, cant_visita);
        this.cod_tour = cod_tour;
        this.fecha_tour = fecha_tour;
        this.hora_tour = hora_tour;
        this.insumos_tour = insumos_tour;
    }

    public TourEvento(int cod_tour, Date fecha_tour, Time hora_tour, String insumos_tour, String nom_ev, Date fec_ini, String nombre) {
        super(nom_ev, fec_ini, nombre);
        this.cod_tour = cod_tour;
        this.fecha_tour = fecha_tour;
        this.hora_tour = hora_tour;
        this.insumos_tour = insumos_tour;
    }

    
    public int getCod_tour() {
        return cod_tour;
    }

    public void setCod_tour(int cod_tour) {
        this.cod_tour = cod_tour;
    }

    public Date getFecha_tour() {
        return fecha_tour;
    }

    public void setFecha_tour(Date fecha_tour) {
        this.fecha_tour = fecha_tour;
    }

    public Time getHora_tour() {
        return hora_tour;
    }

    public void setHora_tour(Time hora_tour) {
        this.hora_tour = hora_tour;
    }

    public String getInsumos_tour() {
        return insumos_tour;
    }

    public void setInsumos_tour(String insumos_tour) {
        this.insumos_tour = insumos_tour;
    }

    
    
    
}
