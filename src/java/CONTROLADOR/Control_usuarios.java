package CONTROLADOR;

import MODELO.Especialidades;
import MODELO.EspecialidadUsuario;
import MODELO.Rol;
import MODELO.Usuarios;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class Control_usuarios extends Usuarios {
    Control_conexion con=new Control_conexion();
    
    
    
    //Registrar usuario publico
    public void RegistrarUsu(String usuario, String pass, String nom, String em){
    
    try {
        con.conectar();
        PreparedStatement sql=con.Estado().prepareStatement("INSERT INTO usuarios(nom_usu, pass_usu, p_nombre, em_usu, codRol) "
                + " VALUES ('"+usuario+"','"+pass+"','"+nom+"','"+em+"','10')");
        sql.execute();
        } catch (SQLException e) {
            System.out.println("ERROR add Usu= "+e);
    }finally{
            con.Desconectar();
        }
    
    }
    
    
    //verificar cl;ave secreta de admin
    public boolean claveADM(String clave){//String cod para buscar al susuario por codigo
    try {
        con.conectar();
        PreparedStatement sql=con.Estado().prepareStatement("SELECT em_admin FROM administrador "
                + " WHERE pass_admin='"+clave+"'");
        ResultSet rs=sql.executeQuery();
        if(rs.next()){
            return true;
            }
    } catch (SQLException e) {
            System.out.println("ERROR VeriClaveADM= "+e);
    }finally{
            con.Desconectar();
        }
    return false;
    }
    
    
    //eliminar usuarios
    public void eliminarUsu(String cod){
    
    try {
        con.conectar();
        PreparedStatement sql=con.Estado().prepareStatement("DELETE FROM usuarios WHERE cod_usu='"+cod+"'");
        sql.execute();
        } catch (SQLException e) {
            System.out.println("ERROR eliminarUsu= "+e);
    }finally{
            con.Desconectar();
        }
    
    }
    
    //modificar usuarios
    public void editarUsu(String codU, String usu_nom, String pass, String nom, String em, String rol){
    
    try {
        con.conectar();
        PreparedStatement sql=con.Estado().prepareStatement("UPDATE  usuarios SET nom_usu='"+usu_nom+"', "
                + "pass_usu='"+pass+"', p_nombre='"+nom+"',em_usu='"+em+"', codRol='"+rol+"' "
                + " WHERE cod_usu='"+codU+"'");
        sql.execute();
        } catch (SQLException e) {
            System.out.println("ERROR EditarUsu= "+e);
    }finally{
            con.Desconectar();
        }
    
    }
    
    //BUSCAR USUARIOS
    public List buscarUsu(String buscar){//String cod para buscar al susuario por codigo
    List<Usuarios> lista = new ArrayList<>();
    try {
        con.conectar();
        PreparedStatement sql=con.Estado().prepareStatement("SELECT cod_usu, nom_usu, pass_usu, p_nombre, em_usu, rol_nom FROM Rol "
                + " INNER JOIN usuarios ON (rol.rol_cod=usuarios.codRol) "
                + " WHERE nom_usu LIKE '%"+buscar+"%' OR p_nombre LIKE '%"+buscar+"%' ");
        ResultSet rs=sql.executeQuery();
        while(rs.next()){
            lista.add(new Usuarios(rs.getInt("cod_usu"), rs.getString("nom_usu"), rs.getString("pass_usu"), rs.getString("p_nombre"), rs.getString("em_usu"), rs.getString("rol_nom")));
            }
    } catch (SQLException e) {
            System.out.println("ERROR CTRL ROL= "+e);
    }finally{
            con.Desconectar();
        }
    return lista;
    }
    
    
    //agregar usuario
    public void insrtarUsu(String usuario, String pass, String nom, String em, String codRol){
    try {
        con.conectar();
        PreparedStatement sql=con.Estado().prepareStatement("INSERT INTO usuarios(nom_usu, pass_usu, p_nombre, em_usu, codRol) "
                + " VALUES ('"+usuario+"','"+pass+"','"+nom+"','"+em+"','"+codRol+"')");
        sql.execute();
        } catch (SQLException e) {
            System.out.println("ERROR add Usu= "+e);
    }finally{
            con.Desconectar();
        }
    
    }
    
    //lista de roles
    public List listaRoles(){
    List<Rol> lista = new ArrayList<>();
    try {
        con.conectar();
        PreparedStatement sql=con.Estado().prepareStatement("SELECT * FROM Rol");
        ResultSet rs=sql.executeQuery();
        while(rs.next()){
            lista.add(new Rol(rs.getInt("rol_cod"), rs.getString("rol_nom")));
            }
    } catch (SQLException e) {
            System.out.println("ERROR CTRL ROL= "+e);
    }finally{
            con.Desconectar();
        }
    return lista;
    }
    
    public List lista_usus(){
    List<Usuarios> lista = new ArrayList<>();
    try {
        con.conectar();
        PreparedStatement sql=con.Estado().prepareStatement("SELECT cod_usu, nom_usu, pass_usu, p_nombre, em_usu, rol_nom FROM Rol "
                + " INNER JOIN usuarios ON (rol.rol_cod=usuarios.codRol)");
        ResultSet rs=sql.executeQuery();
        while(rs.next()){
            lista.add(new Usuarios(rs.getInt("cod_usu"), rs.getString("nom_usu"), rs.getString("pass_usu"), rs.getString("p_nombre"), rs.getString("em_usu"), rs.getString("rol_nom")));
            }
    } catch (SQLException e) {
            System.out.println("ERROR CTRL ROL= "+e);
    }finally{
            con.Desconectar();
        }
    return lista;
    }
    
    //verificar login
    public boolean verificar(String usuario, String pass){
        
        try {
            con.conectar();
            PreparedStatement sql=con.Estado().prepareStatement("SELECT p_nombre, rol_nom FROM rol INNER JOIN usuarios " +
            " ON (usuarios.codRol = rol.rol_cod) "
            + "WHERE nom_usu='"+usuario+"' AND pass_usu='"+pass+"'");
            ResultSet rs=sql.executeQuery();
            if(rs.next()){
                this.setRol_nom(rs.getString("rol_nom"));
                this.setNombre(rs.getString("p_nombre"));
                return true;           
            }
        } catch (SQLException e) {
            System.out.println("ERROR= "+e);
        }finally{
        con.Desconectar();
        }
        return false;
    }
    
    //PreparedStatement ps;
    
    /*public boolean login(String nom, String pass){
    con.conectar();
        try {
            PreparedStatement sql=con.Estado().prepareStatement("SELECT nom_usu, pass_usu FROM usuarios WHERE nom_usu='"+nom+"' AND pass_usu='"+pass+"'");
            ResultSet res=sql.executeQuery();
            if (res.next()) {
            this.setUsu_nom("nom_usu");
            return true;
            }
        } catch (SQLException e) {
            System.out.println("ERROR CONSULTA LOGIN= /n"+e);
        }finally{
        con.Desconectar();
        }    
    return false;
    }
    */
}
