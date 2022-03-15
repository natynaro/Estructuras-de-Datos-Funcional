package Ejercicio2402;

import java.math.BigInteger;
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
	
	// Recursiva Cuando una cadena es que polindromo o no.
	
	public static boolean polindromoInternet(String cadena) {
		cadena = cadena.toLowerCase().replace("á", "a").replace("é", "e").replace("í", "i").replace("ó", "o")
				.replace("ú", "u").replace(" ", "").replace(".", "").replace(",", "");
		String invertida= new StringBuilder(cadena).reverse().toString();
		if(cadena==invertida) {
			return true;
		}else return false;
	}
	public static boolean palindromo(String cadena) {
		cadena = cadena.toLowerCase().replace("á", "a").replace("é", "e").replace("í", "i").replace("ó", "o")
				.replace("ú", "u").replace(" ", "").replace(".", "").replace(",", "");
		return palindromoR(cadena);
	}
	public static boolean palindromoR(String cadena) {
		
		if(cadena.length()==1) {
			return true;
			
		}else{
			char a= cadena.charAt(0);
			char b= cadena.charAt(cadena.length()-1);
			if(a==b) {
				return palindromoR(cadena.substring(1, (cadena.length()-1)));
			}else return false;
			
		}
		
	}
	  
	 //Hacer dos métodos, uno par y otro impar que sean booleanos (recursiva)
	
	
	public static boolean esParR(int num) {
		double numm= (double)num/2;
		if(numm%2==0) {
			return esParR((int)numm);
		}else if(numm==1){
			return true;
		}else return false;
		
	} 
	public static boolean esImparR(int num) {
		int resta=num-2;
		if(resta==1) {
			return true;
		}else if(resta==0) {
			return false;
		}else return esImparR(resta);
		
	} 
	
	public static int recursivo(int[] v, int i1, int i2) {
		int aux1, aux2;
		if(i1==i2) return v[i1];
		else {
			aux1= recursivo(v, i1, ((i1+i2)/2));
			aux2= recursivo(v, (((i1+i2)/2))+1, i2);
			if (aux1>aux2) return aux1; else return aux2;
		}
		
	}  
	
	
	
	//metodo recursivo que devuelva la inversa de una cadena
	
	public static String inversa(String cadena) {
		return inversaR(cadena, cadena.length()-1);
	}
	public static String inversaR(String cadena, int pos) {
		String result="";
		if(pos>=0) {
			result= cadena.charAt(pos)+ inversaR(cadena, pos-1);
		}
		return result;
		
	}
	
	
	//suma arreglos dividir y vencer
	
	
	public static int sumaAD(int[] n) throws EArrayVacio {
		long suma=0;
		if(n.length!=0 || n!=null) {
			int pos= n.length-1;
			return (int) (suma= sumaADR(n, 0, pos));
		}else {
			throw new EArrayVacio();
		}
		
	}
	
	public static int sumaADR(int[] n, int i1, int i2){
		int aux1, aux2;
		if(i1==i2) {
			return n[i1];
		}else {
			aux1=sumaADR(n, i1, ((i2+i1)/2));
			aux2=sumaADR(n,((i2+i1)/2)+1,i2 );;
			return aux1+aux2;
		}
		
	}
	
	
	public static long fibonacciIter(long n) {
		long anterior=1;
		long actual=1;
		for(int i=1; i<n; i++) {
			long tempAnterior=anterior;
			anterior=actual;
			actual+=anterior;
		}return actual;
	}
	
	public static long fibonacciR(long n) {
		if(n==0||n==1) {
			return n;
		}return fibonacciR(n-1)+fibonacciR(n-2);
		
	}
	
	/*variables que guarden info anterior
	crear un metodo fibonacci que la recursividad no esté tan larga
	torres de hanoi
	 */
	
	
	public static int[] hanoi(int n) {
		int[]origen= llenadoHanoi(n-2);;
		int[]auxiliar= new int[0]; 
		int[]llegada= new int[0];
		return hanoiR(n, origen,auxiliar,llegada);
		
	}
	public static int[] hanoiR(int m, int[]origen,int[]auxiliar,	int[]llegada) {
		llegada=Arrays.copyOf(llegada, llegada.length+1);
		auxiliar=Arrays.copyOf(auxiliar, auxiliar.length+1);
		if(m==1) {
			mover(origen,llegada);
			origen=Arrays.copyOf(origen, origen.length-1);
			llegada=Arrays.copyOf(llegada, llegada.length+1);
			llegada[llegada.length-1]=1;
			return llegada;
		}
		else {
			llegada=mover(origen,llegada);
			origen=Arrays.copyOf(origen, origen.length-1);
			auxiliar= mover(llegada,auxiliar);
			return hanoiR(m-1, origen, auxiliar, llegada);
		}	
	}
	public static int[] mover( int[]origen, int[]llegada) {
		llegada=Arrays.copyOf(llegada, llegada.length+1);
		llegada[llegada.length-1]=	origen[origen.length-1];
		return llegada;
	}
	
	public static long fibonacciNormal(long n) {
		return fibonacciRNormal((int) n, 1, 1);
	}
	
	public static long fibonacciRNormal(int n, long ant, long act) {
		if(n==0) {
			return act;
		}else {
			long aux=ant;
			ant=act;
			act+=aux;
			return fibonacciRNormal(n-1, ant, act);
		}
		
		
	}
	
	public static long fibonacciFast(long n) {
		int actual=(n==0)?0:1;
		return fibonacciFastR((int) n, 0, actual);
	}
	public static long fibonacciFastR(int n, long ant, long act){
		if(n<=1)return act;
		return fibonacciFastR(n-1, act, act+ant);
	}
	
	
	public static int[] llenadoHanoi(int n) {
		int[] result=new int[n];
		for(int i=0; i<n; i++) {
			result[i]= i+1;
		}
		return result;
	}
	
	
	
	
	
	
	public static BigInteger fibonacciBig(int n) {
		int actual=(n==0)?0:1;
		return fibonacciBigR(n, new BigInteger("0"), new BigInteger(Integer.toString(actual)));
	}
	public static BigInteger fibonacciBigR(int n, BigInteger ant, BigInteger act) {
		if(n<=1) {
			return act;
		}
		
		return fibonacciBigR(n-1, act, new BigInteger (act.toString()).add(ant));
	}
	
	
	/*public static boolean esParR(int num) {
		double numm= (double)num/2;
		if(numm%2==0) {
			return esParR((int)numm);
		}else if(numm==1){
			return true;
		}else return false;
		
	} */
	//numeros pares
	
	public static int[] pares(int[] array) {
		return paresR(0, array);
	}
	
	public static int[] paresR(int pos, int[]array) {
		if(pos==array.length-1) {
			if(array[pos]%2==0||array[pos]%-2==0) {
				return array;
			}else return Arrays.copyOf(array, array.length-1);
		}else {
			if(array[pos]%2==0||array[pos]%-2==0) {
				return paresR(pos+1,array);
			}else {
				
				for(int i=0, d=1; d<array.length;i++) {
					array[d]=array[i];
					d++;
				}
				return paresR(pos,Arrays.copyOf(array, array.length-1));
			}
		}
	}
	public static int cantPar(int[]a) {
		return cantParR(0,a);
	}
	public static int cantParR(int pos, int[]a) {
		if(pos==a.length) {
			return 0;
		}
		if(a[pos]%2==0||a[pos]%-2==0) {
			return 1+cantParR(pos+1,a);
		}
		return cantParR(pos+1,a);
	}
	//sumar matriz aera recursivas
	
	
	
}
