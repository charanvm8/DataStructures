package LL;

public class LLDeletion {

    LinkedList head;

    public void deleteHead(){
        LinkedList newHead = head;

        head = newHead.getNext();

        newHead.setNext(null);

        LinkedList prev,pres = head;

    }
}
