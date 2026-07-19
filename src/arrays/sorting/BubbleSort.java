package arrays.sorting;


public class BubbleSort {
	
	public static void sort(int[] arr) {
		boolean swapped;
		int n = arr.length;
		
		/*
		 * In bubble sort, there will be total i passes in which, after each pass, the
		 * largest unsorted element moves to its correct position at the end of the
		 * array.
		 */
		for(int i = 0; i < n; i++) {
			swapped = false;
			
			for(int j = 0; j < n - i - 1; j++) {
				if(arr[j] > arr[j+1]) {
					swapped = true;
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
			
			if(!swapped) break;
		}
	}
	
	public static void main(String[] args) {
		int[] arr = {5, 2, 9, 1, 3};
        sort(arr);

        for (int i : arr) System.out.print(i + " ");
	}

}
