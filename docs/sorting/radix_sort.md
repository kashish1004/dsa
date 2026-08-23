# Radix Sort

## How It Works

Radix Sort sorts integers one digit at a time, starting with the least significant digit. Each pass commonly uses stable Counting Sort.

For ascending order:

- Find the largest number.
- Sort by the ones digit.
- Sort by the tens digit.
- Continue through each more significant digit.

## Example

Consider:

~~~text
[170, 45, 75, 90, 802, 24, 2, 66]
~~~

After sorting by ones, tens, and hundreds digits:

~~~text
[2, 24, 45, 66, 75, 90, 170, 802]
~~~

## The Main Idea

Stable digit-by-digit sorting produces the final numeric order.
