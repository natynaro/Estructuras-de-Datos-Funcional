package Clase0102;

import java.util.*;

public class ClaseMain {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String palabra="";
		System.out.println("Igrese la palabra que quieres saber las vocales");
		palabra= scanner.next();
		System.out.println(Martes.vocales(palabra));
	
	}
	/*public class Ejercicio_recursividad_DDR_2 {
 
    public static void main(String[] args) {
 
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8};
 
        System.out.println(multiplicarArrayDyV(0, array.length - 1, array));
 
    }
 
    public static int multiplicarArrayDyV(int inicio, int fin, int[] array) {
 
        if (inicio == fin) {
            return array[inicio];
        } else {
 
            int mitad = (inicio + fin) / 2;
 
            int x = multiplicarArrayDyV(inicio, mitad, array);
            int y = multiplicarArrayDyV(mitad + 1, fin, array);
 
            return x * y;
 
        }
 
    }
 
}*/

}
