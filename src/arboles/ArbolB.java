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
	
	//Me dan el ArrayList del preorden e inorden, devolver el arbol
	
	/*Preorden: Visite la raíz
		Atraviese el sub-árbol izquierdo
		Atraviese el sub-árbol derecho
 
 	Posorden: Atraviese el sub-árbol izquierdo
		Atraviese el sub-árbol derecho
		Visite la raíz

	inorden: Atraviese el sub-árbol izquierdo
		Visite la raíz
		Atraviese el sub-árbol derecho


*/
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
	public int buscarPosNodo(Comparable comparable, ArrayList<E> a) {
		int i=0;
		while(a.get(i).compareTo((E) comparable)!=0) {
			i++;
		}
		if(a.get(i).compareTo((E) comparable)==0) {
			return i;
		}else return -1;
		
	}
	
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
	public void armarArbol2(ArrayList<E>preorden,ArrayList<E>inorden,ArrayList<E> derecha, ArrayList<E> izquierda, ArbolB arbol) {
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
	
	
	//altura de un arbol, altura de un nodo
	
	
	public int alturaArbol() {
		return 0;
		
	}

	
}
