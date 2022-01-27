package Salario;
import java.util.*;

/*que los trabajadores tengan una lista de as cantidad de días trabajados por mes
 * 
 * hacer un método que devuelva el salario promedio de ese trabajador en todos los meses que tenga, teniendo en cuenta los meses que haya trabajado*/


public class Trabajador{
	private double salarioBasico;
	private String nombre;
	private double diasTrabajados;
	private double salario;
	private double[] meses = new double[0];
	
	public Trabajador (String nombre, double salarioBasico){
		this.nombre=nombre;
		this.salarioBasico=salarioBasico;
		
		
	}
	
	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	public double getSalarioBasico() {
		return salarioBasico;
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

	public double getDiasTrabajados() {
		return diasTrabajados;
	}

	public void setDiasTrabajados(double diasTrabajados) {
		this.diasTrabajados = diasTrabajados;
	}
	
	
}