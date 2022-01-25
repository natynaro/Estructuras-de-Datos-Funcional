package Proyectos;

public class Proyectos {
	private double horasMes;
	private double horasTotal;
	private int numProyect;
	
	public Proyectos(int numProject, double horasMes) {
		this.numProyect=numProject;
		this.horasMes=horasMes;
		
	}

	public double getHorasMes() {
		return horasMes;
	}

	public void setHorasMes(double horasMes) {
		this.horasMes = horasMes;
	}

	public double getHorasTotal() {
		return horasTotal;
	}

	public void setHorasTotal(double horasTotal) {
		this.horasTotal = horasTotal;
	}

	public int getNumProyect() {
		return numProyect;
	}

	public void setNumProyect(int numProyect) {
		this.numProyect = numProyect;
	}
	
	
	
	
}
