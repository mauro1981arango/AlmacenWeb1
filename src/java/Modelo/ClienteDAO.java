package Modelo;

import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Diego Arango
 */
public class ClienteDAO {

    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int r;

    public Cliente BuscarCliente(int idcliente) {
        Cliente cliente = new Cliente();
        String sql = "SELECT * FROM `cliente` WHERE IdCliente = ?";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, idcliente);
            rs = ps.executeQuery();
            while (rs.next()) {
                cliente.setIdCliente(rs.getInt("IdCliente"));
                cliente.setCedula(rs.getString("Cedula"));
                cliente.setNombres(rs.getString("Nombres"));
                cliente.setApellidos(rs.getString("Apellidos"));
                cliente.setDireccion(rs.getString("Direccion"));
                cliente.setTelefono(rs.getString("Telefono"));
                cliente.setEstado(rs.getString("Estado"));
            }
        } catch (SQLException e) {
            System.out.println("El cliente no existte" + e);
        }
        return cliente;
    }

    public List listar() {
        String sql = "SELECT * FROM `cliente`";
        List<Cliente> lista = new ArrayList<>();
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Cliente cli = new Cliente();
                cli.setIdCliente(rs.getInt(1));
                cli.setCedula(rs.getString(2));
                cli.setNombres(rs.getString(3));
                cli.setApellidos(rs.getString(4));
                cli.setDireccion(rs.getString(5));
                cli.setTelefono(rs.getString(6));
                cli.setEstado(rs.getString(7));
                lista.add(cli);
            }
        } catch (SQLException e) {
            System.out.println("No hay clientes para mostrar" + e);
        }
        return lista;
    }

    public int Agregar(Cliente cli) {
        String sql = "INSERT INTO cliente (Cedula, Nombres, Apellidos, Direccion, Telefono, Estado) VALUES (?,?,?,?,?,?)";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, cli.getCedula());
            ps.setString(2, cli.getNombres());
            ps.setString(3, cli.getApellidos());
            ps.setString(4, cli.getDireccion());
            ps.setString(5, cli.getTelefono());
            ps.setString(6, cli.getEstado());
            ps.executeUpdate();
            System.out.println("DatosGuardados");
        } catch (SQLException e) {
            System.out.println("Los datos no pudieron ser guardados" + e);
        }
        return r;
    }

    public Cliente listarPorId(int id) {
        Cliente cliente = new Cliente();
        String sql = "SELECT * FROM cliente WHERE IdCliente=" + id;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {

                cliente.setCedula(rs.getString(2));
                cliente.setNombres(rs.getString(3));
                cliente.setApellidos(rs.getString(4));
                cliente.setDireccion(rs.getString(5));
                cliente.setTelefono(rs.getString(6));
                cliente.setEstado(rs.getString(7));
            }
        } catch (SQLException e) {
            System.err.println("Mensaje" + e);
        }
        return cliente;
    }

    public int Actualizar(Cliente cliente) {
        String sql = "UPDATE cliente SET Cedula=?,Nombres=?,Apellidos=?,Direccion=?,Telefono=?,Estado=? WHERE IdCliente=?";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, cliente.getCedula());
            ps.setString(2, cliente.getNombres());
            ps.setString(3, cliente.getApellidos());
            ps.setString(4, cliente.getDireccion());
            ps.setString(5, cliente.getTelefono());
            ps.setString(6, cliente.getEstado());
            ps.setInt(7, cliente.getIdCliente());
            ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Los datos no pudieron ser actualizados" + e);
        }
        return r;
    }

    public boolean Eliminar(int id) {
        String sql = "DELETE FROM cliente WHERE IdCliente=?" + id;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("No se pudo eliminar el cliente" + e);
        }
        return false;
    }
}
