package aaaBusqueda;

public class Tareas {
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

}
