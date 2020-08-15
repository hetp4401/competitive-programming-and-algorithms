package dynammicProgramming;

import java.util.Scanner;

public class bowlingForNumbers2 {
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

		int n = s.nextInt();

		for (int c = 0; c < n; c++) {

			int pins = s.nextInt();
			int balls = s.nextInt();
			int size = s.nextInt();

			int[] diff = new int[pins + 1];
			for (int i = 1; i < pins + 1; i++)
				diff[i] = diff[i - 1] + s.nextInt();

			int[][] dp = new int[balls + 1][pins + 1];
			for (int i = 1; i < pins + 1; i++) {
				dp[1][i] = Math.max(dp[1][i - 1], i - size >= 0 ? diff[i] - diff[i - size] : diff[i]);
			}

			for (int i = 2; i < balls + 1; i++) {
				for (int j = 1; j < pins + 1; j++) {
					int m1 = dp[i][j - 1];
					int m2 = j - size >= 0 ? dp[i - 1][j - size] + diff[j] - diff[j - size] : diff[j];
					int m3 = 0;
					for (int k = 1; k <= size - 1 && j - size - k >= 0; k++) {
						m3 = Math.max(diff[j] - diff[j - size - k] + dp[i - 2][j - size - k], m3);
					}
					dp[i][j] = Math.max(Math.max(m1, m2), m3);
				}
			}
			System.out.println(dp[balls][pins]);
		}
	}
}


/*

Same as bowling for numbers but wiht negative value pins

Sample Input
2
9 2 3
2
8
5
1
9
6
9
3
2
9 3 3
2
8
-5
3
5
8
4
8
-6

Sample Output
39
38

*/