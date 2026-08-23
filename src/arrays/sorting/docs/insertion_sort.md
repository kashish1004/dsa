# Insertion Sort

## How It Works

Insertion Sort builds a sorted part of the array one element at a time.

For ascending order:

- Treat the first element as sorted.
- Take the next element as the current value.
- Shift larger values in the sorted part to the right.
- Insert the current value into its correct position.
- Repeat for every remaining element.

## Example

Consider:

~~~text
[5, 2, 9, 1, 3]
~~~

Insert **2** into the sorted part:

~~~text
[2, 5, 9, 1, 3]
~~~

Then insert **1** and **3** into their correct positions:

~~~text
[1, 2, 3, 5, 9]
~~~

## The Main Idea

Each step grows the sorted portion on the left:

~~~text
[5] | [2, 9, 1, 3]
[2, 5] | [9, 1, 3]
[2, 5, 9] | [1, 3]
[1, 2, 5, 9] | [3]
[1, 2, 3, 5, 9] | []
~~~
