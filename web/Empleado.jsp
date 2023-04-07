<%-- 
    Document   : Empleado
    Created on : 7/03/2022, 6:22:06 p. m.
    Author     : Diego Arango
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <title>Sistema Ventas Web</title>
    </head>
    <body>
        <!-- Comienzo del formulario empleado -->
        <div class="d-flex">
            <div class="card col-sm-3">
                <div class="card-body">
                    <form action="ControladorEmpleado?menu=Empleado" method="post">
                        <div class="form-group">
                            <input type="hidden" name="txtIdEmpleado" class="form-control" value="${empleadoSelecionado.getIdEmpleado()}">
                        </div>
                        <div class="form-group">
                            <label>Cédula</label>
                            <input type="number" name="txtCedula" class="form-control" value="${empleadoSelecionado.getCedula()}">
                            <small class="form-text text-muted">Ingrese el número de Cédula sin puntos ni carácteres especiales</small>
                        </div>
                        <div class="form-group">
                            <label>Nombres</label>
                            <input type="text" name="txtNombres" class="form-control" value="${empleadoSelecionado.getNombres()}">
                        </div>
                        <div class="form-group">
                            <label>Apellidos</label>
                            <input type="text" name="txtApellidos" class="form-control" value="${empleadoSelecionado.getApellidos()}">
                        </div>
                        <div class="form-group">
                            <label>Teléfono</label> 
                            <input type="text" name="txtTelefono" class="form-control" value="${empleadoSelecionado.getTelefono()}">
                        </div>
                        <div class="form-group">
                            <label>Correo</label>
                            <input type="text" name="txtCorreo" class="form-control" value="${empleadoSelecionado.getCorreo()}">
                        </div>
                        <div class="form-group">
                            <label>Estado</label>
                            <input type="text" name="txtEstado" class="form-control" value="${empleadoSelecionado.getEstado()}">
                        </div>
                        <div class="form-group">
                            <label>Usuario</label>
                            <input type="text" name="txtUsuario" class="form-control" value="${empleadoSelecionado.getUsuario()}">
                        </div>
                        <input type="submit" class="btn btn-primary"  name="accion" value="Agregar">
                        <input type="submit" class="btn btn-success"  name="accion" value="Actualizar">
                    </form>
                </div>
            </div>
            <!-- Cierre del formulario empleado -->
            <div class="col-sm-6">
                <table class="table table-dark">
                    <thead>
                        <tr>
                            <th scope="col">Nro</th>
                            <th scope="col">Cedula</th>
                            <th scope="col">Nombres</th>
                            <th scope="col">Apellidos</th>
                            <th scope="col">Teléfono</th>
                            <th scope="col">Correo</th>
                            <th scope="col">Estado</th>
                            <th scope="col">Usuario</th>
                            <th scope="col">Acciones</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="usuario" items="${listaempleado}">
                            <tr>
                                <td>${usuario.getIdEmpleado()}</td>
                                <td>${usuario.getCedula()}</td>
                                <td>${usuario.getNombres()}</td>
                                <td>${usuario.getApellidos()}</td>
                                <td>${usuario.getTelefono()}</td>
                                <td>${usuario.getCorreo()}</td>
                                <td>${usuario.getEstado()}</td>
                                <td>${usuario.getUsuario()}</td>
                                <td>
                                    <a class="btn btn-warning" href="ControladorEmpleado?menu=Empleado&accion=Cargar&id=${usuario.getIdEmpleado()}">Actualizar</a>
                                    <a class="btn btn-danger" href="ControladorEmpleado?menu=Empleado&accion=Cargar&id=${usuario.getIdEmpleado()}">Eliminar</a>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div> 
            <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
            <script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.7/dist/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
            <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    </body>
</html>
