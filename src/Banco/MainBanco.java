package Banco;

import java.util.Date;
import java.util.*;

public class MainBanco {

	public static void main(String[] args) {
		Banco banco = new Banco();
		Date hoy= new Date();
		
		banco.AddCliente("Pepito", "Juarez", "direccion", "telefono", "9595959595", hoy, "especial", 10000000);
		banco.AddCliente("Julian", "Perez", "direccion", "telefono", "94848845", hoy, "corriente", 10660000);
		banco.AddCliente("Angela", "Serna", "direccion", "telefono", "952839249", hoy, "especial", 10888800);
		banco.AddCliente("Nancy", "Arias", "direccion", "telefono", "923523595", hoy, "corriente", 185858000);
		
		System.out.println(Arrays.toString(banco.cuentasEspeciales()));
		
		/*System.out.println(banco.buscarClienteCC("9595959595"));
		System.out.println(banco.buscarClienteNom("Nancy", "Arias"));
		banco.DepositoCC(1000, "9595959595");
		banco.ExtraccionCC(4000, "952839249");
		banco.FinalMes();
		System.out.println(banco.Reporte());*/
		
	}

}
