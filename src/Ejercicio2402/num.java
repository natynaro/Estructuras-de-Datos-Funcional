package Ejercicio2402;

public class num {
	public num() {
		
	}
	public static int mayor(int[] array) {
		int sumaActual;//1
		int sumaMayor=0;//2
		
		
		for(int i=0; i<array.length; i++) {//2n+3
			sumaActual=array[i];//1
			for(int j=i+1;j<array.length; j++) {//n^2+4n+3
				sumaActual+=array[j];//n^2-n
				if(sumaActual>sumaMayor) {//n^2-n/2
					sumaMayor=sumaActual;//n^2-n/2
				}
			}
			
		}
		return sumaMayor;//1
	}//O(3N^2+6N+11)=O(N^2)
	
	
	public static int mayor2(int[] array) {
		
		int  j=1, sumaActual=array[0], sumaMayor=0;//8
		for(int i=0; j<array.length; i++ ){
			if(sumaMayor<sumaActual) {
				do{
					sumaMayor=sumaActual;
					sumaActual+=array[j];
					j++;
				}while(sumaMayor<sumaActual);
			}
			
		}
		
		
		return sumaMayor;
	}
	
	public static int subsecuenciaSumaMaxima (int [] a)
	{
	 int sumaActual; //1
	 int sumaMax = 0;//2
	 for ( int i =0; i<a.length; i++)//2n+3
		 for ( int j=i; j<a.length; j++){//
			 
			 sumaActual = 0;//
			 for ( int k=i; k<=j; k++)//
				 sumaActual += a[k];//(n^3/3)+(n^2)+(2n/3)
			 
			 if (sumaActual > sumaMax){//
				 
				 sumaMax = sumaActual;//
				 int secIni = i;//
				 int secFin = j;//
			 }
		 }
	 	return sumaMax;//1
	 }
}
