package Salario;
import java.util.*;

public class MainTrabajador {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner (System.in);
		String nombre="";
		double salario=0; //el b�sico
				
		Trabajador[] arr= new Trabajador[0]; //el arreglo de trabajadores
			
		int k=1;
		
		while(k>0) {
			System.out.println("Ingrese su nombre");
			nombre= scanner.next();
			
			System.out.println("Ingrese su salario b�sico");
			salario= scanner.nextDouble();
		
			
			arr= Arrays.copyOf(arr, arr.length+1); //le estoy añadiendo una nueva casilla para guardar al nuevo objeto trabajador
			arr[arr.length-1] = new Trabajador(nombre, salario);
			
			/*System.out.println("Ingrese el n�mero de d�as que trabaj�");
			trabajador1.setDiasTrabajados(scanner.nextDouble());
			trabajador1.Salario();*/ //tengo que preguntar el nombre del trabajador para buscarlo y modificar su atributo de salario
			
			k++; //ponerlo como if no hay mas trabajadores, entonces k=0 y se detiene el while
		}
		
	}

}
