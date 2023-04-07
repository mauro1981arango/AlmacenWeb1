
package Modelo;

/**
 *
 * @author Diego Arango
 */
public class Empleado {
   private int IdEmpleado;
   private String Cedula;
   private String Nombres;
   private String Apellidos;
   private String Telefono; 
   private String Correo;
   private String Estado;
   private String Usuario;

   public Empleado() {
   }

   public Empleado(int IdEmpleado, String Cedula, String Nombres, String Apellidos, String Telefono, String Correo, String Estado, String Usuario) {
      this.IdEmpleado = IdEmpleado;
      this.Cedula = Cedula;
      this.Nombres = Nombres;
      this.Apellidos = Apellidos;
      this.Telefono = Telefono;
      this.Correo = Correo;
      this.Estado = Estado;
      this.Usuario = Usuario;
   }

   public int getIdEmpleado() {
      return IdEmpleado;
   }

   public void setIdEmpleado(int IdEmpleado) {
      this.IdEmpleado = IdEmpleado;
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

   public String getTelefono() {
      return Telefono;
   }

   public void setTelefono(String Telefono) {
      this.Telefono = Telefono;
   }

   public String getCorreo() {
      return Correo;
   }

   public void setCorreo(String Correo) {
      this.Correo = Correo;
   }

   public String getEstado() {
      return Estado;
   }

   public void setEstado(String Estado) {
      this.Estado = Estado;
   }

   public String getUsuario() {
      return Usuario;
   }

   public void setUsuario(String Usuario) {
      this.Usuario = Usuario;
   }
   
}
