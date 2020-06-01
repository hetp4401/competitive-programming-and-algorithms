package dynammicProgramming;

import java.util.Arrays;
import java.util.Scanner;

public class factorSolitaire {
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        int n = s.nextInt();
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[1] = 0;

        for (int i = 2; i < n + 1; i++) {
            for (int j = i - 1; j >= Math.ceil(i / 2); j--) {
                if (j % (i - j) == 0) {
                    dp[i] = Math.min(dp[j] + (j / (i - j)), dp[i]);
                }
            }
        }
        System.out.println(dp[n]);
    }
}

/*
In the game of Factor Solitaire, you start with the number 1, and try to change it to some given target number n by repeatedly using the following operation. In each step, if c is your current number, you split it into two positive factors a, b of your choice such that c = a * b. You then add a to your current number c to get your new current number. Doing this costs you b points. You continue doing this until your current number is n, and you try to achieve this at the cost of a minimum total number of points.

For example, here is one way to get to 15:

start with 1
change 1 to 1+1=2—cost so far is 1
change 2 to 2+1=3—cost so far is 1+2
change 3 to 3+3=6—cost so far is 1+2+1
change 6 to 6+6=12—cost so far is 1+2+1+1
change 12 to 12+3=15—cost so far is 1+2+1+1+4=9.
In fact, this is the minimum possible total cost to get 15. You want to compute the minimum total cost for other target end numbers.

Input
The input costs of a single integer N ≥ 1. In at least half of the cases N ≤ 5×104, in at least another quarter of the cases N ≤ 5×105, and in the remaining cases N ≤ 5×106.

Output
Compute the minimum cost that gets you to N.

Sample Input 1
15
Sample Output 1
9

Sample Input 2
2013
Sample Output 2
91

Explanation for Sample Case 2
For example, start with 1, then get to 2, 4, 5, 10, 15, 30, 60, 61, 122, 244, 305, 610, 671, 1342, and then 2013.
*/