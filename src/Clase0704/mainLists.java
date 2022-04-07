package Clase0704;

import java.util.*;

public class mainLists {

	public static void main(String[] args) {
		ArrayList<String> lista = new ArrayList<String>();
/*ejemplo de lista iterator*/
		
		lista.add("Pedro");
		lista.add("Olga");
		lista.add("Miguel");
		lista.add("Antonio");
		lista.add("Olga");
		lista.add("Olga");
		lista.add("Andres");
		lista.add("Olga");
		printList(lista);
		
		ArrayList<String> listatemp =(ArrayList<String>) lista.clone();
		for(int i=0; i<listatemp.size();i++) {
			if(listatemp.get(i).compareTo("Olga")==0) {
				listatemp.remove(i);//como se cambia el tamaño de la vaina, por eso se queda una olga y todo mal, entonces es mejor el iterator
				i--;//por eso este --
			}}
			printList(listatemp);
			listatemp=(ArrayList<String>) lista.clone();
			ListIterator<String> it= listatemp.listIterator();
			String e;
			while(it.hasNext()) {
				e=it.next();
				if(e.compareTo("Olga")==0) {
					it.remove();
				}
			}
		
		printList(listatemp);
		
		

	}
public static <E> void printList(ArrayList<E> list) {
	for(E e:list) System.out.print(e+ "\t"); System.out.println();
}
}
