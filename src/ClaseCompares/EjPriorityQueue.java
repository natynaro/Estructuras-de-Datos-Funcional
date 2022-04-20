package ClaseCompares;

import java.util.*;

/*Hacer una clase llamada cliente con una cola de prioridad de manera que primero vayan embarazadas, despues adultos mayores de 60, y después por orden de llegada*/

public class EjPriorityQueue {
	
	public EjPriorityQueue() {
		super();
	}
	
	public Comparator<Persona> compPersonasN= new Comparator<Persona>() {
		public int compare(Persona o1, Persona o2) {
			return o1.getNomb().compareTo(o2.getNomb());
		}
	};
	/*public Comparator<Persona> compPersonasNE= new Comparator<Persona>() {
		public int compare(Persona o1, Persona o2) {
			return (o1.getNomb().compareTo(o2.getNomb()==0)? o1.getEdad()-o2.getEdad(): o1.getNomb().compareTo(o2.getNomb()));
		}
	};*/
	
	public Comparator<Persona> compPersonasE= new Comparator<Persona>() {
		public int compare(Persona o1, Persona o2) {
			return o1.getEdad()-o2.getEdad();
		}
	};
	
	
}

class Comp implements Comparator<Persona>{

	@Override
	public int compare(Persona o1, Persona o2) {
		// TODO Auto-generated method stub
		return o1.getNomb().compareTo(o2.getNomb());
	}
	
}

class Comp2 implements Comparator<Persona>{

	private String tipo;
	public Comp2 (String tipo){
		this.tipo=tipo;
	}
	public int compare(Persona o1, Persona o2) {
		if(tipo.compareTo("nombre")==0) {
			return o1.getNomb().compareTo(o2.getNomb());
		}else {
			return o1.getEdad()-o2.getEdad();
		}
	}
	
}
