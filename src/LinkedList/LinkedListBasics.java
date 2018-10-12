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
        LinkedListBasics bb2 = new LinkedListBasics();
        MergeTwoSortedList mg = new MergeTwoSortedList();
        bb.head = new Node(1);
        bb.head.next = new Node (2);
        bb.head.next.next = new Node(4);
        bb2.head = new Node(1);
        bb2.head.next = new Node (3);
        bb2.head.next.next = new Node(4);
        bb.printList(mg.mergeTwoList(bb.head,bb2.head));
    }
}
