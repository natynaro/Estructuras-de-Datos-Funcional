package Clase0102;

import java.util.Arrays;

public class Martes {
	private String string= "";
	private static StringBuffer resultado;

	public String getString() {
		return string;
	}

	public void setString(String string) {
		this.string = string;
	}
	
	//metodo que te devuelva vocales (MI VERSION)
	
	static StringBuffer vocales(String string) { 
		String[] vocales= {"a", "e", "i", "o", "u", "A", "E", "I", "O", "U","á", "é", "í", "ó", "u","Á", "É", "Í", "Ó", "Ú", };
		StringBuffer resultado= new StringBuffer();;
			
		for(int i=0; i< string.length(); i++) {
			String letra= Character.toString(string.charAt(i));
			int k=0;
			while (k<vocales.length){
				if( letra.equals(vocales[k])) {
					resultado.append(string.charAt(i));
					k=vocales.length+1;
				}else {
					k++;
				}
			}
		}
		return resultado;
	}
	
	public static char[] vocalesProfe(String cadena){
		String vocales="AÁaáEÉeéIÍiíOÓoóUÚuú";
		char[] result= new char[0];
		for(int i=0; i<cadena.length(); i++) {
			if(vocales.contains(String.valueOf(cadena.charAt(i)))) {
				result= Arrays.copyOf(result, result.length+1);
				result[result.length-1]=cadena.charAt(i);
			}
		}
		return result;
	}
	
	//un método que solo ponga las vocales no repetidas
	public static char[] vocalesNoRepetidas(String cadena){
		StringBuffer repetidas= vocales(cadena);
		StringBuffer resultado=new StringBuffer();
		String repetida= resultado.toString();
	
		for(int i=0; i<repetidas.length(); i++){
			//if(repetida.contains(repetidas.charAt(i))){
				resultado.append(repetidas.charAt(i));
				
				
			}
			
		//}
		return null;
		
	}
}
