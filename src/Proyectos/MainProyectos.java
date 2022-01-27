package Proyectos;
import java.util.*;

public class MainProyectos {

	public static void main(String[] args) {
		
		Proyectos[] proyectos = new Proyectos[20];
		int[] meses = new int[12];
		Scanner scanner = new Scanner (System.in);
		
		//LLENADO DE PROYECTOS 
		 for (int i=0; i<proyectos.length; i++) {
				
				for (int k=0; k<meses.length; k++) {
					System.out.println("Ingresa las horas trabajadas del proyecto" + (i+1) + " en el " + (k+1) + " mes:");		
					meses[k]= scanner.nextInt();
				}
				
				proyectos[i]= new Proyectos(i, meses); 
			}
		 
		 Proyectos.setProyectos(proyectos);
		 
		 int ubicar=0;
		 System.out.println("Ingresa qué proyecto quieres saber del 1 al 20: ");
		 
		 
		 ubicar= (scanner.nextInt()-1);
		 
		 proyectos[ubicar].horasMes(ubicar);
		 proyectos[ubicar].horasTotalesProyecto(ubicar);
		 proyectos[ubicar].totalProyectos();
		 
		 

	}

}
