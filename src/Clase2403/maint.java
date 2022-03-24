package Clase2403;

public class maint {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BubbleSort ob = new BubbleSort();
        int arr[] = {64, 34, 25, 12, 22, 11, 90};
        BubbleSort.bubbleSort(arr);
        System.out.println("Sorted array");
        BubbleSort.printArray(arr);
        
	}

}
