package SingleLinkedList;

public class SingleLinkedList {
    private Node insertLast(Node head, int data) {
        Node node = new Node(data);

        Node start = head;

        while (start.next != null) {
            start = start.next;
        }

        start.next = node;

        return head;
    }

    private Node delete(Node head, int data) {
        return head;
    }

    public static void main(String[] a) {
        SingleLinkedList singleLinkedList = new SingleLinkedList();

        Node head = new Node(1);
        head = singleLinkedList.insertLast(head, 2);
    }
}
