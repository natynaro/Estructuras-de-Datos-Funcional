package aaaEjemploExcepcion;

public class MainCuenta {
	public static void main(String[] args) {
	
	Cuenta c= new Cuenta(200);
	
	try {
		c.depositar(200);
		System.out.println("El saldo es: " + c.getSaldo());
		c.extraer(300);
		System.out.println("El saldo es: " + c.getSaldo());
		c.extraer(500);
		System.out.println("El saldo es: " + c.getSaldo());
		
	}catch (EValorNegativo e){
		System.out.println(e.getMessage());
	}catch(EValorMayorSaldo i) {
		System.out.println(i.getMessage());
	}
}
}
