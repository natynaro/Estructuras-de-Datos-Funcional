package Clase2104;

import java.util.Comparator;

import ClaseCompares.Persona;

public class TareaPriorityQueue {
	
	public static int primera=-4;
	public static int primeraE=-3;
	public static int primeraT=-1;
	/*if(o1.getEstado()=="embarazada" && o2.getEstado()=="embarazada"){ //las dos embarazadas, por orden de llegada
		if(o1.getTurno()<o2.getTurno()) {
					return primera-1;
				}else return primera;
	}if(o1.getEstado()=="embarazada" && o2.getEstado()=="normal") { // una embarazada y el otro normal
					return primera;
				
	}
	 
	 */
	//solo comparar los estados, si son iguales los ordeno por orden de llegada, si no ajá
	
	public Comparator<Persona> compPersonasN= new Comparator<Persona>() {
		public int compare(Persona o1, Persona o2) {
			if(o1.getEstado()=="embarazada" && o2.getEstado()=="normal") {
					return primera;
				
			}if(o1.getEdad()>=60 && o2.getEstado()!="embarazada") {
				if(o1.getEdad()-o2.getEdad()>0) {
					return primeraE;
				}else return primeraE+1;
				
			}if(o1.getEstado()=="embarazada" && o2.getEstado()=="embarazada") {
				if(o1.getTurno()<o2.getTurno()) {
					return primera-1;
				}else return primera;
			}
			if(o1.getEstado()!="embarazada" && o1.getEdad()<60 && o2.getEstado()!="embarazada" && o2.getEdad()<60) {
				if(o1.getTurno()<o2.getTurno()) {
					return (int) o1.getTurno();
				}else return (int) o2.getTurno();
							
			}
			/*Hacer una clase llamada cliente con una cola de prioridad de manera que primero vayan embarazadas, despues adultos mayores de 60, y después por orden de llegada*/
			return (int)o1.getTurno();
			
			
		}
	};
}
