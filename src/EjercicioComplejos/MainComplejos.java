package EjercicioComplejos;
import java.util.Scanner;

public class MainComplejos {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner (System.in);
		Complejos complejos= new Complejos();
		
		System.out.println("Ingrese la parte real del número complejo");
		double real = scanner.nextDouble();
		complejos.setReal(real);
		
		System.out.println("Ingrese la parte entera del que acompaña a i en el número complejo");
		int entero = scanner.nextInt();
		complejos.setEntero(entero);
		
		System.out.println("El módulo del número entero es: " + complejos.Modulo() + 
				" y el argumento en radianes es: " + complejos.Argumento());
	}

}
