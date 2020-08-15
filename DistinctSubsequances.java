package dynammicProgramming;

import java.util.Scanner;

public class distinctsubsequances {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        String s = in.nextLine();

        int[] chars = new int[26];
        long[] sums = new long[s.length() + 1];

        long total = 0;
        for (int i = 0; i < s.length(); i++) {

            if (chars[(int) s.charAt(i) - 97] == 0)
                total += sums[i] + 1;
            else
                total += sums[i] - sums[chars[(int) s.charAt(i) - 97] - 1];

            total %= 10007;
            sums[i + 1] = total;
            chars[(int) s.charAt(i) - 97] = i + 1;
        }

        System.out.println(total % 10007);
    }
}


/*
Given a string, count all distinct subsequences (not substrings).
As defined previously, a subsequence is a collection of characters from the string (they don't have to be contiguous)

For example, for the string aba, there are 6 distinct subsequences: (a, b, aa, ab, ba, aba).

Input
The string, on one line. It will consist only of lowercase letters.
It will be no longer than 100,000 characters long (this is easier than all substrings!)

Output
The number of distinct subsequences.

Note that this number may be ridiculously large, so print it mod 10,007.

*/
