/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CONTROLADOR;


import MODELO.Museos;
import MODELO.PaisMuseo;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Mark-
 */
public class Control_Museos {
    Control_conexion con=new Control_conexion();
    
    //listar museos
    public List ListarMuseos(){//String cod para buscar al susuario por codigo
    List<Museos> lista = new ArrayList<>();
    try {
        con.conectar();
        PreparedStatement sql=con.Estado().prepareStatement("SELECT " +
        "cod_museo " +
        ",nom_museo " +
        ",dir_museo " +
        ",contac_museo " +
        ",nom_paism " +
        "FROM " +
        "museos " +
        "INNER JOIN paism " +
        "ON (museos.cod_paism = paism.cod_paism)");
        ResultSet rs=sql.executeQuery();
        while(rs.next()){
            lista.add(new Museos(rs.getInt("cod_museo"), 
                    rs.getString("nom_museo"), 
                    rs.getString("dir_museo"), 
                    rs.getString("contac_museo"), 
                    rs.getString("nom_paism")));
            }
    } catch (SQLException e) {
            System.out.println("ERROR LISTAR MUSEOS= "+"\n"+e);
    }finally{
            con.Desconectar();
        }
    return lista;
    }
    
    //buscar museos
    public List BuscarMuseos(String buscar){//String cod para buscar al susuario por codigo
    List<Museos> lista = new ArrayList<>();
    try {
        con.conectar();
        PreparedStatement sql=con.Estado().prepareStatement("SELECT " +
        "cod_museo " +
        ",nom_museo " +
        ",dir_museo " +
        ",contac_museo " +
        ",nom_paism " +
        "FROM " +
        "museos " +
        "INNER JOIN paism " +
        "ON (museos.cod_paism = paism.cod_paism) "
        + "WHERE nom_museo LIKE '%"+buscar+"%' OR dir_museo LIKE '%"+buscar+"%' OR contac_museo LIKE '%"+buscar+"%' OR nom_paism LIKE '%"+buscar+"%'");
        ResultSet rs=sql.executeQuery();
        while(rs.next()){
            lista.add(new Museos(rs.getInt("cod_museo"), 
                    rs.getString("nom_museo"), 
                    rs.getString("dir_museo"), 
                    rs.getString("contac_museo"), 
                    rs.getString("nom_paism")));
            }
    } catch (SQLException e) {
            System.out.println("ERROR BUSCAR MUSEOS= "+"\n"+e);
    }finally{
            con.Desconectar();
        }
    return lista;
    }
    
    //insertar museo
    public void InsertarMuseos(String nom, String dir, String contac, int codP){
    try {
        con.conectar();
        PreparedStatement sql=con.Estado().prepareStatement("INSERT INTO museos "
                + "(nom_museo,dir_museo,contac_museo,cod_paism) "
                + "VALUES ('"+nom+"','"+dir+"','"+contac+"','"+codP+"') ");
        sql.execute();
        } catch (SQLException e) {
            System.out.println("ERROR INSERTAR MUSEOS= "+"\n"+e);
    }finally{
            con.Desconectar();
        }
    }
    
    //edtar museos
    public void EditarMuseos(int cod, String nom, String dir, String contac, int codP){
    try {
        con.conectar();
        PreparedStatement sql=con.Estado().prepareStatement("UPDATE museos SET "
                + "nom_museo='"+nom+"', dir_museo='"+dir+"',contac_museo='"+contac+"',cod_paism='"+codP+"' "
                + "WHERE cod_museo='"+cod+"' ");
        sql.execute();
        } catch (SQLException e) {
            System.out.println("ERROR EDITAR MUSEOS= "+"\n"+e);
    }finally{
            con.Desconectar();
        }
    }
    
    //eliminar museos
     public void EliminarMuseos(int cod){
    try {
        con.conectar();
        PreparedStatement sql=con.Estado().prepareStatement("DELETE FROM museos WHERE cod_museo='"+cod+"' ");
        sql.execute();
        } catch (SQLException e) {
            System.out.println("ERROR ELIMINAR MUSEOS= "+"\n"+e);
    }finally{
            con.Desconectar();
        }
    }
    
    //listar pais de museos
    public List ListarPaisDeMuseo(){//String cod para buscar al susuario por codigo
    List<PaisMuseo> lista = new ArrayList<>();
    try {
        con.conectar();
        PreparedStatement sql=con.Estado().prepareStatement("SELECT cod_paism, nom_paism FROM paism");
        ResultSet rs=sql.executeQuery();
        while(rs.next()){
            lista.add(new PaisMuseo(rs.getInt("cod_paism"), rs.getString("nom_paism")));
            }
    } catch (SQLException e) {
            System.out.println("ERROR LISTAR PAISES DE MUSEOS= "+"\n"+e);
    }finally{
            con.Desconectar();
        }
    return lista;
    }
}
