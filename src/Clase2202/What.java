package Clase2202;

public class What {

		public double mayorDe (double num1, double num2) {
			
			if(num1>=num2) {
				return num1;
			}else return num2;
		}
 //calcularo los pasos y l
/*
public void punto1() {
	int n, a, b;
	for(int i=0; i<n; i++){ //al declarar y asignar i hay 2 paso, la comparacion de i y n se realiza n+1 veces, la i++ se realiza n veces
		a+=b; //se realiza 2n veces
	}
} //es O(4N+3)=O(4N)=O(N)*/
		
		/*
		public void punto2() {
			k=100; //ES 1 SOLO PASO PORQUE EN REALIDAD  NO SE DECLARA
			for(int i=1; i<k; i++){ //al declarar y asignar i hay 2 paso, la comparacion de i y K se realiza 100 veces, la i++ se realiza 99 veces
				a+=b; //se realiza 198 veces
			}
		}  //O(400)=O(1)*/
		
		/*
		 public void punto3() {
			
			for(int i=0; i<N; i++){ //2, N+1, N
				for(int j=1; j<N; j++){2N, N*N + 2N +1, n*n
							a+=b; //2n*n
			}} O(3+5N+4N*N)=O(4N*N)=O(N*N)
		 */
		
		/*
		 public void punto3() {
			
			for(int i=0; i<N; i++){ //2, N+1, N
				for(int j=0; j<=i; j++){ //2n, cv+n; cv
							a+=b; //2cv
			}// al hacer una tabla de i y j, hay una sumatoria de 1 a n, lo que da n(n+1)/2 <---- las veces que se repite el ciclo j
			//Así, O(2N*N+7N+3)=O(N*N)
			
			} 
		 */
		
		/*
		 public void puntoE() {
			while(c<N){ //log base 2 N
				a+=b;//2(LOG BASE 2 N -1)
				c=2*c;//2(LOG BASE 2 N -1)
			} //O(5LOG BASE 2 N -2)= O(LOG N)
		 */
}

