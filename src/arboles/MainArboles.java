package arboles;

import java.util.ArrayList;

public class MainArboles {

	public static <E> void main(String[] args) {/*
		NodoB<Integer> n1= new NodoB<Integer>(10);
		NodoB<Integer> n2= new NodoB<Integer>(7);
		NodoB<Integer> n3= new NodoB<Integer>(15);
		NodoB<Integer> n4= new NodoB<Integer>(5);
		NodoB<Integer> n5= new NodoB<Integer>(9);
		NodoB<Integer> n6= new NodoB<Integer>(12);
		NodoB<Integer> n20= new NodoB<Integer>(20);
		n3.setHijoIzq(n6);
		n2.setHijoIzq(n4);
		n2.setHijoDer(n5);
		n1.setHijoIzq(n2);
		n1.setHijoDer(n3);
		n4.setHijoDer(n20);
		
		ArbolB<Integer> a= new ArbolB<Integer>(n1);
		System.out.println("Altura de 7: "+n2.alturaNodo(n2));
		n2.alturaNodo(n2);*/
		
		ArbolBB<Integer> b= new ArbolBB<Integer>();
		/*try {
			b.insertNodo(5);
			b.insertNodo(2);
			b.insertNodo(3);
			b.insertNodo(1);
			b.insertNodo(9);
			b.insertNodo(7);
			b.insertNodo(8);
			b.insertNodo(6);
			b.insertNodo(4);
			b.insertNodo(10);
			b.insertNodo(15);
			b.insertNodo(16);
			
			System.out.println("Altura de 5: "+ n2.alturaNodo(b.raiz));
			
			System.out.println("Inorden sysout");
			b.inorden();
			System.out.println();
			
			System.out.println("Inorden ArrayList");
			ArrayList w=b.inorden2();
			for(int i=0; i<w.size();i++) {
				System.out.println(w.get(i));
			}
			System.out.println();
			
			
			System.out.println("Preorden Sysout");
			b.preorden();
			System.out.println();
		
			System.out.println("Preorden ArrayList");
			ArrayList t=b.preorden2();
			for(int i=0; i<t.size();i++) {
				System.out.println(t.get(i));
			}
			System.out.println();
			
		
			System.out.println("Posorden Sysout");
			b.posorden(); 
			System.out.println();
			
			System.out.println("Posorden 	ArrayList");
			b.posorden2();
			ArrayList y=b.posorden2();
			for(int i=0; i<y.size();i++) {
				System.out.println(y.get(i));
			}
			System.out.println();
			
			System.out.println("El nodo buscado es: ");
			System.out.println(b.buscarNodo(4).toString());
			
			b.eliminarNodo(4);
			System.out.println("Preorden Sysout");
			b.preorden();
			
			
			
			
			
			ArbolBB<Integer> e= new ArbolBB<Integer>();
			System.out.println();
			
			
			e.insertNodo(10);
			e.insertNodo(15);
			e.insertNodo(17);
			e.insertNodo(13);
			e.insertNodo(5);
			e.insertNodo(8);
			e.insertNodo(6);
			e.insertNodo(3);
			
			e.preorden();
			System.out.println();
			
			e.deleteNodo(17);
			e.preorden();
			
			/*ArbolB Z= new ArbolB();
			Z.armarArbol(b.preorden2(), b.inorden2());
			
			Z.inorden();*/
		/*}catch (ExceptionNodo e) {
			
			System.out.println(e.getMessage());
		}*/

		ArbAVL arbolito= new ArbAVL();
		arbolito.insertar(10);
		arbolito.insertar(5);
		arbolito.insertar(13);
		arbolito.insertar(1);
		arbolito.insertar(6);
		arbolito.insertar(17);
		
		arbolito.preorden();
		System.out.println(arbolito.getRaiz().toString());
		arbolito.insertar(16);
		arbolito.preorden();
	
	}

}
