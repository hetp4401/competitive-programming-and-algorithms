package graphTheory;

import java.util.ArrayList;
import java.util.Scanner;

public class whoIsTaller {

    static int n;
    static ArrayList<Integer>[] arr;

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        n = s.nextInt();
        int c = s.nextInt();

        arr = new ArrayList[n + 1];
        for (int i = 0; i < c; i++) {
            int a = s.nextInt();
            int b = s.nextInt();
            if (arr[a] == null)
                arr[a] = new ArrayList<Integer>();
            arr[a].add(b);
        }

        int l = s.nextInt();
        int r = s.nextInt();

        if (bfs(l, r)) {
            System.out.println("yes");
        } else if (bfs(r, l)) {
            System.out.println("no");
        } else {
            System.out.println("unknown");
        }
    }

    public static boolean bfs(int a, int b) {

        boolean[] visited = new boolean[n + 1];
        ArrayList<Integer> current = new ArrayList<Integer>();
        current.add(a);

        while (current.size() > 0) {
            ArrayList<Integer> temp = new ArrayList<Integer>();
            for (Integer node : current) {
                if (node == b)
                    return true;
                if (visited[node])
                    continue;
                visited[node] = true;
                if (arr[node] == null)
                    continue;
                for (Integer next : arr[node]) {
                    temp.add(next);
                }
            }
            current = temp;
        }
        return false;
    }
}


/* 

Problem S4: Who is taller?
You have a few minutes before your class starts, and you decide to compare the heights of your classmates. You dont have an accurate measuring device, so you just compare relative heights between two people: you stand two people back-to-back, and determine which one of the two is taller. Conveniently, none of your classmates are the same height, and you always compare correctly (i.e., you never make a mistake in your comparisons).

After you have done all of your comparisons, you would like to determine who the tallest person is between two particular classmates.

Input
The first line contains two integers N and M separated by one space. N, the number of people in the class, is an integer with 1 ≤ N ≤ 1000000. M, the number of comparisons that have already been done, is an integer with 1 ≤ M ≤ 10000000. Each of the next M lines contains two distinct integers x and y (1 ≤ x, y ≤ N) separated by a space, indicating that person number x was determined to be taller than person number y. Finally, the last line contains two distinct integers p and q (1 ≤ p, q ≤ N) separated by one space: your goal is to determine, if possible, whether person p is taller than person q. Note that it may be the case that neither p nor q occur in the input concerning measurements between classmates, and each measurement between any two particular people will be recorded exactly once.

Output
The output is one line, containing one of three possible strings:

yes (if p is taller than q),
no (if q is taller than p),
unknown (if there is not enough information to determine the relative heights of p and q).

Sample Input 1
10 3
8 4
3 8
4 2
3 2

Sample Output 1
yes

Sample Input 2
10 3
3 8
2 8
3 4
3 2

Sample Output 2
unknown

*/