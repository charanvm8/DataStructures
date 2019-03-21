package DLL;

public class DLLInsertion {

    Node head;

//    public void insertAtFirst(Node node){
//        head.setLeft(node);
//        node.setLeft(null);
//        node.setRight(head);
//        head = node;
//    }

    public void insertAtFirst(int data){
        Node newNode = new Node(data);
        newNode.setRight(head);
        newNode.setLeft(null);
        if(head!=null){
            head.setLeft(newNode);
        }
        head = newNode;
    }

    public void insertAtLast(int data){
        Node newNode= new Node(data);
        newNode.setRight(null);
        if(head == null){
            newNode.setLeft(null);
            head = newNode;
            return;
        }
        Node temp = head;
        while (temp != null){
            temp = temp.getRight();
        }
        temp.setRight(newNode);
        newNode.setLeft(temp);
    }

    public void insertAtIndex(int data,int position){
        if(position == 0){
            insertAtFirst(data);
            return;
        }
        Node newData = new Node(data);

    }


}
