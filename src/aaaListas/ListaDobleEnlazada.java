package aaaListas;

public class ListaDobleEnlazada<E extends Comparable<E>>  {
	
	NodoD<E> cabeza; 
	
	public ListaDobleEnlazada() {
		cabeza=null;
	}
	
	public ListaDobleEnlazada(NodoD<E> d) {
		cabeza=d;
	}
	
	/*-------GETTERS Y SETTERS DE LA CABEZA--------*/
	
	public NodoD<E> getCabeza() {
		return cabeza;
	}

	public void setCabeza(NodoD<E> cabeza) {
		this.cabeza = cabeza;
	}

	/*------insertar un nuevo elemento en la cabeza de una lista doble-------*/
	public void insertarCabezaLista(E entrada){ 
		NodoD<E> nuevo= (NodoD<E>) new NodoD<E>(entrada); 
		
		if (cabeza != null ) {
			nuevo.setAdelante(cabeza);
			cabeza.setAtras(nuevo);
			cabeza = nuevo;
			}
	} 
	
	/*------inserción despues de un nodo-------*/
	public void insertaDespues(NodoD<E> anterior, E entrada) { 
		
		NodoD<E> nuevo= new NodoD<E>(entrada); 
		 
		if (anterior.getAdelante() != null) {
			nuevo.setAdelante(anterior.getAdelante());
			anterior.setAdelante(nuevo);
			nuevo.setAtras(anterior);
			anterior.getAdelante().setAtras(nuevo);
			}
	}
	/*------Eliminar un elemento-------*/
	
	public void eliminar (E entrada){ 
		NodoD<E> actual=cabeza;
		boolean encontrado = false;
	
		// Bucle de búsqueda
		while ((actual != null) && (!encontrado)) {
			encontrado = (actual.getInfo() == entrada); 
			if (!encontrado)
				actual = actual.getAdelante();
		}
		
		// Enlace de nodo anterior con el siguiente
		if (actual != null){ 
		
			//distingue entre nodo cabecera o resto de la lista 
			if (actual == cabeza) { 
				cabeza = actual.getAdelante(); 
				if (actual.getAdelante() != null)
					actual.getAdelante().setAtras(null);
			}else if (actual.getAdelante() != null) // No es el último nodo
				{ 
				actual.getAtras().setAdelante(actual.getAdelante());
				actual.getAdelante().setAtras(actual.getAtras());
				}
			else {// último nodo 
				actual.getAtras().setAdelante(null);
				actual = null;
			}
		} 
	}
	
	/*------VIZUALIZACION-------*/
	
	public void printList(){
		NodoD<E> actual=cabeza;
		while (actual!=null){
			System.out.print(actual.getInfo()+" ");
			actual=actual.getAdelante();
		}
		System.out.println();
	}
	
	/*------BUSCAR-------*/
	
	public int getIndex(E x) {
        int i = 0;
        NodoD<E> tmp = cabeza;
        while 	(tmp != null && ((Comparable<E>) tmp.getInfo()).compareTo(x)!=0) {
            tmp = tmp.getAdelante();
            i++;
        }
        return ((tmp != null) ? i : -1);
    }
	
	/*-----------NODO EN ESA POSICION-----------*/
	
	public NodoD<E> getNodo(int i) {
        NodoD<E> tmp = cabeza;
        int j=0;
        while 	(tmp != null && j<i) {
            tmp = tmp.getAdelante();
            j++;
        }
        return ((tmp != null) ? tmp : null);
    }
	
	/*-----------¿eSTÁ VACÍA?-----------*/
	public boolean isEmpty(){
		return cabeza==null;
	}
	
	/*-----------TAMAÑO-----------*/
	public int length(){
		int l=0;
		NodoD<E> temp=cabeza;
		while(temp!=null){
			temp=temp.getAdelante();
			l++;
		}
		return l;
	}
	
}

class NodoD<E>{
	private E Info;
	private NodoD<E> adelante; 
	private NodoD<E> atras;
	
	
	public E getInfo() {
		return Info;
	}
	public void setInfo(E info) {
		Info = info;
	}
	public NodoD<E> getAdelante() {
		return adelante;
	}
	public void setAdelante(NodoD<E> adelante) {
		this.adelante = adelante;
	}
	public NodoD<E> getAtras() {
		return atras;
	}
	public void setAtras(NodoD<E> atras) {
		this.atras = atras;
	}
	/*-----------CONSTRUCTOR-----------*/
	public NodoD(E info) {
		super();
		Info = info;
		adelante= null;
		atras=null;
	}

	public String toString() {
		return Info.toString();
	}
	
}