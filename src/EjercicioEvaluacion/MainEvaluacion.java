package EjercicioEvaluacion;
import java.util.Scanner;

public class MainEvaluacion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner (System.in);
		EvaluacionEstudiante estudiante= new EvaluacionEstudiante();
		double cal1=0;
		double cal2=0;
		double cal3=0;
		
		
		System.out.println("Ingrese su primera calificación");
		cal1= scanner.nextDouble();
		estudiante.setEv1(cal1);
		
		System.out.println("Ingrese su segunda calificación");
		cal2= scanner.nextDouble();
		estudiante.setEv2(cal2);
		
		System.out.println("Ingrese su tercera calificación");
		cal3= scanner.nextDouble();
		estudiante.setEv3(cal3);
		
		
		System.out.println("Su calificación final es: " + estudiante.calcularCalificacion());
	}

}
