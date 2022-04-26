package Clase2104;

import java.util.Comparator;
import java.util.PriorityQueue;

import Clase2604.TareaPriorityQueue;
import ClaseCompares.Persona;

public class mainPriorityQueue {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Persona p9= new Persona("Alex", 50, 1, "normal");
		Persona p1= new Persona("Santi", 24,8, "normal");
	    Persona p2= new Persona("Oscar", 21, 2, "normal");
	    Persona p3= new Persona("Marcela", 20, 3, "embarazada");
	    Persona p4= new Persona("Andres", 70,4, "normal");
	    Persona p5= new Persona("Pepa", 90,5, "normal");
	    Persona p6= new Persona("Marcela", 28, 6, "embarazada");
	    Persona p7= new Persona("Pedro", 70, 7, "normal");
	    
	    PriorityQueue a= new PriorityQueue();
	    TareaPriorityQueue b= new TareaPriorityQueue();
	    PriorityQueue<Persona> pq= new PriorityQueue<Persona>(b.compPersonasN);
	     pq.add(p7);
	     pq.add(p6);
	     pq.add(p5);
	     pq.add(p4);
	     pq.add(p3);
	     pq.add(p2);
	     pq.add(p1);
	     pq.add(p9);
	    System.out.println(pq.toString());
}

}
