package BinarySearchTree;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {
    public static void insert(Node root, int data) {
        if (root == null)
            root = new Node(data);

        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node current = queue.remove();

            if (current.left == null) {
                current.left = new Node(data);
                break;
            } else {
                queue.add(current.left);
            }

            if (current.right == null) {
                current.right = new Node(data);
                break;
            } else {
                queue.add(current.right);
            }
        }
    }

    // mirror tree
    public static Boolean isSymmetricTree(Node root) {
        return isMirror(root, root);
    }

    public static boolean isMirror(Node left, Node right) {
        if (left == null && right == null)
            return true;

        if (left != null && right != null && left.data == right.data) {
            return isMirror(left.left, right.right) && isMirror(left.right, right.left);
        }

        return false;
    }

    static int postOrderCount = 0;

    public static void NthPostorderNode(Node root, int n) {
        if (root == null)
            return;

        if (postOrderCount <= n) {
            NthPostorderNode(root.left, n);
            NthPostorderNode(root.right, n);
            postOrderCount += 1;

            if (n == postOrderCount) {
                System.out.println(root.data);
                return;
            }
        }
    }

    static int inorderCount = 0;
    public static void NthInorderNode(Node root, int n) {
        if (root == null)
            return;

        if (inorderCount <= n) {
            NthInorderNode(root.left, n);
            inorderCount += 1;

            if (inorderCount == n) {
                System.out.println(root.data);
            }

            NthInorderNode(root.right, n);
        }
    }

    static int preorderCount = 0;
    public static void NthPreorderNode(Node root, int n) {
        if (root == null)
            return;

        if (preorderCount <= n) {
            preorderCount += 1;

            if (preorderCount == n) {
                System.out.println(root.data);
            }

            NthPreorderNode(root.left, n);
            NthPreorderNode(root.right, n);
        }
    }
}
