package BinarySearchTree;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;
import java.util.TreeMap;

public class BinarySearchTree {
    //recursive insert
    public static Node insert(Node root, int data) {
        Node node = new Node(data);

        if (root == null) {
            root = node;
        } else if (data <= root.data) {
            root.left = insert(root.left, data);
        } else {
            root.right = insert(root.right, data);
        }

        return root;
    }

    //recursive pre order
    public static void preOrder(Node root) {
        Node node = root;

        if (node == null)
            return;

        System.out.print(node.data + " ");
        preOrder(node.left);
        preOrder(node.right);
    }

    //recursive in order
    public static void inOrder(Node root) {
        Node node = root;

        if (node == null)
            return;

        inOrder(node.left);
        System.out.print(node.data + " ");
        inOrder(node.right);
    }

    //recursive post order
    public static void postOrder(Node root) {
        Node node = root;

        if (node == null)
            return;

        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.data + " ");
    }

    public static void levelOrder(Node root) {
        Node start = root;

        Queue<Node> queue = new LinkedList<Node>();

        queue.add(start);

        while (!queue.isEmpty()) {
            start = queue.remove();
            System.out.print(start.data + " ");

            if (start.left != null)
                queue.add(start.left);

            if (start.right != null)
                queue.add(start.right);
        }
    }

    //iterative pre-order
    public static void iterativePreOrder(Node root) {
        Stack<Node> stack = new Stack<Node>();

        stack.add(root);

        while (!stack.empty()) {
            Node node = stack.pop();

            System.out.print(node.data + " ");

            if (node.right != null) {
                stack.add(node.right);
            }

            if (node.left != null) {
                stack.add(node.left);
            }
        }
    }

    //iterative in-order
    public static void iterativeInOrder(Node root) {
        Stack<Node> stack = new Stack<Node>();
        Node start = root;

        while (start != null || stack.size() > 0) {
            while (start != null) {
                stack.add(start);
                start = start.left;
            }

            start = stack.pop();
            System.out.print(start.data + " ");

            start = start.right;
        }
    }

    //iterative post-order
    public static void iterativePostOrder(Node root) {
        Stack<Node> stack1 = new Stack<Node>();
        Stack<Node> stack2 = new Stack<Node>();

        stack1.add(root);

        while (!stack1.empty()) {
            Node current = stack1.pop();

            stack2.push(current);

            if (current.left != null)
                stack1.add(current.left);

            if (current.right != null)
                stack1.add(current.right);
        }

        while (!stack2.empty()) {
            System.out.print(stack2.pop().data + " ");
        }
    }

    //top view of tree
    public static void topView(Node root, Map<Integer, Integer> topView) {
        if (root == null)
            return;
        Node start = root;
        Node left;
        Node right;

        if (topView.get(start.width) == null) {
            topView.put(start.width, start.data);
        }

        if (start.left != null) {
            left = start.left;
            left.width = start.width - 1;

            topView(left, topView);
        }

        if (start.right != null) {
            right = start.right;
            right.width = start.width + 1;
            topView(right, topView);
        }
    }

    //bottom view
    public static void bottomView(Node root, Map<Integer, Integer> bottomView, Boolean onlyLeaf) {
        if (root == null)
            return;
        Node start = root;
        Node left;
        Node right;

        if (onlyLeaf) {
            if (start.left == null && start.right == null) {
                bottomView.put(start.width, start.data);
            }
        } else {
            bottomView.put(start.width, start.data);
        }

        //Print all leaf nodes of a binary tree from right to left(first right then left)

        if (start.left != null) {
            left = start.left;
            left.width = start.width - 1;

            bottomView(left, bottomView, onlyLeaf);
        }

        if (start.right != null) {
            right = start.right;
            right.width = start.width + 1;
            bottomView(right, bottomView, onlyLeaf);
        }
    }

    //left view
    public static void leftView(Node root) {
        if (root == null)
            return;
        Node start = root;

        System.out.print(start.data + " ");

        if (start.left != null) {
            start = start.left;
            leftView(start);
        } else if (start.right != null) {
            start = start.right;
            leftView(start);
        }
    }

    //right view
    public static void rightView(Node root) {
        if (root == null)
            return;
        Node start = root;

        System.out.print(start.data + " ");

        if (start.right != null) {
            start = start.right;
            rightView(start);
        } else if (start.left != null) {
            start = start.left;
            rightView(start);
        }
    }

    //Border anti-clock wise.
    //left view
    public static void leftViewWithoutLeaf(Node root) {
        Node start = root;

        if (start == null || (start.left == null && start.right == null))
            return;

        System.out.print(start.data + " ");

        if (start.left != null) {
            start = start.left;
            leftViewWithoutLeaf(start);
        } else if (start.right != null) {
            start = start.right;
            leftViewWithoutLeaf(start);
        }
    }

    //bottom view
    public static void bottomView(Node root) {
        Map<Integer, Integer> bottomView = new TreeMap<Integer, Integer>();
        bottomView(root, bottomView, true);

        for (Integer width : bottomView.keySet()) {
            System.out.print(bottomView.get(width) + " ");
        }
    }

    //right view
    public static void rightViewWithoutLeaf(Node root) {
        Node start = root;

        if (start == null || (start.left == null && start.right == null))
            return;

        if (start.right != null) {
            start = start.right;
            rightViewWithoutLeaf(start);
        } else if (start.left != null) {
            start = start.left;
            rightViewWithoutLeaf(start);
        }

        if (!(start.left == null && start.right == null))
            System.out.print(start.data + " ");
    }

    public static void antiClockwiseBorder(Node root) {
        if (root== null)
            return;

        leftViewWithoutLeaf(root);
        bottomView(root);
        rightViewWithoutLeaf(root);
    }

    //HEIGHT OF TREE
    public static int getHeight(Node root) {
        Node start = root;

        if (start == null)
            return 0;
        else {
            int leftHeight = getHeight(start.left);
            int rightHeight = getHeight(start.right);

            return Math.max(leftHeight, rightHeight) + 1;
        }
    }

    //PRINT GIVEN LEVEL
    public static void printGivenLevel(Node root, int level) {
        if (root == null)
            return;

        if (level == 0)
            System.out.print(root.data + " ");

        printGivenLevel(root.left, level - 1);
        printGivenLevel(root.right, level - 1);
    }

    //CHECK GIVEN TREE IS BINARY SEARCH TREE OR NOT
    public static boolean isBST(Node root, Integer prev) {
        if (root == null)
            return true;

        if (!isBST(root.left, prev))
            return false;

        if (prev != null && prev > root.data)
            return false;

        prev = root.data;

        return isBST(root.right, prev);
    }

    public static Node delete(Node root, int value) {
        if (root == null)
            return null;

        if (value < root.data) {
            root.left = delete(root.left, value);
        } else if (value > root.data) {
            root.right = delete(root.right, value);
        } else {
            if (root.left == null || root.right == null) {
                Node temp = root.left == null ? root.right : root.left;

                return temp;
            } else {
                Node current = root.right;

                while (current.left != null) {
                    current = current.left;
                }

                root.data = current.data;
                root.right = delete(root.right, current.data);

                return root;
            }
        }

        return root;
    }

    public static void main(String[] args) {
//        int[] a = {1, 9, 10, 15, 2, 13, 5};
        int[] a = {50, 30, 20, 25, 40, 70, 60, 80, 75, 78};
        Node root = null;

        for (int i = 0; i < a.length; i += 1)
            root = insert(root, a[i]);

        System.out.print("pre-order ");
        preOrder(root);
        System.out.println();

        System.out.print("Nth node in preorder: ");
        BinaryTree.NthPreorderNode(root, 5);

//        System.out.print("iterative pre-order ");
//        iterativePreOrder(root);
//        System.out.println();
//
        System.out.print("in-order ");
        inOrder(root);
        System.out.println();

        System.out.print("Nth node in inorder: ");
        BinaryTree.NthInorderNode(root, 5);
//
//        System.out.print("iterative in-order ");
//        iterativeInOrder(root);
//        System.out.println();
//
        System.out.print("post-order ");
        postOrder(root);
        System.out.println();

        System.out.print("Nth node in post order: ");
        BinaryTree.NthPostorderNode(root, 5);
//
//        System.out.print("iterative post-order ");
//        iterativePostOrder(root);
//        System.out.println();
//
//        System.out.print("level order ");
//        levelOrder(root);
//        System.out.println();
//
//        System.out.print("top view of tree: ");
//        Map<Integer, Integer> topView = new TreeMap<Integer, Integer>();
//        topView(root, topView);
//
//        for (Integer width : topView.keySet()) {
//            System.out.print(topView.get(width) + " ");
//        }
//
//        System.out.println();
//
//        System.out.print("bottom view of tree: ");
//        Map<Integer, Integer> bottomView = new TreeMap<Integer, Integer>();
//        bottomView(root, bottomView, false);
//
//        for (Integer width : bottomView.keySet()) {
//            System.out.print(bottomView.get(width) + " ");
//        }
//
//        System.out.println();
//
//        System.out.print("left view of tree: ");
//        leftView(root);
//
//        System.out.println();
//
//        System.out.print("right view of tree: ");
//        rightView(root);
//
//        System.out.println();
//
//        System.out.print("border of tree: ");
//        antiClockwiseBorder(root);
//
//        System.out.println();
//
//        System.out.print("height of tree: " + getHeight(root));
//        System.out.println();
//
//        System.out.print("elements in given level: ");
//        printGivenLevel(root, 2);
//
//        System.out.println();

//        root.left.right.data = 1;
//        root = delete(root, 30);
//        System.out.print("in-order ");
//        inOrder(root);
//        System.out.println();
//        System.out.print("Given tree is BST: ");
//        System.out.println(isBST(root, null));
//
//        System.out.println("least common ancestor: " +Ancestor.getAncestor(root, 40, 70));
//
//        System.out.println("least common ancestor 2: " +Ancestor.getAncestorInMinTime1(root, 40, 70));
//        System.out.println();
//        System.out.println("distance from root: " + Ancestor.getDistance(root, 78, 0));
//        System.out.println("distance between nodes: " + Ancestor.getDistanceBetweenNodes(root, 20, 75));
    }
}