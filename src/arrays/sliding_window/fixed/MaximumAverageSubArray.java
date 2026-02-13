package arrays.sliding_window.fixed;

/* 
 * Problem Description:
 * 
 * You are given an integer array nums consisting of n elements, and an integer k.
 * Find a contiguous subarray whose length is equal to k that has the maximum average value
 * and return this value. Any answer with a calculation error less than 10-5 will be accepted.
 * */

/*
 * Leetcode problem link - https://leetcode.com/problems/maximum-average-subarray-i/description/
 * */

/*
 * Time Complexity:- O(n) -> as a loop is used there is a possibility of traversing the whole array
 * 
 * Space Complexity:- O(1) -> as just integers variables are used which makes the space used as constant.
 * */
	 
public class MaximumAverageSubArray {
	
	// as the sub array size is fixed so max sum in that fixed sub array size will have max average
	public static double findMaxAverage(int[] nums, int k) {
        int windowSum = 0, n = nums.length;
        for(int i = 0; i < k; i++){
            windowSum += nums[i];
        }
        int maxSum = windowSum;
        for(int i = k; i < n; i++){
            windowSum = windowSum - nums[i-k] + nums[i];
            maxSum = Math.max(maxSum,windowSum);
        }
        return maxSum * 1d / k;
    }

	public static void main(String[] args) {
		int[] nums = {1,12,-5,-6,50,3};
		int k = 4;
		System.out.println(findMaxAverage(nums, k));
	}

}
