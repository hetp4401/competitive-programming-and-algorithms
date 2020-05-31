package recursion;

import java.util.Scanner;

class numIslands {
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        int h = s.nextInt();
        int w = s.nextInt();

        int[][] grid = new int[h][w];
        for (int i = 0; i < h; i++) for (int j = 0; j < w; j++)  grid[i][j] = s.nextInt();
        
        int count = 0;
        for (int y = 0; y < grid.length; y++) {
            for (int x = 0; x < grid[0].length; x++) {
                if (grid[y][x] == 1) {
                    remove(y, x, grid);
                    count++;
                }
            }
        }
        System.out.println(count);
    }

    public static void remove(int y, int x, int[][] grid) {
        if (y >= 0 && y < grid.length && x >= 0 && x < grid[0].length && grid[y][x] == 1) {
            grid[y][x] = 0;
            remove(y - 1, x, grid);
            remove(y + 1, x, grid);
            remove(y, x - 1, grid);
            remove(y, x + 1, grid);
        }
    }
}

/*

Sample Input 1
4 5
1 1 1 1 0
1 1 0 1 0
1 1 0 0 0
0 0 0 0 0

Sample Output 1
1

Sample Input 2
4 5
1 1 0 0 0
1 1 0 0 0
0 0 1 0 0
0 0 0 1 1

Sample Output 2
3

*/