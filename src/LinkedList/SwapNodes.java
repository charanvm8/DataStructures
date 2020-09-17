package LinkedList;

public class SwapNodes {

    Node head;

    public Node swapNodesByTwoPlaces(Node head){
       if(head==null || head.next==null){
           return head;
       }
       Node first = head;
       Node second = head.next;
       while(first!=null && second!=null ){
           int temp = first.x;
           first.x = second.x;
           second.x = temp;
           first = second.next;
           if(first!=null && first.next!=null){
               second = first.next;
           }
           else{
               second = null;
           }
       }
       return head;
    }

    public Node swapNodesByTwoPlaces1(Node head){
        if(head==null || head.next==null){
            return head;
        }
        Node first  = head;
        Node second  = head.next;
        Node prev = second;
        Node res = second;

        while(first!=null && second!=null){
            first.next = second.next;
            second.next = first;
            prev.next = second;
            prev = first;
            first = first.next;
            if(first!=null && first.next!=null){
                second = first.next;
            }
            else{
                second= null;
            }
        }
        return res;
    }

    public void pringLL(Node head){
        Node temp = head;
        while (temp!=null){
            System.out.print(temp.x+" ");
            temp = temp.next;
        }
        System.out.println();
    }
    public static void main(String[] args){

        Node head = new Node(1);
        Node one = new Node(2);
        Node two = new Node(3);
        Node three = new Node(4);
        Node five = new Node(5);
        Node six = new Node(6);

        SwapNodes ll = new SwapNodes();
        ll.head = head;
        head.next = one;
        one.next = two;
        two.next = three;
        three.next = five;
        five.next = six;
        Node temp = ll.swapNodesByTwoPlaces(ll.head);
        ll.pringLL(temp);
    }
}
