package clase1904;

public class mainColaPila {

	public static void main(String[] args) throws EIndexAt {
		// TODO Auto-generated method stub
		//"S.ALLETOS BES TRATROR AMPRO CEUGINSO CI SAR. VENTERGU");
		StringBuilder mensaje= Decodificar.decodificar("PROBLEMAS HIPER-INTERESANTES.");
		System.out.println(mensaje);
		
		StringBuilder mensaje2= Decodificar.decodificar("S.ALLETOS BES TRATROR AMPRO CEUGINSO CI SAR. VENTERGU");
		System.out.println(mensaje2);
		
		System.out.println(Parentesis.parentesis("(b(a+b))"));
		System.out.println(Parentesis.parentesis("((((a+b)))))"));
		System.out.println(Parentesis.parentesis("(((((a+b))))"));
		
		System.out.println(Parentesis.parentesisExc("(b(a+b))"));
		System.out.println(Parentesis.parentesisExc("((((a+b)))))"));
		System.out.println(Parentesis.parentesisExc("(((((a+b))))"));
		
	}

}
