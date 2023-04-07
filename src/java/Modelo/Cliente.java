
package Modelo;

/**
 *
 * @author Diego Arango
 */
public class Cliente {
   private int IdCliente;
   private String Cedula, Nombres, Apellidos, Direccion, Telefono, Estado;

   public Cliente() {
   }

   public Cliente(int IdCliente, String Cedula, String Nombres, String Apellidos, String Direccion, String Telefono, String Estado) {
      this.IdCliente = IdCliente;
      this.Cedula = Cedula;
      this.Nombres = Nombres;
      this.Apellidos = Apellidos;
      this.Direccion = Direccion;
      this.Telefono = Telefono;
      this.Estado = Estado;
   }

   public int getIdCliente() {
      return IdCliente;
   }

   public void setIdCliente(int IdCliente) {
      this.IdCliente = IdCliente;
   }

   public String getCedula() {
      return Cedula;
   }

   public void setCedula(String Cedula) {
      this.Cedula = Cedula;
   }

   public String getNombres() {
      return Nombres;
   }

   public void setNombres(String Nombres) {
      this.Nombres = Nombres;
   }

   public String getApellidos() {
      return Apellidos;
   }

   public void setApellidos(String Apellidos) {
      this.Apellidos = Apellidos;
   }

   public String getDireccion() {
      return Direccion;
   }

   public void setDireccion(String Direccion) {
      this.Direccion = Direccion;
   }

   public String getTelefono() {
      return Telefono;
   }

   public void setTelefono(String Telefono) {
      this.Telefono = Telefono;
   }

   public String getEstado() {
      return Estado;
   }

   public void setEstado(String Estado) {
      this.Estado = Estado;
   }
   
}
