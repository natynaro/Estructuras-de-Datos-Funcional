package clase290322;

public class Prueba {

	public static void main(String[] args) {
	     int a[] = {64, 34, 25, 12, 22, 11, 90};
		 int valorDado = (int) Math.floor(Math.random()*a.length+1);
		 System.out.println(valorDado);
		// TODO Auto-generated method stub
/*int N= 20;
		Random r = new Random();
		Integer[] lista = new Integer[N];
		for(int i=0;i<N;i++) {
			lista[i] = r.nextInt(2*N);
			//lista[i] = N-i;
			//lista[i] = i;
		}
		try {
			
			Integer[] listaTemp = Arrays.copyOf(lista, lista.length);
			long timeinicio = System.currentTimeMillis();
			AlgoritmosOrdenamiento.bubblesSort(listaTemp);
			long timefin = System.currentTimeMillis();
			System.out.println("BubbleSort: " + (timefin-timeinicio));
			
			listaTemp = Arrays.copyOf(lista, lista.length);
			timeinicio = System.currentTimeMillis();
			AlgoritmosOrdenamiento.selectionSort(listaTemp);
			timefin = System.currentTimeMillis();
			System.out.println("SelectionSort: " + (timefin-timeinicio));
			
			listaTemp = Arrays.copyOf(lista, lista.length);
			timeinicio = System.currentTimeMillis();
			AlgoritmosOrdenamiento.insertSort(listaTemp);
			timefin = System.currentTimeMillis();
			System.out.println("InsertSort: " + (timefin-timeinicio));
			
			listaTemp = Arrays.copyOf(lista, lista.length);
			timeinicio = System.currentTimeMillis();
			AlgoritmosOrdenamiento.quickSort(listaTemp);
			timefin = System.currentTimeMillis();
			System.out.println("QuickSort: " + (timefin-timeinicio));
			
			listaTemp = Arrays.copyOf(lista, lista.length);
			timeinicio = System.currentTimeMillis();
			AlgoritmosOrdenamiento.quickSortRandomPivote(listaTemp);
			System.out.println(Arrays.toString(listaTemp));
			System.out.println(AlgoritmosOrdenamiento.ordenado(listaTemp));
			timefin = System.currentTimeMillis();
			System.out.println("QuickSort Random Pivote: " + (timefin-timeinicio));
			
			listaTemp = Arrays.copyOf(lista, lista.length);
			timeinicio = System.currentTimeMillis();
			Comparable [] arr = AlgoritmosOrdenamiento.mergeSort(listaTemp);
			System.out.println(AlgoritmosOrdenamiento.ordenado(arr));
			timefin = System.currentTimeMillis();
			System.out.println("MergeSort: " + (timefin-timeinicio));
		}finally {
			
		}*/
	}

}
