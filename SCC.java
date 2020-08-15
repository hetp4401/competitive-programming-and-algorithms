package graphTheory;

import java.util.Scanner;
import java.util.Stack;

public class stronglyConnectedComponents {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        int n = s.nextInt();
        int e = s.nextInt();

        boolean[][] g = new boolean[n][n];
        boolean[][] gt = new boolean[n][n];

        for (int i = 0; i < e; i++) {
            int a = s.nextInt();
            int b = s.nextInt();
            g[a][b] = true;
            gt[b][a] = true;
        }

        Stack<Integer> t = new Stack<Integer>();
        boolean[] v = new boolean[n];

        for (int c = 0; c < n; c++) {
            if (!v[c]) {
                dfs(c, v, t, g);
            }
        }

        v = new boolean[n];
        while (!t.empty()) {
            int c = t.pop();
            if (!v[c]) {
                Stack<Integer> scc = new Stack<Integer>();
                dfs(c, v, scc, gt);
                System.out.println(scc);
            }
        }
    }

    public static void dfs(int c, boolean[] v, Stack<Integer> t, boolean[][] g) {
        v[c] = true;
        for (int i = 0; i < g.length; i++) {
            if (g[c][i] == true && !v[i]) {
                dfs(i, v, t, g);
            }
        }
        t.add(c);
    }
}


/* 
Input
n - number of nodes
e - number of edges
next e lines will consist of 2 numbers a, b denoting an directed edge from a to b

Sample Input
8 14
0 1
1 2
1 4
1 5
2 3
2 6
3 2
3 7
4 0
4 5
5 6
6 5
7 3
7 6

Sample Output
[1, 4, 0]
[7, 3, 2]
[5, 6]

*/