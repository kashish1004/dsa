package arrays.sliding_window.variable;

/* 
 * Problem Description:
 * 
 * Given an array of positive integers nums and a positive integer target,
 * return the minimal length of a subarray whose sum is greater than or equal to target.
 * If there is no such subarray, return 0 instead.
 * */

/*
 * Leetcode problem link - https://leetcode.com/problems/minimum-size-subarray-sum/description/
 * */

/*
 * Time Complexity:- O(n) -> each element is added to and removed from the sliding window at most once.
 * 
 * Space Complexity:- O(1) -> only a few variables are used, with no extra data structures.
 * */

public class MinimumSizeSubarraySum {
	
	public static int minSubArrayLen(int target, int[] nums) {
        int l = 0, n = nums.length, minLength = Integer.MAX_VALUE, sum = 0;
        for(int r = 0; r < n; r++) {
        	sum += nums[r];
        	
        	while(sum >= target) {
        		minLength = Math.min(minLength, r - l + 1);
                sum -= nums[l];
                l++;
        	}
        	
        }
        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }

	public static void main(String[] args) {
		int[] nums = {2,3,1,2,4,3};
		int target = 7;
		System.out.println(minSubArrayLen(target, nums));
	}

}
