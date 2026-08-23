# Bubble Sort

## How It Works

Bubble Sort repeatedly compares **two adjacent elements** and swaps them if they are in the wrong order.

For ascending order:

- Compare the first two elements.
- If the first element is greater than the second, swap them.
- Move to the next pair of adjacent elements.
- Continue until the end of the array.
- After one complete pass, the **largest unsorted element moves to the end**.
- Repeat the process for the remaining unsorted elements until the array is sorted.

## Example

Consider:

```text
[5, 2, 9, 1, 3]
```

### Pass 1

Compare **5** and **2**:

```text
[5, 2, 9, 1, 3]
 ↑  ↑
```

**5 > 2**, so swap:

```text
[2, 5, 9, 1, 3]
```

Compare **5** and **2**:

```text
[2, 5, 9, 1, 3]
    ↑  ↑
```

**5 < 9**, so no swap:

```text
[2, 5, 9, 1, 3]
```

Compare **9** and **1**:

```text
[2, 5, 9, 1, 3]
       ↑  ↑
```

**9 > 1**, so swap:

```text
[2, 5, 1, 9, 3]
```

Compare **9** and **3**:

```text
[2, 5, 1, 9, 3]
          ↑  ↑
```

**9 > 3**, so swap:

```text
[2, 5, 1, 3, 9]
```

The largest element **9** has now reached the end.

```text
[2, 5, 1, 3, 9]
             ↑
         sorted
```

### Pass 2

Now we only need to work with:

```text
[2, 5, 1, 3]
```

Compare **2** and **5**:

```text
[2, 5, 1, 3, 9]
 ↑  ↑
```

**2** < **5**, so no swap

```text
[2, 5, 1, 3, 9]
```

Compare **5** and **1**:

```text
[2, 5, 1, 3, 9]
    ↑  ↑
```

Swap:

```text
[2, 1, 5, 3, 9]
```

Compare **5** and **3**:

```text
[2, 1, 5, 3, 9]
       ↑  ↑
```

Swap:

```text
[2, 1, 3, 5, 9]
```

Now **5** is also in its correct position.

```text
[2, 1, 3, 5, 9]
          ↑  ↑
        sorted
```

### Pass 3

Compare **2** and **1**:

```text
[2, 1, 3, 5, 9]
 ↑  ↑
```

Swap:

```text
[1, 2, 3, 5, 9]
```

Compare 2 and 3:

```text
[1, 2, 3, 5, 9]
    ↑  ↑
```
No swap.

The array is now sorted:

```text
[1, 2, 3, 5, 9]
```

## The Main Idea

Each pass pushes the **largest remaining element to the end:**

```text
[5, 2, 9, 1, 3]
            ↓
Pass 1 → [2, 5, 1, 3, 9]
                      ↑

Pass 2 → [2, 1, 3, 5, 9]
                   ↑  ↑

Pass 3 → [1, 2, 3, 5, 9]
```