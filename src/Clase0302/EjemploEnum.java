package Clase0302;

public class EjemploEnum {
	public enum Precio{BARATO, MEDIO, CARO};
	
	public enum PrecioRango{
		BARATOS(0,10000), MEDIOS(10000,100000), CAROS(100000,1000000);
		private double min;
		private double max;
		private PrecioRango(double min, double max) {
			this.min=min;
			this.max=max;
		}
		public double getMin() {
			return min;
		}
		public void setMin(double min) {
			this.min = min;
		}
		public double getMax() {
			return max;
		}
		public void setMax(double max) {
			this.max = max;
		}
		
	}; //lo de ordinal me sirve para algo
	
	
}
