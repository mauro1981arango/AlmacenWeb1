Aplicación Java con Bootstrap y patrón de diseño MVC. Para el funcionamiento de esta pequeña aplicación es necesario tener instalado
XAMPP Version: 8.2.0 e importar la base de datos ventas_web. 
Se ingresa con usuario: admin y contraseña: 123456
Tener instalado Apache NetBeans IDE 13.
java 17.0.2 2022-01-18 LTS.
Java(TM) SE Runtime Environment (build 17.0.2+8-LTS-86).
Java HotSpot(TM) 64-Bit Server VM (build 17.0.2+8-LTS-86, mixed mode, sharing).
Este pequeño Software simula una venata en java web, falta mucho para que sea completamente funcional en la vida real.
Es útil para personas que se están iniciando en el mundo del desarrollo web en Java.
La base de datos MySql llamada ventas_web tiene 5 tablas relacionales: cliente, detalle_venta, empleado, producto y ventas.
Cumple con las operaciones CRUD.
Para realizar una venta, se puede buscar un producto y un cliente por su id y luego dar clip en el botón BuscarProducto y BuscarCliente. De este modo
te agrega los productos que quieras a la tabla ventas presionando el botón Agregar. Te calcula el total.
Tiene un correlactivo de número de factura que inicia en 000000 y va aumentandode uno en uno. Ejemplo 00000012, sería la factura 12.
Al dar clip en el botón generar venta te guarda la venta y el detalle de la venta en MySql.
Es un proyecto nectamente de aprendizaje, dista de ser un proyecto funcional en la vida real.
