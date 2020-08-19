
import java.util.Scanner;

public class ccc15j5 {

    static int[][][] dp;
	
	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		
		int n = s.nextInt();
		int k = s.nextInt();
		
		dp = new int[n+1][k+1][n+1];
		
		System.out.println(solve(n, k, 1));
	}
	
	public static int solve(int n, int k, int m) {
		if(dp[n][k][m] == 0) {
			if(k == 1) {
				dp[n][k][m] = 1;
			} else {
				int t = 0;
				for(int i = m; i <= n/k; i++) {
					t += solve(n-i, k-1, i);
				}
				dp[n][k][m] = t;
			}
		}
		return dp[n][k][m];
    }
}