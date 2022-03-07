package EjercicioRectangulo;
import java.util.Scanner;
import java.io.*;

public class MainRectangulo implements Serializable{

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		
		Rectangulo r= new Rectangulo();
		
		r.setAltura(40);
		r.setAncho(1);
		r.guardarFichero();
		
		System.out.println(r.toString());
		
		//Si tenemos info en administrador (osea, en cada array atributo), correrlo, guardar esa info y ya despues poner el cargar ficheros dentro de admin
		
		
	
	}

}
