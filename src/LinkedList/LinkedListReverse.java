package LinkedList;

import LinkedListLeetCode.ListNode;

public class LinkedListReverse {
    Node head;

    public Node reverse(Node n){
        Node lastNode = null;
        Node tempHead = head;
        while (tempHead != null) {
            Node next = tempHead.next;
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
