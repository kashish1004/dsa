package arrays.two_pointers;

import java.util.List;
import java.util.Set;
import java.util.HashSet;
import java.util.ArrayList;
import java.util.Arrays;

/* 
 * Problem Description:
 * 
 * Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]]
 * such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
 * Notice that the solution set must not contain duplicate triplets.
 * */

/*
 * Leetcode problem link - https://leetcode.com/problems/3sum/description/
 * */

/*
 * Time Complexity:- O(n*n) -> as nested loop is used
 * 
 * Space Complexity:- O(n*n) -> as list can store all possible triplets in worst case
 * */

public class ThreeSum {
	
	public static List<List<Integer>> threeSum(int[] nums) {
		Set<List<Integer>> set = new HashSet<>();
		Arrays.sort(nums);
		int length = nums.length;
		int i = 0, j = i + 1, k = length - 1;
		while(i <= length - 3) {
			j = i + 1;
			k = length - 1;
			while(j < k) {
				int sum = nums[i] + nums[j] + nums[k];
				if(sum == 0) {
					List<Integer> sublist = new ArrayList<>();
					sublist.add(nums[i]);
					sublist.add(nums[j]);
					sublist.add(nums[k]);
					set.add(sublist);
					j++;
				}
				else if(sum < 0) {
					j++;
				}
				else {
					k--;
				}
			}
			i++;
		}
		
		return new ArrayList<>(set);
    }

	public static void main(String[] args) {
		
		int[] nums = {0,0,0};
		System.out.println(threeSum(nums));
		
	}

}
