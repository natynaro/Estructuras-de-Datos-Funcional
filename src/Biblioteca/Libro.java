package Biblioteca;

import java.util.*;

public class Libro {

	private String titulo;
	private String codigoLibro;
	private String autores;
	private String editorial;
	private String Edicion;
	private Ejemplar[] ejemplares= new Ejemplar[0];
	private int cantDisponible;
	private boolean existenciaLibro;
	
	public Libro(String titulo, String codigoLibro, String autores, String editorial, String edicion, Ejemplar[] ejemplares,
			int cantDisponible, boolean existenciaLibro) {
		super();
		this.titulo = titulo;
		this.codigoLibro = codigoLibro;
		this.autores = autores;
		this.editorial = editorial;
		Edicion = edicion;
		this.ejemplares = ejemplares;
		this.cantDisponible = cantDisponible;
		this.existenciaLibro = existenciaLibro;
	}

	
	public String getTitulo() {
		return titulo;
	}

	
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	
	public String getCodigoLibro() {
		return codigoLibro;
	}

	
	public void setCodigoLibro(String codigo) {
		this.codigoLibro = codigo;
	}

	
	public String getAutores() {
		return autores;
	}

	
	public void setAutores(String autores) {
		this.autores = autores;
	}

	
	public String getEditorial() {
		return editorial;
	}

	
	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}

	
	public String getEdicion() {
		return Edicion;
	}

	
	public void setEdicion(String edicion) {
		Edicion = edicion;
	}

	
	public Ejemplar[] getEjemplares() {
		return ejemplares;
	}

	
	public void setEjemplares(Ejemplar[] ejemplares) {
		this.ejemplares = ejemplares;
	}

	
	public int getCantDisponible() {
		return cantDisponible;
	}

	
	public void setCantDisponible(int cantDisponible) {
		this.cantDisponible = cantDisponible;
	}

	
	public boolean isExistenciaLibro() {
		return existenciaLibro;
	}

	
	public void setExistenciaLibro(boolean existencia) {
		this.existenciaLibro = existencia;
	}
	
	//métodos que pidió la profe
	
	//añade un nuevo espacio en los ejemplares del libro correspondiente y le asigna un código y le pone la disponibilidad y existencia
	public void addEjemplar(String codigo) {
		this.ejemplares=Arrays.copyOf(ejemplares, (ejemplares.length+1));
		this.ejemplares[(ejemplares.length-1)]= new Ejemplar(this.titulo, this.codigoLibro, this.autores, this.editorial, this.Edicion, this.ejemplares, this.cantDisponible, this.existenciaLibro, codigo, true, true);
		this.cantDisponible= cantDisponible+1;
	}
	
	//Lo que hace es que mientras en el arreglo de ejemplares de libro, haya disponibilidad y existencia, retorna el ejemplar, si no, retorna un ejemplar que diga no disponible
	public Ejemplar buscarEjemplar() {
		int i=0;
		while(ejemplares[i].isExistenciaEjemplar()) {
			while(ejemplares[i].isDisponibilidad()) {
				return ejemplares[i];
			}
			i++;
		}
		Ejemplar noDisponible= new Ejemplar(this.titulo, this.codigoLibro, this.autores, this.editorial, this.Edicion, this.ejemplares, this.cantDisponible, this.existenciaLibro, "no disponible", false, false);
		
		return noDisponible;
	}

	//cuando quiera eliminar un ejemplar de este libro, con el codigo del ejemplar busca la posicion delejemplar y si existe lo elimina
	public void eliminarEjemplar(String codigo) {
		int i=0;
		while(!ejemplares[i].getCodigoEjemplar().equals(codigo)) {
			i++;
		}//if
		if(i<ejemplares.length) {
			for(int k=i; k<ejemplares.length; k++) {
				ejemplares[k]=ejemplares[k+1];
			}
			this.ejemplares=Arrays.copyOf(ejemplares, (ejemplares.length-1));
		}// else no se pudo hacer
		
	}
}
