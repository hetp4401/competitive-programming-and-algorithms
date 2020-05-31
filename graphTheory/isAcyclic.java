package graphTheory;

import java.util.HashMap;
import java.util.Scanner;

public class isAcyclic {
    static Integer[][] graph;
    static HashMap<Integer, Boolean> hm = new HashMap<Integer, Boolean>();

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        int n = s.nextInt();
        graph = new Integer[n][n];

        for (int i = 0; i < n; i++) {
            Integer[] nodes = new Integer[n];
            int index = 0;
            for (int j = 0; j < n; j++) {
                if (s.nextInt() == 1) {
                    nodes[index] = j;
                    index++;
                }
            }
            graph[i] = nodes;
        }

        for (int i = 0; i < n; i++) {
            loop(i);
            System.out.println();
            hm.clear();
        }

        System.out.println("YES");
    }

    public static void loop(int index) {
        if (hm.containsKey(index) == false) {
            hm.put(index, false);
            for (int i = 0; i < graph[index].length && graph[index][i] != null; i++) {
                loop(graph[index][i]);
                graph[index][i] = null;
            }

        } else {
            System.out.println("NO");
            System.exit(0);
        }

        hm.remove(index);
    }
}

/*

Given a directed graph, output YES if it is acyclic, and NO otherwise.

Input
As usual.
N ≤ 1000.

Output
YES or NO.

Sample Input
3
0 1 0 
0 0 1
1 0 0

Sample Output
NO

Sample Input 2
3
0 1 0
0 0 1
0 0 0

Sample Output 2
YES

*/