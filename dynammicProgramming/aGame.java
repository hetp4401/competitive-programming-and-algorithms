package dynammicProgramming;

import java.util.Scanner;

public class aGame {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int c = s.nextInt();
        int[][] p1 = new int[c][c];
        int[][] p2 = new int[c][c];

        for (int i = 0; i < c; i++) {
            int n = s.nextInt();
            p1[i][i] = n;
        }

        for (int j = 1; j < c; j++) {
            for (int i = 0; i < c - j; i++) {
                int coin1 = p1[i][i];
                int coin2 = p1[i + j][i + j];

                if ((coin1 + p2[i + 1][i + j]) > (coin2 + p2[i][i + j - 1])) {
                    p1[i][i + j] = coin1 + p2[i + 1][i + j];
                    p2[i][i + j] = p1[i + 1][i + j];
                } else {
                    p1[i][i + j] = coin2 + p2[i][i + j - 1];
                    p2[i][i + j] = p1[i][i + j - 1];
                }
            }
        }
        System.out.println(p1[0][c - 1]);
    }
}

/*
There are a bunch of coins on a table, laid out in a straight line.
Each coin has a (positive) value from 1 to 1000. Now, you're going to play a game with a friend.

At every turn, you must remove a coin from one end of the line.
Turns alternate, so your friend goes immediately after you're done.
The game ends when there are no coins remaining.

An example game:
The coins start like this:
4 4 9 4
You always go first, so you take the 4 from the left side:
4 9 4
Your friend takes any of the 4s (it doesn't matter)
9 4
Now you can take the 9, and your friend takes the remaining 4.

Your score, in this case, is 4+9 = 13.
(In this case you can always beat your friend.)
Find the maximum possible score you can achieve.

Sample Input
10
45
60
44
67
11
5
59
65
18
20

Sample Output
217
*/
