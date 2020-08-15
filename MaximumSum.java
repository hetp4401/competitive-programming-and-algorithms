package dynammicProgramming;

import java.util.Scanner;

public class maximumSum {
	
	public static void main(String[] args) throws Exception {
		
		Scanner s = new Scanner(System.in);
	
		int n = s.nextInt();
		int[] sums = new int[n+3];
		
		for(int i = 0; i < n; i++) {
			int a = s.nextInt();
			sums[i+3] = Math.max(sums[i] + a, sums[i+1] + a);
		}	
		System.out.println(Math.max(sums[n+2], sums[n+1]));
	}
}


/* 
Given an array of (positive) integers, find a subset with the maximal sum.
However, there is the additional restriction that no two numbers in the subset may be adjacent.

For example, for the array 4 5 6 9 10:
4 6 10 is valid, while 5 9 10 is invalid since 9 and 10 are next to each other.
4 6 10 happens to be the optimal sum in this case, so 20 is the answer.

Input
An integer 1 < N <= 100,000.
N lines, each with one positive integer in the sequence <= 1000

Output
The maximum sum possible.

Sample Input
10
55
62
87
62
52
69
16
87
54
3

Sample Output
301
*/