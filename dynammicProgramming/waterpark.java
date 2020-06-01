package dynammicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class waterpark {

    public static void main(String[] args) throws Exception {

        Scanner s = new Scanner(System.in);
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();

        int n = s.nextInt();

        int[] vals = new int[n];
        int counter = 0;

        vals[0] = 1;

        int a = -1;
        int b = -1;

        a = s.nextInt();
        b = s.nextInt();

        while (a != 0) {

            if (map.containsKey(b)) {
                ArrayList<Integer> li = map.get(b);
                li.add(a);
                map.put(b, li);
            } else {
                ArrayList<Integer> li = new ArrayList<Integer>();
                li.add(a);
                map.put(b, li);
                counter++;
            }

            a = s.nextInt();
            b = s.nextInt();
        }

        int[] keys = new int[counter];

        int j = 0;
        for (int i : map.keySet()) {
            keys[j] = i;
            j++;
        }

        Arrays.sort(keys);

        for (int i = 0; i < counter; i++) {
            ArrayList<Integer> li = map.get(keys[i]);
            for (int x = 0; x < li.size(); x++) {
                vals[keys[i] - 1] = vals[keys[i] - 1] + vals[li.get(x) - 1];
            }
        }

        System.out.println(vals[n - 1]);
    }
}

/* 
The local waterpark has a great slide complex, with many paths crisscrossing down the hill. There is one start point and one end point, but at various points one can turn and take different paths. Walter and Wanda are wondering exactly how many different ways there are to go down the slide. Can you solve their problem?

More precisely, there are n marked points (including the start at 1 and the end at n) where the paths down the hill may split or merge. All paths move down the hill to higher numbered positions; some paths will actually cross over others without meeting but we don’t have to worry about that. We won’t worry about the collisions between sliders that can happen either. Our problem is simply to determine the number of different sequences of marked points we can follow down the hill.

For example, at one small waterpark, there are 4 points with direct slides from 1 to points 2 and 4; from 2 to 3 and 4; and from 3 to 4. There are 3 ways down the hill. You can check this by seeing that we can go (1,2,3,4), (1,2,4) or (1,4).

(Here is a hint: think about starting at the bottom of the slide.)

Input
Input begins with a single integer n (1 ≤ n ≤ 9999), on a line by itself, indicating the number of marked points. The next lines contain point pairs of the of the form x y, where 1 ≤ x < y ≤ n. For example, 1234 8765 indicates a direct slide from point 1234 to point 8765. The last line of input will be indicated by point pair 0 0.

Output
The output is an integer, which is the number of different paths from point 1 to point n. You can assume that the number of paths will be less than 230. It is possible that there is no path from point 1 to point n, in which case the number of paths is 0.

Sample Input
4
1 2
1 4
2 3
2 4
3 4
0 0

Sample Output
3

*/