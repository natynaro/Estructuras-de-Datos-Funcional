package aaaColas;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import ClaseCompares.Persona;

public class EjemplosClase {
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
		
		String res="";
		for(int j=0; j<expresion.length(); j++) {
			
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
	
	public Comparator<PersonaQueueQueue> compPersonasN= new Comparator<PersonaQueueQueue>() {
		public int compare(PersonaQueueQueue o1, PersonaQueueQueue o2) {
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
	
	public Comparator<Persona> compPersonasN6= new Comparator<Persona>() {
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
class PersonaQueueQueue implements Comparable<PersonaQueueQueue>{
	
	private String nomb;
	private int edad;
	private final int turno;
	private String estado;
	
	public PersonaQueueQueue(String nomb, int edad, int turno, String estado) {
		
		super();
		this.nomb = nomb;
		this.edad = edad;
		this.turno = turno;
		this.setEstado(estado);
	}
	
	public String getNomb() {
		return nomb;
	}
	
	public void setNomb(String nomb) {
		this.nomb = nomb;
	}
	
	public int getEdad() {
		return edad;
	}
	
	public void setEdad(int edad) {
		this.edad = edad;
	}
	
	
	@Override
	public String toString() {
		return  nomb + "" + edad + "]";
	}

	@Override
	public int compareTo(PersonaQueueQueue o) {
		
		
		
		int dif= edad-o.edad;
		if(dif!=0) return dif;
		return this.nomb.compareTo(o.getNomb());
	}
	/*public int compareTo2(PersonaQueueQueue o) {
		//que si el nombre esta igual o la iedad igual seguir comparando letras
		if(edad-o.getEdad()==0) {
			return 0;
		}
		return edad;
		
	}*/
	
	public static Comparable[] bubbleSort(Comparable[] arr)
    {
        int n = arr.length;
        for (int i = 0; i < n-1; i++)
            for (int j = 0; j < n-i-1; j++)
                if (arr[j+1].compareTo(arr[j])<0)
                {
                    // swap arr[j+1] and arr[j]
                    Comparable temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
    return arr;
    }
	
	public static Comparable[] selectionSort(Comparable[] a) {
		for(int i=0; i<a.length; i++) {
			int im=i;
			for(int j=i+1; j<a.length;j++) {
				if(a[j].compareTo(a[im])<0) {
					im=j;
				}
			Comparable tem=a[i];
			a[i]=a[im];
			a[im]=tem;
			}
		}
		 return a;
	}
	public static Comparable[] insertSort(Comparable[] a) {
		for(int i=1;i<a.length;i++) {
			Comparable temp= a[i];
			int j=i;
			while(j>0 && temp.compareTo(a[j-i])<0) {
				a[j]=a[j-1];
				j--;
			}
			a[j]=temp;
		}
		return a;
	}
	
	public static void printLista(Comparable[] lista) {
		if(lista!=null) {
			String result="";
			for(int i=0; i<lista.length; i++) {
				result= result + lista[i] + " ";
			}
			
		System.out.println(result);
			
		}
	}

	public int getTurno() {
		return turno;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
}
