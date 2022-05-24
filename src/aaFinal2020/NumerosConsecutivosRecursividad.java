package aaFinal2020;
import java.util.*;

public class NumerosConsecutivosRecursividad {
/*Dada una matriz de ceros y unos se considera una secuencia de unos a más de un 1 consecutivo en una fila. Se desea hacer una función RECURSIVA que reciba una matriz y devuelva en un arreglo la cantidad de secuencias de unos por filas.

0 0 1 0 0
1 1 0 1 1
1 1 1 0 1
0 0 1 1 0

En la primera fila hay una secuencia de 1 pero tiene sólo tamaño 1.
En la fila 2 hay dos secuencias de 1 de tamaño 2.
En la tercera hay una secuencia de tamaño 3.
Y en la cuarta hay una secuencia de tamaño 2.
El método debe devolver un arreglo con la cantidad de secuencias por filas, en el caso anterior sería:
0
2
1
1*/
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ConsecutiveOnes a= new ConsecutiveOnes();
		int[][] matriz= {{0, 0, 1, 0, 0},{1, 1, 0, 1, 1},{1, 1, 1, 0, 1},{0, 0, 1, 1, 0}};
		int[] b= a.iterativo(matriz);
		for(int i=0; i<b.length;i++) {
			System.out.println(b[i]+ ", ");
		}
		int[] c=a.consecutive(matriz);
		for(int i=0; i<c.length;i++) {
			System.out.println(c[i]+ ", ");
		}
		
	}

}

class ConsecutiveOnes {
    
	public int[] iterativo(int[][] matriz) {
        // Complete el código
    	//numeros consecutivos de una matriz
		int contador=0;
		int contador2=0;
		int[] hola=new int[matriz.length];
		for (int i = 0;i< matriz.length; i++) {
            for (int j = 1; j<matriz[0].length-1; j++) {
                if((matriz[i][j]== 1) && (matriz[i][j-1]==1)) {
                	contador++;
                	contador2++;
                	if(contador2>=2) contador--;
                }else contador2=0;
            }
          hola[i]=contador;
          contador=0;
        }
		return hola;
	}
    
	
	
    public int[] consecutive(int[][] matriz) {
        // Complete el código
    	//numeros consecutivos de una matriz
    	int[] a= new int[matriz.length];
    	return consecutive(matriz, 0,a);
    }
    
    
    public int[] consecutive(int[][] matriz, int i, int[] a) {
    	if(i==matriz.length-1) {
    		a[i]=recursivo(matriz[i].clone());
    		return a;
    	}
    	a[i]=recursivo(matriz[i].clone());
    	 return consecutive(matriz, i+1, a);
    }
    //recursividad para cada fila
    public int recursivo(int[] m) {
    	int c=0;
    	int[] a= Arrays.copyOf(m, (m.length+1));
    	a[a.length-1]=0;
    	for(int i=0; i<a.length-2;i++) {
    		if(a[i]==a[i+1] && a[i]==1 && a[i+1]!=a[i+2]) {
    			c++;
    		}
    	}
		return c;
    	
    }
    
    // Haga las funciones que necesite
  
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int row= Integer.parseInt(in.nextLine());
        int col= Integer.parseInt(in.nextLine());
        int[][] matriz=new int[row][col];
        for (int i=0;i<row;i++) {
            String s[]= in.nextLine().split(",");
            for(int j =0 ;j < s.length;j++)
                matriz[i][j]= Integer.parseInt(s[j]);
        }
        ConsecutiveOnes co=new ConsecutiveOnes();
        int[] consecutive=co.consecutive(matriz);
        for (int c:consecutive)
            System.out.println(c);          
        in.close();
    }

}