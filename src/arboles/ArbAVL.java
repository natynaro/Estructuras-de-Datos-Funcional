package arboles;

import java.util.ArrayList;

public class ArbAVL <E extends Comparable<E>>{
	
	private NodoAVL raiz;
	
	public ArbAVL() {
		raiz=null;
	}
	public ArbAVL(NodoAVL<E>n) {
		raiz=n;
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
	
	//Inserción con balanceo libro
	
	public void insertarNodo(E llave) throws Exception {
		alturaTodosNodos();
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
	
	public void alturaTodosNodos() throws Exception {
		alturaTodosNodos(raiz);
		
	}
	public void alturaTodosNodos(NodoAVL n) throws Exception {
		if(n!=null) {
			FENodos(n);
			FENodos(n.getHijoD());
			FENodos(n.getHijoI());
		}else {
			throw new Exception("idk");
		}
		
	}
	//derecho-izquierdo
	public int FENodos(NodoAVL n) {
		if(n==null) {
			return 0;
		}else if(n.getHijoI()==null && n.getHijoD()!=null) {
			return n.getHijoD().alturaNodo(n);
		}else if(n.getHijoI()!=null && n.getHijoD()==null) {
			return 0-n.getHijoI().alturaNodo(n);
		}else {
			return n.getHijoD().alturaNodo(n)-n.getHijoI().alturaNodo(n);
		}
		
		
	}
	
	//Eliminado de nodos
	
	public  void eliminar(E valor) throws Exception{
		raiz=borrarAVL(raiz, valor);
	}
	public NodoAVL borrarAVL(NodoAVL<E> r, E clave) throws Exception {
		if(r==null) {
			throw new Exception("NodoNoEncontrado");
		}else if(clave.compareTo(r.getLlave())<0) {
			NodoAVL iz= borrarAVL(r.getHijoI(), clave);
			r.setHijoI(iz);
			alturaTodosNodos();
			/*if(bandera) r=equilibrar1(r, bandera);*/
		}else if(clave.compareTo(r.getLlave())>0) {
			NodoAVL dr=borrarAVL(r.getHijoD(),clave);
		}else {
			NodoAVL q=r;
			if(q.getHijoI()==null) {
				r=q.getHijoD();
			}else if(q.getHijoD()==null) {
				r=q.getHijoI();
			}else {
				NodoAVL iz;
				iz= reemplazar(r, r.getHijoI());
				r.setHijoI(iz);
				alturaTodosNodos();
				/*if(bandera) r=equilibrar1(r, bandera)*/
			}
			q=null;
		}
		return r;
		
	}
	private NodoAVL reemplazar(NodoAVL n, NodoAVL act) throws Exception {
		if(act.getHijoD()!=null) {
			NodoAVL d;
			d=reemplazar(n, act.getHijoD());
			act.setHijoD(d);
			alturaTodosNodos();
			/*if(bandera) act=equilibrar2(act, bandera)*/
		}else {
			n.setLlave(act.getLlave());
			n=act;
			act=act.getHijoI();
			n=null;
		}
		alturaTodosNodos();
		return act;
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
	/*
	 * 
	 * 
	 * 
	 * 
	 * 
	 * LO QUE HIZO LA PROFE
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * */
	
	public NodoAVL<E> desbalance(NodoAVL<E> n){
		NodoAVL<E> nodo=n;
		while(nodo!=null && Math.abs(nodo.FE())<=1) {
			nodo=(NodoAVL<E>) nodo.getPadre();	
		}
		return nodo;
	}
	/*private void balancearC(NodoAVL<E> n) {
		NodoAVL<E> desb=desbalance(n);
		if(desb!=null) {
			NodoAVL<E> p= desb.getPadre();
			desb=(desb.getFe()>0)?
					((desb.getHijoD().getFe())>=0)?
		}
	}*/
	
	private void balancear(NodoAVL<E> n) {
		NodoAVL<E> desb=desbalance(n);
		if(desb!=null) {
			NodoAVL<E> p=(NodoAVL<E>) desb.getPadre();
			if(desb.FE()>0) {
				if(desb.getHijoD().FE()>=0) {
					desb=(NodoAVL<E>) balanceSimpleIzq(desb);
				}else desb= balanceDobleIzq(desb);
			}else { //EQUIPO1
				if(desb.FE()<0) {
					if(desb.getHijoI().FE()<=0) desb=(NodoAVL<E>) 
							balanceSimpleDer(desb);
					else desb= balanceDobleDer(desb);
				}
				if(p==null) raiz=desb;
				else {
					if(desb.getLlave().compareTo(p.getLlave())>0)
						p.setHijoD(desb);
					else p.setHijoI(desb);
				}
			}
		}
	}
	
	public NodoAVL<E> balanceSimpleIzq(NodoAVL<E> n){
		NodoAVL<E> der=n.getHijoD();
		der.setPadre(n.getPadre());
		n.setHijoD(der.getHijoI());
		der.setHijoI(n);
		return der;
	
	}
	
	public NodoAVL<E> balanceSimpleDer(NodoAVL<E> n){
		NodoAVL<E> izq=n.getHijoI();
		izq.setPadre(n.getPadre());
		n.setHijoI(izq.getHijoD());
		izq.setHijoD(n);
		return izq;
	
	}
	public NodoAVL<E> balanceDobleDer(NodoAVL<E> n){
		n.setHijoI(balanceSimpleIzq(n.getHijoI()));
		return (NodoAVL<E>) balanceSimpleDer(n);
	}
	
	public NodoAVL<E> balanceDobleIzq(NodoAVL<E> n){
		n.setHijoD(balanceSimpleDer(n.getHijoD()));
		return (NodoAVL<E>) balanceSimpleIzq(n);
	}
	
	//hacer dos insertar
	//balancear
	
	public void insertNodoAVL(NodoAVL<E> n ) {
		
	}
	public void insertNodo(E llaveN) throws ExceptionNodo{
		NodoAVL a=new NodoAVL<E>(llaveN);
		raiz=(NodoAVL) insertNodo(a, raiz);
		balancear(a);
	}
	
	public void insertNodo(NodoAVL<E> n) throws ExceptionNodo{
		raiz=(NodoAVL) insertNodo(n, raiz);
		NodoAVL a = (NodoAVL) n;
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
}
	
	


