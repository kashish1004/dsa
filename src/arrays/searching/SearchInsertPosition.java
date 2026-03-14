package arrays.searching;

/* 
 * Problem Description:
 * 
 * Given a sorted array of distinct integers and a target value, 
 * return the index if the target is found. 
 * If not, return the index where it would be if it were inserted in order.
 * You must write an algorithm with O(log n) runtime complexity.
 * */

/*
 * Leetcode problem link - https://leetcode.com/problems/search-insert-position/description/
 * */

/*
 * Time Complexity:- O(log n) -> because the algorithm halves the search space on each iteration (binary search).
 * 
 * Space Complexity:- O(1) -> as just integers variables are used which makes the space used as constant.
 * */

public class SearchInsertPosition {

	public static int searchInsert(int[] nums, int target) {
		int left = 0, right = nums.length;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] < target)
                left = mid + 1;
            else
                right = mid;
        }
        return left;
    }
	
	public static void main(String[] args) {
		int[] nums = {1,3,5,6};
		int target = 2;
		System.out.println(searchInsert(nums, target));
	}

}
