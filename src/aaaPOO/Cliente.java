package aaaPOO;

public class Cliente {
	private String nombre;
	private String estado;
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public Cliente(String nombre, String estado) {
		super();
		this.nombre = nombre;
		this.estado = estado;
	}
	
	
}
