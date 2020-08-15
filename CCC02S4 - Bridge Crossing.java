package dynammicProgramming;

import java.util.Scanner;

public class bridgeCrossing {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        int m = Integer.parseInt(s.nextLine());
        int n = Integer.parseInt(s.nextLine());

        String[] peeps = new String[n];
        int[][] times = new int[m][n];
        int[] choices = new int[n];

        for (int i = 0; i < n; i++) {
            peeps[i] = s.nextLine();
            times[0][i] = Integer.parseInt(s.nextLine());
        }

        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n - i; j++) {
                times[i][j] = Math.max(times[i - 1][j], times[i - 1][j + 1]);
            }
        }

        int[] dp = new int[n]; dp[0] = times[0][0];
        for (int i = 1; i < m; i++) dp[i] = Math.max(dp[i - 1], times[0][i]);

        for (int i = m; i < n; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < m; j++) {
                int t = dp[i - j - 1] + times[j][i - j];
                if (t < min) {
                    min = t;
                    choices[i] = i - j;
                }
            }
            dp[i] = min;
        }

        String ans = "";
        int idx = n - 1;

        while (idx >= 0) {
            String temp = "";
            for (int i = idx; i >= choices[idx]; i--) temp = peeps[i] + " " + temp;
            ans = temp + "\n" + ans;
            idx = choices[idx] - 1;
        }

        System.out.println("Total Time: " + dp[n - 1]);
        System.out.println(ans);
    }
}


/*
A rope bridge traverses a deep gorge. People may cross the bridge in groups, but there is a limit (M) to the size of the group. The time taken for a group to cross is determined by the slowest member. You are responsible for safety on the bridge and part of your job is to control the groups crossing.

People are waiting in a queue (line); when the previous group has crossed, you tell the next few people they can now cross. Groups can be of different sizes; no group can contain more than M people, and the goal is to get everyone over in the shortest time, all the time maintaining the order of the people in the queue.

Input
The first line of the input contains an integer M (1 ≤ M ≤ 20). The second line contains Q (1 ≤ Q ≤ 100), the length of the queue waiting to cross.

For each person in the queue, a pair of input lines follows. The first of these is the name of the person, and the second is that person's individual time to cross the bridge. Recall that a group's crossing time will be the maximum crossing time for any individual in the group.

Output
The first line of the output is to give the total crossing time for the entire queue of people. Then, output the names of the people in each group, one group per line, which will obtain the minimum overall crossing time. If several groupings yield the same overall crossing time, any such grouping may be listed.

Sample Input
2
5
alice
1
bob
5
charlie
5
dobson
3
eric
3

Sample Output
Total Time: 9
alice
bob charlie
dobson eric

*/