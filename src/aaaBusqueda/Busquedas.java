package aaaBusqueda;

public class Busquedas {
	
	/*Búsqueda secuencial O(n)
	Búsqueda Binaria O(log(n))*/
	
	/*-----------------BUSQUEDA BINARIA-----------------*/
	
	/*Un tipo de búsqueda que requiere acceso aleatorio a los
		elementos de la lista. Se parte de que la lista está
		ordenada y se realizan divisiones sucesivas del espacio de
		búsqueda (Divide y vencerás) comparando el elemento
		buscado con el elemento en el medio de la lista*/
	
	//busqueda binaria recursiva
	
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
	
	
	
	//busqueda binaria iterativa
	
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
	
	
	
	
	/*-----------------BUSQUEDA SECUENCIAL-----------------*/
	
	/*Un tipo de búsqueda en arreglos o listas de modo
		secuencial, elemento por elemento, de modo que la
		función del tiempo en relación al número de elementos es
		lineal, o sea, creciente proporcionalmente.*/
	
	//indice del mayor
	public static int mayor(Comparable [] a){
		int indm=0;
		for (int i=1; i<a.length; i++){
			if (a[indm].compareTo(a[i])<0) {
				indm=i;
			}
		}
			return indm;
	}
	
	//indice del menor
	public static int menor(Comparable [] a){
		int indm=0;
		for (int i=1; i<a.length; i++){
			if (a[indm].compareTo(a[i])>0) {
				indm=i;
			}
		}
			return indm;
	}
	
	//Búsqueda de un valor especifico
	
	public static int busqueda(Comparable[] ps, Comparable p3){
		int i=0;
		while ( i<ps.length && ps[i].compareTo(p3)!=0) i++ ;
		return(i==ps.length) ? -1: i;
		}
	
 public static int busquedaRecursiva(){
         
     }
    public static int busquedaBinRecursiva(int[] a, int valor, int inicio,int fin){
        int medio;
        if (a[inicio] >= valor)
            return  inicio;
        else {
            medio=(inicio+fin)/2;
            if (a[medio]>= valor)
                return medio;
            else{
            	if((valor-a[medio])<) {
            		
            	}
            }
                if (a[medio].compareTo(valor)>0)
                    return busquedaBinRecursiva(a,valor, inicio,medio-1);
                else
                    return busquedaBinRecursiva(a, valor,medio+1,fin);
            }
        }
}
