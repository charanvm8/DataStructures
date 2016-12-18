package linkedList;

public class LinkedListLength {
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
	
	//Deleting the value of the key
	public void deleteKey(int key){
		
		Node temp=head;
		Node prev=null;
		
		//if head has the key
		if(temp!=null && temp.data==key){
			head=temp.next;
			return;
		}
		
		while(temp!=null && temp.data!=key){
			prev=temp;
			temp=temp.next;
		}
		
		if(temp==null){
			return;
		}
		
		prev.next=temp.next;
		
	}
	
	//Deleting a node at a given position
	public void deleteAt(int i){
		Node temp=head;
		Node prev=null;
		int count=0;
		if(i==0){
			head=temp.next;
			return;
		}
		
		while(count!=i){
			count++;
			prev=temp;
			temp=temp.next;
		}
		if(temp==null){
			return;
		}
		
		prev.next=temp.next;
		
	}
		
	//Printing the length of the linked list
	public int size(){
		Node temp=head;
		int count=0;
		
		if(head==null){
			return 0;
		}
		
		while(temp!=null){
			count++;
			temp=temp.next;
		}
		
		return count;
	}
	
	//Printing the length of the linked list in recursive way
	public int recSize(Node n){
		if(n==null){
			return 0;
		}
		
		return 1+recSize(n.next);
		
	}
	public int getCount()
	    {
	        return recSize(head);
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
		// TODO Auto-generated method stub
		LinkedListLength llist=new LinkedListLength();
		llist.append(10);
		llist.add(20);
		llist.insertAfter(llist.head,30);
		llist.add(50);
		System.out.println(llist.size());
		System.out.println(llist.getCount());
		llist.print();
	}

}
