/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CONTROLADOR;


import MODELO.SeguroPrestamo;
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
public class Control_SeguroPrestamo {
    Control_conexion con=new Control_conexion();
    
    //listar detalles seguros para los prestamos
    public List ListaDetalle(String codigo){
    List<SeguroPrestamo> lista = new ArrayList<>();
    try {
        con.conectar();
        PreparedStatement sql=con.Estado().prepareStatement("SELECT " +
        "cod_seguro," +
        "desc_seguro," +
        "fec_seguro," +
        "monto_seguro " +
        "FROM seguros "
        + "WHERE cod_seguro='"+codigo+"'");
        ResultSet rs=sql.executeQuery();
        while(rs.next()){
            lista.add(new SeguroPrestamo(rs.getInt("cod_seguro"), 
                    rs.getString("desc_seguro"), 
                    rs.getDate("fec_seguro"), 
                    rs.getInt("monto_seguro")));
            }
    } catch (SQLException e) {
            System.out.println("ERROR LISTAR DETALLES DE SEGURO DE PRESTAMOS= "+"\n"+e);
    }finally{
            con.Desconectar();
        }
    return lista;
    }
    
    //listar seguros
    public List ListarSeguro(){
    List<SeguroPrestamo> lista = new ArrayList<>();
    try {
        con.conectar();
        PreparedStatement sql=con.Estado().prepareStatement("SELECT cod_seguro," +
        "desc_seguro," +
        "fec_seguro," +
        "monto_seguro " +
        "FROM seguros");
        ResultSet rs=sql.executeQuery();
        while(rs.next()){
            lista.add(new SeguroPrestamo(rs.getInt("cod_seguro"), 
                    rs.getString("desc_seguro"), 
                    rs.getDate("fec_seguro"), 
                    rs.getInt("monto_seguro")));
            }
    } catch (SQLException e) {
            System.out.println("ERROR LISTAR SEGUROS DE PRESTAMOS= "+"\n"+e);
    }finally{
            con.Desconectar();
        }
    return lista;
    }
    
    //insertar seguros
    public void InsertarSeguro(String desc, Date fec, int monto){
    try {
        con.conectar();
        PreparedStatement sql=con.Estado().prepareStatement("INSERT INTO seguros "
                + "(desc_seguro,fec_seguro,monto_seguro) "
                + "VALUES ('"+desc+"','"+fec+"','"+monto+"')");
        sql.execute();
        } catch (SQLException e) {
            System.out.println("ERROR INSERTAR SEGUROS PARA PRESTAMOS= "+"\n"+e);
    }finally{
            con.Desconectar();
        }
    }
    
    //editar seguros
    public void EditarSeguro(int cod, String desc, Date fec, int monto){
    try {
        con.conectar();
        PreparedStatement sql=con.Estado().prepareStatement("UPDATE seguros SET "
                + "desc_seguro='"+desc+"',fec_seguro='"+fec+"',monto_seguro='"+monto+"' "
                + "WHERE cod_seguro='"+cod+"'");
        sql.execute();
        } catch (SQLException e) {
            System.out.println("ERROR EDITAR SEGUROS PARA PRESTAMOS= "+"\n"+e);
    }finally{
            con.Desconectar();
        }
    }
      
    //eliminar seguros
    public void EliminarSeguro(int cod){
    try {
        con.conectar();
        PreparedStatement sql=con.Estado().prepareStatement("DELETE FROM seguros WHERE cod_seguro='"+cod+"'");
        sql.execute();
        } catch (SQLException e) {
            System.out.println("ERROR ELIMINAR SEGUROS PARA PRESTAMOS= "+"\n"+e);
    }finally{
            con.Desconectar();
        }
    }
    
    //buscar seguros
    public List BuscarSeguro(String dato){
    List<SeguroPrestamo> lista = new ArrayList<>();
    try {
        con.conectar();
        PreparedStatement sql=con.Estado().prepareStatement("SELECT " +
        "cod_seguro," +
        "desc_seguro," +
        "fec_seguro," +
        "monto_seguro" +
        "FROM seguros "
        + "WHERE desc_seguro LIKE '%"+dato+"%', fec_seguro LIKE '%"+dato+"%', monto_seguro LIKE '%"+dato+"%' ");
        ResultSet rs=sql.executeQuery();
        while(rs.next()){
            lista.add(new SeguroPrestamo(rs.getInt("cod_seguro"), 
                    rs.getString("desc_seguro"), 
                    rs.getDate("fec_seguro"), 
                    rs.getInt("monto_seguro")));
            }
    } catch (SQLException e) {
            System.out.println("ERROR BUSCAR SEGUROS DE PRESTAMOS= "+"\n"+e);
    }finally{
            con.Desconectar();
        }
    return lista;
    }
}
