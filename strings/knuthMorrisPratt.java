package strings;

import java.util.Scanner;

public class knuthMorrisPratt {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        String m = in.nextLine();
        String p = in.nextLine();

        System.out.println(kmp(m, p));
    }

    public static int kmp(String m, String p) {
        int[] lcp = new int[p.length()];

        int i = 0;
        int j = 1;
        while (j < p.length()) {
            if (p.charAt(i) == p.charAt(j)) {
                lcp[j] = i + 1;
                i++;
                j++;
            } 
            else if (i == 0) j++;
            else i = lcp[i - 1];
        }

        i = 0;
        j = 0;
        while (i < p.length() && j < m.length()) {
            if (p.charAt(i) == m.charAt(j)) {
                i++;
                j++;
            } 
            else if (i == 0) j++;
            else i = lcp[i - 1];
        }
        return j == m.length() ? -1 : j - p.length();
    }
}

/*

linear time String search algorithm

Input
m - String that is searched
p - pattern

Output
index of p in m else -1 if it is not found 

Sample Input
Computer Science
Sci

Sample Output
9

*/