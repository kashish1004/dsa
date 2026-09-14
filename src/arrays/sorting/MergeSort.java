package arrays.sorting;

public class MergeSort {
	
	/*
	 * Merge sort follows the Divide and Conquer approach.
	 * It first divides the array into smaller subarrays until each 
	 * contains one element, then merges the subarrays in sorted order.
	 */
	public static void mergeSort(int[] arr, int low, int high) {
        if (low < high) {
            int mid = low + (high - low) / 2;

            mergeSort(arr, low, mid);
            mergeSort(arr, mid + 1, high);

            merge(arr, low, mid, high);
        }
    }

    public static void merge(int[] arr, int low, int mid, int high) {
        int[] temp = new int[high - low + 1];

        int i = low, j = mid + 1, k = 0;

        while (i <= mid && j <= high) {
            if (arr[i] <= arr[j]) temp[k++] = arr[i++];
            else temp[k++] = arr[j++];
        }

        while (i <= mid) temp[k++] = arr[i++];
        while (j <= high) temp[k++] = arr[j++];

        System.arraycopy(temp, 0, arr, low, temp.length);
    }
	
    void main() {
		int[] arr = {5, 2, 9, 1, 3};
        mergeSort(arr,0,arr.length - 1);

        for (int i : arr) System.out.print(i + " ");
	}

}
