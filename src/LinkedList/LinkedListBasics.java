package LinkedList;

public class LinkedListBasics {
    Node head;

    public void printList(Node head){
        while(head != null){
            System.out.println(head.x);
            head = head.next;
        }
    }

    public static void main(String[] args){
        LinkedListBasics bb = new LinkedListBasics();
        bb.head = new Node(1);
        bb.head.next = new Node (2);
        bb.head.next.next = new Node(3);
        bb.printList(bb.head);
    }
}
