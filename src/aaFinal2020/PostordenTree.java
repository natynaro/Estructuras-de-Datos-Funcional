package aaFinal2020;

import java.io.*;
import java.util.*;

import aaaArbolBinarioAVL.NodoAVL;

public class PostordenTree {
	
    
    public ArrayList<Integer> fromPreordenToPostorden(Integer[] preorden) throws ExceptionNodoS {
        return construirConPreOrden(preorden);
    }
    public ArrayList<Integer> construirConPreOrden(Integer[] preorden) throws ExceptionNodoS {
    	ArbolBB<Integer> b= new ArbolBB<Integer>();
    	
    	for(int i=0; i<preorden.length;i++) {
    		NodoA<Integer> n= new NodoA<Integer>(preorden[i]);
    		b.insertNodo(n);
    	}
    	return b.posorden2();
    	
    	
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner in = new Scanner(System.in);
        String line= in.nextLine();
        String[] preordenS=line.split(",");
        Integer[] preorden=new Integer[preordenS.length];
        for (int i=0;i<preordenS.length;i++)
            preorden[i]=Integer.parseInt(preordenS[i]);
        PostordenTree p=new PostordenTree();
        //p.preordenpostorden(preorden, 0, preorden.length);
        ArrayList<Integer> resultado;
		try {
			resultado = p.fromPreordenToPostorden(preorden);
			for (Integer s:resultado)
	            System.out.println(s);
		} catch (ExceptionNodoS e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        in.close();
    }

}



class ArbolBB <E extends Comparable<E>>{

    protected NodoA<E> raiz;
    
	public ArrayList<E> posorden2() {
		ArrayList<E> arbolPosorden = new ArrayList<E>();
		arbolPosorden= posorden2(raiz, arbolPosorden);
		return arbolPosorden;
	}
	
	public ArrayList<E>  posorden2(NodoA<E> r, ArrayList<E> a) {
		if(r!=null) {
			posorden2(r.getHijoIzq(), a);
			posorden2(r.getHijoDer(), a);
			a.add(r.getLlave());
		}
		return a;
	}
		
	

    
    /*-----------CONSTRUCTOR-----------*/
    
    public ArbolBB() {
        super();
    }

    public ArbolBB(NodoA<E> raiz) {
        super();
        this.raiz = raiz;
    }
    
    
    /*---------GETTERS AND SETTERS DE LA RAiZ---------*/
    
    public NodoA<E> getRaiz() {
        return raiz;
    }

    public void setRaiz(NodoA<E> raiz) {
        this.raiz = raiz;
    }
    
    
    /*---------INSERTAR UN NUEVO NODO---------*/
    
        
    public void insertNodo(NodoA<E> n) throws ExceptionNodoS{
        raiz=insertNodo(n, raiz);
        
    }
        

    public void insertNodo(E llaveN) throws ExceptionNodoS{
        raiz=insertNodo(new NodoA<E>(llaveN), raiz);
    }
        
   
    protected NodoA<E> insertNodo(NodoA<E> n, NodoA<E> r) throws ExceptionNodoS{
        if(r==null) {
        r=n;
        }    else {
            if(n.getLlave().compareTo(r.getLlave())<0)
                r.setHijoIzq(insertNodo(n, r.getHijoIzq()));
            if(n.getLlave().compareTo(r.getLlave())>0) 
                r.setHijoDer(insertNodo(n, r.getHijoDer()));
            if(n.getLlave().compareTo(r.getLlave())==0) 
                throw new ExceptionNodoS("El nodo està repetido");
        }
        return r;
    }
  
    
    public void construirConPreOrden (ArrayList<E> pre) throws ExceptionNodoS {
        raiz = construirConPreOrden(pre, new NodoA<E>(pre.get(0)), 1, pre.size());
    }
    
    public NodoA<E> construirConPreOrden (ArrayList<E> pre, NodoA<E> n, int k, int valMax) throws ExceptionNodoS {
        
        raiz = new NodoA<E>(pre.get(0));
        
        for (int i = 1; i < pre.size(); i++) {
            insertNodo(pre.get(i));
        }
        
        return raiz;
        
    }
 

}

class ExceptionNodoS extends Exception{
    
    private static final long serialVersionUID = 1L;

        public ExceptionNodoS(String s) {
            super(s);
        }
}
class NodoA <E extends Comparable<E>>{
    
    protected E llave;
    protected NodoA<E> hijoIzq;
    protected NodoA<E> hijoDer;
    protected NodoA<E> padre;
    
    /*-----------CONSTRUCTOR-----------*/
    public NodoA(E llave) {
        this.llave=llave;
        padre=null;
        hijoIzq=null;
        hijoDer=null;
    }
    
    public NodoA(E llave, NodoA<E> hijoIzq,NodoA<E> hijoDer,NodoA<E>padre) {
        this.llave=llave;
        this.padre=padre;
        this.hijoIzq=hijoIzq;
        this.hijoDer=hijoDer;
    }

    /*---------GETTERS AND SETTERS---------*/
    
    public E getLlave() {
        return llave;
    }

    public void setLlave(E llave) {
        this.llave = llave;
    }

    public NodoA<E> getHijoIzq() {
        return hijoIzq;
    }

    public void setHijoIzq(NodoA<E> hijoIzq) {
        if(hijoIzq!=null){
            hijoIzq.setPadre(this);
        }
        this.hijoIzq = hijoIzq;
    }

    public NodoA<E> getHijoDer() {
        return hijoDer;
    }

    public void setHijoDer(NodoA<E> hijoDer) {
        if(hijoDer!=null) {
            hijoDer.setPadre(this);
        }
        this.hijoDer = hijoDer;
    }

    public NodoA<E> getPadre() {
        return padre;
    }

    public void setPadre(NodoA<E> padre) {
        this.padre = padre;
    }

    /*---------TO STRING---------*/
    
    public String toString() {
        return "NodoA [llave=" + llave + "]";
    }
    
    /*---------ALTURA NODO DADO O ESTE MISMO NODO---------*/
    
    public int alturaNodo(NodoA<E> n) {
        if(n==null) return -1;
        int altDer=(n.getHijoDer()==null)? 0:1+alturaNodo(n.getHijoDer());
        int altIzq=(n.getHijoIzq()==null)? 0:1+alturaNodo(n.getHijoIzq());
        return Math.max(altDer, altIzq);
    }
    
    public int altura() {
        return alturaNodo(this);
    }
        
}


