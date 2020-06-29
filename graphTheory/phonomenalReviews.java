package graphTheory;

import java.util.Scanner;

public class phonomenalReviews {
	static boolean[] p;
	static boolean[] v;
	static boolean[][] g;
	static int[] dist;

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);

		int n = s.nextInt();
		int m = s.nextInt();

		p = new boolean[n];
		g = new boolean[n][n];

		for (int i = 0; i < m; i++) {
			p[s.nextInt()] = true;
		}

		for (int i = 0; i < n - 1; i++) {
			int a = s.nextInt();
			int b = s.nextInt();
			g[a][b] = true;
			g[b][a] = true;
		}

		int start = 0;
		for (; start < n; start++) {
			if (p[start]) {
				break;
			}
		}

		v = new boolean[n];
		int total = dfs(start) - 1;

		v = new boolean[n];
		dist = new int[n];
		dfs2(start, 0);

		for (int i = 0; i < n; i++) {
			start = dist[i] > dist[start] ? i : start;
		}

		v = new boolean[n];
		dist = new int[n];
		dfs2(start, 0);

		int f = 0;
		for (int i = 0; i < n; i++) {
			f = Math.max(dist[i], f);
		}

		System.out.println((total * 2) - f);
	}

	public static int dfs(int c) {
		int t = 0;
		v[c] = true;
		for (int i = 0; i < g.length; i++) {
			if (g[c][i] && !v[i]) {
				t += dfs(i);
			}
		}
		return t + (p[c] || t > 0 ? 1 : 0);
	}

	public static void dfs2(int c, int d) {
		if (p[c])
			dist[c] = d;
		v[c] = true;
		for (int i = 0; i < g.length; i++) {
			if (g[c][i] && !v[i]) {
				dfs2(i, d + 1);
			}
		}

	}
}



/* 
Jo is a blogger, specializing in the critique of restaurants. Today, she wants to visit all the Vietnamese Pho restaurants in the Waterloo area, in order to determine which one is the best.

There are N restaurants in the city of Waterloo, numbered 0 to N−1. However, only M of them are Pho restaurants. Jo can choose to start at any restaurant. There are N−1 roads in Waterloo, each road connecting exactly two restaurants. It is possible to reach every restaurant from any restaurant using these roads. It takes Jo exactly 1 minute to travel along any road.

In computer science, a road network with this structure is called a tree. Here are three examples of trees:

One property that is true for all trees is that there is exactly one path that does not repeat any roads between any two points in the tree.

What is the minimal amount of time that Jo needs to spend on travelling on roads to visit to all of the Pho restaurants?

Input Format
The first line of input contains 2 integers, N and M (2 ≤ M ≤ N ≤ 100 000).
The second line of input contains M distinct integers indicating the restaurants which are Pho restaurants.
The next N−1 lines contain 2 integers each. The i-th line contains ai and bi (0 ≤ ai, bi ≤ N−1), representing a path between the two restaurants numbered ai and bi.

Output Format
Your program should output one line, containing one integer – the minimum amount of time Jo needs to spend travelling on roads in order to visit all Pho restaurants, in minutes.

Sample Input 1
8 2
5 2
0 1
0 2
2 3
4 3
6 1
1 5
7 3
Sample Output 1
3
Explanation 1
The path between 5 and 2 goes through 5→1→0→2, which uses 3 roads.

Sample Input 2
8 5
0 6 4 3 7
0 1
0 2
2 3
4 3
6 1
1 5
7 3
Sample Output 2
7
Explanation 2
If Jo begins at restaurant 6, she will only need to use 7 roads. One possible path that she can take is: 6→1→0→2→3→7→3→4. Notice that she doesn't need to visit restaurant 5, since it is not a Pho restaurant. A diagram of the road network is shown below:
*/


