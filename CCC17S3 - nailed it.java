package dataStructures;

import java.util.Scanner;
import java.util.HashMap;

public class ccc17j5s3 {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        int[] boardA = new int[2001];
        HashMap<Integer, Integer> heights = new HashMap<Integer, Integer>();

        int t = s.nextInt();
        s.nextLine();

        for (int i = 0; i < t; i++) {
            int a = Integer.parseInt(s.next());
            heights.put(a, 1);
            boardA[a] += 1;
        }

        int[] keys = new int[heights.keySet().size()];
        int index = 0;
        for (int i : heights.keySet()) {
            keys[index] = i;
            index += 1;
        }
        heights.clear();

        for (int i = 0; i < keys.length; i++) {
            for (int f = i; f < keys.length; f++) {
                int sum = keys[i] + keys[f];

                int amount1 = boardA[keys[i]];
                int amount2 = boardA[keys[f]];

                int possible = 0;
                if (keys[i] != keys[f]) {
                    if (amount1 > amount2) {
                        possible = amount2;
                    } else if (amount1 < amount2) {
                        possible = amount1;
                    } else {
                        possible = amount1;
                    }
                } else {
                    possible = amount1 / 2;
                }

                if (heights.containsKey(sum)) {
                    int current = heights.get(sum);
                    current += possible;
                    heights.put(sum, current);
                } else {
                    heights.put(sum, possible);
                }
            }
        }

        int width = 0;
        for (int i : heights.keySet()) {
            if (heights.get(i) > width) {
                width = heights.get(i);
            }
        }

        int ways = 0;
        for (int i : heights.keySet()) {
            if (heights.get(i) == width) {
                ways += 1;
            }
        }

        System.out.println(width + " " + ways);

    }
}


/* 

Tudor is a contestant in the Canadian Carpentry Challenge (CCC). To win the CCC, Tudor must demonstrate his skill at nailing wood together to make the longest fence possible using boards. To accomplish this goal, he has N pieces of wood. The ith piece of wood has integer length Li.

A board is made of exactly two pieces of wood. The length of a board made with lengths Li and Lj is Li + Lj. A fence consists of boards that are the same length. The length of the fence is the number of boards used to make it, and the height of the fence is the length of each board in the fence. In the example fence below, the length of the fence is 4; the height of the fence is 50; and, the length of each piece of wood is shown:

Tudor would like to make the longest fence possible. Please help him determine the maximum length of any fence he could make, and the number of different heights a fence of that maximum length could have.

Input Format
The first line will contain the integer N (2 ≤ N ≤ 1 000 000).
The second line will contain N space-separated integers L1, L2, …, LN (1 ≤ Li ≤ 2000).

Output Format
Output two integers on a single line separated by a single space: the length of the longest fence and the number of different heights a longest fence could have.

Sample Input 1
4
1 2 3 4

Sample Output 1
2 1

Explanation 1
Tudor first combines the pieces of wood with lengths 1 and 4 to form a board of length 5. Then he combines the pieces of wood with lengths 2 and 3 to form another board of length 5. Finally, he combines the boards to make a fence with length 2 and height 5.

Sample Input 2
5
1 10 100 10000 2000

Sample Output 2
1 10

Explanation 2
Tudor can’t make a fence longer than length 1, and there are 10 ways to make a fence with length 1 by choosing any two pieces of wood to nail together. Specifically, he may have a fence of height 11, 101, 1001, 2001, 110, 1010, 2010, 1100, 2100 and 3000.

*/