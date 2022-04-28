package arboles;

public class MainArboles {

	public static void main(String[] args) {
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
		//Preorden= 10, 7, 5, 20, 9, 15, 12
		System.out.println("Preorden");
		a.preorden();
		System.out.println("Posorden");
		a.posorden();
		System.out.println("Inorden");
		a.inorden();

	}

}
