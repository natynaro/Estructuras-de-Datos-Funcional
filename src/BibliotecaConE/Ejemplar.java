package BibliotecaConE;

public class Ejemplar extends Libro{
	
	private String codigoEjemplar;
	private boolean disponibilidad;
	private boolean existenciaEjemplar;
	
	public Ejemplar(String titulo, String codigoLibro, String autores, String editorial, String edicion, Ejemplar[] ejemplares,
			int cantDisponible, boolean existenciaLibro, String codigoEjemplar, boolean disponibilidad, boolean existenciaEjemplar) {
		super(titulo, codigoLibro, autores, editorial, edicion, ejemplares, cantDisponible, existenciaLibro);
		
		this.codigoEjemplar = codigoEjemplar;
		this.disponibilidad = disponibilidad;
		this.existenciaEjemplar = existenciaEjemplar;
	}

	
	public String getCodigoEjemplar() {
		return codigoEjemplar;
	}

	
	public void setCodigoEjemplar(String codigoEjemplar) {
		this.codigoEjemplar = codigoEjemplar;
	}

	
	public boolean isDisponibilidad() {
		return disponibilidad;
	}

	
	public void setDisponibilidad(boolean disponibilidad) {
		this.disponibilidad = disponibilidad;
	}

	
	public boolean isExistenciaEjemplar() {
		return existenciaEjemplar;
	}

	
	public void setExistenciaEjemplar(boolean existenciaEjemplar) {
		this.existenciaEjemplar = existenciaEjemplar;
	} 
	
	
}
