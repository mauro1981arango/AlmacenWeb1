<%-- 
    Document   : Clientes
    Created on : 3/03/2022, 5:43:36 p. m.
    Author     : Diego Arango
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <title>JSP Page</title>
    </head>
    <body>
        <!-- Comienzo del formulario cliente -->
        <div class="d-flex">
            <div class="card col-sm-3">
                <div class="card-body">
                    <form action="Controlador?menu=Cliente" method="post">
                        <div class = "form-group">
                            <input type="hidden" name="txtIdCliente" class="form-control" value="${clienteSelecionado.getIdCliente()}">
                        </div> 
                        <div class = "form-group">
                            <label>Cédula</label>
                            <input type="number" name="txtCedula" class="form-control" value="${clienteSelecionado.getCedula()}">
                            <small class="form-text text-muted">Ingrese el número de Cédula sin puntos ni carácteres especiales</small>
                        </div> 
                        <div class = "form-group">
                            <label>Nombres</label>
                            <input type="text" name="txtNombres" class="form-control" value="${clienteSelecionado.getNombres()}">
                        </div> 
                        <div class = "form-group">
                            <label>Apellidos</label>
                            <input type="text" name="txtApellidos" class="form-control" value="${clienteSelecionado.getApellidos()}"> 
                        </div> 
                        <div class = "form-group">
                            <label>Dirección</label>
                            <input type="text" name="txtDireccion" class="form-control" value="${clienteSelecionado.getDireccion()}">
                        </div> 
                        <div class = "form-group">
                            <label>Teléfono</label>
                            <input type="number" name="txtTelefono" class="form-control" value="${clienteSelecionado.getTelefono()}"> 
                        </div> 
                        <div class = "form-group">
                            <label>Estado</label>
                            <input type="number" name="txtEstado" class="form-control" value="${clienteSelecionado.getEstado()}"> 
                        </div> 
                        <input type="submit" name="accion" class="btn btn-primary" value="Agregar">
                        <input type="submit" name="accion" class="btn btn-success" value="Actualizar">
                    </form>
                </div>
            </div>
            <!-- Cierre del formulario cliente -->
            <div class="col-sm-10">
                <table class="table table-dark">
                    <thead>
                        <tr>
                            <th scope="col">Nro</th>
                            <th scope="col">Cedula</th>
                            <th scope="col">Nombres</th>
                            <th scope="col">Apellidos</th>
                            <th scope="col">Dirección</th>
                            <th scope="col">Teléfono</th>
                            <th scope="col">Estado</th>
                            <th scope="col">Acciones</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="cliente" items="${listaCliente}">
                            <tr>
                                <td>${cliente.getIdCliente()}</td>
                                <td>${cliente.getCedula()}</td>
                                <td>${cliente.getNombres()}</td>
                                <td>${cliente.getApellidos()}</td>
                                <td>${cliente.getDireccion()}</td>
                                <td>${cliente.getTelefono()}</td>
                                <td>${cliente.getEstado()}</td>
                                <td>
                                    <a class="btn btn-warning" href="Controlador?menu=Cliente&accion=Cargar&id=${cliente.getIdCliente()}">Actualizar</a>
                                    <a class="btn btn-danger" name="accion" href="Controlador?menu=Cliente&accion=Eliminar&id=${cliente.getIdCliente()}">Eliminar</a>
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
