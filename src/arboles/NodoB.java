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
		this.hijoIzq = hijoIzq;
	}

	public NodoB<E> getHijoDer() {
		return hijoDer;
	}

	public void setHijoDer(NodoB<E> hijoDer) {
		this.hijoDer = hijoDer;
	}

	public NodoB<E> getPadre() {
		return padre;
	}

	public void setPadre(NodoB<E> padre) {
		this.padre = padre;
	}
	
	
	
}
