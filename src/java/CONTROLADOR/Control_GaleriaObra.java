
package CONTROLADOR;


import MODELO.GaleriaObra;
import MODELO.Galerias;
import MODELO.ObraDeArte;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Control_GaleriaObra {
    Control_conexion con=new Control_conexion();
    
    //listar obras de artes En Galerias
    public List lista_ObrasEnGal(String galeria){
        List<GaleriaObra> lista=new ArrayList();
        try {
            con.conectar();
            PreparedStatement sql=con.Estado().prepareStatement("SELECT " +
            "cod_galob,tit_obra,fcrea_obra,fing_obra,nom_autor,nom_tipo FROM galeria_obra " +
            "INNER JOIN obradearte " +
            "ON (galeria_obra.cod_ob = obradearte.cod_obra) " +
            "INNER JOIN autores " +
            "ON (obradearte.cod_autor = autores.cod_autor) " +
            "INNER JOIN tipodeobra " +
            "ON (obradearte.cod_tipo = tipodeobra.cod_tipo) " +
            "WHERE cod_gal='"+galeria+"' ");
            ResultSet rs=sql.executeQuery();
            while (rs.next()) {                
                lista.add(new GaleriaObra(rs.getInt("cod_galob"), 
                        rs.getString("tit_obra"), 
                        rs.getDate("fcrea_obra"), 
                        rs.getDate("fing_obra"), 
                        rs.getString("nom_autor"), 
                        rs.getString("nom_tipo")));
            }
        } catch (SQLException e) {
            System.out.println("Error lista de Obras dentro de Galerias= "+"\n"+e);
        }finally{
        con.Desconectar();
        }
    return lista;
    }
    
    //listar galeriasobras
    public List Lista_GalObras(){
    List<GaleriaObra> lista = new ArrayList<>();
    try {
        con.conectar();
        PreparedStatement sql=con.Estado().prepareStatement("SELECT cod_galob, nom_gal, tit_obra FROM galeria_obra " +
        "INNER JOIN galerias ON (galeria_obra.cod_gal = galerias.cod_gal) " +
        "INNER JOIN db_ejemplo.obradearte " +
        "ON (galeria_obra.cod_ob = obradearte.cod_obra)");
        ResultSet rs=sql.executeQuery();
        while(rs.next()){
            lista.add(new GaleriaObra(rs.getInt("cod_galob"), rs.getString("nom_gal"), rs.getString("tit_obra")));
            }
    } catch (SQLException e) {
            System.out.println("ERROR listaGalObra= "+e);
    }finally{
            con.Desconectar();
        }
    return lista;
    }
    
    public List listaObras(){
    List<ObraDeArte> lista = new ArrayList<>();
    try {
        con.conectar();
        PreparedStatement sql=con.Estado().prepareStatement("SELECT cod_obra, tit_obra FROM ObraDeArte");
        ResultSet rs=sql.executeQuery();
        while(rs.next()){
            lista.add(new ObraDeArte(rs.getInt("cod_obra"), rs.getString("tit_obra")));
            }
    } catch (SQLException e) {
            System.out.println("ERROR LISTAobra= "+e);
    }finally{
            con.Desconectar();
        }
    return lista;
    }
    
    public List listagal(){
    List<Galerias> lista = new ArrayList<>();
    try {
        con.conectar();
        PreparedStatement sql=con.Estado().prepareStatement("SELECT cod_gal, nom_gal FROM galerias");
        ResultSet rs=sql.executeQuery();
        while(rs.next()){
            lista.add(new Galerias(rs.getInt("cod_gal"), rs.getString("nom_gal")));
            }
    } catch (SQLException e) {
            System.out.println("ERROR LISTAobra= "+e);
    }finally{
            con.Desconectar();
        }
    return lista;
    }
    
     //insertar GaleriasObras
    public void insrtarGaleriaObra(String obra, String gal){ 
    try {
        con.conectar();
        PreparedStatement sql=con.Estado().prepareStatement("INSERT INTO galeria_obra(cod_gal, cod_ob) "
                + " VALUES ('"+gal+"','"+obra+"')");
        sql.execute();
        } catch (SQLException e) {
            System.out.println("ERROR add GalObra= "+e);
    }finally{
            con.Desconectar();
        }    
    }
    
    public List BuscarGalObras(String buscar){
    List<GaleriaObra> lista = new ArrayList<>();
    try {
        con.conectar();
        PreparedStatement sql=con.Estado().prepareStatement("SELECT cod_galob, nom_gal, tit_obra  FROM galeria_obra " +
        "INNER JOIN galerias ON (galeria_obra.cod_gal = galerias.cod_gal) " +
        "INNER JOIN db_ejemplo.obradearte " +
        "ON (galeria_obra.cod_ob = obradearte.cod_obra)"
        + "WHERE tit_obra LIKE '%"+buscar+"%' OR nom_gal LIKE '%"+buscar+"%'");
        ResultSet rs=sql.executeQuery();
        while(rs.next()){
            lista.add(new GaleriaObra(rs.getInt("cod_galob"), rs.getString("nom_gal"), rs.getString("tit_obra")));
            }
    } catch (SQLException e) {
            System.out.println("ERROR listaGalObra= "+e);
    }finally{
            con.Desconectar();
        }
    return lista;
    }
    
    //modificar GaleriasObras
    public void editarGalObras(String cod, String codgal, String codO ){
    try {
        con.conectar();
        PreparedStatement sql=con.Estado().prepareStatement("UPDATE  galeria_obra SET cod_gal='"+codgal+"', "
                + "cod_ob='"+codO+"' "
                + "WHERE cod_galob='"+cod+"'");
        sql.execute();
        } catch (SQLException e) {
            System.out.println("ERROR EditarGalObra= "+e);
    }finally{
            con.Desconectar();
        }
    }
    
    //eliminar GalObras
    public void eliminarGalObras(String cod){
    try {
        con.conectar();
        PreparedStatement sql=con.Estado().prepareStatement("DELETE FROM galeria_obra WHERE cod_galob='"+cod+"'");
        sql.execute();
        } catch (SQLException e) {
            System.out.println("ERROR eliminarGalObra= "+e);
    }finally{
            con.Desconectar();
        }
    
    }
    
}
