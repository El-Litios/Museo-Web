
package CONTROLADOR;


import MODELO.Eventos;
import MODELO.GaleriaObra;
import MODELO.Galerias;
import MODELO.TipoEvento;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Control_Eventos {
    Control_conexion con=new Control_conexion();
    
    
    
    //listar Eventos EN GALERIAS.
    public List lista_EveEnGal(String galeria){
    List<Eventos> lista = new ArrayList<>();
    try {
        con.conectar();
        PreparedStatement sql=con.Estado().prepareStatement("SELECT cod_ev, nom_ev, fec_ini, fec_fin, nom_tev FROM evento " +
        "INNER JOIN tipoevento " +
        "ON (evento.cod_tev = tipoevento.cod_tev) " +
        "WHERE cod_gal='"+galeria+"'");
        ResultSet rs=sql.executeQuery();
        while(rs.next()){
            lista.add(new Eventos(rs.getInt("cod_ev"), rs.getString("nom_ev"), rs.getDate("fec_ini"), rs.getDate("fec_fin"), rs.getString("nom_tev")));
            }
    } catch (SQLException e) {
            System.out.println("ERROR listaEventos= "+e);
    }finally{
            con.Desconectar();
        }
    return lista;
    }
    
    
     //listar Eventos
    public List lista_Eventos(){
    List<Eventos> lista = new ArrayList<>();
    try {
        con.conectar();
        PreparedStatement sql=con.Estado().prepareStatement("SELECT cod_ev, nom_ev, fec_ini, fec_fin, nom_gal, nom_tev FROM evento " +
        "INNER JOIN tipoevento " +
        "ON (evento.cod_tev = tipoevento.cod_tev) " +
        "INNER JOIN galerias " +
        "ON (evento.cod_gal = galerias.cod_gal)");
        ResultSet rs=sql.executeQuery();
        while(rs.next()){
            lista.add(new Eventos(rs.getInt("cod_ev"), 
                    rs.getString("nom_ev"), 
                    rs.getDate("fec_ini"), 
                    rs.getDate("fec_fin"), 
                    rs.getString("nom_gal"), 
                    rs.getString("nom_tev")));
            }
    } catch (SQLException e) {
            System.out.println("ERROR listaEventos= "+e);
    }finally{
            con.Desconectar();
        }
    return lista;
    }
    
    //listar galerias
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
    
    //listar tipos de evento
    public List lista_tipEv(){
    List<TipoEvento> lista = new ArrayList<>();
    try {
        con.conectar();
        PreparedStatement sql=con.Estado().prepareStatement("SELECT * FROM tipoevento");
        ResultSet rs=sql.executeQuery();
        while(rs.next()){
            lista.add(new TipoEvento(rs.getInt("cod_tev"), rs.getString("nom_tev")));
            }
    } catch (SQLException e) {
            System.out.println("ERROR ListTipoEv= "+e);
    }finally{
            con.Desconectar();
        }
    return lista;
    }
    
    //insertar Evento
    public void insrtarEvento(String nom, Date fec_ini, Date fec_fin, String codgal, String codtev){ 
    try {
        con.conectar();
        PreparedStatement sql=con.Estado().prepareStatement("INSERT INTO evento(nom_ev, fec_ini, fec_fin, cod_gal, cod_tev) "
                + " VALUES ('"+nom+"','"+fec_ini+"','"+fec_fin+"','"+codgal+"','"+codtev+"')");
        sql.execute();
        } catch (SQLException e) {
            System.out.println("ERROR addEvento= "+e);
    }finally{
            con.Desconectar();
        }    
    }
    
    //buscar obras de arte
    public List buscarEventos(String buscar){//String cod para buscar galerias por codigo
    List<Eventos> lista = new ArrayList<>();
    try {
        con.conectar();
        PreparedStatement sql=con.Estado().prepareStatement("SELECT cod_ev, nom_ev, fec_ini, fec_fin, nom_gal, nom_tev FROM evento " +
        "INNER JOIN tipoevento " +
        "ON (evento.cod_tev = tipoevento.cod_tev) " +
        "INNER JOIN galerias " +
        "ON (evento.cod_gal = galerias.cod_gal) " +
        "WHERE nom_ev LIKE '%"+buscar+"%'");
        ResultSet rs=sql.executeQuery();
        while(rs.next()){
           lista.add(new Eventos(rs.getInt("cod_ev"), 
                    rs.getString("nom_ev"), 
                    rs.getDate("fec_ini"), 
                    rs.getDate("fec_fin"), 
                    rs.getString("nom_gal"), 
                    rs.getString("nom_tev")));
            }
    } catch (SQLException e) {
            System.out.println("ERROR buscarEvento= "+e);
    }finally{
            con.Desconectar();
        }
    return lista;
    }
    
    //modificar Eventos
    public void editarEventos(String codE, String nom, Date ini, Date fin, String codgal, String codtev){
    try {
        con.conectar();
        PreparedStatement sql=con.Estado().prepareStatement("UPDATE  evento SET nom_ev='"+nom+"', "
                + "fec_ini='"+ini+"', "
                + "fec_fin='"+fin+"', "
                + "cod_gal='"+codgal+"', "
                + "cod_tev='"+codtev+"' "
                + "WHERE cod_ev='"+codE+"'");
        sql.execute();
        } catch (SQLException e) {
            System.out.println("ERROR EditarEvento= "+e);
    }finally{
            con.Desconectar();
        }
    }
    
     //eliminar Eventos
    public void eliminarEventos(String cod){
    try {
        con.conectar();
        PreparedStatement sql=con.Estado().prepareStatement("DELETE FROM evento WHERE cod_ev='"+cod+"'");
        sql.execute();
        } catch (SQLException e) {
            System.out.println("ERROR eliminarEvento= "+e);
    }finally{
            con.Desconectar();
        }   
    }
    
    
}
