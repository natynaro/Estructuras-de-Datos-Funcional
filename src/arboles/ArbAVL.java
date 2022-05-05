package arboles;

import java.util.ArrayList;

public class ArbAVL <E extends Comparable<E>>{
	
	private NodoAVL raiz;
	public ArbAVL() {
		raiz=null;
	}
	
	
	
	public NodoAVL getRaiz() {
		return raiz;
	}



	public void setRaiz(NodoAVL raiz) {
		this.raiz = raiz;
	}



	//Buscar
	public NodoAVL buscar(E d){
		return buscar(d, raiz);
	}
	
	
	
	public NodoAVL buscar(E d, NodoAVL<E> r) {
		if(raiz==null) {
			return null;
		}else if(r.getLlave().compareTo(d)==0) {
			return r;
		}else if(r.getLlave().compareTo(d)<0) {
			return buscar(d,r.getHijoD());
		}else {
			return buscar(d,r.getHijoI());
		}
		
	}
	
	
	//Obtener el Factor de equilibrio
	
	public int obtenerFE(NodoAVL x) {
		if(x==null) {
			return -1;
		}else {
			return x.getFe();
		}
	}
	
	//Rotacion Simple Izquierda (video)
	
	public NodoAVL rotIzq(NodoAVL c) {
		NodoAVL aux= c.getHijoI();
		c.setHijoI(aux.getHijoD());
		aux.setHijoD(c);
		c.setFe(Math.max(obtenerFE(c.getHijoI()), obtenerFE(c.getHijoD()))+1);
		aux.setFe(Math.max(obtenerFE(aux.getHijoI()), obtenerFE(aux.getHijoD())+1));
		return aux;
	
	}
	
	//Rotacion II libro
	public NodoAVL rotacionII(NodoAVL<E> n, NodoAVL<E> n1) {
		n.setHijoI(n1.getHijoD());
		n1.setHijoD(n);
		// actualización de los factores de equilibrio
		if(n1.getFe()==-1) {
			n.setFe(0);
			n1.setFe(0);
		}else {
			n.setFe(-1);
			n1.setFe(1);
		}
		return n1;
	}
	
	//Rotacion Simple Derecha
	
	public NodoAVL rotDer(NodoAVL c) {
		NodoAVL aux= c.getHijoD();
		c.setHijoD(aux.getHijoI());
		aux.setHijoI(c);
		c.setFe(Math.max(obtenerFE(c.getHijoI()), obtenerFE(c.getHijoD()))+1);
		aux.setFe(Math.max(obtenerFE(aux.getHijoI()), obtenerFE(aux.getHijoD())+1));
		return aux;
	
	}
	//Rotación DD Libro
	
	public NodoAVL rotacionDD(NodoAVL<E> n, NodoAVL<E> n1) {
		n.setHijoD(n1.getHijoI());
		n1.setHijoI(n);
		// actualización de los factores de equilibrio
		if(n1.getFe()==1) {
			n.setFe(0);
			n1.setFe(0);
		}else {
			n.setFe(1);
			n1.setFe(-1);
		}
		return n1;
	}
	
	//rOTACION doBLE IZQUIERDA
	
	public NodoAVL rotDobleI(NodoAVL c) {
		NodoAVL aux;
		c.setHijoI(rotDer(c.getHijoI()));
		aux=rotIzq(c);
		return aux;
	}
	
	//Rotación ID LIBRO
	
	public NodoAVL rotacionID(NodoAVL<E> n, NodoAVL<E>n1) {
		NodoAVL n2;
		n2= n1.getHijoD();
		n.setHijoI(n2.getHijoD());
		n2.setHijoD(n2.getHijoI());
		n2.setHijoI(n1);
		// actualización de los factores de equilibrio
		if(n2.getFe()==1)
			n1.setFe(-1);
		else 
			n1.setFe(0);
		if(n2.getFe()==-1) 
			n.setFe(1);
		else 
			n.setFe(0);
		n2.setFe(0);
		return n2;
		
		
	}
	
	//Rotacion Doble Derecha
	public NodoAVL rotDobleD(NodoAVL c) {
		NodoAVL aux;
		c.setHijoD(rotIzq(c.getHijoD()));
		aux=rotDer(c);
		return aux;
	}
	
	//Rotación DI LIBRO
	
		public NodoAVL rotacionDI(NodoAVL<E> n, NodoAVL<E>n1) {
			NodoAVL n2;
			n2= n1.getHijoI();
			
			n.setHijoD(n2.getHijoI());
			n2.setHijoI(n);
			n1.setHijoI(n2.getHijoD());
			n2.setHijoD(n1);
			// actualización de los factores de equilibrio
			if(n2.getFe()==1)
				n.setFe(-1);
			else 
				n.setFe(0);
			if(n2.getFe()==-1) 
				n1.setFe(1);
			else 
				n1.setFe(0);
			n2.setFe(0);
			return n2;
			
			
		}
	
	//Metodo para insertar VL
	
	public NodoAVL insertarAVL(NodoAVL n, NodoAVL subAr) {
		NodoAVL nuevoPadre= subAr;
		if(n.getLlave().compareTo(subAr.getLlave())<0) {
			if(subAr.getHijoI()==null) {
				subAr.setHijoI(n);
			}else {
				subAr.setHijoI(insertarAVL(n, subAr.getHijoI()));
				if(subAr.getHijoI().getFe()-subAr.getHijoD().getFe()==2) {
					if(n.getLlave().compareTo(subAr.getHijoI().getLlave())<0) {
						nuevoPadre=rotIzq(subAr);
					}else {
						nuevoPadre=rotDobleI(subAr);
					}
				}
			}
		}else if(n.getLlave().compareTo(subAr.getLlave())>0) {
			if(subAr.getHijoD()==null) {
				subAr.setHijoD(n);
			}else {
				subAr.setHijoD(insertarAVL(n, subAr.getHijoD()));
				if((subAr.getHijoD().getFe()-subAr.getHijoI().getFe())==2) {
					if(n.getLlave().compareTo(subAr.getHijoD().getLlave())>0) {
						nuevoPadre=rotDer(subAr);
					}else {
						nuevoPadre=rotDobleD(subAr);
					}
				}
			}
		}else {
			//El nodo está duplicado
		}
		
		//Actualizar el FE
		if(subAr.getHijoI()==null && subAr.getHijoD()!=null) {
			subAr.setFe(subAr.getHijoD().getFe()+1);
		}else if(subAr.getHijoD()==null && subAr.getHijoI()!=null) {
			subAr.setFe(subAr.getHijoI().getFe()+1);
		}else {
			subAr.setFe(Math.max(subAr.getHijoI().getFe(), subAr.getHijoD().getFe())+1);
		}
		
		return nuevoPadre;
		
	}
	
	//Inserción con balacneo libro
	
	public void insertarNodo(E llave) throws Exception {
		if(raiz==null) {
			raiz= new NodoAVL(llave);
		}else {
			raiz=insertarAVL(raiz, llave);
		}
	}
	
	public NodoAVL insertarAVL(NodoAVL raiz, E llave) throws Exception {
		NodoAVL n1;
		if(raiz==null) {
			raiz=new NodoAVL(llave);
		}else if(llave.compareTo((E) raiz.getLlave())<0) {
			NodoAVL iz;
			iz=insertarAVL(raiz.getHijoI(),llave);
			raiz.setHijoI(iz);//regreso por los nodos del camino de búsqueda
			switch(raiz.getFe()) {
			case 1:
				raiz.setFe(0); break;
			case 0:
				raiz.setFe(-1);break;
			case -1://aplicar rotación a la izquierda
				n1= raiz.getHijoI();
				if(n1.getFe()==-1) raiz=rotacionII(raiz, n1);
				else raiz=rotacionID(raiz,n1);
				break;
			}
			
		}else if(llave.compareTo((E) raiz.getLlave())>0) {
			NodoAVL dr;
			dr= insertarAVL(raiz.getHijoD(), llave);
			raiz.setHijoD(dr);
			//regreso por los nodos del camino de búsqueda
			switch(raiz.getFe()) {
			case 1://aplicar rotación a la derecha
				n1=raiz.getHijoD();
				if(n1.getFe()==1) raiz= rotacionDD(raiz, n1);
				else raiz=rotacionDI(raiz,n1);
				break;
			case 0:
				raiz.setFe(1);break;
			case -1:
				raiz.setFe(0);
				break;
			}
		}
		else throw new Exception("El nodo esta repetido");
		return raiz;
	}
	
	//Eliminado de nodos
	
	public  void eliminar(E valor) throws Exception{
		raiz=borrarAVL(raiz, valor);
	}
	public NodoAVL borrarAVL(NodoAVL r, E llave) throws Exception {
		return r;
		
	}
	
	//metodo para insertar
	
	public void insertar(E d) {
		NodoAVL nuevo= new NodoAVL(d);
		if(raiz==null) {
			raiz=nuevo;
		}else {
			raiz=insertarAVL(nuevo,raiz);
		}
	}
	
	//Metodos de recorrer
	
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
	
	//Hacer todo esto pero ponerlo en un arrayList
	
	public ArrayList preorden2() {
		ArrayList<E> arbolPreorden = new ArrayList<E>();
		arbolPreorden= preorden2(raiz, arbolPreorden);
		return arbolPreorden;
			
	}
	
	public ArrayList preorden2(NodoAVL<E> r, ArrayList a) {
		
		if(r!=null) {
			a.add(r.getLlave());
			preorden2(r.getHijoI(), a);	
			preorden2(r.getHijoD(), a);
		}
		return a;
	}
	
	public ArrayList posorden2() {
		ArrayList<E> arbolPosorden = new ArrayList<E>();
		arbolPosorden= posorden2(raiz, arbolPosorden);
		return arbolPosorden;
	}
	public ArrayList  posorden2(NodoAVL<E> r, ArrayList a) {
		if(r!=null) {
			posorden2(r.getHijoI(), a);
			preorden2(r.getHijoD(), a);
			a.add(r.getLlave());
		}
		return a;
		
	}
	
	public ArrayList inorden2() {
		ArrayList<E> arbolInorden = new ArrayList<E>();
		arbolInorden= inorden2(raiz, arbolInorden);
		return arbolInorden;
	}
	public ArrayList inorden2(NodoAVL<E> r, ArrayList a) {
		if(r!=null) {
			inorden2(r.getHijoI(), a);
			a.add(r.getLlave());
			inorden2(r.getHijoD(), a);
		}
		return a;	
	}
	
	//arraylist Preorden en un arbol binario de busqueda
	
	public ArbAVL preordenArbol(ArrayList<E> a) throws Exception {
		ArbAVL result= new ArbAVL();
		NodoAVL raiz= new NodoAVL(a.get(0));
		result.setRaiz(raiz);
		int i=1;
		while(i<=a.size()) {
			result.insertarNodo(a.get(i));
		}
		return result;
		
	}
	
	
}
	
	


