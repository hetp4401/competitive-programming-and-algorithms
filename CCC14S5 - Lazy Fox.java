package dynammicProgramming;

import java.util.Arrays;
import java.util.Scanner;

public class lazyFox {
	
	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		
		int n = s.nextInt();
		
        int[][] points = new int[n+1][2];
		points[0][0] = 0;
		points[0][1] = 0;
		
		for (int i = 1; i <= n; i++) {
			int x = s.nextInt();
			int y = s.nextInt();
			points[i][0] = x;
			points[i][1] = y;
		}
		
		int t = n*(n+1)/2;
		int[][] distances = new int[t][3];
		
		int idx = 0;
		for (int i = 0; i < n+1; i++) {
			int x1 = points[i][0];
			int y1 = points[i][1];
			for (int j = i+1; j < n+1; j++) {
				int x2 = points[j][0];
				int y2 = points[j][1];
				distances[idx][0] = (int) (Math.pow(Math.abs(x1-x2), 2) + Math.pow(Math.abs(y1-y2), 2));
				distances[idx][1] = i;
				distances[idx][2] = j;
				idx++;
			}
		}
		
		Arrays.sort(distances, (a, b) -> a[0]-b[0]);

		int[] dist = new int[n+1];
		int[] prev = new int[n+1];
		int[] best = new int[n+1];
		
		for (int[] x : distances) {
			int d = x[0];
			int a = x[1];
			int b = x[2];
			if (dist[a] != d) {
				dist[a] = d;
				prev[a] = best[a];
			}
			if (dist[b] != d) {
				dist[b] = d;
				prev[b] = best[b];
			}
			if (a == 0) {
				best[a] = Math.max(prev[b], best[a]);
			} else {
				best[a] = Math.max(prev[b]+1, best[a]);
				best[b] = Math.max(prev[a]+1, best[b]);
			}
		};
		
		System.out.println(best[0]+1);
    }
}


/* 
You have a pet Fox who loves treats. You have N neighbours at distinct locations (described as points 
on the Cartesian plane) which hand out treats to your pet Fox, and each neighbour has an unlimited number 
of treats to give out. The origin (which is where the Fox starts) will not be one of these N locations.

The Fox moves from location to location to gather exactly one treat from each location on each visit. 
He can revisit any previous location, but cannot visit the same location on two consecutive visits.

Your Fox is very lazy. The distance your Fox is willing to travel after each treat will strictly decrease. Specifically, the distance from the origin to his first treat location must be larger than the distance from his first treat location to his second treat location, which in turn is larger than the distance between his second treat location and his third treat location, and so on.

What is the largest number of treats your Fox gathers?

Input
The first line contains the integer N (1 ≤ N ≤ 2000). The next N lines each contain Xi, followed by a space, 
followed by Yi, for i = 1..N (−10 000 ≤ Xi, Yi ≤ 10 000) representing the coordinates of the i-th location. 

Output
The output is one integer, the largest number of treats your Fox can gather.

Sample Input
5
5 8
4 10
3 1
3 2
3 3

Sample Output
6

Explanation
The Fox performs the visits in the following order (with the indicated distances):

(0, 0) to (4, 10) with distance √116;
(4, 10) to (3, 1) with distance √82;
(3, 1) to (5, 8) with distance √53;
(5, 8) to (3, 3) with distance √29;
(3, 3) to (3, 1) with distance 2;
(3, 1) to (3, 2) with distance 1.
*/