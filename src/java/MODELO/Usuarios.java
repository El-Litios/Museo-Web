package MODELO;
public class Usuarios extends Rol {
    private int usu_cod;
    private String usu_nom;
    private String usu_pass;
    private String nombre;
    private String em;

    public Usuarios() {  
    }

    

   

    public Usuarios(String usu_nom, String nombre, String em) {
        this.usu_nom = usu_nom;
        this.nombre = nombre;
        this.em = em;
    }
    
     public Usuarios(String usu_nom) {
        this.usu_nom = usu_nom;
    }

    public Usuarios(int usu_cod, String usu_nom, String nombre, String rol_nom) {
        super(rol_nom);
        this.usu_cod = usu_cod;
        this.usu_nom = usu_nom;
        this.nombre = nombre;
    }

    public Usuarios(String nombre, String em) {
        this.nombre = nombre;
        this.em = em;
    }

    
    

  

    public Usuarios(int usu_cod, String usu_nom, String nombre, String em, String rol_nom) {
        super(rol_nom);
        this.usu_cod = usu_cod;
        this.usu_nom = usu_nom;
        this.nombre = nombre;
        this.em = em;
    }

    public Usuarios(int usu_cod, String usu_nom) {
        this.usu_cod = usu_cod;
        this.usu_nom = usu_nom;
    }

    


    public Usuarios(int usu_cod, String usu_nom, String usu_pass, String nombre, String em, String rol_nom) {
        super(rol_nom);
        this.usu_cod = usu_cod;
        this.usu_nom = usu_nom;
        this.usu_pass = usu_pass;
        this.nombre = nombre;
        this.em = em;
    }

    
    
    public void setUsu_cod(int usu_cod) {
        this.usu_cod = usu_cod;
    }

    public int getUsu_cod() {
        return usu_cod;
    }
    
    public String getUsu_nom() {
        return usu_nom;
    }

    public void setUsu_nom(String usu_nom) {
        this.usu_nom = usu_nom;
    }

    public String getUsu_pass() {
        return usu_pass;
    }

    public void setUsu_pass(String usu_pass) {
        this.usu_pass = usu_pass;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEm() {
        return em;
    }

    public void setEm(String em) {
        this.em = em;
    }

 
   
    @Override
    public String toString(){
    return nombre;
    }
    
    
}
