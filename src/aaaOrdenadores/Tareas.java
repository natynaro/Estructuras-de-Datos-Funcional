package aaaOrdenadores;

import java.util.Arrays;

public class Tareas {

	/*Se quiere eliminar los elementos duplicados de un arreglo,
	 *  una variante es realizar la operación sin ordenar, otra es 
	 *  ordenar y eliminar los duplicados después. Implemente ambas variantes
	 *   y estudie el tiempo de ejecución de ambos algoritmos.

/*
¿Se mejora la complejidad temporal  con los métodos de ordenamiento estudiados?*/
	
	
	public static Comparable[] duplicadosNoOrdenados(Comparable [] a) {
		Comparable[] result= a;
		
		for(int i=1, j=1; i<result.length-1; i++) {
			if(j<result.length) {
				i--;
			}
			while(j<result.length && !(result[i].compareTo(result[j])==0))j++;
			if(j<result.length) {
				for(int k=j; k+1<result.length;k++) {
					result[k] = result[k+1];					
				}
			result=Arrays.copyOf(result, result.length-1);
			}	
		}
		return result;	
	}
		
		/*for(int i=0, j=1; j<result.length; i++) {
			do {
			while(j<result.length && !(result[j].compareTo(result[i])==0))j++;
			if(j<result.length) {
				for(int k=j; k+2<result.length;k++) {
					result[k] = result[k+1];					
				}
				result=Arrays.copyOf(result, result.length-1);
				
			}}while(j<result.length);
			
			j=i+1;
		}
		
		*/
		
	
	
	
	public static Comparable[] duplicadosOrdenados(Comparable [] a) {
		Comparable[] result= selectionSort(a);
		for(int i=0, j=1; j+1<result.length; i++) {
			if(result[i].compareTo(result[j])==0) {
				for(int k=j; k+1<result.length;k++) {
					result[k] = result[k+1];
					result=Arrays.copyOf(result, result.length-1);
				}
				j=i+1;
			}
		}
		return result;
	}
	
	
	/* * Modifique el algoritmo de selección directa para ordenar crecientemente
     * los elementos  que se encuentran en las posiciones pares del arreglo y
     * en orden decreciente los elementos que se encuentran en las posiciones impares
     * del arreglo, manteniéndose en las posiciones pares e impares respectivamente.*/
	/*

	CON LA MISMA IDEA DEL SELECT SORT, VAMOS A COGER LAS 
	POSICIONES PARES CRECIENTEMENTE Y LAS IMPARES DECRECIENTES. 
	ASÍ MESCLADO RARO AAAAH EN SELECT SOR AAAHÇ

	COMPLEJIDAD DE LOS DOS METODOS DE DUPLICADOS*/
	
	public static Comparable[] a(Comparable [] a) {
		
		Comparable [] impar={};
		impar= Arrays.copyOf(a, a.length);
		Comparable [] par= {};
		
		
		for(int i=0; i<a.length; i++) {
			if(i%2==0) {
				par[par.length-1]=a[i];
				par=Arrays.copyOf(par, par.length+1);
			}else {
				impar[impar.length-1]=a[i];
				impar=Arrays.copyOf(impar, impar.length+1);
			}	
		}
		Comparable [] imparOrdenado= selectionSort(impar);
		Comparable [] parOrdenado= selectionSort(par);
		
		for(int i=0; i<a.length; i++) {
			if(i%2==0) {
				a[i]= parOrdenado[i-1];
			}else {
				a[i]= imparOrdenado[i-1];	
			}
		}
	return a;	
		
	}
	
	public static Comparable[] selectionSort(Comparable[] a) {
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
		return a;
	}
	
	public static Comparable[] selectionSortParImp(Comparable[] b) {
		Comparable[] a= Arrays.copyOf(b, b.length);
		for (int i = 0; i < a.length-2; i+=2) {
			int min=i;
			for (int j = i+2; j < a.length; j+=2) {
				if(a[j].compareTo(a[min])<0) {
					min=j;
				}
			}
			Comparable temp = a[i];
			a[i] = a[min];
			a[min] = temp;
		}
		
		for (int i = 1; i < a.length-1; i+=2) {
			int min=i;
			for (int j = i+2; j < a.length; j+=2) {
				if(a[j].compareTo(a[min])>0) {
					min=j;
				}
			}
			Comparable temp = a[i];
			a[i] = a[min];
			a[min] = temp;
		}
		return a;
	
	}




}
