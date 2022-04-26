package Clase2604;

import java.util.Comparator;

import ClaseCompares.Persona;

public class TareaPriorityQueue {
	
	public Comparator<Persona> compPersonasN= new Comparator<Persona>() {
		public int compare(Persona o1, Persona o2) {
			if(o1.getEstado()=="embarazada" && o2.getEstado()=="normal") {
					return -90;
				
			}if(o1.getEdad()>=60 && o2.getEstado()!="embarazada") {
				if(o1.getEdad()-o2.getEdad()>0) {
					return -2;
				}else return -1;
				
			}
			else {

				return (int) o1.getTurno();
						
			}
			/*Hacer una clase llamada cliente con una cola de prioridad de manera que primero vayan embarazadas, despues adultos mayores de 60, y después por orden de llegada*/
			
		}
	};
}
