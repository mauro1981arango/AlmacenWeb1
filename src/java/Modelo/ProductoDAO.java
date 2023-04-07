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
public class ProductoDAO {

    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int r;

    public Producto BuscarProducto(String codigo) {
        Producto producto = new Producto();
        String sql = "SELECT * FROM `producto` WHERE Codigo = ?";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, codigo);
            rs = ps.executeQuery();
            while (rs.next()) {
                producto.setIdProducto(rs.getInt("IdProducto"));
                producto.setCodigo(rs.getString("Codigo"));
                producto.setDescripcion(rs.getString("Descripcion"));
                producto.setPrecio(Double.parseDouble(rs.getString("Precio")));
                producto.setStock(Integer.parseInt(rs.getString("Stock")));
                producto.setEstado(rs.getString("Estado"));
            }
        } catch (SQLException e) {
            System.out.println("El producto no existte" + e);
        }
        return producto;
    }

    public List Listar() {
        String sql = "SELECT * FROM `producto`";
        List<Producto> lista = new ArrayList<>();
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Producto pro = new Producto();
                pro.setIdProducto(rs.getInt(1));
                pro.setCodigo(rs.getString(2));
                pro.setDescripcion(rs.getString(3));
                pro.setPrecio(rs.getDouble(4));
                pro.setStock(rs.getInt(5));
                pro.setEstado(rs.getString(6));
                lista.add(pro);
            }
        } catch (SQLException e) {
            System.out.println("No hay productos para mostrar" + e);
        }
        return lista;
    }

    public boolean Agregar(Producto pro) {
        String sql = "INSERT INTO producto (Codigo, Descripcion, Precio, Stock, Estado) VALUES (?,?,?,?,?)";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, pro.getCodigo());
            ps.setString(2, pro.getDescripcion());
            ps.setDouble(3, pro.getPrecio());
            ps.setInt(4, pro.getStock());
            ps.setString(5, pro.getEstado());
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.out.println("Los datos no pudieron ser guardados" + e);
        }
        return false;
    }

    public Producto ListarPorId(int id) {
        Producto prod = new Producto();
        String sql = "SELECT * FROM producto WHERE IdProducto=" + id;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                prod.setIdProducto(id);
                prod.setCodigo(rs.getString(2));
                prod.setDescripcion(rs.getString(3));
                prod.setPrecio(rs.getDouble(4));
                prod.setStock(rs.getInt(5));
                prod.setEstado(rs.getString(6));
            }
        } catch (SQLException e) {
            System.err.println("Mensaje" + e);
        }
        return prod;
    }

    public boolean Actualizar(Producto producto) {
        String sql = "UPDATE producto SET Codigo=?,Descripcion=?,Precio=?,Stock=?,Estado=? WHERE IdProducto=?";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, producto.getCodigo());
            ps.setString(2, producto.getDescripcion());
            ps.setDouble(3, producto.getPrecio());
            ps.setInt(4, producto.getStock());
            ps.setString(5, producto.getEstado());
            ps.setInt(6, producto.getIdProducto());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Los datos no pudieron ser actualizados" + e);
        }
        return false;
    }

    public void Eliminar(int id) {
        String sql = "DELETE FROM producto WHERE IdProducto=?" + id;
        con = cn.Conexion();
        try {
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("No se pudo eliminar el producto" + e);
        }
    }

    public int ActualizarStock(int IdProducto, int Stock) {
        String sql = "UPDATE producto SET Stock=? WHERE IdProducto = ?";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, Stock);
            ps.setInt(2, IdProducto);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.toString();
        }
        return r;
    }
    
    public Producto Buscar(int IdProducto) {
        Producto producto = new Producto();
        String sql = "SELECT * FROM `producto` WHERE IdProducto = ?";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, IdProducto);
            rs = ps.executeQuery();
            while (rs.next()) {
                producto.setIdProducto(rs.getInt("IdProducto"));
                producto.setCodigo(rs.getString("Codigo"));
                producto.setDescripcion(rs.getString("Descripcion"));
                producto.setPrecio(Double.parseDouble(rs.getString("Precio")));
                producto.setStock(Integer.parseInt(rs.getString("Stock")));
                producto.setEstado(rs.getString("Estado"));
            }
        } catch (SQLException e) {
            System.out.println("El producto no existte" + e);
        }
        return producto;
    }
}
