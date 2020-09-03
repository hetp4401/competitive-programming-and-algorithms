
import java.util.Scanner;

public class ccc16s4 {
	
	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		
		int n = s.nextInt();
		
		int ans = 0;
		
		int[] arr = new int[n+1];
		int[][] dp = new int[n+1][n+1];
		
		for(int i = 1; i <= n; i++) arr[i] = s.nextInt();
		for(int i = 1; i <= n; i++) dp[i][i] = arr[i];
		
		for(int i = 0; i < n; i++) {
			for(int j = 1; j <= n-i; j++) {
				int l = j;
				int r = i+j;
				int ls = arr[l];
				int rs = arr[r];
				while(l < r) {
					if(ls == rs && dp[j][l] != 0 && dp[r][j+i] != 0 && (r-l != 1 ? dp[l+1][r-1] != 0 : true)) {
						dp[j][i+j] = dp[j][l] + dp[r][j+i] + (r-l != 1 ? dp[l+1][r-1] : 0);
						break;
					}else if(ls < rs) {
						l++;
						ls += arr[l];
					}else {
						r--;
						rs += arr[r];
					}
				}
				ans = Math.max(ans, dp[j][i+j]);
			}
		}
		
		System.out.println(ans);
	}
}



/* 
Alphonse has N rice balls of various sizes in a row. He wants to form the largest rice ball possible for 
his friend to eat. Alphonse can perform the following operations:

If two adjacent rice balls have the same size, Alphonse can combine them to make a new rice ball. The new 
rice ball's size is the sum of the two old rice balls' sizes. It occupies the position in the row 
previously occupied by the two old rice balls.

If two rice balls have the same size, and there is exactly one rice ball between them, Alphonse can 
combine all three rice balls to make a new rice ball. (The middle rice ball does not need to have the 
same size as the other two.) The new rice ball's size is the sum of the three old rice balls' sizes. 
It occupies the position in the row previously occupied by the three old rice balls.
Alphonse can perform each operation as many times as he wants.

Determine the size of the largest rice ball in the row after performing 0 or more operations.

Input Specification
The first line will contain the integer, N.

The next line will contain N space separated integers representing the sizes of the riceballs, in order from left to right. Each integer is at least 1 and at most 1000000.

Output the size of the largest riceball Alphonse can form.

Sample Input 1
7
47 12 12 3 9 9 3

Sample Output 1
48

Sample Input 2
4
1 2 3 1

Sample Output 2
3
*/