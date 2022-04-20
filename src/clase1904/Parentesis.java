package clase1904;

import java.util.Stack;

public class Parentesis {
	public static boolean parentesis(String expresion) {
		Stack<String> par= new Stack();
		int k=0;
		while(k<expresion.length()){
			while(k<expresion.length() && !expresion.subSequence(k, k+1).equals(")")) {
				if(expresion.subSequence(k, k+1).equals("(")) {
					par.push("(");
				}
				k++;
			} k++;
			if(par.isEmpty()) {
				return false;
			}else par.pop();
		}
		if(!par.isEmpty()) {
			return false;
		}else return true;
	}

	public static boolean parentesisExc(String expresion) throws EIndexAt {
			Stack<String> par= new Stack();
			Stack<Integer> pare= new Stack();
			int k=0;
			for(int j=0; j<expresion.length(); j++) {
				if(expresion.charAt(j)=='(') {
					par.push("(");
				}
				if(expresion.charAt(j)==')') {
					if(par.isEmpty()) {
						pare.push(k+1);
					}else par.pop();
				}
				k++;
			}
			/*while(k<expresion.length()){
				while(k<expresion.length() && !expresion.subSequence(k, k+1).equals(")")) {
					if(expresion.subSequence(k, k+1).equals("(")) {
						par.push("(");
					}
					k++;
				} k++;
				if(par.isEmpty()) {
					pare.push(k);
				}else par.pop();
			}*/
	
		if(!par.isEmpty()) {
			for(int i=0; i<par.size();i++) {
				pare.push(k);// acá 
			}
		}
	
		if(pare.size()>1) {
			throw new  EIndexAt(pare.toString());
		}else if(pare.size()==1) {
			throw new  EIndexAt(pare.pop());
		}else return true;
	}
}
 class EIndexAt extends Exception {
	private static final long serialVersionUID = 1L;
	public EIndexAt(int i) {
		super("Hay un paréntesis demás en el caracter" + (i+1));
	}
	public EIndexAt(String i) {
		super("Hay varios paréntesis demás en los caracteres" + i);
	}
}

