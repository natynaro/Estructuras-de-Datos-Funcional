package Salario;
import java.util.*;

/*arreglo de trabajadores con la clase que ya tenemos de trabajador*/


public class MainTrabajador {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner (System.in);
		Proyecto proyecto1= new Proyecto();
		String nombre="";
		double salario=0; //el b�sico	
		int k=1;
		
		while(k>0) { 
			//estoy llenando el arreglo de trabajadores en proyecto
			System.out.println("Ingrese su nombre");
			nombre= scanner.next();
			
			System.out.println("Ingrese su salario b�sico");
			salario= scanner.nextDouble();
			
			proyecto1.nuevoTrabajador(nombre, salario);
			
			//ahora voy a llenar su arreglo de días trabajados por mes
			
			double [] diasMeses = new double[12];
			
			for (int j=0; j<12; j++)	{
				System.out.println("Ingrese el número de días que trabajó en el mes " + (j+1)+ " Si no trabajó este mes, ingrese un -1");
				diasMeses[j]= scanner.nextDouble();
				proyecto1.cadaMes(nombre, (j), diasMeses[j]);
				
				//ahora a que haga el método con la fórmula de salario y lo guarde
				double salarioss=proyecto1.nuevoSalario(nombre, (j+1));
			}
			
			//ahora ingresar más trabajadores para saber si seguir o no en el while
			
			System.out.println("¿Desea ingresar la información de otro trabajador? Si sí ingrese un 1, si no un 0");
			
			if (scanner.nextInt()==1) {
				k++;
			} else if (scanner.nextInt()==0) {
				k=0;
			}
		}
		
		//Ahora para probar los otros métodos que hacen búsqueda también
		
		String ubicar="";
		System.out.println("Ingresa el nombre del trabajador que quieres saber su salario promedio: ");
		ubicar= scanner.next();
		System.out.println("El promedio del salario de todos los meses del trabajador"+ nombre + "es: " + proyecto1.promedioTrabajador(nombre));
		
		int mes=0;
		System.out.println("Ingresa el mes del que quieres saber el promedio de todos los trabajadores en ese mes específico (en un número del 1 al 12): ");
		mes= scanner.nextInt();
		
		System.out.println("El promedio de los salarios en el mes "+ mes + "es: " + proyecto1.promedioSalarios(mes));
		
		System.out.println("El salario mínimo es: "+ proyecto1.salarioMinimo());
		
		int posicion=0;
		
		System.out.println("Ingrese el nombre del nuevo trabajador");
		nombre= scanner.next();
		
		System.out.println("Ingrese el salario basico de " + nombre);
		salario= scanner.nextDouble();
		
		System.out.println("Ingrese la posición a la que quiere añadir en la lista a " + nombre);
		posicion=scanner.nextInt();	
		
		//------------------------------------------------------------------------------------------------
		System.out.println(proyecto1.insertarTrabajador(posicion, nombre, salario));
			
		System.out.println("Ingrese el nombre del trabajador que quiere eliminar");
		nombre= scanner.next();
		
		posicion= proyecto1.buscarTrabajador(nombre); //(para el quitar normal)
		System.out.println(proyecto1.quitarTrabajadorRepetido(nombre));
		
		System.out.println("El nombre que va primero alfabéticamente es: " + proyecto1.nombreMenor());
		System.out.println("El nombre que va último alfabéticamente es: " + proyecto1.nombreMayor());
	}
}



