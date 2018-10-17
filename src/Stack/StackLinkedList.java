package Stack;

public class StackLinkedList<T> {
    Node head;

    private class Node {
        T i;
        Node next;
        Node(T x){
            this.i = x;
        }
    }

    public void push(T i){
        Node n = new Node(i);
        n.next = head;
        head = n;
    }

    public Node pop() {
        Node temp = head;
        head = head.next;
        return temp;
    }

    public void print(){
        Node temp = head;
        while(temp == null){
            System.out.println(temp.i);
            temp = temp.next;

        }
    }

    public static void main(String[] args){

        StackLinkedList stackList = new StackLinkedList<String>();
        stackList.push("Charan");
        stackList.push("Vardhan");
        stackList.push("Mareedu");
        stackList.pop();
        stackList.print();

    }
}
