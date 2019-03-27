package Stack.implementation;

public class ArrayImplementation {
    protected int capacity;

    private final static int CAPACITY=10;

    protected int[] arr;

    private int top = -1;

    public ArrayImplementation(){
        this.capacity = CAPACITY;
        arr = new int[CAPACITY];
    }

    public int size(){
        return top+1;
    }

    public boolean isEmpty(){
        return top<0;
    }

    public ArrayImplementation(int capacity){
        this.capacity = capacity;
        arr = new int[capacity];
    }

    public void push(int data) throws Exception{
        if(size() == capacity){
            throw new Exception("Stack is full");
        }
        arr[++top] = top;
    }

    public int getTop() throws Exception{
        if(isEmpty()){
            throw new Exception("Stack is empty");
        }
        return arr[top];
    }

    public int pop() throws Exception{
        if(isEmpty()){
            throw new Exception("Stack is empty");
        }
        int data = arr[top];
        arr[top--] = Integer.MIN_VALUE;
        return data;
    }


}
