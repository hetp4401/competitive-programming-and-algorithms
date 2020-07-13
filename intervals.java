import java.util.Arrays;
import java.util.Scanner;

public class intervals {
	
	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		
		int n = s.nextInt();
		int q = s.nextInt();
		
		int[] start = new int[n];
		int[] end = new int[n];
		
		
		for(int i = 0; i < n; i++) {
			start[i] = s.nextInt();
			end[i] = s.nextInt();
		}
		
		Arrays.sort(start);
		Arrays.sort(end);
		
		
		int[] exact = new int[n*2];
		int[] greater = new int[n*2];
		int[] keys = new int[n*2];
		
		int c = 0;
		int a = 0;
		int b = 0;
		while(a != n || b != n) {
			if(b == n || a < n && start[a] <= end[b]) {
				exact[a+b] = c+1;
				greater[a+b] = c+1;
				keys[a+b] = start[a];
				c++;
				a++;
			}else {
				exact[a+b] = end[b] == keys[a+b-1] ? exact[a+b-1] : c;
				greater[a+b] = c-1;
				keys[a+b] = end[b];
				c--;
				b++;
			}
		}
		
		for(int i = n*2-2; i >= 0; i--) if(keys[i] == keys[i+1]) exact[i] = exact[i+1]; 
		for(int i = n*2-2; i >= 0; i--) if(keys[i] == keys[i+1]) greater[i] = greater[i+1]; 
		
		for(int i = 0; i < q; i++) {
			int qry = s.nextInt();
			if(qry < start[0]) {
				System.out.println(0);
			}else {
				int k = Arrays.binarySearch(keys, qry);
				if(k < 0) {
					System.out.println(greater[(k*-1)-2]);
				}else {
					System.out.println(exact[k]);
				}
			}
		}
	}
}




/* 
closed interval [a..b] contains the integers a, a+1, a+2, ... b-2, b-1, b. 
You are given N closed intervals [ai..bi] (0 ≤ N ≤ 100000), with ai and bi 
in the range [-109..109], and Q (0 ≤ Q ≤ 100000) queries of the form "how 
many intervals contain this integer x?" (where -2 × 109 ≤ x ≤ 2 × 109). 
Determine the answer to each query.

Input Format
Line 1: Two space-separated integers, N and Q
Next N lines: Two space-separated integers each, ai and bi, denoting one closed interval.
Next Q lines: One integer each, denoting a single query.

Output Format
Print the answer to each query on its own line.

Sample Input
3 10
0 3
2 4
3 7
-1
0
1
2
3
4
5
6
7
8


Sample Output
0
1
1
2
3
2
1
1
1
0

*/
