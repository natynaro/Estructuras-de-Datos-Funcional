package Ejercicio2402;

public class EArrayVacio extends Exception{
	public EArrayVacio(String s) {
		super(s);
	}
	public EArrayVacio() {
		super("El ARREGLO NO TIENE VALORES");
	}
}
