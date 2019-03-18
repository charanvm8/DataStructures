package LL;

public class LLInsertion {

    LinkedList head;

    // Insert at the beginning
    public void insertAtFirst(LinkedList node){
        node.setNext(head);
        head = node;
    }

    public void insertAtEnd(LinkedList node){
        if(head == null){
            head = node;
        }
        else{
            LinkedList temp = head;
            while(temp.getNext()!=null){
                temp = temp.getNext();
            }
            temp.setNext(node);
        }
    }

    public void insertAtPoint(LinkedList node, int position){

        if(head == null){
            head = node;
        }

        else if(position == 0 ){
            node.setNext(head);
            head = node;
        }
        else {
            LinkedList temp = head;

            for(int i=0;i<position;i++){
                temp = temp.getNext();
            }

            LinkedList pres = temp.getNext();
            temp.setNext(node);
            node.setNext(pres);
        }


//        if(position < 0){
//            return;
//        }
//
//        if(head == null && position == 0){
//            head = node;
//            return;
//        }
//
//        LinkedList prev = head;
//        LinkedList pres = head;
//
//        for(int i=0;i<position;i++){
//            if(pres.getNext() == null){
//                break;
//            }
//            prev = pres;
//            pres = pres.getNext();
//        }
//
//        prev.setNext(node);
//        node.setNext(pres);

    }


}
