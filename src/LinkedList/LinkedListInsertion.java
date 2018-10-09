package LinkedList;

public class LinkedListInsertion {

    Node head;


    // complexity O(1)
    public void printList(Node head){
        while(head != null){
            System.out.println(head.x);
            head = head.next;
        }
    }

    public void insertAtHead(int x){
        Node newNode = new Node(x);
        newNode.next = head;
        head = newNode;
    }

    public void insertAfter(Node x,int after){
        if(x == null)
            return;

        Node newNode = new Node(after);
        newNode.next = x.next;
        x.next = newNode;
    }

    public void insertLast(Node head,int val){
        Node newNode = new Node(val);
        if(head == null){
            head = newNode;
            return;
        }
        while (head !=null){
            if(head.next == null){
                head.next = newNode;
                return;
            }
            head = head.next;
        }
    }

    public static void main(String[] args){

        LinkedListInsertion listInsertion = new LinkedListInsertion();
        listInsertion.insertAtHead(10);
        listInsertion.insertAtHead(9);
        listInsertion.insertAtHead(4);
        listInsertion.insertAfter(listInsertion.head.next,13);
        listInsertion.insertLast(listInsertion.head,18);
        listInsertion.printList(listInsertion.head);


    }
}
