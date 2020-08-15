package graphTheory;

import java.util.Scanner;

public class networkFlow {

    static int l;
    static int r;
    static int core;
    static int[] lakes;
    static int[][] graph;
    static boolean[] visited;

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        l = s.nextInt();
        r = s.nextInt();

        lakes = new int[l];
        for (int i = 0; i < l; i++) {
            int n = s.nextInt();
            lakes[i] = n;
            if (n == 0) {
                core = i;
                lakes[core] = 10000;
            }
        }

        graph = new int[l][l];
        for (int i = 0; i < r; i++) {
            int a = s.nextInt() - 1;
            int b = s.nextInt() - 1;
            graph[a][b] = lakes[b];
        }

        int start = lakes[0];
        int flow = 0;
        while (true) {
            visited = new boolean[l];
            int f = dfs(0, start);
            if (f == 0) {
                break;
            }
            flow += f;
            start -= f;
        }
        System.out.println(flow);
    }

    public static int dfs(int current, int flow) {
        if (current == core) {
            return flow;
        }
        visited[current] = true;
        for (int i = 0; i < l; i++) {
            if (!visited[i] && graph[current][i] > 0) {
                int f = dfs(i, Math.min(graph[current][i], flow));
                if (f > 0) {
                    graph[current][i] -= f;
                    graph[i][current] += f;
                    return f;
                }
            }
        }
        return 0;
    }
}



/* 
In his last escapade, Digger successfully picked up the underground treasure and continued to dig down with his souped-up pneumatic drill, hoping to come up in China. To his surprise, however, he instead stumbled upon the planet core. He quickly cooks up a new plan - to rocket up to the surface via a volcano.

He observes N (1 ≤ N ≤ 10000) rivers of lava, as well as M (1 ≤ M ≤ 1000) lakes, which Digger has numbered 1 to M. Each river flows in one direction only, from one lake to another, and no two rivers run between the same pair of lakes in the same direction. Each lake has a certain flow rate - this is how many gallons of lava in total can potentially flow out of it per second (geologists claim they know the factors that affect flow rate, but really they have no idea). Exactly one lake has a flow rate of 0 - this means that this lake is volcanic and erupts from time to time. There will be no rivers flowing out of this lake.

The lake that Digger counts as Lake 1 is fed by the core itself, which is where all lava in the river system comes from. No rivers flow into this lake, and there will be at least one system of rivers that lead from it to the volcanic lake.

All rivers and lakes are originally empty, but when an eruption occurs, lava starts to gush out of the core and along the rivers so that the rate of lava flowing into the volcanic lake is maximized. Digger plans to hop into the volcanic lake (using the inflatable heat-proof raft he keeps in his pocket) and wait for an eruption to occur, but he wants to know in advance the rate of lava that will be flowing into the lake.

Input
Line 1:	M and N — respectively, the number of lakes and the number of rivers.
Lines 2..M+1:	F (0 ≤ F ≤ 10000) — the i-th line describes the (i-1)-th lake, where F is the flow rate (if F = 0, this lake is volcanic).
Lines N+2:	A and B (1 ≤ A, B ≤ M) — the i-th line describes the (i-M-1)-th river, which flows from lake A to lake B.
Output
Output the maximum rate at which lava can flow into the volcanic lake (in gallons per second).

Sample Input
6 8
10
3
4
6
2
0
1 2
1 3
2 3
2 4
3 4
3 5
4 6
5 6

Sample Output
7

*/