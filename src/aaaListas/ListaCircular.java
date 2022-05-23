package aaaListas;

public class ListaCircular <E extends Comparable<E>>{
	
	private NodoC<E> lc;
	
	/*-----------CONSTRUCTOR-----------*/
	public ListaCircular(){ 
		lc = null;
	}
	
	/*-----------Insertar un elemento-----------*/
	public void insertar(E entrada){ 
		NodoC<E> nuevo;
		nuevo = new NodoC<E>(entrada);
		if (lc != null) { // lista circular no vacía 
			nuevo.setNext(lc.getNext());
		} 
		lc.setNext(nuevo);
		lc = nuevo; 
	}
	
	/*-----------Eliminar un elemento-----------*/
	
	public void eliminar(E entrada){ 
		NodoC<E> actual=lc;
		boolean encontrado = false;
		//bucle de búsqueda
		while ((actual.getNext()!= lc) && (!encontrado)){ 
			encontrado = (actual.getNext().getInfo() == entrada); 
			if (!encontrado) { 
				actual = actual.getNext(); 
			}
		}
		encontrado = (actual.getNext().getInfo() == entrada); 
	
		// Enlace de nodo anterior con el siguiente 
		if (encontrado) {
			NodoC<E> p;
			p = actual.getNext(); // Nodo a eliminar
			if (lc == lc.getNext()) // Lista con un solo nodo
				lc = null; 
			else{ 
				if (p == lc){ 
					lc = actual; // Se borra el elemento referenciado por lc, 
				} // el nuevo acceso a la lista es el anterior
				}
			actual.setNext(p.getNext());  
			p = null;
		} 
	}
	
	/*-----------recorrer una lista circular-----------*/
	public void recorrer(){ 
		NodoC<E> p;
		if (lc != null){ 
			p = lc.getNext(); // siguiente nodo al de acceso 
			do {
				System.out.println("\t" + p.getInfo());
				p = p.getNext();
			}while (p != lc.getNext());
		}
		else
			System.out.println("\t Lista Circular vacía.");
	}
	
	/*-----------Borrar una lista circular-----------*/
	
	public void borrarLista(){ 
		NodoC<E> p;
		if (lc != null){ 
			p = lc; 
			do {
				NodoC<E> t= p;
				p = p.getNext();
				t = null; // no es estrictamente necesario
			}while(p != lc); 
		}else
			System.out.println("\n\t Lista vacía.");
		lc = null;
	}
	
	
	
	
}
class NodoC<E>{
	private E Info;
	private NodoC<E> next;
	
	public E getInfo() {
		return Info;
	}
	public void setInfo(E info) {
		Info = info;
	}
	public NodoC<E> getNext() {
		return next;
	}
	public void setNext(NodoC<E> next) {
		this.next = next;
	}
	/*-----------CONSTRUCTOR-----------*/
	public NodoC(E info) {
		super();
		Info = info;
		next = this;
	}
	@Override
	public String toString() {
		return Info.toString();
	}
	
}