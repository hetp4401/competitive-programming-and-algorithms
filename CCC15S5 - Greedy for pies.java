
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



/* 
The local pie shop is offering a promotion – all-you-can-eat pies! Obviously, you can't pass up this offer.

The shop lines up N pies from left to right – the i-th pie contains Ai grams of sugar. Additionally, another 
M pies are provided - the i-th of these contains Bi grams of sugar.

You are first allowed to insert each of the M pies from the second group anywhere into the first list of N 
pies, such as its start or end, or in between any two pies already in the list. The result will be a list of
N + M pies with the constraint that the initial N pies are still in their original relative order.

Following this, you are allowed to take one walk along the new line of pies from left to right, to pick up 
your selection of all-you-can-eat pies! When you arrive at a pie, you may choose to add it to your pile, or
skip it. However, because you're required to keep moving, if you pick up a certain pie, you will not be able
to also pick up the pie immediately after it (if any). In other words, you cannot eat consecutive pies in 
this combined list!

Being a pie connoisseur, your goal is to maximize the total amount of sugar in the pies you pick up from 
this line. How many grams can you get?

Input
The first line of input contains the integer N (1 ≤ N ≤ 3000). The next N lines contain one integer Ai (1 ≤ Ai ≤ 105), describing the integer number of grams of sugar in pie i in the group of N pies.
The next line contains the integer M (0 ≤ M ≤ 100), the number of pies in the second list. The next M lines contain one integer Bi (1 ≤ Bi ≤ 105), describing the integer number of grams of sugar in pie i in the group of M pies.

Output
Output the maximum number of grams of sugar in all the pies that you are able to pick up.

Sample Input
5
10
12
6
14
7
3
1
8
2

Sample Output
44

Explanation
Place the pies in the order: 10, 1, 12, 2, 8, 6, 14, 7 (that is, insert the pie with 1 gram of sugar between
 10 and 12, and insert pies with 2 and 8 grams of sugar, in that order, between pies 12 and 6). Then, we can
  grab 10 + 12 + 8 + 14 = 44 grams of sugar, which is maximal.
*/
