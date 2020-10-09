
import java.util.Scanner;

public class s1 {
	
	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		
		int n = s.nextInt();
		int k = s.nextInt();
		
		int[][] tri = new int[n][n];
		int[][] bit = new int[n+1][n+1];
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j <= i; j++) {
				tri[i][j] = s.nextInt();
			}
		}
		
		long sum = 0;
		for(int j = n-1; j >= 0; j--) {
			for(int i = n-1; i >= j; i--) {
				update(tri[i][j], i, j+n-1-i, bit, k);
				int y = i;
				int x = j+n-1-i;
				if(y+k-1 < n && x-k+1 >= 0) {
					sum += query(y+k-1, x, bit, k);
				}
			}
		}
		System.out.println(sum);
	}
	
	public static int query(int y, int x, int[][] bit, int k) {
		y++;
		x++;
		int t = 0;
		for(int i = y; i > y-k; i -= i & (-i)) {
			for(int j = x; j > x-k; j -= j & (-j)) {
				t = Math.max(t, bit[i][j]);
			}
		}
		return t;
	}
	
	public static void update(int val, int y, int x, int[][] bit, int k) {
		y++;
		x++;
		for(int i = y; i < Math.min(bit.length, y+k); i += i & (-i)) {
			for(int j = x; j < Math.min(bit.length, x+k); j += j & (-j)) {
				bit[i][j] = Math.max(val, bit[i][j]);
			}
		}
	}
}

/* 

- This is an efficient implementation that is optimized using a binary indexed tree

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