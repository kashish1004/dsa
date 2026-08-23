# 🚀 Sorting Algorithms

Sorting an array is a fundamental topic in programming and is especially rich because there are **many different approaches**, each with different performance, use-cases, and trade-offs.

---

## 🔹 1. Bubble Sort

### 💡 Idea:

Repeatedly swap adjacent elements if they are in the wrong order. More info [here](/docs/sorting/bubble_sort.md)

### ⏱ Time Complexity:

* Worst/Average: O(n²)
* Best: O(n)

```java
public class Main {
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        boolean swapped;

        for (int i = 0; i < n - 1; i++) {
            swapped = false;

            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }

            if (!swapped) break;
        }
    }

    public static void main(String[] args) {
        int[] arr = {5, 2, 9, 1, 3};
        bubbleSort(arr);

        for (int i : arr) System.out.print(i + " ");
    }
}
```

---

## 🔹 2. Selection Sort

### 💡 Idea:

Find the minimum element in the unsorted portion of the array and place it with the first element of that unsorted portion, then repeat. More info [here](/docs/sorting/selection_sort.md)

### ⏱ Time Complexity:

* Always: O(n²)

```java
public class Main {
    public static void selectionSort(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;

            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }

            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }
}
```

---

## 🔹 3. Insertion Sort

### 💡 Idea:

Insert each element into its correct position in a sorted part. More info [here](/docs/sorting/insertion_sort.md)

### ⏱ Time Complexity:

* Worst: O(n²)
* Best: O(n)

```java
public class Main {
    public static void insertionSort(int[] arr) {
        int n = arr.length;

        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }

            arr[j + 1] = key;
        }
    }
}
```

---

## 🔹 4. Merge Sort

### 💡 Idea:

Divide array into halves → sort → merge. More info [here](/docs/sorting/merge_sort.md)

### ⏱ Time Complexity:

* Always: O(n log n)

```java
public class Main {
    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;

            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);

            merge(arr, left, mid, right);
        }
    }

    public static void merge(int[] arr, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];

        int i = left, j = mid + 1, k = 0;

        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) temp[k++] = arr[i++];
            else temp[k++] = arr[j++];
        }

        while (i <= mid) temp[k++] = arr[i++];
        while (j <= right) temp[k++] = arr[j++];

        for (int p = 0; p < temp.length; p++) {
            arr[left + p] = temp[p];
        }
    }
}
```

---

## 🔹 5. Quick Sort

### 💡 Idea:

Pick a pivot and partition around it. More info [here](/docs/sorting/quick_sort.md)

### ⏱ Time Complexity:

* Average: O(n log n)
* Worst: O(n²)

```java
public class Main {
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);

            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }
}
```

---

## 🔹 6. Heap Sort

### 💡 Idea:

Convert array into a heap and extract max repeatedly. More info [here](/docs/sorting/heap_sort.md)

### ⏱ Time Complexity:

* Always: O(n log n)

```java
public class Main {
    public static void heapSort(int[] arr) {
        int n = arr.length;

        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(arr, n, i);

        for (int i = n - 1; i > 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            heapify(arr, i, 0);
        }
    }

    public static void heapify(int[] arr, int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && arr[left] > arr[largest])
            largest = left;

        if (right < n && arr[right] > arr[largest])
            largest = right;

        if (largest != i) {
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;

            heapify(arr, n, largest);
        }
    }
}
```

---

## 🔹 7. Counting Sort (Non-comparison)

### 💡 Idea:

Count occurrences of each element. More info [here](/docs/sorting/counting_sort.md)

### ⏱ Time Complexity:

* O(n + k)

```java
public class Main {
    public static void countingSort(int[] arr) {
        int max = arr[0];
        for (int num : arr) {
            if (num > max) max = num;
        }

        int[] count = new int[max + 1];

        for (int num : arr) {
            count[num]++;
        }

        int index = 0;
        for (int i = 0; i < count.length; i++) {
            while (count[i]-- > 0) {
                arr[index++] = i;
            }
        }
    }
}
```

---

## 🔹 8. Radix Sort

### 💡 Idea:

Sort digit by digit (uses counting sort internally). More info [here](/docs/sorting/radix_sort.md)

```java
public class Main {
    public static void radixSort(int[] arr) {
        int max = getMax(arr);

        for (int exp = 1; max / exp > 0; exp *= 10)
            countingSortByDigit(arr, exp);
    }

    public static int getMax(int[] arr) {
        int max = arr[0];
        for (int num : arr)
            if (num > max) max = num;
        return max;
    }

    public static void countingSortByDigit(int[] arr, int exp) {
        int n = arr.length;
        int[] output = new int[n];
        int[] count = new int[10];

        for (int i = 0; i < n; i++)
            count[(arr[i] / exp) % 10]++;

        for (int i = 1; i < 10; i++)
            count[i] += count[i - 1];

        for (int i = n - 1; i >= 0; i--) {
            output[count[(arr[i] / exp) % 10] - 1] = arr[i];
            count[(arr[i] / exp) % 10]--;
        }

        for (int i = 0; i < n; i++)
            arr[i] = output[i];
    }
}
```

---

## 🔹 Summary Table

| Algorithm      | Time Complexity | Stable | Use Case         |
| -------------- | --------------- | ------ | ---------------- |
| Bubble Sort    | O(n²)           | Yes    | Learning         |
| Selection Sort | O(n²)           | No     | Simple logic     |
| Insertion Sort | O(n²)           | Yes    | Small arrays     |
| Merge Sort     | O(n log n)      | Yes    | Large data       |
| Quick Sort     | O(n log n)      | No     | Fast general use |
| Heap Sort      | O(n log n)      | No     | Memory efficient |
| Counting Sort  | O(n+k)          | Yes    | Integers only    |
| Radix Sort     | O(nk)           | Yes    | Large numbers    |

---

## Stability

A sorting algorithm is **stable** if two elements with the same value maintain their original relative order after sorting.

For example:

```text
Before:
[5(A), 3, 5(B), 2]

After stable sorting:
[2, 3, 5(A), 5(B)]
```
Here, **5(A)** was originally before **5(B)**, and it remains before **5(B)**.

### Why is Stability Important?

Stability is useful when sorting objects by multiple fields.

For example, if students are first sorted by **name** and then by **marks**, a stable sort can preserve the previous ordering when marks are equal.

## In-place vs Extra Space

An **in-place sorting algorithm** sorts the array using a small amount of additional memory, usually **O(1)** auxiliary space.

| Algorithm      | In-place |
| -------------- | -------- |
| Bubble Sort	 | Yes      |
| Selection Sort | Yes      |
| Insertion Sort | Yes      |
| Merge Sort	 | No       |
| Quick Sort	 | Yes*     |
| Heap Sort	     | Yes      |
| Counting Sort	 | No       |
| Radix Sort	 | No       |


> Note: Quick Sort is generally considered in-place because the partitioning happens inside the original array, but its recursive calls require stack space.

## Complexity Comparison

| Algorithm      | Best       | Average    | Worst      | Extra Space |
| -------------- | ---------- | ---------- | ---------- | ----------- |
| Bubble Sort	 | O(n)       |	O(n²)	   | O(n²)      | O(1)        |
| Selection Sort | O(n²)      |	O(n²)      | O(n²)      | O(1)        |
| Insertion Sort | O(n)       |	O(n²)      | O(n²)      | O(1)        |
| Merge Sort	 | O(n log n) |	O(n log n) | O(n log n) | O(n)        |
| Quick Sort	 | O(n log n) |	O(n log n) | O(n²)      | O(log n)*   |
| Heap Sort	     | O(n log n) |	O(n log n) | O(n log n) | O(1)        |
| Counting Sort	 | O(n + k)	  | O(n + k)   | O(n + k)   | O(k)        |
| Radix Sort	 | O(dn)	  | O(dn)      | O(dn)	    | O(n + k)    |

```
k = range of values / base used by the algorithm
d = number of digits
* Quick Sort's average recursive stack space is O(log n), but it can become O(n) in the worst case.
```

## Java Built-in Sorting
In real-world Java applications, you usually don't need to implement sorting algorithms yourself. Java provides built-in sorting methods through the standard library.

### Arrays.sort()

For primitive arrays:

```java
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] arr = {5, 2, 9, 1, 3};

        Arrays.sort(arr);

        System.out.println(Arrays.toString(arr));
    }
}
```

Output:

```java
[1, 2, 3, 5, 9]
```

For object arrays, you can also provide a comparator:

```java
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        Integer[] arr = {5, 2, 9, 1, 3};

        Arrays.sort(arr, Comparator.reverseOrder());

        System.out.println(Arrays.toString(arr));
    }
}
```

### Collections.sort()

For lists:

```java
import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(5, 2, 9, 1, 3);

        Collections.sort(numbers);

        System.out.println(numbers);
    }
}
```

You can also use sort() method of list:

```java
import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(5, 2, 9, 1, 3);

        numbers.sort(Comparator.reverseOrder());

        System.out.println(numbers);
    }
}
```

```text
For interviews and DSA practice, implementing sorting algorithms is important for understanding how they work. In production code, prefer Java's built-in sorting methods unless you have a specific reason to implement your own.
```





