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
public class EspecialidadUsuario2 extends ObraDeArte{
    private int cod_eu;

    public EspecialidadUsuario2() {
    }

    public EspecialidadUsuario2(int cod_eu, String tit_obra, Date fcrea_obra, Date fing_obra) {
        super(tit_obra, fcrea_obra, fing_obra);
        this.cod_eu = cod_eu;
    }

    public EspecialidadUsuario2(String tit_obra, Date fcrea_obra, Date fing_obra) {
        super(tit_obra, fcrea_obra, fing_obra);
    }

    
    
    public int getCod_eu() {
        return cod_eu;
    }

    public void setCod_eu(int cod_eu) {
        this.cod_eu = cod_eu;
    }

  
    
    
 
    
    
}
