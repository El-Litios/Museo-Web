/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CONTROLADOR;


import MODELO.PrestamoSeguros;
import MODELO.Prestamos;
import MODELO.SeguroPrestamo;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Mark-
 */
public class Control_SegPres {
    Control_conexion con=new Control_conexion();
    
    //listar prestamosSeguros
    public List ListaSegPresEnPrestamos(String prestamo){
    List<PrestamoSeguros> lista = new ArrayList<>();
    try {
        con.conectar();
        PreparedStatement sql=con.Estado().prepareStatement("SELECT " +
        "cod_preseg " +
        ",desc_seguro " +
        ",fec_seguro " +
        ",monto_seguro " +
        "FROM prestamoseguro " +
        "INNER JOIN seguros " +
        "ON (prestamoseguro.cod_seguro = seguros.cod_seguro) "
        + "WHERE cod_prestamo='"+prestamo+"'");
        ResultSet rs=sql.executeQuery();
        while(rs.next()){
            lista.add(new PrestamoSeguros(rs.getInt("cod_preseg"), rs.getString("desc_seguro"), rs.getDate("fec_seguro"), rs.getInt("monto_seguro")));
            }
    } catch (SQLException e) {
            System.out.println("ERROR LISTAR PRESSEG PARA LOS PRESTAMOS= "+"\n"+e);
    }finally{
            con.Desconectar();
        }
    return lista;
    }
    
    //listar prestamosSeguros
    public List ListarPresSeg(String seguro){
    List<PrestamoSeguros> lista = new ArrayList<>();
    try {
        con.conectar();
        PreparedStatement sql=con.Estado().prepareStatement("SELECT " +
        "cod_preseg " +
        ",fec_prestamo " +
        ",costo_asociado " +
        ",nom_museo " +
        ",nom_estadop " +
        "FROM prestamoseguro " +
        "INNER JOIN prestamos " +
        "ON (prestamoseguro.cod_prestamo = prestamos.cod_prestamo) " +
        "INNER JOIN museos " +
        "ON (prestamos.cod_museo = museos.cod_museo) " +
        "INNER JOIN estadoprestamo " +
        "ON (prestamos.cod_estadop = estadoprestamo.cod_estadop) "
        + "WHERE cod_seguro='"+seguro+"'");
        ResultSet rs=sql.executeQuery();
        while(rs.next()){
            lista.add(new PrestamoSeguros(rs.getInt("cod_preseg"), 
                    rs.getDate("fec_prestamo"), rs.getInt("costo_asociado"), rs.getString("nom_estadop"), rs.getString("nom_museo")));
            }
    } catch (SQLException e) {
            System.out.println("ERROR LISTAR PRESSEG= "+"\n"+e);
    }finally{
            con.Desconectar();
        }
    return lista;
    }
    
    //insertar prestamosSeguros
    public void InsertarPresSeg(String codP, String codS){
    try {
        con.conectar();
        PreparedStatement sql=con.Estado().prepareStatement("INSERT INTO PrestamoSeguro (cod_prestamo,cod_seguro) "
                + "VALUES ('"+codP+"','"+codS+"')");
        sql.execute();
        } catch (SQLException e) {
            System.out.println("ERROR INSERTAR PRESSEG= "+"\n"+e);
    }finally{
            con.Desconectar();
        }
    }
    
    //editar prestamosSeguros
    public void EditarPresSeg(int cod, String codP, String codS){
    try {
        con.conectar();
        PreparedStatement sql=con.Estado().prepareStatement("UPDATE PrestamoSeguro SET "
                + "cod_prestamo='"+codP+"', cod_seguro='"+codS+"' WHERE cod_preseg='"+cod+"'");
        sql.execute();
        } catch (SQLException e) {
            System.out.println("ERROR EDITAR PRESSEG= "+"\n"+e);
    }finally{
            con.Desconectar();
        }
    }
    
    //eliminar prestamosSeguros
    public void EliminarPresSeg(int cod){
    try {
        con.conectar();
        PreparedStatement sql=con.Estado().prepareStatement("DELETE FROM PrestamoSeguro WHERE cod_preseg='"+cod+"'");
        sql.execute();
        } catch (SQLException e) {
            System.out.println("ERROR ELIMINAR PRESSEG= "+"\n"+e);
    }finally{
            con.Desconectar();
        }
    }
    
    //listar prestamos
    public List ListarPrestamos(){
    List<Prestamos> lista = new ArrayList<>();
    try {
        con.conectar();
        PreparedStatement sql=con.Estado().prepareStatement("SELECT cod_prestamo,fec_prestamo FROM prestamos");
        ResultSet rs=sql.executeQuery();
        while(rs.next()){
            lista.add(new Prestamos(rs.getInt("cod_prestamo"), rs.getDate("fec_prestamo")));
            }
    } catch (SQLException e) {
            System.out.println("ERROR LISTAR PRESTAMOS PARA PRESSEG= "+"\n"+e);
    }finally{
            con.Desconectar();
        }
    return lista;
    }
    
    //listar seguros de prestamos
    public List ListarSeguro(){
    List<SeguroPrestamo> lista = new ArrayList<>();
    try {
        con.conectar();
        PreparedStatement sql=con.Estado().prepareStatement("SELECT cod_seguro,desc_seguro FROM seguros");
        ResultSet rs=sql.executeQuery();
        while(rs.next()){
            lista.add(new SeguroPrestamo(rs.getInt("cod_seguro"), rs.getString("desc_seguro")));
            }
    } catch (SQLException e) {
            System.out.println("ERROR LISTAR SEGUROS DE PRESTAMO PARA PRESSEG= "+"\n"+e);
    }finally{
            con.Desconectar();
        }
    return lista;
    }
}
