/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controlador;

import Modelo.Empleado;
import Modelo.EmpleadoDAO;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;

/**
 *
 * @author godie
 */
@WebServlet(name = "ControladorEmpleado", urlPatterns = {"/ControladorEmpleado"})
public class ControladorEmpleado extends HttpServlet {
    
    int idEmpleado;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
        EmpleadoDAO empleadodao = new EmpleadoDAO();
        String accion;
        RequestDispatcher dispatcher = null;
        accion = request.getParameter("accion");
        if (accion == null || accion.isEmpty()) {
            request.getRequestDispatcher("Empleado.jsp");
            List<Empleado> listaEmpleado = empleadodao.listar();
            request.setAttribute("listaempleado", listaEmpleado);
        } else if ("Agregar".equals(accion)) {
            Empleado empleado = new Empleado();
            String cedula = request.getParameter("txtCedula");
            String nombres = request.getParameter("txtNombres");
            String apellidos = request.getParameter("txtApellidos");
            String telefono = request.getParameter("txtTelefono");
            String correo = request.getParameter("txtCorreo");
            String estado = request.getParameter("txtEstado");
            String usuario = request.getParameter("txtUsuario");
            empleado.setCedula(cedula);
            empleado.setNombres(nombres);
            empleado.setApellidos(apellidos);
            empleado.setTelefono(telefono);
            empleado.setCorreo(correo);
            empleado.setEstado(estado);
            empleado.setUsuario(usuario);
            empleadodao.agregar(empleado);
            request.getRequestDispatcher("ControladorEmpleado?menu=Empleado&accion=Listar");
            List<Empleado> listaEmpleado = empleadodao.listar();
            request.setAttribute("listaempleado", listaEmpleado);
        } else if (accion.equals("Cargar")) {
            idEmpleado = Integer.parseInt(request.getParameter("id"));
            Empleado trabajador = empleadodao.listarId(idEmpleado);
            request.setAttribute("empleadoSelecionado", trabajador);
            dispatcher = request.getRequestDispatcher("ControladorEmpleado?menu=Empleado&accion=Listar");
            List<Empleado> listaEmpleado = empleadodao.listar();
            request.setAttribute("listaempleado", listaEmpleado);
        } else if (accion.equals("Actualizar")) {
            Empleado emp = new Empleado();
            String cedulaUpdate = request.getParameter("txtCedula");
            String nombresUpdate = request.getParameter("txtNombres");
            String apellidosUpdate = request.getParameter("txtApellidos");
            String telefonoUpdate = request.getParameter("txtTelefono");
            String correoUpdate = request.getParameter("txtCorreo");
            String estadoUpdate = request.getParameter("txtEstado");
            String usuarioUpdate = request.getParameter("txtUsuario");
            emp.setCedula(cedulaUpdate);
            emp.setNombres(nombresUpdate);
            emp.setApellidos(apellidosUpdate);
            emp.setTelefono(telefonoUpdate);
            emp.setCorreo(correoUpdate);
            emp.setEstado(estadoUpdate);
            emp.setUsuario(usuarioUpdate);
            emp.setIdEmpleado(idEmpleado);
            empleadodao.actualizar(emp);
            dispatcher = request.getRequestDispatcher("ControladorEmpleado?menu=Empleado&accion=Listar");
            List<Empleado> listaEmpleado = empleadodao.listar();
            request.setAttribute("listaempleado", listaEmpleado);
        } else if (accion.equals("Eliminar")) {
            Empleado emp = new Empleado();
            int IdEmpleado = Integer.parseInt(request.getParameter("txtIdEmpleado"));
            emp.setIdEmpleado(IdEmpleado);
            empleadodao.eliminar(emp);
            request.setAttribute("empleado", IdEmpleado);
            dispatcher = request.getRequestDispatcher("ControladorEmpleado?menu=Empleado&accion=Listar");
            List<Empleado> listaEmpleado = empleadodao.listar();
            request.setAttribute("listaempleado", listaEmpleado);
        }else{
            List<Empleado> listaEmpleado = empleadodao.listar();
            request.setAttribute("listaempleado", listaEmpleado);
        }
        //dispatcher.forward(request, response);
        request.getRequestDispatcher("Empleado.jsp").forward(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
        
    }
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
