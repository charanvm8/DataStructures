package LinkedList;

public class LinkedListLength {

    Node head;

    public int iterate(Node head){
        Node temp = head;
        int len =0;
        while (temp!=null){
            len += 1;
        }
        return len;
    }

    public int lecLen(Node head){
        if (head == null){
            return 0;
        }
        return 1 + lecLen(head.next);
    }

    public static void main(String[] args){
    }
}
