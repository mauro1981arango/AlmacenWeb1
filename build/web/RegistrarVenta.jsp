<%-- 
    Document   : RegistrarVenta
    Created on : 3/03/2022, 5:45:18 p. m.
    Author     : Diego Arango
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <title>Registrar Venta</title>
    </head>
    <body>

        <div class="d-flex">
            <div class="col-sm-4">
                <div class="card">
                    <form action="Controlador?menu=RegistrarVenta" method="post">
                        <div class="card-body">
                            <div class="form-group d-flex">
                                <!-- Informacion del cliente -->
                                <div class="col-sm-12 d-flex">
                                    <input type="text" name="txtCedulaCliente" value="${Clientes.getIdCliente()}" class="form-control"> 

                                    <input type="submit" name="accion" value="BuscarCliente" class="btn-outline-info">  
                                    <input type="text" name="txtNombresCliente" value="${Clientes.getNombres()}" class="form-control">                    
                                </div> 
                                <!-- Fin formulario Cliente -->

                                <!-- Informacion del Producto -->  
                            </div>
                            <div class="form-group d-flex">
                                <div class="col-sm-12 d-flex">
                                    <input type="text" name="txtCodigo" value="${productos.getIdProducto()}" class="form-control"> 

                                    <input type="submit" name="accion" value="BuscarProducto" class="btn-outline-info">  
                                    <input type="text" name="txtDescripcion" value="${productos.getDescripcion()}" class="form-control">                    
                                </div> 
                                <!-- Fin formulario Producto -->
                            </div>
                            <!-- Componentes adicionales -->  
                            <div class="form-group d-flex">
                                <div class="col-sm-12 d-flex">
                                    <input type="text" name="txtPrecio" value="${productos.getPrecio()}" class="form-control" placeholder="$/.000.0"> 

                                    <input type="number" name="txtCantidad" value="1" class="form-control" placeholder="Cantidad">  
                                    <input type="number" name="txtStock" value="${productos.getStock()}" class="form-control" placeholder="Stock">                   
                                </div> 
                            </div>
                            <div class="form-group">
                                <input type="submit" name="accion" value="Agregar" class="btn-outline-info">  
                            </div>
                                
                              
                            <!-- Fin Componentes -->
                        </div>
                    </form>
                </div>
            </div>
            <div class="col-sm-8">
                <div class="card"></div>
                <div class="col-sm-3 ml-auto">
                    <label>Numero Factura</label>
                    <input type="text" name="NumeroFactura" class="form-control" value="${nserie}">
                </div>
                <table class="table table-hover">
                    <thead>
                        <tr>
                            <th>Nro</th> 
                            <th>Codigo</th> 
                            <th>Descripcion</th> 
                            <th>Precio</th> 
                            <th>Cantidad</th> 
                            <th>SubTotal</th> 
                            <th>Acciones</th> 
                        </tr> 
                    </thead> 
                    <tbody>
                        <c:forEach var="lista" items="${listaventas}">
                            <tr>
                                <th>${lista.getItem()}</th>
                                <td>${lista.getIdProducto()}</td>
                                <td>${lista.getDescripcion()}</td>
                                <td>${lista.getPrecioVenta()}</td>
                                <td>${lista.getCantidad()}</td>
                                <td>${lista.getTotal()}</td>
                                <td class="columna">
                                    <a class="btn btn-warning">Editar</a>
                                    <a class="btn btn-danger">Eliminar</a>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
                <div class="card-footer d-flex">
                    <div class="col-sm-6">
                        <a class="btn btn-success"  onclick="print()" href="Controlador?menu=RegistrarVenta&accion=GenerarVenta">Generar Venta</a>
                        <input type="submit" name="accion" value="Cancelar" class="btn-danger">
                    </div>
                </div>
                <div class="col-sm-3 ml-auto">
                    <label class="ml-auto">Total</label>
                    <input type="text" name="txtTotal" value="${totalapagar}" class="form-control">
                </div>
            </div>  
        </div>
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.7/dist/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    </body>
</html>
