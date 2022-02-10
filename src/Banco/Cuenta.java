package Banco;
import java.util.*;

public class Cuenta {
	private String codigo;
	private Date fechaCrear;
	private double saldo;
	private double[] depositos= new double[0];
	private String tipo;
	
	public Cuenta(String codigo, Date fechaCrear, double saldo, String tipo) {
		super();
		this.codigo = codigo;
		this.fechaCrear = fechaCrear;
		this.saldo = saldo;
		this.setTipo(tipo);
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
	
	public double[] getDepositos() {
		return depositos;
	}
	
	public void setDepositos(double[] depositos) {
		this.depositos = depositos;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	@Override
	public String toString() {
		return "Cuenta [codigo=" + codigo + ", saldo=" + saldo + ", depositos=" + Arrays.toString(depositos) + ", tipo="
				+ tipo + "]";
	}
	
	

}
