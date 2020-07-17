/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CONTROLADOR;


import MODELO.EstadoPrestamo;
import MODELO.Museos;
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
public class Control_Prestamos {
    Control_conexion con=new Control_conexion();
    
    //listar para el boton de Detalles en CRUD de prestamos
    public List ComboboxPrestamo(){
    List<Prestamos> lista = new ArrayList<>();
    try {
        con.conectar();
        PreparedStatement sql=con.Estado().prepareStatement("SELECT " +
        "cod_prestamo " +
        ",fec_prestamo " +
        "FROM " +
        "prestamos ");
        ResultSet rs=sql.executeQuery();
        while(rs.next()){
            lista.add(new Prestamos(rs.getInt("cod_prestamo"), 
                    rs.getDate("fec_prestamo")));
            }
    } catch (SQLException e) {
            System.out.println("ERROR LISTAR COMBOBOX PRESTAMOS = "+"\n"+e);
    }finally{
            con.Desconectar();
        }
    return lista;
    }
    
    //listar para el boton de Detalles en CRUD de prestamos
    public List ListarDetalles(String codigo){
    List<Prestamos> lista = new ArrayList<>();
    try {
        con.conectar();
        PreparedStatement sql=con.Estado().prepareStatement("SELECT " +
        "cod_prestamo " +
        ",fec_prestamo " +
        ",comen_prestamo " +
        ",costo_asociado " +
        ",nom_museo " +
        ",nom_estadop " +
        "FROM " +
        "prestamos " +
        "INNER JOIN museos " +
        "ON (prestamos.cod_museo = museos.cod_museo) " +
        "INNER JOIN estadoprestamo " +
        "ON (prestamos.cod_estadop = estadoprestamo.cod_estadop) "
        + "WHERE cod_prestamo='"+codigo+"'");
        ResultSet rs=sql.executeQuery();
        while(rs.next()){
            lista.add(new Prestamos(rs.getInt("cod_prestamo"), 
                    rs.getDate("fec_prestamo"), 
                    rs.getString("comen_prestamo"), 
                    rs.getInt("costo_asociado"), 
                    rs.getString("nom_estadop"), 
                    rs.getString("nom_museo")));
            }
    } catch (SQLException e) {
            System.out.println("ERROR LISTAR PRESTAMOS= "+"\n"+e);
    }finally{
            con.Desconectar();
        }
    return lista;
    }
    
    //buscar prestamos
    public List BuscarPrestamos(String buscar){//String cod para buscar al susuario por codigo
    List<Prestamos> lista = new ArrayList<>();
    try {
        con.conectar();
        PreparedStatement sql=con.Estado().prepareStatement("SELECT " +
        "cod_prestamo " +
        ",fec_prestamo " +
        ",comen_prestamo " +
        ",costo_asociado " +
        ",nom_museo " +
        ",nom_estadop " +
        "FROM " +
        "prestamos " +
        "INNER JOIN museos " +
        "ON (prestamos.cod_museo = museos.cod_museo) " +
        "INNER JOIN estadoprestamo " +
        "ON (prestamos.cod_estadop = estadoprestamo.cod_estadop) "
        + "WHERE comen_prestamo LIKE '%"+buscar+"%' OR costo_asociado LIKE '%"+buscar+"%' OR nom_museo LIKE '%"+buscar+"%' OR nom_estadop LIKE '%"+buscar+"%'");
        ResultSet rs=sql.executeQuery();
        while(rs.next()){
            lista.add(new Prestamos(rs.getInt("cod_prestamo"), 
                    rs.getDate("fec_prestamo"), 
                    rs.getString("comen_prestamo"), 
                    rs.getInt("costo_asociado"), 
                    rs.getString("nom_estadop"), 
                    rs.getString("nom_museo")));
            }
    } catch (SQLException e) {
            System.out.println("ERROR LISTAR PRESTAMOS= "+"\n"+e);
    }finally{
            con.Desconectar();
        }
    return lista;
    }
    
    //listar prestamos
    public List ListarPrestamos(){//String cod para buscar al susuario por codigo
    List<Prestamos> lista = new ArrayList<>();
    try {
        con.conectar();
        PreparedStatement sql=con.Estado().prepareStatement("SELECT " +
        "cod_prestamo " +
        ",fec_prestamo " +
        ",comen_prestamo " +
        ",costo_asociado " +
        ",nom_museo " +
        ",nom_estadop " +
        "FROM " +
        "prestamos " +
        "INNER JOIN museos " +
        "ON (prestamos.cod_museo = museos.cod_museo) " +
        "INNER JOIN estadoprestamo " +
        "ON (prestamos.cod_estadop = estadoprestamo.cod_estadop)");
        ResultSet rs=sql.executeQuery();
        while(rs.next()){
            lista.add(new Prestamos(rs.getInt("cod_prestamo"), 
                    rs.getDate("fec_prestamo"), 
                    rs.getString("comen_prestamo"), 
                    rs.getInt("costo_asociado"), 
                    rs.getString("nom_estadop"), 
                    rs.getString("nom_museo")));
            }
    } catch (SQLException e) {
            System.out.println("ERROR LISTAR PRESTAMOS= "+"\n"+e);
    }finally{
            con.Desconectar();
        }
    return lista;
    }
    
    //insertar prestamos
    public void InsertarPrestamos(Date fec, String comen, int costo, int museo, int estado){
    try {
        con.conectar();
        PreparedStatement sql=con.Estado().prepareStatement("INSERT INTO prestamos "
                + "(fec_prestamo,comen_prestamo,costo_asociado,cod_museo,cod_estadop) "
                + "VALUES ('"+fec+"','"+comen+"','"+costo+"','"+museo+"','"+estado+"')");
        sql.execute();
        } catch (SQLException e) {
            System.out.println("ERROR INSERTAR PRESTAMOS= "+"\n"+e);
    }finally{
            con.Desconectar();
        }
    }
    
    //editar prestamos
    public void EditarPrestamos(int cod, Date fec, String comen, int costo, int museo, int estado){
    try {
        con.conectar();
        PreparedStatement sql=con.Estado().prepareStatement("UPDATE prestamos SET "
                + "fec_prestamo='"+fec+"',comen_prestamo='"+comen+"',costo_asociado='"+costo+"',cod_museo='"+museo+"',cod_estadop='"+estado+"' "
                + "WHERE cod_prestamo='"+cod+"' ");
        sql.execute();
        } catch (SQLException e) {
            System.out.println("ERROR EDITAR PRESTAMOS= "+"\n"+e);
    }finally{
            con.Desconectar();
        }
    }
    
    //eliminar prestamos
    public void EliminarPrestamos(int cod){
    try {
        con.conectar();
        PreparedStatement sql=con.Estado().prepareStatement("DELETE FROM prestamos WHERE cod_prestamo='"+cod+"'");
        sql.execute();
        } catch (SQLException e) {
            System.out.println("ERROR ELIMINAR PRESTAMOS= "+"\n"+e);
    }finally{
            con.Desconectar();
        }
    }
    
    //listar museos
    public List ListarMuseos(){//String cod para buscar al susuario por codigo
    List<Museos> lista = new ArrayList<>();
    try {
        con.conectar();
        PreparedStatement sql=con.Estado().prepareStatement("SELECT " +
        "cod_museo " +
        ",nom_museo " +
        "FROM " +
        "museos");
        ResultSet rs=sql.executeQuery();
        while(rs.next()){
            lista.add(new Museos(rs.getInt("cod_museo"), rs.getString("nom_museo")));
            }
    } catch (SQLException e) {
            System.out.println("ERROR LISTAR MUSEOS EN PRESTAMOS= "+"\n"+e);
    }finally{
            con.Desconectar();
        }
    return lista;
    }
    
    //listar estado del prestamos
    public List ListarEstadoPrestamos(){//String cod para buscar al susuario por codigo
    List<EstadoPrestamo> lista = new ArrayList<>();
    try {
        con.conectar();
        PreparedStatement sql=con.Estado().prepareStatement("SELECT " +
        "cod_estadop " +
        ",nom_estadop " +
        "FROM " +
        "estadoprestamo");
        ResultSet rs=sql.executeQuery();
        while(rs.next()){
            lista.add(new EstadoPrestamo(rs.getInt("cod_estadop"), rs.getString("nom_estadop")));
            }
    } catch (SQLException e) {
            System.out.println("ERROR LISTAR ESTADOS DE PRESTAMOS EN PRESTAMOS= "+"\n"+e);
    }finally{
            con.Desconectar();
        }
    return lista;
    }
    
}
