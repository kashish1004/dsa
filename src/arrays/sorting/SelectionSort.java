package arrays.sorting;

public class SelectionSort {
	
	public static void sort(int[] arr) {
		int n = arr.length;
		
		/*
		 * Selection sort finds the smallest element from the unsorted part of the array
		 * and swaps it with the first unsorted position.
		 */ 
		for(int i = 0; i < n; i++) {
			int minIndex = i;
			
			for(int j = i+1; j < n; j++) {
				if(arr[j] < arr[minIndex]) {
					minIndex = j;
				}
			}
			
			int temp = arr[i];
			arr[i] = arr[minIndex];
			arr[minIndex] = temp;
			
		}
	}
	
	public static void main(String[] args) {
		int[] arr = {5, 2, 9, 1, 3};
        sort(arr);

        for (int i : arr) System.out.print(i + " ");
	}

}
