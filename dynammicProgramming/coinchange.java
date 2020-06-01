package dynammicProgramming;

import java.util.Scanner;

public class coinchange {
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        int c = s.nextInt();
        int[] nums = new int[c + 1];
        int n = s.nextInt();
        int[] coins = new int[n];

        for (int i = 0; i < n; i++) {
            coins[i] = s.nextInt();
        }

        for (int i = 1; i <= c; i++) {
            int low = 10000;
            for (int j : coins) {
                int diff = i - j;
                if (diff >= 0) {
                    low = Math.min(nums[diff] + 1, low);
                }
            }
            nums[i] = low;
        }
        System.out.println(nums[c]);
    }
}

/* 
Given a value of x cents, and an infinite supply of coins of n denominations, followed by their denominations, find the least amount of coins required to make change for x.

Input
Line 1: x, an integer between 1 and 10000

Line 2: n, the number of different denominations

Line 3..3+n: the denominations of the coins

Output
An integer, on a single line - the least coins required to make change for x.

Example
Input:
24
4
12
13
5
6

Output:
2
*/