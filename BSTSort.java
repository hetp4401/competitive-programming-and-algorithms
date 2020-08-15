package sorting;

import java.util.Scanner;

public class bstSort {
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        TreeNode root = new TreeNode(s.nextInt());
        for (int i = 1; i < n; i++)
            add(root, s.nextInt());
        print(root);
    }

    public static void print(TreeNode node) {
        if (node != null) {
            print(node.left);
            System.out.println(node.val);
            print(node.right);
        }
    }

    public static void add(TreeNode node, int i) {
        if (i >= node.val) {
            if (node.right == null) {
                node.right = new TreeNode(i);
            } else {
                add(node.right, i);
            }

        } else {
            if (node.left == null) {
                node.left = new TreeNode(i);
            } else {
                add(node.left, i);
            }
        }
    }
}

class TreeNode {
    TreeNode left;
    TreeNode right;
    int val;

    TreeNode(int val) {
        this.val = val;
    }
}
