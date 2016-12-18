package linkedList;

public class LinkedListDeletion {
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
		
		//Printing the elements in the linkedList
		public void print(){
			Node temp=head;
			
			while(temp!=null){
				System.out.println(temp.data);
				temp=temp.next;
			}
		}
		

	public static void main(String[] args) {
		// Implementing delete
		
		LinkedListDeletion llist1=new LinkedListDeletion();
		llist1.append(10);
		llist1.add(20);
		llist1.insertAfter(llist1.head.next,30);
		llist1.deleteKey(10);
		llist1.print();
		System.out.println("Deleted key");
		llist1.deleteAt(1);
		llist1.print();
		
		

	}

}
