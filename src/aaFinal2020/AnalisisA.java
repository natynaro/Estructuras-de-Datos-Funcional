package aaFinal2020;

public class AnalisisA {
	/*Seleccione una o más de una: 
	 * a. O(N logN)
		b. 4+9 N+8 N logN */
	
	public void y(int[] a) {
		for(int i=0; i<a.length;i++) {
			int j=0;
			while(j<a.length) {
				System.out.println("Este es el indice: " + j + "elemento: "+ a[j]);
				j=j*10;
			}
			if(a[i]>0)
				System.out.println(a[j]);
		}
		
	}
	
	/*
	 * Seleccione una o más de una: 
	 * 
		
		d. O(n^2)
		f. 8+6 N+11/2 N^2 +1/2 N*/
	
	public void x(int[] a) {
		int N=a.length;
		if(N>1000000) {
			N=1000000;
		}
		for(int i=0;i<N;i++) {
			for(int j=i+1;j<N;j++) {
				int temp=a[i];
				a[i]=a[j];
				a[j]=temp;
			}
		}
	}
	
}
