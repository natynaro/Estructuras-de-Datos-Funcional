package aaaColas;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

import Clase2604.TareaPriorityQueue;
import ClaseCompares.Persona;

public class MainColas {

	public static void main(String[] args) {
	
		/*--------QUEUE COMO LINKEDLIST----------*/
		Queue<String> queue2 = new LinkedList<String>();
		queue2.add("a");
		
		/*Una cola es una estructura de datos que almacena elementos en una lista y 
		 * permite acceder a los datos por uno de los dos extremos de la lista (Figura 
		 * 10.1). Un elemento se inserta en la cola (parte final) de la lista y se 
		 * suprime o elimina por el frente (parte inicial, frente) de la lista.*/
	
		
		/*Operaciones:
		 	- add
		 	- poll
		 	- peek
		 	- isEmpty*/
		
		
		/*--------PRIORITY QUEUE CON PERSONAS----------*/
		PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
		
		EjemplosClase b= new EjemplosClase(); //Acá está el compareTo
		 PriorityQueue<PersonaQueueQueue> pq= new PriorityQueue<PersonaQueueQueue>(b.compPersonasN);
	}

}
