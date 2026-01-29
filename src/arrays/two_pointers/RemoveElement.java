package arrays.two_pointers;

/* 
 * Problem Description:
 * 
 * Given an integer array nums and an integer val,
 * remove all occurrences of val in nums in-place.
 * The order of the elements may be changed. 
 * Then return the number of elements in nums which are not equal to val.
 * */

/*
 * Leetcode problem link - https://leetcode.com/problems/remove-element/description/
 * */

/*
 * Time Complexity:- O(n) -> as a loop is used there is a possibility of traversing the whole array
 * 
 * Space Complexity:- O(1) -> as just integers variables are used which makes the space used as constant.
 * */

public class RemoveElement {

	public static int removeElement(int[] nums, int val) {
		int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[index] = nums[i];
                index++;
            }
        }
        return index;
	}

	public static void main(String[] args) {
		int[] nums = { 0,1,2,2,3,0,4,2 };
		int val = 2;
		int index = removeElement(nums, val);
		for (int i = 0; i < index; i++) {
			System.out.print(nums[i] + " ");
		}

	}

}