package Ejercicio2402;

import EjemploExcepcion.EValorNegativo;

public class mainNum {

	public static void main(String[] args) throws EValorNegativo, EArrayVacio {
		
		long time_start=System.currentTimeMillis();
		System.out.println(time_start);
		System.out.println(num.fibonacciR(45));
		long time_end=System.currentTimeMillis();
		System.out.println(time_end);
		System.out.println("Se demoró el recur: "+(-time_start+time_end));
		
		time_start=System.currentTimeMillis();
		System.out.println(time_start);
		System.out.println(num.fibonacciIter(45));
		time_end=System.currentTimeMillis();
		System.out.println(time_end);
		System.out.println("Se demoró el iter: "+(-time_start+time_end));
		
		/*try {
			int[] numm= {-2,3, 5, 4, 11, -4, 13, -5, 200, 7, -10, 8, 44};
			
			
		
			//System.out.println(num.mayor(numm));
			//System.out.println(num.subsecuenciaMax(numm));
			//System.out.println(num.mayor2(numm));
			//System.out.println(num.subsecuenciaSumaMaxima(numm));
			long fact=5;
			System.out.println("El factorial es: "+num.factorial(fact));
			System.out.println("La sumatoria es: "+num.suma(fact));
			long[] nume= {-2, 11, -4, 13, -5, 2, 4444};
			System.out.println("La suma es: "+num.sumaA(nume));
			System.out.println("El maximo es: "+num.max(nume));
			String cadenaP="A ti no, bonita";
			String cadenaNoP="QUE";
			System.out.println("La cadena es palindromo: "+num.palindromo(cadenaP));
			System.out.println("La cadena es palindromo: "+num.palindromo(cadenaNoP));
			int numPar=8;
			int numImpar=9;
			System.out.println("El numero es par: "+num.esParR(numPar));
			System.out.println("El numero es par: "+num.esParR(numImpar));
			
			System.out.println("El numero es par: "+num.esImparR(numPar));
			System.out.println("El numero es par: "+num.esImparR(numImpar));
			
			System.out.println(num.recursivo(numm, 0, 12)); //devuelve el myor
			System.out.println(num.inversa(cadenaNoP));
			System.out.println(num.inversa(cadenaP));
			int[] hi= {3,7,0,1};
			System.out.println(num.sumaAD(hi));
			
			
			
			
		}catch (EValorNegativo e){
			System.out.println(e.getMessage());
		}*/
		
		
	}

}
