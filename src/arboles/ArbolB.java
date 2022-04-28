package arboles;

import java.util.ArrayList;

public class ArbolB <E extends Comparable<E>>{
	protected NodoB<E> raiz;

	public NodoB<E> getRaiz() {
		return raiz;
	}

	public void setRaiz(NodoB<E> raiz) {
		this.raiz = raiz;
	}

	public ArbolB() {
		super();
	}

	public ArbolB(NodoB<E> raiz) {
		super();
		this.raiz = raiz;
	}
	
	public void preorden() {
		preorden(raiz);
		System.out.println();
			
	}
	public void preorden(NodoB<E> r) {
		if(r!=null) {
			System.out.println(r.getLlave()+" ");
			preorden(r.getHijoIzq());	
			preorden(r.getHijoDer());
		}
	}
	
	public void posorden() {
		posorden(raiz);
		System.out.println();
	}
	public void posorden(NodoB<E> r) {
		if(r!=null) {
			posorden(r.hijoIzq);
			preorden(r.getHijoDer());
			System.out.println(r.getLlave()+" ");
		}
		
	}
	
	public void inorden() {
		inorden(raiz);
		System.out.println();
	}
	public void inorden(NodoB<E> r) {
		if(r!=null) {
			inorden(r.hijoIzq);
			System.out.println(r.getLlave()+" ");
			inorden(r.getHijoDer());
		}	
	}
	
	//Hacer todo esto pero ponerlo en un arrayList
	
	public ArrayList preorden2() {
		preorden(raiz);
		System.out.println();
		return null;
			
	}
	public NodoB<E> preorden2(NodoB<E> r) {
		if(r!=null) {
			System.out.println(r.getLlave()+" ");
			preorden(r.getHijoIzq());	
			preorden(r.getHijoDer());
		}
		return r;
	}
	
	public ArrayList posorden2() {
		posorden(raiz);
		System.out.println();
		return null;
	}
	public NodoB<E> posorden2(NodoB<E> r) {
		if(r!=null) {
			posorden(r.hijoIzq);
			preorden(r.getHijoDer());
			System.out.println(r.getLlave()+" ");
		}
		return r;
		
	}
	
	public ArrayList inorden2() {
		inorden(raiz);
		System.out.println();
		return null;
	}
	public NodoB<E> inorden2(NodoB<E> r) {
		if(r!=null) {
			inorden(r.hijoIzq);
			System.out.println(r.getLlave()+" ");
			inorden(r.getHijoDer());
		}
		return r;	
	}
	
	
	
	//Me dan el ArrayList del preorden e inorden, devolver el arbol
	
	public ArbolB armarArbol(ArrayList<E> Preorden, ArrayList<E> Inorden) {
		NodoB raiz= new NodoB(Preorden.get(0));
		ArbolB arbolB= new ArbolB(raiz);
		return armarArbol2(Preorden, Inorden, arbolB);
		
		
	}
	public ArbolB armarArbol2(ArrayList<E> Preorden, ArrayList<E> Inorden, ArbolB Arbol) {
		return Arbol;	
		
	}
	
}
