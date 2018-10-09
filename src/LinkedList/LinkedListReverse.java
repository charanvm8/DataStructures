package LinkedList;

public class LinkedListReverse {
    Node head;

    public Node reverse(Node n){
        Node lastNode = null;
        Node tempHead = head;
        Node next = null;
        while (tempHead != null) {
            next = tempHead.next;
            tempHead.next = lastNode;
            lastNode = tempHead;
            tempHead = next;
        }
        n = tempHead;
        return n;
    }

    public static void main(String[] args){
    }
}
