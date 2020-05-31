package dynammicProgramming;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

public class dominoes {
	
	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		
		int n = s.nextInt();
		
		int[] arr = new int[n];
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(int i = 0; i < n; i++) { 
			int k = s.nextInt();
			int v = s.nextInt();
			arr[i] = k;
			map.put(k, v);	
		}
		
		Arrays.sort(arr);
		
		int[][] d = new int[n][2];
		for(int i = 0; i < n; i++) {
			d[i][0] = arr[i];
			d[i][1] = map.get(arr[i]);
		}
		
		Stack<Integer> sl = new Stack<Integer>();
		int[] left = new int[d.length]; Arrays.fill(left, 1);
		for(int i = 0; i < d.length; i++) {
			while(!sl.empty() && d[sl.peek()][0] >= d[i][0]-d[i][1]) sl.pop();
			if(!sl.empty()) left[i] = sl.peek() + 2;
			sl.add(i);
		}
		
		Stack<Integer> sr = new Stack<Integer>();
		int[] right = new int[d.length]; Arrays.fill(right, d.length);
		for(int i = d.length-1; i >= 0; i--) {
			while(!sr.empty() && d[sr.peek()][0] <= d[i][0]+d[i][1]) sr.pop();
			if(!sr.empty()) right[i] = sr.peek();
			sr.add(i);
		}
		
		int[] bit = new int[n+2]; Arrays.fill(bit, 100000); bit[n+1] = 0;
		int[] dp = new int[n+1]; Arrays.fill(dp, 100000); dp[0] = 0;
		
		for(int i = 1; i < n+1; i++) {
			int r = right[i-1];
			int l = left[i-1];
			int m = 100000;
			
			dp[r] = Math.min(dp[i-1]+1, dp[r]);
			for(int j = n+2-l; j > n+1-i; j -= j&-(j)) m = Math.min(bit[j], m);
			dp[i] = Math.min(m+1, dp[i]);
			for(int j = n+1-i; j < n+2; j += j&-(j)) bit[j] = Math.min(dp[i], bit[j]);			
		}
		
		System.out.println(dp[n]);
	}
}





/*

Farmer John's son, Johnny is playing with some dominoes one afternoon.
His dominoes come in a variety of heights and colors.

Just like any other child, he likes to put them in a row and knock them over.
He wants to know something: how many pushes does it take to knock down all the dominoes?
Johnny is lazy, so he wants to minimize the number of pushes he takes.
A domino, once knocked over, will knock over any domino that it touches on the way down.

For the sake of simplicity, imagine the floor as a one-dimensional line, where 1 is the leftmost point. Dominoes will not slip along the floor once toppled. Also, dominoes do have some width: a domino of length 1 at position 1 can knock over a domino at position 2.

For the mathematically minded:
A domino at position x with height h, once pushed to the right, will knock all dominoes at positions x+1, x+2, ..., x+h rightward as well.
Conversely, the same domino pushed to the left will knock all dominoes at positions x-1, x-2, ..., x-h leftward.
Input
The input starts with a single integer N ≤ 100,000, the number of dominoes, followed by N pairs of integers.
Each pair of integers represents the location and height of a domino.
(1 ≤ location ≤ 1,000,000,000, 1 ≤ height ≤ 1,000,000,000)
No two dominoes will be in the same location.

NOTE: 60% of test data has N ≤ 5000.
Output
One line, with the number of pushes required.

Sample Input
6
1 1
2 2
3 1
5 1
6 1
8 3

Sample Output
2

Push the domino at location 1 rightward, the domino at location 8 leftward.
Diagram
              |
  |           |
| | |   | |   |
1 2 3 4 5 6 7 8

Pushing 1 causes 2 and 3 to fall, while pushing 8 causes 6 to fall and gently makes 5 tip over as well.


*/