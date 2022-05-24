package aaFinal2020;

import java.util.*;

class ExceptionNodo extends Exception{
    public ExceptionNodo(String s){
        super(s);
    }
}

class Famoso implements Comparable<Famoso>{
    private String nombre;
    private int cantidad_seguidores;
    private int publicaciones;
    
    public Famoso(String nombre, int cantidad_seguidores, int publicaciones) {
        super();
        this.nombre = nombre;
        this.cantidad_seguidores = cantidad_seguidores;
        this.publicaciones = publicaciones;
    }
    public Famoso(){
        super();
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public int getCantidad_seguidores() {
        return cantidad_seguidores;
    }
    public void setCantidad_seguidores(int cantidad_seguidores) {
        this.cantidad_seguidores = cantidad_seguidores;
    }
    public int getPublicaciones() {
        return publicaciones;
    }
    public void setPublicaciones(int publicaciones) {
        this.publicaciones = publicaciones;
    }
    @Override
    public String toString() {
        return  nombre + ", "+ cantidad_seguidores ;
    }
    @Override
    public int compareTo(Famoso arg0) {
       // ordenado por cantidad de seguidores en Instagram
        if(this.cantidad_seguidores<arg0.getCantidad_seguidores()){
            return this.cantidad_seguidores;
        }else return arg0.getCantidad_seguidores()+1; 
    }
    public Comparator<Famoso> compPersonasN= new Comparator<Famoso>() {
        public int compare(Famoso o1, Famoso o2) {
           if(o1.cantidad_seguidores<o2.getCantidad_seguidores()){
            return o1.cantidad_seguidores;
        }else return o2.getCantidad_seguidores();  
          
        }
    };
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
                throw new ExceptionNodo("El nodo es repetido");
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
    
    //RECORRIDO INORDEN (PARA QUE ESTE EN ORDEN)
   public ArrayList<E> inorden2() {
        ArrayList<E> arbolInorden = new ArrayList<E>();
        arbolInorden= inorden2(raiz, arbolInorden);
        return arbolInorden;
    }
    
    public ArrayList<E> inorden2(NodoB<E> r, ArrayList<E> a) {
        if(r!=null) {
            inorden2(r.getHijoIzq(), a);
            a.add(r.getLlave());
            inorden2(r.getHijoDer(), a);
        }
        return a;    
    }
}
class Eseguidor extends Exception {
    private String string;
    public Eseguidor(String string) {
        super(string);
        this.string = string;
    }

    public Eseguidor() {
        super("No hay famosos con esa cantidad de seguidores");

    }
}

public class AVL_Famosos {
    
    public ArrayList<Famoso> mayoresSeguidores(int N, NodoB<Famoso> raiz) throws Eseguidor, ExceptionNodo{
        ArrayList<Famoso> z= cola(raiz);
         ArrayList<Famoso> a= new ArrayList<Famoso>();
       for(Famoso f: z){
           if(f.getCantidad_seguidores()>N){
               a.add(f);
           }
       }
        if(a.isEmpty()){
           throw new Eseguidor(); 
        }
        
       return a;
    }
    
    public ArrayList<Famoso> cola(NodoB<Famoso> raiz) throws ExceptionNodo{
        AVL<Famoso> arbol= new AVL<Famoso>();
        arbol.insertNodo(raiz);
        //LO RECURSIVO ESTA EN EL INORDEN  QUE ESTA EN LA CLASE AVL
        ArrayList<Famoso> z= arbol.inorden2();
		return z;
       
     
    }
    
    
   

    public static void main(String[] args) throws ExceptionNodo {
        // TODO Auto-generated method stub
        Scanner in = new Scanner(System.in);
        String line=in.nextLine();
        int N=Integer.parseInt(line);
        AVL<Famoso> arbol=new AVL<Famoso>();
        while ((line=in.nextLine()).compareTo("")!=0) {
            String[] lineSplit=line.split(",");
            Famoso p=new Famoso(lineSplit[0], Integer.parseInt(lineSplit[1]),Integer.parseInt(lineSplit[2]));
            NodoB<Famoso> nodo=new NodoB<Famoso>(p);
            try {
                arbol.insertNodo(nodo);
            } catch (ExceptionNodo e) {
                System.out.println(e.getMessage());
            }
        }
        AVL_Famosos avl=new AVL_Famosos();
        ArrayList<Famoso> a;
		try {
			a = avl.mayoresSeguidores(N, arbol.getRaiz());
			ListIterator<Famoso> it= a.listIterator();
	        while(it.hasNext()) {
	            Famoso p= it.next();
	            System.out.println(p.getNombre()+ " "+ p.getCantidad_seguidores());
	        }

	        in.close();
		} catch (Eseguidor e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
    }

}