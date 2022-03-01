package Ejercicio2402;

public class EValorNegativo extends Exception {


		public EValorNegativo(String string) {
			super(string);
		}
		
		public EValorNegativo() { 
			super("El valor está negativo");		}
}
