package Salario;
import java.util.Scanner;


public class Trabajador {
	private double salarioBasico;
	private String nombre;
	private double diasTrabajados;
	Scanner scanner = new Scanner (System.in);
	
	public Trabajador (String nombre, double salarioBasico){
		this.nombre=nombre;
		this.salarioBasico=salarioBasico;
		
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
	
	public double Salario(){
		
		double salario=(this.salarioBasico + this.diasTrabajados)/24;
		System.out.println("El salario del trabajador es:"+ salario);
		return salario;
	}
	
	
	
}
