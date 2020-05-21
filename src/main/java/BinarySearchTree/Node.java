package BinarySearchTree;

public class Node {
    int data;
    Node left, right;
    int width;
    Node parent; // Lowest Common Ancestor in a Binary Tree Using Parent Pointer (int n1, int n2) => no root.

    public Node() {

    }

    public Node(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
        this.parent = null;
        this.width = 0;
    }
}
