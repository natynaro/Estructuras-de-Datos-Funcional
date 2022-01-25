package EjercicioRectangulo;
import java.util.Scanner;

public class MainRectangulo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner (System.in);
		Rectangulo ejemplo = new Rectangulo();
		
		double altura, ancho;
		
		System.out.println("Escriba la altura del rectángulo en metros");
		altura = scanner.nextDouble();
		ejemplo.setAltura(altura);
	
		
		System.out.println("Escriba el ancho del rectángulo en metros");
		ancho = scanner.nextDouble();
		ejemplo.setAncho(ancho);
		
		System.out.println("El área del rectángulo en metros cuadrados: " + ejemplo.calcularArea() + 
				" y el perímetro en metros es: " + ejemplo.calcularPerimetro() );

	}

}
