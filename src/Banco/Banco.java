package Banco;

import java.util.Date;

public class Banco {
	
	private Cliente[] clientes= new Cliente[0];

	public Banco(Cliente[] clientes) {
		super();
		this.clientes = clientes;
	}

	
	public Cliente[] getClientes() {
		return clientes;
	}

	
	public void setClientes(Cliente[] clientes) {
		this.clientes = clientes;
	}
	
	//métodos
	
	//con los parámetros usar el constructor de cliente, y dependiendo del String tipoCuenta, asignar un string "especial", "corriente" que para todos sean lo mismo en caracteres
	public void AddCliente(String nombre, String apellidos, String direccion, String telefono, String cedula, Date nacimiento, String tipoCuenta){
		
	}

	public Cliente buscarCliente(String nombre) {
		return null;
	}
}
