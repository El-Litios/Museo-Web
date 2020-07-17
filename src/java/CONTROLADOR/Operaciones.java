package CONTROLADOR;

import MODELO.Datos;

public class Operaciones extends Datos{
    
    public String MiTabla(){
    String tabla="TABLA DE MULTIPLICAR<br/>";
    for (int i = 1; i < 10; i++) {
        tabla+=i+" * "+this.getV1()+" = "+(i*this.getV1())+"<br/>";
    }
    return tabla;
    }

}
