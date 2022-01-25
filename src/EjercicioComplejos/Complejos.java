package EjercicioComplejos;

public class Complejos {
	private int entero;
	private double real;
	
	
	public int getEntero() {
		return entero;
	}
	public void setEntero(int entero) {
		this.entero = entero;
	}
	public double getReal() {
		return real;
	}
	public void setReal(double real) {
		this.real = real;
	}
	
	public double Modulo() {
		//la raíz de la suma de los cuadrados del real y entero
		
		int entero;
		double real;
		entero= this.entero;
		real= this.real;
		
		double modulo= Math.sqrt(Math.pow(entero, 2)+(Math.pow(real, 2)));
		return modulo;
	}
	public double Argumento() {
		//arco tangente del real dividido del entero
		
		double real;
		entero= this.entero;
		real= this.real;
		
		double argumento=Math.atan((entero)/(real));
		if(real<0 && entero>0) {
			argumento= argumento + Math.PI;
		}else if(real<0 && entero<0) {
			argumento= argumento - Math.PI;
		}else if (real==0){
			if(entero ==0) {
				argumento=0;
			}else if(entero>0) {
				argumento=(Math.PI/2);
			}else {
				argumento=(3*Math.PI/2);
			}
		}
		return argumento;
	}
}
