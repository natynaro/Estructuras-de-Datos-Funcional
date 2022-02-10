package Banco;

import java.math.BigInteger;
import java.util.*;

public class Banco {
	
	private Cliente[] clientes= new Cliente[0];

	public Banco() {
	}
	
	public Cliente[] getClientes() {
		return clientes;
	}
	
	public void setClientes(Cliente[] clientes) {
		this.clientes = clientes;
	}
	
	//métodos
	
	//ME FALTA GENERAR EL CODIGO EN ADD CLIENTE ALEATORIAMENTE
	
	//con los parámetros usar el constructor de cliente, y dependiendo del String tipoCuenta, asignar un string "especial", "corriente" que para todos sean lo mismo en caracteres
	public void AddCliente(String nombre, String apellidos, String direccion, String telefono, String cedula, Date nacimiento, String tipoCuenta, double saldo){
		this.clientes=Arrays.copyOf(clientes, (clientes.length+1));
		Random random = new Random();
		String codigo=new BigInteger(50, random).toString(32); //generar un código aleatorio
		Date diaHoy= new Date();
	
		boolean condicion= true;
		int k=0;
		
		if(clientes.length!=0) {
			codigo=new BigInteger(50, random).toString(32);
		}else {
			while(condicion) {
				while(k<=clientes.length && !codigo.equals(clientes[k].getCuenta().getCodigo())) {
					k++;
				}
				if(k<=clientes.length) {
					codigo=new BigInteger(50, random).toString(32);
					k=0;
					
				}else {
					condicion= false;
				}
			}
		}
		
		if(tipoCuenta.toLowerCase().contains("especial")){
			tipoCuenta= "especial";
			Cuenta cuenta = new Cuenta(codigo, diaHoy, saldo, tipoCuenta);
			clientes[clientes.length-1]= new Cliente(nombre, apellidos, direccion, telefono, cedula, nacimiento, cuenta);
			
		}else if(tipoCuenta.toLowerCase().contains("corriente")) {
			tipoCuenta= "corriente";
			Cuenta cuenta = new Cuenta(codigo, diaHoy, saldo, tipoCuenta);
			clientes[clientes.length-1]= new Cliente(nombre, apellidos, direccion, telefono, cedula, nacimiento, cuenta);
		
		}else {System.out.println("Error, no se acepta ese tipo de cuenta, intentelo nuevamente");}
	
		}

	//buscar un cliente en el arreglo por nombre y apellidos y todos los qu ecumplan la condicion se añader a un arreglo derespuestas
	public Cliente[] buscarClienteNom(String nombre, String apellidos) {
		
		int i=0;
		Cliente[] res= new Cliente[0];
		
		while(i<clientes.length && !clientes[i].getNombre().equals(nombre) && !clientes[i].getApellidos().equals(apellidos))i++;
		if(i<clientes.length) {
			for(int k=i; k<clientes.length; k++) {
				if(clientes[i].getNombre().equals(nombre) && clientes[i].getApellidos().equals(apellidos)) {
					res= Arrays.copyOf(res, (res.length+1));
					res[(res.length-1)]=clientes[i];
				}
			}
			return res;
		}else {return null;}
		
	}
	
	//buscar un cliente en el arreglo por cédula
	public Cliente buscarClienteCC(String cc) {
		int i=0;
		while(i<clientes.length && !clientes[i].getCedula().equals(cc))i++;
		if(i<clientes.length) {
			return clientes[i];
		}else {return null;}
	}
	
	//elimina un cliente por su cedula
	public void eliminarCliente(String cedula) {
		int i=0;
		while(i<clientes.length && !clientes[i].getCedula().equals(cedula))i++;
		if(i<clientes.length) {
			for(int k=i;k<clientes.length; k++) {
				clientes[k]=clientes[k+1];
				clientes=Arrays.copyOf(clientes, (clientes.length-1));
			}
		}else {System.out.println("Error, no se encontró el cliente con esta cédula");}
	}
	
	//busca al cliente con esta cédula y le disminuye esa cantidad al saldo y añade la operación 
	public void ExtraccionCC(double cantidad,String CC) {
		Cliente cliente= buscarClienteCC(CC);
		cliente.extraccion(cantidad);
		
	}
	
	//busca el cliente que tenga ese mismo código en su cuenta para extraerle el saldo
	public void ExtraccionCuenta(double cantidad,String codigo) {
		int i=0;
		while(i<clientes.length && !clientes[i].getCuenta().getCodigo().equals(codigo)) i++;
		
		if(i<clientes.length) {
			clientes[i].extraccion(cantidad);
		}else {System.out.println("No se encontró la cuentacon ese código");}
	}
	
	//busca al cliente con esta cédula y le aumenta esa cantidad al saldo y añade la operación
	public void DepositoCC(double cantidad,String CC) {
		Cliente cliente= buscarClienteCC(CC);
		cliente.deposito(cantidad);
		
	}
	
	//busca el cliente que tenga ese mismo código en su cuenta para depositarle el saldo
	public void DepositoCuenta(double cantidad,String codigo) {

		int i=0;
		while(i<clientes.length && !clientes[i].getCuenta().getCodigo().equals(codigo)) i++;
		
		if(i<clientes.length) {
			clientes[i].deposito(cantidad);
		}else {System.out.println("No se encontró la cuentacon ese código");}
	}
	
	//en las cuentas corrientes amentar el 3% del saldo actual
	public void InteresCorriente(Cuenta cuenta) {
		cuenta.setSaldo((cuenta.getSaldo()*0.03)+cuenta.getSaldo());
	}
	
	//se hace apartir del 3% de los últimos 3 depósitos que se han realizado + el 1% del saldo actual, si no tiene 3 depósitos, entonces con los últimos realizados
	public void InteresEspecial(Cuenta cuenta) {
		double[] depositos=cuenta.getDepositos();
		double suma=0;
		if(depositos.length>=3) {
			suma= depositos[depositos.length-1]+ depositos[depositos.length-2]+ depositos[depositos.length-3];
			cuenta.setSaldo((suma*0.03)+cuenta.getSaldo()+ (cuenta.getSaldo()*0.01));
		}else {
			for(int i=0;i<depositos.length;i++) {
				suma=suma+depositos[i];
				cuenta.setSaldo((suma*0.03)+cuenta.getSaldo()+ (cuenta.getSaldo()*0.01));
			}
		}
		
	}
	
	//un método para que al final del mes aumente el respectivo interes de cada cuenta de los clientes con losdos métodos anteriores
	public void FinalMes() {
		for(int i=0; i<clientes.length;i++) {
			Cuenta cuenta=clientes[i].getCuenta();
			if (cuenta.getTipo().equals("especial")) {
				InteresEspecial(cuenta);
			}else {
				InteresCorriente(cuenta);
			}
		}
	}
	
	public StringBuffer Reporte() {
		
		StringBuffer reporte= new StringBuffer();
		for(int i=0; i<clientes.length;i++) {
			Cuenta cuenta= clientes[i].getCuenta();
			reporte.append(clientes[i].getNombre());
			reporte.append(", ");
			reporte.append(clientes[i].getApellidos());
			reporte.append(", ");
			reporte.append(cuenta.getSaldo());
			reporte.append(", ");
			reporte.append(cuenta.getDepositos());
			reporte.append(". ");
			
		}
		return reporte;
	}
	
	//cantidad de cuentas especiales cuenta[]
	
	public Cuenta[] cuentasEspeciales() {
		
		Cuenta[] cuestasEspeciales= new Cuenta[0];
		
		for(int i=0; i<clientes.length; i++) {
			if(clientes[i].getCuenta().getTipo().equals("especial")) { //Si tuviera subclase de Cuenta, usaría el Instance of Cuentaespecial
				cuestasEspeciales= Arrays.copyOf(cuestasEspeciales, (cuestasEspeciales.length+1));
				cuestasEspeciales[cuestasEspeciales.length-1]= clientes[i].getCuenta();
			}
		}
		return cuestasEspeciales;
	}

}
