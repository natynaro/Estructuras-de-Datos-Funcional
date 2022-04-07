package clase0404;

import java.util.*;

import ClaseCompares.Persona;

public class mainTarea {
	public static void main(String[] args) {
		
		System.out.println("\n"+ "Array original:");
		Comparable arr[] = {64, 34, 25, 12, 22, 11, 90, 22, 64};
       for(int i=0; i<arr.length;i++) {
    	   System.out.print(arr[i]+ " - ");
       }
       
       
       System.out.println("\n"+ "Array ordenado:");
       Comparable Ordenado[]= Busqueda.insertSortTarea(arr);;
       for(int i=0; i<Ordenado.length;i++) {
    	   System.out.print(Ordenado[i]+ " - ");
       }
		
       /*
       System.out.println("\n"+ "Array duplicados No Ordenados:");
       Comparable[] Array= tarea.duplicadosNoOrdenados(arr);
       for(int i=0; i<Array.length;i++) {
    	   System.out.print(Array[i]+ " - ");
       }
         
       System.out.println("\n"+ "Array duplicados Ordenados:");
       Comparable[] Array3= tarea.duplicadosOrdenados(arr);
       for(int i=0; i<Array3.length;i++) {
    	   System.out.print(Array3[i]+ " - ");
       }
       
       
       System.out.println("\n"+ "Array selectionSortParImp:");
       Comparable[] Array2= tarea.selectionSortParImp(arr);
       for(int i=0; i<Array2.length;i++) {
    	   System.out.print(Array2[i]+ " - ");
       }*/
       /*
       System.out.println();
       int a=Busqueda.busquedaBinIterativa(Ordenado, 22);
      if(a!=-1) {
    	  System.out.println("El número fue encontrado en la posición: " + (a+1));
      }else   System.out.println("El número no fue encontrado ");
      
      int a2=Busqueda.busquedaBinRecursiva(Ordenado, 25, 0, Ordenado.length-1);
      if(a2!=-1) {
    	  System.out.println("El número fue encontrado en la posición: " + (a2+1));
      }else   System.out.println("El número no fue encontrado ");*/
       
       /*
       
       Ej ej= new Ej(new Persona("Zrnesto", 30));
       Persona e1= (Persona) ej.getObj();
       System.out.println(e1.getNomb());
       System.out.println(ej.min(new Persona("Humberto",25)));
       
       //EVITA LOS CASTINGS
       Genericidad<Persona> ej2=new Genericidad<Persona>(new Persona("Ernesto", 30));
       Persona e= ej2.getObj();
       System.out.println(e.getNomb());
       System.out.println(ej2.min(new Persona("Humberto",25)));*/
	}
	
	
	
}
