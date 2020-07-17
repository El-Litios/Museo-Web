package CONTROLADOR;

import MODELO.Ubicaciones;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Control_Ubicaciones {
    Control_conexion con=new Control_conexion();
    
    public List lista_ubi(){
    List<Ubicaciones> lista = new ArrayList<>();
    try {
        con.conectar();
        PreparedStatement sql=con.Estado().prepareStatement("SELECT * FROM ubicacion");
        ResultSet rs=sql.executeQuery();
        while(rs.next()){
            lista.add(new Ubicaciones(rs.getInt("cod_ubicacion"), rs.getString("nom_ubicacion")));
            }
    } catch (SQLException e) {
            System.out.println("ERROR listaUbi= "+e);
    }finally{
            con.Desconectar();
        }
    return lista;
    }
    
     public void insertar_ubi(String nombre){
    
    try {
        con.conectar();
        PreparedStatement sql=con.Estado().prepareStatement("INSERT INTO ubicacion(nom_ubicacion) VALUES ('"+nombre+"')");
        sql.execute();
        } catch (SQLException e) {
            System.out.println("ERROR addUbi= "+e);
    }finally{
            con.Desconectar();
        }
    
    }
     
     public void editar_ubi(int codigo, String nombre){
    
    try {
        con.conectar();
        PreparedStatement sql=con.Estado().prepareStatement("UPDATE ubicacion SET nom_ubicacion='"+nombre+"' WHERE cod_ubicacion='"+codigo+"'");
        sql.execute();
        } catch (SQLException e) {
            System.out.println("ERROR editUbi= "+e);
    }finally{
            con.Desconectar();
        }
    }
     
    public List Buscar_ubi(String buscar){
    List<Ubicaciones> lista = new ArrayList<>();
    try {
        con.conectar();
        PreparedStatement sql=con.Estado().prepareStatement("SELECT * FROM ubicacion WHERE nom_ubicacion LIKE '%"+buscar+"%'");
        ResultSet rs=sql.executeQuery();
        while(rs.next()){
            lista.add(new Ubicaciones(rs.getInt("cod_ubicacion"), rs.getString("nom_ubicacion")));
            }
    } catch (SQLException e) {
            System.out.println("ERROR CTRL ROL= "+e);
    }finally{
            con.Desconectar();
        }
    return lista;
    }
    
    public void eliminar_ubi(String cod){
    
    try {
        con.conectar();
        PreparedStatement sql=con.Estado().prepareStatement("DELETE FROM ubicacion WHERE cod_ubicacion='"+cod+"'");
        sql.execute();
        } catch (SQLException e) {
            System.out.println("ERROR deleteUbi= "+e);
    }finally{
            con.Desconectar();
        }
    
    }
}
