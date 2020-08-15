package sorting;

import java.util.Scanner;

public class mergeSort {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        int n = s.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++)
            nums[i] = s.nextInt();

        nums = mergeSort(0, nums.length - 1, nums);
        for (int i : nums)
            System.out.println(i);
    }

    public static int[] mergeSort(int l, int r, int[] nums) {
        if (l != r) {
            return merge(mergeSort(l, l + (r - l) / 2, nums), mergeSort(l + ((r - l) / 2) + 1, r, nums));
        } else {
            int[] n = { nums[l] };
            return n;
        }
    }

    public static int[] merge(int[] a, int[] b) {
        int i = 0, j = 0;
        int[] m = new int[a.length + b.length];

        while (i < a.length && j < b.length) {
            if (a[i] <= b[j]) {
                m[i + j] = a[i];
                i++;
            } else {
                m[i + j] = b[j];
                j++;
            }
        }

        for (; i < a.length; i++)
            m[i + j] = a[i];
        for (; j < b.length; j++)
            m[i + j] = b[j];

        return m;
    }
}