package arrays.sliding_window.variable;

/* 
 * Problem Description:
 * 
 * Given an array of integers nums and an integer k,
 * return the number of contiguous subarrays where the product of all the elements
 * in the subarray is strictly less than k.
 * */

/*
 * Leetcode problem link - https://leetcode.com/problems/subarray-product-less-than-k/description/
 * */

/*
 * Time Complexity:- O(n) -> each element is added to and removed from the sliding window at most once.
 * 
 * Space Complexity:- O(1) -> only a few variables are used, with no extra data structures.
 * */

public class SubArrayProductsLessThanK {
	
	public static int numSubarrayProductLessThanK(int[] nums, int k) {
        if(k <= 1) return 0;
        int l = 0, n = nums.length, c = 0, product = 1;
        for(int r = 0; r < n; r++) {
        	product *= nums[r];
        	
        	while(product >= k) {
                product /= nums[l];
                l++;
        	}
            c += r - l + 1;
        	
        }
        return c;
    }

	public static void main(String[] args) {
		int[] nums = {10,5,2,6};
		int k = 100;
		System.out.println(numSubarrayProductLessThanK(nums, k));
	}

}
