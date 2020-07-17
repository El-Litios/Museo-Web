package CONTROLADOR;

import MODELO.Nacionalidades;
import MODELO.Paises;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Control_Nacionalidades{
    Control_conexion con=new Control_conexion();
    
    public List lista_nac(){
    List<Nacionalidades> lista = new ArrayList<>();
    try {
        con.conectar();
        PreparedStatement sql=con.Estado().prepareStatement("SELECT " +
        "cod_nac " +
        ",desc_nac " +
        ",nom_pais " +
        "FROM " +
        "nacionalidades " +
        "INNER JOIN pais " +
        "ON (nacionalidades.cod_pais = pais.cod_pais)" );
        ResultSet rs=sql.executeQuery();
        while(rs.next()){
            lista.add(new Nacionalidades(rs.getInt("cod_nac"), rs.getString("desc_nac"), rs.getString("nom_pais")));
            }
    } catch (SQLException e) {
            System.out.println("ERROR listaNac= "+e);
    }finally{
            con.Desconectar();
        }
    return lista;
    }
    
    //listar paises
    public List lista_Paises(){
    List<Paises> lista = new ArrayList<>();
    try {
        con.conectar();
        PreparedStatement sql=con.Estado().prepareStatement("SELECT cod_pais, nom_pais FROM pais ORDER BY nom_pais");
        ResultSet rs=sql.executeQuery();
        while(rs.next()){
            lista.add(new Paises(rs.getInt("cod_pais"), rs.getString("nom_pais")));
            }
    } catch (SQLException e) {
            System.out.println("ERROR listaPaises= "+e);
    }finally{
            con.Desconectar();
        }
    return lista;
    }
    
    //insertar nacion
    public void insrtarNac(String nom, String codP){
    try {
        con.conectar();
        PreparedStatement sql=con.Estado().prepareStatement("INSERT INTO nacionalidades(desc_nac, cod_pais)  "
                + " VALUES ('"+nom+"','"+codP+"')");
        sql.execute();
        } catch (SQLException e) {
            System.out.println("ERROR addNac= "+e);
    }finally{
            con.Desconectar();
        }
    }
    
    //buscar nacionalidades
    public List buscarNac(String buscar){//String cod para buscar galerias por codigo
    List<Nacionalidades> lista = new ArrayList<>();
    try {
        con.conectar();
        PreparedStatement sql=con.Estado().prepareStatement("SELECT cod_nac, desc_nac, nom_pais FROM nacionalidades "
        + " INNER JOIN pais ON (pais.cod_pais=nacionalidades.cod_nac)"
        +" WHERE desc_nac LIKE '%"+buscar+"%'");
        ResultSet rs=sql.executeQuery();
        while(rs.next()){
            lista.add(new Nacionalidades(rs.getInt("cod_nac"), rs.getString("desc_nac"), rs.getString("nom_pais")));
            }
    } catch (SQLException e) {
            System.out.println("ERROR buscarNac= "+e);
    }finally{
            con.Desconectar();
        }
    return lista;
    }
    
    //modificar nacionalidades
    public void editarNac(String codN, String nom, String pais){
    
    try {
        con.conectar();
        PreparedStatement sql=con.Estado().prepareStatement("UPDATE  nacionalidades SET desc_nac='"+nom+"', "
        + " cod_pais='"+pais+"' "
        + " WHERE cod_nac='"+codN+"'");
        sql.execute();
    } catch (SQLException e) {
            System.out.println("ERROR EditarNac= "+e);
    }finally{
            con.Desconectar();
        }
    
    }
    
     //eliminar Nacionalidades
    public void eliminarNac(String cod){
    try {
        con.conectar();
        PreparedStatement sql=con.Estado().prepareStatement("DELETE FROM nacionalidades WHERE cod_nac='"+cod+"'");
        sql.execute();
        } catch (SQLException e) {
            System.out.println("ERROR eliminarNac= "+e);
    }finally{
            con.Desconectar();
        }
    }
    
    
}
