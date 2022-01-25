package EjercicioRectangulo;

public class Rectangulo {
	private double ancho;
	private double altura;
	public double getAncho() {
		return ancho;
	}
	public void setAncho(double ancho) {
		this.ancho = ancho;
	}
	public double getAltura() {
		return altura;
	}
	public void setAltura(double altura) {
		this.altura = altura;
	}
	
	public double calcularPerimetro() {
		double perimetro= ((this.altura * 2)+ (this.ancho * 2));
		return perimetro;
		
		
	}
	public double calcularArea() {
		double area=(this.altura * this.ancho);
		return area;
	}
}
