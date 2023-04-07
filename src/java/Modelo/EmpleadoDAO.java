package Modelo;

import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Diego Arango
 */
public class EmpleadoDAO {

   Conexion cn = new Conexion();
   Connection con;
   PreparedStatement ps;
   ResultSet rs;
   int r;

   public Empleado validar(String Usuario, String Cedula) {
      Empleado empl = new Empleado();
      String sql = "SELECT `IdEmpleado`, `Cedula`, `Nombres`, `Apellidos`, `Telefono`, `Correo`, `Estado`, `Usuario` FROM `empleado` WHERE Usuario=? and Cedula=?";
      try {
         con = cn.Conexion();
         ps = con.prepareStatement(sql);
         ps.setString(1, Usuario);
         ps.setString(2, Cedula);
         rs = ps.executeQuery();
         while (rs.next()) {
            empl.setIdEmpleado(rs.getInt("IdEmpleado"));
            empl.setCedula(rs.getString("Cedula"));
            empl.setNombres(rs.getString("Nombres"));
            empl.setApellidos(rs.getString("Apellidos"));
            empl.setTelefono(rs.getString("Telefono"));
            empl.setCorreo(rs.getString("Correo"));
            empl.setEstado(rs.getString("Estado"));
            empl.setUsuario(rs.getString("Usuario"));
         }
      } catch (SQLException e) {
         try {
            System.err.println("No se encontró ningún empleado" + e);
            con.close();
         } catch (SQLException ex) {
            Logger.getLogger(EmpleadoDAO.class.getName()).log(Level.SEVERE, null, ex);
         }
      }
      return empl;
   }

   public List listar() {
      String sql = "SELECT * FROM `empleado`";
      List<Empleado> lista = new ArrayList<>();
      try {
         con = cn.Conexion();
         ps = con.prepareStatement(sql);
         rs = ps.executeQuery();
         while (rs.next()) {
            Empleado emp = new Empleado();
            emp.setIdEmpleado(rs.getInt(1));
            emp.setCedula(rs.getString(2));
            emp.setNombres(rs.getString(3));
            emp.setApellidos(rs.getString(4));
            emp.setTelefono(rs.getString(5));
            emp.setCorreo(rs.getString(6));
            emp.setEstado(rs.getString(7));
            emp.setUsuario(rs.getString(8));
            lista.add(emp);
         }
      } catch (SQLException e) {
         try {
             System.out.println("No hay empleados para mostrar" + e);
            con.close();
         } catch (SQLException ex) {
            Logger.getLogger(EmpleadoDAO.class.getName()).log(Level.SEVERE, null, ex);
         }
      }
      return lista;
   }

   public int agregar(Empleado emp) {
      String sql = "INSERT INTO empleado (Cedula, Nombres, Apellidos, Telefono, Correo, Estado, Usuario) VALUES (?,?,?,?,?,?,?)";
      try {
         con = cn.Conexion();
         ps = con.prepareStatement(sql);
         ps.setString(1, emp.getCedula());
         ps.setString(2, emp.getNombres());
         ps.setString(3, emp.getApellidos());
         ps.setString(4, emp.getTelefono());
         ps.setString(5, emp.getCorreo());
         ps.setString(6, emp.getEstado());
         ps.setString(7, emp.getUsuario());
         ps.executeUpdate();

      } catch (SQLException e) {
         try {
            System.out.println("Los datos no pudieron ser guardados" + e);
            con.close();
         } catch (SQLException ex) {
            Logger.getLogger(EmpleadoDAO.class.getName()).log(Level.SEVERE, null, ex);
         }
      }
      return r;
   }

   public Empleado listarId(int id) {
      Empleado empl = new Empleado();
      String sql = "SELECT * FROM empleado WHERE IdEmpleado=" + id;
      try {
         con = cn.Conexion();
         ps = con.prepareStatement(sql);
         rs = ps.executeQuery();
         while (rs.next()) {
            empl.setIdEmpleado(rs.getInt(1));
            empl.setCedula(rs.getString(2));
            empl.setNombres(rs.getString(3));
            empl.setApellidos(rs.getString(4));
            empl.setTelefono(rs.getString(5));
            empl.setCorreo(rs.getString(6));
            empl.setEstado(rs.getString(7));
            empl.setUsuario(rs.getString(8));        
         }
      } catch (SQLException e) {
         try {
            System.err.println("Mensaje" + e);
            con.close();
         } catch (SQLException ex) {
            Logger.getLogger(EmpleadoDAO.class.getName()).log(Level.SEVERE, null, ex);
         }
      }
      return empl;
   }

   public int actualizar(Empleado emp) {
      String sql = "UPDATE empleado SET Cedula=?,Nombres=?,Apellidos=?,Telefono=?,Correo=?,Estado=?,Usuario=? WHERE IdEmpleado=?";
      try {
         con = cn.Conexion();
         ps = con.prepareStatement(sql);
         ps.setString(1, emp.getCedula());
         ps.setString(2, emp.getNombres());
         ps.setString(3, emp.getApellidos());
         ps.setString(4, emp.getTelefono());
         ps.setString(5, emp.getCorreo());
         ps.setString(6, emp.getEstado());
         ps.setString(7, emp.getUsuario());
         ps.setInt(8, emp.getIdEmpleado());
         ps.executeUpdate();

      } catch (SQLException e) {
         try {
            System.out.println("Los datos no pudieron ser actualizados" + e);
            con.close();
         } catch (SQLException ex) {
            Logger.getLogger(EmpleadoDAO.class.getName()).log(Level.SEVERE, null, ex);
         }
      }
      return r;
   }

   public void eliminar(Empleado emp) {
      String sql = "DELETE FROM empleado WHERE IdEmpleado=?";
      try {
         con = cn.Conexion();
         ps = con.prepareStatement(sql);
         ps.setInt(1, emp.getIdEmpleado());
         ps.executeUpdate();
      } catch (SQLException e) {
         try {
            System.out.println("No se pudo eliminar el empleado" + e);
            con.close();
         } catch (SQLException ex) {
            Logger.getLogger(EmpleadoDAO.class.getName()).log(Level.SEVERE, null, ex);
         }
      }
   }
}
