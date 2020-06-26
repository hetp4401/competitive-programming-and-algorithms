package strings;

import java.util.Arrays;
import java.util.Scanner;

public class suffixArray {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        s.nextLine();
        for (int i = 0; i < n; i++)
            substrings(s.nextLine());
    }

    public static void substrings(String substring) {
        String[] suffix = new String[substring.length()];
        for (int i = 0; i < substring.length(); i++)
            suffix[i] = substring.substring(i);

        Arrays.sort(suffix);

        int count = 0;
        for (int i = 0; i < suffix.length - 1; i++) {
            for (int j = 0; j < Math.min(suffix[i].length(), suffix[i + 1].length()); j++) {
                if (!(suffix[i].charAt(j) + "").equals(suffix[i + 1].charAt(j) + ""))
                    break;
                count++;
            }
        }
        System.out.println(substring.length() * (substring.length() + 1) / 2 - count + 1);
    }
}


/*
Problem S4: Substrings
How many distinct substrings does a given string S have?

For example, if S = "abc", S has 7 distinct substrings: "", "a", "b", "c", "ab", "bc", "abc". Note that the empty string and S itself are considered substrings of s.

On the other hand, if S = "aaa". S has only 4 distinct substrings: "", "a", "aa", "aaa".

Sample Input
2
abc
aaa
Sample Output
7
4
*/