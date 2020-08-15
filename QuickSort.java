package sorting;

import java.util.Scanner;

public class quickSort {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int n = s.nextInt();

        int[] nums = new int[n];
        for (int i = 0; i < n; i++)
            nums[i] = s.nextInt();

        quicksort(nums, 0, nums.length - 1);

        for (int i : nums)
            System.out.println(i);
    }

    public static void quicksort(int[] n, int left, int right) {
        if (left < right) {
            int mid = partition(n, left, right);
            quicksort(n, left, mid - 1);
            quicksort(n, mid + 1, right);
        }
    }

    public static int partition(int[] n, int left, int right) {

        int l = left, r = right - 1;
        while (l <= r) {
            if (n[r] > n[right])
                r -= 1;
            else if (n[l] <= n[right])
                l += 1;
            else {
                int temp = n[r];
                n[r] = n[l];
                n[l] = temp;
            }
        }
        int temp = n[right];
        n[right] = n[l];
        n[l] = temp;
        return l;
    }
}
