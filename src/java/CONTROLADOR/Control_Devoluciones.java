/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CONTROLADOR;

import MODELO.Devoluciones;
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
public class Control_Devoluciones {
    Control_conexion con=new Control_conexion();
    
    
    //listar devoluciones para BOTON DETALLES de PRESTAMOS
    public List ListaDevoEnPrestamos(String prestamo){
    List<Devoluciones> lista = new ArrayList<>();
    try {
        con.conectar();
        PreparedStatement sql=con.Estado().prepareStatement("SELECT " +
        "cod_devolucion " +
        ",fec_devolucion " +
        ",docs_devolucion " +
        ",comen_devolucion " +
        "FROM devoluciones "
        + "WHERE cod_prestamo='"+prestamo+"'");
        ResultSet rs=sql.executeQuery();
        while(rs.next()){
            lista.add(new Devoluciones(rs.getInt("cod_devolucion"), 
                    rs.getDate("fec_devolucion"), 
                    rs.getString("docs_devolucion"), 
                    rs.getString("comen_devolucion")));
            }
    } catch (SQLException e) {
            System.out.println("ERROR LISTAR DEVOLUCIONES EN LOS PRESTAMOS= "+"\n"+e);
    }finally{
            con.Desconectar();
        }
    return lista;
    }
    
    //listar devoluciones
    public List ListarDevoluciones(){
    List<Devoluciones> lista = new ArrayList<>();
    try {
        con.conectar();
        PreparedStatement sql=con.Estado().prepareStatement("SELECT " +
        "cod_devolucion " +
        ",fec_devolucion " +
        ",docs_devolucion " +
        ",comen_devolucion " +
        ",fec_prestamo " +
        "FROM devoluciones " +
        "INNER JOIN prestamos " +
        "ON (devoluciones.cod_prestamo = prestamos.cod_prestamo)");
        ResultSet rs=sql.executeQuery();
        while(rs.next()){
            lista.add(new Devoluciones(rs.getInt("cod_devolucion"), 
                    rs.getDate("fec_devolucion"), 
                    rs.getString("docs_devolucion"), 
                    rs.getString("comen_devolucion"), 
                    rs.getDate("fec_prestamo")));
            }
    } catch (SQLException e) {
            System.out.println("ERROR LISTAR DEVOLUCIONES= "+"\n"+e);
    }finally{
            con.Desconectar();
        }
    return lista;
    }
    
    //insertar devoluciones
    public void InsertarDevoluciones(Date fec, String docs, String comen, String codP){
        try {
            con.conectar();
            PreparedStatement sql=con.Estado().prepareStatement("INSERT INTO devoluciones (fec_devolucion,docs_devolucion,comen_devolucion,cod_prestamo) "
            + "VALUES ('"+fec+"','"+docs+"','"+comen+"','"+codP+"')");
            sql.execute();
        } catch (SQLException e) {
            System.out.println("ERROR INSERTAR DEVOLUCIONES= "+"\n"+e);
        }finally{
        con.Desconectar();
        }
    }
    
    //editar devoluciones
    public void EditarDevoluciones(int cod,Date fec, String docs, String comen, String codP){
        try {
            con.conectar();
            PreparedStatement sql=con.Estado().prepareStatement("UPDATE devoluciones SET "
            + "fec_devolucion='"+fec+"',docs_devolucion='"+docs+"',comen_devolucion='"+comen+"',cod_prestamo='"+codP+"' "
            + "WHERE cod_devolucion='"+cod+"'");
            sql.execute();
        } catch (SQLException e) {
            System.out.println("ERROR EDITAR DEVOLUCIONES= "+"\n"+e);
        }finally{
        con.Desconectar();
        }
    }
    
    //eliminar devoluciones
    public void EliminarDevoluciones(int cod){
        try {
            con.conectar();
            PreparedStatement sql=con.Estado().prepareStatement("DELETE FROM devoluciones WHERE cod_devolucion='"+cod+"'");
            sql.execute();
        } catch (SQLException e) {
            System.out.println("ERROR EDITAR DEVOLUCIONES= "+"\n"+e);
        }finally{
        con.Desconectar();
        }
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
