package clase1904;
import java.util.*;

public class Decodificar {
	/*la pila acumula mientras se cumpla la condicion de no encontrar vocales. cuando se deja de cumplir, lo vamos vaciando hacia el string resultado */
	public static StringBuilder decodificar(String oracion) { 
		String vocales= "AÀaàEÈeèIÌiìOÒoòUÙuùÁáÉéÍíÓóÚú";
		Stack<String> caracteres= new Stack();
		StringBuilder resultado= new StringBuilder();
		int	k=0;
		while(k<oracion.length()){
			if(vocales.contains(oracion.subSequence(k, k+1))) {
				resultado.append(oracion.subSequence(k, k+1));
				k++;
			}else {
				while(k<oracion.length()&&!vocales.contains(oracion.subSequence(k, k+1))) {
					
					caracteres.push((String) oracion.subSequence(k, k+1));
					k++; 
				}
				while(!caracteres.empty()) resultado.append(caracteres.pop());
			}
		}
		resultado.reverse();
		return resultado;
	}
	
}
