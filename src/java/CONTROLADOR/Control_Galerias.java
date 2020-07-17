package CONTROLADOR;

import MODELO.Galerias;
import MODELO.Ubicaciones;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Control_Galerias extends Galerias {
    Control_conexion con=new Control_conexion();
    
    //listar galerias
    public List listaDetalles(String codigo){
    List<Galerias> lista = new ArrayList<>();
    try {
        con.conectar();
        PreparedStatement sql=con.Estado().prepareStatement("SELECT cod_gal, nom_gal, nom_ubicacion FROM ubicacion "
                + " INNER JOIN galerias ON (ubicacion.cod_ubicacion=galerias.cod_ubi) "
                + "WHERE cod_gal='"+codigo+"' ");
        ResultSet rs=sql.executeQuery();
        while(rs.next()){
            lista.add(new Galerias(rs.getInt("cod_gal"), rs.getString("nom_gal"), rs.getString("nom_ubicacion")));
            }
    } catch (SQLException e) {
            System.out.println("ERROR listaGal= "+e);
    }finally{
            con.Desconectar();
        }
    return lista;
    }
    
    
    //listar galerias
    public List lista_gal(){
    List<Galerias> lista = new ArrayList<>();
    try {
        con.conectar();
        PreparedStatement sql=con.Estado().prepareStatement("SELECT cod_gal, nom_gal, nom_ubicacion FROM ubicacion "
                + " INNER JOIN galerias ON (ubicacion.cod_ubicacion=galerias.cod_ubi)");
        ResultSet rs=sql.executeQuery();
        while(rs.next()){
            lista.add(new Galerias(rs.getInt("cod_gal"), rs.getString("nom_gal"), rs.getString("nom_ubicacion")));
            }
    } catch (SQLException e) {
            System.out.println("ERROR listaGal= "+e);
    }finally{
            con.Desconectar();
        }
    return lista;
    }
    
    //listar ubicaciones
    public List listaUbi(){
    List<Ubicaciones> lista = new ArrayList<>();
    try {
        con.conectar();
        PreparedStatement sql=con.Estado().prepareStatement("SELECT * FROM ubicacion");
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
    
    //insertar galerias
    public void insrtarGal(String nom, String codU){
    
    try {
        con.conectar();
        PreparedStatement sql=con.Estado().prepareStatement("INSERT INTO galerias(nom_gal, cod_ubi) "
                + " VALUES ('"+nom+"','"+codU+"')");
        sql.execute();
        } catch (SQLException e) {
            System.out.println("ERROR add gal= "+e);
    }finally{
            con.Desconectar();
        }
    
    }
    
    //buscar
    public List buscarGal(String buscar){//String cod para buscar galerias por codigo
    List<Galerias> lista = new ArrayList<>();
    try {
        con.conectar();
        PreparedStatement sql=con.Estado().prepareStatement("SELECT cod_gal, nom_gal, nom_ubicacion FROM galerias " +
        " INNER JOIN ubicacion " +
        " ON (galerias.cod_ubi = ubicacion.cod_ubicacion) "
        +" WHERE nom_gal LIKE '%"+buscar+"%'");
        ResultSet rs=sql.executeQuery();
        while(rs.next()){
            lista.add(new Galerias(rs.getInt("cod_gal"), rs.getString("nom_gal"), rs.getString("nom_ubicacion")));
            }
    } catch (SQLException e) {
            System.out.println("ERROR buscarGal= "+e);
    }finally{
            con.Desconectar();
        }
    return lista;
    }
    
    //modificar galerias
    public void editarGal(String codG, String nom, String ubi){
    try {
        con.conectar();
        PreparedStatement sql=con.Estado().prepareStatement("UPDATE  galerias SET nom_gal='"+nom+"', "
                + "cod_ubi='"+ubi+"' "
                + " WHERE cod_gal='"+codG+"'");
        sql.execute();
        } catch (SQLException e) {
            System.out.println("ERROR EditarGal= "+e);
    }finally{
            con.Desconectar();
        }
    
    }
    
    //eliminar Galerias
    public void eliminarGal(String cod){
    try {
        con.conectar();
        PreparedStatement sql=con.Estado().prepareStatement("DELETE FROM galerias WHERE cod_gal='"+cod+"'");
        sql.execute();
        } catch (SQLException e) {
            System.out.println("ERROR eliminarGal= "+e);
    }finally{
            con.Desconectar();
        }
    
    }
    
}
