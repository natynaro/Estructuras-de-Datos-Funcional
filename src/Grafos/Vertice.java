package Grafos;

import java.util.*;

public class Vertice <E extends Comparable<E>> implements Comparable<Vertice<E>>{
	private E info;
	private LinkedList<Arista<E>> adyacentes;
	
	//pARA CAMINO
	private Vertice<E>anterior;    
	private double distance;
    @Override
    public String toString() {
        return info.toString();
    }
    public Vertice(E info) {
        super();
        this.info = info;
        adyacentes = new LinkedList<Arista<E>>();
        anterior = null;
        distance = Double.POSITIVE_INFINITY;
    }
   
	public E getInfo() {
		return info;
	}
	public void setInfo(E info) {
		this.info = info;
	}
	public LinkedList<Arista<E>> getAdyacentes() {
		return adyacentes;
	}
	public void setAdyacentes(LinkedList<Arista<E>> adyacentes) {
		this.adyacentes = adyacentes;
	}
	public Vertice<E> getAnterior() {
		return anterior;
	}
	public void setAnterior(Vertice<E> anterior) {
		this.anterior = anterior;
	}
	public double getDistance() {
		return distance;
	}
	public void setDistance(double distance) {
		this.distance = distance;
	}
	
	public int compareTo(Vertice<E> v) {
	        return (distance==v.getDistance())?0:(distance>v.getDistance())?1:-1;
	    }
}
