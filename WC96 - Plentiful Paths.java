package dynammicProgramming;

import java.util.Scanner;

public class plentifulPaths {
    public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		
		int m = s.nextInt();
		int n = s.nextInt();
		
		int[][] dp = new int[m+1][n+1];
		
		while(true) {
			int y = s.nextInt();
			int x = s.nextInt();
			if(y == 0) break;
			dp[y][x] = 1;
		}
		
		for(int i = 1; i < m+1; i++) {
			for(int j = 1; j < n+1; j++) {
				dp[i][j] += Math.max(dp[i][j-1], dp[i-1][j]); 
			}
		}	
		System.out.println(dp[m][n]);
	}
}

/* 
Given is an M by N grid and on each square of the grid there may or may not be an apple on it. Let A be the bottom left square and B be the upper right square of the grid. Find the path from A to B (shown below) going up and right only that passes through the most number of squares with apples in them. For this path output the number of apples on it.

For example, here is a 4 by 4 grid:

    .a.a <-B
    ..aa
    a.a.
A-> ....
Each square can have at most one apple (this includes squares A and B).

Input
Your program should read in the size of the grid, M N, where 1 ≤ M, N ≤ 100. The locations of the apples where A is at (1, 1) and B is at (M, N). Inputs will end with 0 0 and have the same format as the one below. In our example, the input would be

4 4
2 1
2 3
3 3
3 4
4 2
4 4
0 0

Output
Give the number of apples on the path with the most number of them. In this case

5
*/