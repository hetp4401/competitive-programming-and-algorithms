package dataStructures;

import java.util.Scanner;

public class segmentTree {
    
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int n = s.nextInt();
        int m = s.nextInt();
        s.nextLine();

        int[] nums = new int[n];
        for (int i = 0; i < n; i++)
            nums[i] = s.nextInt();
        SegmentTree st = new SegmentTree(nums);

        for (int i = 0; i < m; i++) {
            String action = s.next();
            int j = s.nextInt();
            int k = s.nextInt();

            if (action.equals("Q")) {
                System.out.println(st.query(j, k));
            } else {
                st.update(j, k);
            }
        }
    }
}

class SegmentTree {
    int[] data;
    int[] nodes;
    int[] indexes;
    int i = 0;

    SegmentTree(int[] arr) {
        data = arr;
        indexes = new int[data.length];
        nodes = new int[(int) (2 * (Math.pow(2, (-1 * Math.floor(-1 * Math.log(arr.length) / Math.log(2))))) - 1)];
        buildTree(0, 0, data.length - 1);
    }

    int buildTree(int index, int left, int right) {
        if (left == right) {
            nodes[index] = data[left];
            indexes[i] = index;
            i++;
            return nodes[index];
        } else {
            int middle = (right - left) / 2;
            nodes[index] = Math.min(buildTree(index * 2 + 1, left, left + middle),
                    buildTree(index * 2 + 2, left + middle + 1, right));
            return nodes[index];
        }
    }

    int query(int l, int r) {
        return sum(0, l, r, 0, data.length - 1);
    }

    int sum(int index, int l, int r, int left, int right) {
        if (l <= left && right <= r) {
            return nodes[index];
        } else if (left <= l && l <= right || left <= r && r <= right) {
            int middle = (right - left) / 2;
            return Math.min(sum(index * 2 + 1, l, r, left, left + middle),
                    sum(index * 2 + 2, l, r, left + middle + 1, right));
        } else {
            return Integer.MAX_VALUE;
        }
    }

    void update(int index, int val) {
        index = indexes[index];
        nodes[index] = val;
        if (index % 2 == 0) {
            index -= 2;
            index /= 2;
        } else {
            index -= 1;
            index /= 2;
        }

        modify(index);
    }

    void modify(int index) {
        if (index >= 0) {
            nodes[index] = Math.min(nodes[index * 2 + 1], nodes[index * 2 + 2]);

            if (index % 2 == 0) {
                index -= 2;
                index /= 2;
            } else {
                index -= 1;
                index /= 2;
            }
            modify(index);
        }
    }
}



/* 
Perform the dynamic range minimum query.
Input
The first line of input will contain two space-separated integers: N (1 ≤ N ≤ 100 000), the number of elements in the array, and M (1 ≤ M ≤ 100 000), the number of operations to perform.

The next N lines each contain one non-negative integer less than 1 000 000. Specifically, line number i contains element i - 2 of the array. Note that the array has zero-based indexing.

The following M lines contain one operation each. Each operation is either of the form M i x, indicating that element number i (0 ≤ i < N) is to be changed to x (0 ≤ x < 1 000 000), or the form Q i j (0 ≤ i ≤ j < N) indicating that your program is to find the minimum value of the elements in the index range [i, j] (that is, inclusive) in the current state of the array and print this value to standard output.

Output
One integer, on its own line, for each Q statement: the answer to the query.

Sample Input
5 10
35232
390942
649675
224475
18709
Q 1 3
M 4 475689
Q 2 3
Q 1 3
Q 1 2
Q 3 3
Q 2 3
M 2 645514
M 2 680746
Q 0 4

Sample Output
224475
224475
224475
390942
224475
224475
35232

*/