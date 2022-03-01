package Ejercicio2402;

import EjemploExcepcion.EValorNegativo;

public class mainNum {

	public static void main(String[] args) throws EValorNegativo, EArrayVacio {
		try {
			int[] numm= {-2, 11, -4, 13, -5, 2};
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
		}catch (EValorNegativo e){
			System.out.println(e.getMessage());
		}
		
		
	}

}
