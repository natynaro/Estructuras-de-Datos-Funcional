package Ejercicio2402;

import EjemploExcepcion.EValorNegativo;

public class mainNum {

	public static void main(String[] args) throws EValorNegativo, EArrayVacio {
		try {
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
			
			
		}catch (EValorNegativo e){
			System.out.println(e.getMessage());
		}
		
		
	}

}
