package LinkedList;

import LL.LinkedList;

public class DetectLoopInLL {

    Node head;

    public Node detectLoop1(Node n){
        if(n==null || n.next==null){
            return null;
        }
        Node compare = n;
        Node temp = n.next;
        while (temp!=null){
            if(temp == compare){
                return compare;
            }
            Node track = n;
            while (track==compare){
                if(temp==track){
                    return track;
                }
                track = track.next;
            }
            compare = n.next;
            temp = temp.next;
        }
        return null;
    }

//    public Node detectLoop2(Node n){
//        Node temp = n;
//        while(temp!=null){
//            if(temp.visited){
//                return temp;
//            }
//            temp.visited = true;
//            temp = temp.next;
//        }
//        return null;
//    }

    public Node detectLoop3(Node n){
        Node temp = n;
        Node ref = null;
        while (temp!=null){
            if(temp.next==ref){
                return temp;
            }
            Node temp1 = temp.next;
            temp.next = ref;
            temp = temp1;
        }
        return null;
    }

    //Floyds Detection
    public Node detectLoop4(Node n){
        Node slow = n;
        Node fast = n;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow==fast){
                return fast;
            }
        }
        return null;
    }



    public static void main(String[] args) {
        Node head = new Node(10);
        Node one = new Node(15);
        Node two = new Node(12);
        Node three = new Node(20);

        DetectLoopInLL ll = new DetectLoopInLL();
        ll.head = head;
        head.next = one;
        one.next = two;
        two.next = three;
        three.next = one;
        System.out.println(ll.detectLoop3(ll.head).x);

    }
}
