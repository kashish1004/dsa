package arrays.two_pointers;

import java.util.HashSet;
import java.util.Set;

/* 
 * Problem Description:
 * 
 * You are playing a game involving a circular array of non-zero integers nums. 
 * Each nums[i] denotes the number of indices forward/backward you must move if you are located at index i:
 * 		- If nums[i] is positive, move nums[i] steps forward, and
 * 		- If nums[i] is negative, move abs(nums[i]) steps backward.
 * Since the array is circular, you may assume that moving forward from the last element
 * puts you on the first element, and moving backwards from the first element puts you on the last element.
 * A cycle in the array consists of a sequence of indices seq of length k where:
 * 		- Following the movement rules above results in the repeating index sequence seq[0] -> seq[1] -> ... -> seq[k - 1] -> seq[0] -> ...
 * 		- Every nums[seq[j]] is either all positive or all negative.
 * 		- k > 1
 * Return true if there is a cycle in nums, or false otherwise.
 * */

/*
 * Leetcode problem link - https://leetcode.com/problems/circular-array-loop/description/
 * */

/*
 * Time Complexity:- O(n^2) -> nested loops
 * 
 * Space Complexity:- O(n) -> because of set
 * */

public class CircularArrayLoop {
	
	public static boolean circularArrayLoop(int[] nums) {
		int prev = 0,next = 0; // to keep track of previous and next index
        int n = nums.length;
        Set<Integer> set = null; // to keep track of seen indexes
        for(int i = 0; i < n; i++){
        	prev = i;
            set = new HashSet<>();
            next = (prev + nums[prev]) % n;
            if(nums[prev] < 0)
            	next = (n + next) % n;
            while(((nums[prev] > 0 && nums[next] > 0) || 
                  (nums[prev] < 0 && nums[next] < 0)) && 
                  prev != next) // for same direction and self cycle 
                  {
                        if(set.contains(next)){
                        	return true;
                        }else {
                            set.add(next);
                        }
                        prev = next;
                        next = (prev + nums[prev]) % n;
                        if(nums[prev] < 0)
                        	next = (n + next) % n;
                  }
        }
        return false;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int[] nums = { 2,-1,1,2,2 }; // true
//		int[] nums = { -1,-2,-3,-4,-5,6 }; //false
//		int[] nums = { 1,-1,5,1,4 }; //true
//		int[] nums = { -2,1,-1,-2,-2 }; // false
		int[] nums = { -1,-2,-3,-4,-5 }; // false
//		int[] nums = {2,2,2,2,2,4,7}; //false
//		int[] nums = {-2,-3,-9}; // false
		System.out.println(circularArrayLoop(nums));
	}

}
