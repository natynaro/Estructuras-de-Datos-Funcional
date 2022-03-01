package Ejercicio2402;

import java.util.*;

import EjemploExcepcion.EValorNegativo;

public class num {
	
	public num() {
		
	}
	
	public static int mayor(int[] array) {
		int sumaActual;//1
		int sumaMayor=0;//2	
		for(int i=0, j=i+1; i<array.length; i++) {//
			sumaActual=array[i];
			for(j=i+1;j<array.length; j++) {//
				sumaActual+=array[j];//
				if(sumaActual>sumaMayor) {//
					sumaMayor=sumaActual;//
				}
			}
			
		}
		return sumaMayor;//1
	}
	
	public static int mayor2(int[] array) {
		
		int sumaActual=0, sumaMax=0;//4
		for(int i=0, j=0; j< array.length; j++) {//2n+5
			sumaActual += array[j];//2n
			if(sumaActual>sumaMax) {
				sumaMax= sumaActual;
			}else if(sumaActual<0){//n
				i=j+1;//2n
				sumaActual=0;//2n
			}
		}
		return sumaMax;//1
		}//O(9N+9)= O(N)
				
	public static int subsecuenciaMax(int [] a) {
		
		int sumaActual=0, sumaMax=0, secIni, secFin;// 6
		for(int i=0, j=0; j< a.length; j++) {//2N+5
			sumaActual += a[j];//2N
			if(sumaActual>sumaMax) {//N
				sumaMax= sumaActual;//N
				secIni=i;//N
				secFin=j;//N
			}else if(sumaActual<0){
				i=j+1;
				sumaActual=0;
			}
		}
		
		return sumaMax;//1
		}//O(8N+11)
			
	public static int subsecuenciaSumaMaxima (int [] a)
	{
	 int sumaActual; //1
	 int sumaMax = 0;//2
	 for ( int i =0; i<a.length; i++)//2n+3
		 for ( int j=i; j<a.length; j++){//
			 
			 sumaActual = 0;//
			 for ( int k=i; k<=j; k++)//
				 sumaActual += a[k];//(n^3/3)+(n^2)+(2n/3)
			 
			 if (sumaActual > sumaMax){//
				 
				 sumaMax = sumaActual;//
				 int secIni = i;//
				 int secFin = j;//
			 }
		 }
	 	return sumaMax;//1
	 }
	public static long factorial(long n) throws EValorNegativo{
		if(n>=0 && Math.round(n)==n){
			if (n==1||n==0) {
				return 1;
			}else return n*factorial(n-1);
		} else throw new EValorNegativo("El numero debe ser mayor a 0 y entero, para poder realizar el factorial");
		
	}
	
	public static long suma(long n) throws EValorNegativo{
		if(n>=0 && Math.round(n)==n){
			if (n==1) {
				return 1;
			}else return n+suma(n-1);
		}else throw new EValorNegativo("El numero debe ser mayor a 0 y entero, para poder realizar la suma");
		
	}
	
	public static long sumaA(long[] n) throws EArrayVacio {
		long suma=0;
		if(n.length!=0 || n!=null) {
			int pos= n.length-1;
			suma= sumaAR(n, pos);
			return suma;	
		}else {
			throw new EArrayVacio();
		}
		
	}
	
	public static long sumaAR(long[] n, int pos){
		
		if(pos==0) {
			return n[0];
		}else {
			return n[pos]+sumaAR(n, pos-1);
		}
		
	}
	
	public static long max(long[] n) throws EArrayVacio{
		long max=0;
		if(n.length!=0 || n!=null) {
			int pos= n.length-1;
			max= maxR(n, pos);
			return max;	
		}else {
			throw new EArrayVacio();
		}
	}
	public static long maxR(long[] n, int pos) {
		if(pos==0) {
			return n[0];
		}else {
			return Math.max(n[pos], maxR(n, pos-1));
		}
		
	}

}
