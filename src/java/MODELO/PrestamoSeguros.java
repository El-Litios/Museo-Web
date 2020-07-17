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
public class PrestamoSeguros extends SeguroPrestamos2{
    private int cod_preseg;

    public PrestamoSeguros(int cod_preseg, Date fec_seguro, int monto_seguro, Date fec_prestamo, int codto_asociado, String nom_estado, String nom_museo) {
        super(fec_seguro, monto_seguro, fec_prestamo, codto_asociado, nom_estado, nom_museo);
        this.cod_preseg = cod_preseg;
    }

    public PrestamoSeguros(int cod_preseg, Date fec_prestamo, int codto_asociado, String nom_estado, String nom_museo) {
        super(fec_prestamo, codto_asociado, nom_estado, nom_museo);
        this.cod_preseg = cod_preseg;
    }

  
    public PrestamoSeguros(int cod_preseg, Date fec_seguro) {
        super(fec_seguro);
        this.cod_preseg = cod_preseg;
    }

    public PrestamoSeguros(int cod_preseg, String desc_seguro, Date fec_seguro, int monto_seguro) {
        super(desc_seguro, fec_seguro, monto_seguro);
        this.cod_preseg = cod_preseg;
    }

   

    public int getCod_preseg() {
        return cod_preseg;
    }

    public void setCod_preseg(int cod_preseg) {
        this.cod_preseg = cod_preseg;
    }
    
    
}
