package Salario;
import java.util.*;

public class Trabajador{
	
	private double salarioBasico;
	private String nombre;
	private double[] meses = new double[12];
	private double[] salario = new double[12];
	
	public Trabajador (String nombre, double salarioBasico){
		this.nombre=nombre;
		this.salarioBasico=salarioBasico;	
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
	
	public double[] getMeses() {
		return meses;
	}
	
	public void setMeses(double[] meses) {
		this.meses = meses;
	}
	
	public double[] getSalario() {
		return salario;
	}
	
	public void setSalario(double[] salario) {
		this.salario = salario;
	}
	
	public void nuevoSalario(int posicion, double salario) {
		this.salario[posicion-1]= salario;
	}

	public void nuevoMes(int mes, double dias) {
		// TODO Auto-generated method stub
		this.meses[mes]= dias;
	}
		
}