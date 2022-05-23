package aaaArbolBinario;

import java.util.*;


public class ArbolB <E extends Comparable<E>>{
	
	protected NodoB<E> raiz;

	/*-----------CONSTRUCTOR-----------*/
	
	public ArbolB() {
		super();
	}

	public ArbolB(NodoB<E> raiz) {
		super();
		this.raiz = raiz;
	}
	
	
	/*---------GETTERS AND SETTERS DE LA RAÍZ---------*/
	
	public NodoB<E> getRaiz() {
		return raiz;
	}

	public void setRaiz(NodoB<E> raiz) {
		this.raiz = raiz;
	}

	/*---------ALTURA DEL ARBOL---------*/
	
	public int alturaArbol() {
		
		return (raiz==null)? -1:raiz.alturaNodo(raiz);
		
	}
	
	/*---------BUSCAR NODO CON LLAVE---------*/
	
	public NodoB<E> buscarNodo(E d) {
		NodoB aux=raiz;
		while(aux.llave!=d) {
			if(d.compareTo((E) aux.llave)<0) {
				aux= aux.hijoIzq;
			}else {
				aux=aux.hijoDer;
			}if(aux==null) {
				return null;
			}
		}
		return aux;	
	}
	
	/*-----------RECORRIDOS DEL ÁRBOL-----------*/
	
	// PREORDEN: visita la raíz, luego el subarbol izquierdo en preorden y después el subarbol derecho en preorden
	
		//Con Sysout
	
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
	
		//Con arraylist
	
	public ArrayList preorden2() {
		ArrayList<E> arbolPreorden = new ArrayList<E>();
		arbolPreorden= preorden2(raiz, arbolPreorden);
		return arbolPreorden;
			
	}
	
	public ArrayList preorden2(NodoB<E> r, ArrayList a) {
		
		if(r!=null) {
			a.add(r.getLlave());
			preorden2(r.getHijoIzq(), a);	
			preorden2(r.getHijoDer(), a);
		}
		return a;
	}

	
	// POSTORDEN: visita el subarbol izquierdo en postorden, luego el subarbol derecho en postorden y por  último la raíz
	
		//Con Sysout
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
	
		//Con arraylist
	
	public ArrayList posorden2() {
		ArrayList<E> arbolPosorden = new ArrayList<E>();
		arbolPosorden= posorden2(raiz, arbolPosorden);
		return arbolPosorden;
	}
	
	public ArrayList  posorden2(NodoB<E> r, ArrayList a) {
		if(r!=null) {
			posorden2(r.hijoIzq, a);
			preorden2(r.getHijoDer(), a);
			a.add(r.getLlave());
		}
		return a;
		
	}
	
	
	// INORDEN: visita el subarbol izquierdo en inorden, visita la raíz y luego el subarbol derecho en inorden 
	
		//Con Sysout
		
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
	
		//Con arraylist
	
	public ArrayList inorden2() {
		ArrayList<E> arbolInorden = new ArrayList<E>();
		arbolInorden= inorden2(raiz, arbolInorden);
		return arbolInorden;
	}
	
	public ArrayList inorden2(NodoB<E> r, ArrayList a) {
		if(r!=null) {
			inorden2(r.hijoIzq, a);
			a.add(r.getLlave());
			inorden2(r.getHijoDer(), a);
		}
		return a;	
	}
	
	
/*---------BUSCAR POSICION DEL NODO EN UN ARRAYLIST CON CIERTA LLAVE---------*/
	
	public int buscarPosNodo(Comparable comparable, ArrayList<E> a) {
		int i=0;
		while(a.get(i).compareTo((E) comparable)!=0) {
			i++;
		}
		if(a.get(i).compareTo((E) comparable)==0) {
			return i;
		}else return -1;
		
	}
	
	/*---------CON UN ARRAYLIST DEL PREORDEN E INORDEN, ARMAR EL ÁRBOL---------*/
	
	public ArbolB armarArbol(ArrayList<E> preorden, ArrayList<E> inorden) {
		NodoB raiz= new NodoB(preorden.get(0));
		
		ArbolB arbolB= new ArbolB(raiz);
		
		//return armarArbol2(Preorden, Inorden, arbolB);
		NodoB aux=arbolB.getRaiz();
		
		int pos= buscarPosNodo(aux.getLlave(), inorden);
		
		ArrayList<E> izquierdaI = null;
		for(int i=0; i<pos;i++){
			izquierdaI.add(inorden.get(i));
		}
		ArrayList<E> derechaI = null;
		for(int i=pos+1; i<inorden.size();i++){
			derechaI.add(inorden.get(i));
		}
		
		armarArbol2(preorden, inorden,derechaI, izquierdaI, arbolB);
		
		return arbolB;
		
	}
	
	public void armarArbol2(ArrayList<E>preorden,ArrayList<E>inorden,ArrayList<E> derecha, ArrayList<E> izquierda, ArbolB<E> arbol) {
		NodoB aux=arbol.getRaiz();
		
		if(derecha.size()==1) {
			NodoB n= new NodoB(derecha.get(0));
			aux.setHijoDer(n);
		}if(izquierda.size()==1) {
			NodoB n= new NodoB(izquierda.get(0));
			aux.setHijoIzq(n);
		}else {
			
			int pos= buscarPosNodo(aux.getLlave(), inorden);
			ArrayList<E> izquierdaI = null;
			for(int i=0; i<pos;i++){
				izquierdaI.add(inorden.get(i));
			}
			ArrayList<E> derechaI = null;
			for(int i=pos+1; i<inorden.size();i++){
				derechaI.add(inorden.get(i));
			}
			
			ArrayList<E> izquierdaP = null;
			for(int i=0; i<pos;i++){
				izquierdaP.add(preorden.get(i));
			}
			ArrayList<E> derechaP = null;
			for(int i=pos+1; i<preorden.size();i++){
				derechaP.add(preorden.get(i));
			}
			
			armarArbol2(preorden, inorden,izquierdaP, izquierdaI, arbol);
			armarArbol2(preorden, inorden,derechaI,derechaP, arbol);


		}
		
	}
	
	
	//arraylist Preorden en un arbol binario de busqueda, hacer el arbol.  

	
}

