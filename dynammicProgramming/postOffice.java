package dynammicProgramming;

import java.util.Scanner;

public class postOffice {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int n = s.nextInt();
        int p = s.nextInt();

        int[] po = new int[n]; 
        for (int i = 0; i < n; i++) po[i] = s.nextInt();

        int[][] best = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int r = i + 1; r < n; r++) best[i][r] = best[i][r - 1] + Math.abs(po[i] - po[r]);
            for (int l = i - 1; l >= 0; l--) best[i][l] = best[i][l + 1] + Math.abs(po[i] - po[l]);
        }

        int[][] best2 = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                best2[i][j] = Integer.MAX_VALUE;
                for (int k = 0; k < n; k++) {
                    best2[i][j] = Math.min(best[k][i] + best[k][j], best2[i][j]);
                }
            }
        }

        int[][] dp = new int[p][n]; dp[0] = best2[0];
        for (int i = 1; i < p; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = best2[0][j];
                for (int k = j; k > 0; k--) {
                    dp[i][j] = Math.min(dp[i-1][k-1] + best2[k][j], dp[i][j]);
                }
            }
        }

        System.out.println(dp[p - 1][n - 1]);
    }
}



/* 
There is a straight highway with villages alongside the highway. The highway is represented as an integer axis, and the position of each village is identified with a single integer coordinate. There are no two villages in the same position. The distance between two positions is the absolute value of the difference of their integer coordinates.

Post offices will be built in some, but not necessarily all of the villages. A village and the post office in it have the same position. For building the post offices, their positions should be chosen so that the total sum of all distances between each village and its nearest post office is minimum.

You are to write a program which, given the positions of the villages and the number of post offices, computes the least possible sum of all distances between each village and its nearest post office, and the respective desired positions of the post offices.

Sample Input
10 5
1 2 3 6 7 9 11 22 44 50

Sample Output
9
*/