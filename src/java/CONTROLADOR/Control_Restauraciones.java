/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CONTROLADOR;


import MODELO.EspecialidadUsuario;
import MODELO.EstadoRestauracion;
import MODELO.ObraDeArte;
import MODELO.Restauraciones;
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
public class Control_Restauraciones {
    Control_conexion con=new Control_conexion();
    
    
    //listar especialidades de usuarios
    public List ListaEspUsu(){
    List<EspecialidadUsuario> lista = new ArrayList<>();
    try {
        con.conectar();
        PreparedStatement sql=con.Estado().prepareStatement("SELECT " +
        "cod_eu " +
        ",p_nombre " +
        "FROM " +
        "especialidadusuario " +
        "INNER JOIN usuarios " +
        "ON (especialidadusuario.cod_usu = usuarios.cod_usu) " +
        "WHERE cod_especialidad=1");
        ResultSet rs=sql.executeQuery();
        while(rs.next()){
            lista.add(new EspecialidadUsuario(rs.getInt("cod_eu"), rs.getString("p_nombre")));
            }
    } catch (SQLException e) {
            System.out.println("ERROR LISTAR ESPECIALIDAD DE RESTAURADOR PARA RESTAURACIONES= "+"\n"+e);
    }finally{
            con.Desconectar();
        }
    return lista;
    }
    
    //listar obras de artes
    public List ListaObras(){
    List<ObraDeArte> lista = new ArrayList<>();
    try {
        con.conectar();
        PreparedStatement sql=con.Estado().prepareStatement("SELECT cod_obra,tit_obra FROM obradearte");
        ResultSet rs=sql.executeQuery();
        while(rs.next()){
            lista.add(new ObraDeArte(rs.getInt("cod_obra"), rs.getString("tit_obra")));
            }
    } catch (SQLException e) {
            System.out.println("ERROR LISTAR OBRAS DE ARTE= "+"\n"+e);
    }finally{
            con.Desconectar();
        }
    return lista;
    }
    
    //listar estados de restauraciones
    public List ListaEstadosRes(){
    List<EstadoRestauracion> lista = new ArrayList<>();
    try {
        con.conectar();
        PreparedStatement sql=con.Estado().prepareStatement("SELECT cod_estado,nom_estado FROM estadorestauracion");
        ResultSet rs=sql.executeQuery();
        while(rs.next()){
            lista.add(new EstadoRestauracion(rs.getInt("cod_estado"), rs.getString("nom_estado")));
            }
    } catch (SQLException e) {
            System.out.println("ERROR LISTAR ESTADOS DE RESTAURACIONES= "+"\n"+e);
    }finally{
            con.Desconectar();
        }
    return lista;
    }
    
    //eliminar restauraciones
    public void EliminarRestauraciones(int cod){
    try {
        con.conectar();
        PreparedStatement sql=con.Estado().prepareStatement("DELETE FROM restauracionobra WHERE cod_restauracion='"+cod+"'");
        sql.execute();
        } catch (SQLException e) {
            System.out.println("ERROR ELIMINAR RESTAURACIONES= "+"\n"+e);
    }finally{
            con.Desconectar();
        }
    }
    
    //editar restauraciones
    public void EditarRestauraciones(int cod, Date fp, Date fe, int codO, String codE){
    try {
        con.conectar();
        PreparedStatement sql=con.Estado().prepareStatement("UPDATE restauracionobra SET "
                + "fecha_progra='"+fp+"',fecha_estimada='"+fe+"',cod_obra='"+codO+"',cod_eu='1',cod_estado='"+codE+"'");
        sql.execute();
        } catch (SQLException e) {
            System.out.println("ERROR EDITAR RESTAURACIONES= "+"\n"+e);
    }finally{
            con.Desconectar();
        }
    }
    
    //insertar restauraciones 
    public void InsertarRestauraciones(Date fp, Date fe, int codO, String codE){
    try {
        con.conectar();
        PreparedStatement sql=con.Estado().prepareStatement("INSERT INTO restauracionobra "
                + "(fecha_progra,fecha_estimada,cod_obra,cod_eu,cod_estado) "
                + "VALUES ('"+fp+"','"+fe+"','"+codO+"','1','"+codE+"')");
        PreparedStatement sql2=con.Estado().prepareStatement("UPDATE obradearte SET cod_estadoO='2' WHERE cod_obra='"+codO+"'");
        sql.execute();
        sql2.execute();
        } catch (SQLException e) {
            System.out.println("ERROR INSERTAR RESTAURACIONES= "+"\n"+e);
    }finally{
            con.Desconectar();
        }
    }
    
    //listar restauraciones
    public List ListarRestauraciones(String estado){
    List<Restauraciones> lista = new ArrayList<>();
    try {
        con.conectar();
        PreparedStatement sql=con.Estado().prepareStatement("SELECT " +
        "cod_restauracion" +
        ",fecha_progra " +
        ",fecha_estimada " +
        ",tit_obra " +
        ",fcrea_obra " +
        ",fing_obra " +
        "FROM restauracionobra " +
        "INNER JOIN obradearte " +
        "ON (restauracionobra.cod_obra = obradearte.cod_obra) " +
        "WHERE cod_estado='"+estado+"'");
        ResultSet rs=sql.executeQuery();
        while(rs.next()){
            lista.add(new Restauraciones(rs.getInt("cod_restauracion"), 
                    rs.getDate("fecha_progra"), 
                    rs.getDate("fecha_estimada"),  
                    rs.getString("tit_obra"), 
                    rs.getDate("fcrea_obra"), 
                    rs.getDate("fing_obra")));
            }
    } catch (SQLException e) {
            System.out.println("ERROR LISTAR RESTAURACIONES= "+"\n"+e);
    }finally{
            con.Desconectar();
        }
    return lista;
    }
    
     
}
