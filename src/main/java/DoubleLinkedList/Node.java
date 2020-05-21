package DoubleLinkedList;

public class Node {
    int data;
    Node prev, next;

    public Node() {

    }

    public Node (int data) {
        this.data = data;
        this.prev = this.next = null;
    }
}
