package arrays.two_pointers;

import java.util.Arrays;

/* 
 * Problem Description:
 * 
 * Winter is coming! During the contest, your first job is to design a standard heater
 * with a fixed warm radius to warm all the houses.
 * Every house can be warmed, as long as the house is within the heater's warm radius
 * range. 
 * Given the positions of houses and heaters on a horizontal line, return the minimum
 * radius standard of heaters so that those heaters could cover all houses.
 * Notice that all the heaters follow your radius standard, and the warm radius will
 * be the same.
 * */

/*
 * LeetCode problem link - https://leetcode.com/problems/heaters/description/
 * */

/*
 * Time Complexity:- O(nlogm + nlogn) → sorting houses O(nlogn) + for each house binary search in heaters O(nlogm)
 * 
 * Space Complexity:- O(1) extra (ignoring input sorting)
 * */

public class Heaters {
	
	public static int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);
        int maxRadius = 0;
        for (int house : houses) {
            maxRadius = Math.max(maxRadius, findNearestHeater(heaters, house));
        }

        return maxRadius;
    }

    static int findNearestHeater(int[] heaters, int housePosition){
        int leftNearestHeater = -1, rightNearestHeater = -1;
        int low, high, mid;
        // find left nearest heater for house in housePosition with binary search
        low = 0;
        high = heaters.length - 1;
        while(low <= high){
            mid = low + (high - low) / 2;
            int val = heaters[mid];
            if(val <= housePosition){
                leftNearestHeater = mid;
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }

        // find right nearest heater for house in housePosition with binary search
        low = 0;
        high = heaters.length - 1;
        while(low <= high){
            mid = low + (high - low) / 2;
            int val = heaters[mid];
            if(val >= housePosition){
                rightNearestHeater = mid;
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }

        int leftDist = (leftNearestHeater == -1) ? Integer.MAX_VALUE: housePosition - heaters[leftNearestHeater];
        int rightDist = (rightNearestHeater == -1) ? Integer.MAX_VALUE: heaters[rightNearestHeater] - housePosition;
        return Math.min(leftDist, rightDist);
    }

	void main() {
		
		int[] heaters = {1,2,3}; 
		int[] houses = {2};
		System.out.println(findRadius(heaters,houses));
	}

}
