package Stack;

public class StackArrayImplementation {

    private static final int MAX = 1000;
    int top = -1;
    int[] array = new int[MAX];

    public void enQueue(int x){
        if(top >= MAX-1){
            throw new IllegalArgumentException("Array size reached");
        }else{
            array[++top] = x;
        }
    }

    public void deQueue(){
        if(top<0){
            throw new IllegalArgumentException("No elements present in the array");
        }else{
            array[top--] = 0;
        }
    }
}
