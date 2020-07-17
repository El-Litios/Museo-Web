/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CONTROLADOR;


import MODELO.DevolucionSeguros;
import MODELO.Devoluciones;
import MODELO.SeguroDevoluciones;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Mark-
 */
public class Control_SegDev {
    Control_conexion con=new Control_conexion();
    
    //listar SegurosDevoluciones en Seguros
    public List SegDevEnSeguros(String seguro){
    List<DevolucionSeguros> lista = new ArrayList<>();
    try {
        con.conectar();
        PreparedStatement sql=con.Estado().prepareStatement("SELECT " +
        "cod_devoseg " +
        ",fec_devolucion " +
        ",docs_devolucion " +
        ",fec_prestamo " +
        "FROM devolucionseguro " +
        "INNER JOIN devoluciones " +
        "ON (devolucionseguro.cod_devolucion = devoluciones.cod_devolucion) " +
        "INNER JOIN prestamos " +
        "ON (devoluciones.cod_prestamo = prestamos.cod_prestamo) "
        + "WHERE cod_segurodev='"+seguro+"'");
        ResultSet rs=sql.executeQuery();
        while(rs.next()){
            lista.add(new DevolucionSeguros(rs.getInt("cod_devoseg"), 
                    rs.getDate("fec_devolucion"), 
                    rs.getString("docs_devolucion"), 
                    rs.getDate("fec_prestamo")));
            }
    } catch (SQLException e) {
            System.out.println("ERROR LISTAR DEVSEG EN SEGUROS= "+"\n"+e);
    }finally{
            con.Desconectar();
        }
    return lista;
    }
    
    //listar DevolucionSeguros
    public List ListarDevSeg(){
    List<DevolucionSeguros> lista = new ArrayList<>();
    try {
        con.conectar();
        PreparedStatement sql=con.Estado().prepareStatement("SELECT " +
        "cod_devoseg " +
        ",fec_devolucion " +
        ",docs_devolucion " +
        ",fec_prestamo " +
        ",fec_segurodev " +
        ",monto_segurodev " +
        "FROM devolucionseguro " +
        "INNER JOIN devoluciones " +
        "ON (devolucionseguro.cod_devolucion = devoluciones.cod_devolucion) " +
        "INNER JOIN prestamos " +
        "ON (devoluciones.cod_prestamo = prestamos.cod_prestamo) " +
        "INNER JOIN segurosdevo " +
        "ON (devolucionseguro.cod_segurodev = segurosdevo.cod_segurodev)");
        ResultSet rs=sql.executeQuery();
        while(rs.next()){
            lista.add(new DevolucionSeguros(rs.getInt("cod_devoseg"), 
                    rs.getDate("fec_segurodev"), 
                    rs.getInt("monto_segurodev"), 
                    rs.getDate("fec_devolucion"), 
                    rs.getString("docs_devolucion"), 
                    rs.getDate("fec_prestamo")));
            }
    } catch (SQLException e) {
            System.out.println("ERROR LISTAR DEVSEG= "+"\n"+e);
    }finally{
            con.Desconectar();
        }
    return lista;
    }
    
    //insertar DevolucionSeguros
    public void InsertarDevSeg(int codD, String codS){
    try {
        con.conectar();
        PreparedStatement sql=con.Estado().prepareStatement("INSERT INTO devolucionseguro (cod_devolucion,cod_segurodev) "
                + "VALUES ('"+codD+"','"+codS+"') ");
        sql.execute();
        } catch (SQLException e) {
            System.out.println("ERROR INSERTAR DEVSEG= "+"\n"+e);
    }finally{
            con.Desconectar();
        }
    }
    
    //editar DevolucionSeguros
    public void EditarDevSeg(int cod, int codP, String codS){
    try {
        con.conectar();
        PreparedStatement sql=con.Estado().prepareStatement("UPDATE devolucionseguro SET "
                + "cod_devolucion='"+codP+"', cod_segurodev='"+codS+"' WHERE cod_devoseg='"+cod+"'");
        sql.execute();
        } catch (SQLException e) {
            System.out.println("ERROR EDITAR DEVSEG= "+"\n"+e);
    }finally{
            con.Desconectar();
        }
    }
    
    //eliminar DevolucionSeguros
    public void EliminarPresSeg(int cod){
    try {
        con.conectar();
        PreparedStatement sql=con.Estado().prepareStatement("DELETE FROM devolucionseguro WHERE cod_devoseg='"+cod+"'");
        sql.execute();
        } catch (SQLException e) {
            System.out.println("ERROR ELIMINAR DEVSEG= "+"\n"+e);
    }finally{
            con.Desconectar();
        }
    }
    
    //listar devoluciones
    public List ListarDevoluciones(){
    List<Devoluciones> lista = new ArrayList<>();
    try {
        con.conectar();
        PreparedStatement sql=con.Estado().prepareStatement("SELECT cod_devolucion,fec_devolucion FROM devoluciones");
        ResultSet rs=sql.executeQuery();
        while(rs.next()){
            lista.add(new Devoluciones(rs.getInt("cod_devolucion"), rs.getDate("fec_devolucion")));
            }
    } catch (SQLException e) {
            System.out.println("ERROR LISTAR DEVOLUCIONES PARA DEVSEG= "+"\n"+e);
    }finally{
            con.Desconectar();
        }
    return lista;
    }
    
    //listar seguros de devoluciones
    public List ListarSeguro(){
    List<SeguroDevoluciones> lista = new ArrayList<>();
    try {
        con.conectar();
        PreparedStatement sql=con.Estado().prepareStatement("SELECT cod_segurodev,desc_segurodev FROM segurosdevo");
        ResultSet rs=sql.executeQuery();
        while(rs.next()){
            lista.add(new SeguroDevoluciones(rs.getInt("cod_segurodev"), rs.getString("desc_segurodev")));
            }
    } catch (SQLException e) {
            System.out.println("ERROR LISTAR SEGUROS DE DEVOLUCIONES PARA DEVSEG= "+"\n"+e);
    }finally{
            con.Desconectar();
        }
    return lista;
    }
}
