package Salario;
import java.util.Scanner;

public class MainTrabajador {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner (System.in);
		String nombre="";
		double salario=0; //el b�sico
		
		System.out.println("Ingrese su nombre");
		nombre= scanner.next();
		
		System.out.println("Ingrese su salario b�sico");
		salario= scanner.nextDouble();
		
		Trabajador trabajador1 = new Trabajador(nombre, salario);
		System.out.println("Ingrese el n�mero de d�as que trabaj�");
		trabajador1.setDiasTrabajados(scanner.nextDouble());
		trabajador1.Salario();
	}
//aaaaaaaaaa
}
