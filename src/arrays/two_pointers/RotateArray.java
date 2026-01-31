package arrays.two_pointers;

/* 
 * Problem Description:
 * 
 * Given an integer array nums, rotate the array to the right by k steps, 
 * where k is non-negative.
 * */

/*
 * Leetcode problem link - https://leetcode.com/problems/rotate-array/description/
 * */

/*
 * Time Complexity:- O(n) -> because of a single while loop
 * 
 * Space Complexity:- O(1) -> because of constant variables
 * */

public class RotateArray {
	
	public static void rotateRight(int[] nums, int k) {
		int n = nums.length;
		k = k % n;
		
		// rotating to right, so the break point will be at the right side of array
		int breakPoint = n - k; // used to break array into 2 parts
        
        reverseArray(nums,0,breakPoint-1); // reverse first part of array
        reverseArray(nums,breakPoint,n - 1); // reverse second part of array
        reverseArray(nums,0,n - 1); // reverse the whole array
        
    }
	
	public static void rotateLeft(int[] nums, int k) {
		int n = nums.length;
		k = k % n;
		
        reverseArray(nums,0,k-1);
        reverseArray(nums,k,n - 1);
        reverseArray(nums,0,n - 1);
    }
	
	private static void reverseArray(int[] nums, int startIndex, int endIndex) {
		while(startIndex < endIndex) {
			nums[startIndex] = nums[startIndex] + nums[endIndex];
			nums[endIndex] = nums[startIndex] - nums[endIndex];
			nums[startIndex] = nums[startIndex] - nums[endIndex];
			startIndex++;
			endIndex--;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1,2,3,4,5,6,7};
		int k = 3;
		rotateRight(nums, k);
		System.out.println("Output after rotating to right "+ k +" times");
		for(int a: nums) {
			System.out.print(a+ " ");
		}
		System.out.println();
		int[] nums1 = {1,2,3,4,5,6,7};
		rotateLeft(nums1, k);
		System.out.println("Output after rotating to left "+ k +" times");
		for(int a: nums1) {
			System.out.print(a+ " ");
		}
	}

}
