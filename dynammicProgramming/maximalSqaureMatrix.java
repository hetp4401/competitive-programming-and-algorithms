
package dynammicProgramming;

import java.util.Scanner;

public class maximalSqaureMatrix {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        int n = s.nextInt();

        int[][] dp = new int[n + 1][n + 1];

        int m = 0;
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (s.nextInt() == 1) {
                    dp[i][j] = 1 + Math.min(Math.min(dp[i][j - 1], dp[i - 1][j - 1]), dp[i - 1][j]);
                    m = Math.max(dp[i][j], m);
                }
            }
        }
        System.out.println(m * m);
    }
}

/*
 * Sample Input 1 6 1 0 1 0 1 0 0 1 0 1 0 1 1 0 1 0 1 0 0 1 0 1 0 1 1 0 1 0 1 0
 * 0 1 0 1 0 1
 * 
 * Sample Output 1 1
 * 
 * Sample Input 2 6 0 1 1 1 1 0 1 0 1 1 1 1 0 1 1 1 1 1 1 1 0 1 1 1 1 1 1 1 0 1
 * 1 1 0 1 1 1
 * 
 * Sample Output 2 9
 * 
 */