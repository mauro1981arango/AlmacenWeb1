<%-- 
    Document   : Principal
    Created on : 3/03/2022, 11:39:03 a. m.
    Author     : Diego Arango
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <title>Sistema Ventas Web</title>
    </head>
    <body>
        <nav class="navbar navbar-expand-lg navbar-light bg-info">
            <a class="navbar-brand" href="#"></a>
            <div class="collapse navbar-collapse" id="navbarText">
                <ul class="navbar-nav mr-auto">
                    <li class="nav-item active">
                        <a class="nav-link" href="#"  class="btn btn-outline-light">Home</a>
                    </li>
                    <li class="nav-item">
                        <a style="margin-left: 10px; border: none" class="btn btn-outline-light" href="ControladorEmpleado?menu=Empleado" target="myFrame">Empleado</a>
                    </li>
                    <li class="nav-item">
                        <a style="margin-left: 10px; border: none" class="btn btn-outline-light" href="Controlador?menu=Cliente" target="myFrame">Clientes</a>
                    </li>
                    <li class="nav-item">
                        <a style="margin-left: 10px; border: none" class="btn btn-outline-light" href="Controlador?menu=RegistrarVenta&accion=default" target="myFrame">Nueva Venta</a>
                    </li>
                    <li class="nav-item">
                        <a style="margin-left: 10px; border: none" class="btn btn-outline-light" href="Controlador?menu=Producto" target="myFrame">Producto</a>
                    </li>
                </ul>
                <div class="dropdown">
                    <button style="border: none" class="btn btn-outline-light dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                      ${usuario.getNombres()} ${usuario.getApellidos()} 
                    </button>
                    <div class="dropdown-menu text-center">
                        <a class="dropdown-item" href="#">
                           <!-- <img src="WEB-INF/img/img-usuario.jpg" alt="60" width="60"/> -->
                        </a>
                        <a class="dropdown-item" href="#">Usuario: ${usuario.getUsuario()}</a>
                        <a class="dropdown-item" href="#">Correo: ${usuario.getCorreo()}</a>
                        <a class="dropdown-item" href="#">Teléfono: ${usuario.getTelefono()}</a>
                        <a class="dropdown-item" href="#">Id: ${usuario.getIdEmpleado()}</a>
                        <div class="dropdown-divider"></div>
                        <form acttion="Validar" method="post">
                            <button name="accion" value="Salir" class="btn btn-danger center-block">Salir</button>
                        </form>
                    </div>
                </div>  
            </div>
        </nav>
        <iframe class="m-4" style="height: 565px; width: 96.6%; border: none"class="backgroun-color-blue" name="myFrame"></iframe>
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.7/dist/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    </body>
</html>
