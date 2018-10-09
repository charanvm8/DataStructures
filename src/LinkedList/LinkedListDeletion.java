package LinkedList;

public class LinkedListDeletion {
    Node head;


    // complexity O(n)
    public void deleteNode(int value){
        Node temp = head;
        Node prev = null;
        if(temp !=null && temp.x == value){
            head = temp.next;
            return;
        }
        while(temp != null && temp.x != value){
            prev = temp;
            temp = temp.next;
        }
        if(temp == null) return;
        prev.next = temp.next;

    }

    public void deleteNodeAt(int pos){
        if(head == null) return;
        Node temp = head;
        if(pos == 0) head=temp.next;
        while (pos==0){
            temp = temp.next;
        }
        if(temp == null || temp.next ==null) return;
        Node next = temp.next.next;
        temp.next = next;
    }

    public static void main(String[] args){
    }
}
