package dynammicProgramming;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class jumpscotch {
	
	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		
		int n = s.nextInt();
		int d = s.nextInt();
		
		int[] nums = new int[n]; for(int i = 0; i < n; i++) nums[i] = s.nextInt();
		
		int[] dp = new int[n]; dp[0] = nums[0];
        Deque<Integer> deque = new LinkedList<Integer>();  deque.addFirst(0);
        
        for(int i = 1; i < n; i++) {
        	dp[i] = dp[deque.peekFirst()] + nums[i];
        	if(deque.peekFirst() <= i - d) deque.removeFirst();
        	while(!deque.isEmpty() && dp[i] < dp[deque.getLast()]) deque.removeLast();
        	deque.addLast(i);
        }
        System.out.println(dp[n-1]);
	}
}   









/* 

Hopscotch is a simple game which can be played with a group or family or individually. Diana has been playing the game for years and is easily the best Hopsscotch player on the playground. Her friends have decided to challenge her title by inventing a complicated version of Hopscotch called "Jumpscotch."

In Jumpscotch, a single row of squares is drawn along the ground and a positive integer is drawn inside each square. Starting on the first square, Diana must jump from square to square and finish on the last square. Afterwards, her 'score' is the sum of all numbers which she has touched. The objective of Jumpscotch is to get a lower score than your opponent.

Diana knows that she is only strong enough to hop a certain distance (d). She is also smart enough to know that with this limitation, the best 'path' is not always obvious. Diana wants your help in determining the best path, given each square's value and her maximum hopping distance.

Input
On the first line, the integers n (1 ≤ n ≤ 1,000,000) and d (1 ≤ d ≤ 10).
There will be one test case where Diana has super human strength and d = 5,000 while n = 1,000,000.

The next n lines that follow have positive integers ≤ 1000, representing the number drawn inside each square. These lines are listed, in order, from start to finish.

Output
On a single line, output the smallest possible score that Diana can obtain.

Sample Input
12 3
1
4
2
6
5
1
1
8
7
3
1
2

Sample Output
10

*/
