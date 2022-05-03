package arboles;

public class NodoB <E extends Comparable<E>>{
	protected E llave;
	protected NodoB<E> hijoIzq;
	protected NodoB<E> hijoDer;
	protected NodoB<E> padre;
	
	public NodoB(E llave) {
		this.llave=llave;
		padre=null;
		hijoIzq=null;
		hijoDer=null;
	}
	
	public NodoB(E llave, NodoB<E> hijoIzq,NodoB<E> hijoDer,NodoB<E>padre) {
		this.llave=llave;
		this.padre=padre;
		this.hijoIzq=hijoIzq;
		this.hijoDer=hijoDer;
	}

	public E getLlave() {
		return llave;
	}

	public void setLlave(E llave) {
		this.llave = llave;
	}

	public NodoB<E> getHijoIzq() {
		return hijoIzq;
	}

	public void setHijoIzq(NodoB<E> hijoIzq) {
		if(hijoIzq!=null){
			hijoIzq.setPadre(this);
		}
		this.hijoIzq = hijoIzq;
	}

	public NodoB<E> getHijoDer() {
		return hijoDer;
	}

	public void setHijoDer(NodoB<E> hijoDer) {
		if(hijoDer!=null) {
			hijoDer.setPadre(this);
		}
		this.hijoDer = hijoDer;
	}

	public NodoB<E> getPadre() {
		return padre;
	}

	public void setPadre(NodoB<E> padre) {
		this.padre = padre;
	}

	@Override
	public String toString() {
		return "NodoB [llave=" + llave + "]";
	}
	
	public int alturaNodo(NodoB<E> n) {
		if(n==null) return -1;
		int altDer=(n.getHijoDer()==null)? 0:1+alturaNodo(n.getHijoDer());
		int altIzq=(n.getHijoIzq()==null)? 0:1+alturaNodo(n.getHijoIzq());
		return Math.max(altDer, altIzq);
	}
	
	public int altura() {
		return alturaNodo(this);
	}
	
	
	
}
