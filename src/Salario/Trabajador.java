package Salario;
import java.util.Scanner;

/*se quiere manejar la info de los proyectos de una empresa. Se sabe que se tienen 20 proyectos y de ellos se necesita la informacion de horas trabajadas por mes. Al final se necesita saber la cantidad de horas total por proyecto, cantidad de horas que se ha trabajado por mes, cantidad total de horas.
construya una clase para manejar esta info. 
arreglo de trabajadores con la clase que ya tenemos de trabajador
métodos: crear, asignar, salario (tiene que buscar con el nombre (id) el trabajador en la otra clase), método buscar trabajador.*/


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
