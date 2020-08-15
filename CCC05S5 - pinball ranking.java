package dataStructures;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class ccc05s5 {
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();

        int n = s.nextInt();
        int[] scores = new int[n];

        for (int i = 0; i < n; i++) scores[i] = s.nextInt();

        int[] arr = scores.clone();
        Arrays.sort(arr);

        for (int i = 0; i < n; i++) hm.put(arr[i], i + 1);
        for (int i = 0; i < n; i++) scores[i] = hm.get(scores[i]);

        BIT bit = new BIT(n);
        double sum = 0;
        for (int i = 0; i < n; i++) {
            sum += 1 + bit.sum(n) - bit.sum(scores[i]);
            bit.add(scores[i], 1);
        }

        System.out.printf("%.2f", sum / n);
    }
}

class BIT {
    int[] nodes;

    BIT(int size) {
        nodes = new int[size + 1];
    }

    int sum(int i) {
        int sum = 0;
        while (i != 0) {
            sum += nodes[i];
            i -= i & (-i);
        }
        return sum;
    }

    void add(int i, int val) {
        while (i < nodes.length) {
            nodes[i] += val;
            i += i & (-i);
        }
    }
}


/*

Pinball is an arcade game in which an individual player controls a silver ball by means of flippers, with the objective of accumulating as many points as possible. At the end of each game, the player's score and rank are displayed. The score, an integer between 0 and 1 000 000 000, is that achieved by the player in the game just ended. The rank is displayed as "r of n". n is the total number of games ever played on the machine, and r is the position of the score for the just-ended game within this set.

More precisely, r is one greater than the number of games whose score exceeds that of the game just ended.

Input
You are to implement the pinball machine's ranking algorithm. The first line of input contains a positive integer, t, the total number of games played in the lifetime of the machine. t lines follow, given the scores of these games, in chronological order.

Output
You are to output the average of the ranks (rounded to two digits after the decimal) that would be displayed on the board.
At least one test case will have t ≤ 100. All test cases will have t ≤ 100 000.

Sample Input
5
100
200
150
170
50
Sample Output
2.20
Explanation
The pinball screen would display (in turn):

1 of 1
1 of 2
2 of 3
2 of 4
5 of 5
The average rank is (1+1+2+2+5)/5 = 2.20.

*/