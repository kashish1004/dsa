# Counting Sort

## How It Works

Counting Sort counts occurrences of each integer value, then writes the values back in order. It works best for a small range of values.

For ascending order:

- Find the largest value.
- Create a count array.
- Count every occurrence.
- Write each value back as many times as it appears.

## Example

Consider:

~~~text
[4, 2, 2, 8, 3, 3, 1]
~~~

Count the occurrences:

~~~text
value: 1 2 3 4 5 6 7 8
count: 1 2 2 1 0 0 0 1
~~~

Write the values back in order:

~~~text
[1, 2, 2, 3, 3, 4, 8]
~~~

## The Main Idea

Counting Sort uses values as indexes instead of comparing pairs of elements.
