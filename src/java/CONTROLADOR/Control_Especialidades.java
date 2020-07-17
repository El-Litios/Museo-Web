/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CONTROLADOR;


import MODELO.EspecialidadUsuario;
import MODELO.Especialidades;
import MODELO.EstadoRestauracion;
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
public class Control_Especialidades {
    Control_conexion con=new Control_conexion();
    
    //listar especialidad
    public List Detalles(String codigo){
    List<EstadoRestauracion> lista = new ArrayList<>();
    try {
        con.conectar();
        PreparedStatement sql=con.Estado().prepareStatement("SELECT cod_estado, nom_estado FROM EstadoRestauracion "
        + "WHERE cod_estado='"+codigo+"'");
        ResultSet rs=sql.executeQuery();
        while(rs.next()){
            lista.add(new EstadoRestauracion(rs.getInt("cod_estado"), rs.getString("nom_estado")));
            }
    } catch (SQLException e) {
            System.out.println("ERROR PARA DETALLES DE RESTAURACIOENS= "+"\n"+e);
    }finally{
            con.Desconectar();
        }
    return lista;
    }
    
    //listar especialidades en usuarios
    public List ListarEspecialUsu(){
    List<EspecialidadUsuario> lista = new ArrayList<>();
    try {
        con.conectar();
        PreparedStatement sql=con.Estado().prepareStatement("SELECT " +
        "cod_eu " +
        ",nom_usu " +
        ",p_nombre " +
        ",em_usu " +
        ",nom_especialidad " +
        "FROM especialidadusuario " +
        "INNER JOIN especialidades " +
        "ON (especialidadusuario.cod_especialidad = especialidades.cod_especialidad) " +
        "INNER JOIN usuarios " +
        "ON (especialidadusuario.cod_usu = usuarios.cod_usu)");
        ResultSet rs=sql.executeQuery();
        while(rs.next()){
            lista.add(new EspecialidadUsuario(rs.getInt("cod_eu"), 
                    rs.getString("nom_especialidad"), 
                    rs.getString("nom_usu"), 
                    rs.getString("p_nombre"), 
                    rs.getString("em_usu")));
            }
    } catch (SQLException e) {
            System.out.println("ERROR LISTAR USUARIOS CON SUS ESPECIALIDADES= "+"\n"+e);
    }finally{
            con.Desconectar();
        }
    return lista;
    }
    
    //insertar especialidades en usuarios
    public void InsertarEspecialUsu(String codU, String codE){
    try {
        con.conectar();
        PreparedStatement sql=con.Estado().prepareStatement("INSERT INTO especialidadusuario (cod_usu, cod_especialidad) "
        + "VALUES ('"+codU+"', '"+codE+"')");
        sql.execute();
        } catch (SQLException e) {
            System.out.println("ERROR INSERTAT ESPECIALIDADES DE USUARIOS= "+"\n"+e);
    }finally{
            con.Desconectar();
        }
    }
    
    //editar especialidades en usuarios
    public void EditarEspecialUsu(String cod, String codU, String codE){
    try {
        con.conectar();
        PreparedStatement sql=con.Estado().prepareStatement("UPDATE especialidadusuario SET "
        + "cod_usu='"+codU+"', cod_especialidad='"+codE+"' WHERE cod_eu='"+cod+"'");
        sql.execute();
        } catch (SQLException e) {
            System.out.println("ERROR EDITAR ESPECIALIDADES DE USUARIOS= "+"\n"+e);
    }finally{
            con.Desconectar();
        }
    }
    
    //eliminar especialidades en usuarios
    public void EliminarEspecialUsu(String cod){
    try {
        con.conectar();
        PreparedStatement sql=con.Estado().prepareStatement("DELETE FROM especialidadusuario "
            + "WHERE cod_eu='"+cod+"'");
        sql.execute();
        } catch (SQLException e) {
            System.out.println("ERROR EDITAR ESPECIALIDADES DE USUARIOS= "+"\n"+e);
    }finally{
            con.Desconectar();
        }
    }
    
    //listar especialidades para comboBox
    public List ListarEspecialidades(){
    List<Especialidades> lista = new ArrayList<>();
    try {
        con.conectar();
        PreparedStatement sql=con.Estado().prepareStatement("SELECT cod_especialidad, nom_especialidad FROM especialidades");
        ResultSet rs=sql.executeQuery();
        while(rs.next()){
            lista.add(new Especialidades(rs.getInt("cod_especialidad"), rs.getString("nom_especialidad")));
            }
    } catch (SQLException e) {
            System.out.println("ERROR LISTAR  ESPECIALIDADES= "+"\n"+e);
    }finally{
            con.Desconectar();
        }
    return lista;
    }
    
    //listar usuarios para comboBox
    public List BuscarEspcialUsu(String buscar){
    List<EspecialidadUsuario> lista = new ArrayList<>();
    try {
        con.conectar();
        PreparedStatement sql=con.Estado().prepareStatement("SELECT " +
        "cod_eu " +
        ",nom_usu " +
        ",p_nombre " +
        ",em_usu " +
        ",nom_especialidad " +
        "FROM especialidadusuario " +
        "INNER JOIN especialidades " +
        "ON (especialidadusuario.cod_especialidad = especialidades.cod_especialidad) " +
        "INNER JOIN usuarios " +
        "ON (especialidadusuario.cod_usu = usuarios.cod_usu) "
        + "WHERE nom_usu LIKE '%"+buscar+"%' OR p_nombre LIKE '%"+buscar+"%' OR em_usu LIKE '%"+buscar+"%' OR nom_especialidad LIKE '%"+buscar+"%'");
        ResultSet rs=sql.executeQuery();
        while(rs.next()){
            lista.add(new EspecialidadUsuario(rs.getInt("cod_eu"), 
                    rs.getString("nom_especialidad"), 
                    rs.getString("nom_usu"), 
                    rs.getString("p_nombre"), 
                    rs.getString("em_usu")));
            }
    } catch (SQLException e) {
            System.out.println("ERROR LISTAR USUARIOS CON SUS ESPECIALIDADES= "+"\n"+e);
    }finally{
            con.Desconectar();
        }
    return lista;
    }
    
    //listar usuarios con rol de restauradores
    public List ListarUsuarios(){
    List<Usuarios> lista = new ArrayList<>();
    try {
        con.conectar();
        PreparedStatement sql=con.Estado().prepareStatement("SELECT cod_usu, nom_usu FROM usuarios WHERE codRol=21 OR codRol=13");
        ResultSet rs=sql.executeQuery();
        while(rs.next()){
            lista.add(new Usuarios(rs.getInt("cod_usu"), rs.getString("nom_usu")));
            }
    } catch (SQLException e) {
            System.out.println("ERROR LISTAR USUARIOS CON ROL DE RESTAURADOR= "+"\n"+e);
    }finally{
            con.Desconectar();
        }
    return lista;
    }
}
