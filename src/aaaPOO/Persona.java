package aaaPOO;


public class Persona implements Comparable<Persona>{
	
	private String nomb;
	private int edad;
	private final int turno;
	private String estado;
	
	public Persona(String nomb, int edad, int turno, String estado) {
		
		super();
		this.nomb = nomb;
		this.edad = edad;
		this.turno = turno;
		this.setEstado(estado);
	}
	
	public String getNomb() {
		return nomb;
	}
	
	public void setNomb(String nomb) {
		this.nomb = nomb;
	}
	
	public int getEdad() {
		return edad;
	}
	
	public void setEdad(int edad) {
		this.edad = edad;
	}
	
	
	@Override
	public String toString() {
		return  nomb + "" + edad + "]";
	}

	@Override
	public int compareTo(Persona o) {
		
		
		
		int dif= edad-o.edad;
		if(dif!=0) return dif;
		return this.nomb.compareTo(o.getNomb());
	}
	/*public int compareTo2(Persona o) {
		//que si el nombre esta igual o la iedad igual seguir comparando letras
		if(edad-o.getEdad()==0) {
			return 0;
		}
		return edad;
		
	}*/
	
	public static Comparable[] bubbleSort(Comparable[] arr)
    {
        int n = arr.length;
        for (int i = 0; i < n-1; i++)
            for (int j = 0; j < n-i-1; j++)
                if (arr[j+1].compareTo(arr[j])<0)
                {
                    // swap arr[j+1] and arr[j]
                    Comparable temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
    return arr;
    }
	
	public static Comparable[] selectionSort(Comparable[] a) {
		for(int i=0; i<a.length; i++) {
			int im=i;
			for(int j=i+1; j<a.length;j++) {
				if(a[j].compareTo(a[im])<0) {
					im=j;
				}
			Comparable tem=a[i];
			a[i]=a[im];
			a[im]=tem;
			}
		}
		 return a;
	}
	public static Comparable[] insertSort(Comparable[] a) {
		for(int i=1;i<a.length;i++) {
			Comparable temp= a[i];
			int j=i;
			while(j>0 && temp.compareTo(a[j-i])<0) {
				a[j]=a[j-1];
				j--;
			}
			a[j]=temp;
		}
		return a;
	}
	
	public static void printLista(Comparable[] lista) {
		if(lista!=null) {
			String result="";
			for(int i=0; i<lista.length; i++) {
				result= result + lista[i] + " ";
			}
			
		System.out.println(result);
			
		}
	}

	public int getTurno() {
		return turno;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
}

 /*HYA FOTOS DE COMPARATOR PARA ORDENAR LAS PRORITY QUEUE*/

