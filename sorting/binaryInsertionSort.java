package sorting;

import java.util.ArrayList;
import java.util.Scanner;

public class binaryInsertionSort {
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        ArrayList<Integer> li = new ArrayList<Integer>();
        int n = s.nextInt();

        li.add(Integer.MIN_VALUE);
        li.add(Integer.MAX_VALUE);

        for (int i = 1; i <= n; i++) {
            int num = s.nextInt();
            int index = li.size() - 1;
            int jump = li.size() - 1;
            while (true) {
                jump = (jump + 1) / 2;
                if (num > li.get(index)) {
                    index += jump;
                } else if (num <= li.get(index - 1)) {
                    index -= jump;
                } else {
                    li.add(index, num);
                    break;
                }
            }
        }

        li.remove(0);
        li.remove(li.size() - 1);
        for (Integer i : li) {
            System.out.println(i);
        }
    }
}