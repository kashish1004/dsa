package arrays.sliding_window.fixed;

/* 
 * Problem Description:
 * 
 * You are given a 0-indexed array nums of n integers, and an integer k.
 * 
 * The k-radius average for a subarray of nums centered at some index i
 * with the radius k is the average of all elements in nums between the indices i - k and i + k (inclusive).
 * If there are less than k elements before or after the index i, then the k-radius average is -1.
 * 
 * Build and return an array avgs of length n where avgs[i] is the k-radius average for the subarray centered at index i.
 * The average of x elements is the sum of the x elements divided by x, using integer division.
 * The integer division truncates toward zero, which means losing its fractional part.
 * For example, the average of four elements 2, 3, 1, and 5 is (2 + 3 + 1 + 5) / 4 = 11 / 4 = 2.75, which truncates to 2.
 * */

/*
 * Leetcode problem link - https://leetcode.com/problems/k-radius-subarray-averages/description/
 * */

/*
 * Time Complexity:- O(n) -> because each element is added to and removed from the sliding window at most once.
 * 
 * Space Complexity:- O(n) -> because we store the result in a new array of size n (constant extra space besides that).
 * */

public class KRadiusSubarrayAverages {
	
	public static int[] getAverages(int[] nums, int k) {
        int n = nums.length;
        int ans[] = new int[n];
        int actualK = 2*k + 1;
        long windowSum = 0;

        for(int i = 0; i < n; i++){
            ans[i] = -1;
        }

        if(n < actualK){
            return ans;
        }

        for(int i = 0; i < actualK; i++){
            windowSum += nums[i];
        }
        ans[k] = (int)(windowSum / actualK);

        for(int i = k; i < n - k - 1; i++){
            windowSum += nums[i + k + 1] - nums[i - k];
            ans[i+1] = (int)(windowSum / actualK);
        }

        return ans;
    }

	public static void main(String[] args) {
		int[] nums = {7,4,3,9,1,8,5,2,6};
		int k = 3;
		int[] averages = getAverages(nums, k);
		for(int i = 0; i < averages.length; i++) {
			if(i == averages.length - 1) {
				System.out.print(averages[i]);
				break;
			}
			System.out.print(averages[i]+", ");
		}
		

	}

}
