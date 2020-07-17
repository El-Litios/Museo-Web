package CONTROLADOR;

import MODELO.Autores;
import MODELO.ObraDeArte;
import MODELO.TipoDeObra;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Control_ObrasDeArte {
    Control_conexion con=new Control_conexion();
    
    //listar obras para gestionar.
    public List listaObras(){
    List<ObraDeArte> lista = new ArrayList<>();
    try {
        con.conectar();
        PreparedStatement sql=con.Estado().prepareStatement("SELECT cod_obra, tit_obra  FROM obradearte ");
        ResultSet rs=sql.executeQuery();
        while(rs.next()){
            lista.add(new ObraDeArte(rs.getInt("cod_obra"), 
                    rs.getString("tit_obra")));
            }
    } catch (SQLException e) {
            System.out.println("ERROR listaObraParaGestionar= "+"\n"+e);
    }finally{
            con.Desconectar();
        }
    return lista;
    }
    
    //listar Obras de arte
    public List lista_Obras(){
    List<ObraDeArte> lista = new ArrayList<>();
    try {
        con.conectar();
        PreparedStatement sql=con.Estado().prepareStatement("SELECT cod_obra, tit_obra, fcrea_obra, fing_obra, nom_autor, nom_tipo FROM obradearte "+
        "INNER JOIN autores ON (obradearte.cod_autor = autores.cod_autor) " +
        "INNER JOIN tipodeobra ON (obradearte.cod_tipo = tipodeobra.cod_tipo)");
        ResultSet rs=sql.executeQuery();
        while(rs.next()){
            lista.add(new ObraDeArte(rs.getInt("cod_obra"), 
                    rs.getString("tit_obra"), 
                    rs.getDate("fcrea_obra"), 
                    rs.getDate("fing_obra"), 
                    rs.getString("nom_autor"), 
                    rs.getString("nom_tipo")));
            }
    } catch (SQLException e) {
            System.out.println("ERROR listaObra= "+e);
    }finally{
            con.Desconectar();
        }
    return lista;
    }
    
    //listar tipo de obras
    public List listaTipoObra(){
    List<TipoDeObra> lista = new ArrayList<>();
    try {
        con.conectar();
        PreparedStatement sql=con.Estado().prepareStatement("SELECT cod_tipo, nom_tipo FROM TipoDeObra");
        ResultSet rs=sql.executeQuery();
        while(rs.next()){
            lista.add(new TipoDeObra(rs.getInt("cod_tipo"), rs.getString("nom_tipo")));
            }
    } catch (SQLException e) {
            System.out.println("ERROR LISTTIPOOBRA= "+e);
    }finally{
            con.Desconectar();
        }
    return lista;
    }
     
    //listar autores
    public List listaAutores(){
    List<Autores> lista = new ArrayList<>();
    try {
        con.conectar();
        PreparedStatement sql=con.Estado().prepareStatement("SELECT cod_autor, nom_autor FROM autores ");
        ResultSet rs=sql.executeQuery();
        while(rs.next()){
            lista.add(new Autores(rs.getInt("cod_autor"), rs.getString("nom_autor")));
            }
    } catch (SQLException e) {
            System.out.println("ERROR LISTAutores= "+e);
    }finally{
            con.Desconectar();
        }
    return lista;
    } 
    
    //insertar Obras de Arte
    public void insrtarObraDeArte(String titulo, String fcrea, String fing, String codau, String codtip){ 
    try {
        con.conectar();
        PreparedStatement sql=con.Estado().prepareStatement("INSERT INTO obradearte(tit_obra, fcrea_obra, fing_obra, cod_autor, cod_tipo, cod_estadoO) "
                + " VALUES ('"+titulo+"','"+fcrea+"','"+fing+"','"+codau+"','"+codtip+"','1')");
        sql.execute();
        } catch (SQLException e) {
            System.out.println("ERROR add Obra= "+e);
    }finally{
            con.Desconectar();
        }    
    }
    
    //buscar obras de arte
    public List buscarObras(String buscar){//String cod para buscar galerias por codigo
    List<ObraDeArte> lista = new ArrayList<>();
    try {
        con.conectar();
        PreparedStatement sql=con.Estado().prepareStatement("SELECT cod_obra, tit_obra, fcrea_obra, fing_obra, nom_autor, nom_tipo FROM obradearte " +
        "INNER JOIN autores ON (obradearte.cod_autor = autores.cod_autor) " +
        "INNER JOIN tipodeobra ON (obradearte.cod_tipo = tipodeobra.cod_tipo) " +
        "WHERE tit_obra LIKE '%"+buscar+"%'");
        ResultSet rs=sql.executeQuery();
        while(rs.next()){
            lista.add(new ObraDeArte(rs.getInt("cod_obra"), 
                    rs.getString("tit_obra"), 
                    rs.getDate("fcrea_obra"), 
                    rs.getDate("fing_obra"), 
                    rs.getString("nom_autor"), 
                    rs.getString("nom_tipo")));
            }
    } catch (SQLException e) {
            System.out.println("ERROR buscarObra= "+e);
    }finally{
            con.Desconectar();
        }
    return lista;
    }
    
    //modificar Obras de Arte
    public void editarObras(String codO, String titulo, String fcrea, String fing, String codau, String codtip){
    try {
        con.conectar();
        PreparedStatement sql=con.Estado().prepareStatement("UPDATE  obradearte SET tit_obra='"+titulo+"', "
                + "fcrea_obra='"+fcrea+"', "
                + "fing_obra='"+fing+"', "
                + "cod_autor='"+codau+"', "
                + "cod_tipo='"+codtip+"' "
                + "WHERE cod_obra='"+codO+"'");
        sql.execute();
        } catch (SQLException e) {
            System.out.println("ERROR EditarObra= "+e);
    }finally{
            con.Desconectar();
        }
    }
    
    //eliminar Obras de Arte
    public void eliminarObraDeArte(String cod){
    try {
        con.conectar();
        PreparedStatement sql=con.Estado().prepareStatement("DELETE FROM obradearte WHERE cod_obra='"+cod+"'");
        sql.execute();
        } catch (SQLException e) {
            System.out.println("ERROR eliminarObra= "+e);
    }finally{
            con.Desconectar();
        }
    
    }
    
}
