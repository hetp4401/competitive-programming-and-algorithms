package dynammicProgramming;

import java.util.Scanner;

public class ccc07s5{

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
		
		int t = s.nextInt();
		for(int c = 0; c < t; c++) {
			int n = s.nextInt();
			int k = s.nextInt();
			int w = s.nextInt();
			
			int[] sums = new int[n+1];
			int[][] dp = new int[k+1][n+1];
			
			for(int i = 1; i < n+1; i++) sums[i] = sums[i-1] + s.nextInt();
			for(int i = 1; i < n+1; i++) dp[1][i] = Math.max(i-w >= 1 ? sums[i]-sums[i-w] : sums[i], dp[1][i-1]);
			for(int i = 2; i < k+1; i++) {
				for(int j = 1; j < n+1; j++) {
					dp[i][j] = j-w >= 1 ? Math.max(dp[i-1][j-w]+sums[j]-sums[j-w], dp[i][j-1]) : dp[i-1][j] ;
				}
			}
			System.out.println(dp[k][n]);
		}
    }

}


/* 
At the Canadian Carnival Competition (CCC), a popular game is Bowling for Numbers. A large 
number of bowling pins are lined up in a row. Each bowling pin has a number printed on it, 
which is the score obtained from knocking over that pin. The player is given a number of 
bowling balls; each bowling ball is wide enough to knock over a few consecutive and adjacent
pins.

For example, one possible sequence of pins is: 2 8 5 1 9 6 9 3 2

If Alice was given two balls, each able to knock over three adjacent pins, the maximum score 
lice could achieve would be 39, the sum of two throws: 2 + 8 + 5 = 15, and 9 + 6 + 9 = 24.

Bob has a strategy where he picks the shot that gives him the most score, then repeatedly 
picks the shot that gives him the most score from the remaining pins. This strategy doesn’t 
always yield the maximum score, but it is close. On the test data, such a strategy would get 
a score of 20%.

Input
first line of input is t, test cases, 1 ≤ t ≤ 10.
The first line of each test case contains three integers n k w. First is the integer n, 1 ≤ n ≤ 30000, indicating the number of 
bowling pins. The second integer, k, 1 ≤ k ≤ 500, giving the number of bowling balls 
available to each player. The third and final integer is w, 1 ≤ w ≤ n, the width of the 
bowling ball (the number of adjacent pins it can knock over). The next n lines of each test
 case each contain a single non-negative integer less than 10000, giving the score of the 
 pins, in order.

Output
For each test case, output the maximum achievable score by the player. This score is guaranteed to be less than one billion.

Sample Input
1
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

Sample Output
39
*/