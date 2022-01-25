package EjercicioCuerpo;

import java.util.Scanner;

public class MainCuerpo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner (System.in);
		
		Cuerpo cuerpo = new Cuerpo();
		
		System.out.println("Escriba el espacio recorrido por el cuerpo EN METROS con decimales");
		double Recorrido = scanner.nextDouble();
		cuerpo.setEspacio(Recorrido);
		
		System.out.println("Escriba el tiempo EN SEGUNDOS en el que el cuerpo recorió el espacio "
				+ "con decimales");
		double Tiempo = scanner.nextDouble();
		cuerpo.setTiempo(Tiempo);
		
		System.out.println("La velocidad del cuerpo es:" + 
		cuerpo.calcularVelocidad(Recorrido, Tiempo) + "m/s^2");
	}

}
