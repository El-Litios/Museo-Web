/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CONTROLADOR;


import MODELO.Devoluciones;
import MODELO.Prestamos;
import MODELO.SeguroDevoluciones;
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
public class Control_SeguroDevolucion {
    Control_conexion con=new Control_conexion();
    
    //listar prestamos para combobox
    public List ListarDevoluciones(){
    List<Devoluciones> lista = new ArrayList<>();
    try {
        con.conectar();
        PreparedStatement sql=con.Estado().prepareStatement("SELECT cod_devolucion, fec_devolucion FROM devoluciones");
        ResultSet rs=sql.executeQuery();
        while(rs.next()){
            lista.add(new Devoluciones(rs.getInt("cod_devolucion"), rs.getDate("fec_devolucion")));
            }
    } catch (SQLException e) {
            System.out.println("ERROR LISTAR DEVOLUCIONES PARA COMBOBOX= "+"\n"+e);
    }finally{
            con.Desconectar();
        }
    return lista;
    }
    
    //listar detalles
    public List ListarDetalle(String codigo){
    List<SeguroDevoluciones> lista = new ArrayList<>();
    try {
        con.conectar();
        PreparedStatement sql=con.Estado().prepareStatement("SELECT " +
        "cod_segurodev," +
        "fec_segurodev," +
        "monto_segurodev " +
        "FROM segurosdevo WHERE cod_segurodev='"+codigo+"'");
        ResultSet rs=sql.executeQuery();
        while(rs.next()){
            lista.add(new SeguroDevoluciones(rs.getInt("cod_segurodev"), 
                    rs.getDate("fec_segurodev"), 
                    rs.getInt("monto_segurodev")));
            }
    } catch (SQLException e) {
            System.out.println("ERROR LISTAR SEGURO PARA DETALLES= "+"\n"+e);
    }finally{
            con.Desconectar();
        }
    return lista;
    }
    
    //listar seguros
    public List ListarSeguro(){
    List<SeguroDevoluciones> lista = new ArrayList<>();
    try {
        con.conectar();
        PreparedStatement sql=con.Estado().prepareStatement("SELECT " +
        "cod_segurodev," +
        "desc_segurodev," +
        "fec_segurodev," +
        "monto_segurodev " +
        "FROM segurosdevo");
        ResultSet rs=sql.executeQuery();
        while(rs.next()){
            lista.add(new SeguroDevoluciones(rs.getInt("cod_segurodev"), 
                    rs.getString("desc_segurodev"), 
                    rs.getDate("fec_segurodev"), 
                    rs.getInt("monto_segurodev")));
            }
    } catch (SQLException e) {
            System.out.println("ERROR LISTAR  SEGUROS PARA DEVOLUCIONES= "+"\n"+e);
    }finally{
            con.Desconectar();
        }
    return lista;
    }
    
    //insertar seguros
    public void InsertarSeguro(String desc, Date fec, int monto){
    try {
        con.conectar();
        PreparedStatement sql=con.Estado().prepareStatement("INSERT INTO segurosdevo "
                + "(desc_segurodev,fec_segurodev,monto_segurodev) "
                + "VALUES ('"+desc+"','"+fec+"','"+monto+"')");
        sql.execute();
        } catch (SQLException e) {
            System.out.println("ERROR INSERTAR SEGUROS PARA DEVOLUCIONES= "+"\n"+e);
    }finally{
            con.Desconectar();
        }
    }
    
    //editar seguros
    public void EditarSeguro(int cod, String desc, Date fec, int monto){
    try {
        con.conectar();
        PreparedStatement sql=con.Estado().prepareStatement("UPDATE segurosdevo SET "
                + "desc_segurodev='"+desc+"',fec_segurodev='"+fec+"',monto_segurodev='"+monto+"' "
                + "WHERE cod_segurodev='"+cod+"'");
        sql.execute();
        } catch (SQLException e) {
            System.out.println("ERROR EDITAR SEGUROS PARA DEVOLUCIONES= "+"\n"+e);
    }finally{
            con.Desconectar();
        }
    }
      
    //eliminar seguros
    public void EliminarSeguro(int cod){
    try {
        con.conectar();
        PreparedStatement sql=con.Estado().prepareStatement("DELETE FROM segurosdevo WHERE cod_segurodev='"+cod+"'");
        sql.execute();
        } catch (SQLException e) {
            System.out.println("ERROR ELIMINAR SEGUROS PARA DEVOLUCIONES= "+"\n"+e);
    }finally{
            con.Desconectar();
        }
    }
    
    //buscar seguros
    public List BuscarSeguro(String dato){
    List<SeguroDevoluciones> lista = new ArrayList<>();
    try {
        con.conectar();
        PreparedStatement sql=con.Estado().prepareStatement("SELECT " +
        "cod_segurodev," +
        "desc_segurodev," +
        "fec_segurodev," +
        "monto_segurodev " +
        "FROM segurosdevo "
        + "WHERE desc_segurodev LIKE '%"+dato+"%' OR fec_segurodev LIKE '%"+dato+"%' OR monto_segurodev LIKE '%"+dato+"%'");
        ResultSet rs=sql.executeQuery();
        while(rs.next()){
            lista.add(new SeguroDevoluciones(rs.getInt("cod_segurodev"), rs.getString("desc_segurodev"), rs.getDate("fec_segurodev"), rs.getInt("monto_segurodev")));
            }
    } catch (SQLException e) {
            System.out.println("ERROR BUSCAR SEGUROS DE DEVOLUCIONES= "+"\n"+e);
    }finally{
            con.Desconectar();
        }
    return lista;
    }
}
