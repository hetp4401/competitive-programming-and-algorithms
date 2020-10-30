import java.util.Scanner;

public class ccc02s4 {
	
	static int[][] mat;
	static int[][] sums;
	static int[][][][] dp;
		
	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		
		int n = s.nextInt();
		int m = s.nextInt();
		
		mat = new int[n][m];
		sums = new int[n][m];
		dp = new int[n][m][n][m];
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				for(int k = 0; k < n; k++) {
					for(int l = 0; l < m; l++) {
						dp[i][j][k][l] = -1;
					}
				}
			}
		}
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				mat[i][j] = s.nextInt();
				int s1 = i-1 >= 0 ? sums[i-1][j] : 0;
				int s2 = j-1 >= 0 ? sums[i][j-1] : 0;
				int s3 = i-1 >= 0 && j-1 >= 0? sums[i-1][j-1] : 0;
				sums[i][j] = mat[i][j]+s1+s2-s3;
				dp[i][j][i][j] = 0;
			}
		}		
		
		System.out.println(raisins(0, 0, n-1, m-1));
    }
	
	public static int raisins(int y, int x, int y2, int x2) {
		if(dp[y][x][y2][x2] != -1) return dp[y][x][y2][x2];
		
		int min = Integer.MAX_VALUE;
		for(int i = y; i < y2; i++) min = Math.min(min, raisins(y, x, i, x2) + raisins(i+1, x, y2, x2));
		for(int j = x; j < x2; j++) min = Math.min(min, raisins(y, x, y2, j) + raisins(y, j+1, y2, x2));
		
		int s1 = y-1 >= 0 ? sums[y-1][x2] : 0;
		int s2 = x-1 >= 0 ? sums[y2][x-1] : 0;
		int s3 = y-1 >= 0 && x-1 >= 0 ? sums[y-1][x-1] : 0;
		
		return dp[y][x][y2][x2] = min + sums[y2][x2] - s1 - s2 + s3;
	}	
}

/* 
problem can be found here https://dmoj.ca/problem/ioi09p4
*/