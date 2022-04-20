package ClaseCompares;

import java.util.*;

public class mainn {
	public static void main(String[] args) {
    Persona p1= new Persona("Pedro", 24);
    Persona p2= new Persona("Oscar", 21);
    Persona p3= new Persona("Marcela", 20);
    Persona p4= new Persona("Andres", 26);
    Persona p5= new Persona("Andres", 20);
    Persona p6= new Persona("Marcela", 28);
    Persona p7= new Persona("Pedro", 50);
    
    PriorityQueue a= new PriorityQueue();
    PriorityQueue<Persona> pq= new PriorityQueue<Persona>(a.comparator());
     
    while (!pq.isEmpty()) {
    	System.out.println(pq.poll());
    }
    
    
   /* Persona[] listaP= {p1, p2, p3, p4, p5, p6, p7};
    Persona[] listaPp= (Persona[]) Persona.bubbleSort(listaP);
    Persona.printLista(listaPp);
    
    Persona[] listaP2= (Persona[]) Persona.selectionSort(listaP);;
    Persona.printLista(listaP2);
    
    //insertSort
    
    Persona[] listaP3= (Persona[]) Persona.insertSort(listaP);;
    Persona.printLista(listaP3);*/
    
	}
}
