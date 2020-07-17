/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CONTROLADOR;


import MODELO.EspecialidadUsuario;
import MODELO.Eventos;
import MODELO.TourEvento;
import MODELO.Visitante;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Mark-
 */
public class Control_Visitas {
    Control_conexion con= new Control_conexion();
    
    public List ComboGuias(){
        List<EspecialidadUsuario> lista=new ArrayList<>();
        try {
            con.conectar();
            PreparedStatement sql=con.Estado().prepareStatement("SELECT\n" +
"    `usuarios`.`cod_usu`\n" +
"    , `usuarios`.`p_nombre`\n" +
"FROM\n" +
"    `db_ejemplo`.`especialidadusuario`\n" +
"    INNER JOIN `db_ejemplo`.`usuarios` \n" +
"        ON (`especialidadusuario`.`cod_usu` = `usuarios`.`cod_usu`) WHERE cod_especialidad=2");
            ResultSet rs=sql.executeQuery();
            while(rs.next()){
            lista.add(new EspecialidadUsuario(rs.getInt("cod_eu"), rs.getString("p_nombre")));
            }
        } catch (SQLException e) {
            System.out.println("ERROR SELECT GUIAS TURISTICOS PARA TOURA= "+"\n"+e);
        }finally{
        con.Desconectar();
        }
    return lista;
    }
    
    //Listar Eventos para Select de Eventos
    public List SelectEventos(){
    List<Eventos> lista = new ArrayList<>();
    try {
        con.conectar();
        PreparedStatement sql=con.Estado().prepareStatement("SELECT cod_ev, nom_ev FROM evento");
        ResultSet rs=sql.executeQuery();
        while(rs.next()){
            lista.add(new Eventos(rs.getInt("cod_ev"), rs.getString("nom_ev")));
            }
    } catch (SQLException e) {
            System.out.println("ERROR SELECT EVENTOS PARA TOURS= "+"\n"+e);
    }finally{
            con.Desconectar();
        }
    return lista;
    }
    
    
    //Eliminar tours desde visitantes
    public void EliminarTours(int cod){
        try {
            con.conectar();
            PreparedStatement sql=con.Estado().prepareStatement("DELETE FROM tourevento WHERE cod_tour='"+cod+"'");
            sql.execute();
        } catch (SQLException e) {
            System.out.println("ERROR ELIMINAR TOURS DESDE VISITAS= "+"\n"+e);
        }finally{
        con.Desconectar();
        }
    }
    
    //Editar tours desde visitantes
    public void EditarTours(int cod, Date fec, Time hora, String ins, int codv, int codes, int codeve){
        try {
            con.conectar();
            PreparedStatement sql=con.Estado().prepareStatement("UPDATE tourevento SET "
                    + "fecha_tour='"+fec+"', hora_tour='"+hora+"', insumos_tour='"+ins+"', "
                    + "cod_visita='"+codv+"', cod_especialidad='"+codes+"', cod_evento='"+codeve+"' "
                    + "WHERE cod_tour='"+cod+"'");
            sql.execute();
        } catch (SQLException e) {
            System.out.println("ERROR EDITAR TOURS EN VISITAS= "+"\n"+e);
        }finally{
        con.Desconectar();
        }
    }
    
    //Insertar tours desde visitantes
    public void InsertarTours(Date fec, Time hora, String ins, int codv, int codes, int codeve){
        try {
            con.conectar();
            PreparedStatement sql=con.Estado().prepareStatement("INSERT INTO tourevento (fecha_tour, hora_tour, insumos_tour, "
                    + "cod_visita, cod_especialidad, cod_evento) "
                    + "VALUES ('"+fec+"','"+hora+"','"+ins+"','"+codv+"','"+codes+"','"+codeve+"')");
            sql.execute();
        } catch (SQLException e) {
            System.out.println("ERROR INSERTAR TOURS EN VISITAS= "+"\n"+e);
        }finally{
        con.Desconectar();
        }
    }
    
    //listar Tours en Visitas
    public List ListarTourVisita(String visita){
    List<TourEvento> lista = new ArrayList<>();
    try {
        con.conectar();
        PreparedStatement sql=con.Estado().prepareStatement("SELECT \n" +
"        cod_tour\n" +
"        ,fecha_tour\n" +
"        ,hora_tour\n" +
"        ,insumos_tour\n" +
"        ,p_nombre\n" +
"        ,nom_ev\n" +
"        ,fec_ini \n" +
"        FROM \n" +
"        tourevento \n" +
"        INNER JOIN especialidadusuario \n" +
"        ON (tourevento.cod_especialidad = especialidadusuario.cod_eu) \n" +
"        INNER JOIN usuarios \n" +
"        ON (especialidadusuario.cod_usu = usuarios.cod_usu) \n" +
"        INNER JOIN evento \n" +
"        ON (tourevento.cod_evento = evento.cod_ev) \n" +
"        WHERE cod_visita='"+visita+"'");
        ResultSet rs=sql.executeQuery();
        while(rs.next()){
            lista.add(new TourEvento(rs.getInt("cod_tour"), 
                    rs.getDate("fecha_tour"), 
                    rs.getTime("hora_tour"), 
                    rs.getString("insumos_tour"), 
                    rs.getString("nom_ev"), 
                    rs.getDate("fec_ini"), 
                    rs.getString("p_nombre")));
            }
    } catch (SQLException e) {
            System.out.println("ERROR LISTAR TOURS EN VISITANTES= "+"\n"+e);
    }finally{
            con.Desconectar();
        }
    return lista;
    }
    
    public List ListarDetalles(String visita){
    List<Visitante> lista = new ArrayList<>();
    try {
        con.conectar();
        PreparedStatement sql=con.Estado().prepareStatement("SELECT cod_visita, "
        + "nom_visita, nom_encargado, curso_visita, cantidad_visita FROM visitante "
        + "WHERE cod_visita='"+visita+"'");
        ResultSet rs=sql.executeQuery();
        while(rs.next()){
            lista.add(new Visitante(rs.getInt("cod_visita"), 
                    rs.getString("nom_visita"), 
                    rs.getString("nom_encargado"), 
                    rs.getString("curso_visita"), 
                    rs.getInt("cantidad_visita")));
            }
    } catch (SQLException e) {
            System.out.println("ERROR LISTAR TOURS EN VISITANTES= "+"\n"+e);
    }finally{
            con.Desconectar();
        }
    return lista;
    }
    
    
    //listar visitantes
    public List ListarVisitantes(){
    List<Visitante> lista = new ArrayList<>();
    try {
        con.conectar();
        PreparedStatement sql=con.Estado().prepareStatement("SELECT " +
        "cod_visita" +
        ",nom_visita" +
        ",nom_encargado" +
        ",curso_visita" +
        ",cantidad_visita " +
        "FROM " +
        "visitante");
        ResultSet rs=sql.executeQuery();
        while(rs.next()){
            lista.add(new Visitante(rs.getInt("cod_visita"), 
                    rs.getString("nom_visita"), 
                    rs.getString("nom_encargado"), 
                    rs.getString("curso_visita"), 
                    rs.getInt("cantidad_visita")));
            }
    } catch (SQLException e) {
            System.out.println("ERROR Listar Visitantes = "+"\n"+e);
    }finally{
            con.Desconectar();
        }
    return lista;
    }
    
    
    
    //insertar visitantes
    public void InsertarVisitante(String nom, String enc, String curso, int cant){
    try {
        con.conectar();
        PreparedStatement sql=con.Estado().prepareStatement("INSERT INTO visitante (nom_visita, nom_encargado, curso_visita, cantidad_visita) "
                + "VALUES ('"+nom+"','"+enc+"','"+curso+"','"+cant+"')");
        sql.execute();
        } catch (SQLException e) {
            System.out.println("ERROR Add Visitantes= "+"\n"+e);
    }finally{
            con.Desconectar();
        }
    
    }
    
    //buscar visitantes
    public List BuscarVisitantes(String dato){
    List<Visitante> lista = new ArrayList<>();
    try {
        con.conectar();
        PreparedStatement sql=con.Estado().prepareStatement("SELECT " +
        "cod_visita" +
        ",nom_visita" +
        ",nom_encargado" +
        ",curso_visita" +
        ",cantidad_visita " +
        "FROM " +
        "visitante "
        + "WHERE nom_visita LIKE '%"+dato+"%' OR nom_encargado LIKE '%"+dato+"%' OR curso_visita LIKE '%"+dato+"%' OR cantidad_visita LIKE '%"+dato+"%'");
        ResultSet rs=sql.executeQuery();
        while(rs.next()){
            lista.add(new Visitante(rs.getInt("cod_visita"), 
                    rs.getString("nom_visita"), 
                    rs.getString("nom_encargado"), 
                    rs.getString("curso_visita"), 
                    rs.getInt("cantidad_visita")));
            }
    } catch (SQLException e) {
            System.out.println("ERROR Buscar Visitantes = "+"\n"+e);
    }finally{
            con.Desconectar();
        }
    return lista;
    }
    
    //modificar visitantes
    public void EditarVisitantes(int cod, String nom, String enc, String curso, int cant){
    try {
        con.conectar();
        PreparedStatement sql=con.Estado().prepareStatement("UPDATE visitante SET "
        + "nom_visita='"+nom+"', nom_encargado='"+enc+"', curso_visita='"+curso+"', cantidad_visita='"+cant+"' "
        + "WHERE cod_visita='"+cod+"'");
        sql.execute();
        } catch (SQLException e) {
            System.out.println("ERROR Editar Visitantes= "+"\n"+e);
    }finally{
            con.Desconectar();
        }
    
    }
    
    //eliminar visitantes
    public void EliminarVisitantes(int cod){
    try {
        con.conectar();
        PreparedStatement sql=con.Estado().prepareStatement("DELETE FROM visitante WHERE cod_visita='"+cod+"'");
        sql.execute();
        } catch (SQLException e) {
            System.out.println("ERROR Eliminar Visitantes= "+"\n"+e);
    }finally{
            con.Desconectar();
        }
    
    }
}
