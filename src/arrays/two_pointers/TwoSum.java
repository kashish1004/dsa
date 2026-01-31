package arrays.two_pointers;

/* 
 * Problem Description:
 * 
 * Given a 1-indexed array of integers numbers that is already sorted in non-decreasing order,
 * find two numbers such that they add up to a specific target number.
 * Let these two numbers be numbers[index1] and numbers[index2] where 
 * 1 <= index1 < index2 <= numbers.length.
 * Return the indices of the two numbers, 
 * index1 and index2, added by one as an integer 
 * array [index1, index2] of length 2.
 * */

/*
 * Leetcode problem link - https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/description/
 * */

/*
 * Time Complexity:- O(n) -> because of  a single while loop
 * 
 * Space Complexity:- O(1) -> because of constant variables
 * */

public class TwoSum {
	
	public static int[] twoSum(int[] numbers, int target) {
        int i = 0;
        int j = numbers.length - 1;
        int[] ans = new int[2];
        while(i < j) {
        	int a = numbers[i];
        	int b = numbers[j];
        	if(a+b == target) {
        		ans[0] = i+1;
        		ans[1] = j+1;
        		break;
        	}
        	else if(a+b < target) {
        		i++;
        	}
        	else {
        		j--;
        	}
        }
        return ans;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {2,7,11,15};
		int target = 9;
		int[] arr = twoSum(nums,target);
		for(int a:arr) {
			System.out.print(a+" ");
		}
		
	}

}
