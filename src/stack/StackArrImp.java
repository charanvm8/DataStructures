package stack;

public class StackArrImp {
	int maxSize;
	int top=-1;
	int arr[];
	
	// Initializing array
	public StackArrImp(int x) {
		maxSize=x;
		arr=new int[x];
	}
	
	// Push into the array
	void push(int y){
		if(top!=(maxSize-1)){
			top+=1;
			arr[top]=y;
		}
		else{
			System.out.println("Stack is full");
		}
		
	}
	
	// Pop will remove the last element
	void pop(){
		if(top==-1){
			System.out.println("Stack is empty");
		}
		else{
			top-=1;
		}
	}
	
	// Checks whether the array is empty or not
	boolean isEmpty(){
		if(top==-1){
			return true;
		}
		else{
			return false;
		}
	}
	
	// Returns the top element in the array
	void top(){
		if(top==-1){
			System.out.println("Stack is empty");
		}
		else{
			System.out.println(arr[top]);
		}
	}
	
	// Returns all the elements in the array
	void print(){
		if(top==-1){
			System.out.println("Stack is empty");
		}
		else{
			for(int i=0;i<=top;i++){
				System.out.println(arr[i]);
			}
		}
	}
	public static void main(String[] args) {
		
		StackArrImp stack=new StackArrImp(5);
		stack.push(10);
		stack.print();

	}

}
