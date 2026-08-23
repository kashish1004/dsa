# Selection Sort

## How It Works

Selection Sort repeatedly finds the **smallest element** in the unsorted part of the array and places it at the beginning.

For ascending order:

- Start from the first position in the array.
- Find the smallest element from that position to the end.
- Swap it with the element at the current position.
- Move the current position one step to the right.
- Repeat until the array is sorted.
- After each pass, the **smallest unsorted element moves to its correct position**.

## Example

Consider:

```text
[5, 2, 9, 1, 3]
```

### Pass 1

Find the smallest element in the entire array:

```text
[5, 2, 9, 1, 3]
          ↑
        smallest
```

The smallest element is **1**. Swap it with the first element, **5**:

```text
[1, 2, 9, 5, 3]
 ↑
sorted
```

### Pass 2

Now the first element is sorted, so find the smallest element in the remaining array:

```text
[1, 2, 9, 5, 3]
    ↑
 smallest
```

The smallest remaining element is **2**. It is already in the correct position, so no swap is needed:

```text
[1, 2, 9, 5, 3]
 ↑  ↑
 sorted
```

### Pass 3

Find the smallest element in the remaining unsorted part:

```text
[1, 2, 9, 5, 3]
             ↑
        smallest
```

The smallest element is **3**. Swap it with **9**:

```text
[1, 2, 3, 5, 9]
 ↑  ↑  ↑
  sorted
```

### Pass 4

Find the smallest element in the remaining array:

```text
[1, 2, 3, 5, 9]
          ↑
     smallest
```

The smallest remaining element is **5**. It is already in the correct position.

The array is now sorted:

```text
[1, 2, 3, 5, 9]
```

## The Main Idea

Each pass places the **smallest remaining element at the beginning:**

```text
[5, 2, 9, 1, 3]
 ↓
Pass 1 → [1, 2, 9, 5, 3]
          ↑

Pass 2 → [1, 2, 9, 5, 3]
             ↑

Pass 3 → [1, 2, 3, 5, 9]
                ↑
```
