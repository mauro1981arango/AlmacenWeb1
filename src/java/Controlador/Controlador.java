package Controlador;

import Modelo.Cliente;
import Modelo.ClienteDAO;
import Modelo.Empleado;
import Modelo.EmpleadoDAO;
import Modelo.Producto;
import Modelo.ProductoDAO;
import Modelo.Venta;
import Modelo.VentaDAO;
import config.GenerarSerie;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author Diego Arango
 */
public class Controlador extends HttpServlet {

    int idcliente;
    int idproducto;
    int idEmpleado;
    Empleado empleado = new Empleado();
    EmpleadoDAO empleadodao = new EmpleadoDAO();
    Producto producto = new Producto();
    ProductoDAO proDAO = new ProductoDAO();
    Cliente cliente = new Cliente();
    ClienteDAO cliDao = new ClienteDAO();
    VentaDAO ventaDAO = new VentaDAO();
    Venta v = new Venta();
    List<Venta> lista = new ArrayList<>();
    int numfac = 0;
    int Item;
    int cod;
    String descripcion;
    double precio;
    int cantidad;
    double subtotal;
    double totalapagar;
    String numeroSerie;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String menu = request.getParameter("menu");
        String accion = request.getParameter("accion");
        RequestDispatcher dispatcher = null;
        if ("Principal".equals(menu)) {
            request.getRequestDispatcher("Principal.jsp").forward(request, response);
        }
        if ("Producto".equals(menu)) {
            if (accion == null || accion.isEmpty()) {
                request.getRequestDispatcher("Producto.jsp");
                List<Producto> listaproducto = proDAO.Listar();
                request.setAttribute("productos", listaproducto);
            } else if (accion.equals("Cargar")) {
                idproducto = Integer.parseInt(request.getParameter("id"));
                producto = proDAO.ListarPorId(idproducto);
                request.setAttribute("productoSelecionado", producto);
                dispatcher = request.getRequestDispatcher("Controlador?menu=Producto&accion=Listar");
                List<Producto> listaproducto = proDAO.Listar();
                request.setAttribute("productos", listaproducto);
            } else if (accion.equals("Agregar")) {
                String codigo = request.getParameter("txtCodigo");
                String descrirpcion = request.getParameter("txtDescripcion");
                String precio = request.getParameter("txtPrecio");
                String stock = request.getParameter("txtStock");
                String estado = request.getParameter("txtEstado");
                producto.setCodigo(codigo);
                producto.setDescripcion(descrirpcion);
                producto.setPrecio(Double.parseDouble(precio));
                producto.setStock(Integer.parseInt(stock));
                producto.setEstado(estado);
                proDAO.Agregar(producto);
                dispatcher = request.getRequestDispatcher("Controlador?menu=Producto&accion=Listar");
                List<Producto> listaproducto = proDAO.Listar();
                request.setAttribute("productos", listaproducto);
            } else if (accion.equals("Actualizar")) {
                String codigoUpdate = request.getParameter("txtCodigo");
                String descrirpcionUpdate = request.getParameter("txtDescripcion");
                String precioUpdate = request.getParameter("txtPrecio");
                String stockUpdate = request.getParameter("txtStock");
                String estadoUpdate = request.getParameter("txtEstado");
                producto.setCodigo(codigoUpdate);
                producto.setDescripcion(descrirpcionUpdate);
                producto.setPrecio(Double.parseDouble(precioUpdate));
                producto.setStock(Integer.parseInt(stockUpdate));
                producto.setEstado(estadoUpdate);
                producto.setIdProducto(idproducto);
                proDAO.Actualizar(producto);
                dispatcher = request.getRequestDispatcher("Controlador?menu=Producto&accion=Listar");
                List<Producto> listaproducto = proDAO.Listar();
                request.setAttribute("productos", listaproducto);
            } else if (accion.equals("Eliminar")) {
                idproducto = Integer.parseInt(request.getParameter("id"));
                proDAO.Eliminar(idproducto);
                dispatcher = request.getRequestDispatcher("Controlador?menu=Producto&accion=Listar");
                List<Producto> listaproducto = proDAO.Listar();
                request.setAttribute("productos", listaproducto);
            }
            request.getRequestDispatcher("Producto.jsp").forward(request, response);
        }

        if ("Empleado".equals(menu)) {
            request.getRequestDispatcher("Empleado.jsp").forward(request, response);
        }

        if (menu.equals("Cliente")) {
            if (accion == null || accion.isEmpty()) {
                request.getRequestDispatcher("Cliente.jsp");
                List<Cliente> clientes = cliDao.listar();
                request.setAttribute("listaCliente", clientes);
            } else if (accion.equals("Agregar")) {
                Cliente cliente = new Cliente();
                String cedula = request.getParameter("txtCedula");
                String nombres = request.getParameter("txtNombres");
                String apellidos = request.getParameter("txtApellidos");
                String direccion = request.getParameter("txtDireccion");
                String telefono = request.getParameter("txtTelefono");
                String estado = request.getParameter("txtEstado");
                cliente.setCedula(cedula);
                cliente.setNombres(nombres);
                cliente.setApellidos(apellidos);
                cliente.setDireccion(direccion);
                cliente.setTelefono(telefono);
                cliente.setEstado(estado);
                cliDao.Agregar(cliente);
                request.getRequestDispatcher("Controlador?menu=Cliente&accion=Listar");
                List<Cliente> clientes = cliDao.listar();
                request.setAttribute("listaCliente", clientes);
            } else if (accion.equals("Cargar")) {
                idcliente = Integer.parseInt(request.getParameter("id"));
                Cliente cliente = cliDao.listarPorId(idcliente);
                request.setAttribute("clienteSelecionado", cliente);
                request.getRequestDispatcher("Controlador?menu=Cliente&accion=Listar");
                List<Cliente> clientes = cliDao.listar();
                request.setAttribute("listaCliente", clientes);
            } else if (accion.equals("Actualizar")) {
                Cliente cliente = new Cliente();
                String cedula = request.getParameter("txtCedula");
                String nombres = request.getParameter("txtNombres");
                String apellidos = request.getParameter("txtApellidos");
                String direccion = request.getParameter("txtDireccion");
                String telefono = request.getParameter("txtTelefono");
                String estado = request.getParameter("txtEstado");
                cliente.setCedula(cedula);
                cliente.setNombres(nombres);
                cliente.setApellidos(apellidos);
                cliente.setDireccion(direccion);
                cliente.setTelefono(telefono);
                cliente.setEstado(estado);
                cliente.setIdCliente(idcliente);
                cliDao.Actualizar(cliente);
                request.getRequestDispatcher("Controlador?menu=Cliente&accion=Listar");
                List<Cliente> clientes = cliDao.listar();
                request.setAttribute("listaCliente", clientes);
            } else if (accion.equals("Eliminar")) {
                idcliente = Integer.parseInt(request.getParameter("id"));
                cliDao.Eliminar(idcliente);
                request.getRequestDispatcher("Controlador?menu=Cliente&accion=Listar");
                List<Cliente> clientes = cliDao.listar();
                request.setAttribute("listaCliente", clientes);
            }
            request.getRequestDispatcher("Cliente.jsp").forward(request, response);
        }

        if (menu.equals("RegistrarVenta")) {
            switch (accion) {
                case "BuscarCliente":
                    idcliente = Integer.parseInt(request.getParameter("txtCedulaCliente"));
                    String nombres = request.getParameter("txtNombresCliente");
                    cliente.setIdCliente(idcliente);
                    cliente.setNombres(nombres);
                    Cliente client = cliDao.BuscarCliente(idcliente);
                    request.setAttribute("Clientes", client);
                    break;
                
                case "BuscarProducto":
                    int id = Integer.parseInt(request.getParameter("txtCodigo"));
                    producto = proDAO.ListarPorId(id);
                    request.setAttribute("productos", producto);
                    request.setAttribute("lista", lista);
                    request.setAttribute("Clientes", cliente);
                    request.setAttribute("totalapagar", totalapagar);
                    for (int i = 0; i < lista.size(); i++) {
                        totalapagar = totalapagar + lista.get(i).getTotal();
                    }
                    request.setAttribute("totalapagar", totalapagar);
                    request.setAttribute("listaventas", lista);

                    break;
                case "Agregar":

                    request.setAttribute("Clientes", cliente);
                    totalapagar = 0.0;
                    v = new Venta();
                    Item++;
                    idEmpleado = empleado.getIdEmpleado();
                    cod = producto.getIdProducto();
                    descripcion = request.getParameter("txtDescripcion");
                    precio = Double.parseDouble(request.getParameter("txtPrecio"));
                    cantidad = Integer.parseInt(request.getParameter("txtCantidad"));
                    subtotal = precio * cantidad;
                    v.setItem(Item);
                    v.setIdEmpleado(idEmpleado);
                    v.setIdProducto(cod);
                    v.setDescripcion(descripcion);
                    v.setPrecioVenta(precio);
                    v.setCantidad(cantidad);
                    v.setTotal(subtotal);
                    lista.add(v);
                    for (int i = 0; i < lista.size(); i++) {
                        totalapagar = totalapagar + lista.get(i).getTotal();
                    }
                    request.setAttribute("totalapagar", totalapagar);
                    request.setAttribute("listaventas", lista);
                    request.setAttribute("Clientes", cliente);

                    break;
                case "GenerarVenta":
                    //Actualizar stock
                    for (int i = 0; i < lista.size(); i++) {
                        Producto prod = new Producto();
                        int cant = lista.get(i).getCantidad();
                        int idprod = lista.get(i).getIdProducto();
                        ProductoDAO pDAO = new ProductoDAO();
                        prod = pDAO.Buscar(idprod);
                        int stockactual = prod.getStock() - cant;
                        pDAO.ActualizarStock(idprod, stockactual);

                    }
                    //Guardar venta
                    v.setNumeroFactura(numeroSerie);
                    v.setIdCliente(idcliente);
                    v.setIdEmpleado(1);
                    v.setTotal(totalapagar);
                    v.setEstado("1");
                    //v.setFecha(v.getFecha());
                    ventaDAO.RegistrarVenta(v);
                    int idv = Integer.parseInt(ventaDAO.ObtenerMaximoIdVentas());
                    for (int i = 0; i < lista.size(); i++) {
                        v = new Venta();
                        v.setIdVenta(idv);
                        v.setIdProducto(lista.get(i).getIdProducto());
                        v.setCantidad(lista.get(i).getCantidad());
                        v.setPrecioVenta(lista.get(i).getPrecioVenta());
                        ventaDAO.GuardarDetalleVenta(v);

                    }
                    break;
                default:
                    numeroSerie = ventaDAO.ObtenerNumeroDeFactura();
                    if (numeroSerie == null) {
                        numeroSerie = "00000001";
                        request.setAttribute("nserie", numeroSerie);
                    } else {
                        int incrementar = Integer.parseInt(numeroSerie);
                        GenerarSerie gs = new GenerarSerie();
                        numeroSerie = gs.NumeroFactura(incrementar);
                        request.setAttribute("nserie", numeroSerie);
                    }
//                   request.getRequestDispatcher("RegistrarVenta.jsp").forward(request, response);
            }
            request.getRequestDispatcher("RegistrarVenta.jsp").forward(request, response);
        }

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
