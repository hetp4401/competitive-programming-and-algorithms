package dataStructures;

import java.util.ArrayList;

public class PriorityQueue {

    ArrayList<Integer> heap = new ArrayList<Integer>();

    PriorityQueue() {
    }

    boolean is_empty() {
        return heap.size() == 0;
    }

    void push(int n) {
        heap.add(n);
        int i = heap.size() - 1;
        while (i > 0) {
            int p = (i - 1) / 2;
            if (heap.get(p) <= n) {
                break;
            }
            heap.set(i, heap.get(p));
            heap.set(p, n);
            i = p;
        }
    }

    int pop() {
        if (heap.size() == 1) {
            return heap.remove(0);
        }

        int top = heap.get(0);
        heap.set(0, heap.remove(heap.size() - 1));

        int i = 0;
        while (true) {
            int c = i * 2 + 1;
            if (c >= heap.size()) {
                break;
            }
            if (c + 1 < heap.size() && heap.get(c + 1) < heap.get(c)) {
                c++;
            }
            if (heap.get(c) < heap.get(i)) {
                int temp = heap.get(i);
                heap.set(i, heap.get(c));
                heap.set(c, temp);
                i = c;
            } else {
                break;
            }
        }
        return top;
    }
}

