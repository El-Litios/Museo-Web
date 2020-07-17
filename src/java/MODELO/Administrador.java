package MODELO;
public class Administrador extends Usuarios{
    private int cod_adm;
    private String em_adm;
    private String pass_adm;


    public Administrador() {
    }

    public Administrador(int cod_adm, String em_adm, String pass_adm, String usu_nom) {
        super(usu_nom);
        this.cod_adm = cod_adm;
        this.em_adm = em_adm;
        this.pass_adm = pass_adm;
    }

    
    
    

    public int getCod_adm() {
        return cod_adm;
    }

    public void setCod_adm(int cod_adm) {
        this.cod_adm = cod_adm;
    }

    public String getEm_adm() {
        return em_adm;
    }

    public void setEm_adm(String em_adm) {
        this.em_adm = em_adm;
    }

    public String getPass_adm() {
        return pass_adm;
    }

    public void setPass_adm(String pass_adm) {
        this.pass_adm = pass_adm;
    }

 
    
 
}
