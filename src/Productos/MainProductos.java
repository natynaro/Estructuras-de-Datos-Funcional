package Productos;

public class MainProductos {

	public static void main(String[] args) {

		String nombre= "Juan Gonzales";
		String apellido= nombre.substring(5);
		System.out.println(apellido);
		
		String a = nombre.substring(3, 7);
		System.out.println(a);
		System.out.println(nombre.charAt(6));
	}

}
