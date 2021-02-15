package geeksForGeeks.dataStructures.linkedList.classroom;

public class PalindromeLL {

    public static boolean checkIfPalindrome(Node head){
        Node mid = getMid(head);
        reverseLinkedList(mid.next);
        Node first = head;
        Node second = mid.next;
        while (second!=null){
            if(first.data!=second.data){
                return false;
            }
            first = first.next;
            second = second.next;
        }
        return true;
    }

    public static Node getMid(Node head){
        Node slow = head;
        Node fast = head;
        while (fast.next!=null && fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static Node reverseLinkedList(Node head){
        Node temp = head;
        while (temp.next!=null){
            int data = temp.next.data;
            temp.next.data = temp.data;
            temp.data = data;
            temp = temp.next;
        }
        return head;
    }

    public static void main(String[] args) {
        LinkedListImpl ll = new LinkedListImpl(10);
        ll.head.next = new Node(20);
        ll.head.next.next = new Node(20);
        ll.head.next.next.next = new Node(10);
        ll.printLL();
        System.out.println(checkIfPalindrome(ll.head));
    }
}
