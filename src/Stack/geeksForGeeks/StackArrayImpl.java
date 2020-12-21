package Stack.geeksForGeeks;

public class StackArrayImpl {

    int[] arr;
    int capacity;
    int size = -1;

    public StackArrayImpl(int capacity){
        this.capacity = capacity;
        arr = new int[capacity];
    }

    public void push(int i){
        if(size == capacity){
            return;
        }
        arr[++size] = i;
    }

    public int peek(){
        if(this.size==-1){
            return -1;
        }
        return arr[size];
    }

    public int pop(){
        if(this.size==-1){
            return -1;
        }
        int res = arr[size];
        arr[size--] = 0;
        return res;
    }

    public int size(){
        return this.size+1;
    }

    public boolean isEmpty(){
        return size==-1;
    }


    public static void main(String[] args) {

        StackArrayImpl stack = new StackArrayImpl(5);
        stack.push(5);
        stack.push(15);
        stack.push(25);
        System.out.println(stack.peek());
        System.out.println(stack.pop());
        stack.push(35);
        System.out.println(stack.size());
        System.out.println(stack.isEmpty());

    }
}
