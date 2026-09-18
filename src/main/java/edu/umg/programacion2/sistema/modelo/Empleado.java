package edu.umg.programacion2.sistema.modelo;
import java.math.BigDecimal;
public class Empleado {
	  private int idEmpleado;
	    private String nombreCompleto;
	    private String puesto;
	    private BigDecimal salario;
	    private String telefono;
	    private String correo;

	    public Empleado() {
	    }

	    public Empleado(int idEmpleado, String nombreCompleto, String puesto,
	                    BigDecimal salario, String telefono, String correo) {
	        this.idEmpleado = idEmpleado;
	        this.nombreCompleto = nombreCompleto;
	        this.puesto = puesto;
	        this.salario = salario;
	        this.telefono = telefono;
	        this.correo = correo;
	    }

	    public int getIdEmpleado() {
	        return idEmpleado;
	    }

	    public void setIdEmpleado(int idEmpleado) {
	        this.idEmpleado = idEmpleado;
	    }

	    public String getNombreCompleto() {
	        return nombreCompleto;
	    }

	    public void setNombreCompleto(String nombreCompleto) {
	        this.nombreCompleto = nombreCompleto;
	    }

	    public String getPuesto() {
	        return puesto;
	    }

	    public void setPuesto(String puesto) {
	        this.puesto = puesto;
	    }

	    public BigDecimal getSalario() {
	        return salario;
	    }

	    public void setSalario(BigDecimal salario) {
	        this.salario = salario;
	    }

	    public String getTelefono() {
	        return telefono;
	    }

	    public void setTelefono(String telefono) {
	        this.telefono = telefono;
	    }

	    public String getCorreo() {
	        return correo;
	    }

	    public void setCorreo(String correo) {
	        this.correo = correo;
	    }
	}
