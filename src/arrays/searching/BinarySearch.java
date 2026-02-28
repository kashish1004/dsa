package arrays.searching;

/* 
 * Problem Description:
 * 
 * Given an array of integers nums which is sorted in ascending order, and an integer target, 
 * write a function to search target in nums. If target exists, then return its index. Otherwise, return -1.
 * You must write an algorithm with O(log n) runtime complexity.
 * */

/*
 * Leetcode problem link - https://leetcode.com/problems/binary-search/description/
 * */

/*
 * Time Complexity:- O(log n) -> because the algorithm halves the search space on each iteration (binary search).
 * 
 * Space Complexity:- O(1) -> as just integers variables are used which makes the space used as constant.
 * */

public class BinarySearch {
	
	public static int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(nums[mid] == target)
                return mid;
            else if(nums[mid] < target)
                left = mid + 1;
            else
                right = mid - 1;
        }
        return -1;
    }
	
	public static void main(String[] args) {
		int[] nums = {-1,0,3,5,9,12};
		int target = 9;
		System.out.println(search(nums, target));
	}

}
