package sorting;

import java.util.Scanner;

public class heapSort {

    static int[] heap;

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        heap = new int[n];

        for (int i = 0; i < n; i++)
            heap[i] = s.nextInt();
        for (int i = heap.length - 1; i >= 0; i--)
            build(i, heap.length);

        sort();

        for (int i : heap)
            System.out.println(i);

    }

    public static void build(int i, int lim) {
        if (i < lim) {
            int index = i;
            if (i * 2 + 1 < lim && heap[i * 2 + 1] > heap[index])
                index = i * 2 + 1;
            if (i * 2 + 2 < lim && heap[i * 2 + 2] > heap[index])
                index = i * 2 + 2;
            if (index != i) {
                int n1 = heap[i];
                int n2 = heap[index];
                heap[i] = n2;
                heap[index] = n1;
                build(index, lim);
            }
        }
    }

    public static void sort() {

        for (int i = heap.length - 1; i >= 0; i--) {
            int n1 = heap[0];
            int n2 = heap[i];
            heap[i] = n1;
            heap[0] = n2;
            build(0, i);
        }
    }
}
