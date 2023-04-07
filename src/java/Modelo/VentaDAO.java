package Modelo;

import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

/**
 *
 * @author godie
 */
public class VentaDAO {

    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int r = 0;

    public String ObtenerNumeroDeFactura() {
        String numerodefactura = "";
        String consulta = "SELECT MAX(NumeroFactura) FROM ventas";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(consulta);
            rs = ps.executeQuery();
            while (rs.next()) {
                numerodefactura = rs.getString(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(VentaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return numerodefactura;
    }

    public String ObtenerMaximoIdVentas() {
        String IdVenta = "";
        String consulta = "SELECT MAX(IdVenta) FROM ventas";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(consulta);
            rs = ps.executeQuery();
            while (rs.next()) {
                IdVenta = rs.getString(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(VentaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return IdVenta;
    }

    public int RegistrarVenta(Venta venta) {
        String sentencia = "INSERT INTO ventas(NumeroFactura, IdCliente, IdEmpleado, Total, Estado) VALUES(?,?,?,?,?)";     
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sentencia);
            ps.setString(1, venta.getNumeroFactura());
            ps.setInt(2, venta.getIdCliente());
            ps.setInt(3, venta.getIdEmpleado());
            ps.setDouble(4, venta.getTotal());
            ps.setString(5, venta.getEstado());
            ps.executeUpdate();
            //ps.setString(6, venta.getFecha());
           

        } catch (SQLException ex) {
            Logger.getLogger(VentaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return r;
    }
    public int GuardarDetalleVenta(Venta venta){
          String sentencia = "INSERT INTO detalle_venta (IdVenta, IdProducto, Cantidad, PrecioVenta) VALUES(?,?,?,?)";
        
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sentencia);
            ps.setInt(1,venta.getIdVenta());
            ps.setInt(2, venta.getIdProducto());
            ps.setInt(3, venta.getCantidad());
            ps.setDouble(4, venta.getPrecioVenta());
            ps.executeUpdate();
           
        } catch (SQLException ex) {
            Logger.getLogger(VentaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return r;
    }
   
}
