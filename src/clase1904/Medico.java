package clase1904;

import java.util.*;

public class Medico {
	private String nombre;
	private Queue atender;
		
	public Medico(String nombre) {
		super();
		this.nombre = nombre;
		atender=  new LinkedList<Integer>();
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Queue getStack() {
		return atender;
	}
	public void setStack(Queue stack) {
		this.atender = stack;
	}

	
	
	
}
