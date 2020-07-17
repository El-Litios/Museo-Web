/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CONTROLADOR;

import MODELO.DetallePrestamo;
import MODELO.ObraDeArte;
import MODELO.Prestamos;
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
public class Control_DetallesPrestamos {
    Control_conexion con=new Control_conexion();
    
    //listar detalles
    public List ListarDetallesPrestamos(String prestamo){
    List<DetallePrestamo> lista = new ArrayList<>();
    try {
        con.conectar();
        PreparedStatement sql=con.Estado().prepareStatement("SELECT " +
        "cod_detallep " +
        ",obser_detallep " +
        ",tit_obra " +
        "FROM " +
        "detalle_prestamo " +
        "INNER JOIN obradearte " +
        "ON (detalle_prestamo.cod_obra = obradearte.cod_obra) "
        + "WHERE cod_prestamo='"+prestamo+"'");
        ResultSet rs=sql.executeQuery();
        while(rs.next()){
            lista.add(new DetallePrestamo(rs.getInt("cod_detallep"), 
                    rs.getString("obser_detallep"), 
                    rs.getString("tit_obra")));
            }
    } catch (SQLException e) {
            System.out.println("ERROR LISTAR  DETALLES DE PRESTAMOS EN PRESTAMOS= "+"\n"+e);
    }finally{
            con.Desconectar();
        }
    return lista;
    }
    
    //insertar detalles
    public void InsertarDetallesPrestamos( String obs, String codP, int codO){
    try {
        con.conectar();
        PreparedStatement sql=con.Estado().prepareStatement("INSERT INTO detalle_prestamo "
                + "(obser_detallep,cod_prestamo,cod_obra) "
                + "VALUES ('"+obs+"','"+codP+"','"+codO+"')");
        sql.execute();
        } catch (SQLException e) {
            System.out.println("ERROR INSERTAR DETALLES DE PRESTAMOS= "+"\n"+e);
    }finally{
            con.Desconectar();
        }
    }
    
    //editar detalles
    public void EditarDetallesPrestamos(int cod, String obs, String codP, int codO){
    try {
        con.conectar();
        PreparedStatement sql=con.Estado().prepareStatement("UPDATE  detalle_prestamo SET "
                + "obser_detallep='"+obs+"' "
                + ",cod_prestamo='"+codP+"' "
                + ",cod_obra='"+codO+"' "
                + "WHERE cod_detallep='"+cod+"'");
        sql.execute();
        } catch (SQLException e) {
            System.out.println("ERROR EDITRAR DETALLES DE PRESTAMOS= "+"\n"+e);
    }finally{
            con.Desconectar();
        }
    }
    
    //eliminar detalles
    public void EliminarDetallesPrestamos(int cod){
    try {
        con.conectar();
        PreparedStatement sql=con.Estado().prepareStatement("DELETE FROM detalle_prestamo");
        sql.execute();
        } catch (SQLException e) {
            System.out.println("ERROR EDITRAR DETALLES DE PRESTAMOS= "+"\n"+e);
    }finally{
            con.Desconectar();
        }
    }
    
    //listar obras de artes para ComboBox
    public List listarObras(){
    List<ObraDeArte> lista = new ArrayList<>();
    try {
        con.conectar();
        PreparedStatement sql=con.Estado().prepareStatement("SELECT cod_obra, tit_obra FROM obradearte");
        ResultSet rs=sql.executeQuery();
        while(rs.next()){
            lista.add(new ObraDeArte(rs.getInt("cod_obra"), rs.getString("tit_obra")));
            }
    } catch (SQLException e) {
            System.out.println("ERROR COMBO BOX OBRAS DE ARTE= "+"\n"+e);
    }finally{
            con.Desconectar();
        }
    return lista;
    }
    
    //listar Prestamos para combobox
    public List listarPrestamos(){
    List<Prestamos> lista = new ArrayList<>();
    try {
        con.conectar();
        PreparedStatement sql=con.Estado().prepareStatement("SELECT cod_prestamo, fec_prestamo FROM prestamos");
        ResultSet rs=sql.executeQuery();
        while(rs.next()){
            lista.add(new Prestamos(rs.getInt("cod_prestamo"), rs.getDate("fec_prestamo")));
            }
    } catch (SQLException e) {
            System.out.println("ERROR COMBO BOX PRESTAMOS= "+"\n"+e);
    }finally{
            con.Desconectar();
        }
    return lista;
    }
}
