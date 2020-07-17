
package CONTROLADOR;

import MODELO.Autores;
import MODELO.Nacionalidades;
import MODELO.TipoDeObra;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Control_Autores extends Autores{
    Control_conexion con=new Control_conexion();
    
    //autores para mostrar en galerias
    public List listaAutores(){
    List<Autores> lista=new ArrayList<>();
        try {
            con.conectar();
            PreparedStatement sql=con.Estado().prepareStatement("SELECT cod_autor, nom_autor FROM autores");
            ResultSet rs=sql.executeQuery();
            while (rs.next()) {                
                lista.add(new Autores(rs.getInt("cod_autor"), rs.getString("nom_autor")));
            }
        } catch (SQLException e) {
            System.out.println("Error lista de Autores para Galerias= "+"\n"+e);
        }finally{
        con.Desconectar();
        }
    return lista;    
    }
    
    //listar autores
    public List lista_autores(){
    List<Autores> lista = new ArrayList<>();
    try {
        con.conectar();
        PreparedStatement sql=con.Estado().prepareStatement("SELECT cod_autor, nom_autor, pseu_autor, fec_naci, fec_def, desc_nac, nom_pais FROM pais "
                + " INNER JOIN nacionalidades ON (pais.cod_pais=nacionalidades.cod_pais) "
                + " INNER JOIN autores ON (nacionalidades.cod_nac=autores.cod_nac) ORDER BY nom_autor");
        ResultSet rs=sql.executeQuery();
        while(rs.next()){
            lista.add(new Autores(rs.getInt("cod_autor"), 
                    rs.getString("nom_autor"), 
                    rs.getString("pseu_autor"),
                    rs.getString("fec_naci"),
                    rs.getString("fec_def"),
                    rs.getString("desc_nac"), 
                    rs.getString("nom_pais")));
            }
    } catch (SQLException e) {
            System.out.println("ERROR listaAutor= "+e);
    }finally{
            con.Desconectar();
        }
    return lista;
    }
    
    //lista de nacionalidades
    public List lista_nacionalidades(){
    List<Nacionalidades> lista = new ArrayList<>();
    try {
        con.conectar();
        PreparedStatement sql=con.Estado().prepareStatement("SELECT\n" +
"    `nacionalidades`.`cod_nac`\n" +
"    , `pais`.`nom_pais`,\n" +
"    concat(desc_nac, '/',nom_pais) AS desc_nac\n" +
"FROM\n" +
"    `db_ejemplo`.`nacionalidades`\n" +
"    INNER JOIN `db_ejemplo`.`pais` \n" +
"        ON (`nacionalidades`.`cod_pais` = `pais`.`cod_pais`);");
        ResultSet rs=sql.executeQuery();
        while(rs.next()){
            lista.add(new Nacionalidades(rs.getInt("cod_nac"), rs.getString("desc_nac")));
            }
    } catch (SQLException e) {
            System.out.println("ERROR listaNac= "+e);
    }finally{
            con.Desconectar();
        }
    return lista;
    }
    
    //listar los tipos de obra
    public List lista_TipoDeObra(){
    List<TipoDeObra> lista = new ArrayList<>();
    try {
        con.conectar();
        PreparedStatement sql=con.Estado().prepareStatement("SELECT cod_tipo, nom_tipo FROM TipoDeObra ORDER BY nom_tipo");
        ResultSet rs=sql.executeQuery();
        while(rs.next()){
            lista.add(new TipoDeObra(rs.getInt("cod_tipo"), rs.getString("nom_tipo")));
            }
    } catch (SQLException e) {
            System.out.println("ERROR listaTipoObra= "+e);
    }finally{
            con.Desconectar();
        }
    return lista;
    }
    
    //insertar autores
    public void insrtarAutores(String nom, String pseu, String fnac, String fdef, String codN){
    try {
        con.conectar();
        PreparedStatement sql=con.Estado().prepareStatement("INSERT INTO autores(nom_autor, pseu_autor, fec_naci, fec_def, cod_nac) "
        + " VALUES ('"+nom+"','"+pseu+"','"+fnac+"','"+fdef+"','"+codN+"')");
        } catch (SQLException e) {
            System.out.println("ERROR addAutores= "+e);
    }finally{
            con.Desconectar();
        }
    }
    
    //busca autores
    public List buscarAutor(String buscar){//String cod para buscar galerias por codigo
    List<Autores> lista = new ArrayList<>();
    try {
        con.conectar();
        PreparedStatement sql=con.Estado().prepareStatement("SELECT cod_autor, nom_autor, pseu_autor, desc_nac, nom_pais FROM pais "
        + " INNER JOIN nacionalidades ON (pais.cod_pais=nacionalidades.cod_pais) "
        + " INNER JOIN autores ON (nacionalidades.cod_nac=autores.cod_nac)  "
        + " WHERE nom_autor LIKE '%"+buscar+"%' OR pseu_autor LIKE '%"+buscar+"%'");
        ResultSet rs=sql.executeQuery();
        while(rs.next()){
            lista.add(new Autores(rs.getInt("cod_autor"), 
                    rs.getString("nom_autor"), 
                    rs.getString("pseu_autor"), 
                    rs.getString("desc_nac"), 
                    rs.getString("nom_pais")));
            }
    } catch (SQLException e) {
            System.out.println("ERROR buscarNac= "+e);
    }finally{
            con.Desconectar();
        }
    return lista;
    }
    
    //editar Autor
     public void editarAutor(String codA, String nom, String pseu, String fnac, String fdef, String codN){
    try {
        con.conectar();
        PreparedStatement sql=con.Estado().prepareStatement("UPDATE autores SET nom_autor='"+nom+"', pseu_autor='"+pseu+"', fec_naci='"+fnac+"', "
        + "fec_def='"+fdef+"', cod_nac='"+codN+"' "
        + " WHERE cod_autor='"+codA+"'");
        sql.execute();
    } catch (SQLException e) {
            System.out.println("ERROR EditarAutor= "+e);
    }finally{
            con.Desconectar();
        }
    }
     
    //eliminar autor
    public void eliminarAutor(String cod){
    try {
        con.conectar();
        PreparedStatement sql=con.Estado().prepareStatement("DELETE FROM autores WHERE cod_autor='"+cod+"'");
        sql.execute();
        } catch (SQLException e) {
            System.out.println("ERROR eliminarNac= "+e);
    }finally{
            con.Desconectar();
        }
    }
}
