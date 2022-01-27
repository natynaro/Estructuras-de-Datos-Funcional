package Proyectos;
import java.util.*;

public class Proyectos {
	
	//metodo que devuelva el salario mínimo de los trabajadores
	
	//scanner no puede estar acá al parecer

	private double horasTotal;
	private int numProyect;
	private int[] meses = new int[12];
	static Proyectos[] proyectos = new Proyectos[20]; //ESTAS VARIABLES CREO QUE LAS PUEDO QUITAR, O CREO QUE NO
	
	Scanner scanner = new Scanner (System.in);
	
	
	public Proyectos(int numProject, int[] mesHoras) {
		this.numProyect=numProject;
		this.meses=mesHoras;
	}

	
		public int[] getMeses() {
		return meses;
	}


	public void setMeses(int[] meses) {
		this.meses = meses;
	}

		public static Proyectos[] getProyectos() {
		return proyectos;
	}


	public static void setProyectos(Proyectos[] proyectos) {
		Proyectos.proyectos = proyectos;
	}


		public double getHorasTotal() {
		return horasTotal;
	}



	public void setHorasTotal(double horasTotal) {
		this.horasTotal = horasTotal;
	}



	public int getNumProyect() {
		return numProyect;
	}



	public void setNumProyect(int numProyect) {
		this.numProyect = numProyect;
	}


	
	/*/llenado de proyectos QUÍTALO DE ACÁ

		public void LlenadoProyectos (){
			
			for (int i=0; i<proyectos.length; i++) {
				
				for (int k=0; k<meses.length; k++) {
					System.out.println("Ingresa las horas trabajadas del proyecto" + (i+1) + " en el " + (k+1) + " mes:");		
					meses[i]= scanner.nextInt();
				}
				
				proyectos[i]= new Proyectos(i, meses); //decir que i es numproject
			}
		}*/
	
	//sumar las horas totales y ponerla en la variable y devolverla
	
	public int horasTotalesProyecto(int numProject) { 
		
		int total=0;
		int[] proyPedido = proyectos[numProject].meses;
		
		for (int i=0; i<proyPedido.length; i++){
			total= total + proyPedido[i]; //decir que esto es this.horasTotal
		}
		
		System.out.println("El total de horas de este proyecto es " + total);
		
		return total;
	}
	
	//horas al mes
	
	public void horasMes(int numProject) {
		
		int[] proyPedido = proyectos[numProject].meses;
		
		for (int i=0; i<proyPedido.length; i++) {
			System.out.println("En el mes " + (i+1) + " las horas fueron " + proyPedido[i]);
		}
	
		
	}
	
	//total horas todos proyectos
	
	public int totalProyectos() {
		
		int total=0;
		
		for (int i=0; i<proyectos.length; i++) {
			//pedir el get horasTotal de cada proyecto  y sumarlo
			total = total + proyectos[i].horasTotalesProyecto(i);
		}
		
		System.out.println("El total de horas de todos los proyectos es " + total);
		
		return total;
		
	}
	
	
	
	
}
