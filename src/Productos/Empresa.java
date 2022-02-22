package Productos;

public class Empresa {
 private Productos[] productos= new Productos[10];
 
 enum Semana{
	 
	 LUNES("lunes", 0), MARTES("martes",1), MIERCOLES("miercoles", 2), JUEVES("jueves", 3),VIERNES("viernes", 4);
	 final int posicion;
	 final String dia;
	 
	 private Semana(String dia, int posicion) {
		 this.posicion=posicion;
		 this.dia=dia;
		 
	 }
	 
	 static int posicionSemana(String dia) {
		 String resultado= dia.toLowerCase();
		 
		 switch (resultado) {
		 case "lunes":
			 return LUNES.posicion;
			 
		 case "martes":
			 return MARTES.posicion;
			 
		 case "miercoles":
			 return MIERCOLES.posicion;
			 
		 case "jueves":
			 return JUEVES.posicion;
			 
		 case "viernes":
			 return VIERNES.posicion;
		default: 
			return -1;
		 }
	 }
	 
 }

 public void nuevoProducto(int posicion) {
	 int[] dias=new int[0];
	 productos[posicion]=new Productos(dias);
 }
 
 public int buscarProducto(String nombre) {
	 int i=0;
		 while(!productos[i].getNombre().equals(nombre)) {
			i++; 
		 }
	return (i<10 && i>-1)? i: -1;
}
  
 public String llenadoDias(String nombre, String dia, int dias) {
	 if(buscarProducto(nombre)!=-1) {
		 int[] semana=productos[buscarProducto(nombre)].getProduccionSemanal();
		 int posicion= Semana.posicionSemana(dia);
		 if(posicion!=-1) {
			 semana[posicion]=dias;
			 productos[buscarProducto(nombre)].setProduccionSemanal(semana);
			 return "Llenado del dia exitoso";
		 }else {
			 return "No se encontró el producto";
		 
		 }
	 }else {
		 return "No se encontró el producto";
	 }
	 }
 
 public double produccionProducto(String nombre) {
	 double sum=0;
	 if(buscarProducto(nombre)!=-1) {
		 int[] meses= productos[buscarProducto(nombre)].getProduccionSemanal();
		 for(int i=0; i<5; i++) {
			 if(meses[i]!=-1) {
				 sum=sum + meses[i];
			 }
		 }
		 return sum; 
	 }else {
		 return-1;
	 }
	 
 }
 
 public double produccionTotal() {
	 double sum=0;
	 for(int k=0;k<productos.length;k++) {
		 String nombre= productos[k].getNombre();
		 sum=sum+produccionProducto(nombre);
		 
	 }
	 return sum;
 }
 
}
