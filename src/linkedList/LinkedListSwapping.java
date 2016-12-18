package linkedList;

public class LinkedListSwapping {
Node head;
	
	//Inserting at the beginning of the List
	public void add(int d){
		Node new_node=new Node(d);
		new_node.next=head;
		head=new_node;
	}
	
	//Swapping the data with nodes
	public void swap(int d,int k){
		
		if(d==k){
			return;
		}
		
		Node tempX=head;
		Node prevX=null;
				
		while(tempX!=null && tempX.data!=d){
			prevX=tempX;
			tempX=tempX.next;			
		}
		
		Node tempY=head;
		Node prevY=null;
		
		while(tempY!=null && tempY.data!=k){
			prevY=tempY;
			tempY=tempY.next;
		}
		
		if(tempX==null && tempY==null){
			return;
		}
		
		if(prevX!=null){
			prevX.next=tempY.next;
		}
		else{
			head=tempY.next;
		}
		
		if(prevY!=null){
			prevY.next=tempX.next;
		}
		else{
			head=tempX.next;
		}
		Node temp=tempX.next;
		prevX.next=tempY.next;
		prevY.next=temp;
		
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

	}

}
