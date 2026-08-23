# Heap Sort

## How It Works

Heap Sort builds a **max heap**, where the largest value is at the root, then repeatedly moves that value to the end.

For ascending order:

- Build a max heap from the array.
- Swap the root with the last unsorted element.
- Reduce the heap size by one.
- Restore the max-heap property.
- Repeat until sorted.

## Example

Consider:

~~~text
[5, 2, 9, 1, 3]
~~~

A possible max heap is:

~~~text
[9, 3, 5, 1, 2]
~~~

Repeatedly extract the largest value:

~~~text
[1, 2, 3, 5, 9]
~~~

## The Main Idea

A max heap makes the largest remaining element easy to select.
