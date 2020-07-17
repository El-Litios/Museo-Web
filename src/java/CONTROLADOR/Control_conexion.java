
package CONTROLADOR;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Control_conexion {
    
   
    
    Connection conexion;
    public Connection conectar(){
    try {
        //llamar al driver
        Class.forName("com.mysql.jdbc.Driver");
        conexion=DriverManager.getConnection("jdbc:mysql://127.0.0.1/db_ejemplo","root","");
    } catch (SQLException ex) { 
        System.out.println("ERROR: "+ex);
    }   catch (ClassNotFoundException ex) {
            System.out.println("ERROR CLASE: "+ex);
        }
        return conexion;
    }
    
    public void Desconectar(){
    try {
        conexion.close();
    } catch (SQLException ex) {
        System.out.println("ERROR: "+ex);
    }
        
   }
    
    
   public Connection Estado(){
   return conexion;
   }
    
}
