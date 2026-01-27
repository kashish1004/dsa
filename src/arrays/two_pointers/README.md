# Two Pointers

The **two pointers approach** is a common and powerful technique used when working with **arrays (or strings, linked lists)** to solve problems more efficiently—usually in **O(n)** time instead of **O(n²)**.

Let's break it down step by step, with intuition, types, and examples.

---

## What is the Two Pointers Approach?

The idea is simple:

> **Use two indices (pointers) to traverse an array in a coordinated way instead of using nested loops.**

These pointers move based on certain conditions until the problem is solved.

---

## Why Use Two Pointers?

Without two pointers, many problems look like this:

```code
for i in range(n):
    for j in range(n):
        ...
```

➡️ **Time complexity: O(n²)**

With two pointers:

```code
while left < right:
    ...
```

➡️ **Time complexity: O(n)**  
✔ Faster  
✔ Cleaner logic  
✔ Less memory  

---

## Common Types of Two Pointer Techniques

### 1️⃣ Opposite Direction Pointers (Left & Right)

* One pointer starts at the **beginning**
* One pointer starts at the **end**
* They move **towards each other**

### When to use:

* Array is **sorted**
* Finding pairs, reversing arrays, checking palindromes

---

### 2️⃣ Same Direction Pointers (Fast & Slow)

Both pointers start from the **same side**, but move at **different speeds** or under different conditions.

### When to use:

* Remove duplicates
* Move zeros
* Detect cycles

---


## How to Identify Two Pointer Problems

Look for keywords like:

* **sorted array**
* **pair / triplet**
* **subarray / substring**
* **remove duplicates**
* **find longest / shortest**
* **O(n) solution expected**

---

## Key Advantages

✅ Reduces time complexity  
✅ No extra memory (usually O(1) space)  
✅ Cleaner and more intuitive once practiced  