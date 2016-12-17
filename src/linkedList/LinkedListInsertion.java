package linkedList;

public class LinkedListInsertion {
	Node head;
	
	//Inserting at the beginning of the List
	public void add(int d){
		Node new_node=new Node(d);
		new_node.next=head;
		head=new_node;
	}
	
	//Inserting at the particular position
	public void insertAfter(Node prev_node,int d){
		
		if(head==null){
			System.out.println("The list is empty. Cannot add the value at a particular position");
			return;
		}
		
		Node new_node=new Node(d);
		new_node.next=prev_node.next;
		prev_node.next=new_node;
		return;
		
	}
	
	//Inserting at the end of the list
	public void append(int d){
				
		if(head==null){
			head=new Node(d);
			return;
		}
		Node new_node=new Node(d);
		new_node.next=null;
		
		Node temp=head;
		
		while(temp.next!=null){
			temp=temp.next;
		}
		temp.next=new_node;
		return;
	}
	
	//Printing the elements in the linkedList
	public void print(){
		Node temp=head;
		
		while(temp!=null){
			System.out.println(temp.data);
			temp=temp.next;
		}
	}
	

	public static void main(String[] args) {
		// Implementing Linked List
		LinkedListInsertion llist=new LinkedListInsertion();
		llist.append(10);
		llist.add(20);
		llist.insertAfter(llist.head.next,30);
		llist.print();
		
		
		}

}
