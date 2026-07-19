package arrays.sorting;

public class InsertionSort {
	
	public static void sort(int[] arr) {
		int n = arr.length;
		
		/*
		 * Insertion sort builds a sorted portion of the array one element at a time. In
		 * each pass, the current element (called the key) is inserted into its correct
		 * position in the sorted part.
		 *
		 */
		for(int i = 1; i < n; i++) {
			int key = arr[i];
			int j = i - 1;
			while (j >= 0 && arr[j] > key) {
				arr[j+1] = arr[j];
				j--;
			}
			
			arr[j+1] = key;
			
		}
	}
	
	public static void main(String[] args) {
		int[] arr = {5, 2, 9, 1, 3};
        sort(arr);

        for (int i : arr) System.out.print(i + " ");
	}

}
