package CONTROLADOR;

import MODELO.TipoDeObra;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Control_TipoObra {
    Control_conexion con=new Control_conexion();
    
    public List lista_TipoDeObra(){
    List<TipoDeObra> lista = new ArrayList<>();
    try {
        con.conectar();
        PreparedStatement sql=con.Estado().prepareStatement("SELECT * FROM tipodeobra");
        ResultSet rs=sql.executeQuery();
        while(rs.next()){
            lista.add(new TipoDeObra(rs.getInt("cod_tipo"), rs.getString("nom_tipo")));
            }
    } catch (SQLException e) {
            System.out.println("ERROR CTRL TO= "+e);
    }finally{
            con.Desconectar();
        }
    return lista;
    }
    
    public void eliminar_T_Obra(int cod){
    
    try {
        con.conectar();
        PreparedStatement sql=con.Estado().prepareStatement("DELETE FROM tipodeobra WHERE cod_tipo='"+cod+"'");
        sql.execute();
        } catch (SQLException e) {
            System.out.println("ERROR CTRL TO= "+e);
    }finally{
            con.Desconectar();
        }
    }
    
    public List Buscar_T_Obra(String buscar){
    List<TipoDeObra> lista = new ArrayList<>();
    try {
        con.conectar();
        PreparedStatement sql=con.Estado().prepareStatement("SELECT cod_tipo, nom_tipo FROM tipodeobra WHERE nom_tipo LIKE '%"+buscar+"%' ");
        ResultSet rs=sql.executeQuery();
        while(rs.next()){
            lista.add(new TipoDeObra(rs.getInt("cod_tipo"), rs.getString("nom_tipo")));
            }
    } catch (SQLException e) {
            System.out.println("ERROR CTRL TO= "+e);
    }finally{
            con.Desconectar();
        }
    return lista;
    }
    
    public void editar_T_Obra(int codigo, String nombre){   
    try {
        con.conectar();
        PreparedStatement sql=con.Estado().prepareStatement("UPDATE tipodeobra SET nom_tipo='"+nombre+"' WHERE cod_tipo='"+codigo+"'");
        sql.execute();
        } catch (SQLException e) {
            System.out.println("ERROR CTRL TO= "+e);
    }finally{
            con.Desconectar();
        }    
    }
    
     public void insertar_T_Obra(String nombre){
    try {
        con.conectar();
        PreparedStatement sql=con.Estado().prepareStatement("INSERT INTO tipodeobra(nom_tipo) VALUES ('"+nombre+"')");
        sql.execute();
        } catch (SQLException e) {
            System.out.println("ERROR CTRL TO= "+e);
    }finally{
            con.Desconectar();
        }
    
    }
    
}
