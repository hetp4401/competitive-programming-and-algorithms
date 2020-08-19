package dynammicProgramming;

import java.util.Scanner;

public class bowlingfornumbers2 {

    public static void main(String[] args) {
 
        Scanner s = new Scanner(System.in);

        int n = s.nextInt();
        int[] nums = new int[n];

        for (int i = 0; i < n; i++)
            nums[i] = s.nextInt();

        int sum = 0;
        for (int i : nums)
            sum += i;

        int[][] dp = new int[nums.length + 1][(sum / 2) + 1];
        dp[0][0] = 1;

        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j] = j - nums[i - 1] >= 0 ? Math.max(dp[i - 1][j - nums[i - 1]], dp[i - 1][j]) : dp[i - 1][j];
            }
        }

        int i = dp[0].length - 1;
        for (; i > 0; i--)
            if (dp[nums.length][i] == 1)
                break;

        System.out.println(sum - i - i);
    }
}






/* 

Korra is trying to restore balance to the world. But before that, she must restore balance in some numbers. Given N (1 ≤ N ≤ 10) numbers, Korra wants to split them into two (possibly empty) groups, such that their sums are as close as possible.

Output the minimum difference between the two groups of numbers.

Input Format
The first line will contain the integer N, representing the number of numbers Korra has.
The second line will contain N positive integers (each no greater than 1000), the numbers that Korra is trying to split.

Output Format
Output a single line containing a single integer – the minimum difference of the sum of the two groups of numbers.

Sample Input 1
5
8 12 16 100 20

Sample Ouput 1
44

Sample Input 2
9
1 8 5 9 7 2 3 4 6 

Sample Output 2
1

*/