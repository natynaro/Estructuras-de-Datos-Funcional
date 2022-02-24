package Ejercicio2402;

public class num {
	public num() {
		
	}
	public static int mayor(int[] array) {
		int sumaActual;//1
		int sumaMayor=0;//2
		
		
		for(int i=0; i<array.length; i++) {//2+n+
			sumaActual=array[i];
			for(int j=i+1;j<array.length; j++) {
				sumaActual+=array[j];
				if(sumaActual>sumaMayor) {
					sumaMayor=sumaActual;
				}
			}
			
		}
		return sumaMayor;
	}
	/*
	public static int mayor2(int[] array) {
		int sumaMayor=0;//2
		
		for(int i=0, j=i+1, sumaActual=array[i]; j<array.length; i++, j++) {//2+n+
			do {
				sumaMayor=sumaActual;
				sumaActual+=array[j];
				j++;
			} while(sumaMayor<sumaActual && j<array.length);
			
		}
		return sumaMayor;
	}*/
	
	public static int subsecuenciaSumaMaxima (int [] a)
	{
	 int sumaActual; //1
	 int sumaMax = 0;//2
	 for ( int i =0; i<a.length; i++)//2n+3
	 for ( int j=i; j<a.length; j++)//n(2+n-i+1+n-i)=n(2n+2-2i)
	 {
	 sumaActual = 0;//1
	 for ( int k=i; k<=j; k++)
	 sumaActual += a[k];
	 if (sumaActual > sumaMax)
	 {
	 sumaMax = sumaActual;
	 int secIni = i;
	 int secFin = j;
	 }
	 }
	 return sumaMax;
	 }
}
