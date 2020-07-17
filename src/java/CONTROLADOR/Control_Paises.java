package CONTROLADOR;


import MODELO.Paises;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Control_Paises {
    Control_conexion con=new Control_conexion();
    
    //listar paises
    public List lista_Paises(){
    List<Paises> lista = new ArrayList<>();
    try {
        con.conectar();
        PreparedStatement sql=con.Estado().prepareStatement("SELECT * FROM pais");
        ResultSet rs=sql.executeQuery();
        while(rs.next()){
            lista.add(new Paises(rs.getInt("cod_pais"), rs.getString("nom_pais")));
            }
    } catch (SQLException e) {
            System.out.println("ERROR listaPaises= "+e);
    }finally{
            con.Desconectar();
        }
    return lista;
    }
    //insertar paises
    public void insertar_Paises(String nombre){
    
    try {
        con.conectar();
        PreparedStatement sql=con.Estado().prepareStatement("INSERT INTO pais(nom_pais) VALUES ('"+nombre+"')");
        sql.execute();
        } catch (SQLException e) {
            System.out.println("ERROR addPais= "+e);
    }finally{
            con.Desconectar();
        }
    
    }
    //editar paises
     public void editar_paises(int codigo, String nombre){
    
    try {
        con.conectar();
        PreparedStatement sql=con.Estado().prepareStatement("UPDATE pais SET nom_pais='"+nombre+"' WHERE cod_pais='"+codigo+"'");
        sql.execute();
        } catch (SQLException e) {
            System.out.println("ERROR editPais= "+e);
    }finally{
            con.Desconectar();
        }
    }
    //eliminar paises
    public void eliminar_pais(int cod){
    try {
        con.conectar();
        PreparedStatement sql=con.Estado().prepareStatement("DELETE FROM pais WHERE cod_pais='"+cod+"'");
        sql.execute();
        } catch (SQLException e) {
            System.out.println("ERROR deleteUbi= "+e);
    }finally{
            con.Desconectar();
        }
    
    }
    //buscar paises
    public List Buscar_pais(String buscar){
    List<Paises> lista = new ArrayList<>();
    try {
        con.conectar();
        PreparedStatement sql=con.Estado().prepareStatement("SELECT * FROM pais WHERE nom_pais LIKE '%"+buscar+"%'");
        ResultSet rs=sql.executeQuery();
        while(rs.next()){
            lista.add(new Paises(rs.getInt("cod_pais"), rs.getString("nom_pais")) );
            }
    } catch (SQLException e) {
            System.out.println("ERROR BuscarPais= "+e);
    }finally{
            con.Desconectar();
        }
    return lista;
    }
}
