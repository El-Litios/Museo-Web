package CONTROLADOR;


import MODELO.TipoEvento;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Control_TipoEvento {
Control_conexion con=new Control_conexion();

 public List lista_tipEv(){
    List<TipoEvento> lista = new ArrayList<>();
    try {
        con.conectar();
        PreparedStatement sql=con.Estado().prepareStatement("SELECT * FROM tipoevento");
        ResultSet rs=sql.executeQuery();
        while(rs.next()){
            lista.add(new TipoEvento(rs.getInt("cod_tev"), rs.getString("nom_tev")));
            }
    } catch (SQLException e) {
            System.out.println("ERROR ListTipoEv= "+e);
    }finally{
            con.Desconectar();
        }
    return lista;
    }
 //insertar
 public void insertar_TipoEv( String nombre){
    
    try {
        con.conectar();
        PreparedStatement sql=con.Estado().prepareStatement("INSERT INTO tipoevento (nom_tev) VALUES ('"+nombre+"')");
        sql.execute();
        } catch (SQLException e) {
            System.out.println("ERROR AddTEV= "+e);
    }finally{
            con.Desconectar();
        }
    
    }
 //editar
 public void editar_TipoEv(int codigo, String nombre){
    
    try {
        con.conectar();
        PreparedStatement sql=con.Estado().prepareStatement("UPDATE  tipoevento SET nom_tev='"+nombre+"' WHERE cod_tev='"+codigo+"'");
        sql.execute();
        } catch (SQLException e) {
            System.out.println("ERROR EditTev= "+e);
    }finally{
            con.Desconectar();
        }
    
    }
 
 //eliminar 
    public void eliminar_TipoEv(int cod){
    
    try {
        con.conectar();
        PreparedStatement sql=con.Estado().prepareStatement("DELETE FROM tipoevento WHERE cod_tev='"+cod+"'");
        sql.execute();
        } catch (SQLException e) {
            System.out.println("ERROR EliminarTev= "+e);
    }finally{
            con.Desconectar();
        }
    
    }
 
  public List buscar_Tev(String buscar){
    List<TipoEvento> lista = new ArrayList<>();
    try {
        con.conectar();
        PreparedStatement sql=con.Estado().prepareStatement("SELECT cod_tev, nom_tev FROM tipoevento WHERE nom_tev LIKE '%"+buscar+"%' ");
        ResultSet rs=sql.executeQuery();
        while(rs.next()){
            lista.add(new TipoEvento(rs.getInt("cod_tev"), rs.getString("nom_tev")));
            }
    } catch (SQLException e) {
            System.out.println("ERROR buscarTev= "+e);
    }finally{
            con.Desconectar();
        }
    return lista;
    }
 
}
