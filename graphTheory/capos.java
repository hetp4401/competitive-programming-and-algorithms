
package graphTheory;

import java.util.ArrayList;
import java.util.Scanner;

public class capos{
    static int n;
	static int m;
	static int[] grudges;
	static int ans = 15;
	static ArrayList<Integer> track = new ArrayList<Integer>();
	static ArrayList<Integer> groups = new ArrayList<Integer>();
	
	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		
		n = s.nextInt();
		m = s.nextInt();
		
		grudges = new int[n+1];
		
		for(int i = 0; i < m; i++) {
			int a = s.nextInt();
			int b = s.nextInt();
			grudges[a] |= 1 << (b-1);
			grudges[b] |= 1 << (a-1);
		}

		groups.add(0);
		for(int i = 1; i < n+1; i++) {
			int size = groups.size();
			for(int j = 0; j < size; j++) {
				if((grudges[i] & groups.get(j)) == 0) {
					groups.add(groups.get(j) | (1 << (i-1)));
				}
			}
		}
		
		dfs(1, 0, 0, new ArrayList<Integer>());
		
		System.out.println(ans);
		for(int n : track) {
			for(int i = 1; n != 0; i++, n >>= 1) {
				if((n & 1) == 1) {
					System.out.print(i + " ");
				}
			}
			System.out.println();
		};
		
    }
	public static void dfs(int c, int b, int t, ArrayList<Integer> path) {
		if (b == (1 << n)-1) {
			ans = Math.min(t, ans);
			track = (ArrayList<Integer>) path.clone();
		}
		for(int i = c; i < groups.size(); i++) {
			if((b & groups.get(i)) == 0) {
				path.add(groups.get(i));
				dfs(i+1, b | groups.get(i), t+1, path);
				path.remove(path.size()-1);
			}
		}
	}
}



/* 
There are N soldiers that are out of control, and M two-way grudges that you know exist 
between pairs of soldiers. Since the capos you're hiring are new, you don't know if they 
can be trusted. The more capos you hire, the more likely it is that one of them will rat. 
You must help the Don determine the minimum number of capos required to lead the soldiers, 
such that no grudges exist amongst the same crew. Additionally, you must find one such way
of grouping the soldiers.

Input
The first line of input will contain two integers: N (1 ≤ N ≤ 15), the number of soldiers, and M (1 ≤ M ≤ N*(N-1)/2), the number of grudges.
The next M lines will each contain two integers a and b (1 ≤ a, b ≤ N), denoting a grudge between soldiers a and b.

Output
The first line of output should contain an integer, the minimum number of crews required to group the soldiers.
Each remaining line represents a separate crew. For every crew, you must output the soldiers that it contains. You may output the groups/soldiers in any order.

Sample Input
5 7
1 2
1 5
2 4
2 5
3 4
3 5
4 5

Sample Output
3
1 4
2 3
5

Explanation
Soldiers 1 and 4 are led by a capo, soldiers 2 and 3 are led by a capo, and soldier 5 is led by another capo. There exists no grudges within any of the three groups.

*/