package Salario;
import java.util.*;

/*arreglo de trabajadores con la clase que ya tenemos de trabajador*/


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
			
			System.out.println("¿Desea ingresar la información de otro trabajador? Si sí ingrese un 0, si no un 1");
			
			if (scanner.nextInt()==0) {
				k++;
			} else if (scanner.nextInt()==1) {
				k=0;
			}
		}
		
		Trabajador.setTrabajadores(arr);
		
		String ubicar="";
		 System.out.println("Ingresa el nombre del trabajador que quieres saber: ");
		 ubicar= scanner.next();
		 arr[0].Salario(nombre);
		 
			
		
	}
}
