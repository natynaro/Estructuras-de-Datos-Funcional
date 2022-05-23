package aaaListas;

import java.util.Iterator;

public class GenericList <T extends Comparable<T>>{
	
	private Nodo<T> nodo;
	private int tamano;

/*-----------CONSTRUCTOR-----------*/
	
	public GenericList() {
		tamano = 0;
		nodo=null;
	}
	
/*---------GETTERS AND SETTERS---------*/
	
	public Nodo<T> getNodo() {
		return nodo;
	}

	public void setNodo(Nodo<T> nodo) {
		this.nodo = nodo;
	}

	public int getTamano() {
		return tamano;
	}

	public void setTamano(int tamano) {
		this.tamano = tamano;
	}

	
/*-----------TAMAÑO DE LA LISTA-----------*/
	public int size() {
		return tamano;
	}
		
/*-----------AÑADIR NODO CON INFO GENERICA-----------*/
	
	public void add(T elemento) {
		if(nodo == null) { //Primer caso donde se crea el primer nodo
			nodo = new Nodo<T>(elemento);
			tamano++;
		}else {
			Nodo<T> temporal = nodo;
			while(temporal.tieneCabecera()) {
				temporal = nodo.getCabecera();
			}
			temporal.setCabecera(elemento);
			tamano++;
		}
	}	

/*-----------AÑADIR NODO CON INFO GENERICA EN CIERTA POSICION-----------*/
	
	public void insert(T elemento, int posicion) {
		if(posicion < size()) {
			//En caso de insertar de primero
			Nodo<T> temporal;
			if(posicion == 0) {
				temporal = new Nodo<T>(elemento);
				temporal.setCabecera(nodo);
				nodo = temporal;
				tamano++;
			}
			else {
				int temporalContador=0;
				temporal = nodo;
				while(temporalContador+1<posicion) {
					temporal = temporal.getCabecera();
					temporalContador++;
				}
				Nodo<T> temporal2 = new Nodo<T>(elemento);
				temporal2.setCabecera(temporal.getCabecera());
				temporal.setCabecera(temporal2);
				tamano++;
			}
		}
	}

/*-----------ELIMINAR LISTA (VACIARLA)-----------*/
	
	public void clear() {
		nodo = null;
		tamano = 0;
	}
	
/*-----------¿ESTÁ VACÍA?-----------*/
	
	public boolean empty() {
		return (tamano == 0) ? true:false;
	}

/*-----------OBTENER LA POS DE CIERTO ELEMENTO-----------*/
	
	public int getIndex(T elemento) {
		int index = 0;
		Nodo<T> temporal = nodo;
		while(index < size() && temporal.getCuerpo().compareTo(elemento) != 0) {
			temporal = temporal.getCabecera();
			index++;
		}
		return (temporal != null && temporal.getCuerpo().compareTo(elemento)==0) ? index:-1;
	}
	
/*-----------OBTENER OBJETO EN X POSICION-----------*/
	
	public T getObject(int index) {
		if(index < size() && index>=0) {
			Nodo<T> temporal = nodo;
			int indexAux = 0;
			while(indexAux< index ) {
				temporal = temporal.getCabecera();
				indexAux++;
			}
			return temporal.getCuerpo();
		}
		else {
			return null;
		}
	}
	
/*-----------ELIMINAR ELEMENTO EN CIERTA POSICION-----------*/

	public void remove(int index) {
		if(index < size() && index>=0) {
			int temporalContador=0;
			Nodo<T> temporal = nodo;
			while(temporalContador+1<index) {
				temporal = temporal.getCabecera();
				temporalContador++;
			}
			if (temporal.getCabecera().getCabecera() !=null) {
				temporal.setCabecera(temporal.getCabecera().getCabecera());
				tamano--;
			}
			else { //Es el ultimo
				temporal.deleteCabecera();
				tamano--;
			}
		}
	}
	
/*-----------¿EXISTE ESTE OBJETO?-----------*/
	
	public boolean contains(T object) {
		return (getIndex(object) != -1) ? true:false;
	}

/*-----------IMPRIMIR LISTA-----------*/
	
	public void printLista() {
		Nodo<T> temporal = nodo;
		while(temporal.tieneCabecera()) {
			System.out.println(temporal.getCuerpo());
			temporal = temporal.getCabecera();
		}
		System.out.println(temporal.getCuerpo());
	}
	
/*-----------ITERATOR-----------*/
	 
	public Iterator<T> iterator() {
		return this.iterator();
		 
	 }
}

class Nodo<T>{
	
	private T cuerpo;//LA INFO
	private Nodo<T> cabecera;//EL SIGUIENTE

	 public Nodo() {
     	cuerpo=null;
     	cabecera=null;
     }
	 
	public Nodo(T cuerpo) {
		this.cuerpo = cuerpo;
	}
	public Nodo(T cuerpo, Nodo<T> n) {
		this.cuerpo = cuerpo;
		this.cabecera = n;
	}
	
	public T getCuerpo() {
		return cuerpo;
	}

	public void setCuerpo(T cuerpo) {
		this.cuerpo = cuerpo;
	}

	public Nodo<T> getCabecera() {
		return cabecera;
	}

	public void setCabecera(T elemento) {
		cabecera = new Nodo<T>(elemento);
	}
	public void setCabecera(Nodo<T> n) {
		cabecera = n;
	}
	public void deleteCabecera() {
		cabecera = null;
	}

	public boolean tieneCabecera() {
		return (this.getCabecera() != null) ? true:false;
	
	}


}

class ListIterador <T extends Comparable<T>>{
	private Nodo<T> prm, actual;
	
	public ListIterador(GenericList<T> list){ 
		
		prm = actual = list.getNodo(); 
		
	}
	
	public T siguiente(){ 
		T elemento = null; 
		if (actual != null){ 
			elemento = actual.getCuerpo();
			actual= actual.getCabecera();
		} 
		return elemento;
	}
	public void inicIter(){ 
		actual = prm; 
	}
}