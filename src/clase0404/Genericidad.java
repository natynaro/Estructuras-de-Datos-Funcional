package clase0404;

public class Genericidad<T extends Comparable<T>>{
	private T obj;

	public Genericidad(T obj) {
		super();
		this.obj = obj;
	}

	public T getObj() {
		return obj;
	}

	public void setObj(T obj) {
		this.obj = obj;
	}
	
	public T min(T o) {
		return (obj.compareTo(o)<0)? obj:o;
	}
	
	public T max(T o) {
		return (obj.compareTo(o)<0)? o:obj;
	
	}
	
}

class Ej{
private Comparable obj;
	
	public Ej(Comparable obj) {
		super();
		this.obj=obj;
	}

	public Comparable getObj() {
		return obj;
	}

	public void setObj(Comparable obj) {
		this.obj = obj;
	}
	
	public Comparable min(Comparable o) {
		return (obj.compareTo(o)<0)? obj:o;
	}
	
	public Comparable max(Comparable o) {
		return (obj.compareTo(o)<0)? o:obj;
	
	}
}
