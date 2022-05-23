package aaaListas;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;

public class MainListas {

	public static void main(String[] args) {
		
	/*-----------LISTA SIMPLEMENTE ENLAZADA-----------*/
		ListaSimpEnlazada<Integer> lista1= new ListaSimpEnlazada<Integer>();
		lista1.addFirst(5);
		
		LinkedList<Integer> lista5= new LinkedList<Integer>();
		lista5.add(5);
		
	/*-----------LISTA DOBLEMENTE ENLAZADA-----------*/
		ListaDobleEnlazada<Integer> lista2= new ListaDobleEnlazada<Integer>();
		lista2.insertarCabezaLista(5);
		
	/*-----------LISTA CIRCULARES-----------*/
		ListaCircular<Integer> lista3= new ListaCircular<Integer>();
		lista3.insertar(5);
	}
	
	/*-----------ArrayList-----------*/
		ArrayList<String> lista = new ArrayList<String>();
		ListIterator<String> iterador = lista.listIterator();
	
	/*permite almacenar datos en memoria de forma similar 
	 * a los Arrays, con la ventaja de que el numero de 
	 * elementos que almacena, lo hace de forma dinámica, 
	 * es decir, que no es necesario declarar su tamaño 
	 * como pasa con los Arrays*/
	
	

}
