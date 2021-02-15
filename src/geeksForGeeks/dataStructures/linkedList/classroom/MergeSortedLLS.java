package geeksForGeeks.dataStructures.linkedList.classroom;

public class MergeSortedLLS {

    public static Node mergeSortedLLs(Node left,Node right){
        Node head,tail;
        if(left.data<=right.data){
            head = tail = left;
            left = left.next;
        }
        else{
            head = tail = right;
            right = right.next;
        }
        while (left!=null && right!=null){
            if(left.data<=right.data){
                tail.next = left;
                left = left.next;
                tail = tail.next;
            }
            else{
                tail.next = right;
                right =right.next;
                tail = tail.next;
            }
        }
        if(left!=null){
            tail.next = left;
        }
        if(right!=null){
            tail.next = right;
        }
        return head;
    }

    public static void main(String[] args) {
        LinkedListImpl ll1 = new LinkedListImpl(10);
        ll1.head.next = new Node(20);
        ll1.head.next.next = new Node(30);

        LinkedListImpl ll2 = new LinkedListImpl(5);
        ll2.head.next = new Node(25);

        Node head = mergeSortedLLs(ll1.head,ll2.head);
        while (head!=null){
            System.out.print(head.data+" ");
            head = head.next;
        }
    }
}
