<%-- 
    Document   : Producto
    Created on : 10/03/2022, 10:42:23 a. m.
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
        <!-- Comienzo del formulario producto -->
        <div class="d-flex">
            <div class="card col-sm-3">
                <div class="card-body">
                    <form action="Controlador?menu=Producto" method="post">
                        
                        <div class = "form-group">
                            <label>Código</label>
                            <input type="text" name="txtCodigo" class="form-control" value="${productoSelecionado.getCodigo()}">
                        </div> 
                        <div class = "form-group">
                            <label>Descripción</label>
                            <input type="text" name="txtDescripcion" class="form-control" value="${productoSelecionado.getDescripcion()}">
                        </div> 
                        <div class = "form-group">
                            <label>Precio</label>
                            <input type="number" name="txtPrecio" class="form-control" value="${productoSelecionado.getPrecio()}"> 
                        </div> 
                        <div class = "form-group">
                            <label>Stock</label>
                            <input type="number" name="txtStock" class="form-control" value="${productoSelecionado.getStock()}">
                        </div>
                        <div class = "form-group">
                            <label>Estado</label>
                            <input type="text" name="txtEstado" class="form-control" value="${productoSelecionado.getEstado()}"> 
                        </div> 
                        <input type="submit" class="btn btn-primary" name="accion"  value="Agregar">
                        <input type="submit" class="btn btn-success" name="accion" value="Actualizar">
                    </form>
                </div>
            </div>
            <!-- Cierre del formulario Producto -->
            <div class="col-sm-9">
                <table class="table table-dark">
                    <thead>
                        <tr>
                            <th scope="col">Nro</th>
                            <th scope="col">Código</th>
                            <th scope="col">Descripción</th>
                            <th scope="col">Precio</th>
                            <th scope="col">Stock</th>
                            <th scope="col">Estado</th>
                            <th scope="col">Acciones</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="producto" items="${productos}">
                            <tr>
                                <td>${producto.getIdProducto()}</td>
                                <td>${producto.getCodigo()}</td>
                                <td>${producto.getDescripcion()}</td>
                                <td>${producto.getPrecio()}</td>
                                <td>${producto.getStock()}</td>
                                <td>${producto.getEstado()}</td>
                                <td>
                                    <a class="btn btn-warning" href="Controlador?menu=Producto&accion=Cargar&id=${producto.getIdProducto()}">Actualizar</a>
                                    <a class="btn btn-danger" href="Controlador?menu=Producto&accion=Eliminar&id${producto.getIdProducto()}">Eliminar</a>
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

