/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package CONTROLADOR;

import MODELO.Administrador;
import MODELO.Usuarios;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Mark-
 */
public class Control_Admin extends Administrador{
    Control_conexion con=new Control_conexion();
    
    
    //listar admins
     public List lista_Admins(){
    List<Administrador> lista = new ArrayList<>();
    try {
        con.conectar();
        PreparedStatement sql=con.Estado().prepareStatement("SELECT cod_admin, em_admin, pass_admin, nom_usu FROM administrador " +
        "INNER JOIN usuarios " +
        "ON (administrador.cod_usu = usuarios.cod_usu)");
        ResultSet rs=sql.executeQuery();
        while(rs.next()){
            lista.add(new Administrador(rs.getInt("cod_admin"), rs.getString("em_admin"), rs.getString("pass_admin"), rs.getString("nom_usu")));
            }
    } catch (SQLException e) {
            System.out.println("ERROR CTRL ROL= "+e);
    }finally{
            con.Desconectar();
        }
    return lista;
    }
    
    //verificar login de ADMINS
    public boolean verificar(String emADM, String passADM){
        
        try {
            con.conectar();
            PreparedStatement sql=con.Estado().prepareStatement("SELECT nom_usu FROM usuarios INNER JOIN administrador " +
            " ON (administrador.cod_usu = usuarios.cod_usu) "
            + "WHERE em_admin='"+emADM+"' AND pass_admin='"+passADM+"'");
            ResultSet rs=sql.executeQuery();
            if(rs.next()){
                this.setUsu_nom(rs.getString("nom_usu"));
                return true;           
            }
        } catch (SQLException e) {
            System.out.println("ERROR= "+e);
        }finally{
        con.Desconectar();
        }
        return false;
    }
    
    //listar usuarios
    public List lista_usus(){
    List<Usuarios> lista = new ArrayList<>();
    try {
        con.conectar();
        PreparedStatement sql=con.Estado().prepareStatement("SELECT cod_usu, nom_usu FROM usuarios " +
        "INNER JOIN rol " +
        "ON (usuarios.codRol = rol.rol_cod) " +
        "WHERE rol_nom='Administrador'");
        ResultSet rs=sql.executeQuery();
        while(rs.next()){
            lista.add(new Usuarios(rs.getInt("cod_usu"), rs.getString("nom_usu")));
            }
    } catch (SQLException e) {
            System.out.println("ERROR ListaUSU= "+e);
    }finally{
            con.Desconectar();
        }
    return lista;
    }
    
    //agregar admins
    public void insrtarAdmin(String em, String pass,  String codU){
    try {
        con.conectar();
        PreparedStatement sql=con.Estado().prepareStatement("INSERT INTO administrador(em_admin, pass_admin,  cod_usu) "
                + " VALUES ('"+em+"','"+pass+"','"+codU+"')");
        sql.execute();
        } catch (SQLException e) {
            System.out.println("ERROR addAdmin= "+e);
    }finally{
            con.Desconectar();
        }
    }
    
    //editar admins
    public void editarADM(String codADM, String emADM, String passADM, String cod_usu){
    
    try {
        con.conectar();
        PreparedStatement sql=con.Estado().prepareStatement("UPDATE  administrador SET em_admin='"+emADM+"', "
                + "pass_admin='"+passADM+"', cod_usu='"+cod_usu+"' "
                + " WHERE cod_admin='"+codADM+"'");
        sql.execute();
        } catch (SQLException e) {
            System.out.println("ERROR EditarADM= "+e);
    }finally{
            con.Desconectar();
        }
    
    }
    
    //eliminar admins
    public void eliminarAdmin(String cod){
    
    try {
        con.conectar();
        PreparedStatement sql=con.Estado().prepareStatement("DELETE FROM administrador WHERE cod_admin='"+cod+"'");
        sql.execute();
        } catch (SQLException e) {
            System.out.println("ERROR eliminarADM= "+e);
    }finally{
            con.Desconectar();
        }
    
    }
    
    
    //buscador admins
    public List buscarAdmin(String buscar){//String cod para buscar al susuario por codigo
    List<Administrador> lista = new ArrayList<>();
    try {
        con.conectar();
        PreparedStatement sql=con.Estado().prepareStatement("SELECT cod_admin, em_admin, pass_admin, nom_usu FROM administrador " +
        "INNER JOIN usuarios " +
        "ON (administrador.cod_usu = usuarios.cod_usu) "
        + " WHERE em_admin LIKE '%"+buscar+"%' ");
        ResultSet rs=sql.executeQuery();
        while(rs.next()){
            lista.add(new Administrador(rs.getInt("cod_admin"), rs.getString("em_admin"), rs.getString("pass_admin"), rs.getString("nom_usu")));
            }
    } catch (SQLException e) {
            System.out.println("ERROR buscarADM= "+e);
    }finally{
            con.Desconectar();
        }
    return lista;
    }
    
    
}
