package aaFinal2020;

import java.util.*;

import EjemploExcepcion.EValorMayorSaldo;

/*Adicione una excepción creada por usted para que en el primer método buscarPaqueteVidrio(String barrio),
 *  si el barrio no está en el listado, devuelva el siguiente mensaje textual: "El barrio no ha reciclado 
 *  vidrio". Tenga cuidado al adicionar el try-catch en el main, vea dónde debe ir exactament y ponga a 
 *  imprimir en el catch el getMessage de la excepción que cree.
*/

class EBarrio extends Exception {
	private String string;
	public EBarrio(String string) {
		super(string);
		this.string = string;
	}

	public EBarrio() {
		super("El barrio no ha reciclado vidrio");

	}
}


class PaqueteReciclaje{
 private String barrio;
 private double kg;
 private boolean aceptable;
 private double kgmalos; 
 
 
 
 public String getBarrio() {
	return barrio;
}
public void setBarrio(String barrio) {
	this.barrio = barrio;
}
public double getKg() {
	return kg;
}
public void setKg(double kg) {
	this.kg = kg;
}
public boolean isAceptable() {
	return aceptable;
}
public void setAceptable(boolean aceptable) {
	this.aceptable = aceptable;
}
public double getKgmalos() {
	return kgmalos;
}
public void setKgmalos(double kgmalos) {
	this.kgmalos = kgmalos;
}
public PaqueteReciclaje(String barrio, double kg, boolean aceptable, double kgmalos) {
     super();
     this.barrio = barrio;
     this.kg = kg;
     this.aceptable = aceptable;
     this.kgmalos = kgmalos;
 }
 public double paquetesBuenos() {
	 return (this.kg-this.kgmalos);
 }
 
}

class PaqueteVidrio extends PaqueteReciclaje{  
	private double kgIncoloro;
	private double kgVerde;
	private double kgAmbar;
	
	
	public PaqueteVidrio(String barrio, double kg, boolean aceptable, double kgmalos, double kgIncoloro, double kgVerde,
			double kgAmbar) {
		super(barrio, kg, aceptable, kgmalos);
		this.kgIncoloro = kgIncoloro;
		this.kgVerde = kgVerde;
		this.kgAmbar = kgAmbar;
	}


	public double getKgIncoloro() {
		return kgIncoloro;
	}


	public void setKgIncoloro(double kgIncoloro) {
		this.kgIncoloro = kgIncoloro;
	}


	public double getKgVerde() {
		return kgVerde;
	}


	public void setKgVerde(double kgVerde) {
		this.kgVerde = kgVerde;
	}


	public double getKgAmbar() {
		return kgAmbar;
	}


	public void setKgAmbar(double kgAmbar) {
		this.kgAmbar = kgAmbar;
	}
	
	
	
	
}

class PaquetePlastico extends PaqueteReciclaje{
	private double kgDuro;
	private double kgBlando;
	
	
	public PaquetePlastico(String barrio, double kg, boolean aceptable, double kgmalos, double kgDuro,
			double kgBlando) {
		super(barrio, kg, aceptable, kgmalos);
		this.kgDuro = kgDuro;
		this.kgBlando = kgBlando;
	}


	public double getKgDuro() {
		return kgDuro;
	}


	public void setKgDuro(double kgDuro) {
		this.kgDuro = kgDuro;
	}


	public double getKgBlando() {
		return kgBlando;
	}


	public void setKgBlando(double kgBlando) {
		this.kgBlando = kgBlando;
	}
	
	
	
}

class PaqueteCarton extends PaqueteReciclaje{

	public PaqueteCarton(String barrio, double kg, boolean aceptable, double kgmalos) {
		super(barrio, kg, aceptable, kgmalos);
		
	}
 
}

class UnidadReciclaje{
	
 private PaqueteReciclaje[] paquetes; 
 
 public UnidadReciclaje(PaqueteReciclaje[] paquetes) {
     this.paquetes = paquetes;
 }


 public double [] buscarPaqueteVidrio(String barrio) throws EBarrio {
	 double [] lista= new double [3];
	 PaqueteVidrio pos=busquedaVidrio(barrio);
	 lista[0]= pos.getKgAmbar();
	 lista[1]= pos.getKgVerde();
	 lista[2]= pos.getKgIncoloro();
      return lista;           
 }
 public PaqueteVidrio busquedaVidrio(String barrio) throws EBarrio{
	int i=0;
	while (i<paquetes.length && paquetes[i].getBarrio()!=barrio && !(paquetes[i] instanceof PaqueteVidrio) ) {
		i++;
	}
	if(paquetes[i].getBarrio()==barrio) {
		return (PaqueteVidrio) paquetes[i];
	}else throw new EBarrio();
}
 public int busqueda(String barrio) throws EBarrio{
		int i=0;
		while (i<paquetes.length && paquetes[i].getBarrio()!=barrio) {
			i++;
		}
		if(paquetes[i].getBarrio()==barrio) {
			return i;
		}else throw new EBarrio();
	}

 public String[] barriosConPaquetes() {
	 ArrayList<String> barrios= new ArrayList<String>();
	 for (int i=0; i<paquetes.length;i++) {
		 while(!barrios.contains(paquetes[i].getBarrio())) barrios.add(paquetes[i].getBarrio());
	 }
	 String[] a= new String[barrios.size()];
	 int j=0;
	 for(String b: barrios) {
		 a[j]=b;
		 j++;
	 };
     return a;
 }
  
 public double[] kgPorBarrios() throws EBarrio {
	 String[] barrios= barriosConPaquetes();
	 double c=0;
	 int pos=0;
	 double[] total=new double[barrios.length];
	 int cont=0;
	 for(String a: barrios) {
		 pos= busqueda(a);
		 total[cont]= paquetes[pos].paquetesBuenos();
		 cont++;
	 }
	 
     return total;
 }
 
 public double[] kgPlasticoDuro() throws EBarrio {
	 String[] barrios= barriosConPaquetes();
	 double[] total=new double[barrios.length];
	 int cont=0;
	 
	 for(String b:barrios) {
		 PaquetePlastico p= busquedaPlastico(b);
		 total[cont]= p.getKgDuro();
		 cont++;
	 }
	 
     return total;
 }
 public PaquetePlastico busquedaPlastico(String barrio) throws EBarrio{
	int i=0;
	while (i<paquetes.length && paquetes[i].getBarrio()!=barrio && !(paquetes[i] instanceof PaquetePlastico) ) {
		i++;
	}
	if(paquetes[i].getBarrio()==barrio) {
		return (PaquetePlastico) paquetes[i];
	}else throw new EBarrio();
}
 
}

public class Quiz1 {

 public static void main(String[] args) {
		Scanner in = new Scanner(System.in);		
		String ejercicio=in.nextLine();
		String barrio = null;
		if (ejercicio.equals("0"))
			barrio=in.nextLine();
		String line;
		PaqueteReciclaje[] paquetes=new PaqueteReciclaje[0];
		while ((line=in.nextLine()).compareTo("")!=0) {
			String[] lineSplit=line.split(" ");
			paquetes=Arrays.copyOf(paquetes, paquetes.length+1);
			//PaqueteVidrio(String barrio, double kg, boolean aceptable, double kgmalos, double kgIncoloro, double kgVerde, double kgAmbar)
			if (lineSplit[0].equals("V"))
				paquetes[paquetes.length-1]=new PaqueteVidrio(lineSplit[1], Float.parseFloat(lineSplit[2]), 
						Boolean.parseBoolean(lineSplit[3]), Float.parseFloat(lineSplit[4]), Float.parseFloat(lineSplit[5]), Float.parseFloat(lineSplit[6]), Float.parseFloat(lineSplit[7]));
			
			//PaquetePlastico(String barrio, double kg, boolean aceptable, double kgmalos, double kgDuro, double kgBlando)
			if (lineSplit[0].equals("P"))
				paquetes[paquetes.length-1]=new PaquetePlastico(lineSplit[1], Float.parseFloat(lineSplit[2]), 
						Boolean.parseBoolean(lineSplit[3]), Float.parseFloat(lineSplit[4]), Float.parseFloat(lineSplit[5]), Float.parseFloat(lineSplit[6]));
			if (lineSplit[0].equals("C"))
				paquetes[paquetes.length-1]=new PaqueteCarton(lineSplit[1], Float.parseFloat(lineSplit[2]), 
						Boolean.parseBoolean(lineSplit[3]), Float.parseFloat(lineSplit[4]));
			
		}
		UnidadReciclaje u=new UnidadReciclaje(paquetes);
		if (ejercicio.equals("0")) {
			double[] pvidrio;
			try {
				pvidrio = u.buscarPaqueteVidrio(barrio);
				for (int i=0;i<pvidrio.length;i++) {
					if (i!=0)
						System.out.print(", ");
					System.out.print(pvidrio[i]);			
				}
				System.out.println();
			} catch (EBarrio e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}else if (ejercicio.equals("1.0")) {
			//Barrios
			String[] barrios=u.barriosConPaquetes();
			System.out.print("Barrios: ");
			for (int i=0;i<barrios.length;i++) {
				if (i!=0)
					System.out.print(", ");
				System.out.print(barrios[i]);			
			}
			System.out.println();
		}
		else if (ejercicio.equals("1.1")) {
			//Barrios y kgs totales
			String[] barrios=u.barriosConPaquetes();
			double[] kgsBarrios;
			try {
				kgsBarrios = u.kgPorBarrios();
				System.out.print("Barrios: ");
				for (int i=0;i<barrios.length;i++) {
					if (i!=0)
						System.out.print(", ");
					System.out.print(barrios[i]+"-"+kgsBarrios[i]);			
				}
				System.out.println();
			
			} catch (EBarrio e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}else if (ejercicio.equals("1.2")) {
			//Barrios y kgs de plastico duro
			String[] barrios=u.barriosConPaquetes();
			double[] kgsBarrios;
			try {
				kgsBarrios = u.kgPlasticoDuro();
				System.out.print("Barrios: ");
				for (int i=0;i<barrios.length;i++) {
					if (i!=0)
						System.out.print(", ");
					System.out.print(barrios[i]+"-"+kgsBarrios[i]);			
				}
				System.out.println();
			} catch (EBarrio e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		in.close();
 }
}