package ClaseCompares;


public class mainn {
	public static void main(String[] args) {
    Persona p1= new Persona("Pedro", 24);
    Persona p2= new Persona("oscar", 21);
    Persona p3= new Persona("Marcela", 20);
    Persona p4= new Persona("Andres", 26);
    Persona[] listaP= {p1, p2, p3, p4};
    Persona[] listaPp= (Persona[]) Persona.bubbleSort(listaP);
    Persona.printLista(listaPp);
    
    Persona[] listaP2= (Persona[]) Persona.selectionSort(listaP);;
    Persona.printLista(listaP2);
    
    //insertSort
    
    Persona[] listaP3= (Persona[]) Persona.insertSort(listaP);;
    Persona.printLista(listaP3);
    
	}
}
