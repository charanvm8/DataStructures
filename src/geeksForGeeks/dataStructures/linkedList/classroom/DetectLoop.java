package geeksForGeeks.dataStructures.linkedList.classroom;

public class DetectLoop {

    public static boolean loop(Node head){

        return false;
    }

    public static void main(String[] args) {
        LinkedListImpl ll1 = new LinkedListImpl(10);
        Node loop = new Node(15);
        ll1.head.next = loop;
        ll1.head.next.next = new Node(12);
        ll1.head.next.next.next = new Node(20);
        ll1.head.next.next.next.next = loop;
        System.out.println(loop(ll1.head));
    }
}
