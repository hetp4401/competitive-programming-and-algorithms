package strings;

import java.util.HashMap;
import java.util.Scanner;

public class patternMatching {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        String pattern = s.nextLine();
        String sequance = s.nextLine();

        HashMap<Character, String> map = new HashMap<Character, String>();
        System.out.println(dfs(0, 0, pattern, sequance, map, ""));
    }

    public static boolean dfs(int i, int j, String p, String s, HashMap<Character, String> m, String path) {
        if (i == p.length()) {
            if (j == s.length())
                System.out.println(path);

            return j == s.length();
        }

        char c = p.charAt(i);
        for (int k = j; k < s.length(); k++) {
            String seg = s.substring(j, k + 1);
            if (m.containsKey(c) && m.get(c).equals(seg)) {
                if (dfs(i + 1, k + 1, p, s, m, path + seg + " "))
                    return true;
            } else if (!m.containsKey(c) && !m.containsValue(seg)) {
                m.put(c, seg);
                if (dfs(i + 1, k + 1, p, s, m, path + seg + " "))
                    return true;
                m.remove(c);
            }
        }
        return false;
    }
}


/* 
Given a pattern and a string to match, output true or false if the pattern can be matched to the string
such that there is a bijection between a letter in pattern and a non-empty substring in the string. If it
is possible output how the String should be broken up

Sample input 
abcba
dogcathorsecatdog

Sample output
dog cat horse cat dog
true
*/