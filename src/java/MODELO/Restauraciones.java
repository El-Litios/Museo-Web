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
public class Restauraciones extends EstadoRestauracion {
    private int cod_restauracion;
    private Date fecha_progra;
    private Date fecha_estimada;

    public Restauraciones() {
    }

    public Restauraciones(int cod_restauracion, Date fecha_progra, Date fecha_estimada, String nom_estado, String tit_obra, Date fcrea_obra, Date fing_obra) {
        super(nom_estado, tit_obra, fcrea_obra, fing_obra);
        this.cod_restauracion = cod_restauracion;
        this.fecha_progra = fecha_progra;
        this.fecha_estimada = fecha_estimada;
    }

    public Restauraciones(int cod_restauracion, Date fecha_progra, Date fecha_estimada, String tit_obra, Date fcrea_obra, Date fing_obra) {
        super(tit_obra, fcrea_obra, fing_obra);
        this.cod_restauracion = cod_restauracion;
        this.fecha_progra = fecha_progra;
        this.fecha_estimada = fecha_estimada;
    }


    public int getCod_restauracion() {
        return cod_restauracion;
    }

    public void setCod_restauracion(int cod_restauracion) {
        this.cod_restauracion = cod_restauracion;
    }

    public Date getFecha_progra() {
        return fecha_progra;
    }

    public void setFecha_progra(Date fecha_progra) {
        this.fecha_progra = fecha_progra;
    }

    public Date getFecha_estimada() {
        return fecha_estimada;
    }

    public void setFecha_estimada(Date fecha_estimada) {
        this.fecha_estimada = fecha_estimada;
    }
    
    
}
