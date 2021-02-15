package geeksForGeeks.dataStructures.linkedList.classroom;

public class LinkedListImpl {

    Node head;

    LinkedListImpl(int data){
        head = new Node(data);
    }

    public void printLL(){
        Node temp = this.head;
        while (temp!=null){
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
    }

}
