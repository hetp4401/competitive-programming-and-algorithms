
import java.util.Scanner;

public class ccc02s4 {
	
	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		
		int n = s.nextInt();
		int k = s.nextInt();
		
		int[][] tri = new int[n][n];
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < i + 1; j++) {
				tri[i][j] = s.nextInt();
			}
		}
		
		for(int r = 1; r < k; r++) {
			for(int i = 0; i < n-r; i++) {
				for(int j = 0; j < i + 1; j++) {
					int n1 = tri[i][j];					
					int n2 = tri[i+1][j];
					int n3 = tri[i+1][j+1];
					tri[i][j] = Math.max(Math.max(n1, n2), n3);
				}
			}
		}
		
		long t = 0;
		for(int i = 0; i < n-k+1; i++) {
			for(int j = 0; j < i+1; j++) {
				t += tri[i][j];
			}
		}
		
		System.out.println(t);
    }
}

/* 

- This is a DP solution that can be further optimized by using summation techniques

In a parallel universe, the most important data structure in computer science is the triangle. A triangle of size M 
consists of M rows, with the ith row containing i elements. Furthermore, these rows must be arranged to form the shape 
of an equilateral triangle. That is, each row is centred around a vertical line of symmetry through the middle of the 
triangle. For example, the diagram below shows a triangle of size 4:

                                                3
                                                1 2
                                                4 2 1
                                                6 1 4 2

A triangle contains sub-triangles. For example, the triangle above contains ten sub-triangles of size 1, six 
sub-triangles of size 2 (two of which are the triangle containing (3,1,2) and the triangle containing (4,6,1)), three 
sub-triangles of size 3 (one of which contains (2,2,1,1,4,2)). Note that every triangle is a sub-triangle of itself.

You are given a triangle of size N and must find the sum of the maximum elements of every sub-triangle of size K.

Sample Input
4 2
3
1 2
4 2 1
6 1 4 2

Sample Output
23
*/