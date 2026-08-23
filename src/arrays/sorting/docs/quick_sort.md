# Quick Sort

## How It Works

Quick Sort chooses a **pivot** and partitions the array so smaller values are on the left and larger values are on the right.

For ascending order:

- Choose a pivot element.
- Move smaller values to the left of the pivot.
- Move larger values to the right of the pivot.
- Sort both partitions recursively.

## Example

Consider:

~~~text
[5, 2, 9, 1, 3]
~~~

Choose **3** as the pivot:

~~~text
[2, 1] | 3 | [5, 9]
~~~

Sort the left and right partitions:

~~~text
[1, 2, 3, 5, 9]
~~~

## The Main Idea

Each partition puts one pivot in its final position.
