package Salario;
import java.util.*;

/*arreglo de trabajadores con la clase que ya tenemos de trabajador*/


public class MainTrabajador {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner (System.in);
		String nombre="";
		double salario=0; //el b�sico
		Proyecto proyecto1= new Proyecto();
	
		int k=1;
		
		while(k>0) { //este while tiene que usar ahora el metodo de proyecto
			System.out.println("Ingrese su nombre");
			nombre= scanner.next();
			
			System.out.println("Ingrese su salario b�sico");
			salario= scanner.nextDouble();
			
			proyecto1.nuevoTrabajador(nombre, salario);
				
			System.out.println("¿Desea ingresar la información de otro trabajador? Si sí ingrese un 1, si no un 0");
			
			if (scanner.nextInt()==1) {
				k++;
			} else if (scanner.nextInt()==0) {
				k=0;
			}
		}
		
		System.out.println(proyecto1.getTrabajadores());
		
		String ubicar="";
		System.out.println("Ingresa el nombre del trabajador que quieres saber: ");
		 ubicar= scanner.next();
		 
			
		
	}
}



