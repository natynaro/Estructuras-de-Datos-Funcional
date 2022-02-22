package BibliotecaConE;
import java.util.*;

public class Prestamo {
	
	private Usuario usuario;
	private Ejemplar[] libros= new Ejemplar[0];
	private Date fechaPrestamo = new Date();
	private Date fechaDevolucion = new Date();
		
	public Prestamo(Usuario usuario, Ejemplar[] libros, Date fechaPrestamo, Date fechaDevolucion) {
		super();
		this.usuario = usuario;
		this.libros = libros;
		this.fechaPrestamo = fechaPrestamo;
		this.fechaDevolucion = fechaDevolucion;
	}
	
	public Usuario getUsuario() {
		return usuario;
	}
	
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public Ejemplar[] getLibros() {
		return libros;
	}
	
	public void setLibros(Ejemplar[] libros) {
		this.libros = libros;
	}
	
	public Date getFechaPrestamo() {
		return fechaPrestamo;
	}
	
	public void setFechaPrestamo(Date fechaPrestamo) {
		this.fechaPrestamo = fechaPrestamo;
	}
	
	public Date getFechaDevolucion() {
		return fechaDevolucion;
	}
	
	public void setFechaDevolucion(Date fechaDevolucion) {
		this.fechaDevolucion = fechaDevolucion;
	}
	
	
	
}
