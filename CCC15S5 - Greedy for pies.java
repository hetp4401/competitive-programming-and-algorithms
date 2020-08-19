
import java.util.Arrays;
import java.util.Scanner;

public class ccc15s5 {
	
	static int n;
	static int m;
	static int[] N;
	static int[] M;
	static int[][][][] dp;
	
	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		
		n = s.nextInt();
		N = new int[n+1];
		for(int i = 1; i <= n; i++) N[i] = s.nextInt();
		
		m = s.nextInt();
		M = new int[m+1];
		for(int i = 1; i <= m; i++) M[i] = s.nextInt();
		
		Arrays.sort(M);
		
		dp = new int [n+2][m+2][m+2][2];
		for(int i = 0; i < n+2; i++) {
			for(int j = 0; j < m+2; j++) {
				for(int k = 0; k < m+2; k++) {
					for(int l = 0; l < 2; l++) {
						dp[i][j][k][l] = -1;
					}
				}
			}
		}
		
		System.out.println(solve(1, 1, m, 0));
	}
	public static int solve(int i, int j, int k, int l) {
		if(dp[i][j][k][l] != -1) return dp[i][j][k][l];
		int best = 0;
		if(l == 0) {
			if(i != n+1) best = Math.max(N[i] + solve(i+1, j, k, 1), best);
			if(j <= k) best = Math.max(M[k] + solve(i, j, k-1, 1), best);
		}
		if(i != n+1) best = Math.max(solve(i+1, j, k, 0), best);
		if(j <= k) best = Math.max(solve(i, j+1, k, 0), best);
		dp[i][j][k][l] = best;
		return best;
	}
}
