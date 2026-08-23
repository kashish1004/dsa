# Merge Sort

## How It Works

Merge Sort divides the array into smaller halves, sorts those halves, and merges them back together.

For ascending order:

- Divide the array into two halves.
- Keep dividing until every part has one element.
- Merge neighbouring parts in sorted order.
- Continue until one sorted array remains.

## Example

Consider:

~~~text
[5, 2, 9, 1, 3]
~~~

Divide into individual elements, then merge in order:

~~~text
[5] [2] [9] [1] [3]
[2, 5] [1, 3, 9]
[1, 2, 3, 5, 9]
~~~

## The Main Idea

Merge Sort sorts small arrays first, then combines them.
