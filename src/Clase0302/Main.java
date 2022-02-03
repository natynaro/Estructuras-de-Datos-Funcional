package Clase0302;

import Clase0302.EjemploEnum.PrecioRango;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PrecioRango precio= PrecioRango.valueOf("CAROS");
		PrecioRango precio2= PrecioRango.BARATOS;
		System.out.println(precio);
		System.out.println(precio2);
		
		switch(precio) {
		case BARATOS: System.out.println("Esta barato. comprenlo ya"); break;
		case CAROS: System.out.println("bye"); break;
		case MEDIOS: System.out.println("Esta mas o menos, comprelo despues"); 
		
		}
		

	}

}
