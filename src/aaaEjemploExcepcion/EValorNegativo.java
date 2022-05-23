package aaaEjemploExcepcion;

public class EValorNegativo extends Exception {


		public EValorNegativo(String string) {
			super(string);
		}
		
		public EValorNegativo() { 
			super("El valor está negativo");		}
}
