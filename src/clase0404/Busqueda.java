package clase0404;
import java.util.*;

public class Busqueda {
	
/* Búsqueda Secuencial, el arreglo no está ordenado*/
	
	/*Búsqueda del mayor (o menor) en una lista */
	public static int mayor(Comparable [] a){
		int indm=0;
		for (int i=1; i<a.length; i++){
			if (a[indm].compareTo(a[i])<0) {
				indm=i;
			}
		}
		return indm;
	}
	
	/*Búsqueda de un valor */
	public static int busqueda(Comparable[] ps, Comparable p3){
		int i=0;
		while ( i<ps.length && ps[i].compareTo(p3)!=0) i++ ;
		return(i==ps.length) ? -1: i;
	}
	//Ejercicios propuestos
	
	/*Buscar un elemento, no en todo el arreglo, sino a partir de un
	índice determinado
	 Si el elemento no se encuentra devolver el más próximo a él
	(hágalo con una lista de enteros)*/
	
	public static int buscarIndice(Comparable[] ps, Comparable p3, int i) {
		while ( i<ps.length && ps[i].compareTo(p3)!=0) i++;
		return(i==ps.length)? -1: i;
	}
	public static int buscarCercano(Comparable[] ps, Comparable p3) {
		int i=0;
		int auxMenor= 0, auxMayor=0;
		for(i=1; i<ps.length; i++) {
			if(Math.abs(ps[i].compareTo(p3))<Math.abs(ps[auxMenor].compareTo(p3))) {
				auxMenor=i;
			}else {
				auxMayor=i;
			}
		}
		
		return(Math.abs(ps[auxMenor].compareTo(p3))<Math.abs(ps[auxMayor].compareTo(p3)))? auxMenor: auxMayor;
	}
	
//Búsqueda binaria: la lista ya está ordenada+
	
	/*Búsqueda Binaria (iterativa), sin recursividad*/
	
	public static int busquedaBinIterativa(Comparable[] a, Comparable valor){
		int inicio=0;
		int fin=a.length-1;
		int medio;
		while (inicio<=fin){
			medio=(inicio+fin)/2; // posición media
			if (a[medio].compareTo(valor)==0){ // búsqueda satisfactoria
				return medio;
			}
			else{ // actualización de los límites
				if (a[medio].compareTo(valor)>0)
					fin=medio-1;
				else
					inicio=medio+1;
			}
		}
			return -1; // no se encontró el elemento
		}
	
	/*Ejercicio:
	Haga un método para que busque en un intervalo del arreglo.*/
	public static int buscarIntervalo(Comparable[] a, Comparable valor, int inicio, int fin) {
		int medio;
		while (inicio<=fin){
			medio=(inicio+fin)/2; // posición media
			if (a[medio].compareTo(valor)==0){ // búsqueda satisfactoria
				return medio;
			}
			else{ // actualización de los límites
				if (a[medio].compareTo(valor)>0)
					fin=medio-1;
				else
					inicio=medio+1;
			}
		}
			return -1; // no se encontró el elemento
		}

	
	
	//Búsqueda Binaria (recursiva)
	
	public static int busquedaBinRecursiva(Comparable[] a, Comparable valor, int inicio,int fin){
		int medio;
		if (inicio >= fin)
			return a[inicio].compareTo(valor)==0 ? inicio : -1;			
		else {
			medio=(inicio+fin)/2;
			if (a[medio].compareTo(valor)==0)
				return medio;
			else{
				if (a[medio].compareTo(valor)>0)
					return busquedaBinRecursiva(a,valor, inicio,medio-1);
				else
					return busquedaBinRecursiva(a, valor,medio+1,fin);
				}
		}
	}
/*Búsqueda secuencial O(n)
Búsqueda Binaria O(log(n))*/
	
	
	
	//EJERCICIO
	//1. Critique la siguiente versión de búsqueda secuencial: debería ser bianria
	public static int busca (int x, int v[]) {
		int m = 0;
		while (v[m] < x && m < v.length) ++m;
		if (m<v.length && v[m] == x) return m;
		else return -1;
	} 
	
	/*Cambiar el insert sort, de manera que esa posicion en donde se inserta en vez 
	 * de ir comparando, se use un método de búsqueda. */
	
	public static void insertSort(Comparable[] a){
		for( int i=1; i<a.length; i++ ) {
		Comparable temp=a[i]; //el que quiero insertar
		int j=i;
		while(j>0 && temp.compareTo(a[j-1])<0) {
			a[j]=a[j-1];
			j--;
		}
		a[j]= temp;
		}
		} 
	public static int buscarIntervaloCercano(Comparable[] ps, Comparable p3, int inicio, int fin) {
		
		int i=0;
		int auxMenor= inicio, auxMayor=inicio+1;
		for(i=inicio; i<ps.length; i++) {
			if(Math.abs(ps[i].compareTo(p3))<Math.abs(ps[auxMenor].compareTo(p3))) {
				auxMenor=i;
			}else {
				auxMayor=i;
			}
		}
		
		return(Math.abs(ps[auxMenor].compareTo(p3))<Math.abs(ps[auxMayor].compareTo(p3)))? auxMenor: auxMayor;

		}
	
	public static Comparable[] insertSortTarea(Comparable[] a){
		
		for( int i=1; i<a.length; i++ ) {
		Comparable temp=a[i]; 
		int j=buscarIntervaloCercano(a, temp, 0, i+1);
		
		while(j>0 && j<i) {
			a[j]=a[j-1];
			j--;
		}
			a[j]= temp;
		}
		return a;
	} 
	
	
	
}
