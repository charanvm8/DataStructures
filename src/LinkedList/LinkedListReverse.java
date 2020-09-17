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

    public Node reverseRecursively(Node head){
        if(head == null || head.next==null){
            return head;
        }
        Node recursive_result = reverseRecursively(head.next);
        Node tail_element = head.next;
        tail_element.next = head;
        head.next = null;
        return recursive_result;
    }

    public Node reverseRecursively2(Node head,Node start){
        if(head == null){
            return start;
        }
        Node temp = head.next;
        head.next = start;
        return reverseRecursively2(temp,head);
    }

//    public Node reverseListByK(Node head){
//
//    }



    public static void main(String[] args){
    }
}
