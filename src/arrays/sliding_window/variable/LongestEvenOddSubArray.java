package arrays.sliding_window.variable;

/* 
 * Problem Description:
 * 
 * You are given a 0-indexed integer array nums and an integer threshold.
 * Find the length of the longest subarray of nums starting at index l and ending at index r 
 * (0 <= l <= r < nums.length) that satisfies the following conditions:
 * - nums[l] % 2 == 0
 * - For all indices i in the range [l, r - 1], nums[i] % 2 != nums[i + 1] % 2
 * - For all indices i in the range [l, r], nums[i] <= threshold
 * Return an integer denoting the length of the longest such subarray.
 * Note: A subarray is a contiguous non-empty sequence of elements within an array.
 * */

/*
 * Leetcode problem link - https://leetcode.com/problems/longest-even-odd-subarray-with-threshold/description/
 * */

/*
 * Time Complexity:- O(n) – each element is visited at most a constant number of times as left and right pointers move forward through the array.
 * 
 * Space Complexity:- O(1) – only a few integer variables are used, so no extra space grows with input size.
 * */

public class LongestEvenOddSubArray {
	
	public static int longestAlternatingSubarray(int[] nums, int threshold) {
		int maxLength = 0, n = nums.length;
        int left = 0, right = 0;
        // find starting index and assign to left
        while(nums[left] % 2 != 0 || nums[left] > threshold){
        	// No Even element less than or equal to threshold is present
            if(left == n - 1)
        		return 0;
            left++;
        }

        for(right = left+1; right < n; right++){
            if((nums[right] % 2 == nums[right-1] % 2) || nums[right] > threshold || nums[right-1] > threshold){
                maxLength = Math.max(maxLength, right - left);
                // finding next left
                left++;
                while(nums[left] % 2 != 0 || nums[left] > threshold){
                    if(left == n - 1)
        		        break;
                    left++;
                }
                right = left;
            }
        }
        // if all of the elements are under threshold and satisfy the even odd criteria - then the maxLength in above loop will not be calculated
        maxLength = Math.max(maxLength, right - left);
        return maxLength;
    }

	public static void main(String[] args) {
		int[] nums = {3,2,5,4};
		int threshold = 5; // ans: 3
//		int[] nums = {2,3,4,5};
//		int threshold = 4; // ans: 3
//		int[] nums = {1};
//		int threshold = 1; // ans: 0
		System.out.println(longestAlternatingSubarray(nums, threshold));
	}

}
