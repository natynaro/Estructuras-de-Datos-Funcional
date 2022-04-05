package Salario;

import java.util.*;

public class Proyecto {
	
	private Trabajador[] trabajadores =new Trabajador[0];
	
	public Trabajador[] getTrabajadores() {
		return trabajadores;
	}

	public void setTrabajadores(Trabajador[] trabajadores) {
		this.trabajadores = trabajadores;
	}
	
	//Asignar trabajadores al proyecto
	public void nuevoTrabajador(String nombre, double salarioBasico) {
		
	this.trabajadores=Arrays.copyOf(trabajadores, trabajadores.length+1);
	this.trabajadores[trabajadores.length-1]= new Trabajador (nombre, salarioBasico);
	
	}
	
	//cuando en el main me dan el nombre, te devuelvo la posición en el vector del trabajador
	public int buscarTrabajador(String nombre) {		
	int k =0;
		while(k<trabajadores.length && !(trabajadores[k].getNombre().equals(nombre))) {
			k++;
		}		
		return (k<(trabajadores.length))? k: -1;
	}

	//método buscar trabajador que también reciba de parámetro el index desde donde va a empezar a buscar
	public int buscarTrabajadorIndex(String nombre, int posicion) {		
		int k =0;
			while(k<trabajadores.length && !(trabajadores[k].getNombre().equals(nombre))) {
				k++;
			}		
			return (k<(trabajadores.length))? k: -1;
		}

	
	//setea en Trabajador el arreglo de meses
	/*public void cadaMes (String nombre, int mes, double dias){
			
		int posicion= buscarTrabajador(nombre);		
		trabajadores[posicion].nuevoMes(mes, dias);
	}
		
	//método que dado el mes para calcular del trabajador, devuelve el salario con la fórmula y hay que guardarlo en el arreglo del trabajador
	public double nuevoSalario(String nombre, int mes) {
		
		int posicion= buscarTrabajador(nombre);
		double salario=0;
		
		if (posicion!=-1) {
			double[] meses= trabajadores[posicion].getMeses();
			for(int i=0; i<meses.length; i++) {
				if(meses[i]!=-1) { //si el trabajador no trabajó ese mes, entonces en el arreglo de salario va a aparecer -1
					salario= (trabajadores[posicion].getSalarioBasico() + meses[mes-1])/24;
					trabajadores[posicion].nuevoSalario(mes, salario);
				}else {
					trabajadores[posicion].nuevoSalario(mes, -1);
				}
			}
			
		}else {
			return -1;
		}
		return (salario!=-1)? salario:-1;
	}
		
	//suma el salario de todos los meses de un trabajador específico y hace un promedio
	public double promedioTrabajador(String nombre) {
		int posicion= buscarTrabajador(nombre);
		double suma=0;
		double total=0;
		int aux=0;
			
		if(posicion!=-1) {
			double[] salarios= trabajadores[posicion].getSalario();
			for(int i=0;i<salarios.length; i++) {
				if(salarios[i]!=-1) { //si el salario no es -1(de que no trabajó ese mes) entonces sí tenlo en cuenta en el promedio
					suma=suma+salarios[i];
					aux++;
				}
			}
			total= suma/aux;	
			return total;
		}else {
			return -1;
		}
	}
	
	//calcular el promedio del salario de todos los trabajadores en un mes específico
	public double promedioSalarios(int mes) {
		double suma =0;
		double total=0;
		int aux=0;
		
		for(int i=0; i<trabajadores.length;i++) {
			double[] arreglo=trabajadores[i].getSalario();
			if(arreglo[mes-1]!=-1) { //si en ese arreglo del trabajador i el salario de ese mes no es -1, entonces tenlo en cuenta para la suma
				suma= suma + arreglo[mes-1];
				aux++;
			}
		}
		
		total= suma/aux;
		return total;
	}
	
	//método que inserte un trabajador, osea, que específicamente un trabajador esté en tal posición del arreglo	
	public String insertarTrabajador(int posicion, String nombre, double salarioBasico) {
		
		//verificar que la posicion que me dieron sí está en el rango
		
		if(posicion<=trabajadores.length && posicion>0) {
			Trabajador[] aux= Arrays.copyOf(trabajadores, trabajadores.length+1);	
			
			for(int k=0; k<(posicion); k++) {
				aux[k]=trabajadores[k];
			}
			
			aux[posicion-1]= new Trabajador(nombre, salarioBasico);
			
			// no sé si correr acá los métodos de llenado de meses y salarios porque no van a estar inicializados
			
			for(int k=posicion; k<aux.length; k++) {
				aux[k]=trabajadores[k-1];
			}
				
			this.trabajadores=Arrays.copyOf(aux, aux.length);
			return "Se añadió exitosamente";
		}else {
			return "Número de posición inválida";
		}		
	}
	//se puede ir corriendo las posiciones, desde la final con un for<---------------- en vez de la auxiliar que hice
	
	//método de eliminar un trabajador, que el arreglo se modifique de tamaño y de todo	
	/*ahora asumir que hay nombres iguales, entonces a eliminar todos los que 
	 * tengan ese mismo nombre*/
	public String quitarTrabajador(int posicion) {
		Trabajador[] aux= Arrays.copyOf(trabajadores, trabajadores.length-1); //va a tener 3 posiciones
		
		if(posicion<=trabajadores.length && posicion>0) {
			for(int k=0; k<(posicion); k++) {
				aux[k]=trabajadores[k];
			}
			for(int k=(posicion-1); k<aux.length; k++) {
				aux[k]=trabajadores[k+1];
			}
				
			this.trabajadores=Arrays.copyOf(aux, aux.length);
			return "Se eliminó exitosamente";
		}else {
			return "Número de posición inválida";
		}
	}
	
	public String quitarTrabajadorRepetido(String nombre) {
			 
		int index;
		//método buscar trabajador que también reciba de parámetro el index desde donde va a empezar a buscar
		while((index=buscarTrabajador(nombre))!=-1) {
			for(int k=index; k<trabajadores.length; k++) {
				trabajadores[k]=trabajadores[k+1];
			}
		}
		return "Se quitaron los trabajadores con ese nombre exitosamente";
	}

	//busca el mínimo salario entre los trabajadores y devuelve el número
	/*public double salarioMinimo() {
		
		double[] aux= trabajadores[0].getSalario();
		double a=aux[0];
				
		for (int i=0; i<trabajadores.length; i++) {
			
			aux=trabajadores[i].getSalario();
			
			for(int j=0; j<aux.length; j++) {
				if(a> aux[j]) {
					a=aux[j];
				}}}
		return a;
	}

	//hacer un método que me imprima el arreglo de trabajadores (pregunta, que era algo de string to string y por alguna razon aparecia e el debug)
	public String toString() {
		return "Proyecto [trabajadores=" + Arrays.toString(trabajadores) + "]";
	}
	
	//usar elcompareto string 
	/*The result is a negative integer if this String object lexicographically precedes 
	 * the argument string. The result is a positive integer if this String object 
	 * lexicographically follows the argument string. The result is zero if the strings 
	 * are equal*/
	
	public String nombreMayor() {
		String aux= trabajadores[0].getNombre();
		int result= 0;
		for (int i=0; i<trabajadores.length; i++) {
				result=aux.compareTo(trabajadores[i].getNombre());
				if(result<=0) {
					aux=trabajadores[i].getNombre();
				}
			}
		return aux;
	}
	
	public String nombreMenor() {
		String aux= trabajadores[0].getNombre();
		int result= 0;
		for (int i=0; i<trabajadores.length; i++) {
				result=aux.compareTo(trabajadores[i].getNombre());
				if(result>=0) {
					aux=trabajadores[i].getNombre();
				}
			}
		return aux;
	}
	
	
	
}



