package aaFinal2020;
import java.util.*;

import aaaArbolBinarioAVL.NodoAVL;

public class AVLDePersonas {
/*A partir de las clases siguientes de Persona1, AVL (árbol AVL) y NodoB. Se tiene una clase AVL_Final donde se necesita un método:
public ArrayList buscarMujeres(AVL arbolPersona1s)
que reciba un árbol AVL de la clase Persona1.
Este árbol está ordenado según el nombre y la edad de las Persona1s. O sea ordenadas alfabéticamente por nombre y para nombres iguales, por edad, comos e muestra en el método compareTo.
Implemente el método buscarMujeres que devuelva una lista de las mujeres que están en ese árbol, pero ordenadas en forma descendente.*/

/*Juan 20 M
Marta 30 F
Alberto 20 M
Lena 30 F
Ana 28 F
Ana 18 F*/
	public static void main(String[] args) {
		Persona1 p= new Persona1("Juan", 20, 'M');
		Persona1 p2= new Persona1("Marta", 30, 'F');
		Persona1 p3= new Persona1("Alberto", 20, 'M');
		Persona1 p4= new Persona1("Lena", 30, 'F');
		Persona1 p5= new Persona1("Ana", 28, 'F');
		Persona1 p6= new Persona1("Ana", 18, 'F');
		
		NodoB<Persona1> a= new NodoB<Persona1>(p);
		NodoB<Persona1> a2= new NodoB<Persona1>(p2);
		NodoB<Persona1> a3= new NodoB<Persona1>(p3);
		NodoB<Persona1> a4= new NodoB<Persona1>(p4);
		NodoB<Persona1> a5= new NodoB<Persona1>(p5);
		NodoB<Persona1> a6= new NodoB<Persona1>(p6);
		
		AVL<Persona1> b= new AVL<Persona1>();
		try {
			b.insertNodo(a);
			b.insertNodo(a2);
			b.insertNodo(a3);
			b.insertNodo(a4);
			b.insertNodo(a5);
			b.insertNodo(a6);
			
			AVL_Final f= new AVL_Final();
			
			for(Persona1 s: f.buscarMujeres(b)) {
				System.out.println(s.toString());
			}
		} catch (ExceptionNodo e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}


/*---------------LO QUE HAY QUE PROGRAMAR----------*/
class AVL_Final {
    
    public ArrayList<Persona1> buscarMujeres(AVL<Persona1> arbolPersona1s){
 
    	
    	ArrayList<Persona1> a= inorden2(arbolPersona1s);
    	
    	ArrayList<Persona1> c= new ArrayList<Persona1>();
    	Stack<Persona1> pila = new Stack<Persona1>();
    	//ListIterator<Persona1> t=c.listIterator();
    	for(Persona1 b: a) {
    		if(b.getSexo()=='F')
    			pila.push(b);
    	}
    	while(!pila.isEmpty()) {
    		c.add(pila.pop());
    	}
    	
    	return c;
    
    }
    public ArrayList<Persona1> inorden2(AVL<Persona1> c) {
		ArrayList<Persona1> arbolInorden = new ArrayList<Persona1>();
		arbolInorden= inorden2(c.getRaiz(), arbolInorden);
		return arbolInorden;
	}
	
	public ArrayList<Persona1> inorden2(NodoB<Persona1> r, ArrayList<Persona1> a) {
		if(r!=null) {
			inorden2(r.getHijoIzq(), a);
			a.add(r.getLlave());
			inorden2(r.getHijoDer(), a);
		}
		return a;	
	}
	
    
    //Haga las funciones que necesite

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String line;
        AVL<Persona1> arbol=new AVL<Persona1>();
        while ((line=in.nextLine()).compareTo("")!=0) {
            String[] lineSplit=line.split(" ");
            Persona1 p=new Persona1(lineSplit[0], Integer.parseInt(lineSplit[1]),lineSplit[2].charAt(0));
            NodoB<Persona1> nodo=new NodoB<Persona1>(p);
            try {
                arbol.insertNodo(nodo);
            } catch (ExceptionNodo e) {
                System.out.println(e.getMessage());
            }
        }
        AVL_Final avl=new AVL_Final();
        ArrayList<Persona1> a=avl.buscarMujeres(arbol);
        ListIterator<Persona1> it= a.listIterator();
        while(it.hasNext()) {
            Persona1 p= it.next();
            System.out.println(p.getNombre()+ " "+ p.getEdad());
        }

        in.close();
    }
    

}
class Persona1 implements Comparable<Persona1>{
    private String nombre;
    private int edad;
    private char sexo;// F para femenino y M para masculino
    public String getNombre() {
        return nombre;
    }
    public int getEdad() {
        return edad;
    }    
    public char getSexo() {
        return sexo;
    }
    public Persona1(String nombre, int edad, char sexo) {
        this.nombre = nombre;
        this.edad = edad;
        this.sexo=sexo;
    }
    @Override
    public String toString() {
        return  nombre + ", "+ edad ;
    }
    @Override
    public int compareTo(Persona1 arg0) {
        return (nombre.compareTo(arg0.getNombre())==0)?
                edad-arg0.getEdad():nombre.compareTo(arg0.getNombre());
    }
}

class ExceptionNodo extends Exception{
    public ExceptionNodo(String s){
        super(s);
    }
}

class NodoB<E extends Comparable<E>> {
    protected E llave;
    protected NodoB<E> hijoIzq;
    protected NodoB<E> hijoDer;
    protected NodoB<E> padre;

    public NodoB(E llave) {
        this.llave = llave;
        padre=null;
        hijoIzq=null;
        hijoDer=null;
    }

    public NodoB(E llave, NodoB<E> hijoIzq, NodoB<E> hijoDer, NodoB<E> padre) {
        super();
        this.llave = llave;
        this.hijoIzq = hijoIzq;
        this.hijoDer = hijoDer;
        this.padre = padre;
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
        if (hijoIzq!=null){
            hijoIzq.setPadre(this);
        }
        this.hijoIzq = hijoIzq;
    }

    public NodoB<E> getHijoDer() {
        return hijoDer;
    }

    public void setHijoDer(NodoB<E> hijoDer) {
        if (hijoDer!=null){
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

    public int altura (NodoB<E> n){
        if (n== null) return -1;
        int altder = (n.getHijoDer() == null? 0:1 + altura (n.getHijoDer()));
        int altizq = (n.getHijoIzq() == null? 0:1 + altura (n.getHijoIzq()));
        return Math.max(altder,altizq);
    }
    
    public int altura(){
        return altura(this);
    }
    
    public int FE(){
        return altura(this.getHijoDer())-altura(this.getHijoIzq());
    }
    
    @Override
    public String toString() {
        String HI=(hijoIzq==null)? "null":hijoIzq.getLlave().toString();
        String HD=(hijoDer==null)? "null":hijoDer.getLlave().toString();
        return ((Comparable<E>)llave).toString()+ "("+HI+","+HD+")";
    }

}

class AVL<E extends Comparable<E>>{
    private NodoB<E> raiz;

    public NodoB<E> getRaiz() {
        return raiz;
    }
    public AVL() {
        raiz=null;
    }
    
    public void insert(NodoB<E> n) throws ExceptionNodo{
        raiz=insert(n, raiz);
    }
    
    protected NodoB<E> insert(NodoB<E> n, NodoB<E> r) throws ExceptionNodo {
        if (r==null){
            r=n;
        }else{
            if (n.getLlave().compareTo(r.getLlave())<0)
                r.setHijoIzq(insert(n,r.getHijoIzq()));
            if (n.getLlave().compareTo(r.getLlave())>0)
                r.setHijoDer(insert(n,r.getHijoDer()));
            if (n.getLlave().compareTo(r.getLlave())==0)
                throw new ExceptionNodo("El nodo está repetido");
        }
        return r;        
    }
    
    public void insertNodo(NodoB<E> n) throws ExceptionNodo {
        insert(n);
        balancear(n);
    }
    
        
    private void balancear(NodoB<E> n) {
        NodoB<E> desb = desbalance(n);
        if (desb!=null){
            NodoB<E> p= desb.getPadre();
            desb=(desb.FE()>0)?
                ((desb.getHijoDer().FE()>=0)? balanceSimpleIzq(desb):balanceDobleIzq(desb)):
                ((desb.getHijoIzq().FE()<=0)? desb=balanceSimpleDer(desb):balanceDobleDer(desb));
            if (p==null)
                 raiz=desb;
            else
                if(desb.getLlave().compareTo(p.getLlave())>0)
                    p.setHijoDer(desb);
                else
                    p.setHijoIzq(desb);
        }        
    }

    public NodoB<E> desbalance(NodoB<E> n){
        NodoB<E> nodo=n;
        while(nodo!=null && Math.abs(nodo.FE())<=1){
            nodo= nodo.getPadre();
        }
        return nodo;
    }
    
    public NodoB<E> balanceSimpleDer(NodoB<E> n){
        NodoB<E> izq=n.getHijoIzq();
        izq.setPadre(n.getPadre());
        n.setHijoIzq(izq.getHijoDer());
        izq.setHijoDer(n);
        return izq;
    }    
    
    public NodoB<E> balanceSimpleIzq(NodoB<E> n){
        NodoB<E> der=n.getHijoDer();
        der.setPadre(n.getPadre());
        n.setHijoDer(der.getHijoIzq());
        der.setHijoIzq(n);
        return der;
    }
    
    public NodoB<E> balanceDobleDer(NodoB<E> n){
        n.setHijoIzq(balanceSimpleIzq(n.getHijoIzq())); 
        return balanceSimpleDer(n);
    }
    
    public NodoB<E> balanceDobleIzq(NodoB<E> n){
        n.setHijoDer(balanceSimpleDer(n.getHijoDer())); 
        return balanceSimpleIzq(n);
    }
}
