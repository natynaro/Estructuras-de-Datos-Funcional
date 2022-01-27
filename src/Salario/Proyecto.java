package Salario;

import java.util.Arrays;

//calcular el promedio del salario de todos los trabajadores en un mes específico
//método que inserte un trabajador, osea, que específicamente un trabajador esté en tal posición del arreglo>>>>>>>>>>
//método de eliminar un trabajador, que el arreglo se modifique de tamaño y de todo

public class Proyecto {
 //acá es donde debía estar la lista de proyectos
	
	private Trabajador[] trabajadores =new Trabajador[0];
	
	//Asignar trabajadores al proyecto
	
	public void nuevoTrabajador(String nombre, double salarioBasico) {
		
	this.trabajadores=Arrays.copyOf(trabajadores, trabajadores.length+1);
	this.trabajadores[trabajadores.length-1]= new Trabajador (nombre, salarioBasico);
	
	}
	
	public Trabajador[] getTrabajadores() {
		return trabajadores;
	}

	public void setTrabajadores(Trabajador[] trabajadores) {
		this.trabajadores = trabajadores;
	}

	//cuando en el main me dan el nombre, te devuelvo la posición en el vector del trabajador
	public int buscarTrabajador(String nombre) {
		
		int k =1;
		while(k<=trabajadores.length && !(trabajadores[k].getNombre().equals(nombre))) {
			k++;
		}
		
		return (k<=trabajadores.length)? k: -1;
	}
	
	public double salarioTrabajador(String nombre) {
		
		int posicion= buscarTrabajador(nombre);
		
		if(posicion!=-1) {
			double dias= trabajadores[posicion].getDiasTrabajados();
			double salarioBasico=trabajadores[posicion].getSalarioBasico();
			double salario=(salarioBasico + dias)/24;
			trabajadores[posicion].setSalario(salario);
			return salario;
		}else{
			return -1;
		}
	
	}
	
	//busca el mínimo salario entre los trabajadores y devuelve el número
	public double salarioMinimo() {
		
		double aux=trabajadores[0].getSalario();
			
		//if el arreglo de trabajadores no está vacío	
		if(trabajadores.length!=0) {
			
			for (int i=0; i<trabajadores.length; i++) {
				if(aux > trabajadores[i].getSalario()) {
					aux= trabajadores[i].getSalario();
				}
			}
			return aux;
			
		}else {
			return -1;
		}
		
	}
	
	
	
	
}
