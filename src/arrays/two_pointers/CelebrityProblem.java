package arrays.two_pointers;

/* 
 * Problem Description:
 * 
 * A celebrity is a person who is known to all but does not know anyone at a party.
 * A party is being organized by some people.
 * A square matrix mat[][] of size n*n is used to represent people at the party such that
 * if an element of row i and column j is set to 1 it means ith person knows jth person.
 * You need to return the index of the celebrity in the party, if the celebrity does not exist, return -1.
 * Note: Follow 0-based indexing
 * */

/*
 * Leetcode problem link - https://leetcode.com/problems/find-the-celebrity/
 * */

/*
 * Time Complexity:- O(n) -> one linear pass to eliminate candidates and one linear pass to verify the potential celebrity.
 * 
 * Space Complexity:- O(1) -> only a few variables are used, with no extra data structures.
 * */

public class CelebrityProblem {
	
	public static int findCelebrity(int[][] matrix) {
		int l = 0, n = matrix.length, r = n - 1;
		while(l < r) {
			if(matrix[l][r] == 1) {
				l++;
			}
			else {
				r--;
			}
		}
		for(int i = 0; i < n; i++) {
			if(i == l) continue;
			if(matrix[l][i] == 1 || matrix[i][l] == 0) {
				return -1;
			}
		}
		return l;
	}

	public static void main(String[] args) {
		int[][] nums = {
				{0,1,1,0},
				{0,0,0,0},
				{1,1,0,0},
				{0,1,1,0}
				};
		
		System.out.println(findCelebrity(nums));
		

	}

}
