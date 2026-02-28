# 🔎 Searching in Array

Searching means **finding whether a target element exists in an array and returning its index**.

There are two main methods:

## 1️⃣ Linear Search

* Works on **unsorted arrays**
* Check elements one by one
* Time Complexity: **O(n)**

## 2️⃣ Binary Search (Main Focus)

* Works only on **sorted arrays**
* Much faster
* Time Complexity: **O(log n)**

---

let's go deep in **Binary search and it's variants**.

---


# 🔎 Binary Search

## 💡 Core Idea

1. Find middle element.
2. Compare with target.
3. Discard half of the array.
4. Repeat.

Each step reduces search space by half → logarithmic time.

---

## ✅ 1. Basic Binary Search (Exact Match)

### 🎯 Goal:

Find index of target.

### 💡 Idea:

* If `arr[mid] == target` → return
* If smaller → search right half
* If larger → search left half

### ✅ Code

```java
public static int binarySearch(int[] arr, int target) {
    int left = 0, right = arr.length - 1;

    while (left <= right) {
        int mid = left + (right - left) / 2;

        if (arr[mid] == target)
            return mid;
        else if (arr[mid] < target)
            left = mid + 1;
        else
            right = mid - 1;
    }
    return -1;
}
```

---

# 🔶 Variations of Binary Search

The **real skill** in binary search is modifying conditions correctly.

---

# 2️⃣ Lower Bound (First index ≥ target)

### 🎯 Goal:

Find first element greater than or equal to target.

### 💡 Idea:

* If `arr[mid] < target` → discard left
* Else → mid might be answer → move right pointer to mid

We keep pushing toward the leftmost valid answer.

### ✅ Code

```java
public static int lowerBound(int[] arr, int target) {
    int left = 0, right = arr.length;

    while (left < right) {
        int mid = left + (right - left) / 2;

        if (arr[mid] < target)
            left = mid + 1;
        else
            right = mid;
    }
    return left;
}
```

---

# 3️⃣ Upper Bound (First index > target)

### 🎯 Goal:

Find first element strictly greater than target.

### 💡 Idea:

* If `arr[mid] <= target` → discard left
* Else → mid could be answer

### ✅ Code

```java
public static int upperBound(int[] arr, int target) {
    int left = 0, right = arr.length;

    while (left < right) {
        int mid = left + (right - left) / 2;

        if (arr[mid] <= target)
            left = mid + 1;
        else
            right = mid;
    }
    return left;
}
```

---

# 4️⃣ First Occurrence (With Duplicates)

### 🎯 Goal:

Find first occurrence of target.

### 💡 Idea:

* When found → store answer
* Continue searching left

### ✅ Code

```java
public static int firstOccurrence(int[] arr, int target) {
    int left = 0, right = arr.length - 1;
    int result = -1;

    while (left <= right) {
        int mid = left + (right - left) / 2;

        if (arr[mid] == target) {
            result = mid;
            right = mid - 1;
        } else if (arr[mid] < target) {
            left = mid + 1;
        } else {
            right = mid - 1;
        }
    }
    return result;
}
```

---

# 5️⃣ Last Occurrence

### 🎯 Goal:

Find last occurrence of target.

### 💡 Idea:

* When found → store answer
* Continue searching right

### ✅ Code

```java
public static int lastOccurrence(int[] arr, int target) {
    int left = 0, right = arr.length - 1;
    int result = -1;

    while (left <= right) {
        int mid = left + (right - left) / 2;

        if (arr[mid] == target) {
            result = mid;
            left = mid + 1;
        } else if (arr[mid] < target) {
            left = mid + 1;
        } else {
            right = mid - 1;
        }
    }
    return result;
}
```

---

# 6️⃣ Binary Search on Descending Array

### 🎯 Goal:

Search in reverse sorted array.

### 💡 Idea:

Comparison logic reverses.

### ✅ Code

```java
public static int binarySearchDescending(int[] arr, int target) {
    int left = 0, right = arr.length - 1;

    while (left <= right) {
        int mid = left + (right - left) / 2;

        if (arr[mid] == target)
            return mid;
        else if (arr[mid] > target)
            left = mid + 1;
        else
            right = mid - 1;
    }
    return -1;
}
```

---

# 7️⃣ Search in Rotated Sorted Array

Example:

```
[4,5,6,7,0,1,2]
```

### 🎯 Goal:

Find element in rotated sorted array.

### 💡 Key Idea:

At least one half is always sorted.

Steps:

1. Check which half is sorted.
2. Check if target lies inside sorted half.
3. Discard the other half.

### ✅ Code

```java
public static int searchRotated(int[] arr, int target) {
    int left = 0, right = arr.length - 1;

    while (left <= right) {
        int mid = left + (right - left) / 2;

        if (arr[mid] == target)
            return mid;

        if (arr[left] <= arr[mid]) {  // left half sorted
            if (arr[left] <= target && target < arr[mid])
                right = mid - 1;
            else
                left = mid + 1;
        } else {  // right half sorted
            if (arr[mid] < target && target <= arr[right])
                left = mid + 1;
            else
                right = mid - 1;
        }
    }
    return -1;
}
```

---

# 8️⃣ Binary Search on Answer Space (Very Important in Interviews)

Used in problems like:

* Minimum capacity
* Maximum minimum distance
* Square root
* Book allocation

### 💡 Idea:

We search over possible answers, not array indices.

Steps:

1. Define search range.
2. Check if mid satisfies condition.
3. If valid → try better answer.
4. Else → discard.

### Template

```java
public static int binarySearchAnswer(int low, int high) {
    int answer = -1;

    while (low <= high) {
        int mid = low + (high - low) / 2;

        if (isValid(mid)) {
            answer = mid;
            high = mid - 1; // or low = mid + 1
        } else {
            low = mid + 1;
        }
    }
    return answer;
}
```

---

# 🧠 Big Picture Pattern

Almost every binary search problem reduces to:

```java
while (left <= right) {
    int mid = left + (right - left) / 2;

    if (condition) {
        right = mid - 1;  // or right = mid
    } else {
        left = mid + 1;
    }
}
```

The trick is:

* Understand what condition represents
* Decide which half to discard
* Decide whether to store answer

---

# 📌 Final Summary

| Variation        | Key Idea                      |
| ---------------- | ----------------------------- |
| Basic            | Compare and eliminate half    |
| Lower Bound      | First ≥ target                |
| Upper Bound      | First > target                |
| First Occurrence | Store answer, move left       |
| Last Occurrence  | Store answer, move right      |
| Descending       | Reverse comparisons           |
| Rotated          | Identify sorted half          |
| Answer Space     | Search on monotonic condition |
