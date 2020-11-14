import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class ccc02s4 {

	static HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		
	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		
		for(int c = 0; c < 5; c++) {
			int[][] mat = new int[4][4];
			for(int i = 0; i < 4; i++) {
				for(int j = 0; j < 4; j++) {
					mat[i][j] = s.nextInt();
				}
			}
			
			map.clear();
			dfs(mat);
			int m = 0;
			for(int i : map.values()) m = Math.max(m, i);
			System.out.println(m);
		}
		
	}
	
	public static void dfs(int[][] mat) {
		int hash = Arrays.deepHashCode(mat);
		if(!map.containsKey(hash)) {
			int max = 0;
			for(int[] i : mat) {
				for(int j : i) {
					max = Math.max(max, j);
				}
			}
			map.put(hash, max);
			dfs(up(mat));
			dfs(right(mat));
			dfs(left(mat));
			dfs(down(mat));
		}
	}

	public static int[][] up(int[][] mat) {
		int[][] copy = new int[4][4];
		for(int x = 0; x < 4; x++) {
			int i = 0;
			for(int y = 0; y < 4; y++) {
				if(mat[y][x] == 0) continue;
				if(copy[i][x] == 0) copy[i][x] = mat[y][x];
				else {
					if(copy[i][x] == mat[y][x]) copy[i][x] *= 2;
					else copy[i+1][x] = mat[y][x];
					i++;
				}
			}
		}
		return copy;
	}
	
	public static int[][] right(int[][] mat) {
		int[][] copy = new int[4][4];
		for(int y = 0; y < 4; y++) {
			int i = 3;
			for(int x = 3; x >= 0; x--) {
				if(mat[y][x] == 0) continue;
				if(copy[y][i] == 0) copy[y][i] = mat[y][x];
				else {
					if(copy[y][i] == mat[y][x]) copy[y][i] *= 2;
					else copy[y][i-1] = mat[y][x];
					i--;
				}
			}
		}
		return copy;
	}
	
	public static int[][] down(int[][] mat) {
		int[][] copy = new int[4][4];
		for(int x = 0; x < 4; x++) {
			int i = 3;
			for(int y = 3; y >= 0; y--) {
				if(mat[y][x] == 0) continue;
				if(copy[i][x] == 0) copy[i][x] = mat[y][x];
				else {
					if(copy[i][x] == mat[y][x]) copy[i][x] *= 2;
					else copy[i-1][x] = mat[y][x];
					i--;
				}
			}
		}
		return copy;
	}

	public static int[][] left(int[][] mat) {
		int[][] copy = new int[4][4];
		for(int y = 0; y < 4; y++) {
			int i = 0;
			for(int x = 0; x < 4; x++) {
				if(mat[y][x] == 0) continue;
				if(copy[y][i] == 0) copy[y][i] = mat[y][x];
				else {
					if(copy[y][i] == mat[y][x]) copy[y][i] *= 2;
					else copy[y][i+1] = mat[y][x];
					i++;
				}
			}
		}
		return copy;
	}
}

/* 

For five 2048 board, output the maximum value tile that can be aquired given that no additional tile
is added per move

Sample Input
2 64 4 32
8 16 8 4
4 32 4 0
2 2 0 0
0 0 0 2
0 0 0 2
0 0 0 0
0 0 0 2
2 4 8 2
0 2 0 8
0 0 0 0
0 0 0 0
4 32 8 0
2 64 4 2
8 4 2 0
2 0 0 0
256 256 0 0
256 256 0 0
256 256 0 0
256 256 0 0

Sample Output
128
4
16
128
2048

*/