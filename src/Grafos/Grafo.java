package Grafos;

import java.util.*;

import ClaseCompares.Persona;

class ExceptionVertice extends Exception{
	
    private static final long serialVersionUID = 1L;

    public ExceptionVertice(){
        super("Error en Vértice");
    }
    
    public ExceptionVertice(String s){
        super(s);
    }
}

public class Grafo <E extends Comparable<E>>{

	private LinkedList<Vertice<E>> vertices;
	
	public Grafo() {
		this.vertices=  new LinkedList<Vertice<E>>();
		
	}
	public Grafo(LinkedList<Vertice<E>> vertices) {
		super();
		this.vertices = vertices;
	}
	public LinkedList<Vertice<E>> getVertices() {
		return vertices;
	}
	public void setVertices(LinkedList<Vertice<E>> vertices) {
		this.vertices = vertices;
	}
	

	public void inicializarVertices() {
		ListIterator<Vertice<E>> list = vertices.listIterator();
		while(list.hasNext()) {
		Vertice<E> v = list.next();
		v.setAnterior(null);
		v.setDistance(Double.POSITIVE_INFINITY);
		}
	}
	
	public Stack<Vertice<E>> MenorCaminoSinPesos(Vertice<E> inicio, Vertice<E> destino){
		
		inicializarVertices();//inicializar los anteriores y distancias antes de recorrelos
		//Recorrer a lo ancho todas las aristas con que tiene conexión
		Queue<Vertice<E>> vSinVisitar= new LinkedList<Vertice<E>>();
		inicio.setDistance(0);
		vSinVisitar.add(inicio);
		while(!vSinVisitar.isEmpty()) {
			//buscar Vertice
			Vertice<E> actual= vSinVisitar.poll();
			//Recorrer adyacentes y poner en cola sin visitar
			ListIterator<Arista<E>> iterator= actual.getAdyacentes().listIterator();
			while(iterator.hasNext()) {
				Arista<E> a=iterator.next();
				Vertice<E> v=a.getDestino();
				if(v.getAnterior()==null) {
					v.setAnterior(actual);
					v.setDistance(actual.getDistance()+1);
					vSinVisitar.add(v);
				}
			}
		}
		return camino(inicio,destino);
	}
	
	public Stack<Vertice<E>> camino(Vertice<E> inicio, Vertice<E> destino) {
		Stack<Vertice<E>> camino=new Stack<Vertice<E>>();
		Vertice<E> v=destino;
		
		while(v!=null && inicio.getInfo().compareTo(v.getInfo())!=0) {
			camino.push(v);
			v=v.getAnterior();
		}
		camino.push(inicio);
		return camino;
		
	}
	
	public void imprimirCamino(Stack<Vertice<E>> s) {
        while(!s.isEmpty()){
            Vertice<E> v=s.pop();
            System.out.print(v.getInfo()+ " ");
        }
        System.out.println();
    }
	public void inicializarVerticesPeso() {
		ListIterator<Vertice<E>> list = vertices.listIterator();
		while(list.hasNext()) {
		Vertice<E> v = list.next();
		v.setAnterior(null);
		v.setDistance(Double.POSITIVE_INFINITY);
		}
	}
	public Stack<Vertice<E>> MenorCaminoConPesos(Vertice<E> inicio, Vertice<E> destino){//Dijkstra
	
		inicializarVertices();//inicializar los anteriores y distancias antes de recorrelos
		//Recorrer a lo ancho todas las aristas con que tiene conexión
		Queue<Vertice<E>> vSinVisitar= new PriorityQueue<Vertice<E>>();
		inicio.setDistance(0);
		vSinVisitar.add(inicio);
		while(!vSinVisitar.isEmpty()) {
			//buscar Vertice
			Vertice<E> actual= vSinVisitar.poll();
			//Recorrer adyacentes y poner en cola sin visitar
			ListIterator<Arista<E>> iterator= actual.getAdyacentes().listIterator();
			while(iterator.hasNext()) {
			
				Arista<E> a=iterator.next();
				Vertice<E> v=a.getDestino();
			
				if(v.getAnterior()==null||v.getDistance()>a.getPeso()+actual.getDistance()) {//si no tiene peso(distancia) o si se encuentra una manera de llegar más corta, se va a reemplazar con lo nuevo
					v.setAnterior(actual);
					v.setDistance(actual.getDistance()+a.getPeso());
					if(!vSinVisitar.contains(v)) {
						vSinVisitar.add(v);
					}
				}
			}
		}
		return camino(inicio,destino);
	}
}
