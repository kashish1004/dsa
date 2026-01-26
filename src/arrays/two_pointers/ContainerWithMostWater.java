package arrays.two_pointers;

/* 
 * Problem Description:
 * 
 * You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).
 * Find two lines that together with the x-axis form a container, such that the container contains the most water.
 * Return the maximum amount of water a container can store.
 * Notice that you may not slant the container.
 * */

/*
 * Leetcode problem link - https://leetcode.com/problems/container-with-most-water/description/
 * */



/*
 * Time Complexity:- O(n) -> as a loop is used there is a possiblity of traversing the whole array
 * 
 * Space Complexity:- O(1) -> as just integers variables are used which makes the space used as constant.
 * */

public class ContainerWithMostWater {
    public static int maxArea(int[] height) {
        int i=0,j=height.length-1;
        int max=0,w=0,h=0,area=0;
        while(i<j){
            h = Math.min(height[i],height[j]);
            w = j-i;
            area = w*h;
            max = Math.max(max,area);
            if(height[i]<height[j]){
                i++;
            }
            else if(height[i]>height[j]){
                j--;
            }
            else{
                i++;
                j--;
            }
        }
        return max;
    }
    
    public static void main(String[] args) {
		int[] height = {1,8,6,2,5,4,8,3,7};
		int answer = maxArea(height);
		System.out.println("answer is : "+ answer);
	}
}