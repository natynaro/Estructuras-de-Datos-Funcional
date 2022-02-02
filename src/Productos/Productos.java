package Productos;

public class Productos {
	private int[] produccionSemanal= new int[5];
	private int produccionTotal=0;
	String nombre="";
	
	
	
	public Productos(int[] dias) {
		this.produccionSemanal=dias;
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int[] getProduccionSemanal() {
		return produccionSemanal;
	}
	
	public void setProduccionSemanal(int[] produccionSemanal) {
		this.produccionSemanal = produccionSemanal;
	}
	
	public int getProduccionTotal() {
		return produccionTotal;
	}

	public void setProduccionTotal(int produccionTotal) {
		this.produccionTotal = produccionTotal;
	}
	
	
}
