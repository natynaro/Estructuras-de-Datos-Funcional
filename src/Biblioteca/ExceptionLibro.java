package Biblioteca;

public class ExceptionLibro extends Exception {
	public ExceptionLibro(){
		super("Este libro no existe");
	}
	public ExceptionLibro(String string){
		super(string);
	}
}
