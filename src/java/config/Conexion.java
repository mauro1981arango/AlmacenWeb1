
package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Diego Arango
 */
public class Conexion {
   Connection con;
    String url = ("jdbc:mysql://localhost:3306/ventas_web?serverTimezone=UTC");
    String usser = "root";
    String pass = "";
    public Connection Conexion(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, usser, pass);
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("No se pudo conectar" + e);
        }
        return con;
    }
}
