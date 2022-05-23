package aaaPOO;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;
import java.util.*;

public class AdminConsultorio {

/*ah SEMANA SANTA
FOTO (USA LISTAS, COLAS Y PILAS, 
QUE ESO AYUDARÁ) HACER METODOS SEPARADITOS 
PARA QUE SIRVAN PARA CODIFICAR Y DECODIFICAR

SON DOS FOTOS*/
	
	//decodificar mensajes
	
	//varios medicos brindan consultas en los consultorios 
	private Medico[] Medicos;
	private Consultorio[] consultorios;
	private ArrayList turnos;
	
	//List<objeto> ejemploLista = new ArrayList<String>();
	
	public AdminConsultorio() {
		this.Medicos= new Medico[0];
		this.consultorios= new Consultorio[0];
		this.turnos= new ArrayList<String>();
	}
	
	private void nuevoMedico(String nombre, int consultorio) {//que pregunte el consultorio en el que va a estar y lo añada
		Medico medico= new Medico(nombre);
		this.Medicos=Arrays.copyOf(Medicos, Medicos.length+1);
		Medicos[Medicos.length+1]=medico;
	}
	private void nuevoConsultorio(int num, Medico[] medicos) { 
		
		Consultorio consultorio= new Consultorio(num, medicos);
		this.consultorios=Arrays.copyOf(consultorios, consultorios.length+1);
		consultorios[consultorios.length+1]=consultorio;
	}
	private int buscarMedico(String medico) {
		int k=0;
		while(k<Medicos.length && !Medicos[k].getNombre().equals(medico)) k++;
		return (Medicos[k].getNombre().equals(medico))? k: -1;
	}
	//mantener el sistema de turnos
	private void nuevoTurno(String medico, String paciente) {
		int k= buscarMedico(medico);
		Queue<String> lista= Medicos[k].getStack();
		lista.add(paciente);
		
	}
	
	private void pacienteAtendido(String medico) {
		int k= buscarMedico(medico);
		Queue<String> lista= Medicos[k].getStack();
		lista.poll();
	}
	
	private int cuantosPacientes(String medico) {
		int k= buscarMedico(medico);
		Queue<String> lista= Medicos[k].getStack();
		
		return (lista.isEmpty())? 0:lista.size();
	}
	
	
	//dar empleo en un consultorio a otro médico???
	
	
}
