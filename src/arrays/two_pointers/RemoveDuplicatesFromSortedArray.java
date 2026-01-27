package arrays.two_pointers;

/* 
 * Problem Description:
 * 
 * Given an integer array nums sorted in non-decreasing order,
 * remove the duplicates in-place such that each unique element appears only once.
 * The relative order of the elements should be kept the same.
 * Consider the number of unique elements in nums to be k​​​​​​​​​​​​​​.
 * After removing duplicates, return the number of unique elements k.
 * The first k elements of nums should contain the unique numbers in sorted order.
 * The remaining elements beyond index k - 1 can be ignored.
 * */

/*
 * Leetcode problem link - https://leetcode.com/problems/remove-duplicates-from-sorted-array/description/
 * */

/*
 * Time Complexity:- O(n) -> as a loop is used there is a possibility of traversing the whole array
 * 
 * Space Complexity:- O(1) -> as just integers variables are used which makes the space used as constant.
 * */

public class RemoveDuplicatesFromSortedArray {

	public static int removeDuplicates(int[] nums) {
		int j = 1;
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] != nums[i - 1]) {
				nums[j] = nums[i];
				j++;
			}
		}
		return j;
	}

	public static void main(String[] args) {
		int[] nums = { 1, 1, 2 };
		int index = removeDuplicates(nums);
		for (int i = 0; i < index; i++) {
			System.out.print(nums[i] + " ");
		}

	}

}
