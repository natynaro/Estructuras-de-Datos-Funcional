package EjercicioEvaluacion;

public class EvaluacionEstudiante {
	private double ev1;
	private double ev2;
	private double ev3;
	public double getEv1() {
		return ev1;
	}
	public void setEv1(double ev1) {
		this.ev1 = ev1;
	}
	public double getEv2() {
		return ev2;
	}
	public void setEv2(double ev2) {
		this.ev2 = ev2;
	}
	public double getEv3() {
		return ev3;
	}
	public void setEv3(double ev3) {
		this.ev3 = ev3;
	}
	
	
	public String calcularCalificacion() {
		//hazlo con switch
		int promedio = 0;
		String resultado="";
		promedio = (int) ((this.ev1 + this.ev2 + this.ev3)/3);
		switch (promedio) {
		case 5, 4: resultado="B";
		break;
		case 3: resultado= "R";
		break;
		case 2: resultado = "M";
		break;
		default: System.out.println("No tiene calificación, ocurrió un error");
		}
		return resultado;
	}
}
