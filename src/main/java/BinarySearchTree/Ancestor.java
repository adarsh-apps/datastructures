package BinarySearchTree;

import java.util.ArrayList;
import java.util.List;

public class Ancestor {
    public static List<Node> path1 = new ArrayList<Node>();
    public static List<Node> path2 = new ArrayList<Node>();

    static boolean v1 = false, v2 = false;

    public static boolean findPath(Node root, int n1, List<Node> path) {
        if (root == null)
            return false;

        path.add(root);

        if (root.data == n1)
            return true;

        if (findPath(root.left, n1, path)) {
            return true;
        }

        if (findPath(root.right, n1, path)) {
            return true;
        }

        path.remove(path.size()-1);
        return false;
    }

    public static Integer getAncestor(Node root, int n1, int n2) {
        int i;

        if (findPath(root, n1, path1) && findPath(root, n2, path2)) {
            for (i = 0; i < path1.size() && i < path2.size(); i += 1) {
                if (path1.get(i).data != path2.get(i).data)
                    break;
            }

            return path2.get(i - 1).data;
        }

        return null;
    }

    public static Node getAncestorInMinTime(Node root, int n1, int n2) {
        if (root == null)
            return null;

        Node temp = null;

        if (n1 == root.data) {
            v1 = true;
            temp = root;
        }

        if (n2 == root.data) {
            v2 = true;
            temp = root;
        }

        Node left = getAncestorInMinTime(root.left, n1, n2);
        Node right = getAncestorInMinTime(root.right, n1, n2);

        if (temp != null)
            return temp;

        if (left != null && right != null)
            return root;

        return left != null ? left : right;
    }

    public static Integer getAncestorInMinTime1(Node root, int n1, int n2) {
        Node ancestor = getAncestorInMinTime(root, n1, n2);

        if (v1 && v2)
            return ancestor.data;

        return null;
    }

    public static Integer getDistanceBetweenNodes(Node root, int n1, int n2) {
        if (root == null)
            return null;

        Node commonRoot = getAncestorInMinTime(root, n1, n2);

        if (commonRoot == null)
            return null;

        Integer distance1 = getDistance(commonRoot, n1, 0);
        Integer distance2 = getDistance(commonRoot, n2, 0);

        return distance1 + distance2;
    }

    public static Integer getDistance(Node root, int number, Integer level) {
        if (root == null)
            return -1;

        if (root.data == number)
            return level;

        int distance = getDistance(root.left, number, level + 1);

        if (distance == -1)
            return getDistance(root.right, number, level + 1);

        return distance;
    }

    public static boolean printallAncestorsOfGivenNode(Node root, int data) {
        if (root == null)
            return false;

        if (root.data == data)
            return true;

        if (printallAncestorsOfGivenNode(root.left, data) || printallAncestorsOfGivenNode(root.right, data)) {
            System.out.println(root.data);
            return true;
        }

        return false;
    }

    public static Node kthAncestorOfNode(Node root, int data, int k) {
        if (root == null)
            return null;

        if (root.data == data || (kthAncestorOfNode(root.left, data, k) != null || kthAncestorOfNode(root.right, data, k) != null)) {
            if (k == 0) {
                System.out.println(root.data);
                return null;
            } else{
                k -= 1;
            }

            return root;
        }

        return null;
    }
}
