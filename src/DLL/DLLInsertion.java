package DLL;

public class DLLInsertion {

    Node head;

    public void insertAtFirst(Node node){
        head.setLeft(node);
        node.setLeft(null);
        node.setRight(head);
        head = node;
    }
}
