package arrays.sliding_window.fixed;

/* 
 * Problem Description:
 * 
 * Given an array of integers arr and two integers k and threshold,
 * return the number of sub-arrays of size k and average greater than or equal to threshold.
 * */

/*
 * Leetcode problem link - https://leetcode.com/problems/number-of-sub-arrays-of-size-k-and-average-greater-than-or-equal-to-threshold/description/
 * */

/*
 * Time Complexity:- O(n) -> Each element is processed at most twice (once when added to the window and once when removed).
 * 
 * Space Complexity:- O(1) -> as just integers variables are used which makes the space used as constant.
 * */

public class NumberOfSubArraysAvgGreaterThan {
	
	public static int numOfSubarrays(int[] arr, int k, int threshold) {
        int count = 0, windowSum = 0, n = arr.length;
        threshold = threshold * k;
        for(int i = 0; i < k; i++) {
        	windowSum += arr[i];
        }
        
        if(windowSum >= threshold) {
        	count++;
        }
        
        for(int i = k; i < n; i++) {
        	windowSum += arr[i] - arr[i - k];
        	if(windowSum >= threshold) {
            	count++;
            }
        }
        return count;
    }

	public static void main(String[] args) {
		int[] nums = {2,2,2,2,5,5,5,8};
		int k = 3;
		int threshold = 4; 
		System.out.println(numOfSubarrays(nums, k, threshold));

	}

}
