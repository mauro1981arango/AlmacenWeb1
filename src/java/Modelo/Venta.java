package Modelo;

/**
 *
 * @author godie
 */
public class Venta {

    int Item;
    int IdVenta;
    String NumeroFactura;
    int IdCliente;
    int IdEmpleado;
    double Total;
    int IdProducto;
    int Cantidad;
    double PrecioVenta;
    String Estado;
    String FechaRegistro;
    String Descripcion;

    public Venta() {
    }

    public Venta(int Item, int IdVenta, String NumeroFactura, int IdCliente, int IdEmpleado, double Total, int IdProducto, int Cantidad, double PrecioVenta, String Estado, String FechaRegistro, String Descripcion) {
        this.Item = Item;
        this.IdVenta = IdVenta;
        this.NumeroFactura = NumeroFactura;
        this.IdCliente = IdCliente;
        this.IdEmpleado = IdEmpleado;
        this.Total = Total;
        this.IdProducto = IdProducto;
        this.Cantidad = Cantidad;
        this.PrecioVenta = PrecioVenta;
        this.Estado = Estado;
        this.FechaRegistro = FechaRegistro;
        this.Descripcion = Descripcion;
    }

    public int getItem() {
        return Item;
    }

    public void setItem(int Item) {
        this.Item = Item;
    }

    public int getIdVenta() {
        return IdVenta;
    }

    public void setIdVenta(int IdVenta) {
        this.IdVenta = IdVenta;
    }

    public String getNumeroFactura() {
        return NumeroFactura;
    }

    public void setNumeroFactura(String NumeroFactura) {
        this.NumeroFactura = NumeroFactura;
    }

    public int getIdCliente() {
        return IdCliente;
    }

    public void setIdCliente(int IdCliente) {
        this.IdCliente = IdCliente;
    }

    public int getIdEmpleado() {
        return IdEmpleado;
    }

    public void setIdEmpleado(int IdEmpleado) {
        this.IdEmpleado = IdEmpleado;
    }

    public double getTotal() {
        return Total;
    }

    public void setTotal(double Total) {
        this.Total = Total;
    }

    public int getIdProducto() {
        return IdProducto;
    }

    public void setIdProducto(int IdProducto) {
        this.IdProducto = IdProducto;
    }

    public int getCantidad() {
        return Cantidad;
    }

    public void setCantidad(int Cantidad) {
        this.Cantidad = Cantidad;
    }

    public double getPrecioVenta() {
        return PrecioVenta;
    }

    public void setPrecioVenta(double PrecioVenta) {
        this.PrecioVenta = PrecioVenta;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }

    public String getFechaRegistro() {
        return FechaRegistro;
    }

    public void setFechaRegistro(String FechaRegistro) {
        this.FechaRegistro = FechaRegistro;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    
}
