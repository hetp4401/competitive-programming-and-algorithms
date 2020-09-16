
import java.util.Scanner;

public class ccc02s4{
	
	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		
		while(true) {
			int n = s.nextInt();
			
			if(n == 0) {
				break;
			}
			
			int[] nums = new int [n];
			for(int i = 0; i < n; i++) {
				nums[i] = s.nextInt();
			}
			
			int[][] dp = new int [n][n];
			for(int i = 0; i < n; i++) {
				for(int j = 1; j < n-i-1; j++) {
					int l = j;
					int r = j+i;
					for(int k = l; k <= r; k++) {
						int ls = k != l ? dp[l][k-1] : 0;
						int rs = k != r ? dp[k+1][r] : 0;
						dp[l][r] = Math.max(dp[l][r], nums[k]+nums[l-1]+nums[r+1]+ls+rs);
					}
				}
			}
			
			System.out.println(dp[1][n-2]);
		}
	}
}


/* 
You are playing a game of Pick It. You are given a list of positive integers, and you are allowed to 
select any number other than the first or last number in this list. When you pick a number, that number 
is removed from the board, and your score increases by the sum of the number that you picked and the sum
 of the neighbouring numbers.

For example, if the list contained 1,2,3,4,5 and you picked 3, your score would be 2+3+4=9. On the next 
turn, your list would be 1,2,4,5, and if you picked 4 next, your score would be 9+2+4+5=20, leaving you 
with the list 1,2,5. The game concludes when there are only two numbers remaining.

Given a list of numbers, what is the maximum score that you can obtain?

Input Specification
The input will consist of a number of test cases (at most 200 test cases). A test case is of the form 
n,k1,k2...kn where n (n ≤ 200) is the number of numbers in the list, and each integer ki satisfies 
1 ≤ ki ≤ 100). In all test cases n≥3, except in the case where n=0, which indicates the end of input.

Output Specification
For each test case, output the maximum score attainable.

Sample Input
5 
1 2 3 4 5
5 
2 1 5 3 4
6 
30 20 40 50 70 60
0

Sample Output
30
31
570
*/