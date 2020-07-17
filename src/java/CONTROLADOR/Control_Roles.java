package CONTROLADOR;

import MODELO.Rol;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Control_Roles extends Rol{
    Control_conexion con=new Control_conexion();
    //
    //throw permite manejar errores en formato de hilo, ed, si varias instancias de la clase rol tienen error se pueden manipular todos los errores.
    public List lista_roles(){
    List<Rol> lista = new ArrayList<>();
    try {
        con.conectar();
        PreparedStatement sql=con.Estado().prepareStatement("SELECT * FROM rol");
        ResultSet rs=sql.executeQuery();
        while(rs.next()){
            lista.add(new Rol(rs.getInt("rol_cod"), rs.getString("rol_nom")));
            }
    } catch (SQLException e) {
            System.out.println("ERROR CTRL ROL= "+e);
    }finally{
            con.Desconectar();
        }
    return lista;
    }
    
    //eliminar roles
    public void eliminar_rol(int cod){
    
    try {
        con.conectar();
        PreparedStatement sql=con.Estado().prepareStatement("DELETE FROM rol WHERE rol_cod='"+cod+"'");
        sql.execute();
        } catch (SQLException e) {
            System.out.println("ERROR CTRL ROL= "+e);
    }finally{
            con.Desconectar();
        }
    
    }
    
    public List Buscar_Rol(String buscar){
    List<Rol> lista = new ArrayList<>();
    try {
        con.conectar();
        PreparedStatement sql=con.Estado().prepareStatement("SELECT rol_cod, rol_nom FROM rol WHERE rol_nom LIKE '%"+buscar+"%' ");
        ResultSet rs=sql.executeQuery();
        while(rs.next()){
            lista.add(new Rol(rs.getInt("rol_cod"), rs.getString("rol_nom")));
            }
    } catch (SQLException e) {
            System.out.println("ERROR CTRL ROL= "+e);
    }finally{
            con.Desconectar();
        }
    return lista;
    }
    
    public void editar_rol(int codigo, String nombre){
    
    try {
        con.conectar();
        PreparedStatement sql=con.Estado().prepareStatement("UPDATE  rol SET rol_nom='"+nombre+"' WHERE rol_cod='"+codigo+"'");
        sql.execute();
        } catch (SQLException e) {
            System.out.println("ERROR CTRL ROL= "+e);
    }finally{
            con.Desconectar();
        }
    
    }
    
    //
    public void insertar_rol( String nombre){
    
    try {
        con.conectar();
        PreparedStatement sql=con.Estado().prepareStatement("INSERT INTO rol(rol_nom) VALUES ('"+nombre+"')");
        sql.execute();
        } catch (SQLException e) {
            System.out.println("ERROR CTRL ROL= "+e);
    }finally{
            con.Desconectar();
        }
    
    }
    
}
