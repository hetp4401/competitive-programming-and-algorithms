package dynammicProgramming;

import java.util.Scanner;

public class triangle {

    public static void main(String[] args) throws Exception {

        Scanner s = new Scanner(System.in);

        int n = s.nextInt();
        int[][] tri = new int[n][n];

        for (int i = 0; i < n; i++)
            for (int j = 0; j < i + 1; j++)
                tri[i][j] = Integer.parseInt(s.next());

        for (int i = n - 2; i >= 0; i--)
            for (int j = 0; j < tri[i].length - 1; j++)
                tri[i][j] += Math.max(tri[i + 1][j], tri[i + 1][j + 1]);

        System.out.println(tri[0][0]);
    }
}

/*
The Triangle
            7
          3   8
        8   1   0
      2   7   4   4
    4   5   2   6   5   (Figure 1)
Figure 1 shows a number triangle. Write a program that calculates the highest sum of numbers passed on a route that starts at the top and ends somewhere on the base.

Each step can go either diagonally down to the left or diagonally down to the right.
The number of rows in the triangle is > 1 but ≤ 100.
The numbers in the triangle, all integers, are between 0 and 99 inclusive.
Input Format
The first line of input contains the integer n, the number of lines in the triangle. The remaining n lines will contain the values of the triangle.

Output Format
The output should contain one integer, the highest possible sum.

Sample Input
5
7
3 8
8 1 0 
2 7 4 4
4 5 2 6 5

Sample Output
30

*/