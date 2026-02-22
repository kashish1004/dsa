# Sliding Window Algorithm (Arrays)

The **sliding window** technique is an efficient way to process a **contiguous subarray** of an array by maintaining a window that moves across the array instead of recalculating values repeatedly.

Think of it like looking at a few elements through a **window** and sliding that window from left to right.

---

## Why Use Sliding Window?

Without sliding window, many array problems take **O(n²)** time.  
With sliding window, these problems can often be solved in **O(n)** time.

### Common Use Cases
- Maximum / minimum sum of subarrays.
- Longest or shortest subarray with a condition.
- Counting subarrays that satisfy a rule.

---

## Types of Sliding Window

### 1. Fixed-Size Window

The window size remains constant.

#### Example Problem
Find the maximum sum of any subarray of size `k`.

#### Sliding Window Approach
1. Calculate the sum of the first `k` elements.
2. Slide the window forward:
   - Add the new element entering the window.
   - Remove the element leaving the window.

#### Example
Array: `[2, 1, 5, 1, 3, 2]`  
`k = 3`

- Window `[2, 1, 5]` → sum = 8  
- Window `[1, 5, 1]` → sum = 7  
- Window `[5, 1, 3]` → sum = 9  
- Window `[1, 3, 2]` → sum = 6  

**Maximum sum = 9**

**Time Complexity:** `O(n)`

---

### 2. Variable-Size Window

The window size changes based on a condition.

#### Example Problem
Find the length of the longest subarray with sum ≤ `S`.

#### Sliding Window Approach
- Use two pointers: `left` and `right`.
- Expand the window by moving `right`.
- Shrink the window by moving `left` when the condition is violated.

Below is the template for Variable size sliding window approach:

```java
int left = 0;
// Initialize your window state (e.g., sum, map, set, counter)
int result = 0;

for (int right = 0; right < arr.length; right++) {

    // 1️⃣ Expand window
    // Add arr[right] to your window state
    // e.g., windowSum += arr[right]; or map.put(arr[right], map.getOrDefault(arr[right], 0) + 1);

    // 2️⃣ Shrink while window is invalid
    // windowIsInvalid() is the problem specific condition 
    while (windowIsInvalid()) {
        // Remove arr[left] from your window state
        // e.g., windowSum -= arr[left]; or decrement count in map
        left++;
    }

    // 3️⃣ Update answer
    // e.g., result = Math.max(result, right - left + 1);
}
```

#### Example
Array: `[2, 1, 5, 2, 3]`  
`S = 7`

- Expand the window until the sum exceeds `7`.
- Shrink the window from the left until the sum is valid again
- Track the maximum window size

---

**Step 1:**  
- Window: `[2]`  
- `left = 0`, `right = 0`  
- `windowSum = 2` (≤ 7)  
- Window size = 1 → max length = 1  

---

**Step 2:**  
- Expand window → `[2, 1]`  
- `right = 1`  
- `windowSum = 3` (≤ 7)  
- Window size = 2 → max length = 2  

---

**Step 3:**  
- Expand window → `[2, 1, 5]`  
- `right = 2`  
- `windowSum = 8` (> 7) ❌  
- Shrink window from left  
  - Remove `2` → window becomes `[1, 5]`  
  - `left = 1`, `windowSum = 6` (≤ 7)  
- Window size = 2 → max length = 2  

---

**Step 4:**  
- Expand window → `[1, 5, 2]`  
- `right = 3`  
- `windowSum = 8` (> 7) ❌  
- Shrink window from left  
  - Remove `1` → window becomes `[5, 2]`  
  - `left = 2`, `windowSum = 7` (≤ 7)  
- Window size = 2 → max length = 2  

---

**Step 5:**  
- Expand window → `[5, 2, 3]`  
- `right = 4`  
- `windowSum = 10` (> 7) ❌  
- Shrink window from left  
  - Remove `5` → window becomes `[2, 3]`  
  - `left = 3`, `windowSum = 5` (≤ 7)  
- Window size = 2 → max length = 2  

---

#### Final Result
- **Longest subarray length = 2**
- Valid subarrays include: `[2, 1]`, `[1, 5]`, `[5, 2]`, `[2, 3]`

---

## When to Use Sliding Window?
You should consider sliding window if:
- The problem involves subarrays or substrings
- The elements must be contiguous
- Recalculating results repeatedly would be inefficient

---

## Summary
- Sliding window reduces time complexity from O(n²) to O(n).
- Works best with contiguous data.
- Comes in fixed-size and variable-size forms.