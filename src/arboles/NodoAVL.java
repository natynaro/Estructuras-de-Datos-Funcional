package arboles;

public class NodoAVL <E extends Comparable<E>>{
	
	
	private int fe;//faactor de equilibrio
	private NodoAVL hijoI, hijoD;
	private E llave;
	private NodoAVL padre;
	
	NodoAVL(){
		
	}
	public NodoAVL(E llave) {
		this.llave=llave;
		this.fe=0;
		this.hijoI=null;
		this.hijoD=null;
		this.padre=null;
	}

	public int getFe() {
		return fe;
	}

	public void setFe(int fe) {
		this.fe = fe;
	}
	public void actualizarFe() {
		
		this.fe = alturaNodo(this);
	}
	//izquierda-derecha
	public int actualizarFe(NodoAVL n) {
		if(n==null){
			return 0;
		}else {
			return n.fe = alturaNodo(this.hijoD)-alturaNodo(this.hijoI);
			
		}	
	}

	public NodoAVL getHijoI() {
		return hijoI;
	}

	public void setHijoI(NodoAVL nodoB) {
		
		this.hijoI = (NodoAVL) nodoB;
		this.fe= alturaNodo(this.hijoI)-alturaNodo(this.hijoD);
	}

	public NodoAVL getHijoD() {
		return hijoD;
	}

	public void setHijoD(NodoAVL nodoB) {
		this.hijoD = (NodoAVL) nodoB;
		this.fe= alturaNodo(this.hijoI)-alturaNodo(this.hijoD);
	}

	public E getLlave() {
		return llave;
	}
	

	/*public void setLlave(E llave) {
		this.llave = llave;
	}*/

	public NodoAVL getPadre() {
		return padre;
	}
	public void setPadre(NodoAVL padre) {
		this.padre = padre;
	}
	public void setLlave(E llave) {
		this.llave = llave;
	}
	@Override
	public String toString() {
		return "NodoAVL [fe=" + fe + ", llave=" + llave + "]";
	}
	public int alturaNodo(NodoAVL<E> n) {
		if(n==null) return -1;
		int altDer=(n.getHijoD()==null)? 0:1+alturaNodo(n.getHijoD());
		int altIzq=(n.getHijoI()==null)? 0:1+alturaNodo(n.getHijoI());
		return Math.max(altDer, altIzq);
	}
	public int altura() {
		return alturaNodo(this);
	}
	public int FE() {
		System.out.println(this + "   FE:"+  (alturaNodo(this.getHijoD())-alturaNodo(this.getHijoI())));
		return alturaNodo(this.getHijoD())-alturaNodo(this.getHijoI());
	}
	
	
	
	
	

}
