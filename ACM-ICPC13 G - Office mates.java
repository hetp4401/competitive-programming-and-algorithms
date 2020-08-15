package graphTheory;

import java.util.ArrayList;
import java.util.Scanner;

public class officeMates {
    
    static int ans = 0;
	static boolean[] visited;
	static ArrayList<ArrayList<Integer>> graph;
	
	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		
		int n = s.nextInt();
		int m = s.nextInt();
		
		graph = new ArrayList<ArrayList<Integer>>();
		for(int i = 0; i < n; i++) graph.add(new ArrayList<Integer>());
		for(int i = 0; i < m; i++) {
			int a = s.nextInt()-1;
			int b = s.nextInt()-1;
			graph.get(a).add(b);
			graph.get(b).add(a);
		}
		
		visited = new boolean[n];
		for(int i = 0; i < n; i++) {
			if(!visited[i]) {
				dfs(i, i);
			}
		}
		
		System.out.println(n+ans-1);	
	}
	
	public static int dfs(int c, int o) {
		visited[c] = true;
		int t = 0;
		for(int i : graph.get(c)) {
			if(!visited[i]) {
				t += dfs(i, o);
			}
		}
		if(t >= 2) ans += t-1;
		else if(c == 0) ans += 1;
		return t >= 2 ? 0 : 1;
	}
}



/* 
Dr. Baws has an interesting problem. His N graduate students, while friendly with some select 
people, are generally not friendly with each other. No graduate student is willing to sit beside 
a person they aren't friends with.


The desks are up against the wall, in a single line, so it's possible that Dr. Baws will have to 
leave some desks empty. He does know which students are friends, and fortunately the list is not 
so long: it turns out that for any subset of K graduate students, there are at most K − 1 pairs 
of friends. Dr. Baws would like you to minimize the total number of desks required. What is this 
minimum number?

Input
Two integers on their own line: N ≤ 100000, the number of graduate students (who are indexed by 
the integers 1 through N), and M, the number of friendships among the students. Following this 
are M lines, each containing two integers i and j separated by a single space. Two integers i and 
j represent a mutual friendship between students i and j.


Output
For each test case output a single number: the minimum number of desks Dr. Baws requires to seat the students.

Sample Input
6 5
1 2
1 3
1 4
4 5
4 6

Sample Output
7

Explanation of Sample
2-1-3, 6-4-5
*/