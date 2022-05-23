package aaaOrdenadores;
import java.util.*;

public class Ordenadores {
	public static Random rnd = new Random();
	
	/*El más ráìdo es el quickSort*/
	
	 /* Prints the array */
		public static void printArray(int arr[])
	    {
	        int n = arr.length;
	        for (int i=0; i<n; ++i)
	            System.out.print(arr[i] + " ");
	        System.out.println();
	    }
	
	
	/*---------------BUBBLE SORT------------------*/
		
		/*No es un algoritmo eficiente,
		 *
		 * Su principio consiste en permutar valores de
			posiciones consecutivas, logrando que los valores
			más grandes vayan al final del arreglo.
		 * 
		 * 
		 * Se pasa una vez por el arreglo
			y se lleva el mayor valor al final. Hay que
			empezar de nuevo para lograr que vaya el
			mayor de los restantes a la penúltima
			posición y así sucesivamente.
		 * */

	//con ints
	public static void bubblesSort(int [] a) {
		for (int i = 0; i < a.length-1; i++) {
			for (int j = 0; j < a.length-1-i; j++) {
				if(a[j+1]<a[j]) {
					int temp=a[j];
					a[j] = a[j+1];
					a[j+1] = temp;
				}
			}
		}
	}
	
	//con Comparables
	public static void bubblesSort(Comparable [] a) {
		for (int i = 0; i < a.length-1; i++) {
			for (int j = 0; j < a.length-1-i; j++) {
				if(a[j+1].compareTo(a[j])<0) {
					Comparable temp=a[j];
					a[j] = a[j+1];
					a[j+1] = temp;
				}
			}
		}
	}
	
	/*---------------SELECCION DIRECTA------------------*/
	
	/*Este método consiste en dividir el arreglo en
	dos porciones: una ordenada y la otra no. Se
	comienza con la porción ordenada vacía y el
	arreglo completo en la porción desordenada;
	aquí se busca el menor elemento y se
	intercambia con el primero. Luego se busca
	el menor de los que restan y se intercambia
	con el segundo y así sucesivamente hasta
	terminar con todos.*/
	
	public static void selectionSort(Comparable[] a) {
		for (int i = 0; i < a.length-1; i++) {
			int im=i;
			for (int j = i+1; j < a.length; j++) {
				if(a[j].compareTo(a[im])<0) {
					im=j;
				}
			}
			Comparable temp = a[i];
			a[i] = a[im];
			a[im] = temp;
		}
	}
	
	//el inventado
	public static void seleccion(int A[]) {
        int i, j, menor, pos, tmp;
        for (i = 0; i < A.length - 1; i++) {      // tomamos como menor el primero
              menor = A[i];                       // de los elementos que quedan por ordenar                    
              pos = i;                            // y guardamos su posición
              for (j = i + 1; j < A.length; j++){ // buscamos en el resto
                    if (A[j] < menor) {           // del array algún elemento
                        menor = A[j];             // menor que el actual
                        pos = j;
                    }
              }
              if (pos != i){                      // si hay alguno menor se intercambia                         
                  tmp = A[i];
                  A[i] = A[pos];
                  A[pos] = tmp;
              }
        }
	}
	
	
	/*---------------INSERCION DIRECTA------------------*/
	
	/*En este método también el arreglo se divide
	en dos partes: una desordenada y otra
	ordenada que irá creciendo. En este caso se
	toma el primer elemento de la parte
	desordenada y se inserta en la parte
	ordenada, de forma que quede ordenado.
	Observar que al insertar hay que correr los
	elementos necesarios*/
	
	public static void insertSort(Comparable[] a) {
		for (int i = 0; i < a.length; i++) {
			Comparable temp = a[i]; //El que quiero insertar
			int j=i;
			while(j>0 && temp.compareTo(a[j-1])<0) {
				a[j] = a[j-1];
				j--;
			}
			a[j] = temp;
		}
	}
	
	//el inventado
	public static void insercionDirecta(int A[]){                                            
	    int p, j;
	    int aux;
	    for (p = 1; p < A.length; p++){ // desde el segundo elemento hasta
	              aux = A[p];           // el final, guardamos el elemento y
	              j = p - 1;            // empezamos a comprobar con el anterior
	              while ((j >= 0) && (aux < A[j])){ // mientras queden posiciones y el                                
	                                                // valor de aux sea menor que los
	                             A[j + 1] = A[j];   // de la izquierda, se desplaza a
	                             j--;               // la derecha
	              }
	              A[j + 1] = aux;       // colocamos aux en su sitio
	    }
	}
	
	
	/*---------------QUICKSORT PROFESORA------------------*/
	
	/*
	 * Escoger un elemento de la lista, denominado pivote
	 * 
	 * Reordenar la lista de forma que todos los elementos anteriores
		al pivote sean menores que él y todos los elemento posteriores
		serán mayores que él. Al final el pivote estará en su posición
		final y habrán dos listas no ordenadas. Esa operación partición.
	*
	* Recursivamente se ordena la sublista de los elementos menores
		y la sublista de los elementos mayores.
	
	
	* La base de la recursión son las listas de tamaño cero y uno, que
		están siempre ordenas. El proceso es finito, pues en cada
		iteración por lo menos un elemento es puesto en su posición
		final y no será manipulado en la siguiente iteración.
	 * */
	
	
	public static void quickSort(Comparable[] a) {
		quickSortr(a,0, a.length-1);
	}
	private  static void quickSortr(Comparable[] a, int inicio, int fin) {
		if(fin <= inicio) {
			return;
		}
		else {
			Comparable pivote = a[fin];
			int i = inicio-1;
			int j = fin;
			Comparable temp;
			while(i<j) {
				while(a[++i].compareTo(pivote)<0);
				while(j > inicio && pivote.compareTo(a[--j])<0);
				if(i<j) {
					temp=a[i];
					a[i] = a[j];
					a[j] = temp;
				}
			}
			temp=a[i];
			a[i]=a[fin];
			a[fin] = temp;
			int partition = i;
			quickSortr(a, inicio, partition-1);
			quickSortr(a, partition+1, fin);
		}
	}
	
	/*---------------QUICKSORT PIVOTE RANDOM------------------*/
	
	public static void quickSortRandomPivote(Comparable[] a) {
		quickSortrRandomPivote(a,0, a.length-1);
	}
	
	private  static void quickSortrRandomPivote(Comparable[] a, int inicio, int fin) {
		if(fin <= inicio) {
			return;
		}
		else {
			Comparable pivote = a[(int)(Math.random() * ((fin - inicio) + 1)) + inicio];
			int i = inicio-1;
			int j = fin;
			Comparable temp;
			while(i<j) {
				while(a[++i].compareTo(pivote)<0);
				while(j > inicio && pivote.compareTo(a[--j])<0);
				if(i<j) {
					temp=a[i];
					a[i] = a[j];
					a[j] = temp;
				}
			}
			temp=a[i];
			a[i]=a[fin];
			a[fin] = temp;
			int partition = i;
			quickSortr(a, inicio, partition-1);
			quickSortr(a, partition+1, fin);
		}
	}


	
	/*---------------MERGESORT------------------*/
	
	/*- Si la longitud del array es menor o igual a 1 entonces ya está ordenado.
	- El array a ordenar se divide en dos mitades de tamaño similar.
	- Cada mitad se ordena de forma recursiva aplicando el método MergeSort.*/
		
		
		/*oSEA, UN ORDENAMIENTO RECURSIVO*/
	
	public static Comparable[] mergeSortt(Comparable[] lista) throws Exception {
		return mergeSort(lista,0,lista.length-1);
	}
	
	private static Comparable[] mergeSort(Comparable[]lista, int inicio, int fin) throws Exception {
		if(inicio==fin) {
			return new Comparable[] {lista[inicio]};
		}else {
			Comparable[] list1=mergeSort(lista, inicio,((inicio+fin)/2));
			Comparable[] list2=mergeSort(lista, ((inicio+fin)/2)+1, fin);
			return juntar(list1, list2);
		}
	}
	//JUNTA LAS DOS LISTAS usando el metodo merge
	public static Comparable[] juntar (Comparable[] a, Comparable[] b) throws Exception {
		if(a==null || b==null) {
			throw new Exception("Alguna lista está vacía");
		}else {
			Comparable [] result = new Comparable[a.length+b.length];
			int i=0, j=0;
			while(i<a.length && j<b.length) {
				result[i+j]= (((a[i].compareTo(b[j])<=0)? a[i++]:b[j++]));
			}
			for(int k=i;k<a.length;k++) {
				result[k+j]=a[k];
			}
			for(int k=j;k<b.length;k++) {
				result[k+i]=b[k];
			}
			return result;
		}
		
	}
	
	
	
	/*---------------NO SÉ------------------*/
	public static boolean ordenado(Comparable[] a) { //De menor a mayor
		if(a.length == 0 || a.length == 1) return true;
		int index = 0;
		while(index<a.length-1 && a[index].compareTo(a[index+1]) <= 0) {
			index++;
		}
		return (index==a.length-1 && a[index-1].compareTo(a[index]) <= 0) ? true: false;
	}
}