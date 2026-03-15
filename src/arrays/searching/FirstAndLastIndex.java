package arrays.searching;

import java.util.Arrays;

/* 
 * Problem Description:
 * 
 * Given an array of integers nums sorted in non-decreasing order,
 * find the starting and ending position of a given target value.
 * If target is not found in the array, return [-1, -1].
 * You must write an algorithm with O(log n) runtime complexity.
 * */

/*
 * Leetcode problem link - https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/description/
 * */

/*
 * Time Complexity:- O(log n) -> Two binary searches are performed (for first and last position), and each binary search takes log n time.
 * 
 * Space Complexity:- O(1) -> Only a few variables are used and no extra space proportional to input size is required.
 * */

public class FirstAndLastIndex {

	public static int[] searchRange(int[] nums, int target) {
		int ans[] = new int[2];
        ans[0] = firstPositionOfElement(nums,target);
        ans[1] = lastPositionOfElement(nums,target);
        
        return ans;
    }
	
	private static int firstPositionOfElement(int nums[], int target) {
		int left = 0, right = nums.length - 1, firstIndex = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;

            if(nums[mid] == target) {
            	firstIndex = mid;
            	right = mid - 1;
            }
            else if(nums[mid] < target) {
            	left = mid + 1;
            }
            else {
            	right = mid - 1;
            }
        }
        
        return firstIndex;
	}
	
	private static int lastPositionOfElement(int nums[], int target) {
		int left = 0, right = nums.length - 1, lastIndex = -1;
		while (left <= right) {
            int mid = left + (right - left) / 2;

            if(nums[mid] == target) {
            	lastIndex = mid;
            	left = mid + 1;
            }
            else if(nums[mid] < target) {
            	left = mid + 1;
            }
            else {
            	right = mid - 1;
            }
        }
        
        return lastIndex;
	}
	
	public static void main(String[] args) {
		int[] nums = {5,7,7,8,8,10};
		int target = 8;
		System.out.println(Arrays.toString(searchRange(nums, target)));
	}

}
