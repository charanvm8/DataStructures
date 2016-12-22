package linkedList;

public class LinkedListReverse {
	
	Node head;
	
	Node reverse(Node node){
		Node prev=null;
		Node current=node;
		Node next=null;
		
		while(current!=null){
			next=current.next;
			current.next=prev;
			prev=current;
			current=next;
			
		}
		node=prev;
		return node;		
		
	}
	 void printList(Node node) {
	        while (node != null) {
	            System.out.print(node.data + " ");
	            node = node.next;
	        }
	    }

	public static void main(String[] args) {
		// Reversing a Linked List
		LinkedListReverse linked=new LinkedListReverse();
		linked.head=new Node(10);
		linked.head.next=new Node(20);
		linked.head.next.next=new Node(30);
		
		Node n=linked.reverse(linked.head);
		linked.printList(n);
		

	}

}
