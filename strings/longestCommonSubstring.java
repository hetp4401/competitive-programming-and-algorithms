package dynammicProgramming;

import java.util.Scanner;

public class longestCommonSubstring {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        String s1 = in.nextLine();
        String s2 = in.nextLine();

        int[][] dp = new int[s1.length()][s2.length()];

        for (int i = 0; i < s1.length(); i++) if (s1.charAt(i) == s2.charAt(0)) dp[i][0] = 1;
        for (int j = 0; j < s2.length(); j++) if (s2.charAt(j) == s1.charAt(0))dp[0][j] = 1;
        
        String l = "";
        for (int i = 1; i < s1.length(); i++) {
            for (int j = 1; j < s2.length(); j++) {
                if (s1.charAt(i) == s2.charAt(j)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    if(dp[i][j] > l.length()){
                        l = s1.substring(i-dp[i][j]+1, i+1);
                    }
                }
            }
        }
        System.out.println(l);
    }
}



/* 
Sample Input
runapplebottomsdfsdfergnegjergre
jkenrgkjnerkjngkrenbottomjrenjeg

Sample Output
bottom
*/