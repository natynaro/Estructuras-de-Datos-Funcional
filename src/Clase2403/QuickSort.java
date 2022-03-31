package Clase2403;
import java.util.*;

public class QuickSort {
	
	public static void quickSort(Comparable[] a, int inicio, int fin){
		if (fin <= inicio)
			return;
		else {
			Comparable pivote = a[fin];
			int i = inicio-1;
			int j = fin;
			Comparable temp;
			while (i< j) {//busca un elemento mayor que pivote, si no para en el pivote(el último)
				while( a[++i].compareTo(pivote)<0);//se busca un elemento menor que el pivote, si no lo hay, para en el primero
				while( j > inicio && pivote.compareTo(a[--j])<0 );
				if( i < j ){//se intercambian los elementos
					temp=a[i];
					a[i]=a[j];
					a[j]=temp;
				}
			}//se sale del ciclo cuando la i>=j, si se cruzan los índices en i hay un elemento mayor que el pivote, la posición correcta del pivote es i deben intercambiarse
			temp=a[i];
			a[i]=a[fin]; // el pivote está en fin
			a[fin]=temp;
			int partition=i;
			quickSort( a, inicio, partition-1 );
			quickSort( a, partition+1, fin );
		}
	}
	
	
	public static void QuickSortRandom(Comparable[] a) {
		QuickSortRandomR(a,0, a.length-1);
	}
	
	//tener en cuenta que el pibote puede caer en su posicion (mitad), estar antes o despues. hABRÍA QUE HACER CAMBIOS PARA QU EFUNCIONE CORRECTAMENE 
	public static void QuickSortRandomR(Comparable[] a, int inicio, int fin) {
		if (fin <= inicio)
			return;
		else {
			Random rand= new Random();
	        int pivot = rand.nextInt(fin-inicio)+inicio;
			Comparable pivote = a[pivot];
			int i = inicio-1;
			int j = fin+1;
			Comparable temp;
			while (i< j) {//busca un elemento mayor que pivote, si no para en el pivote(el último)
				//CAMB
				while( a[++i].compareTo(pivote)<0);//se busca un elemento menor que el pivote, si no lo hay, para en el primero
				while( j > inicio && pivote.compareTo(a[--j])<0 );
				if( i < j ){//se intercambian los elementos
					temp=a[i];
					a[i]=a[j];
					a[j]=temp;
				}
			}//se sale del ciclo cuando la i>=j, si se cruzan los índices en i hay un elemento mayor que el pivote, la posición correcta del pivote es i deben intercambiarse
			temp=a[i];
			a[i]=a[fin]; // el pivote está en fin
			a[fin]=temp;
			int partition=i;
			quickSort( a, inicio, partition-1 );
			quickSort( a, partition+1, fin );
		}
	}
	private static void quickSortRandom(Comparable[] a, int inicio, int fin){
		Random r=new Random();
		if (fin <= inicio)
		return;
		else {//CAMBIO://El pivote se selecciona en una pocisión aleatoria
		int indexPivote=r.nextInt((fin-inicio))+inicio;
		//System.out.println("Pivote: "+ a[indexPivote]);
		Comparable pivote= a[indexPivote];
		int i = inicio-1;
		int j = fin+1; // //CAMBIO: Se cambia fin, para llamar con length-1
		Comparable temp;
		while (i< j) {//busca un elemento mayor que pivote, si no para en el pivote (el último)
		//CAMBIO: ADICIONAR i<fin y cambiar <0 por <=0 en ambos ciclos, para que salten el pivote
		while( i < fin && a[++i].compareTo(pivote)<=0);//se busca un elemento menor que el pivote, si no lo hay, para en el primero
		while( j > inicio && pivote.compareTo(a[--j])<=0 );
		if( i < j ){//se intercambian los elementos
		temp=a[i];
		a[i]=a[j];
		a[j]=temp;
		}
		}//se sale del ciclo cuando la i>=j
		//La posición correcta del pivote depende de dónde quedaron la i y la j
		int partition=i;
		if (i>indexPivote)
		partition=j;
		if (i>=indexPivote && j<=indexPivote)
		partition=indexPivote;
		else{
		temp=a[partition];
		a[partition]=a[indexPivote]; // cambio
		a[indexPivote]=temp;
		}
		//Ordenamiento.printLista(a);
		quickSortRandom( a, inicio, partition-1 );
		quickSortRandom( a, partition+1, fin );
		}
		}

		//CAMBIO: Llamar con a.length.1
		public static void quickSortRandom(Comparable[] a){
		quickSortRandom(a, 0, a.length-1);
		}	
	/*
	public static void random(int arr[],int low,int high)
    {
 
        Random rand= new Random();
        int pivot = rand.nextInt(high-low)+low;
         
        int temp1=arr[pivot]; 
        arr[pivot]=arr[high];
        arr[high]=temp1;
    }
	
	public static int partition(int arr[], int low, int high)
    {
       
        random(arr,low,high);
        int pivot = arr[high];
     
 
        int i = (low-1); // index of smaller element
        for (int j = low; j < high; j++)
        {
            // If current element is smaller than or
            // equal to pivot
            if (arr[j] < pivot)
            {
                i++;
 
                // swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
 
        // swap arr[i+1] and arr[high] (or pivot)
        int temp = arr[i+1];
        arr[i+1] = arr[high];
        arr[high] = temp;
 
        return i+1;
    }
	
	public static void sort(int arr[], int low, int high)
    {
        if (low < high)
        {
            int pi = partition(arr, low, high);
 
            // Recursively sort elements before
            // partition and after partition
            sort(arr, low, pi-1);
            sort(arr, pi+1, high);
        }
    }*/

	public static void printArray(int arr[])
	    {
	        int n = arr.length;
	        for (int i = 0; i < n; ++i)
	            System.out.print(arr[i]+" ");
	        System.out.println();
	    }
}
