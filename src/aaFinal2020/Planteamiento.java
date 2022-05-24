package aaFinal2020;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

public class Planteamiento {
	/*Con todo lo que estamos enfrentando en esta crisis del coronavirus, y la nueva etapa de reapertura, se hace cada vez más necesario el control de todas las personas. Se desea hacer un diseño de un sistema para tener el control de todo el personal de la Universidad EIA y de cómo se moverán dentro de la universidad, una vez comiencen las actividades docentes presenciales.
Se necesita guardar la información de todo el personal, ya sean empleados o estudiantes. De ellos se necesita: número de cédula, nombres y apellidos, fecha de nacimiento, dirección, síntomas y comorbilidades que presenta. Además, se necesita saber de cada una de las personas con las que vive: parentesco, edad, síntomas y comorbilidades que pueden presentar. De los profesores se necesita además el área donde trabaja. De los profesores de planta además el número de la oficina.
Se necesita llevar el control diario de entrada a la universidad, cada persona que entra y la fecha y hora a la que lo hace. Además, por cada salón (aula o laboratorio) de la universidad también se llevará control de entrada y salida de éste (persona que entra o sale y fecha y hora a la que lo hace).
Haga un diagrama de clases para resolver este problema.
Tenga en cuenta que el sistema será utilizado por la universidad para llevar un control en caso de algún brote o contagio. El sistema debe ser capaz de:
Adicionar entrada y salida de la universidad.
Adicionar entrada y salida de un salón.
Dada la cédula de una persona, saber sus fechas de entrada y salida a la universidad. Dado un salón y una fecha, saber todas las personas que estuvieron en ese día por horas.
Haga un diagrama de clases para resolver este problema. No es necesario que ponga los constructors ni los getters y setters.*/

/*Se necesita llevar el control diario de entrada a la universidad, 
 * cada persona que entra y la fecha y hora a la que lo hace. Además, 
 * por cada salón (aula o laboratorio) de la universidad también se 
 * llevará control de entrada y salida de éste (persona que entra o sale 
 * y fecha y hora a la que lo hace).*/
	
	

}

class ControlDiario{
	private LocalDate dia;

	public LocalDate getDia() {
		return dia;
	}

	public void setDia(LocalDate dia) {
		this.dia = dia;
	}

	public ControlDiario(LocalDate dia) {
		super();
		this.dia = dia;
	}
	
	
	
	
	
}

class Universidad extends ControlDiario{
	ArrayList<Persona> gente;
	
	ArrayList<Persona> personasAdentro;
	ArrayList<Persona> personasFuera;
	
	public void nuevaEntrada(String cedula) {
		Persona a= new Persona();
		a.setCedula(cedula);
		a.setFechaEntrada(LocalDateTime.now());
		this.personasAdentro.add(a);
	}
	public void nuevaSalida(String cedula) {
		Persona a= new Persona();
		a.setCedula(cedula);
		a.setFechaSalida(LocalDateTime.now());
		this.personasFuera.add(a);
	}
	
	public String fechasEntradaYSalida(String cedula) {
		HashMap <String, LocalDateTime> map = new HashMap <String, LocalDateTime> ();
		for(Persona cadena : gente) {
		     map.put(cadena.getCedula(), cadena.getFechaEntrada());
		  }
		HashMap <String, LocalDateTime> map2 = new HashMap <String, LocalDateTime> ();
		for(Persona cadena : gente) {
		     map2.put(cadena.getCedula(), cadena.getFechaSalida());
		   }
		return "La fecha de entrada fue" + gente.indexOf(cedula) + map.get(cedula) + "La fecha de salida fue " + map2.get(cedula);
	}
	
	
	public ArrayList<Persona> getPersonasAdentro() {
		return personasAdentro;
	}
	public void setPersonasAdentro(ArrayList<Persona> personasAdentro) {
		this.personasAdentro = personasAdentro;
	}
	public ArrayList<Persona> getPersonasFuera() {
		return personasFuera;
	}
	public void setPersonasFuera(ArrayList<Persona> personasFuera) {
		this.personasFuera = personasFuera;
	}
	public Universidad() {
		super(null);
		this.personasAdentro = null;
		this.personasFuera = null;
		// TODO Auto-generated constructor stub
	}
	public Universidad(ArrayList<Persona> personasAdentro, ArrayList<Persona> personasFuera) {
		super(LocalDate.now());
		this.personasAdentro = personasAdentro;
		this.personasFuera = personasFuera;
	}
	
	
}
class aula extends ControlDiario{
	private String numAula;
	ArrayList<Persona> personasAdentro;
	ArrayList<Persona> personasFuera;
	
	public void nuevaEntrada(String cedula) {
		Persona a= new Persona();
		a.setCedula(cedula);
		a.setFechaEntrada(LocalDateTime.now());
		this.personasAdentro.add(a);
	}
	public void nuevaSalida(String cedula) {
		Persona a= new Persona();
		a.setCedula(cedula);
		a.setFechaSalida(LocalDateTime.now());
		this.personasFuera.add(a);
	}
	
	public aula(String numAula, ArrayList<Persona> personasAdentro, ArrayList<Persona> personasFueraa) {
		super(LocalDate.now());
		this.numAula = numAula;
		this.personasAdentro = personasAdentro;
		this.personasFuera = personasFuera;
	}
	public aula(String numAula) {
		super(LocalDate.now());
		this.numAula = numAula;
		this.personasAdentro = null;
		this.personasFuera = null;
		// TODO Auto-generated constructor stub
	}
	public String getNumAula() {
		return numAula;
	}
	public void setNumAula(String numAula) {
		this.numAula = numAula;
	}
	public ArrayList<Persona> getPersonasAdentro() {
		return personasAdentro;
	}
	public void setPersonasAdentro(ArrayList<Persona> personasAdentro) {
		this.personasAdentro = personasAdentro;
	}
	public ArrayList<Persona> getPersonasFuera() {
		return personasFuera;
	}
	public void setPersonasFuera(ArrayList<Persona> personasFuera) {
		this.personasFuera = personasFuera;
	}
	
	
	public ArrayList personas(String salon, Date fecha) {
		return personasAdentro;
		/*Dado un salón y una fecha, saber todas las personas que estuvieron en ese día por horas.
		 */
	}
	
}


class Persona{
	private String cedula;
	private String nombre;
	private String apellidos;
	private Date fechaNacimiento;
	private String direccion;
	private String[] síntomas;
	private String[] comorbilidades;
	private int edad;
	private LocalDateTime fechaEntrada;
	private LocalDateTime fechaSalida;
	
	
	
	
	public Persona(String cedula, String nombre, String apellidos, Date fechaNacimiento, String direccion,
			String[] síntomas, String[] comorbilidades, int edad) {
		super();
		this.cedula = cedula;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.fechaNacimiento = fechaNacimiento;
		this.direccion = direccion;
		this.síntomas = síntomas;
		this.comorbilidades = comorbilidades;
		this.edad = edad;
	}
	
	public Persona() {
		super();
		this.cedula = null;
		this.nombre = null;
		this.apellidos = null;
		this.fechaNacimiento = null;
		this.direccion = null;
		this.síntomas = null;
		this.comorbilidades = null;
		this.edad = 0;
	}
	public String getCedula() {
		return cedula;
	}
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String[] getSíntomas() {
		return síntomas;
	}
	public void setSíntomas(String[] síntomas) {
		this.síntomas = síntomas;
	}
	public String[] getComorbilidades() {
		return comorbilidades;
	}
	public void setComorbilidades(String[] comorbilidades) {
		this.comorbilidades = comorbilidades;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}

	public LocalDateTime getFechaEntrada() {
		return fechaEntrada;
	}

	public void setFechaEntrada(LocalDateTime localDateTime) {
		this.fechaEntrada = localDateTime;
	}

	public LocalDateTime getFechaSalida() {
		return fechaSalida;
	}

	public void setFechaSalida(LocalDateTime fechaSalida) {
		this.fechaSalida = fechaSalida;
	}
	
	
	
	
}
class empleados extends Persona{
	private String area;
	
	

	public empleados(String cedula, String nombre, String apellidos, Date fechaNacimiento, String direccion,
			String[] síntomas, String[] comorbilidades, int edad, String area) {
		super(cedula, nombre, apellidos, fechaNacimiento, direccion, síntomas, comorbilidades, edad);
		this.area = area;
	}
	public empleados() {
		super(null,null,null,null,null,null,null,0);
		this.area = null;
		
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}
	
	
	
	
}

class ProfesoresPlanta extends Persona{
	private String oficina;
	
	public ProfesoresPlanta(String cedula, String nombre, String apellidos, Date fechaNacimiento, String direccion,
			String[] síntomas, String[] comorbilidades, int edad, String area) {
		super(cedula, nombre, apellidos, fechaNacimiento, direccion, síntomas, comorbilidades, edad);
		this.oficina = area;
	}
	public ProfesoresPlanta() {
		super(null,null,null,null,null,null,null,0);
		this.oficina = null;
		
	}

	public String getOficina() {
		return oficina;
	}

	public void setOficina(String oficina) {
		this.oficina = oficina;
	}
	
	
	
}
class estudiantes extends Persona{

	public estudiantes() {
		super();
		// TODO Auto-generated constructor stub
	}

	public estudiantes(String cedula, String nombre, String apellidos, Date fechaNacimiento, String direccion,
			String[] síntomas, String[] comorbilidades, int edad) {
		super(cedula, nombre, apellidos, fechaNacimiento, direccion, síntomas, comorbilidades, edad);
		// TODO Auto-generated constructor stub
	}
	
}