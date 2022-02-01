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

}
