package aaaArbolBinarioDeBusqueda;

import java.util.*;

public class ArbolBB <E extends Comparable<E>>{

	protected NodoB<E> raiz;

	
	/*-----------CONSTRUCTOR-----------*/
	
	public ArbolBB() {
		super();
	}

	public ArbolBB(NodoB<E> raiz) {
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
	
	
	/*---------INSERTAR UN NUEVO NODO---------*/
	
		//con el nodo directamente, verificando el orden
	public void insertNodo(NodoB<E> n) throws ExceptionNodo{
		raiz=insertNodo(n, raiz);
		
	}
		
	//con una llave, verificando el orden
	public void insertNodo(E llaveN) throws ExceptionNodo{
		raiz=insertNodo(new NodoB<E>(llaveN), raiz);
	}
		
	//verifica desde la raíz, recursivamente, si debería estar por loss subarboles derechos(la llave es mayor) o los subarboles izquierdos (la llave es menor que la de la raiz)
	protected NodoB<E> insertNodo(NodoB<E> n, NodoB<E> r) throws ExceptionNodo{
		if(r==null) {
		r=n;
		}	else {
			if(n.getLlave().compareTo(r.getLlave())<0)
				r.setHijoIzq(insertNodo(n, r.getHijoIzq()));
			if(n.getLlave().compareTo(r.getLlave())>0) 
				r.setHijoDer(insertNodo(n, r.getHijoDer()));
			if(n.getLlave().compareTo(r.getLlave())==0) 
				throw new ExceptionNodo("El nodo està repetido");
		}
		return r;
	}
	
	
	/*---------BUSCAR NODO---------*/
	
	public NodoB<E> buscar(E llaveN) throws ExceptionNodo{
		return buscar(raiz, llaveN);
	}
	
	public NodoB<E> buscar(NodoB<E> n, E llaveN) throws ExceptionNodo{
		if (n == null)
			throw new ExceptionNodo("No existe un nodo con ese valor");
		if (n.getLlave().compareTo(llaveN) > 0) 
			return buscar(n.getHijoIzq(), llaveN);
		if (n.getLlave().compareTo(llaveN) < 0) 
			return buscar(n.getHijoDer(), llaveN);
		return n;
	}
	
	
	/*---------ELIMINAR NODO---------*/
	
	public void deleteNodo(E llave) throws ExceptionNodo {
		raiz=deleteNodo(llave, raiz);
	}
	
	public NodoB<E>deleteNodo(E llave, NodoB<E> r) throws ExceptionNodo{
		if(r==null) {
			throw new ExceptionNodo("El nodo no se encuentra");
		}else {
			if(llave.compareTo(r.getLlave())<0) {
				r.setHijoIzq(deleteNodo(llave, r.getHijoIzq()));
			}else {
				if(llave.compareTo(r.getLlave())>0) {
					r.setHijoDer(deleteNodo(llave, r.getHijoDer()));
				}else {
					if(r.getHijoDer()!=null && r.getHijoIzq()!=null) {
						NodoB<E> antecesor=buscarAntecesor(r);
						r.setLlave(antecesor.getLlave());
						r.setHijoIzq(deleteNodo(antecesor.getLlave(), r.getHijoIzq()));
					}else {
						if(r.getHijoDer()!=null) {
							r=r.getHijoDer();
						}else {
							r=r.getHijoIzq();
						}
					}
				}
			}
		}
		
		return r;
	}
	
	public NodoB<E> buscarAntecesor(NodoB<E> n)throws ExceptionNodo{
		return(n.getHijoDer()==null)? null:buscarMax(n.getHijoIzq());
	}
	
	public NodoB<E> buscarMax(NodoB<E> n)throws ExceptionNodo{
		return(n.getHijoDer()==null)? n:buscarMax(n.getHijoDer());
	}
	
	
	/*---------ALTURA NODO---------*/
	public int alturaNodo(NodoB<E> n) {
		if (n == null)
			return -1;
		return hojaLejana(n, 0);
	}
		
	//Busca, con base en el nodo que hay que buscar la altura, la hoja más lejana
	public int hojaLejana(NodoB<E> n, int i){ 
		if (n.getHijoDer() != null && n.getHijoIzq() != null) {
			int aux1 = hojaLejana(n.getHijoIzq(), i+1);
			int aux2 = hojaLejana(n.getHijoDer(), i+1);
			return (aux1 > aux2)? aux1: aux2;
		} else if (n.getHijoDer() != null) {
			return hojaLejana(n.getHijoDer(), i+1);
		} else if (n.getHijoIzq() != null) {
			return hojaLejana(n.getHijoIzq(), i+1);
		}
		return i;
	}
	
	
	/*---------COTRUIR CON EL ARRAYLIST PREORDEN EL ABB---------*/
	
	public void construirConPreOrden (ArrayList<E> pre) throws ExceptionNodo {
		raiz = construirConPreOrden(pre, new NodoB<E>(pre.get(0)), 1, pre.size());
	}
	
	public NodoB<E> construirConPreOrden (ArrayList<E> pre, NodoB<E> n, int k, int valMax) throws ExceptionNodo {
		
		raiz = new NodoB<E>(pre.get(0));
		
		for (int i = 1; i < pre.size(); i++) {
			insertNodo(pre.get(i));
		}
		
		return raiz;
		
	}
	
	/*---------CANTIDAD DE HOJAS DEL ABB---------*/
	
	public int cantHojas() {
		return cantHojas(raiz);
	}
	
	public int cantHojas(NodoB<E> n) {
		if (n == null)
			return 0;
		if (n.getHijoDer() == null && n.getHijoIzq() == null)
			return 1;
		return cantHojas(n.getHijoDer()) + cantHojas(n.getHijoIzq());
	}
	
	/*---------HIJOS MINIMOS Y MAXIMOS DEL ABB---------*/
	
	public NodoB<E> getHijoMin(NodoB<E> a){
		if (a.getHijoIzq() == null) 
			return a;
		else return getHijoMin(a.getHijoIzq());
	}
	
	public NodoB<E> getHijoMax(NodoB<E> a){
		if (a.getHijoDer() == null) 
			return a;
		else return getHijoMax(a.getHijoDer());
	}

}

class ExceptionNodo extends Exception{
	
	private static final long serialVersionUID = 1L;

		public ExceptionNodo(String s) {
			super(s);
		}
}



