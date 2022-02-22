package Biblioteca;

public class Usuario {
	
	private String nombre;
	private String CC;
	private String telefono;
	private String tipo;
	
	public Usuario(String nombre, String cC, String telefono, String tipo) {
		super();
		this.nombre = nombre;
		CC = cC;
		this.telefono = telefono;
		this.tipo = tipo;
	}

	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getCC() {
		return CC;
	}
	
	public void setCC(String cC) {
		CC = cC;
	}
	
	public String getTelefono() {
		return telefono;
	}
	
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	public String getTipo() {
		return tipo;
	}
	
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}	
}
