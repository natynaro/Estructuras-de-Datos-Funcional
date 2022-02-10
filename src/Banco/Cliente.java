package Banco;
import java.util.*;

public class Cliente {
	private String nombre;
	private String apellidos;
	private String direccion;
	private String telefono;
	private String cedula;
	private Date nacimiento;
	private Cuenta cuenta;
	
	public Cliente(String nombre, String apellidos, String direccion, String telefono, String cedula, Date nacimiento,
			Cuenta cuenta) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.direccion = direccion;
		this.telefono = telefono;
		this.cedula = cedula;
		this.nacimiento = nacimiento;
		this.cuenta = cuenta;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getApellidos() {
		return apellidos;
	}
	
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	
	public String getDireccion() {
		return direccion;
	}
	
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	public String getTelefono() {
		return telefono;
	}
	
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	public String getCedula() {
		return cedula;
	}
	
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}
	
	public Date getNacimiento() {
		return nacimiento;
	}
	
	public void setNacimiento(Date nacimiento) {
		this.nacimiento = nacimiento;
	}
	
	public Cuenta getCuenta() {
		return cuenta;
	}
	
	public void setCuenta(Cuenta cuenta) {
		this.cuenta = cuenta;
	}
	
	//métodos
	
	//Dependiendo de la cantidad de dinero que quiera extraer, es lo que disminuye en el saldo de la cuenta
	public void extraccion(double cantidad) {
		if(cuenta.getSaldo()>=cantidad) {
			double saldoFinal=cuenta.getSaldo()-cantidad;
			cuenta.setSaldo(saldoFinal);
		}else {System.out.println("No tiene el suficiente saldo");}
		
	}
	
	//Dependiendo de la cantidad de dinero que quiera depositar, es lo que aumenta en el saldo de la cuenta
	public void deposito(double cantidad) {
		double[] depositos= Arrays.copyOf(cuenta.getDepositos(), (cuenta.getDepositos().length+1));
		double saldoFinal=cuenta.getSaldo()+cantidad;
		cuenta.setSaldo(saldoFinal);
		depositos[depositos.length-1]=cantidad;
	}

	@Override
	public String toString() {
		return "Cliente [nombre=" + nombre + ", apellidos=" + apellidos + ", cedula=" + cedula + ", cuenta=" + cuenta
				+ "]";
	}
	
	
}
