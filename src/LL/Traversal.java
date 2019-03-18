package LL;

public class Traversal {

    LinkedList node;

    public int getLLLength(LinkedList node){
        int count = 0;
        LinkedList head = node;
        while(head!=null){
            count+=1;
            head = head.getNext();
        }
        return count;
    }
}
