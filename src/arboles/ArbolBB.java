package arboles;
import java.util.*;

class ExceptionNodo extends Exception{
		public ExceptionNodo(String s) {
			super(s);
		}
}
public class ArbolBB <E extends Comparable<E>> extends ArbolB<E>{
	public ArbolBB(NodoB<E> raiz) {
		super(raiz);
	}
	
	public ArbolBB() {
		super(null);
	}
	
	
	public void insertNodo(E llaveN) throws ExceptionNodo{
		raiz=insertNodo(new NodoB<E>(llaveN), raiz);
	}
	
	public void insertNodo(NodoB<E> n) throws ExceptionNodo{
		raiz=insertNodo(n, raiz);
		
	}
	
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
	
	//eliminar nodo y buscar
}
