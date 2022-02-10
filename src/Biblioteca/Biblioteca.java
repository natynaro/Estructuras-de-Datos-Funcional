package Biblioteca;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Date;
import java.util.Random;

public class Biblioteca {
	//libro tiene un codigo de 5 caracteres aleatorios, así, los ejemplares de ese libro tendrá el mismo codigo + otro caracter
	//haz esos métodos
	private Libro[] libros= new Libro[0];
	private Usuario[] usuario= new Usuario[0];
	private Prestamo[] prestamos= new Prestamo[0];
	
	public Biblioteca(Libro[] libros, Usuario[] usuario, Prestamo[] prestamos) {
		super();
		this.libros = libros;
		this.usuario = usuario;
		this.prestamos = prestamos;
	}

	
	public Libro[] getLibros() {
		return libros;
	}

	
	public void setLibros(Libro[] libros) {
		this.libros = libros;
	}

	
	public Usuario[] getUsuario() {
		return usuario;
	}

	
	public void setUsuario(Usuario[] usuario) {
		this.usuario = usuario;
	}

	
	public Prestamo[] getPrestamos() {
		return prestamos;
	}

	
	public void setPrestamos(Prestamo[] prestamos) {
		this.prestamos = prestamos;
	}
	
	//métodos que pidió a profe
	
	//crea un arreglo de ejemplares con los codigos de libros que pudo encontrar, para que así estos sean los prestados y a ellos les cambie su disponibilidad y cantidad y los añade alarreglo de prestamo
	public boolean prestamo(String[] codigosLibros, String CC) {
		
		//verificar la disponibilidad de cada código y crear un arreglo de ejemplares
		
		boolean sePudo= false;
		Ejemplar[] ejemplares= new Ejemplar[codigosLibros.length];
		for(int i=0; i<codigosLibros.length;i++) {
			if(buscarLibro(codigosLibros[i]).isExistenciaLibro()) {
				ejemplares[i]= buscarLibro(codigosLibros[i]);
				sePudo=true;
			}
		}
		if(sePudo!= false) {
			//crear un objeto prestamo en el arreglo de biblioteca
			this.prestamos= Arrays.copyOf(prestamos, (prestamos.length+1));
			// , Date fechaPrestamo, Date fechaDevolucion) {
			Date fechaPrestamo= new Date();
			Date fechaDevolucion= new Date(fechaPrestamo.getTime()+604800000);
			
			this.prestamos[(prestamos.length-1)]=new Prestamo(buscarUsuario(CC), ejemplares,fechaPrestamo, fechaDevolucion);
			
			//cambiar la disponibilidad en los ejemplares y la cantidad disponible en libro
			
			for(int i=0; i<ejemplares.length;i++) {
				ejemplares[i].setDisponibilidad(false);
				ejemplares[i].setCantDisponible((ejemplares[i].getCantDisponible()-1));
			}
			return true;
		
		}else {
			return false;	
		}
		
	}
	
	//busca el usuario con la cedula,y cuando coincida ese usuario con el usuario de algúnprestamo,elimina el prestamo y pone disponible los ejemplares y +cantidades
	public void devolucion(String CC) {
		Usuario usuarioDevolver= buscarUsuario(CC);
		if(!usuarioDevolver.getNombre().equals("no existe el usuario")) {
			int i=0;
			while(i<prestamos.length && !prestamos[i].getUsuario().equals(usuarioDevolver)) {
				i++;
			}
			if(i<prestamos.length) {
				// setear la disponibilidad y cantidad
				Ejemplar[] ejemplares= prestamos[i].getLibros();
				for(int k=0; k<ejemplares.length;k++) {
					ejemplares[k].setDisponibilidad(true);
					ejemplares[k].setCantDisponible((ejemplares[i].getCantDisponible()+1));
				}
				//eliminar el prestamo
				for(int k=i; k<prestamos.length; k++) {
					prestamos[k]=prestamos[k+1];
				}
				this.prestamos=Arrays.copyOf(prestamos, (prestamos.length-1));
			}
		}
	}
	
	//busca un libro con el código, llama al método de libro buscarEjemplar y devuelve el ejemplar disponible o si ninguno está disponible, si no encuentra en sí el libro, devuelve un no existe 
	public Ejemplar buscarLibro(String codigo) {//el  parametro debería ser el título
		int i=0;
		while(i<libros.length && !libros[i].getCodigoLibro().equals(codigo))//este whilepuede ser optimizado
			i++;
		if(i<libros.length) {
			return libros[i].buscarEjemplar();
		}else {
			Ejemplar noExiste= new Ejemplar("", "", "", "", "", null, 0, false,"no existe este libro", false, false);	
			return noExiste;
		}
	}
	
	//Con la cédula buscar el usuario en el arreglo de usuarios que tiene biblioteca y devuelve el usuario en tal de existir
	public Usuario buscarUsuario(String CC) {
		int i=0;
		while(i<usuario.length && !usuario[i].getCC().equals(CC)) {
			i++;
		}
		if(i<usuario.length) {
			return usuario[i];
		}else {
			Usuario noExiste = new Usuario("no existe el usuario", "", "", "");
			return noExiste;
		}
		
	}
		
	//usa el constructor de libro con los datos que me dé éste método
	public void addLibro(String titulo, String autores, String editorial, String edicion, int cantDisponible) {
		
		this.libros=Arrays.copyOf(libros,(libros.length+1));
		Random random = new Random();
		String codigo=new BigInteger(25, random).toString(32);
		boolean condicion =true;
		int k=0;
		
		if(libros.length!=0) {
			while(condicion) {
				while(k<libros.length && !codigo.equals(libros[k].getCodigoLibro())) k++;
				if(k<libros.length) {
					codigo=new BigInteger(25, random).toString(32);
					k=0;
				}else {
					condicion= false;
				}
			}
		}

		Ejemplar[] ejemplares= new Ejemplar[0]; 
		libros[(libros.length-1)]= new Libro(titulo, codigo, autores, editorial, edicion, ejemplares, cantDisponible, true);
	}
	
	//Busca el libro con el codigo en el arreglo de biblioteca y añada a esa posicion un nuevo ejemplar con este código
	public void addEjemplar(String codigolibro) {
		int i=0;
		Random random = new Random();
		String bb=new BigInteger(25, random).toString(32);
		String codigo= codigolibro + bb;
		
		if(libros.length!=0) {
			while(i<libros.length && !libros[0].getCodigoLibro().equals(codigolibro)) {
				i++;
			}
			if(i<libros.length) {//encontró el libro
				
				boolean condicion =true;
				int j=0;
				Ejemplar[] ejemplares= libros[i].getEjemplares();
				
				if(libros[i].getEjemplares().length!=0) {//si hay ejemplares voy a empezar a comparar
					while(condicion){
						while(j<libros[i].getEjemplares().length && !codigo.equals(ejemplares[j].getCodigoEjemplar())) j++;
						if(j<ejemplares.length) {//voya volver a hacer un random y a volver a
							codigo=codigolibro + new BigInteger(25, random).toString(32);
							j=0;
						}else {
							String codigoEjemplar = codigolibro + codigo;
							libros[i].addEjemplar(codigoEjemplar); //usa el método que tiene libro, debería haber otro else para cuando  me devuelve el libro no disponible		
							condicion= false;
						}
					}	
				}else {// si no hay ejemplares simplemente lo creo
					codigo=new BigInteger(25, random).toString(32);
					String codigoEjemplar = codigolibro + codigo;
					libros[i].addEjemplar(codigoEjemplar);
				}
					
			}else {//no hay libros con ese código
				System.out.println("No hay ningún libro con este codigo");;
			}
		}else {
			System.out.println("No hay ningún libro en la biblioteca,cree el libro antes de añadir ejemplar");;
		}
		
			
			
	}


	//Busca el libro con el codigo en el arreglo de biblioteca y llame al metodo de eliminar ejemplares con este código
	public void eliminarEjemplar(String codigolibro, String codigoEjemplar) {
		int i=0;
		while(i<libros.length && !libros[0].getCodigoLibro().equals(codigolibro)) {
			i++;
		}
		if(i<libros.length) {
			libros[i].eliminarEjemplar(codigoEjemplar);//usa el método que tiene libro
		}//else nada porque es un void
	}
	
	//Le doy el código del libro que quiero eliminar y cambia el arreglo de libros de acuerdo a esto
	public void eliminarLibro(String codigo) {
		int i=0;
		while(!libros[i].getCodigoLibro().equals(codigo)) {
			i++;
		}
		if(i<libros.length) {
			for(int k=i; k<libros.length;k++) {
				libros[k]= libros[k+1];
			}
		this.libros=Arrays.copyOf(libros, (libros.length-1));
		} //debería haber unelse de caundo ese libro no existe
	}

	//le pregunté a la profe, no sé nada
	public void cargarUsuarios() {
		
	}


}
