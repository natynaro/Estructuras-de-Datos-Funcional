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
	
	//lo de armas con los arraylist arbol, LO DE ARRAYLISTS, Y LO DE PROGRAMAR ELIMINACION, ETC
	
	public NodoB<E> buscarNodo(E d) {
		NodoB<E> aux=raiz;
		while(aux.llave!=d) {
			if(d.compareTo(aux.llave)<0) {
				aux= aux.hijoIzq;
			}else {
				aux=aux.hijoDer;
			}if(aux==null) {
				return null;
			}
		}
		return aux;
			
	}
	
	public boolean eliminarNodo(E d) {
		NodoB aux= raiz;
		NodoB padre=raiz;
		boolean esHijoIzq=true;
		while(aux.llave!=d) {
			padre= aux;
			if(d.compareTo((E) aux.llave)<0) {
				esHijoIzq=true;
				aux= aux.getHijoIzq();
			}else {
				esHijoIzq=false;
				aux= aux.getHijoDer();
			}
			if(aux==null) {
				return false;
			}
		}
		if(aux.getHijoIzq()== null && aux.getHijoDer()==null) {
			if(aux==raiz) {
				raiz=null;
			}else if(esHijoIzq) {
				padre.hijoIzq=null;
			}else {
				padre.hijoDer=null;
			}
		}else if(aux.hijoDer==null) {
			if(aux==raiz) {
				raiz=aux.hijoIzq;
			}else if(esHijoIzq) {
				padre.hijoIzq=aux.hijoIzq;
			}else {
				padre.hijoDer=aux.hijoIzq;
			}
		}else if(aux.hijoIzq==null) {
			if(aux==raiz) {
				raiz=aux.hijoDer;
			}else if(esHijoIzq) {
				padre.hijoIzq=aux.hijoDer;
			}else {
				padre.hijoDer=aux.hijoDer;
			}
		}else {
			NodoB reemplazo=ObtenerNodoReemplazo(aux);
			if(aux==raiz) {
				raiz=reemplazo;
			}else if(esHijoIzq) {
				padre.hijoIzq=reemplazo;
			}else {
				padre.setHijoDer(reemplazo);
			}
			reemplazo.hijoIzq=aux.hijoIzq;
		}
		return true;
		
	}
	private NodoB<E> ObtenerNodoReemplazo(NodoB nodoReemp) {
		NodoB rempPadre= nodoReemp;
		NodoB remplazo= nodoReemp;
		NodoB aux= nodoReemp.getHijoDer();
		
		while(aux!=null) {
			rempPadre= remplazo;
			remplazo=aux;
			aux=aux.getHijoIzq();
		}
		if(remplazo!=nodoReemp.hijoDer) {
			rempPadre.setHijoIzq(remplazo.hijoDer);
			remplazo.setHijoDer(nodoReemp.hijoDer);
		}
		return remplazo;
	}
	
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
		return(n.getHijoIzq()==null)? null:buscarMax(n.getHijoIzq());
	}
	
	public NodoB<E> buscarMax(NodoB<E> n)throws ExceptionNodo{
		return(n.getHijoDer()==null)? n:buscarMax(n.getHijoDer());
	}
}
