package Clase2604;

import java.util.*;

import ClaseCompares.Persona;

public class Tarea {
	public static String InfijaPost(String expresion) {
		Stack<Character> pila= new Stack<Character>();
		String result="";
		String operadores="+-/%*!";
		for(int i=0; i<expresion.length(); i++) {
			if(expresion.charAt(i)>='0' && expresion.charAt(i)<='9') {
				result=result+ expresion.charAt(i);
			}else if(expresion.charAt(i)=='+'|| expresion.charAt(i)=='-'|| expresion.charAt(i)=='/'||expresion.charAt(i)=='%'||expresion.charAt(i)=='*'||expresion.charAt(i)=='!'){//operadores.contains(expresion.charAt(i))
				pila.push(expresion.charAt(i));
			}else if(expresion.charAt(i)==')') {
				result= result + pila.pop();
			}
		}
		while(!pila.isEmpty()) {
			result= result + pila.pop();
		}
		return result;
	
	}
	
	public static String PostfijaInf(String expresion) {
		Queue<Character> fila= new LinkedList<Character>();
		String result="";
		String operadores="+-/%*!";
		for(int i=0; i<expresion.length(); i++) {
			if(expresion.charAt(i)>='0' && expresion.charAt(i)<='9') {
				fila.add(expresion.charAt(i));
			}
			if(expresion.charAt(i)=='+'|| expresion.charAt(i)=='-'|| expresion.charAt(i)=='/'||expresion.charAt(i)=='%'||expresion.charAt(i)=='*'||expresion.charAt(i)=='!'){//operadores.contains(expresion.charAt(i))
			result= result+"("+fila.poll()+expresion.charAt(i)+ fila.poll()+")";
			}
		}
		return result;
		
	}
	
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
