
package Modelo;

/**
 *
 * @author Diego Arango
 */
public class Producto {
   private int IdProducto;
   private String Codigo;
   private String Descripcion;
   private double Precio;
   private int Stock;
   private String Estado;

   public Producto() {
   }

   public Producto(int IdProducto, String Codigo, String Descripcion, double Precio, int Stock, String Estado) {
      this.IdProducto = IdProducto;
      this.Codigo = Codigo;
      this.Descripcion = Descripcion;
      this.Precio = Precio;
      this.Stock = Stock;
      this.Estado = Estado;
   }

   public int getIdProducto() {
      return IdProducto;
   }

   public void setIdProducto(int IdProducto) {
      this.IdProducto = IdProducto;
   }

   public String getCodigo() {
      return Codigo;
   }

   public void setCodigo(String Codigo) {
      this.Codigo = Codigo;
   }

   public String getDescripcion() {
      return Descripcion;
   }

   public void setDescripcion(String Descripcion) {
      this.Descripcion = Descripcion;
   }

   public double getPrecio() {
      return Precio;
   }

   public void setPrecio(double Precio) {
      this.Precio = Precio;
   }

   public int getStock() {
      return Stock;
   }

   public void setStock(int Stock) {
      this.Stock = Stock;
   }

   public String getEstado() {
      return Estado;
   }

   public void setEstado(String Estado) {
      this.Estado = Estado;
   }
   
}
