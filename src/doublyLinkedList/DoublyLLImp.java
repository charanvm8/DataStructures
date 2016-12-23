package doublyLinkedList;

public class DoublyLLImp {
	Node head;
	
	void insert(int d){
		Node node=new Node(d);
		if(head==null){
			head=node;
		}
		else{
			node.prev=head.prev;
			node.next=head;
			head.prev=node;
			head=node;
		}
	}

	public static void main(String[] args) {
		// doubly linked list implementation
		
		

	}

}
