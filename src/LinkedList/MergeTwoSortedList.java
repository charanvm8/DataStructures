package LinkedList;

public class MergeTwoSortedList {

    Node head;

    public Node mergeTwoList(Node l1,Node l2){
        if(l1 == null && l2 == null){
            return null;
        }
        Node temp = new Node(0);
        Node n = temp;
        while (l1!= null && l2!=null){
            int leftVal = 0;
            int rightVal = 0;
            Node tempright = new Node(0);
            if(l1 !=null ){
                leftVal = l1.x;
            }
            if(l2 !=null){
                rightVal = l2.x;
            }
            if(leftVal > rightVal){
                n.next = new Node(leftVal);
                n = n.next;
                l1 = l1.next;
            }else{
                n.next = new Node(rightVal);
                n = n.next;
                l2 = l2.next;
            }

        }
        return temp.next;


    }

    public static void main(String[] args){


    }
}
