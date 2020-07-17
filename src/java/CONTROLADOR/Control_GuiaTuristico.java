/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CONTROLADOR;

import MODELO.EspecialidadUsuario;
import MODELO.Eventos;
import MODELO.TourEvento;
import MODELO.Usuarios;
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
public class Control_GuiaTuristico {
    Control_conexion con=new Control_conexion();
    
    //eliminar Tours en guias turisticos
    public void EliminarTours(int cod){
        try {
            con.conectar();
            PreparedStatement sql=con.Estado().prepareStatement("DELETE FROM tourevento WHERE cod_tour='"+cod+"'");
            sql.execute();
        } catch (SQLException e) {
            System.out.println("ERROR ELIMINAR TOURS EN GUIAS TURISTICOS= "+"\n"+e);
        }finally{
        con.Desconectar();
        }
    }
    
    
    //editar  Tours en guias turisticos
    public void EditarTours(int cod, Date fecha, String hora, String ins, int codv, String code, int codev){
        try {
            con.conectar();
            PreparedStatement sql=con.Estado().prepareStatement("UPDATE tourevento SET fecha_tour='"+fecha+"', hora_tour='"+hora+"', insumos_tour='"+ins+"', "
            + "cod_visita='"+codv+"', cod_especialidad='"+code+"', cod_evento='"+codev+"' WHERE cod_tour='"+cod+"'");
            sql.execute();
        } catch (SQLException e) {
            System.out.println("ERROR EDITAR TOURS EN GUIAS TURISTICOS= "+"\n"+e);
        }
    }
    
    //insertar Tours en guias turisticos
    public void InsertarTours(Date fecha, String hora, String ins, int codv, String code, int codev){
        try {
            con.conectar();
            PreparedStatement sql=con.Estado().prepareStatement("INSERT INTO tourevento (fecha_tour, hora_tour, "
                    + "insumos_tour, cod_visita, cod_especialidad, cod_evento) "
                    + "VALUES ('"+fecha+"','"+hora+"','"+ins+"','"+codv+"','"+code+"','"+codev+"')");
            sql.execute();
        } catch (SQLException e) {
            System.out.println("ERROR INSERTAR TOURS EN GUIAS TURISTICOS= "+"\n"+e);
        }finally{
        con.Desconectar();
        }
    }
    
    //listar detalles
    public List ListarTours(String espe){
    List<TourEvento> lista = new ArrayList<>();
    try {
        con.conectar();
        PreparedStatement sql=con.Estado().prepareStatement("SELECT " +
        "cod_tour" +
        ",fecha_tour" +
        ",hora_tour" +
        ",insumos_tour" +
        ",nom_visita" +
        ",nom_encargado" +
        ",cantidad_visita"+        
        ",nom_ev " +
        "FROM " +
        "tourevento " +
        "INNER JOIN visitante " +
        "ON (tourevento.cod_visita = visitante.cod_visita) " +
        "INNER JOIN evento " +
        "ON (tourevento.cod_evento = evento.cod_ev) "
        + "WHERE cod_especialidad='"+espe+"'");
        ResultSet rs=sql.executeQuery();
        while(rs.next()){
            lista.add(new TourEvento(rs.getInt("cod_tour"), 
                    rs.getDate("fecha_tour"), 
                    rs.getTime("hora_tour"), 
                    rs.getString("insumos_tour"), 
                    rs.getString("nom_ev"), 
                    rs.getString("nom_visita"), 
                    rs.getString("nom_encargado"), 
                    rs.getInt("cantidad_visita")));
            }
    } catch (SQLException e) {
            System.out.println("ERROR LISTAR TOURS EN GUIAS TURISTICOS= "+"\n"+e);
    }finally{
            con.Desconectar();
        }
    return lista;
    }
    
    //listar guias
    public List ListarGuias(){
    List<EspecialidadUsuario> lista = new ArrayList<>();
    try {
        con.conectar();
        PreparedStatement sql=con.Estado().prepareStatement("SELECT " +
        "cod_eu"+        
        ",nom_usu" +
        ",p_nombre" +
        ",em_usu " +
        "FROM " +
        "especialidadusuario " +
        "INNER JOIN usuarios " +
        "ON (especialidadusuario.cod_usu = usuarios.cod_usu) "
        + "WHERE cod_especialidad='2'");
        ResultSet rs=sql.executeQuery();
        while(rs.next()){
            lista.add(new EspecialidadUsuario(rs.getInt("cod_eu"), rs.getString("nom_usu"), rs.getString("p_nombre"), rs.getString("em_usu")));
            
            }
    } catch (SQLException e) {
            System.out.println("ERROR LISTAR USUARIOS CON ROL DE GUIAS TURISTICOS= "+"\n"+e);
    }finally{
            con.Desconectar();
        }
    return lista;
    }
    
    //listar guias
    public List ListarDetalles(String espe){
    List<EspecialidadUsuario> lista = new ArrayList<>();
    try {
        con.conectar();
        PreparedStatement sql=con.Estado().prepareStatement("SELECT cod_eu" +
        ",p_nombre" +
        ",em_usu " +
        "FROM " +
        "especialidadusuario " +
        "INNER JOIN usuarios " +
        "ON (especialidadusuario.cod_usu = usuarios.cod_usu) "
        + "WHERE cod_eu='"+espe+"'");
        ResultSet rs=sql.executeQuery();
        while(rs.next()){
            lista.add(new EspecialidadUsuario(rs.getInt("cod_eu"), rs.getString("p_nombre"), rs.getString("em_usu")));
            
            }
    } catch (SQLException e) {
            System.out.println("ERROR LISTAR DETALLES  DE GUIAS TURISTICOS= "+"\n"+e);
    }finally{
            con.Desconectar();
        }
    return lista;
    }
    
    // Lista eventos para Select de Eventos
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
            System.out.println("ERROR SELECT DE EVENTOS EN TOURS= "+"\n"+e);
    }finally{
            con.Desconectar();
        }
    return lista;
    }
    
    public List SelectVisita(){
    List<Visitante> lista = new ArrayList<>();
    try {
        con.conectar();
        PreparedStatement sql=con.Estado().prepareStatement("SELECT cod_visita, concat(nom_visita,'/',nom_encargado) as nom_visita FROM visitante");
        ResultSet rs=sql.executeQuery();
        while(rs.next()){
            lista.add(new Visitante(rs.getInt("cod_visita"), rs.getString("nom_visita")));
            }
    } catch (SQLException e) {
            System.out.println("ERROR SELECT VISITAS EN TOURS= "+"\n"+e);
    }finally{
            con.Desconectar();
        }
    return lista;
    }
}
