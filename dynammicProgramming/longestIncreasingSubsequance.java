package dynammicProgramming;

import java.util.Arrays;
import java.util.Scanner;

public class longestIncreasingSubsequance {
	
	public static void main (String[] args) { 
		
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		
		int[] nums = new int[n];
		int[] longs = new int[n];
		Arrays.fill(longs, 1);
		
		int high = 1;
		for(int i = 0; i < n; i++) {
			nums[i] = s.nextInt();
			for(int j = 0; j < i; j++) {
				if(nums[i] > nums[j]) {
					int sum = longs[j] + 1;
					longs[i] = Math.max(sum, longs[i]);
				}
			}
			high = Math.max(high, longs[i]);
		}
		System.out.println(high);
    } 
}


/* 
Given an array of integers, find the longest increasing subsequence.
A subsequence is just a collection of numbers from the array - however, they must be in order.

For example:
Array: 1 2 5 4 3 6
The longest increasing subsequence here is 1 2 5 6 (or 1 2 4 6, or 1 2 3 6).
The numbers must be strictly increasing - no two numbers can be equal.

Input
N <= 5000, the number of integers.
N lines, each with a value in the array.

Output
The length of the longest increasing subsequence of the array.

*/