
package MODELO;

import java.sql.Date;

public class GaleriaObra extends Galerias2{
    private int cod_galob;
    
    public GaleriaObra() {
    }

    public GaleriaObra(int cod_galob, String nom_gal, String tit_obra) {
        super(nom_gal, tit_obra);
        this.cod_galob = cod_galob;
    }

    public GaleriaObra(int cod_galob, String tit_obra, Date fcrea_obra, Date fing_obra, String nom_autor, String nom_tipoO) {
        super(tit_obra, fcrea_obra, fing_obra, nom_autor, nom_tipoO);
        this.cod_galob = cod_galob;
    }

    
    public int getCod_galob() {
        return cod_galob;
    }

    public void setCod_galob(int cod_galob) {
        this.cod_galob = cod_galob;
    }

   
    
}
