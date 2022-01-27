package Salario;
import java.util.*;

/*métodos: crear, asignar, salario 
 * (tiene que buscar con el nombre (id) el trabajador en la otra clase), método buscar trabajador.*/


public class Trabajador{
	private double salarioBasico;
	private String nombre;
	private double diasTrabajados;
	static Trabajador[] trabajadores =new Trabajador[0];
	Scanner scanner = new Scanner (System.in);
	
	
	public Trabajador (String nombre, double salarioBasico){
		this.nombre=nombre;
		this.salarioBasico=salarioBasico;
		
	}
	
	
	
	public static Trabajador[] getTrabajadores() {
		return trabajadores;
	}



	public static void setTrabajadores(Trabajador[] trabajadores) {
		Trabajador.trabajadores = Arrays.copyOf(trabajadores, trabajadores.length);
		
	}



	public double getSalarioBasico() {
		return salarioBasico;
	}
	public double getDiasTrabajados() {
		return diasTrabajados;
	}

	public void setDiasTrabajados(double diasTrabajados) {
		this.diasTrabajados = diasTrabajados;
	}

	public void setSalarioBasico(double salarioBasico) {
		this.salarioBasico = salarioBasico;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public double Salario(String nombre){	
		
		double dias=0;
		double salario=0;
		
		System.out.println("Ingrese el n�mero de d�as que " + nombre + " trabajó");
		dias=scanner.nextDouble();
		
		for (int i=0; i<trabajadores.length; i++) {
			if (trabajadores[i].nombre==nombre) {
				this.diasTrabajados= dias;
				salario=(this.salarioBasico + this.diasTrabajados)/24;
				System.out.println("El salario del trabajador " + nombre + " es: "+ salario);
			}
		}
		
		return salario;
		
	}
	
}
