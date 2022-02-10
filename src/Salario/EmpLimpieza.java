package Salario;
//hacer elbanco y lo de empLimpieza

public class EmpLimpieza extends Trabajador {
	 private float norma;
	 private float cump;
	
	 public EmpLimpieza(String nombre, double salarioBasico, float norma, float cump) {
		super(nombre, salarioBasico);
		this.norma = norma;
		this.cump = cump;
	}
	 
	 public float salario() {
		 return (float) ((super.getSalarioBasico())+((super.getSalarioBasico())*(0.1*cump/norma)));
	 }
	 
}
