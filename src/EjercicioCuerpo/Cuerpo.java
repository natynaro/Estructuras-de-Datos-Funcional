package EjercicioCuerpo;

public class Cuerpo {
	private double espacio;
	private double tiempo;
	
	public double getEspacio() {
		return espacio;
	}
	public void setEspacio(double espacio) {
		this.espacio = espacio;
	}
	public double getTiempo() {
		return tiempo;
	}
	public void setTiempo(double tiempo) {
		this.tiempo = tiempo;
	}
	
	public double calcularVelocidad(double espacio, double tiempo) {
		this.espacio = espacio;
		this.tiempo = tiempo;
		double velocidad = (espacio/tiempo);
		return velocidad;
		
	}

}
