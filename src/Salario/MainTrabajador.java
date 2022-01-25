package Salario;
import java.util.Scanner;

public class MainTrabajador {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner (System.in);
		String nombre="";
		double salario=0; //el básico
		
		System.out.println("Ingrese su nombre");
		nombre= scanner.next();
		
		System.out.println("Ingrese su salario básico");
		salario= scanner.nextDouble();
		
		Trabajador trabajador1 = new Trabajador(nombre, salario);
		System.out.println("Ingrese el número de días que trabajó");
		trabajador1.setDiasTrabajados(scanner.nextDouble());
		trabajador1.Salario();
	}
//aaaaaaaaaa
}
