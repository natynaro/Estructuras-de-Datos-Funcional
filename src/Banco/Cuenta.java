package Banco;
import java.util.*;

public class Cuenta {
	private String codigo;
	private Date fechaCrear;
	private double saldo;
	private String tipo; //Enum?
	private double[] depositos= new double[0];
	private double[] transacciones= new double[0];
	
	public Cuenta(String codigo, Date fechaCrear, double saldo, String tipo) {
		super();
		this.codigo = codigo;
		this.fechaCrear = fechaCrear;
		this.saldo = saldo;
		this.tipo = tipo;
	}

	
	public String getCodigo() {
		return codigo;
	}

	
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	
	public Date getFechaCrear() {
		return fechaCrear;
	}

	
	public void setFechaCrear(Date fechaCrear) {
		this.fechaCrear = fechaCrear;
	}

	
	public double getSaldo() {
		return saldo;
	}

	
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	
	public String getTipo() {
		return tipo;
	}

	
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	
	public double[] getDepositos() {
		return depositos;
	}

	
	public void setDepositos(double[] depositos) {
		this.depositos = depositos;
	}

	
	public double[] getTransacciones() {
		return transacciones;
	}

	
	public void setTransacciones(double[] transacciones) {
		this.transacciones = transacciones;
	}

}
