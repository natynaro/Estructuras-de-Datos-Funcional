package aaaArbolBinarioAVL;

import java.util.*;

public class ArbAVL <E extends Comparable<E>>{
	
	private NodoAVL<E> raiz;
	
	
	/*-----------CONSTRUCTOR-----------*/
	
	public ArbAVL() {
		raiz=null;
	}
	
	public ArbAVL(NodoAVL<E>n) {
		raiz=n;
	}
	
	/*---------GETTERS AND SETTERS DE LA RAÍZ---------*/
	
	public NodoAVL<E> getRaiz() {
		return raiz;
	}

	public void setRaiz(NodoAVL<E> raiz) {
		this.raiz = raiz;
	}

	
	/*---------BUSCAR NODO---------*/
	
	public NodoAVL<E> buscar(E llaveN) throws ExceptionNodo{
		return buscar(raiz, llaveN);
	}
	
	public NodoAVL<E> buscar(NodoAVL<E> n, E llaveN) throws ExceptionNodo{
		if (n == null)
			throw new ExceptionNodo("No existe un nodo con ese valor");
		if (n.getLlave().compareTo(llaveN) > 0) 
			return buscar(n.getHijoI(), llaveN);
		if (n.getLlave().compareTo(llaveN) < 0) 
			return buscar(n.getHijoD(), llaveN);
		return n;
	}	
	
	
	/*---------ALTURA NODO---------*/
	public int alturaNodo(NodoAVL<E> n) {
		if (n == null)
			return -1;
		return hojaLejana(n, 0);
	}
		
	//Busca, con base en el nodo que hay que buscar la altura, la hoja más lejana
	public int hojaLejana(NodoAVL<E> n, int i){ 
		if (n.getHijoD() != null && n.getHijoI() != null) {
			int aux1 = hojaLejana(n.getHijoI(), i+1);
			int aux2 = hojaLejana(n.getHijoD(), i+1);
			return (aux1 > aux2)? aux1: aux2;
		} else if (n.getHijoD() != null) {
			return hojaLejana(n.getHijoD(), i+1);
		} else if (n.getHijoI() != null) {
			return hojaLejana(n.getHijoI(), i+1);
		}
		return i;
	}
	
	
	/*---------CANTIDAD DE HOJAS DEL ABB---------*/
	
	public int cantHojas() {
		return cantHojas(raiz);
	}
	
	public int cantHojas(NodoAVL<E> n) {
		if (n == null)
			return 0;
		if (n.getHijoD() == null && n.getHijoI() == null)
			return 1;
		return cantHojas(n.getHijoD()) + cantHojas(n.getHijoI());
	}
	
	
	/*---------HIJOS MINIMOS Y MAXIMOS DEL AVL---------*/
	
	public NodoAVL<E> getHijoMin(NodoAVL<E> a){
		if (a.getHijoI() == null) 
			return a;
		else return getHijoMin(a.getHijoI());
	}
	
	public NodoAVL<E> getHijoMax(NodoAVL<E> a){
		if (a.getHijoD() == null) 
			return a;
		else return getHijoMax(a.getHijoD());
	}
	
	
	/*---------FACTOR DE EQUILIBRIO DEL NODO---------*/ //recordar fep = altHijoDer - altHijoIzq;
	
	public int FEP(NodoAVL<E> n){
		return n.getHijoD().altura()-n.getHijoI().altura();
	}
	
	/*---------INSERTAR NODO SIN DESEQUILIBRAR---------*/
	
	public void insertNodo(E llaveN) throws ExceptionNodo{
		NodoAVL<E> a=new NodoAVL<E>(llaveN);
		raiz=insertNodo(a, raiz);
		balancear(a);
	}
	
	public void insertNodo(NodoAVL<E> n) throws ExceptionNodo{
		raiz=insertNodo(n, raiz);
		NodoAVL<E> a = n;
		balancear(a);
	}
	
	protected NodoAVL<E> insertNodo(NodoAVL<E> n, NodoAVL<E> r) throws ExceptionNodo{
		if(r==null) {
		r=n;
		}	else {
			if(n.getLlave().compareTo(r.getLlave())<0)
				r.setHijoI(insertNodo(n, r.getHijoI()));
			if(n.getLlave().compareTo(r.getLlave())>0) 
				r.setHijoD(insertNodo(n, r.getHijoD()));
			if(n.getLlave().compareTo(r.getLlave())==0) 
				throw new ExceptionNodo("El nodo està repetido");
		}
		return r;
	}
	
	
	/*---------BORRAR NODO SIN DESEQUILIBRAR---------*/
	
	public void deleteNodo(E llave) throws ExceptionNodo{
		NodoAVL<E> n=buscar(llave);
		NodoAVL<E> padre;
		if(n.getHijoD()!=null && n.getHijoI()!=null)
			padre=buscarAntecesor(n).getPadre();
		else
			padre=n.getPadre();
		deleteNodoABB(llave);///super.deleteNodo(llave);
		if(padre==null)
			balancear(raiz);
		else {
			while(padre!=null) {
				balancear(padre);
				padre=padre.getPadre();
			}
		
		}
	}
	
	/*---------ELIMINAR NODO ARBOLBB---------*/
	
	public void deleteNodoABB(E llave) throws ExceptionNodo {
		raiz=deleteNodoABB(llave, raiz);
	}
	
	public NodoAVL<E>deleteNodoABB(E llave, NodoAVL<E> r) throws ExceptionNodo{
		if(r==null) {
			throw new ExceptionNodo("El nodo no se encuentra");
		}else {
			if(llave.compareTo(r.getLlave())<0) {
				r.setHijoI(deleteNodoABB(llave, r.getHijoI()));
			}else {
				if(llave.compareTo(r.getLlave())>0) {
					r.setHijoD(deleteNodoABB(llave, r.getHijoD()));
				}else {
					if(r.getHijoD()!=null && r.getHijoI()!=null) {
						NodoAVL<E> antecesor=buscarAntecesor(r);
						r.setLlave(antecesor.getLlave());
						r.setHijoI(deleteNodoABB(antecesor.getLlave(), r.getHijoI()));
					}else {
						if(r.getHijoD()!=null) {
							r=r.getHijoD();
						}else {
							r=r.getHijoI();
						}
					}
				}
			}
		}
		
		return r;
	}
	
	public NodoAVL<E> buscarAntecesor(NodoAVL<E> n) {
        return(n.getHijoD() == null)? null: buscarMax(n.getHijoI());
    }
	
    public NodoAVL<E> buscarMax(NodoAVL<E> n){
        return(n.getHijoD() == null)? n: buscarMax(n.getHijoD());
    }
    
    
	/*---------BALANCEAR---------*/
	
	private void balancear(NodoAVL<E> n) {
		NodoAVL<E> desb = desbalance(n);
		if (desb != null) {
			NodoAVL<E> p = desb.getPadre();
			
			if ( desb.FE() > 0) {
				if ( desb.getHijoD().FE() >= 0) 
					desb = balanceSimpleIzq(desb);
				else
					desb = balanceDobleIzq(desb);
			} else {
				if (desb.FE() < 0) {
					if (desb.getHijoI().FE() <= 0)
						desb = balanceSimpleDer(desb);
					else 
						desb = balanceDobleDer(desb);
				}
			}
			if (p == null) 
				raiz = desb;
			else 
				if (desb.getLlave().compareTo(p.getLlave()) > 0)
					p.setHijoD(desb);
				else 
					p.setHijoI(desb);
		}
	}
	
	public NodoAVL<E> desbalance(NodoAVL<E> n) {
		NodoAVL<E> nodo = n;
		while (nodo != null && Math.abs(nodo.FE()) <= 1) {
			nodo = nodo.getPadre();
		}
		return nodo;
	}
	
	public NodoAVL<E> balanceSimpleIzq(NodoAVL<E> n) {
		NodoAVL<E> der = n.getHijoD();
		der.setPadre(n.getPadre());
		n.setHijoD(der.getHijoI());
		der.setHijoI(n);
		return der;
	}
	
	public NodoAVL<E> balanceSimpleDer(NodoAVL<E> n) {
		NodoAVL<E> izq = n.getHijoI();
		izq.setPadre(n.getPadre());
		n.setHijoI(izq.getHijoD());
		izq.setHijoD(n);
		return izq;
	}
	
	public NodoAVL<E> balanceDobleDer(NodoAVL<E> n){
		n.setHijoI(balanceSimpleIzq(n.getHijoI()));
		return balanceSimpleDer(n);
	}
	
	public NodoAVL<E> balanceDobleIzq(NodoAVL<E> n){
		n.setHijoD(balanceSimpleDer(n.getHijoD()));
		return balanceSimpleIzq(n);
	}
	
	
	/*---------CANTIDAD DE HOJAS DEL AVL---------*/
    
    public int CantidadHojas() {
    	
    	return CantidadHojas(this.raiz);
    }
    
    public int CantidadHojas(NodoAVL<E> n) {
    	if(n==null) {
    		return 0;
    	}
    	if(n.getHijoD()==null && n.getHijoI()==null) {
    		return 1;
    		
    	}
    	return CantidadHojas(n.getHijoD())+ CantidadHojas(n.getHijoI());
    }
    
    
    /*---------COTRUIR CON EL ARRAYLIST PREORDEN EL ABB---------*/
	
	public void construirConPreOrden (ArrayList<E> pre) throws ExceptionNodo {
		raiz = construirConPreOrden(pre, new NodoAVL<E>(pre.get(0)), 1, pre.size());
	}
	
	public NodoAVL<E> construirConPreOrden (ArrayList<E> pre, NodoAVL<E> n, int k, int valMax) throws ExceptionNodo {	
		raiz = new NodoAVL<E>(pre.get(0));	
		for (int i = 1; i < pre.size(); i++) {
			insertNodo(pre.get(i));
		}
		return raiz;	
	}

/*-----------RECORRIDOS DEL ÁRBOL-----------*/
	
	// PREORDEN: visita la raíz, luego el subarbol izquierdo en preorden y después el subarbol derecho en preorden
	
		//Con Sysout	
	public void preorden() {
		preorden(raiz);
		System.out.println();
			
	}
	
	public void preorden(NodoAVL<E> r) {
		if(r!=null) {
			System.out.println(r.getLlave()+" ");
			preorden(r.getHijoI());	
			preorden(r.getHijoD());
		}
	}
	
		//Con ArrayList
	public ArrayList<E> preorden2() {
		ArrayList<E> arbolPreorden = new ArrayList<E>();
		arbolPreorden= preorden2(raiz, arbolPreorden);
		return arbolPreorden;
			
	}
	
	public ArrayList<E> preorden2(NodoAVL<E> r, ArrayList<E> a) {
		
		if(r!=null) {
			a.add(r.getLlave());
			preorden2(r.getHijoI(), a);	
			preorden2(r.getHijoD(), a);
		}
		return a;
	}
	
	// POSTORDEN: visita el subarbol izquierdo en postorden, luego el subarbol derecho en postorden y por  último la raíz
	
			//Con Sysout
	public void posorden() {
		posorden(raiz);
		System.out.println();
	}
	
	public void posorden(NodoAVL<E> r) {
		if(r!=null) {
			posorden(r.getHijoI());
			preorden(r.getHijoD());
			System.out.println(r.getLlave()+" ");
		}
		
	}
	
		//Con Arraylist
	public ArrayList<E> posorden2() {
		ArrayList<E> arbolPosorden = new ArrayList<E>();
		arbolPosorden= posorden2(raiz, arbolPosorden);
		return arbolPosorden;
	}
	
	public ArrayList<E>  posorden2(NodoAVL<E> r, ArrayList<E> a) {
		if(r!=null) {
			posorden2(r.getHijoI(), a);
			preorden2(r.getHijoD(), a);
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
	
	public void inorden(NodoAVL<E> r) {
		if(r!=null) {
			inorden(r.getHijoI());
			System.out.println(r.getLlave()+" ");
			inorden(r.getHijoD());
		}	
	}
	
		//Con arrayList
	
	public ArrayList<E> inorden2() {
		ArrayList<E> arbolInorden = new ArrayList<E>();
		arbolInorden= inorden2(raiz, arbolInorden);
		return arbolInorden;
	}
	
	public ArrayList<E> inorden2(NodoAVL<E> r, ArrayList<E> a) {
		if(r!=null) {
			inorden2(r.getHijoI(), a);
			a.add(r.getLlave());
			inorden2(r.getHijoD(), a);
		}
		return a;	
	}
	
	/*---------COTRUIR CON EL ARRAYLIST PREORDEN EL AVL---------*/
	
	public ArbAVL<E> preordenArbol(ArrayList<E> a) throws Exception {
		ArbAVL<E> result= new ArbAVL<E>();
		NodoAVL<E> raiz= new NodoAVL<E>(a.get(0));
		result.setRaiz(raiz);
		int i=1;
		while(i<=a.size()) {
			result.insertNodo(a.get(i));
		}
		return result;
		
	}
	
}

class ExceptionNodo extends Exception{
	
	private static final long serialVersionUID = 1L;

		public ExceptionNodo(String s) {
			super(s);
		}
}
