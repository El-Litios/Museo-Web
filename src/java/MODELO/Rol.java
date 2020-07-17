package MODELO;
public class Rol {
    private int rol_cod;
    private String rol_nom;

    public Rol() {
    }

    //contructor para insertar o editar por medio de un arraylist
    public Rol(int rol_cod, String rol_nom) {
        this.rol_cod = rol_cod;
        this.rol_nom = rol_nom;
    }
    
    //constructor agrega nombre de rol

    public Rol(String rol_nom) {
        this.rol_nom = rol_nom;
    }
    
    
    public int getRol_cod() {
        return rol_cod;
    }

    public void setRol_cod(int rol_cod) {
        this.rol_cod = rol_cod;
    }

    public String getRol_nom() {
        return rol_nom;
    }

    public void setRol_nom(String rol_nom) {
        this.rol_nom = rol_nom;
    }
    
    
    
}
