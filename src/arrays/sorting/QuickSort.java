package arrays.sorting;

public class QuickSort {
	
	/*
	 * Quick sort uses the Divide and Conquer approach. 
	 * It selects a pivot element, places it in its correct position (partitioning),
	 * and then recursively sorts the left and right subarrays.
	 */
	public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pIndex = partition(arr,low,high);
            
            quickSort(arr,low,pIndex - 1);
            quickSort(arr,pIndex+1, high);
        }
    }

    private static int partition(int[] arr,int low, int high) {
		int pivot = arr[high];
		int i = low - 1;
		for(int j = low; j < high; j++) {
			if(arr[j] < pivot) {
				i++;
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}
		
		i++;
		int temp = arr[i];
		arr[i] = pivot;
		arr[high] = temp;
		
		return i; // Pivot element's correct index
	}
	
	public static void main(String[] args) {
		int[] arr = {5, 2, 9, 1, 3};
        quickSort(arr,0,arr.length - 1);

        for (int i : arr) System.out.print(i + " ");
	}

}
